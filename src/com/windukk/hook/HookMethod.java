package com.windukk.hook;

import com.windukk.hook.callbacks.HookCallback;
import com.windukk.hook.callbacks.UnhookInterface;
import java.lang.reflect.Member;

public abstract class HookMethod extends HookCallback {

    public static final class HookMethodParam extends HookCallback.Param {
        public Object[] args;
        public Member method;
        private Object result;
        boolean returnEarly;
        public Object thisObject;
        private Throwable throwable;

        public Object getResult() {
            return this.result;
        }

        public Object getResultOrThrowable() {
            Throwable th = this.throwable;
            if (th == null) {
                return this.result;
            }
            throw th;
        }

        public Throwable getThrowable() {
            return this.throwable;
        }

        public boolean hasThrowable() {
            return this.throwable != null;
        }

        public void setResult(Object obj) {
            this.result = obj;
            this.throwable = null;
            this.returnEarly = true;
        }

        public void setThrowable(Throwable th) {
            this.throwable = th;
            this.result = null;
            this.returnEarly = true;
        }
    }

    public class Unhook implements UnhookInterface<HookMethod> {
        private final Member hookMethod;

        public Unhook(Member member) {
            this.hookMethod = member;
        }

        public Member getHookedMethod() {
            return this.hookMethod;
        }

        @Override
        public void unhook() {
            HookBridge.unhookMethod(this.hookMethod, HookMethod.this);
        }

        @Override
        public HookMethod getCallback() {
            return HookMethod.this;
        }
    }

    public HookMethod() {
    }

    public void afterHookedMethod(HookMethodParam hookMethodParam) {
    }

    public void beforeHookedMethod(HookMethodParam hookMethodParam) {
    }

    public HookMethod(int i) {
        super(i);
    }
}
