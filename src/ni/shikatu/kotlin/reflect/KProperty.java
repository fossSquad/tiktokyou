package ni.shikatu.kotlin.reflect;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002\u0011\u0012R)\u0010\u0003\u001a\u00020\u00048&X§\u0084\br\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0007R)\u0010\u000b\u001a\u00020\u00048&X§\u0084\br\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0019\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eX¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lni/shikatu/kotlin/reflect/KProperty;", "V", "Lni/shikatu/kotlin/reflect/KCallable;", "isLateinit", _UrlKt.FRAGMENT_ENCODE_SET, "isLateinit$annotations", "()V", "()Z", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.1", "isConst", "isConst$annotations", "getter", "Lni/shikatu/kotlin/reflect/KProperty$Getter;", "getGetter", "()Lkotlin/reflect/KProperty$Getter;", "Accessor", "Getter", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public interface KProperty<V> extends KCallable<V> {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lni/shikatu/kotlin/reflect/KProperty$Accessor;", "V", _UrlKt.FRAGMENT_ENCODE_SET, "property", "Lni/shikatu/kotlin/reflect/KProperty;", "getProperty", "()Lkotlin/reflect/KProperty;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public interface Accessor<V> {
        KProperty<V> getProperty();
    }

    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    public static final class DefaultImpls {
        public static  void isConst$annotations() {
        }

        public static  void isLateinit$annotations() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003¨\u0006\u0004"}, d2 = {"Lni/shikatu/kotlin/reflect/KProperty$Getter;", "V", "Lni/shikatu/kotlin/reflect/KProperty$Accessor;", "Lni/shikatu/kotlin/reflect/KFunction;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public interface Getter<V> extends Accessor<V>, KFunction<V> {
    }

    Getter<V> getGetter();

    boolean isConst();

    boolean isLateinit();
}
