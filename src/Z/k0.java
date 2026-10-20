package Z;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class k0 implements l0 {
    public final String a;

    public k0(String str) {
        this.a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k0) && Intrinsics.areEqual(this.a, ((k0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return ve.a("B/1rWIWrgIYGLsr03Y9Jwouwtv1RRYZNFAmvMlVSfTcTJ+b8LM74wSqLOj96HygH", "2KVdOhyHh98RvUCC", "aes", new StringBuilder(), this.a).append(")").toString();
    }
}
