package fake.f;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import okio.ByteString;

public final class l extends Message {
    public static final ProtoAdapter c = new a();
    public Long a;
    public String b;

    public static final class a extends ProtoAdapter {
        public a() {
            super(FieldEncoding.LENGTH_DELIMITED, l.class);
        }
    }

    public l(Long l, String str) {
        this(l, str, ByteString.EMPTY);
    }

    public l(Long l, String str, ByteString byteString) {
        super(c, byteString);
        this.a = l;
        this.b = str;
    }
}
