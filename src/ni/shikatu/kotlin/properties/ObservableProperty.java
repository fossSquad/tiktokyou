package ni.shikatu.kotlin.properties;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KProperty;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\bF\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0000H\u0094\u0080\u0004¢\u0006\u0002\u0010\u000fJ+\u0010\u0010\u001a\u00020\u00112\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0000H\u0094\u0080\u0004¢\u0006\u0002\u0010\u0012J%\u0010\u0013\u001a\u00028\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0096\u0082\u0004¢\u0006\u0002\u0010\u0015J-\u0010\u0016\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u0007\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u0017J\n\u0010\u0018\u001a\u00020\u0019H\u0096\u0080\u0004R\u0011\u0010\u0007\u001a\u00028\u0000X\u0082\u008e\b¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u001a"}, d2 = {"Lni/shikatu/kotlin/properties/ObservableProperty;", "V", "Lni/shikatu/kotlin/properties/ReadWriteProperty;", _UrlKt.FRAGMENT_ENCODE_SET, "initialValue", "<init>", "(Ljava/lang/Object;)V", "value", "Ljava/lang/Object;", "beforeChange", _UrlKt.FRAGMENT_ENCODE_SET, "property", "Lni/shikatu/kotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)Z", "afterChange", _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "getValue", "thisRef", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public abstract class ObservableProperty<V> implements ReadWriteProperty<Object, V> {
    private V value;

    public ObservableProperty(V v) {
        this.value = v;
    }

    protected boolean beforeChange(KProperty<?> kProperty, V v, V v2) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return true;
    }

    protected void afterChange(KProperty<?> kProperty, V v, V v2) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
    }

    @Override
    public V getValue(Object thisRef, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return this.value;
    }

    @Override
    public void setValue(Object thisRef, KProperty<?> kProperty, V v) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        V v2 = this.value;
        if (!beforeChange(kProperty, v2, v)) {
            return;
        }
        this.value = v;
        afterChange(kProperty, v2, v);
    }

    public String toString() {
        return "ObservableProperty(value=" + this.value + ')';
    }
}
