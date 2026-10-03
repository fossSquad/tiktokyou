package ni.shikatu.okhttp3.internal.http;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0003\u001a\f\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u0007\u001a\n\u0010\u000e\u001a\u00020\u0007*\u00020\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u000f"}, d2 = {"MAX_DATE", _UrlKt.FRAGMENT_ENCODE_SET, "STANDARD_DATE_FORMAT", "ni/shikatu/okhttp3/internal/http/DateFormattingKt$STANDARD_DATE_FORMAT$1", "Lni/shikatu/okhttp3/internal/http/DateFormattingKt$STANDARD_DATE_FORMAT$1;", "BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "[Ljava/lang/String;", "BROWSER_COMPATIBLE_DATE_FORMATS", "Ljava/text/DateFormat;", "[Ljava/text/DateFormat;", "toHttpDateOrNull", "Ljava/util/Date;", "toHttpDateString", "okhttp"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DateFormattingKt {
    public static final long MAX_DATE = 253402300799999L;
    private static final DateFormattingKt$STANDARD_DATE_FORMAT$1 STANDARD_DATE_FORMAT = new ThreadLocal<DateFormat>() {

        @Override
        public DateFormat initialValue() {
            SimpleDateFormat $this$initialValue_u24lambda_u240 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            $this$initialValue_u24lambda_u240.setLenient(false);
            $this$initialValue_u24lambda_u240.setTimeZone(_UtilJvmKt.UTC);
            return $this$initialValue_u24lambda_u240;
        }
    };
    private static final String[] BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
    private static final DateFormat[] BROWSER_COMPATIBLE_DATE_FORMATS = new DateFormat[BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS.length];

    public static final Date toHttpDateOrNull(String $this$toHttpDateOrNull) {
        Intrinsics.checkNotNullParameter($this$toHttpDateOrNull, "<this>");
        if ($this$toHttpDateOrNull.length() == 0) {
            return null;
        }
        ParsePosition position = new ParsePosition(0);
        Date date = STANDARD_DATE_FORMAT.get().parse($this$toHttpDateOrNull, position);
        if (position.getIndex() == $this$toHttpDateOrNull.length()) {
            return date;
        }
        synchronized (BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS) {
            int length = BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS.length;
            for (int i = 0; i < length; i++) {
                DateFormat format = BROWSER_COMPATIBLE_DATE_FORMATS[i];
                if (format == null) {
                    SimpleDateFormat $this$toHttpDateOrNull_u24lambda_u240_u240 = new SimpleDateFormat(BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[i], Locale.US);
                    $this$toHttpDateOrNull_u24lambda_u240_u240.setTimeZone(_UtilJvmKt.UTC);
                    format = $this$toHttpDateOrNull_u24lambda_u240_u240;
                    BROWSER_COMPATIBLE_DATE_FORMATS[i] = format;
                }
                position.setIndex(0);
                Date date2 = format.parse($this$toHttpDateOrNull, position);
                if (position.getIndex() != 0) {
                    return date2;
                }
            }
            Unit unit = Unit.INSTANCE;
            return null;
        }
    }

    public static final String toHttpDateString(Date $this$toHttpDateString) {
        Intrinsics.checkNotNullParameter($this$toHttpDateString, "<this>");
        String str = STANDARD_DATE_FORMAT.get().format($this$toHttpDateString);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
