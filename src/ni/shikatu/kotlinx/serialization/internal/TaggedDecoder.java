package ni.shikatu.kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.List;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Reflection;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.InternalSerializationApi;
import ni.shikatu.kotlinx.serialization.SerializationException;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.encoding.CompositeDecoder;
import ni.shikatu.kotlinx.serialization.encoding.Decoder;
import ni.shikatu.kotlinx.serialization.modules.SerializersModule;
import ni.shikatu.kotlinx.serialization.modules.SerializersModuleBuildersKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b'\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u00032\u00020\u0004B\t\bF¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u000b\u001a\u00028\u0000*\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH¤\u0080\u0004¢\u0006\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00028\u0000H\u0094\u0080\u0004¢\u0006\u0002\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00028\u0000H\u0094\u0080\u0004¢\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0011\u001a\u00028\u0000H\u0094\u0080\u0004¢\u0006\u0002\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00028\u0000H\u0094\u0080\u0004¢\u0006\u0002\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00028\u0000H\u0094\u0080\u0004¢\u0006\u0002\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00028\u0000H\u0094\u0080\u0004¢\u0006\u0002\u0010\u001fJ\u0017\u0010 \u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00028\u0000H\u0094\u0080\u0004¢\u0006\u0002\u0010!J\u0017\u0010\"\u001a\u00020#2\u0006\u0010\u0011\u001a\u00028\u0000H\u0094\u0080\u0004¢\u0006\u0002\u0010$J\u0017\u0010%\u001a\u00020&2\u0006\u0010\u0011\u001a\u00028\u0000H\u0094\u0080\u0004¢\u0006\u0002\u0010'J\u0017\u0010(\u001a\u00020)2\u0006\u0010\u0011\u001a\u00028\u0000H\u0094\u0080\u0004¢\u0006\u0002\u0010*J\u0017\u0010+\u001a\u00020,2\u0006\u0010\u0011\u001a\u00028\u0000H\u0094\u0080\u0004¢\u0006\u0002\u0010-J\u0017\u0010.\u001a\u00020/2\u0006\u0010\u0011\u001a\u00028\u0000H\u0094\u0080\u0004¢\u0006\u0002\u00100J\u001f\u00101\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u00102\u001a\u00020\fH\u0094\u0080\u0004¢\u0006\u0002\u00103J\u001f\u00104\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u00105\u001a\u00020\fH\u0094\u0080\u0004¢\u0006\u0002\u00106J3\u00107\u001a\u0002H8\"\n\b\u0001\u00108*\u0004\u0018\u00010\u00022\f\u00109\u001a\b\u0012\u0004\u0012\u0002H80:2\b\u0010;\u001a\u0004\u0018\u0001H8H\u0094\u0080\u0004¢\u0006\u0002\u0010<J\u0012\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\fH\u0096\u0080\u0004J\n\u0010?\u001a\u00020\u0014H\u0096\u0080\u0004J\f\u0010@\u001a\u0004\u0018\u00010\u0017H\u0086\u0080\u0004J\n\u0010A\u001a\u00020\u0014H\u0086\u0080\u0004J\n\u0010B\u001a\u00020\u001bH\u0086\u0080\u0004J\n\u0010C\u001a\u00020\u001eH\u0086\u0080\u0004J\n\u0010D\u001a\u00020\u000eH\u0086\u0080\u0004J\n\u0010E\u001a\u00020#H\u0086\u0080\u0004J\n\u0010F\u001a\u00020&H\u0086\u0080\u0004J\n\u0010G\u001a\u00020)H\u0086\u0080\u0004J\n\u0010H\u001a\u00020,H\u0086\u0080\u0004J\n\u0010I\u001a\u00020/H\u0086\u0080\u0004J\u0012\u0010J\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\fH\u0086\u0080\u0004J\u0012\u0010K\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\fH\u0096\u0080\u0004J\u0012\u0010L\u001a\u00020M2\u0006\u0010>\u001a\u00020\fH\u0096\u0080\u0004J\u001a\u0010N\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0080\u0004J\u001a\u0010O\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0080\u0004J\u001a\u0010P\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0080\u0004J\u001a\u0010Q\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0080\u0004J\u001a\u0010R\u001a\u00020#2\u0006\u0010>\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0080\u0004J\u001a\u0010S\u001a\u00020&2\u0006\u0010>\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0080\u0004J\u001a\u0010T\u001a\u00020)2\u0006\u0010>\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0080\u0004J\u001a\u0010U\u001a\u00020,2\u0006\u0010>\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0080\u0004J\u001a\u0010V\u001a\u00020/2\u0006\u0010>\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0080\u0004J\u001a\u0010W\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0080\u0004JC\u0010X\u001a\u0002H8\"\n\b\u0001\u00108*\u0004\u0018\u00010\u00022\u0006\u0010>\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u00109\u001a\b\u0012\u0004\u0012\u0002H80:2\b\u0010;\u001a\u0004\u0018\u0001H8H\u0086\u0080\u0004¢\u0006\u0002\u0010YJE\u0010Z\u001a\u0004\u0018\u0001H8\"\b\b\u0001\u00108*\u00020\u00022\u0006\u0010>\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H80:2\b\u0010;\u001a\u0004\u0018\u0001H8H\u0086\u0080\u0004¢\u0006\u0002\u0010YJ+\u0010[\u001a\u0002H\\\"\u0004\b\u0001\u0010\\2\u0006\u0010\u0011\u001a\u00028\u00002\f\u0010]\u001a\b\u0012\u0004\u0012\u0002H\\0^H\u0082\u0080\u0004¢\u0006\u0002\u0010_J\u0017\u0010j\u001a\u00020M2\u0006\u0010k\u001a\u00028\u0000H\u0084\u0080\u0004¢\u0006\u0002\u0010lJ\u0018\u0010m\u001a\u00020M2\f\u0010n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0084\u0080\u0004J\u000f\u0010p\u001a\u00028\u0000H\u0085\u0080\b¢\u0006\u0002\u0010gR\u0015\u0010\u0007\u001a\u00020\b8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\t\u0010\nR%\u0010`\u001a\u0012\u0012\u0004\u0012\u00028\u00000aj\b\u0012\u0004\u0012\u00028\u0000`bX\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u0015\u0010e\u001a\u00028\u00008DX\u0084\u0084\b¢\u0006\u0006\u001a\u0004\bf\u0010gR\u0017\u0010h\u001a\u0004\u0018\u00018\u00008DX\u0084\u0084\b¢\u0006\u0006\u001a\u0004\bi\u0010gR\u000f\u0010o\u001a\u00020\u0014X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006q"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/TaggedDecoder;", "Tag", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/encoding/Decoder;", "Lni/shikatu/kotlinx/serialization/encoding/CompositeDecoder;", "<init>", "()V", "serializersModule", "Lni/shikatu/kotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "getTag", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "index", _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/Object;", "decodeTaggedValue", "tag", "(Ljava/lang/Object;)Ljava/lang/Object;", "decodeTaggedNotNullMark", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/Object;)Z", "decodeTaggedNull", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/Object;)Ljava/lang/Void;", "decodeTaggedBoolean", "decodeTaggedByte", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/Object;)B", "decodeTaggedShort", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/Object;)S", "decodeTaggedInt", "(Ljava/lang/Object;)I", "decodeTaggedLong", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/Object;)J", "decodeTaggedFloat", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/Object;)F", "decodeTaggedDouble", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/Object;)D", "decodeTaggedChar", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/Object;)C", "decodeTaggedString", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/Object;)Ljava/lang/String;", "decodeTaggedEnum", "enumDescriptor", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "decodeTaggedInline", "inlineDescriptor", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "decodeSerializableValue", "T", "deserializer", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "previousValue", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeInline", "descriptor", "decodeNotNullMark", "decodeNull", "decodeBoolean", "decodeByte", "decodeShort", "decodeInt", "decodeLong", "decodeFloat", "decodeDouble", "decodeChar", "decodeString", "decodeEnum", "beginStructure", "endStructure", _UrlKt.FRAGMENT_ENCODE_SET, "decodeBooleanElement", "decodeByteElement", "decodeShortElement", "decodeIntElement", "decodeLongElement", "decodeFloatElement", "decodeDoubleElement", "decodeCharElement", "decodeStringElement", "decodeInlineElement", "decodeSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeNullableSerializableElement", "tagBlock", "E", "block", "Lni/shikatu/kotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "tagStack", "Ljava/util/ArrayList;", "Lni/shikatu/kotlin/collections/ArrayList;", "getTagStack$kotlinx_serialization_core", "()Ljava/util/ArrayList;", "currentTag", "getCurrentTag", "()Ljava/lang/Object;", "currentTagOrNull", "getCurrentTagOrNull", "pushTag", "name", "(Ljava/lang/Object;)V", "copyTagsTo", "other", "flag", "popTag", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
@InternalSerializationApi
public abstract class TaggedDecoder<Tag> implements Decoder, CompositeDecoder {
    private boolean flag;
    private final ArrayList<Tag> tagStack = new ArrayList<>();

