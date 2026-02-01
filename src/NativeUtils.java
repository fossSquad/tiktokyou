package com.windukk.mod.utils;

import android.content.Context;

public class NativeUtils {
    public static final int a = 0;
    public static final int b = 1;

    static {
        System.loadLibrary("ttmod");
    }

    public static native int fixColorNative(int i, int i2);

    public static native String getStringNative(int i);

    public static native void init(Context context);

    public static native boolean verifySignatureNative(Context context);
}
