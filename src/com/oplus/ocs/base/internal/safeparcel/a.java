package com.oplus.ocs.base.internal.safeparcel;

import android.os.Parcel;

public final class a {

    public static class C0001a extends RuntimeException {
        public C0001a(String str) {
            super(str);
        }
    }

    public static int a(Parcel parcel, int i) {
        c(parcel, i);
        return parcel.readInt();
    }

    public static int b(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    public static void c(Parcel parcel, int i) {
        int iB = b(parcel, i);
        if (iB == 4) {
            return;
        }
        throw new C0001a("Expected size 4 got " + iB + " (0x" + Integer.toHexString(iB) + ")");
    }
}
