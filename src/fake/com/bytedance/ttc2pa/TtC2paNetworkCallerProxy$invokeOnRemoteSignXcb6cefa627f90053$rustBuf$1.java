package fake.com.bytedance.ttc2pa;

import fake.a.h;
import fake.c.b;
import fake.d.c;
import fake.d.d;
import fake.f.g;
import java.io.OutputStream;

public final class TtC2paNetworkCallerProxy$invokeOnRemoteSignXcb6cefa627f90053$rustBuf$1 extends d implements b {
    public final  g $ret;

    public TtC2paNetworkCallerProxy$invokeOnRemoteSignXcb6cefa627f90053$rustBuf$1(g gVar) {
        super(1);
        this.$ret = gVar;
    }

    @Override
    public /* bridge */  Object invoke(Object obj) {
        invoke((OutputStream) obj);
        return h.a;
    }

    public final void invoke(OutputStream outputStream) {
        c.b(outputStream, "it");
        this.$ret.encode(outputStream);
    }
}
