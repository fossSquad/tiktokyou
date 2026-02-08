package com.oplus.ocs.base.utils;

import X.0Vx6;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class ServiceCheck {
    public static final String a = "ServiceCheck";

    public static boolean a(Context context) {
        return a(context, "com.coloros.ocs.opencapabilityservice") || a(context, "com.oplus.ocs");
    }

    public static boolean a(Context context, String str) {
        try {
            Bundle bundle = 0Vx6.Y(context.getPackageManager(), str, 128).metaData;
            return bundle != null && bundle.containsKey("ocs_internal") && bundle.getInt("ocs_internal", 0) == 1;
        } catch (PackageManager.NameNotFoundException e) {
            a.d(a, 0Vx6.m0("Unable to fetch metadata from teh manifest %s", new Object[]{e.getMessage()}));
            return false;
        }
    }

    public static boolean b(Context context) {
        return b(context, "com.coloros.ocs.opencapabilityservice") || b(context, "com.oplus.ocs");
    }

    public static boolean b(Context context, String str) {
        try {
            Bundle bundle = 0Vx6.Y(context.getPackageManager(), str, 128).metaData;
            if (bundle != null && bundle.containsKey("ocs_internal") && bundle.containsKey("ocs_optimize")) {
                int i = bundle.getInt("ocs_internal", 0);
                int i2 = bundle.getInt("ocs_optimize", 0);
                if (i == 1 && i2 == 1) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            a.d(a, 0Vx6.m0("Unable to fetch metadata from teh manifest %s", new Object[]{e.getMessage()}));
            return false;
        }
    }

    public static boolean check(Context context, String str) {
        try {
            return 0Vx6.Y(context.getPackageManager(), str, 128).uid != 0;
        } catch (PackageManager.NameNotFoundException unused) {
            a.d(a, 0Vx6.m0("%s not found", new Object[]{str}));
        }
    }
}
