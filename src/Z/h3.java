package Z;
import java.lang.reflect.Member;
import java.util.concurrent.atomic.AtomicLong;

public final class h3 {
    public final  a4 a;
    public final  b3 b;
    public final  Member c;
    public final  Object[] d;

    public h3(b3 b3Var, a4 a4Var, Member member, Object[] objArr) {
        this.a = a4Var;
        this.b = b3Var;
        this.c = member;
        this.d = objArr;
    }

    public final void a() {
        if (this.b == null) {
            AtomicLong atomicLong = c4.a;
            c4.a(this.a);
            return;
        }
        h6.a(4, h6.a("DASH failed, starting progressive fallback source=%s", new Object[]{this.b.b}), (Throwable) null);
        ThreadLocal threadLocal = i3.a;
        i3.a(this.b, this.a, this.c, this.d);
    }
}
