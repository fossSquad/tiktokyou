package fake.f;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import okio.ByteString;

public final class n extends Message {
    public static final ProtoAdapter d = new a();
    public Long a;
    public String b;
    public String c;

    public static final class a extends ProtoAdapter {
        public a() {
            super(FieldEncoding.LENGTH_DELIMITED, n.class);
        }
    }

    public n(Long l, String str, String str2) {
        this(l, str, str2, ByteString.EMPTY);
    }

    public n(Long l, String str, String str2, ByteString byteString) {
        super(d, byteString);
        this.a = l;
        this.b = str;
        this.c = str2;
    }
}
