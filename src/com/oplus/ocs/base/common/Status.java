package com.oplus.ocs.base.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.ocs.base.common.constant.CommonStatusCodes;
import com.oplus.ocs.base.internal.safeparcel.AbstractSafeParcelable;
import com.oplus.ocs.base.utils.e;
import java.util.Arrays;

public class Status extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new b();
    public int a;
    public int b;
    public String c;
    public PendingIntent d;

    public Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = pendingIntent;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.a == status.a && this.b == status.b && e.a(this.c, status.c) && e.a(this.d, status.d);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b), this.c, this.d});
    }

    public String toString() {
        e.a aVarA = e.a(this);
        String statusCodeString = this.c;
        if (statusCodeString == null) {
            statusCodeString = CommonStatusCodes.getStatusCodeString(this.b);
        }
        aVarA.a("statusCode", statusCodeString);
        aVarA.a("resolution", this.d);
        return aVarA.toString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        int iB = com.oplus.ocs.base.internal.safeparcel.b.b(parcel, 20293);
        com.oplus.ocs.base.internal.safeparcel.b.a(parcel, 1, this.b);
        com.oplus.ocs.base.internal.safeparcel.b.a(parcel, 1000, this.a);
        String str = this.c;
        if (str != null) {
            int iB2 = com.oplus.ocs.base.internal.safeparcel.b.b(parcel, 2);
            parcel.writeString(str);
            com.oplus.ocs.base.internal.safeparcel.b.a(parcel, iB2);
        }
        PendingIntent pendingIntent = this.d;
        if (pendingIntent != null) {
            int iB3 = com.oplus.ocs.base.internal.safeparcel.b.b(parcel, 3);
            pendingIntent.writeToParcel(parcel, i);
            com.oplus.ocs.base.internal.safeparcel.b.a(parcel, iB3);
        }
        com.oplus.ocs.base.internal.safeparcel.b.a(parcel, iB);
    }
}
