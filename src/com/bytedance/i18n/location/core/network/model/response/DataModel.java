package com.bytedance.i18n.location.core.network.model.response;

import X.0BZM;
import X.0Vx6;
import X.0wS0;
import com.bytedance.i18n.location.api.Address;
import kotlin.jvm.internal.Intrinsics;

public final class DataModel {
    public static final  int LIZ = 0;

    @0BZM("Location")
    public final Address address;

    @0BZM("location_cache_ttl")
    public final long cacheTTL;

    @0BZM("EncryptedGeohash")
    public final String encryptedGeoHash;

    @0BZM("EncryptedH3")
    public final String encryptedH3;

    @0BZM("EncryptedS2")
    public final String encryptedS2;

    @0BZM("wifi_conf")
    public final String wifiRule;

    public DataModel() {
        this(null, null, null, null, -1L, null);
    }

    public DataModel(Address address, String str, String str2, String str3, long j, String str4) {
        this.address = address;
        this.encryptedGeoHash = str;
        this.encryptedH3 = str2;
        this.encryptedS2 = str3;
        this.cacheTTL = j;
        this.wifiRule = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataModel)) {
            return false;
        }
        DataModel dataModel = (DataModel) obj;
        return Intrinsics.LJFF(this.address, dataModel.address) && Intrinsics.LJFF(this.encryptedGeoHash, dataModel.encryptedGeoHash) && Intrinsics.LJFF(this.encryptedH3, dataModel.encryptedH3) && Intrinsics.LJFF(this.encryptedS2, dataModel.encryptedS2) && this.cacheTTL == dataModel.cacheTTL && Intrinsics.LJFF(this.wifiRule, dataModel.wifiRule);
    }

    public final int hashCode() {
        Address address = this.address;
        int iHashCode = (address == null ? 0 : address.hashCode()) * 31;
        String str = this.encryptedGeoHash;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.encryptedH3;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.encryptedS2;
        int iHashCode4 = (((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + 0Vx6.c(this.cacheTTL)) * 31;
        String str4 = this.wifiRule;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("DataModel(address=");
        sbLIZ.append(this.address);
        sbLIZ.append(", encryptedGeoHash=");
        sbLIZ.append(this.encryptedGeoHash);
        sbLIZ.append(", encryptedH3=");
        sbLIZ.append(this.encryptedH3);
        sbLIZ.append(", encryptedS2=");
        sbLIZ.append(this.encryptedS2);
        sbLIZ.append(", cacheTTL=");
        sbLIZ.append(this.cacheTTL);
        sbLIZ.append(", wifiRule=");
        sbLIZ.append(this.wifiRule);
        sbLIZ.append(')');
        return 0wS0.LIZIZ(sbLIZ);
    }
}
