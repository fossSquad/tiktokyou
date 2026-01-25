package de.robv.android.xposed;

import de.robv.android.xposed.callbacks.IXUnhook;
import de.robv.android.xposed.callbacks.XCallback;
import java.lang.reflect.Member;

public abstract class XC_MethodHook extends XCallback {
    public XC_MethodHook() {
    }

    public XC_MethodHook(int priority) {
        super(priority);
    }

    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
    }

    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
    }

    public static final class MethodHookParam extends XCallback.Param {
        public Object[] args;
        public Member method;
        public Object thisObject;
        private Object result = null;
        private Throwable throwable = null;
        boolean returnEarly = false;

        public Object getResult() {
            return this.result;
        }

        public void setResult(Object result) {
            this.result = result;
            this.throwable = null;
            this.returnEarly = true;
        }

        public Throwable getThrowable() {
            return this.throwable;
        }

        public boolean hasThrowable() {
            return this.throwable != null;
        }

        public void setThrowable(Throwable throwable) {
            this.throwable = throwable;
            this.result = null;
            this.returnEarly = true;
        }

        public Object getResultOrThrowable() throws Throwable {
            if (this.throwable != null) {
                throw this.throwable;
            }
            return this.result;
        }
    }

    public class Unhook implements IXUnhook<XC_MethodHook> {
        private final Member hookMethod;

        Unhook(Member hookMethod) {
            this.hookMethod = hookMethod;
        }

        public Member getHookedMethod() {
            return this.hookMethod;
        }

        @Override
        public XC_MethodHook getCallback() {
            return XC_MethodHook.this;
        }

        @Override
        public void unhook() {
            XposedBridge.unhookMethod(this.hookMethod, XC_MethodHook.this);
        }
    }
}
