package ni.shikatu.kotlin.jvm.internal;

import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.NoWhenBranchMatchedException;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.reflect.KType;
import ni.shikatu.kotlin.reflect.KTypeParameter;
import ni.shikatu.kotlin.reflect.KVariance;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0019\u001a\u00020\u001a2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Lni/shikatu/kotlin/jvm/internal/TypeParameterReference;", "Lni/shikatu/kotlin/reflect/KTypeParameter;", "container", "", "name", "", "variance", "Lni/shikatu/kotlin/reflect/KVariance;", "isReified", "", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/reflect/KVariance;Z)V", "getName", "()Ljava/lang/String;", "getVariance", "()Lkotlin/reflect/KVariance;", "()Z", "bounds", "", "Lni/shikatu/kotlin/reflect/KType;", "upperBounds", "getUpperBounds$annotations", "()V", "getUpperBounds", "()Ljava/util/List;", "setUpperBounds", "", "equals", "other", "hashCode", "", "toString", "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TypeParameterReference implements KTypeParameter {
    public static final Companion Companion = new Companion(null);
    private volatile List<? extends KType> bounds;
    private final Object container;
    private final boolean isReified;
    private final String name;
    private final KVariance variance;

    public static  void getUpperBounds$annotations() {
    }

    public TypeParameterReference(Object container, String name, KVariance variance, boolean isReified) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(variance, "variance");
        this.container = container;
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

    public boolean equals(Object other) {
        return (other instanceof TypeParameterReference) && Intrinsics.areEqual(this.container, ((TypeParameterReference) other).container) && Intrinsics.areEqual(getName(), ((TypeParameterReference) other).getName());
    }

    public int hashCode() {
        Object obj = this.container;
        return ((obj != null ? obj.hashCode() : 0) * 31) + getName().hashCode();
    }

    public String toString() {
        return Companion.toString(this);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lni/shikatu/kotlin/jvm/internal/TypeParameterReference$Companion;", "", "<init>", "()V", "toString", "", "typeParameter", "Lni/shikatu/kotlin/reflect/KTypeParameter;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public  class WhenMappings {
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
