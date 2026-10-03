package ni.shikatu.okhttp3.internal.http2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ni.shikatu.kotlin.KotlinVersion;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.IntCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.BufferedSource;
import ni.shikatu.okio.ByteString;
import ni.shikatu.okio.Okio;
import ni.shikatu.okio.Source;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u0012H\u0002J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Hpack;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "PREFIX_4_BITS", _UrlKt.FRAGMENT_ENCODE_SET, "PREFIX_5_BITS", "PREFIX_6_BITS", "PREFIX_7_BITS", "SETTINGS_HEADER_TABLE_SIZE", "SETTINGS_HEADER_TABLE_SIZE_LIMIT", "STATIC_HEADER_TABLE", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/internal/http2/Header;", "getSTATIC_HEADER_TABLE", "()[Lokhttp3/internal/http2/Header;", "[Lni/shikatu/okhttp3/internal/http2/Header;", "NAME_TO_FIRST_INDEX", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okio/ByteString;", "getNAME_TO_FIRST_INDEX", "()Ljava/util/Map;", "nameToFirstIndex", "checkLowercase", "name", "Reader", "Writer", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Hpack {
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    public static final Hpack INSTANCE = new Hpack();
    private static final Header[] STATIC_HEADER_TABLE = {new Header(Header.TARGET_AUTHORITY, _UrlKt.FRAGMENT_ENCODE_SET), new Header(Header.TARGET_METHOD, "GET"), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", _UrlKt.FRAGMENT_ENCODE_SET), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", _UrlKt.FRAGMENT_ENCODE_SET), new Header("accept-ranges", _UrlKt.FRAGMENT_ENCODE_SET), new Header("accept", _UrlKt.FRAGMENT_ENCODE_SET), new Header("access-control-allow-origin", _UrlKt.FRAGMENT_ENCODE_SET), new Header("age", _UrlKt.FRAGMENT_ENCODE_SET), new Header("allow", _UrlKt.FRAGMENT_ENCODE_SET), new Header("authorization", _UrlKt.FRAGMENT_ENCODE_SET), new Header("cache-control", _UrlKt.FRAGMENT_ENCODE_SET), new Header("content-disposition", _UrlKt.FRAGMENT_ENCODE_SET), new Header("content-encoding", _UrlKt.FRAGMENT_ENCODE_SET), new Header("content-language", _UrlKt.FRAGMENT_ENCODE_SET), new Header("content-length", _UrlKt.FRAGMENT_ENCODE_SET), new Header("content-location", _UrlKt.FRAGMENT_ENCODE_SET), new Header("content-range", _UrlKt.FRAGMENT_ENCODE_SET), new Header("content-type", _UrlKt.FRAGMENT_ENCODE_SET), new Header("cookie", _UrlKt.FRAGMENT_ENCODE_SET), new Header("date", _UrlKt.FRAGMENT_ENCODE_SET), new Header("etag", _UrlKt.FRAGMENT_ENCODE_SET), new Header("expect", _UrlKt.FRAGMENT_ENCODE_SET), new Header("expires", _UrlKt.FRAGMENT_ENCODE_SET), new Header("from", _UrlKt.FRAGMENT_ENCODE_SET), new Header("host", _UrlKt.FRAGMENT_ENCODE_SET), new Header("if-match", _UrlKt.FRAGMENT_ENCODE_SET), new Header("if-modified-since", _UrlKt.FRAGMENT_ENCODE_SET), new Header("if-none-match", _UrlKt.FRAGMENT_ENCODE_SET), new Header("if-range", _UrlKt.FRAGMENT_ENCODE_SET), new Header("if-unmodified-since", _UrlKt.FRAGMENT_ENCODE_SET), new Header("last-modified", _UrlKt.FRAGMENT_ENCODE_SET), new Header("link", _UrlKt.FRAGMENT_ENCODE_SET), new Header("location", _UrlKt.FRAGMENT_ENCODE_SET), new Header("max-forwards", _UrlKt.FRAGMENT_ENCODE_SET), new Header("proxy-authenticate", _UrlKt.FRAGMENT_ENCODE_SET), new Header("proxy-authorization", _UrlKt.FRAGMENT_ENCODE_SET), new Header("range", _UrlKt.FRAGMENT_ENCODE_SET), new Header("referer", _UrlKt.FRAGMENT_ENCODE_SET), new Header("refresh", _UrlKt.FRAGMENT_ENCODE_SET), new Header("retry-after", _UrlKt.FRAGMENT_ENCODE_SET), new Header("server", _UrlKt.FRAGMENT_ENCODE_SET), new Header("set-cookie", _UrlKt.FRAGMENT_ENCODE_SET), new Header("strict-transport-security", _UrlKt.FRAGMENT_ENCODE_SET), new Header("transfer-encoding", _UrlKt.FRAGMENT_ENCODE_SET), new Header("user-agent", _UrlKt.FRAGMENT_ENCODE_SET), new Header("vary", _UrlKt.FRAGMENT_ENCODE_SET), new Header("via", _UrlKt.FRAGMENT_ENCODE_SET), new Header("www-authenticate", _UrlKt.FRAGMENT_ENCODE_SET)};
    private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX = INSTANCE.nameToFirstIndex();

    private Hpack() {
    }

    public final Header[] getSTATIC_HEADER_TABLE() {
        return STATIC_HEADER_TABLE;
    }

    public final Map<ByteString, Integer> getNAME_TO_FIRST_INDEX() {
        return NAME_TO_FIRST_INDEX;
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014J\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u0006\u0010\u001a\u001a\u00020\u0016J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0005H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0018\u0010'\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u000bH\u0002J\b\u0010)\u001a\u00020\u0005H\u0002J\u0016\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005J\u0006\u0010-\u001a\u00020$R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Hpack$Reader;", _UrlKt.FRAGMENT_ENCODE_SET, "source", "Lni/shikatu/okio/Source;", "headerTableSizeSetting", _UrlKt.FRAGMENT_ENCODE_SET, "maxDynamicTableByteCount", "<init>", "(Lokio/Source;II)V", "headerList", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/internal/http2/Header;", "Lni/shikatu/okio/BufferedSource;", "dynamicTable", _UrlKt.FRAGMENT_ENCODE_SET, "[Lni/shikatu/okhttp3/internal/http2/Header;", "nextHeaderIndex", "headerCount", "dynamicTableByteCount", "getAndResetHeaderList", _UrlKt.FRAGMENT_ENCODE_SET, "adjustDynamicTableByteCount", _UrlKt.FRAGMENT_ENCODE_SET, "clearDynamicTable", "evictToRecoverBytes", "bytesToRecover", "readHeaders", "readIndexedHeader", "index", "dynamicTableIndex", "readLiteralHeaderWithoutIndexingIndexedName", "readLiteralHeaderWithoutIndexingNewName", "readLiteralHeaderWithIncrementalIndexingIndexedName", "nameIndex", "readLiteralHeaderWithIncrementalIndexingNewName", "getName", "Lni/shikatu/okio/ByteString;", "isStaticHeader", _UrlKt.FRAGMENT_ENCODE_SET, "insertIntoDynamicTable", "entry", "readByte", "readInt", "firstByte", "prefixMask", "readByteString", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Reader {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        public int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final BufferedSource source;

        public Reader(Source source, int i) {
            this(source, i, 0, 4, null);
            Intrinsics.checkNotNullParameter(source, "source");
        }

        public Reader(Source source, int headerTableSizeSetting, int maxDynamicTableByteCount) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.headerTableSizeSetting = headerTableSizeSetting;
            this.maxDynamicTableByteCount = maxDynamicTableByteCount;
            this.headerList = new ArrayList();
            this.source = Okio.buffer(source);
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = this.dynamicTable.length - 1;
        }

        public  Reader(Source source, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(source, i, (i3 & 4) != 0 ? i : i2);
        }

        public final List<Header> getAndResetHeaderList() {
            List<Header> list = CollectionsKt.toList(this.headerList);
            this.headerList.clear();
            return list;
        }

        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        private final void adjustDynamicTableByteCount() {
            if (this.maxDynamicTableByteCount < this.dynamicTableByteCount) {
                if (this.maxDynamicTableByteCount == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(this.dynamicTableByteCount - this.maxDynamicTableByteCount);
                }
            }
        }

        private final void clearDynamicTable() {
            ArraysKt.fill$default(this.dynamicTable, (Object) null, 0, 0, 6, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int evictToRecoverBytes(int bytesToRecover) {
            int bytesToRecover2 = bytesToRecover;
            int entriesToEvict = 0;
            if (bytesToRecover2 > 0) {
                int j = this.dynamicTable.length;
                while (true) {
                    j--;
                    if (j < this.nextHeaderIndex || bytesToRecover2 <= 0) {
                        break;
                    }
                    Header toEvict = this.dynamicTable[j];
                    Intrinsics.checkNotNull(toEvict);
                    bytesToRecover2 -= toEvict.hpackSize;
                    this.dynamicTableByteCount -= toEvict.hpackSize;
                    this.headerCount--;
                    entriesToEvict++;
                }
                System.arraycopy(this.dynamicTable, this.nextHeaderIndex + 1, this.dynamicTable, this.nextHeaderIndex + 1 + entriesToEvict, this.headerCount);
                this.nextHeaderIndex += entriesToEvict;
            }
            return entriesToEvict;
        }

        public final void readHeaders() throws IOException {
            while (!this.source.exhausted()) {
                int b = _UtilCommonKt.and(this.source.readByte(), KotlinVersion.MAX_COMPONENT_VALUE);
                if (b != 128) {
                    if ((b & 128) == 128) {
                        int index = readInt(b, 127);
                        readIndexedHeader(index - 1);
                    } else if (b != 64) {
                        if ((b & 64) == 64) {
                            int index2 = readInt(b, Hpack.PREFIX_6_BITS);
                            readLiteralHeaderWithIncrementalIndexingIndexedName(index2 - 1);
                        } else if ((b & 32) == 32) {
                            this.maxDynamicTableByteCount = readInt(b, Hpack.PREFIX_5_BITS);
                            if (this.maxDynamicTableByteCount < 0 || this.maxDynamicTableByteCount > this.headerTableSizeSetting) {
                                throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                            }
                            adjustDynamicTableByteCount();
                        } else if (b == 16 || b == 0) {
                            readLiteralHeaderWithoutIndexingNewName();
                        } else {
                            int index3 = readInt(b, 15);
                            readLiteralHeaderWithoutIndexingIndexedName(index3 - 1);
                        }
                    } else {
                        readLiteralHeaderWithIncrementalIndexingNewName();
                    }
                } else {
                    throw new IOException("index == 0");
                }
            }
        }

        private final void readIndexedHeader(int index) throws IOException {
            if (isStaticHeader(index)) {
                Header staticEntry = Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[index];
                this.headerList.add(staticEntry);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(index - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex < 0 || dynamicTableIndex >= this.dynamicTable.length) {
                throw new IOException("Header index too large " + (index + 1));
            }
            List<Header> list = this.headerList;
            Header header = this.dynamicTable[dynamicTableIndex];
            Intrinsics.checkNotNull(header);
            list.add(header);
        }

        private final int dynamicTableIndex(int index) {
            return this.nextHeaderIndex + 1 + index;
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int index) throws IOException {
            ByteString name = getName(index);
            ByteString value = readByteString();
            this.headerList.add(new Header(name, value));
        }

        private final void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            ByteString name = Hpack.INSTANCE.checkLowercase(readByteString());
            ByteString value = readByteString();
            this.headerList.add(new Header(name, value));
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int nameIndex) throws IOException {
            ByteString name = getName(nameIndex);
            ByteString value = readByteString();
            insertIntoDynamicTable(-1, new Header(name, value));
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            ByteString name = Hpack.INSTANCE.checkLowercase(readByteString());
            ByteString value = readByteString();
            insertIntoDynamicTable(-1, new Header(name, value));
        }

        private final ByteString getName(int index) throws IOException {
            if (isStaticHeader(index)) {
                return Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[index].name;
            }
            int dynamicTableIndex = dynamicTableIndex(index - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex < 0 || dynamicTableIndex >= this.dynamicTable.length) {
                throw new IOException("Header index too large " + (index + 1));
            }
            Header header = this.dynamicTable[dynamicTableIndex];
            Intrinsics.checkNotNull(header);
            return header.name;
        }

        private final boolean isStaticHeader(int index) {
            return index >= 0 && index <= Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1;
        }

        private final void insertIntoDynamicTable(int index, Header entry) {
            this.headerList.add(entry);
            int delta = entry.hpackSize;
            if (index != -1) {
                Header header = this.dynamicTable[dynamicTableIndex(index)];
                Intrinsics.checkNotNull(header);
                delta -= header.hpackSize;
            }
            if (delta > this.maxDynamicTableByteCount) {
                clearDynamicTable();
                return;
            }
            int bytesToRecover = (this.dynamicTableByteCount + delta) - this.maxDynamicTableByteCount;
            int entriesEvicted = evictToRecoverBytes(bytesToRecover);
            if (index != -1) {
                this.dynamicTable[dynamicTableIndex(index) + entriesEvicted + index] = entry;
            } else {
                if (this.headerCount + 1 > this.dynamicTable.length) {
                    Header[] doubled = new Header[this.dynamicTable.length * 2];
                    System.arraycopy(this.dynamicTable, 0, doubled, this.dynamicTable.length, this.dynamicTable.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = doubled;
                }
                int index2 = this.nextHeaderIndex;
                this.nextHeaderIndex = index2 - 1;
                this.dynamicTable[index2] = entry;
                this.headerCount++;
            }
            this.dynamicTableByteCount += delta;
        }

        private final int readByte() throws IOException {
            return _UtilCommonKt.and(this.source.readByte(), KotlinVersion.MAX_COMPONENT_VALUE);
        }

        public final int readInt(int firstByte, int prefixMask) throws IOException {
            int prefix = firstByte & prefixMask;
            if (prefix < prefixMask) {
                return prefix;
            }
            int result = prefixMask;
            int shift = 0;
            while (true) {
                int b = readByte();
                if ((b & 128) != 0) {
                    result += (b & 127) << shift;
                    shift += 7;
                } else {
                    return result + (b << shift);
                }
            }
        }

        public final ByteString readByteString() throws IOException {
            int firstByte = readByte();
            boolean huffmanDecode = (firstByte & 128) == 128;
            long length = readInt(firstByte, 127);
            if (huffmanDecode) {
                Buffer decodeBuffer = new Buffer();
                Huffman.INSTANCE.decode(this.source, length, decodeBuffer);
                return decodeBuffer.readByteString();
            }
            return this.source.readByteString(length);
        }
    }

    private final Map<ByteString, Integer> nameToFirstIndex() {
        LinkedHashMap result = new LinkedHashMap(STATIC_HEADER_TABLE.length, 1.0f);
        int length = STATIC_HEADER_TABLE.length;
        for (int i = 0; i < length; i++) {
            if (!result.containsKey(STATIC_HEADER_TABLE[i].name)) {
                result.put(STATIC_HEADER_TABLE[i].name, Integer.valueOf(i));
            }
        }
        LinkedHashMap $this$unmodifiable$iv = result;
        Map<ByteString, Integer> mapUnmodifiableMap = Collections.unmodifiableMap($this$unmodifiable$iv);
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "unmodifiableMap(...)");
        return mapUnmodifiableMap;
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\u0014\u0010\u001a\u001a\u00020\u00152\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001cJ\u001e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003J\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0003J\b\u0010%\u001a\u00020\u0015H\u0002R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Hpack$Writer;", _UrlKt.FRAGMENT_ENCODE_SET, "headerTableSizeSetting", _UrlKt.FRAGMENT_ENCODE_SET, "useCompression", _UrlKt.FRAGMENT_ENCODE_SET, "out", "Lni/shikatu/okio/Buffer;", "<init>", "(IZLokio/Buffer;)V", "smallestHeaderTableSizeSetting", "emitDynamicTableSizeUpdate", "maxDynamicTableByteCount", "dynamicTable", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/internal/http2/Header;", "[Lni/shikatu/okhttp3/internal/http2/Header;", "nextHeaderIndex", "headerCount", "dynamicTableByteCount", "clearDynamicTable", _UrlKt.FRAGMENT_ENCODE_SET, "evictToRecoverBytes", "bytesToRecover", "insertIntoDynamicTable", "entry", "writeHeaders", "headerBlock", _UrlKt.FRAGMENT_ENCODE_SET, "writeInt", "value", "prefixMask", "bits", "writeByteString", "data", "Lni/shikatu/okio/ByteString;", "resizeHeaderTable", "adjustDynamicTableByteCount", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Writer {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        public int headerCount;
        public int headerTableSizeSetting;
        public int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        public Writer(int i, Buffer buffer) {
            this(i, false, buffer, 2, null);
            Intrinsics.checkNotNullParameter(buffer, "out");
        }

        public Writer(Buffer buffer) {
            this(0, false, buffer, 3, null);
            Intrinsics.checkNotNullParameter(buffer, "out");
        }

        public Writer(int headerTableSizeSetting, boolean useCompression, Buffer out) {
            Intrinsics.checkNotNullParameter(out, "out");
            this.headerTableSizeSetting = headerTableSizeSetting;
            this.useCompression = useCompression;
            this.out = out;
            this.smallestHeaderTableSizeSetting = IntCompanionObject.MAX_VALUE;
            this.maxDynamicTableByteCount = this.headerTableSizeSetting;
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = this.dynamicTable.length - 1;
        }

        public  Writer(int i, boolean z, Buffer buffer, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 4096 : i, (i2 & 2) != 0 ? true : z, buffer);
        }

        private final void clearDynamicTable() {
            ArraysKt.fill$default(this.dynamicTable, (Object) null, 0, 0, 6, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int evictToRecoverBytes(int bytesToRecover) {
            int bytesToRecover2 = bytesToRecover;
            int entriesToEvict = 0;
            if (bytesToRecover2 > 0) {
                int j = this.dynamicTable.length;
                while (true) {
                    j--;
                    if (j < this.nextHeaderIndex || bytesToRecover2 <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[j];
                    Intrinsics.checkNotNull(header);
                    bytesToRecover2 -= header.hpackSize;
                    int i = this.dynamicTableByteCount;
                    Header header2 = this.dynamicTable[j];
                    Intrinsics.checkNotNull(header2);
                    this.dynamicTableByteCount = i - header2.hpackSize;
                    this.headerCount--;
                    entriesToEvict++;
                }
                System.arraycopy(this.dynamicTable, this.nextHeaderIndex + 1, this.dynamicTable, this.nextHeaderIndex + 1 + entriesToEvict, this.headerCount);
                Arrays.fill(this.dynamicTable, this.nextHeaderIndex + 1, this.nextHeaderIndex + 1 + entriesToEvict, (Object) null);
                this.nextHeaderIndex += entriesToEvict;
            }
            return entriesToEvict;
        }

        private final void insertIntoDynamicTable(Header entry) {
            int delta = entry.hpackSize;
            if (delta > this.maxDynamicTableByteCount) {
                clearDynamicTable();
                return;
            }
            int bytesToRecover = (this.dynamicTableByteCount + delta) - this.maxDynamicTableByteCount;
            evictToRecoverBytes(bytesToRecover);
            if (this.headerCount + 1 > this.dynamicTable.length) {
                Header[] doubled = new Header[this.dynamicTable.length * 2];
                System.arraycopy(this.dynamicTable, 0, doubled, this.dynamicTable.length, this.dynamicTable.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = doubled;
            }
            int index = this.nextHeaderIndex;
            this.nextHeaderIndex = index - 1;
            this.dynamicTable[index] = entry;
            this.headerCount++;
            this.dynamicTableByteCount += delta;
        }

        public final void writeHeaders(List<Header> list) throws IOException {
            Intrinsics.checkNotNullParameter(list, "headerBlock");
            if (this.emitDynamicTableSizeUpdate) {
                if (this.smallestHeaderTableSizeSetting < this.maxDynamicTableByteCount) {
                    writeInt(this.smallestHeaderTableSizeSetting, Hpack.PREFIX_5_BITS, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = IntCompanionObject.MAX_VALUE;
                writeInt(this.maxDynamicTableByteCount, Hpack.PREFIX_5_BITS, 32);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Header header = list.get(i);
                ByteString name = header.name.toAsciiLowercase();
                ByteString value = header.value;
                int headerIndex = -1;
                int headerNameIndex = -1;
                Integer staticIndex = Hpack.INSTANCE.getNAME_TO_FIRST_INDEX().get(name);
                if (staticIndex != null) {
                    headerNameIndex = staticIndex.intValue() + 1;
                    if (2 <= headerNameIndex && headerNameIndex < 8) {
                        if (Intrinsics.areEqual(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[headerNameIndex - 1].value, value)) {
                            headerIndex = headerNameIndex;
                        } else if (Intrinsics.areEqual(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[headerNameIndex].value, value)) {
                            headerIndex = headerNameIndex + 1;
                        }
                    }
                }
                if (headerIndex == -1) {
                    int length = this.dynamicTable.length;
                    for (int j = this.nextHeaderIndex + 1; j < length; j++) {
                        Header header2 = this.dynamicTable[j];
                        Intrinsics.checkNotNull(header2);
                        if (Intrinsics.areEqual(header2.name, name)) {
                            Header header3 = this.dynamicTable[j];
                            Intrinsics.checkNotNull(header3);
                            if (Intrinsics.areEqual(header3.value, value)) {
                                headerIndex = (j - this.nextHeaderIndex) + Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length;
                                break;
                            } else if (headerNameIndex == -1) {
                                headerNameIndex = (j - this.nextHeaderIndex) + Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length;
                            }
                        }
                    }
                }
                if (headerIndex == -1) {
                    if (headerNameIndex == -1) {
                        this.out.writeByte(64);
                        writeByteString(name);
                        writeByteString(value);
                        insertIntoDynamicTable(header);
                    } else if (!name.startsWith(Header.PSEUDO_PREFIX) || Intrinsics.areEqual(Header.TARGET_AUTHORITY, name)) {
                        writeInt(headerNameIndex, Hpack.PREFIX_6_BITS, 64);
                        writeByteString(value);
                        insertIntoDynamicTable(header);
                    } else {
                        writeInt(headerNameIndex, 15, 0);
                        writeByteString(value);
                    }
                } else {
                    writeInt(headerIndex, 127, 128);
                }
            }
        }

        public final void writeInt(int value, int prefixMask, int bits) {
            if (value < prefixMask) {
                this.out.writeByte(bits | value);
                return;
            }
            this.out.writeByte(bits | prefixMask);
            int value2 = value - prefixMask;
            while (value2 >= 128) {
                int b = value2 & 127;
                this.out.writeByte(b | 128);
                value2 >>>= 7;
            }
            this.out.writeByte(value2);
        }

        public final void writeByteString(ByteString data) throws IOException {
            Intrinsics.checkNotNullParameter(data, "data");
            if (this.useCompression && Huffman.INSTANCE.encodedLength(data) < data.size()) {
                Buffer huffmanBuffer = new Buffer();
                Huffman.INSTANCE.encode(data, huffmanBuffer);
                ByteString huffmanBytes = huffmanBuffer.readByteString();
                writeInt(huffmanBytes.size(), 127, 128);
                this.out.write(huffmanBytes);
                return;
            }
            writeInt(data.size(), 127, 0);
            this.out.write(data);
        }

        public final void resizeHeaderTable(int headerTableSizeSetting) {
            this.headerTableSizeSetting = headerTableSizeSetting;
            int effectiveHeaderTableSize = Math.min(headerTableSizeSetting, 16384);
            if (this.maxDynamicTableByteCount == effectiveHeaderTableSize) {
                return;
            }
            if (effectiveHeaderTableSize < this.maxDynamicTableByteCount) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, effectiveHeaderTableSize);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = effectiveHeaderTableSize;
            adjustDynamicTableByteCount();
        }

        private final void adjustDynamicTableByteCount() {
            if (this.maxDynamicTableByteCount < this.dynamicTableByteCount) {
                if (this.maxDynamicTableByteCount == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(this.dynamicTableByteCount - this.maxDynamicTableByteCount);
                }
            }
        }
    }

    public final ByteString checkLowercase(ByteString name) throws IOException {
        Intrinsics.checkNotNullParameter(name, "name");
        int size = name.size();
        for (int i = 0; i < size; i++) {
            byte b = name.getByte(i);
            boolean z = false;
            if (65 <= b && b < 91) {
                z = true;
            }
            if (z) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + name.utf8());
            }
        }
        return name;
    }
}
