package X;

import com.bytedance.i18n.location.api.LocationData;
import com.bytedance.i18n.location.core.network.model.response.DataModel;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

public final class C1Ajl {
    public LocationData LIZ;
    public 054j LIZIZ;
    public DataModel LIZJ;
    public 00jk LIZLLL;
    public 00pn LJ;
    public C1AkB LJFF;
    public final String LJI;

    public C1Ajl() {
        this(null, null, 127);
    }

    public C1Ajl(LocationData locationData, 054j r4, int i) {
        locationData = (i & 1) != 0 ? null : locationData;
        r4 = (i & 2) != 0 ? null : r4;
        String string = (i & 64) != 0 ? UUID.randomUUID().toString() : null;
        this.LIZ = locationData;
        this.LIZIZ = r4;
        this.LIZJ = null;
        this.LIZLLL = null;
        this.LJ = null;
        this.LJFF = null;
        this.LJI = string;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1Ajl)) {
            return false;
        }
        C1Ajl c1Ajl = (C1Ajl) obj;
        return Intrinsics.LJFF(this.LIZ, c1Ajl.LIZ) && Intrinsics.LJFF(this.LIZIZ, c1Ajl.LIZIZ) && Intrinsics.LJFF(this.LIZJ, c1Ajl.LIZJ) && Intrinsics.LJFF(this.LIZLLL, c1Ajl.LIZLLL) && Intrinsics.LJFF(this.LJ, c1Ajl.LJ) && Intrinsics.LJFF(this.LJFF, c1Ajl.LJFF) && Intrinsics.LJFF(this.LJI, c1Ajl.LJI);
    }

    public final int hashCode() {
        LocationData locationData = this.LIZ;
        int iHashCode = (locationData == null ? 0 : locationData.hashCode()) * 31;
        054j r0 = this.LIZIZ;
        int iHashCode2 = (iHashCode + (r0 == null ? 0 : r0.hashCode())) * 31;
        DataModel dataModel = this.LIZJ;
        int iHashCode3 = (iHashCode2 + (dataModel == null ? 0 : dataModel.hashCode())) * 31;
        00jk r1 = this.LIZLLL;
        int iHashCode4 = (iHashCode3 + (r1 == null ? 0 : r1.hashCode())) * 31;
        00pn r2 = this.LJ;
        int iHashCode5 = (iHashCode4 + (r2 == null ? 0 : r2.hashCode())) * 31;
        C1AkB c1AkB = this.LJFF;
        return ((iHashCode5 + (c1AkB != null ? c1AkB.hashCode() : 0)) * 31) + this.LJI.hashCode();
    }

    public final String toString() {
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("StrategyContext(location=");
        sbLIZ.append(this.LIZ);
        sbLIZ.append(", options=");
        sbLIZ.append(this.LIZIZ);
        sbLIZ.append(", responseData=");
        sbLIZ.append(this.LIZJ);
        sbLIZ.append(", sensorData=");
        sbLIZ.append(this.LIZLLL);
        sbLIZ.append(", cellData=");
        sbLIZ.append(this.LJ);
        sbLIZ.append(", matchRuleInfo=");
        sbLIZ.append(this.LJFF);
        sbLIZ.append(", uuid=");
        sbLIZ.append(this.LJI);
        sbLIZ.append(')');
        return 0wS0.LIZIZ(sbLIZ);
    }
}