    protected abstract Tag getTag(SerialDescriptor serialDescriptor, int i);

    @Override
    public SerializersModule getSerializersModule() {
        return SerializersModuleBuildersKt.EmptySerializersModule();
    }

    protected Object decodeTaggedValue(Tag tag) {
        throw new SerializationException(Reflection.getOrCreateKotlinClass(getClass()) + " can't retrieve untyped values");
    }

    protected boolean decodeTaggedNotNullMark(Tag tag) {
        return true;
    }

    protected Void decodeTaggedNull(Tag tag) {
        return null;
    }

    protected boolean decodeTaggedBoolean(Tag tag) {
        Object objDecodeTaggedValue = decodeTaggedValue(tag);
        Intrinsics.checkNotNull(objDecodeTaggedValue, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) objDecodeTaggedValue).booleanValue();
    }

    protected byte decodeTaggedByte(Tag tag) {
        Object objDecodeTaggedValue = decodeTaggedValue(tag);
        Intrinsics.checkNotNull(objDecodeTaggedValue, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte) objDecodeTaggedValue).byteValue();
    }

    protected short decodeTaggedShort(Tag tag) {
        Object objDecodeTaggedValue = decodeTaggedValue(tag);
        Intrinsics.checkNotNull(objDecodeTaggedValue, "null cannot be cast to non-null type kotlin.Short");
        return ((Short) objDecodeTaggedValue).shortValue();
    }

    protected int decodeTaggedInt(Tag tag) {
        Object objDecodeTaggedValue = decodeTaggedValue(tag);
        Intrinsics.checkNotNull(objDecodeTaggedValue, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objDecodeTaggedValue).intValue();
    }

    protected long decodeTaggedLong(Tag tag) {
        Object objDecodeTaggedValue = decodeTaggedValue(tag);
        Intrinsics.checkNotNull(objDecodeTaggedValue, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) objDecodeTaggedValue).longValue();
    }

    protected float decodeTaggedFloat(Tag tag) {
        Object objDecodeTaggedValue = decodeTaggedValue(tag);
        Intrinsics.checkNotNull(objDecodeTaggedValue, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) objDecodeTaggedValue).floatValue();
    }

    protected double decodeTaggedDouble(Tag tag) {
        Object objDecodeTaggedValue = decodeTaggedValue(tag);
        Intrinsics.checkNotNull(objDecodeTaggedValue, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) objDecodeTaggedValue).doubleValue();
    }

    protected char decodeTaggedChar(Tag tag) {
        Object objDecodeTaggedValue = decodeTaggedValue(tag);
        Intrinsics.checkNotNull(objDecodeTaggedValue, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) objDecodeTaggedValue).charValue();
    }

    protected String decodeTaggedString(Tag tag) {
        Object objDecodeTaggedValue = decodeTaggedValue(tag);
        Intrinsics.checkNotNull(objDecodeTaggedValue, "null cannot be cast to non-null type kotlin.String");
        return (String) objDecodeTaggedValue;
    }

    protected int decodeTaggedEnum(Tag tag, SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        Object objDecodeTaggedValue = decodeTaggedValue(tag);
        Intrinsics.checkNotNull(objDecodeTaggedValue, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objDecodeTaggedValue).intValue();
    }

    protected Decoder decodeTaggedInline(Tag tag, SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        pushTag(tag);
        return this;
    }

    public <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializationStrategy, T t) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return (T) decodeSerializableValue(deserializationStrategy);
    }

    @Override
    public Decoder decodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedInline(popTag(), descriptor);
    }

    @Override
    public boolean decodeNotNullMark() {
        Tag currentTagOrNull = getCurrentTagOrNull();
        if (currentTagOrNull == null) {
            return false;
        }
        return decodeTaggedNotNullMark(currentTagOrNull);
    }

    @Override
    public final Void decodeNull() {
        return null;
    }

    @Override
    public final boolean decodeBoolean() {
        return decodeTaggedBoolean(popTag());
    }

    @Override
    public final byte decodeByte() {
        return decodeTaggedByte(popTag());
    }

    @Override
    public final short decodeShort() {
        return decodeTaggedShort(popTag());
    }

    @Override
    public final int decodeInt() {
        return decodeTaggedInt(popTag());
    }

    @Override
    public final long decodeLong() {
        return decodeTaggedLong(popTag());
    }

    @Override
    public final float decodeFloat() {
        return decodeTaggedFloat(popTag());
    }

    @Override
    public final double decodeDouble() {
        return decodeTaggedDouble(popTag());
    }

    @Override
    public final char decodeChar() {
        return decodeTaggedChar(popTag());
    }

    @Override
    public final String decodeString() {
        return decodeTaggedString(popTag());
    }

    @Override
    public final int decodeEnum(SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return decodeTaggedEnum(popTag(), enumDescriptor);
    }

    @Override
    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    @Override
    public void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @Override
    public final boolean decodeBooleanElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedBoolean(getTag(descriptor, index));
    }

    @Override
    public final byte decodeByteElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedByte(getTag(descriptor, index));
    }

    @Override
    public final short decodeShortElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedShort(getTag(descriptor, index));
    }

    @Override
    public final int decodeIntElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedInt(getTag(descriptor, index));
    }

    @Override
    public final long decodeLongElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedLong(getTag(descriptor, index));
    }

    @Override
    public final float decodeFloatElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedFloat(getTag(descriptor, index));
    }

    @Override
    public final double decodeDoubleElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedDouble(getTag(descriptor, index));
    }

    @Override
    public final char decodeCharElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedChar(getTag(descriptor, index));
    }

    @Override
    public final String decodeStringElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedString(getTag(descriptor, index));
    }

    @Override
    public final Decoder decodeInlineElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedInline(getTag(descriptor, index), descriptor.getElementDescriptor(index));
    }

    @Override
    public final <T> T decodeSerializableElement(SerialDescriptor serialDescriptor, int i, final DeserializationStrategy<? extends T> deserializationStrategy, final T t) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return (T) tagBlock(getTag(serialDescriptor, i), new Function0() {
            @Override
            public final Object invoke() {
                return this.f$0.decodeSerializableValue(deserializationStrategy, t);
            }
        });
    }

    @Override
    public final <T> T decodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i, final DeserializationStrategy<? extends T> deserializationStrategy, final T t) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return (T) tagBlock(getTag(serialDescriptor, i), new Function0() {
            @Override
            public final Object invoke() {
                return TaggedDecoder.decodeNullableSerializableElement$lambda$0(this.f$0, deserializationStrategy, t);
            }
        });
    }

    public static final Object decodeNullableSerializableElement$lambda$0(TaggedDecoder this$0, DeserializationStrategy $deserializer, Object $previousValue) {
        TaggedDecoder $this$decodeIfNullable$iv = this$0;
        boolean isNullabilitySupported$iv = $deserializer.getDescriptor().isNullable();
        return (isNullabilitySupported$iv || $this$decodeIfNullable$iv.decodeNotNullMark()) ? this$0.decodeSerializableValue($deserializer, $previousValue) : $this$decodeIfNullable$iv.decodeNull();
    }

    private final <E> E tagBlock(Tag tag, Function0<? extends E> function0) {
        pushTag(tag);
        E eInvoke = function0.invoke();
        if (!this.flag) {
            popTag();
        }
        this.flag = false;
        return eInvoke;
    }

    public final ArrayList<Tag> getTagStack$kotlinx_serialization_core() {
        return this.tagStack;
    }

    protected final Tag getCurrentTag() {
        return (Tag) CollectionsKt.last((List) this.tagStack);
    }

    protected final Tag getCurrentTagOrNull() {
        return (Tag) CollectionsKt.lastOrNull((List) this.tagStack);
    }

    protected final void pushTag(Tag tag) {
        this.tagStack.add(tag);
    }

    protected final void copyTagsTo(TaggedDecoder<Tag> taggedDecoder) {
        Intrinsics.checkNotNullParameter(taggedDecoder, "other");
        taggedDecoder.tagStack.addAll(this.tagStack);
    }

    @IgnorableReturnValue
    protected final Tag popTag() {
        Tag tagRemove = this.tagStack.remove(CollectionsKt.getLastIndex(this.tagStack));
        this.flag = true;
        return tagRemove;
    }
}
