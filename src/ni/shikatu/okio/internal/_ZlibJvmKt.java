package ni.shikatu.okio.internal;

import java.util.GregorianCalendar;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a8\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011*\f\b\u0000\u0010\u0004\"\u00020\u00052\u00020\u0005¨\u0006\u0012"}, d2 = {"DEFAULT_COMPRESSION", _UrlKt.FRAGMENT_ENCODE_SET, "getDEFAULT_COMPRESSION", "()I", "CRC32", "Ljava/util/zip/CRC32;", "datePartsToEpochMillis", _UrlKt.FRAGMENT_ENCODE_SET, "year", "month", "day", "hour", "minute", "second", "EMPTY_BYTE_ARRAY", _UrlKt.FRAGMENT_ENCODE_SET, "getEMPTY_BYTE_ARRAY", "()[B", "ni.shikatu.okio"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class _ZlibJvmKt {
    private static final int DEFAULT_COMPRESSION = -1;
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    public static final int getDEFAULT_COMPRESSION() {
        return DEFAULT_COMPRESSION;
    }

    public static final long datePartsToEpochMillis(int year, int month, int day, int hour, int minute, int second) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(14, 0);
        calendar.set(year, month - 1, day, hour, minute, second);
        return calendar.getTime().getTime();
    }

    public static final byte[] getEMPTY_BYTE_ARRAY() {
        return EMPTY_BYTE_ARRAY;
    }
}
