package Z;
import java.lang.reflect.Member;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import ni.shikatu.kotlin.jvm.functions.Function0;

public final class c3 {
    public final  AtomicBoolean a;
    public final  a4 b;
    public final  Function0 c;
    public final  Member d;
    public final  Object[] e;

    public c3(AtomicBoolean atomicBoolean, a4 a4Var, Function0 function0, Member member, Object[] objArr) {
        this.a = atomicBoolean;
        this.b = a4Var;
        this.c = function0;
        this.d = member;
        this.e = objArr;
    }

    public final void a(b3 b3Var) {
        if (this.a.compareAndSet(false, true)) {
            ThreadLocal threadLocal = i3.a;
            i3.a(this.b, b3Var, (List) this.c.invoke(), this.d, this.e);
        }
    }

    public final void a() {
        if (this.a.compareAndSet(false, true)) {
            AtomicLong atomicLong = c4.a;
            c4.a(Long.valueOf(this.b.a));
            ThreadLocal threadLocal = i3.a;
            i3.a((b3) null, this.b, this.d, this.e);
        }
    }
}
