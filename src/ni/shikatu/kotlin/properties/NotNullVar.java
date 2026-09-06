package ni.shikatu.kotlin.properties;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KProperty;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00010\u0003B\t\bF¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\b\u001a\u00028\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0096\u0082\u0004¢\u0006\u0002\u0010\fJ-\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u0006\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u000fJ\n\u0010\u0010\u001a\u00020\u0011H\u0096\u0080\u0004R\u0013\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0082\u008e\b¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0012"}, d2 = {"Lni/shikatu/kotlin/properties/NotNullVar;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/properties/ReadWriteProperty;", "<init>", "()V", "value", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lni/shikatu/kotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
final class NotNullVar<T> implements ReadWriteProperty<Object, T> {
    private T value;

    @Override
    public T getValue(Object thisRef, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Property " + kProperty.getName() + " should be initialized before get.");
    }

    @Override
    public void setValue(Object thisRef, KProperty<?> kProperty, T t) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Intrinsics.checkNotNullParameter(t, "value");
        this.value = t;
    }

    public String toString() {
        return "NotNullProperty(" + (this.value != null ? "value=" + this.value : "value not initialized yet") + ')';
    }
}
