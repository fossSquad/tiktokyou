package com.windukk.hook.callbacks;

public abstract class HookCallback implements Comparable<HookCallback> {
    public static final int PRIORITY_DEFAULT = 50;
    public static final int PRIORITY_HIGHEST = 10000;
    public static final int PRIORITY_LOWEST = -10000;
    public final int priority;

    public static abstract class Param {
    }

    public HookCallback() {
        this(50);
    }

    public HookCallback(int i) {
        this.priority = i;
    }

    @Override
    public int compareTo(HookCallback hookCallback) {
        if (this == hookCallback) {
            return 0;
        }
        int i = hookCallback.priority;
        int i2 = this.priority;
        if (i != i2) {
            return i - i2;
        }
        return System.identityHashCode(this) < System.identityHashCode(hookCallback) ? -1 : 1;
    }
}
