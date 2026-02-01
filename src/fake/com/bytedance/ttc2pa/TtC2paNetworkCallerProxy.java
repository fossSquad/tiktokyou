package fake.com.bytedance.ttc2pa;

import com.squareup.wire.ProtoAdapter;
import fake.a.i;
import fake.d.b;
import fake.d.c;
import fake.f.d;
import fake.f.f;
import java.util.Map;

public final class TtC2paNetworkCallerProxy implements TtC2paNetworkCaller, MoltenFFICallback {
    public static final Companion Companion = new Companion();
    public final TtC2paNetworkCaller callbackObj;

    public static final class Companion {
        public Companion() {
        }

        public  Companion(b bVar) {
            this();
        }

        public final long obtain(TtC2paNetworkCaller ttC2paNetworkCaller) {
            c.b(ttC2paNetworkCaller, "callback");
            return CallbackInstance.INSTANCE.registerInstance(new TtC2paNetworkCallerProxy(ttC2paNetworkCaller));
        }
    }

    public TtC2paNetworkCallerProxy(TtC2paNetworkCaller ttC2paNetworkCaller) {
        this.callbackObj = ttC2paNetworkCaller;
    }

    public  TtC2paNetworkCallerProxy(TtC2paNetworkCaller ttC2paNetworkCaller, b bVar) {
        this(ttC2paNetworkCaller);
    }

    private final BufferCallStatus invokeDoPostXabccf1e3b2baee25(RustBuffer.ByValue byValue) {
        byte[] bArrDestroyToByteArray$ttc2pa_release = RustBuffer.Companion.destroyToByteArray$ttc2pa_release(byValue);
        ProtoAdapter protoAdapter = d.a;
        c.a(bArrDestroyToByteArray$ttc2pa_release);
        Object objDecode = protoAdapter.decode(bArrDestroyToByteArray$ttc2pa_release);
        new BufferCallStatus(0, null, 3, null);
        try {
            objDecode.getClass();
            c.a((Object) null, "p.url");
            throw null;
        } catch (Exception unused) {
            return BufferCallStatus.Companion.error(RustBuffer.Companion.create$ttc2pa_release(0));
        }
    }

    private final BufferCallStatus invokeOnRemoteSignXcb6cefa627f90053(RustBuffer.ByValue byValue) {
        byte[] bArrDestroyToByteArray$ttc2pa_release = RustBuffer.Companion.destroyToByteArray$ttc2pa_release(byValue);
        ProtoAdapter protoAdapter = f.a;
        c.a(bArrDestroyToByteArray$ttc2pa_release);
        Object objDecode = protoAdapter.decode(bArrDestroyToByteArray$ttc2pa_release);
        new BufferCallStatus(0, null, 3, null);
        try {
            objDecode.getClass();
            throw null;
        } catch (Exception unused) {
            return BufferCallStatus.Companion.error(RustBuffer.Companion.create$ttc2pa_release(0));
        }
    }

    @Override
    public TtC2paNetworkResponse doPost(String str, Map map, byte[] bArr, long j, boolean z) {
        c.b(str, "url");
        c.b(map, "headers");
        c.b(bArr, "body");
        return this.callbackObj.doPost(str, map, bArr, j, z);
    }

    @Override
    public TtC2paNetworkCaller getCallbackObj() {
        return this.callbackObj;
    }

    @Override
    public BufferCallStatus onInvoke(long j, long j2, RustBuffer.ByValue byValue) {
        c.b(byValue, "params");
        boolean z = j == -3223723316326955298L;
        if (!i.a || z) {
            if (j2 == -6067208637716435419L) {
                return invokeDoPostXabccf1e3b2baee25(byValue);
            }
            return j2 == -3788389689611190189L ? invokeOnRemoteSignXcb6cefa627f90053(byValue) : new BufferCallStatus(0, null, 3, null);
        }
        throw new AssertionError("Unmatched typeId: " + j + " in TtC2paNetworkCaller");
    }

    @Override
    public TtC2paNetworkResponse onRemoteSign(byte[] bArr) {
        c.b(bArr, "requestBody");
        return this.callbackObj.onRemoteSign(bArr);
    }
}
