package com.oplus.ocs.base.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

public final class b implements Parcelable.Creator<Status> {
    @Override
    public final  Status createFromParcel(Parcel parcel) {
        Parcelable parcelable;
        int i = parcel.readInt();
        int iB = com.oplus.ocs.base.internal.safeparcel.a.b(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if ((i & 65535) != 20293) {
            throw new com.oplus.ocs.base.internal.safeparcel.a.C0001a("Expected object header. Got 0x" + Integer.toHexString(i));
        }
        int i2 = iB + iDataPosition;
        if (i2 < iDataPosition || i2 > parcel.dataSize()) {
            throw new com.oplus.ocs.base.internal.safeparcel.a.C0001a("Size read is invalid start=" + iDataPosition + " end=" + i2);
        }
        int iA = 0;
        int iA2 = 0;
        String string = null;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < i2) {
            int i3 = parcel.readInt();
            int i4 = i3 & 65535;
            if (i4 == 1) {
                iA2 = com.oplus.ocs.base.internal.safeparcel.a.a(parcel, i3);
            } else if (i4 == 2) {
                int iB2 = com.oplus.ocs.base.internal.safeparcel.a.b(parcel, i3);
                int iDataPosition2 = parcel.dataPosition();
                if (iB2 == 0) {
                    string = null;
                } else {
                    string = parcel.readString();
                    parcel.setDataPosition(iDataPosition2 + iB2);
                }
            } else if (i4 == 3) {
                Parcelable.Creator creator = PendingIntent.CREATOR;
                int iB3 = com.oplus.ocs.base.internal.safeparcel.a.b(parcel, i3);
                int iDataPosition3 = parcel.dataPosition();
                if (iB3 == 0) {
                    parcelable = null;
                } else {
                    parcelable = (Parcelable) creator.createFromParcel(parcel);
                    parcel.setDataPosition(iDataPosition3 + iB3);
                }
                pendingIntent = (PendingIntent) parcelable;
            } else if (i4 != 1000) {
                parcel.setDataPosition(parcel.dataPosition() + com.oplus.ocs.base.internal.safeparcel.a.b(parcel, i3));
            } else {
                iA = com.oplus.ocs.base.internal.safeparcel.a.a(parcel, i3);
            }
        }
        if (parcel.dataPosition() == i2) {
            return new Status(iA, iA2, string, pendingIntent);
        }
        throw new com.oplus.ocs.base.internal.safeparcel.a.C0001a("Overread allowed size end=".concat(String.valueOf(i2)));
    }

    @Override
    public final /* bridge */  Status[] newArray(int i) {
        return new Status[i];
    }
}
