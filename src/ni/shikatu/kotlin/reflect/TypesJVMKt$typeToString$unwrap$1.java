package ni.shikatu.kotlin.reflect;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.FunctionReferenceImpl;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
final  class TypesJVMKt$typeToString$unwrap$1 extends FunctionReferenceImpl implements Function1<Class<?>, Class<?>> {
    public static final TypesJVMKt$typeToString$unwrap$1 INSTANCE = new TypesJVMKt$typeToString$unwrap$1();

    TypesJVMKt$typeToString$unwrap$1() {
        super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
    }

    @Override
    public final Class<?> invoke(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "p0");
        return cls.getComponentType();
    }
}
