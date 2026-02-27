package ni.shikatu.kotlin.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\r\u001a\u00020\u0006H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u001a"}, d2 = {"Lni/shikatu/kotlin/reflect/ParameterizedTypeImpl;", "Ljava/lang/reflect/ParameterizedType;", "Lni/shikatu/kotlin/reflect/TypeImpl;", "rawType", "Ljava/lang/Class;", "ownerType", "Ljava/lang/reflect/Type;", "typeArguments", "", "<init>", "(Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/util/List;)V", "", "[Ljava/lang/reflect/Type;", "getRawType", "getOwnerType", "getActualTypeArguments", "()[Ljava/lang/reflect/Type;", "getTypeName", "", "equals", "", "other", "", "hashCode", "", "toString", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class ParameterizedTypeImpl implements ParameterizedType, TypeImpl {
    private final Type ownerType;
    private final Class<?> rawType;
    private final Type[] typeArguments;

    public ParameterizedTypeImpl(Class<?> cls, Type ownerType, List<? extends Type> list) {
        Intrinsics.checkNotNullParameter(cls, "rawType");
        Intrinsics.checkNotNullParameter(list, "typeArguments");
        this.rawType = cls;
        this.ownerType = ownerType;
        List<? extends Type> $this$toTypedArray$iv = list;
        this.typeArguments = (Type[]) $this$toTypedArray$iv.toArray(new Type[0]);
    }

    @Override
    public Type getRawType() {
        return this.rawType;
    }

    @Override
    public Type getOwnerType() {
        return this.ownerType;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return this.typeArguments;
    }

    @Override
    public String getTypeName() {
        StringBuilder $this$getTypeName_u24lambda_u240 = new StringBuilder();
        if (this.ownerType != null) {
            $this$getTypeName_u24lambda_u240.append(TypesJVMKt.typeToString(this.ownerType));
            $this$getTypeName_u24lambda_u240.append("$");
            $this$getTypeName_u24lambda_u240.append(this.rawType.getSimpleName());
        } else {
            $this$getTypeName_u24lambda_u240.append(TypesJVMKt.typeToString(this.rawType));
        }
        if (!(this.typeArguments.length == 0)) {
            ArraysKt.joinTo(this.typeArguments, $this$getTypeName_u24lambda_u240, (50 & 2) != 0 ? ", " : null, (50 & 4) != 0 ? "" : "<", (50 & 8) != 0 ? "" : ">", (50 & 16) != 0 ? -1 : 0, (50 & 32) != 0 ? "..." : null, (50 & 64) != 0 ? null : ParameterizedTypeImpl$getTypeName$1$1.INSTANCE);
        }
        return $this$getTypeName_u24lambda_u240.toString();
    }

    public boolean equals(Object other) {
        return (other instanceof ParameterizedType) && Intrinsics.areEqual(this.rawType, ((ParameterizedType) other).getRawType()) && Intrinsics.areEqual(this.ownerType, ((ParameterizedType) other).getOwnerType()) && Arrays.equals(getActualTypeArguments(), ((ParameterizedType) other).getActualTypeArguments());
    }

    public int hashCode() {
        int iHashCode = this.rawType.hashCode();
        Type type = this.ownerType;
        return (iHashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(getActualTypeArguments());
    }

    public String toString() {
        return getTypeName();
    }
}
