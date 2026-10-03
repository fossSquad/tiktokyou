package ni.shikatu.kotlinx.serialization.modules;

import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\b\tB\t\bD¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0007H¦\u0082\u0004\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lni/shikatu/kotlinx/serialization/modules/ContextualProvider;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "invoke", "Lni/shikatu/kotlinx/serialization/KSerializer;", "typeArgumentsSerializers", _UrlKt.FRAGMENT_ENCODE_SET, "Argless", "WithTypeArguments", "Lni/shikatu/kotlinx/serialization/modules/ContextualProvider$Argless;", "Lni/shikatu/kotlinx/serialization/modules/ContextualProvider$WithTypeArguments;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class ContextualProvider {
    public  ContextualProvider(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract KSerializer<?> invoke(List<? extends KSerializer<?>> list);

    private ContextualProvider() {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0015\bF\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00032\u0010\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\nH\u0096\u0082\u0004J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0082\u0004J\n\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004R\u0019\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lni/shikatu/kotlinx/serialization/modules/ContextualProvider$Argless;", "Lni/shikatu/kotlinx/serialization/modules/ContextualProvider;", "serializer", "Lni/shikatu/kotlinx/serialization/KSerializer;", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "getSerializer", "()Lkotlinx/serialization/KSerializer;", "invoke", "typeArgumentsSerializers", _UrlKt.FRAGMENT_ENCODE_SET, "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Argless extends ContextualProvider {
        private final KSerializer<?> serializer;

        public Argless(KSerializer<?> kSerializer) {
            super(null);
            Intrinsics.checkNotNullParameter(kSerializer, "serializer");
            this.serializer = kSerializer;
        }

        public final KSerializer<?> getSerializer() {
            return this.serializer;
        }

        @Override
        public KSerializer<?> invoke(List<? extends KSerializer<?>> list) {
            Intrinsics.checkNotNullParameter(list, "typeArgumentsSerializers");
            return this.serializer;
        }

        public boolean equals(Object other) {
            return (other instanceof Argless) && Intrinsics.areEqual(((Argless) other).serializer, this.serializer);
        }

        public int hashCode() {
            return this.serializer.hashCode();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B:\bF\u0012/\u0010\u0002\u001a+\u0012\u001d\u0012\u001b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0003¢\u0006\u0004\b\t\u0010\nJ \u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00052\u0010\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0096\u0082\u0004R>\u0010\u0002\u001a+\u0012\u001d\u0012\u001b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lni/shikatu/kotlinx/serialization/modules/ContextualProvider$WithTypeArguments;", "Lni/shikatu/kotlinx/serialization/modules/ContextualProvider;", "provider", "Lni/shikatu/kotlin/Function1;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/KSerializer;", "Lni/shikatu/kotlin/ParameterName;", "name", "typeArgumentsSerializers", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getProvider", "()Lkotlin/jvm/functions/Function1;", "invoke", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class WithTypeArguments extends ContextualProvider {
        private final Function1<List<? extends KSerializer<?>>, KSerializer<?>> provider;

        public WithTypeArguments(Function1<? super List<? extends KSerializer<?>>, ? extends KSerializer<?>> function1) {
            super(null);
            Intrinsics.checkNotNullParameter(function1, "provider");
            this.provider = function1;
        }

        public final Function1<List<? extends KSerializer<?>>, KSerializer<?>> getProvider() {
            return this.provider;
        }

        @Override
        public KSerializer<?> invoke(List<? extends KSerializer<?>> list) {
            Intrinsics.checkNotNullParameter(list, "typeArgumentsSerializers");
            return this.provider.invoke(list);
        }
    }
}
