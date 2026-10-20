package Z;
import java.lang.reflect.Member;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import ni.shikatu.kotlin.jvm.functions.Function0;

public final class p3 {
    public final  AtomicBoolean a;
    public final  p4 b;
    public final  Function0 c;
    public final  Member d;
    public final  Object[] e;

    public p3(AtomicBoolean atomicBoolean, p4 p4Var, Function0 function0, Member member, Object[] objArr) {
        this.a = atomicBoolean;
        this.b = p4Var;
        this.c = function0;
        this.d = member;
        this.e = objArr;
    }

    public final void a() {
        if (this.a.compareAndSet(false, true)) {
            AtomicLong atomicLong = r4.a;
            r4.a(Long.valueOf(this.b.a));
            ThreadLocal threadLocal = v3.a;
            v3.a((o3) null, this.b, this.d, this.e);
        }
    }
}
