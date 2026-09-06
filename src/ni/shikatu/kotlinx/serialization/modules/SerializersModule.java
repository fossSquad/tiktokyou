package ni.shikatu.kotlinx.serialization.modules;

import java.util.List;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.InternalSerializationApi;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.SerializationStrategy;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\bD¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\bH\u0087\u0080\u0004J>\u0010\u0004\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\b2\u0012\b\u0002\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u000bH§\u0080\u0004J9\u0010\f\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\r\"\b\b\u0000\u0010\u0006*\u00020\u00012\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u00060\b2\u0006\u0010\u000f\u001a\u0002H\u0006H§\u0080\u0004¢\u0006\u0002\u0010\u0010J6\u0010\f\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0011\"\b\b\u0000\u0010\u0006*\u00020\u00012\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u00060\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H§\u0080\u0004J\u0012\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H§\u0080\u0004R\u001b\u0010\u0018\u001a\u00020\u00198 X¡\u0084\b¢\u0006\f\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u001b\u0010\u001c\u0082\u0001\u0001\u001d¨\u0006\u001e"}, d2 = {"Lni/shikatu/kotlinx/serialization/modules/SerializersModule;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "getContextual", "Lni/shikatu/kotlinx/serialization/KSerializer;", "T", "kclass", "Lni/shikatu/kotlin/reflect/KClass;", "kClass", "typeArgumentsSerializers", _UrlKt.FRAGMENT_ENCODE_SET, "getPolymorphic", "Lni/shikatu/kotlinx/serialization/SerializationStrategy;", "baseClass", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "serializedClassName", _UrlKt.FRAGMENT_ENCODE_SET, "dumpTo", _UrlKt.FRAGMENT_ENCODE_SET, "collector", "Lni/shikatu/kotlinx/serialization/modules/SerializersModuleCollector;", "hasInterfaceContextualSerializers", _UrlKt.FRAGMENT_ENCODE_SET, "getHasInterfaceContextualSerializers$kotlinx_serialization_core$annotations", "getHasInterfaceContextualSerializers$kotlinx_serialization_core", "()Z", "Lni/shikatu/kotlinx/serialization/modules/SerialModuleImpl;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class SerializersModule {
    public  SerializersModule(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @InternalSerializationApi
    public static  void getHasInterfaceContextualSerializers$kotlinx_serialization_core$annotations() {
    }

    @ExperimentalSerializationApi
    public abstract void dumpTo(SerializersModuleCollector serializersModuleCollector);

    @ExperimentalSerializationApi
    public abstract <T> KSerializer<T> getContextual(KClass<T> kClass, List<? extends KSerializer<?>> list);

    public abstract boolean getHasInterfaceContextualSerializers$kotlinx_serialization_core();

    @ExperimentalSerializationApi
    public abstract <T> DeserializationStrategy<T> getPolymorphic(KClass<? super T> kClass, String str);

    @ExperimentalSerializationApi
    public abstract <T> SerializationStrategy<T> getPolymorphic(KClass<? super T> kClass, T t);

    private SerializersModule() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of overload with default parameter", replaceWith = @ReplaceWith(expression = "getContextual(kclass)", imports = {}))
    @ExperimentalSerializationApi
    public final  KSerializer getContextual(KClass kclass) {
        Intrinsics.checkNotNullParameter(kclass, "kclass");
        return getContextual(kclass, CollectionsKt.emptyList());
    }

    public static  KSerializer getContextual$default(SerializersModule serializersModule, KClass kClass, List list, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContextual");
        }
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        return serializersModule.getContextual(kClass, list);
    }
}
