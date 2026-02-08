package com.bytedance.i18n.location.core.network.model.response;

import X.0BZM;
import X.0wS0;
import kotlin.jvm.internal.Intrinsics;

public final class ResponseModel {
    public static final  int LIZ = 0;

    @0BZM("data")
    public final String data;

    @0BZM("err_no")
    public final int errCode;

    @0BZM("err_msg")
    public final String errMsg;

    public ResponseModel(String str, String str2, int i) {
        this.data = str;
        this.errMsg = str2;
        this.errCode = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponseModel)) {
            return false;
        }
        ResponseModel responseModel = (ResponseModel) obj;
        return Intrinsics.LJFF(this.data, responseModel.data) && Intrinsics.LJFF(this.errMsg, responseModel.errMsg) && this.errCode == responseModel.errCode;
    }

    public final int hashCode() {
        return (((this.data.hashCode() * 31) + this.errMsg.hashCode()) * 31) + this.errCode;
    }

    public final String toString() {
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("ResponseModel(data=");
        sbLIZ.append(this.data);
        sbLIZ.append(", errMsg=");
        sbLIZ.append(this.errMsg);
        sbLIZ.append(", errCode=");
        sbLIZ.append(this.errCode);
        sbLIZ.append(')');
        return 0wS0.LIZIZ(sbLIZ);
    }
}
