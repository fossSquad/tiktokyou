package com.ss.android.ugc.aweme.utils;

import android.content.Context;

public class CommonUtils {
    public static final int ID_LOG_TAG = 0;
    public static final int ID_VERSION = 1;

    static {
        System.loadLibrary("ttmod");
    }

    public static native void init(Context context);

    public static native boolean verifySignatureNative(Context context);
}
