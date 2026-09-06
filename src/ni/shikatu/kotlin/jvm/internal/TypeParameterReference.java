package ni.shikatu.kotlin.jvm.internal;

import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.NoWhenBranchMatchedException;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.reflect.KType;
import ni.shikatu.kotlin.reflect.KTypeParameter;
import ni.shikatu.kotlin.reflect.KVariance;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB-\bF\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u001a\u001a\u00020\u001b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0086\u0080\u0004R\u0015\u0010\u0005\u001a\u00020\u0006X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u00020\bX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\t\u001a\u00020\nX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0017\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u008e\b¢\u0006\u0002\n\u0000R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138VX\u0096\u0084\b¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019Ê\u0001\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( ¨\u0006\u001d"}, d2 = {"Lni/shikatu/kotlin/jvm/internal/TypeParameterReference;", "Lni/shikatu/kotlin/jvm/internal/KTypeParameterBase;", "container", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/jvm/internal/TypeParameterContainer;", "name", _UrlKt.FRAGMENT_ENCODE_SET, "variance", "Lni/shikatu/kotlin/reflect/KVariance;", "isReified", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/reflect/KVariance;Z)V", "getName", "()Ljava/lang/String;", "getVariance", "()Lkotlin/reflect/KVariance;", "()Z", "bounds", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/reflect/KType;", "upperBounds", "getUpperBounds$annotations", "()V", "getUpperBounds", "()Ljava/util/List;", "setUpperBounds", _UrlKt.FRAGMENT_ENCODE_SET, "Companion", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.4"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class TypeParameterReference extends KTypeParameterBase {
    public static final Companion Companion = new Companion(null);
    private volatile List<? extends KType> bounds;
    private final boolean isReified;
    private final String name;
    private final KVariance variance;

    public static  void getUpperBounds$annotations() {
    }

    public TypeParameterReference(Object container, String name, KVariance variance, boolean isReified) {
        super(container);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(variance, "variance");
        this.name = name;
        this.variance = variance;
        this.isReified = isReified;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public KVariance getVariance() {
        return this.variance;
    }

    @Override
    public boolean isReified() {
        return this.isReified;
    }

    @Override
    public List<KType> getUpperBounds() {
        List list = this.bounds;
        if (list != null) {
            return list;
        }
        List<KType> listListOf = CollectionsKt.listOf(Reflection.nullableTypeOf(Object.class));
        this.bounds = listListOf;
        return listListOf;
    }

    public final void setUpperBounds(List<? extends KType> list) {
        Intrinsics.checkNotNullParameter(list, "upperBounds");
        if (this.bounds != null) {
            throw new IllegalStateException(("Upper bounds of type parameter '" + this + "' have already been initialized.").toString());
        }
        this.bounds = list;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0080\u0004¨\u0006\b"}, d2 = {"Lni/shikatu/kotlin/jvm/internal/TypeParameterReference$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "typeParameter", "Lni/shikatu/kotlin/reflect/KTypeParameter;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
        public static final  class WhenMappings {
            public static final  int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[KVariance.values().length];
                try {
                    iArr[KVariance.INVARIANT.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[KVariance.IN.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[KVariance.OUT.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String toString(KTypeParameter typeParameter) {
            Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
            StringBuilder $this$toString_u24lambda_u240 = new StringBuilder();
            switch (WhenMappings.$EnumSwitchMapping$0[typeParameter.getVariance().ordinal()]) {
                case 1:
                    Unit unit = Unit.INSTANCE;
                    break;
                case 2:
                    $this$toString_u24lambda_u240.append("in ");
                    break;
                case 3:
                    $this$toString_u24lambda_u240.append("out ");
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            $this$toString_u24lambda_u240.append(typeParameter.getName());
            return $this$toString_u24lambda_u240.toString();
        }
    }
}
