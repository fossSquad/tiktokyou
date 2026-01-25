package fake.f;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import okio.ByteString;

public final class e extends Message {
    public static final ProtoAdapter a = new a();

    public static final class a extends ProtoAdapter {
        public a() {
            super(FieldEncoding.LENGTH_DELIMITED, e.class);
        }
    }

    public e() {
        this(ByteString.EMPTY);
    }

    public e(ByteString byteString) {
        super(a, byteString);
    }
}
