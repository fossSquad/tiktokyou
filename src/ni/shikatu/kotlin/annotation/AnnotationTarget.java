package ni.shikatu.kotlin.annotation;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.enums.EnumEntries;
import ni.shikatu.kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lni/shikatu/kotlin/annotation/AnnotationTarget;", "", "<init>", "(Ljava/lang/String;I)V", "CLASS", "ANNOTATION_CLASS", "TYPE_PARAMETER", "PROPERTY", "FIELD", "LOCAL_VARIABLE", "VALUE_PARAMETER", "CONSTRUCTOR", "FUNCTION", "PROPERTY_GETTER", "PROPERTY_SETTER", "TYPE", "EXPRESSION", "FILE", "TYPEALIAS", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum AnnotationTarget {
    CLASS,
    ANNOTATION_CLASS,
    TYPE_PARAMETER,
    PROPERTY,
    FIELD,
    LOCAL_VARIABLE,
    VALUE_PARAMETER,
    CONSTRUCTOR,
    FUNCTION,
    PROPERTY_GETTER,
    PROPERTY_SETTER,
    TYPE,
    EXPRESSION,
    FILE,
    TYPEALIAS;

    private static final  EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<AnnotationTarget> getEntries() {
        return $ENTRIES;
    }
}
