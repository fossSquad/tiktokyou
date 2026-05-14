package com.windukk.hook;

import java.lang.reflect.InvocationTargetException;

final class CallbackDispatcher {
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
            Object[] objArr2 = new Object[objArr.length - 1];
            hookMethodParam.args = objArr2;
            System.arraycopy(objArr, 1, objArr2, 0, objArr.length - 1);
        }
        Object[] snapshot = hookInfo.getCallbacks().getSnapshot();
        int length = snapshot.length;
        if (length == 0) {
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
        } while (i < length);
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
        return HookBridge.invokeMember(hookInfo.getBackup(), obj, objArr);
    }
}
