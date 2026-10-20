package Z;
import java.lang.reflect.Member;
import java.util.concurrent.atomic.AtomicLong;

public final class u3 {
    public final  p4 a;
    public final  o3 b;
    public final  Member c;
    public final  Object[] d;

    public u3(o3 o3Var, p4 p4Var, Member member, Object[] objArr) {
        this.a = p4Var;
        this.b = o3Var;
        this.c = member;
        this.d = objArr;
    }

    public final void a() {
        if (this.b == null) {
            AtomicLong atomicLong = r4.a;
            r4.a(this.a);
            return;
        }
        g7.a(4, g7.a("DASH failed, starting progressive fallback source=%s", new Object[]{this.b.b}), (Throwable) null);
        ThreadLocal threadLocal = v3.a;
        v3.a(this.b, this.a, this.c, this.d);
    }
}
