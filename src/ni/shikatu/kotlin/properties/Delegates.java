package ni.shikatu.kotlin.properties;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function3;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KProperty;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0001H\u0086\u0080\u0004J\u0081\u0001\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\u0006\u0010\b\u001a\u0002H\u00062Q\b\u0004\u0010\t\u001aK\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u0011H\u0006¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u0011H\u0006¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\nH\u0086\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0081\u0001\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\u0006\u0010\b\u001a\u0002H\u00062Q\b\u0004\u0010\t\u001aK\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u0011H\u0006¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u0011H\u0006¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00140\nH\u0086\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"Lni/shikatu/kotlin/properties/Delegates;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "notNull", "Lni/shikatu/kotlin/properties/ReadWriteProperty;", "T", "observable", "initialValue", "onChange", "Lni/shikatu/kotlin/Function3;", "Lni/shikatu/kotlin/reflect/KProperty;", "Lni/shikatu/kotlin/ParameterName;", "name", "property", "oldValue", "newValue", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlin/properties/ReadWriteProperty;", "vetoable", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Delegates {
    public static final Delegates INSTANCE = new Delegates();

    private Delegates() {
    }

    public final <T> ReadWriteProperty<Object, T> notNull() {
        return new NotNullVar();
    }

    public final <T> ReadWriteProperty<Object, T> observable(T t, final Function3<? super KProperty<?>, ? super T, ? super T, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "onChange");
        return new ObservableProperty<T>(t) {
            @Override
            protected void afterChange(KProperty<?> kProperty, T t2, T t3) {
                Intrinsics.checkNotNullParameter(kProperty, "property");
                function3.invoke(kProperty, t2, t3);
            }
        };
    }

    public final <T> ReadWriteProperty<Object, T> vetoable(T t, final Function3<? super KProperty<?>, ? super T, ? super T, Boolean> function3) {
        Intrinsics.checkNotNullParameter(function3, "onChange");
        return new ObservableProperty<T>(t) {
            @Override
            protected boolean beforeChange(KProperty<?> kProperty, T t2, T t3) {
                Intrinsics.checkNotNullParameter(kProperty, "property");
                return function3.invoke(kProperty, t2, t3).booleanValue();
            }
        };
    }
}
