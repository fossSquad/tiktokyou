package com.ss.android.ugc.aweme.utils;

import android.content.Context;

public class CommonUtils {
    static {
        System.loadLibrary("ttmod");
    }

    public static native int fixColorNative(int i, int i2);

    public static native void init(Context context);

    public static native boolean verifySignatureNative(Context context);
}
