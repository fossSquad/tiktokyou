package com.windukk.hook;

import java.lang.reflect.InvocationTargetException;

final class CallbackDispatcher {
    private static final Object[] EMPTY_ARGS = new Object[0];

    private CallbackDispatcher() {
    }

    public static Object dispatch(HookBridge.HookInfo hookInfo, Object[] objArr) {
        HookMethod.HookMethodParam hookMethodParam = new HookMethod.HookMethodParam();
        hookMethodParam.method = hookInfo.getMethod();
        if (hookInfo.isStaticHook()) {
            hookMethodParam.thisObject = null;
            if (objArr == null) {
                objArr = HookBridge.EMPTY_ARRAY;
            }
            hookMethodParam.args = objArr;
        } else if (objArr == null || objArr.length == 0) {
            hookMethodParam.thisObject = null;
            hookMethodParam.args = HookBridge.EMPTY_ARRAY;
        } else {
            hookMethodParam.thisObject = objArr[0];
            int length = objArr.length - 1;
            if (length == 0) {
                hookMethodParam.args = EMPTY_ARGS;
            } else {
                Object[] objArr2 = new Object[length];
                hookMethodParam.args = objArr2;
                System.arraycopy(objArr, 1, objArr2, 0, length);
            }
        }
        Object[] snapshot = hookInfo.getCallbacks().getSnapshot();
        int length2 = snapshot.length;
        if (length2 == 0) {
            return invokeOriginal(hookInfo, hookMethodParam.thisObject, hookMethodParam.args);
        }
        int i = 0;
        do {
            try {
                ((HookMethod) snapshot[i]).beforeHookedMethod(hookMethodParam);
                if (hookMethodParam.returnEarly) {
                    i++;
                    break;
                }
                i++;
            } catch (Throwable th) {
                HookBridge.log(th);
                hookMethodParam.setResult(null);
                hookMethodParam.returnEarly = false;
            }
        } while (i < length2);
        if (!hookMethodParam.returnEarly) {
            try {
                hookMethodParam.setResult(invokeOriginal(hookInfo, hookMethodParam.thisObject, hookMethodParam.args));
            } catch (InvocationTargetException e) {
                hookMethodParam.setThrowable(e.getCause());
            }
        }
        int i2 = i - 1;
        do {
            Object result = hookMethodParam.getResult();
            Throwable throwable = hookMethodParam.getThrowable();
            try {
                ((HookMethod) snapshot[i2]).afterHookedMethod(hookMethodParam);
            } catch (Throwable th2) {
                HookBridge.log(th2);
                if (throwable == null) {
                    hookMethodParam.setResult(result);
                } else {
                    hookMethodParam.setThrowable(throwable);
                }
            }
            i2--;
        } while (i2 >= 0);
        Object resultOrThrowable = hookMethodParam.getResultOrThrowable();
        Class<?> returnType = hookInfo.getReturnType();
        return returnType != null ? returnType.cast(resultOrThrowable) : resultOrThrowable;
    }

    private static Object invokeOriginal(HookBridge.HookInfo hookInfo, Object obj, Object[] objArr) {
        return hookInfo.getBackupMethod().invoke(obj, objArr);
    }
}
