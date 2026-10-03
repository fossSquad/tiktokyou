package com.windukk.hook;

public abstract class ReplaceMethod extends HookMethod {
    public static final ReplaceMethod DO_NOTHING = new ReplaceMethod(20000) {
        @Override
        public Object replaceHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
            return null;
        }
    };

    public ReplaceMethod() {
    }

    public static ReplaceMethod returnConstant(Object obj) {
        return returnConstant(50, obj);
    }

    @Override
    public final void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
    }

    @Override
    public final void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            hookMethodParam.setResult(replaceHookedMethod(hookMethodParam));
        } catch (Throwable th) {
            hookMethodParam.setThrowable(th);
        }
    }

    public abstract Object replaceHookedMethod(HookMethod.HookMethodParam hookMethodParam);

    public ReplaceMethod(int i) {
        super(i);
    }

    public static ReplaceMethod returnConstant(int i, final Object obj) {
        return new ReplaceMethod(i) {
            @Override
            public Object replaceHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
                return obj;
            }
        };
    }
}
