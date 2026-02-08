package com.oplus.ocs.base.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.oplus.ocs.base.utils.c;
import java.util.List;

public class CapabilityInfo implements Parcelable {
    public static final Parcelable.Creator<CapabilityInfo> CREATOR = new Parcelable.Creator<CapabilityInfo>() {
        @Override
        public final  CapabilityInfo createFromParcel(Parcel parcel) {
            return new CapabilityInfo(parcel);
        }

        @Override
        public final /* bridge */  CapabilityInfo[] newArray(int i) {
            return new CapabilityInfo[i];
        }
    };
    public List<Feature> a;
    public int b;
    public AuthResult c;
    public IBinder d;
    public String mClassName;

    public CapabilityInfo(Parcel parcel) {
        this.a = parcel.readArrayList(Feature.class.getClassLoader());
        this.b = parcel.readInt();
        this.c = (AuthResult) c.a(parcel, AuthResult.class.getClassLoader(), TextUtils.isEmpty(this.mClassName) ? AuthResult.class.getName() : this.mClassName);
        this.d = parcel.readStrongBinder();
    }

    public CapabilityInfo(List<Feature> list, int i, AuthResult authResult) {
        this(list, i, authResult, null);
    }

    public CapabilityInfo(List<Feature> list, int i, AuthResult authResult, IBinder iBinder) {
        this.a = list;
        this.b = i;
        this.c = authResult;
        this.d = iBinder;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public AuthResult getAuthResult() {
        return this.c;
    }

    public IBinder getBinder() {
        return this.d;
    }

    public String getClassName() {
        return this.mClassName;
    }

    public List<Feature> getFeatures() {
        return this.a;
    }

    public int getVersion() {
        return this.b;
    }

    public void setBinder(IBinder iBinder) {
        this.d = iBinder;
    }

    public void setClassName(String str) {
        this.mClassName = str;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.a);
        parcel.writeInt(this.b);
        c.a(parcel, this.c, TextUtils.isEmpty(this.mClassName) ? AuthResult.class.getName() : this.mClassName);
        parcel.writeStrongBinder(this.d);
    }
}
