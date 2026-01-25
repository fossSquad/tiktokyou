package fake.f;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import okio.ByteString;

public final class a extends Message {
    public static final ProtoAdapter a = new C0000a();

    public static final class C0000a extends ProtoAdapter {
        public C0000a() {
            super(FieldEncoding.LENGTH_DELIMITED, a.class);
        }
    }

    public a() {
        this(ByteString.EMPTY);
    }

    public a(ByteString byteString) {
        super(a, byteString);
    }
}
