package X;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

public final class C1AjT {
    public static final  int LJIIL = 0;
    public final Map<String, Object> LIZ;
    public final long LIZIZ;
    public final long LIZJ;
    public final String LIZLLL;
    public final Long LJ;
    public final long LJFF;
    public final Long LJI;
    public final long LJII;
    public final Long LJIIIIZZ;
    public final long LJIIIZ;
    public final long LJIIJ;
    public final long LJIIJJI;

    public C1AjT(long j, long j2, Map map) {
        String str;
        Long l;
        this.LIZ = map;
        this.LIZIZ = j;
        this.LIZJ = j2;
        Object obj = map.get("cold_start_time");
        Long l2 = obj instanceof Long ? (Long) obj : null;
        Object obj2 = map.get("location_task_load_start_time");
        long jLongValue = (!(obj2 instanceof Long) || (l = (Long) obj2) == null) ? j : l.longValue();
        Object obj3 = map.get("settings_callback_time");
        Long l3 = obj3 instanceof Long ? (Long) obj3 : null;
        Object obj4 = map.get("load_type");
        this.LIZLLL = (!(obj4 instanceof String) || (str = (String) obj4) == null) ? "cold_start" : str;
        Long lValueOf = l2 != null ? Long.valueOf(jLongValue - l2.longValue()) : null;
        this.LJ = lValueOf;
        this.LJFF = lValueOf != null ? lValueOf.longValue() : 0L;
        Long lValueOf2 = l3 != null ? Long.valueOf(l3.longValue() - jLongValue) : null;
        this.LJI = lValueOf2;
        this.LJII = lValueOf2 != null ? lValueOf2.longValue() : 0L;
        Long lValueOf3 = l3 != null ? Long.valueOf(j - l3.longValue()) : null;
        this.LJIIIIZZ = lValueOf3;
        this.LJIIIZ = lValueOf3 != null ? lValueOf3.longValue() : 0L;
        this.LJIIJ = j2 - j;
        this.LJIIJJI = j2 - jLongValue;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1AjT)) {
            return false;
        }
        C1AjT c1AjT = (C1AjT) obj;
        return Intrinsics.LJFF(this.LIZ, c1AjT.LIZ) && this.LIZIZ == c1AjT.LIZIZ && this.LIZJ == c1AjT.LIZJ;
    }

    public final int hashCode() {
        return (((this.LIZ.hashCode() * 31) + 0Vx6.c(this.LIZIZ)) * 31) + 0Vx6.c(this.LIZJ);
    }

    public final String toString() {
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("InitMetrics(extrasSnapshot=");
        sbLIZ.append(this.LIZ);
        sbLIZ.append(", startInitTime=");
        sbLIZ.append(this.LIZIZ);
        sbLIZ.append(", resultTime=");
        sbLIZ.append(this.LIZJ);
        sbLIZ.append(')');
        return 0wS0.LIZIZ(sbLIZ);
    }
}
