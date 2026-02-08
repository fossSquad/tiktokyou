package com.oplus.ocs.base.common;

import android.os.Parcel;
import android.os.Parcelable;

public class Feature implements Parcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new Parcelable.Creator<Feature>() {
        @Override
        public final  Feature createFromParcel(Parcel parcel) {
            return new Feature(parcel);
        }

        @Override
        public final /* bridge */  Feature[] newArray(int i) {
            return new Feature[i];
        }
    };
    public String a;
    public long b;

    public Feature(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readLong();
    }

    public Feature(String str, long j) {
        this.a = str;
        this.b = j;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getName() {
        return this.a;
    }

    public long getVersion() {
        long j = this.b;
        if (j == -1) {
            return -1L;
        }
        return j;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeLong(this.b);
    }
}
