package Z;
import java.util.Comparator;
import java.util.Locale;
import ni.shikatu.kotlin.comparisons.ComparisonsKt;

public final class x implements Comparator {
    @Override
    public final int compare(Object obj, Object obj2) {
        String strA = ((w) obj).a();
        Locale locale = Locale.getDefault();
        String lowerCase = strA.toLowerCase(locale);
        String strA2 = ((w) obj2).a();
        Locale locale2 = Locale.getDefault();
        String lowerCase2 = strA2.toLowerCase(locale2);
        return ComparisonsKt.compareValues(lowerCase, lowerCase2);
    }
}
