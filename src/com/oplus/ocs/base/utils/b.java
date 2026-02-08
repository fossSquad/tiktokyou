package com.oplus.ocs.base.utils;

import android.os.Looper;

public final class b {
    public static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
