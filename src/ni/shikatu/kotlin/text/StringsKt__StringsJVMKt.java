package ni.shikatu.kotlin.text;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecatedSinceKotlin;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.collections.AbstractList;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.StringCompanionObject;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000¶\u0001\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0081\u0088\u0004b\u0002\b\u0006\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001H\u0081\u0088\u0004b\u0002\b\u0006\u001a\"\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0081\u0088\u0004b\u0002\b\u0006\u001a\"\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001H\u0081\u0088\u0004b\u0002\b\u0006\u001a$\u0010\t\u001a\u00020\n*\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\nH\u0086\u0080\u0004\u001a(\u0010\r\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\nH\u0086\u0080\u0004\u001a(\u0010\r\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\nH\u0086\u0080\u0004\u001a(\u0010\u0012\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\nH\u0086\u0080\u0004\u001a(\u0010\u0012\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\nH\u0086\u0080\u0004\u001a\\\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b0\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\"\b\u0017\u0012\u001e\b\u000bB\u001a\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\f\b\u001b\u0012\b\b\fJ\u0004\b\b(\u001cb\u0016\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!b\u0002\b\u0006\u001a \u0010\"\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(\u001fb\u0002\b\u0006\u001a\\\u0010%\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b0\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(&\u0012\"\b\u0017\u0012\u001e\b\u000bB\u001a\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b('\u0012\f\b\u001b\u0012\b\b\fJ\u0004\b\b(\u001cb\u0016\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!b\u0002\b\u0006\u001a \u0010(\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(\u001fb\u0002\b\u0006\u001a\u001c\u0010)\u001a\u00020\u0002*\u00020*H\u0087\u0080\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(+\u001a0\u0010)\u001a\u00020\u0002*\u00020*2\b\b\u0002\u0010,\u001a\u00020\u00012\b\b\u0002\u0010-\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(+\u001a0\u0010.\u001a\u00020**\u00020\u00022\b\b\u0002\u0010,\u001a\u00020\u00012\b\b\u0002\u0010-\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(+\u001a\u001c\u0010/\u001a\u00020\u0002*\u000200H\u0087\u0080\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(+\u001a:\u0010/\u001a\u00020\u0002*\u0002002\b\b\u0002\u0010,\u001a\u00020\u00012\b\b\u0002\u0010-\u001a\u00020\u00012\b\b\u0002\u00101\u001a\u00020\nH\u0087\u0080\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(+\u001a\u001c\u00102\u001a\u000200*\u00020\u0002H\u0087\u0080\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(+\u001a:\u00102\u001a\u000200*\u00020\u00022\b\b\u0002\u0010,\u001a\u00020\u00012\b\b\u0002\u0010-\u001a\u00020\u00012\b\b\u0002\u00101\u001a\u00020\nH\u0087\u0080\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(+\u001a\u0012\u0010.\u001a\u00020**\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0006\u001a<\u0010.\u001a\u00020**\u00020\u00022\u0006\u00103\u001a\u00020*2\b\b\u0002\u00104\u001a\u00020\u00012\b\b\u0002\u0010,\u001a\u00020\u00012\b\b\u0002\u0010-\u001a\u00020\u0001H\u0087\u0088\bb\u0002\b\u0006b\u0002\b5\u001a/\u00106\u001a\u00020\u0002*\u00020\u00022\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0087\u0088\u0004b\u0002\b\u0006¢\u0006\u0002\u0010:\u001a7\u00106\u001a\u00020\u0002*\u00020;2\u0006\u00106\u001a\u00020\u00022\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0087\u0088\u0004b\u0002\b\u0006¢\u0006\u0002\u0010<\u001aG\u00106\u001a\u00020\u0002*\u00020\u00022\b\u0010=\u001a\u0004\u0018\u00010>2\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0087\u0088\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(+b\u0002\b\u0006¢\u0006\u0002\u0010?\u001aO\u00106\u001a\u00020\u0002*\u00020;2\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u00106\u001a\u00020\u00022\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0087\u0088\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(+b\u0002\b\u0006¢\u0006\u0002\u0010@\u001a&\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00020B*\u00020C2\u0006\u0010D\u001a\u00020E2\b\b\u0002\u0010F\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u001a\u0010G\u001a\u00020\u0002*\u00020\u00022\u0006\u0010,\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u0006\u001a\"\u0010G\u001a\u00020\u0002*\u00020\u00022\u0006\u0010,\u001a\u00020\u00012\u0006\u0010-\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u0006\u001a \u0010H\u001a\u00020\n*\u00020\u00022\u0006\u0010I\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\nH\u0086\u0080\u0004\u001a(\u0010H\u001a\u00020\n*\u00020\u00022\u0006\u0010I\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\nH\u0086\u0080\u0004\u001a \u0010J\u001a\u00020\n*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\nH\u0086\u0080\u0004\u001a.\u0010L\u001a\u00020\u00022\u0006\u0010M\u001a\u0002002\u0006\u0010N\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\u00012\u0006\u0010P\u001a\u00020QH\u0087\u0088\u0004b\u0002\b\u0006\u001a\u001e\u0010L\u001a\u00020\u00022\u0006\u0010M\u001a\u0002002\u0006\u0010P\u001a\u00020QH\u0087\u0088\u0004b\u0002\b\u0006\u001a&\u0010L\u001a\u00020\u00022\u0006\u0010M\u001a\u0002002\u0006\u0010N\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u0006\u001a\u0016\u0010L\u001a\u00020\u00022\u0006\u0010M\u001a\u000200H\u0087\u0088\u0004b\u0002\b\u0006\u001a\u0016\u0010L\u001a\u00020\u00022\u0006\u0010R\u001a\u00020*H\u0087\u0088\u0004b\u0002\b\u0006\u001a&\u0010L\u001a\u00020\u00022\u0006\u0010R\u001a\u00020*2\u0006\u0010N\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u0006\u001a&\u0010L\u001a\u00020\u00022\u0006\u0010S\u001a\u00020T2\u0006\u0010N\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u0006\u001a\u0016\u0010L\u001a\u00020\u00022\u0006\u0010U\u001a\u00020VH\u0087\u0088\u0004b\u0002\b\u0006\u001a\u0016\u0010L\u001a\u00020\u00022\u0006\u0010W\u001a\u00020XH\u0087\u0088\u0004b\u0002\b\u0006\u001a\u001a\u0010Y\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Z\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u0006\u001a\u001a\u0010[\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Z\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u0006\u001a\"\u0010\\\u001a\u00020\u0001*\u00020\u00022\u0006\u0010]\u001a\u00020\u00012\u0006\u0010-\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u0006\u001a \u0010^\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\nH\u0086\u0080\u0004\u001a\u001a\u0010_\u001a\u00020\n*\u00020\u00022\u0006\u0010`\u001a\u00020CH\u0087\u0088\u0004b\u0002\b\u0006\u001a\u001a\u0010_\u001a\u00020\n*\u00020\u00022\u0006\u0010W\u001a\u00020VH\u0087\u0088\u0004b\u0002\b\u0006\u001a(\u0010_\u001a\u00020\n*\u0004\u0018\u00010C2\b\u0010\u000b\u001a\u0004\u0018\u00010CH\u0087\u0084\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(\u001f\u001a0\u0010_\u001a\u00020\n*\u0004\u0018\u00010C2\b\u0010\u000b\u001a\u0004\u0018\u00010C2\u0006\u0010\f\u001a\u00020\nH\u0087\u0080\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(\u001f\u001a\u0012\u0010a\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0006\u001a\"\u0010b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Z\u001a\u00020\u00012\u0006\u0010c\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u0006\u001a8\u0010d\u001a\u00020\n*\u00020C2\u0006\u0010e\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020C2\u0006\u0010f\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\nH\u0086\u0080\u0004\u001a8\u0010d\u001a\u00020\n*\u00020\u00022\u0006\u0010e\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010f\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\nH\u0086\u0080\u0004\u001a^\u0010%\u001a\u00020\u0002*\u00020\u00022\u0006\u0010=\u001a\u00020>H\u0087\u0088\u0004b*\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(&\u0012\u001c\b\u0017\u0012\u0018\b\u000bB\u0014\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(g\u0012\u0006\b\u001b\u0012\u0002\b\fb\u0016\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!b\u0002\b\u0006\u001a(\u0010(\u001a\u00020\u0002*\u00020\u00022\u0006\u0010=\u001a\u00020>H\u0087\u0088\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(\u001fb\u0002\b\u0006\u001a^\u0010\u0013\u001a\u00020\u0002*\u00020\u00022\u0006\u0010=\u001a\u00020>H\u0087\u0088\u0004b*\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u001c\b\u0017\u0012\u0018\b\u000bB\u0014\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(h\u0012\u0006\b\u001b\u0012\u0002\b\fb\u0016\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!b\u0002\b\u0006\u001a(\u0010\"\u001a\u00020\u0002*\u00020\u00022\u0006\u0010=\u001a\u00020>H\u0087\u0088\u0004b\f\b#\u0012\b\b$\u0012\u0004\b\b(\u001fb\u0002\b\u0006\u001a\u001c\u0010i\u001a\u000200*\u00020\u00022\b\b\u0002\u0010P\u001a\u00020QH\u0087\u0088\u0004b\u0002\b\u0006\u001a\u001c\u0010j\u001a\u00020E*\u00020\u00022\b\b\u0002\u0010k\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u0006\u001aN\u0010l\u001a\u00020\u0002*\u00020\u0002H\u0087\u0080\u0004b0\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(m\u0012\"\b\u0017\u0012\u001e\b\u000bB\u001a\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(n\u0012\f\b\u001b\u0012\b\b\fJ\u0004\b\b(\u001cb\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u001ab\u0010l\u001a\u00020\u0002*\u00020\u00022\u0006\u0010=\u001a\u00020>H\u0087\u0080\u0004b*\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(m\u0012\u001c\b\u0017\u0012\u0018\b\u000bB\u0014\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(o\u0012\u0006\b\u001b\u0012\u0002\b\fb\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\f\b#\u0012\b\b$\u0012\u0004\b\b(+b\u0002\bp\u001aN\u0010q\u001a\u00020\u0002*\u00020\u0002H\u0087\u0080\u0004b0\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(m\u0012\"\b\u0017\u0012\u001e\b\u000bB\u001a\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(r\u0012\f\b\u001b\u0012\b\b\fJ\u0004\b\b(\u001cb\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u001ab\u0010q\u001a\u00020\u0002*\u00020\u00022\u0006\u0010=\u001a\u00020>H\u0087\u0080\u0004b*\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(m\u0012\u001c\b\u0017\u0012\u0018\b\u000bB\u0014\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(s\u0012\u0006\b\u001b\u0012\u0002\b\fb\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\f\b#\u0012\b\b$\u0012\u0004\b\b(+b\u0002\bp\u001a\u0016\u0010t\u001a\u00020\u0002*\u00020C2\u0006\u0010u\u001a\u00020\u0001H\u0086\u0080\u0004\")\u0010v\u001a\u0012\u0012\u0004\u0012\u00020\u00020wj\b\u0012\u0004\u0012\u00020\u0002`x*\u00020;8FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\by\u0010z¨\u0006{"}, d2 = {"nativeIndexOf", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "ch", _UrlKt.FRAGMENT_ENCODE_SET, "fromIndex", "Lni/shikatu/kotlin/internal/InlineOnly;", "str", "nativeLastIndexOf", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", "ignoreCase", "replace", "oldChar", "newChar", "oldValue", "newValue", "replaceFirst", "toUpperCase", "Lni/shikatu/kotlin/Deprecated;", "message", "Use uppercase() instead.", "replaceWith", "Lni/shikatu/kotlin/ReplaceWith;", "expression", "uppercase(Locale.getDefault())", "imports", "java.util.Locale", "Lni/shikatu/kotlin/DeprecatedSinceKotlin;", "warningSince", "1.5", "errorSince", "2.1", "uppercase", "Lni/shikatu/kotlin/SinceKotlin;", "version", "toLowerCase", "Use lowercase() instead.", "lowercase(Locale.getDefault())", "lowercase", "concatToString", _UrlKt.FRAGMENT_ENCODE_SET, "1.4", "startIndex", "endIndex", "toCharArray", "decodeToString", _UrlKt.FRAGMENT_ENCODE_SET, "throwOnInvalidSequence", "encodeToByteArray", "destination", "destinationOffset", "Lni/shikatu/kotlin/IgnorableReturnValue;", "format", "args", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Lni/shikatu/kotlin/String$Companion;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "locale", "Ljava/util/Locale;", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "split", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "regex", "Ljava/util/regex/Pattern;", "limit", "substring", "startsWith", "prefix", "endsWith", "suffix", "String", "bytes", "offset", "length", "charset", "Ljava/nio/charset/Charset;", "chars", "codePoints", _UrlKt.FRAGMENT_ENCODE_SET, "stringBuffer", "Ljava/lang/StringBuffer;", "stringBuilder", "Ljava/lang/StringBuilder;", "codePointAt", "index", "codePointBefore", "codePointCount", "beginIndex", "compareTo", "contentEquals", "charSequence", "intern", "offsetByCodePoints", "codePointOffset", "regionMatches", "thisOffset", "otherOffset", "lowercase(locale)", "uppercase(locale)", "toByteArray", "toPattern", "flags", "capitalize", "Use replaceFirstChar instead.", "replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", "replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }", "Lni/shikatu/kotlin/internal/LowPriorityInOverloadResolution;", "decapitalize", "replaceFirstChar { it.lowercase(Locale.getDefault()) }", "replaceFirstChar { it.lowercase(locale) }", "repeat", "n", "CASE_INSENSITIVE_ORDER", "Ljava/util/Comparator;", "Lni/shikatu/kotlin/Comparator;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/text/StringsKt")
public class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    private static final int nativeIndexOf(String $this$nativeIndexOf, char ch, int fromIndex) {
        Intrinsics.checkNotNullParameter($this$nativeIndexOf, "<this>");
        return $this$nativeIndexOf.indexOf(ch, fromIndex);
    }

    private static final int nativeIndexOf(String $this$nativeIndexOf, String str, int fromIndex) {
        Intrinsics.checkNotNullParameter($this$nativeIndexOf, "<this>");
        Intrinsics.checkNotNullParameter(str, "str");
        return $this$nativeIndexOf.indexOf(str, fromIndex);
    }

    private static final int nativeLastIndexOf(String $this$nativeLastIndexOf, char ch, int fromIndex) {
        Intrinsics.checkNotNullParameter($this$nativeLastIndexOf, "<this>");
        return $this$nativeLastIndexOf.lastIndexOf(ch, fromIndex);
    }

    private static final int nativeLastIndexOf(String $this$nativeLastIndexOf, String str, int fromIndex) {
        Intrinsics.checkNotNullParameter($this$nativeLastIndexOf, "<this>");
        Intrinsics.checkNotNullParameter(str, "str");
        return $this$nativeLastIndexOf.lastIndexOf(str, fromIndex);
    }

    public static  boolean equals$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.equals(str, str2, z);
    }

    public static final boolean equals(String $this$equals, String other, boolean ignoreCase) {
        if ($this$equals == null) {
            return other == null;
        }
        if (!ignoreCase) {
            return $this$equals.equals(other);
        }
        return $this$equals.equalsIgnoreCase(other);
    }

    public static  String replace$default(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return StringsKt.replace(str, c, c2, z);
    }

    public static final String replace(String $this$replace, char oldChar, char newChar, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$replace, "<this>");
        if (!ignoreCase) {
            String strReplace = $this$replace.replace(oldChar, newChar);
            Intrinsics.checkNotNullExpressionValue(strReplace, "replace(...)");
            return strReplace;
        }
        StringBuilder $this$replace_u24lambda_u240 = new StringBuilder($this$replace.length());
        String $this$forEach$iv = $this$replace;
        for (int i = 0; i < $this$forEach$iv.length(); i++) {
            char element$iv = $this$forEach$iv.charAt(i);
            $this$replace_u24lambda_u240.append(CharsKt.equals(element$iv, oldChar, ignoreCase) ? newChar : element$iv);
        }
        return $this$replace_u24lambda_u240.toString();
    }

    public static  String replace$default(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return StringsKt.replace(str, str2, str3, z);
    }

    public static final String replace(String $this$replace, String oldValue, String newValue, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$replace, "<this>");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        int occurrenceIndex = StringsKt.indexOf($this$replace, oldValue, 0, ignoreCase);
        if (occurrenceIndex < 0) {
            return $this$replace;
        }
        int oldValueLength = oldValue.length();
        int searchStep = RangesKt.coerceAtLeast(oldValueLength, 1);
        int newLengthHint = ($this$replace.length() - oldValueLength) + newValue.length();
        if (newLengthHint < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder stringBuilder = new StringBuilder(newLengthHint);
        int i = 0;
        do {
            stringBuilder.append((CharSequence) $this$replace, i, occurrenceIndex).append(newValue);
            i = occurrenceIndex + oldValueLength;
            if (occurrenceIndex >= $this$replace.length()) {
                break;
            }
            occurrenceIndex = StringsKt.indexOf($this$replace, oldValue, occurrenceIndex + searchStep, ignoreCase);
        } while (occurrenceIndex > 0);
        String string = stringBuilder.append((CharSequence) $this$replace, i, $this$replace.length()).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static  String replaceFirst$default(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return StringsKt.replaceFirst(str, c, c2, z);
    }

    public static final String replaceFirst(String $this$replaceFirst, char oldChar, char newChar, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$replaceFirst, "<this>");
        int index = StringsKt.indexOf$default($this$replaceFirst, oldChar, 0, ignoreCase, 2, (Object) null);
        if (index < 0) {
            return $this$replaceFirst;
        }
        return StringsKt.replaceRange((CharSequence) $this$replaceFirst, index, index + 1, (CharSequence) String.valueOf(newChar)).toString();
    }

    public static  String replaceFirst$default(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return StringsKt.replaceFirst(str, str2, str3, z);
    }

    public static final String replaceFirst(String $this$replaceFirst, String oldValue, String newValue, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$replaceFirst, "<this>");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        int index = StringsKt.indexOf$default($this$replaceFirst, oldValue, 0, ignoreCase, 2, (Object) null);
        if (index < 0) {
            return $this$replaceFirst;
        }
        return StringsKt.replaceRange((CharSequence) $this$replaceFirst, index, oldValue.length() + index, (CharSequence) newValue).toString();
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    private static final String toUpperCase(String $this$toUpperCase) {
        Intrinsics.checkNotNullParameter($this$toUpperCase, "<this>");
        String upperCase = $this$toUpperCase.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    private static final String uppercase(String $this$uppercase) {
        Intrinsics.checkNotNullParameter($this$uppercase, "<this>");
        String upperCase = $this$uppercase.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    private static final String toLowerCase(String $this$toLowerCase) {
        Intrinsics.checkNotNullParameter($this$toLowerCase, "<this>");
        String lowerCase = $this$toLowerCase.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private static final String lowercase(String $this$lowercase) {
        Intrinsics.checkNotNullParameter($this$lowercase, "<this>");
        String lowerCase = $this$lowercase.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public static final String concatToString(char[] $this$concatToString) {
        Intrinsics.checkNotNullParameter($this$concatToString, "<this>");
        return new String($this$concatToString);
    }

    public static  String concatToString$default(char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = cArr.length;
        }
        return StringsKt.concatToString(cArr, i, i2);
    }

    public static final String concatToString(char[] $this$concatToString, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$concatToString, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, $this$concatToString.length);
        return new String($this$concatToString, startIndex, endIndex - startIndex);
    }

    public static  char[] toCharArray$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return StringsKt.toCharArray(str, i, i2);
    }

    public static final char[] toCharArray(String $this$toCharArray, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$toCharArray, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, $this$toCharArray.length());
        char[] cArr = new char[endIndex - startIndex];
        $this$toCharArray.getChars(startIndex, endIndex, cArr, 0);
        return cArr;
    }

    public static final String decodeToString(byte[] $this$decodeToString) {
        Intrinsics.checkNotNullParameter($this$decodeToString, "<this>");
        return new String($this$decodeToString, Charsets.UTF_8);
    }

    public static  String decodeToString$default(byte[] bArr, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return StringsKt.decodeToString(bArr, i, i2, z);
    }

    public static final String decodeToString(byte[] $this$decodeToString, int startIndex, int endIndex, boolean throwOnInvalidSequence) {
        Intrinsics.checkNotNullParameter($this$decodeToString, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, $this$decodeToString.length);
        if (!throwOnInvalidSequence) {
            return new String($this$decodeToString, startIndex, endIndex - startIndex, Charsets.UTF_8);
        }
        CharsetDecoder decoder = Charsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
        String string = decoder.decode(ByteBuffer.wrap($this$decodeToString, startIndex, endIndex - startIndex)).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final byte[] encodeToByteArray(String $this$encodeToByteArray) {
        Intrinsics.checkNotNullParameter($this$encodeToByteArray, "<this>");
        byte[] bytes = $this$encodeToByteArray.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    public static  byte[] encodeToByteArray$default(String str, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return StringsKt.encodeToByteArray(str, i, i2, z);
    }

    public static final byte[] encodeToByteArray(String $this$encodeToByteArray, int startIndex, int endIndex, boolean throwOnInvalidSequence) throws CharacterCodingException {
        Intrinsics.checkNotNullParameter($this$encodeToByteArray, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, $this$encodeToByteArray.length());
        if (!throwOnInvalidSequence) {
            String strSubstring = $this$encodeToByteArray.substring(startIndex, endIndex);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            Charset charset = Charsets.UTF_8;
            Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
            byte[] bytes = strSubstring.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return bytes;
        }
        CharsetEncoder encoder = Charsets.UTF_8.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
        ByteBuffer byteBuffer = encoder.encode(CharBuffer.wrap($this$encodeToByteArray, startIndex, endIndex));
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            int iRemaining = byteBuffer.remaining();
            byte[] bArrArray = byteBuffer.array();
            Intrinsics.checkNotNull(bArrArray);
            if (iRemaining == bArrArray.length) {
                byte[] bArrArray2 = byteBuffer.array();
                Intrinsics.checkNotNull(bArrArray2);
                return bArrArray2;
            }
        }
        byte[] it = new byte[byteBuffer.remaining()];
        byteBuffer.get(it);
        return it;
    }

    private static final char[] toCharArray(String $this$toCharArray) {
        Intrinsics.checkNotNullParameter($this$toCharArray, "<this>");
        char[] charArray = $this$toCharArray.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        return charArray;
    }

    static  char[] toCharArray$default(String $this$toCharArray_u24default, char[] destination, int destinationOffset, int startIndex, int endIndex, int i, Object obj) {
        if ((i & 2) != 0) {
            destinationOffset = 0;
        }
        if ((i & 4) != 0) {
            startIndex = 0;
        }
        if ((i & 8) != 0) {
            endIndex = $this$toCharArray_u24default.length();
        }
        Intrinsics.checkNotNullParameter($this$toCharArray_u24default, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        $this$toCharArray_u24default.getChars(startIndex, endIndex, destination, destinationOffset);
        return destination;
    }

    @IgnorableReturnValue
    private static final char[] toCharArray(String $this$toCharArray, char[] destination, int destinationOffset, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$toCharArray, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        $this$toCharArray.getChars(startIndex, endIndex, destination, destinationOffset);
        return destination;
    }

    private static final String format(String $this$format, Object... args) {
        Intrinsics.checkNotNullParameter($this$format, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        String str = String.format($this$format, Arrays.copyOf(args, args.length));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private static final String format(StringCompanionObject $this$format, String format, Object... args) {
        Intrinsics.checkNotNullParameter($this$format, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        String str = String.format(format, Arrays.copyOf(args, args.length));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private static final String format(String $this$format, Locale locale, Object... args) {
        Intrinsics.checkNotNullParameter($this$format, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        String str = String.format(locale, $this$format, Arrays.copyOf(args, args.length));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private static final String format(StringCompanionObject $this$format, Locale locale, String format, Object... args) {
        Intrinsics.checkNotNullParameter($this$format, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        String str = String.format(locale, format, Arrays.copyOf(args, args.length));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static  List split$default(CharSequence charSequence, Pattern pattern, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return StringsKt.split(charSequence, pattern, i);
    }

    public static final List<String> split(CharSequence $this$split, Pattern regex, int limit) {
        Intrinsics.checkNotNullParameter($this$split, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        StringsKt.requireNonNegativeLimit(limit);
        String[] strArrSplit = regex.split($this$split, limit == 0 ? -1 : limit);
        Intrinsics.checkNotNullExpressionValue(strArrSplit, "split(...)");
        return ArraysKt.asList(strArrSplit);
    }

    private static final String substring(String $this$substring, int startIndex) {
        Intrinsics.checkNotNullParameter($this$substring, "<this>");
        String strSubstring = $this$substring.substring(startIndex);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    private static final String substring(String $this$substring, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$substring, "<this>");
        String strSubstring = $this$substring.substring(startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static  boolean startsWith$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.startsWith(str, str2, z);
    }

    public static final boolean startsWith(String $this$startsWith, String prefix, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!ignoreCase) {
            return $this$startsWith.startsWith(prefix);
        }
        return StringsKt.regionMatches($this$startsWith, 0, prefix, 0, prefix.length(), ignoreCase);
    }

    public static  boolean startsWith$default(String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.startsWith(str, str2, i, z);
    }

    public static final boolean startsWith(String $this$startsWith, String prefix, int startIndex, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!ignoreCase) {
            return $this$startsWith.startsWith(prefix, startIndex);
        }
        return StringsKt.regionMatches($this$startsWith, startIndex, prefix, 0, prefix.length(), ignoreCase);
    }

    public static  boolean endsWith$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.endsWith(str, str2, z);
    }

    public static final boolean endsWith(String $this$endsWith, String suffix, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$endsWith, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (!ignoreCase) {
            return $this$endsWith.endsWith(suffix);
        }
        return StringsKt.regionMatches($this$endsWith, $this$endsWith.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    private static final String String(byte[] bytes, int offset, int length, Charset charset) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(bytes, offset, length, charset);
    }

    private static final String String(byte[] bytes, Charset charset) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(bytes, charset);
    }

    private static final String String(byte[] bytes, int offset, int length) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return new String(bytes, offset, length, Charsets.UTF_8);
    }

    private static final String String(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return new String(bytes, Charsets.UTF_8);
    }

    private static final String String(char[] chars) {
        Intrinsics.checkNotNullParameter(chars, "chars");
        return new String(chars);
    }

    private static final String String(char[] chars, int offset, int length) {
        Intrinsics.checkNotNullParameter(chars, "chars");
        return new String(chars, offset, length);
    }

    private static final String String(int[] codePoints, int offset, int length) {
        Intrinsics.checkNotNullParameter(codePoints, "codePoints");
        return new String(codePoints, offset, length);
    }

    private static final String String(StringBuffer stringBuffer) {
        Intrinsics.checkNotNullParameter(stringBuffer, "stringBuffer");
        return new String(stringBuffer);
    }

    private static final String String(StringBuilder stringBuilder) {
        Intrinsics.checkNotNullParameter(stringBuilder, "stringBuilder");
        return new String(stringBuilder);
    }

    private static final int codePointAt(String $this$codePointAt, int index) {
        Intrinsics.checkNotNullParameter($this$codePointAt, "<this>");
        return $this$codePointAt.codePointAt(index);
    }

    private static final int codePointBefore(String $this$codePointBefore, int index) {
        Intrinsics.checkNotNullParameter($this$codePointBefore, "<this>");
        return $this$codePointBefore.codePointBefore(index);
    }

    private static final int codePointCount(String $this$codePointCount, int beginIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$codePointCount, "<this>");
        return $this$codePointCount.codePointCount(beginIndex, endIndex);
    }

    public static  int compareTo$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.compareTo(str, str2, z);
    }

    public static final int compareTo(String $this$compareTo, String other, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$compareTo, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (ignoreCase) {
            return $this$compareTo.compareToIgnoreCase(other);
        }
        return $this$compareTo.compareTo(other);
    }

    private static final boolean contentEquals(String $this$contentEquals, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter($this$contentEquals, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        return $this$contentEquals.contentEquals(charSequence);
    }

    private static final boolean contentEquals(String $this$contentEquals, StringBuffer stringBuilder) {
        Intrinsics.checkNotNullParameter($this$contentEquals, "<this>");
        Intrinsics.checkNotNullParameter(stringBuilder, "stringBuilder");
        return $this$contentEquals.contentEquals(stringBuilder);
    }

    public static final boolean contentEquals(CharSequence $this$contentEquals, CharSequence other) {
        if (($this$contentEquals instanceof String) && other != null) {
            return ((String) $this$contentEquals).contentEquals(other);
        }
        return StringsKt.contentEqualsImpl($this$contentEquals, other);
    }

    public static final boolean contentEquals(CharSequence $this$contentEquals, CharSequence other, boolean ignoreCase) {
        if (ignoreCase) {
            return StringsKt.contentEqualsIgnoreCaseImpl($this$contentEquals, other);
        }
        return StringsKt.contentEquals($this$contentEquals, other);
    }

    private static final String intern(String $this$intern) {
        Intrinsics.checkNotNullParameter($this$intern, "<this>");
        String strIntern = $this$intern.intern();
        Intrinsics.checkNotNullExpressionValue(strIntern, "intern(...)");
        return strIntern;
    }

    private static final int offsetByCodePoints(String $this$offsetByCodePoints, int index, int codePointOffset) {
        Intrinsics.checkNotNullParameter($this$offsetByCodePoints, "<this>");
        return $this$offsetByCodePoints.offsetByCodePoints(index, codePointOffset);
    }

    public static  boolean regionMatches$default(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 16) != 0) {
            z = false;
        }
        return StringsKt.regionMatches(charSequence, i, charSequence2, i2, i3, z);
    }

    public static final boolean regionMatches(CharSequence $this$regionMatches, int thisOffset, CharSequence other, int otherOffset, int length, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$regionMatches, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (!($this$regionMatches instanceof String) || !(other instanceof String)) {
            return StringsKt.regionMatchesImpl($this$regionMatches, thisOffset, other, otherOffset, length, ignoreCase);
        }
        return StringsKt.regionMatches((String) $this$regionMatches, thisOffset, (String) other, otherOffset, length, ignoreCase);
    }

    public static  boolean regionMatches$default(String str, int i, String str2, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 16) != 0) {
            z = false;
        }
        return StringsKt.regionMatches(str, i, str2, i2, i3, z);
    }

    public static final boolean regionMatches(String $this$regionMatches, int thisOffset, String other, int otherOffset, int length, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$regionMatches, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (!ignoreCase) {
            return $this$regionMatches.regionMatches(thisOffset, other, otherOffset, length);
        }
        return $this$regionMatches.regionMatches(ignoreCase, thisOffset, other, otherOffset, length);
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(locale)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    private static final String toLowerCase(String $this$toLowerCase, Locale locale) {
        Intrinsics.checkNotNullParameter($this$toLowerCase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String lowerCase = $this$toLowerCase.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private static final String lowercase(String $this$lowercase, Locale locale) {
        Intrinsics.checkNotNullParameter($this$lowercase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String lowerCase = $this$lowercase.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(locale)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    private static final String toUpperCase(String $this$toUpperCase, Locale locale) {
        Intrinsics.checkNotNullParameter($this$toUpperCase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String upperCase = $this$toUpperCase.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    private static final String uppercase(String $this$uppercase, Locale locale) {
        Intrinsics.checkNotNullParameter($this$uppercase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String upperCase = $this$uppercase.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    private static final byte[] toByteArray(String $this$toByteArray, Charset charset) {
        Intrinsics.checkNotNullParameter($this$toByteArray, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        byte[] bytes = $this$toByteArray.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    static  byte[] toByteArray$default(String $this$toByteArray_u24default, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$toByteArray_u24default, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        byte[] bytes = $this$toByteArray_u24default.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    static  Pattern toPattern$default(String $this$toPattern_u24default, int flags, int i, Object obj) {
        if ((i & 1) != 0) {
            flags = 0;
        }
        Intrinsics.checkNotNullParameter($this$toPattern_u24default, "<this>");
        Pattern patternCompile = Pattern.compile($this$toPattern_u24default, flags);
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        return patternCompile;
    }

    private static final Pattern toPattern(String $this$toPattern, int flags) {
        Intrinsics.checkNotNullParameter($this$toPattern, "<this>");
        Pattern patternCompile = Pattern.compile($this$toPattern, flags);
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        return patternCompile;
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String capitalize(String $this$capitalize) {
        Intrinsics.checkNotNullParameter($this$capitalize, "<this>");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        return StringsKt.capitalize($this$capitalize, locale);
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String capitalize(String $this$capitalize, Locale locale) {
        Intrinsics.checkNotNullParameter($this$capitalize, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        if ($this$capitalize.length() > 0) {
            char firstChar = $this$capitalize.charAt(0);
            if (Character.isLowerCase(firstChar)) {
                StringBuilder $this$capitalize_u24lambda_u240 = new StringBuilder();
                char titleChar = Character.toTitleCase(firstChar);
                if (titleChar != Character.toUpperCase(firstChar)) {
                    $this$capitalize_u24lambda_u240.append(titleChar);
                } else {
                    String strSubstring = $this$capitalize.substring(0, 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
                    String upperCase = strSubstring.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    $this$capitalize_u24lambda_u240.append(upperCase);
                }
                String strSubstring2 = $this$capitalize.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                $this$capitalize_u24lambda_u240.append(strSubstring2);
                return $this$capitalize_u24lambda_u240.toString();
            }
        }
        return $this$capitalize;
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(Locale.getDefault()) }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String decapitalize(String $this$decapitalize) {
        Intrinsics.checkNotNullParameter($this$decapitalize, "<this>");
        if (!($this$decapitalize.length() > 0) || Character.isLowerCase($this$decapitalize.charAt(0))) {
            return $this$decapitalize;
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = $this$decapitalize.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        StringBuilder sbAppend = sb.append(lowerCase);
        String strSubstring2 = $this$decapitalize.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        return sbAppend.append(strSubstring2).toString();
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(locale) }", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String decapitalize(String $this$decapitalize, Locale locale) {
        Intrinsics.checkNotNullParameter($this$decapitalize, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (!($this$decapitalize.length() > 0) || Character.isLowerCase($this$decapitalize.charAt(0))) {
            return $this$decapitalize;
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = $this$decapitalize.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        StringBuilder sbAppend = sb.append(lowerCase);
        String strSubstring2 = $this$decapitalize.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        return sbAppend.append(strSubstring2).toString();
    }

    public static final String repeat(CharSequence $this$repeat, int n) {
        Intrinsics.checkNotNullParameter($this$repeat, "<this>");
        if (!(n >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + n + '.').toString());
        }
        switch (n) {
            case 0:
                return _UrlKt.FRAGMENT_ENCODE_SET;
            case 1:
                return $this$repeat.toString();
            default:
                switch ($this$repeat.length()) {
                    case 0:
                        return _UrlKt.FRAGMENT_ENCODE_SET;
                    case 1:
                        char cCharAt = $this$repeat.charAt(0);
                        char[] cArr = new char[n];
                        for (int i = 0; i < n; i++) {
                            cArr[i] = cCharAt;
                        }
                        return new String(cArr);
                    default:
                        StringBuilder sb = new StringBuilder($this$repeat.length() * n);
                        int i2 = 1;
                        if (1 <= n) {
                            while (true) {
                                sb.append($this$repeat);
                                if (i2 != n) {
                                    i2++;
                                }
                            }
                        }
                        String string = sb.toString();
                        Intrinsics.checkNotNull(string);
                        return string;
                }
        }
    }

    public static final Comparator<String> getCASE_INSENSITIVE_ORDER(StringCompanionObject $this$CASE_INSENSITIVE_ORDER) {
        Intrinsics.checkNotNullParameter($this$CASE_INSENSITIVE_ORDER, "<this>");
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.checkNotNullExpressionValue(comparator, "CASE_INSENSITIVE_ORDER");
        return comparator;
    }
}
