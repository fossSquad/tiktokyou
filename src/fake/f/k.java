package fake.f;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import okio.ByteString;

public final class k extends Message {
    public static final ProtoAdapter a = new a();

    public static final class a extends ProtoAdapter {
        public a() {
            super(FieldEncoding.LENGTH_DELIMITED, k.class);
        }
    }

    public k() {
        this(ByteString.EMPTY);
    }

    public k(ByteString byteString) {
        super(a, byteString);
    }
}
