package com.oplus.ocs.base.common;

import android.os.Parcel;
import android.os.Parcelable;

public class AuthResult implements Parcelable {
    public static final Parcelable.Creator<AuthResult> CREATOR = new Parcelable.Creator<AuthResult>() {
        @Override
        public final  AuthResult createFromParcel(Parcel parcel) {
            return new AuthResult(parcel);
        }

        @Override
        public final /* bridge */  AuthResult[] newArray(int i) {
            return new AuthResult[i];
        }
    };
    public String a;
    public int b;
    public int c;
    public int d;
    public byte[] e;

    public AuthResult(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.createByteArray();
    }

    public AuthResult(String str, int i, int i2, int i3, byte[] bArr) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = bArr;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public int getErrrorCode() {
        return this.d;
    }

    public String getPackageName() {
        return this.a;
    }

    public byte[] getPermitBits() {
        return this.e;
    }

    public int getPid() {
        return this.c;
    }

    public int getUid() {
        return this.b;
    }

    public void setErrrorCode(int i) {
        this.d = i;
    }

    public void setPackageName(String str) {
        this.a = str;
    }

    public void setPermitBits(byte[] bArr) {
        this.e = bArr;
    }

    public void setPid(int i) {
        this.c = i;
    }

    public void setUid(int i) {
        this.b = i;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeByteArray(this.e);
    }
}
