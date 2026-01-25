package fake.f;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import okio.ByteString;

public final class m extends Message {
    public static final ProtoAdapter e = new a();
    public Long a;
    public String b;
    public String c;
    public ByteString d;

    public static final class a extends ProtoAdapter {
        public a() {
            super(FieldEncoding.LENGTH_DELIMITED, m.class);
        }
    }

    public m(Long l, String str, String str2, ByteString byteString) {
        this(l, str, str2, byteString, ByteString.EMPTY);
    }

    public m(Long l, String str, String str2, ByteString byteString, ByteString byteString2) {
        super(e, byteString2);
        this.a = l;
        this.b = str;
        this.c = str2;
        this.d = byteString;
    }
}
