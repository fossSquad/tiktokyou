package ni.shikatu.kotlin.reflect;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.enums.EnumEntries;
import ni.shikatu.kotlin.enums.EnumEntriesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u001bR\u0013\u0010\u0002\u001a\u00020\u0003X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u00020\u000bX¦\u0084\b¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u00020\u000fX¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u00020\u0013X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R)\u0010\u0015\u001a\u00020\u00138&X§\u0084\br\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0015\u0010\u0014¨\u0006\u001c"}, d2 = {"Lni/shikatu/kotlin/reflect/KParameter;", "Lni/shikatu/kotlin/reflect/KAnnotatedElement;", "index", _UrlKt.FRAGMENT_ENCODE_SET, "getIndex", "()I", "name", _UrlKt.FRAGMENT_ENCODE_SET, "getName", "()Ljava/lang/String;", "type", "Lni/shikatu/kotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "kind", "Lni/shikatu/kotlin/reflect/KParameter$Kind;", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "isOptional", _UrlKt.FRAGMENT_ENCODE_SET, "()Z", "isVararg", "isVararg$annotations", "()V", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.1", "Kind", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public interface KParameter extends KAnnotatedElement {

    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    public static final class DefaultImpls {
        public static  void isVararg$annotations() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0006\b\u0005\u0012\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lni/shikatu/kotlin/reflect/KParameter$Kind;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;I)V", "INSTANCE", "CONTEXT", "Lni/shikatu/kotlin/ExperimentalContextParameters;", "EXTENSION_RECEIVER", "VALUE", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public enum Kind {
        INSTANCE,
        CONTEXT,
        EXTENSION_RECEIVER,
        VALUE;

        private static final  EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Kind> getEntries() {
            return $ENTRIES;
        }
    }

    int getIndex();

    Kind getKind();

    String getName();

    KType getType();

    boolean isOptional();

    boolean isVararg();
}
