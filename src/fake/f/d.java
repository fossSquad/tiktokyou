package fake.f;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;

public final class d extends Message {
    public static final ProtoAdapter a = new a();

    public static final class a extends ProtoAdapter {
        public a() {
            super(FieldEncoding.LENGTH_DELIMITED, d.class);
            ProtoAdapter protoAdapter = ProtoAdapter.STRING;
            ProtoAdapter.newMapAdapter(protoAdapter, protoAdapter);
        }
    }
}
