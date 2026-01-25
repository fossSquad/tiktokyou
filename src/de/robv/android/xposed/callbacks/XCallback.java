package de.robv.android.xposed.callbacks;

public abstract class XCallback implements Comparable<XCallback> {
    public static final int PRIORITY_DEFAULT = 50;
    public static final int PRIORITY_HIGHEST = 10000;
    public static final int PRIORITY_LOWEST = -10000;
    public final int priority;

    @Deprecated
    public XCallback() {
        this.priority = 50;
    }

    public XCallback(int priority) {
        this.priority = priority;
    }

    public static abstract class Param {
        protected Param() {
        }
    }

    @Override
    public int compareTo(XCallback other) {
        if (this == other) {
            return 0;
        }
        if (other.priority != this.priority) {
            return other.priority - this.priority;
        }
        if (System.identityHashCode(this) < System.identityHashCode(other)) {
            return -1;
        }
        return 1;
    }
}
