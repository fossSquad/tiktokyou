package ni.shikatu.kotlin.collections.unsigned;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecatedSinceKotlin;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.UByte;
import ni.shikatu.kotlin.UByteArray;
import ni.shikatu.kotlin.UInt;
import ni.shikatu.kotlin.UIntArray;
import ni.shikatu.kotlin.ULong;
import ni.shikatu.kotlin.ULongArray;
import ni.shikatu.kotlin.UShort;
import ni.shikatu.kotlin.UShortArray;
import ni.shikatu.kotlin.UnsignedKt;
import ni.shikatu.kotlin.collections.AbstractList;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000b¢\u0006\u0004\b\u0005\u0010\u0006\u001a3\u0010\u0000\u001a\u00020\f*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000b¢\u0006\u0004\b\u000e\u0010\u000f\u001a3\u0010\u0000\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000b¢\u0006\u0004\b\u0012\u0010\u0013\u001a3\u0010\u0000\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000b¢\u0006\u0004\b\u0016\u0010\u0017\u001a-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0019*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b\u001a\u0010\u001b\u001a-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0019*\u00020\rH\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b\u001c\u0010\u001d\u001a-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0019*\u00020\u0011H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b\u001e\u0010\u001f\u001a-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u0019*\u00020\u0015H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b \u0010!\u001aC\u0010\"\u001a\u00020\u0004*\u00020\u00022\u0006\u0010#\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b&\u0010'\u001aC\u0010\"\u001a\u00020\u0004*\u00020\r2\u0006\u0010#\u001a\u00020\f2\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b(\u0010)\u001aC\u0010\"\u001a\u00020\u0004*\u00020\u00112\u0006\u0010#\u001a\u00020\u00102\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b*\u0010+\u001aC\u0010\"\u001a\u00020\u0004*\u00020\u00152\u0006\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b,\u0010-\u001aw\u0010.\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b/\u00100\u001aw\u0010.\u001a\u0004\u0018\u00010\f*\u00020\rH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b@\u0010A\u001aw\u0010.\u001a\u0004\u0018\u00010\u0010*\u00020\u0011H\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bB\u0010C\u001aw\u0010.\u001a\u0004\u0018\u00010\u0014*\u00020\u0015H\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bD\u0010E\u001a¢\u0001\u0010F\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\u00022\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(M\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(N\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001a¢\u0001\u0010F\u001a\u0004\u0018\u00010\f\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\r2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(M\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(N\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bO\u0010P\u001a¢\u0001\u0010F\u001a\u0004\u0018\u00010\u0010\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\u00112\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(M\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(N\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bQ\u0010R\u001a¢\u0001\u0010F\u001a\u0004\u0018\u00010\u0014\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\u00152\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(M\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(N\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a\u0093\u0001\u0010U\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010Wj\n\u0012\u0006\b\u0000\u0012\u00020\u0001`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b([\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(\\\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bY\u0010Z\u001a\u0093\u0001\u0010U\u001a\u0004\u0018\u00010\f*\u00020\r2\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\f0Wj\n\u0012\u0006\b\u0000\u0012\u00020\f`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b([\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(\\\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b]\u0010^\u001a\u0093\u0001\u0010U\u001a\u0004\u0018\u00010\u0010*\u00020\u00112\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00100Wj\n\u0012\u0006\b\u0000\u0012\u00020\u0010`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b([\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(\\\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b_\u0010`\u001a\u0093\u0001\u0010U\u001a\u0004\u0018\u00010\u0014*\u00020\u00152\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00140Wj\n\u0012\u0006\b\u0000\u0012\u00020\u0014`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b([\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(\\\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\ba\u0010b\u001aw\u0010c\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(e\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(f\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bd\u00100\u001aw\u0010c\u001a\u0004\u0018\u00010\f*\u00020\rH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(e\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(f\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bg\u0010A\u001aw\u0010c\u001a\u0004\u0018\u00010\u0010*\u00020\u0011H\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(e\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(f\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bh\u0010C\u001aw\u0010c\u001a\u0004\u0018\u00010\u0014*\u00020\u0015H\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(e\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(f\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bi\u0010E\u001a¢\u0001\u0010j\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\u00022\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(l\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(m\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bk\u0010L\u001a¢\u0001\u0010j\u001a\u0004\u0018\u00010\f\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\r2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(l\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(m\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bn\u0010P\u001a¢\u0001\u0010j\u001a\u0004\u0018\u00010\u0010\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\u00112\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(l\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(m\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bo\u0010R\u001a¢\u0001\u0010j\u001a\u0004\u0018\u00010\u0014\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\u00152\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(l\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(m\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bp\u0010T\u001a\u0093\u0001\u0010q\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010Wj\n\u0012\u0006\b\u0000\u0012\u00020\u0001`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(s\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(t\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\br\u0010Z\u001a\u0093\u0001\u0010q\u001a\u0004\u0018\u00010\f*\u00020\r2\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\f0Wj\n\u0012\u0006\b\u0000\u0012\u00020\f`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(s\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(t\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bu\u0010^\u001a\u0093\u0001\u0010q\u001a\u0004\u0018\u00010\u0010*\u00020\u00112\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00100Wj\n\u0012\u0006\b\u0000\u0012\u00020\u0010`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(s\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(t\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bv\u0010`\u001a\u0093\u0001\u0010q\u001a\u0004\u0018\u00010\u0014*\u00020\u00152\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00140Wj\n\u0012\u0006\b\u0000\u0012\u00020\u0014`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(s\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(t\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bw\u0010b\u001aT\u0010x\u001a\u00020y*\u00020\u00022\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020y0JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\f\b}\u0012\b\b~\u0012\u0004\b\b(zb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bz\u0010{\u001aT\u0010x\u001a\u00020y*\u00020\r2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020y0JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\f\b}\u0012\b\b~\u0012\u0004\b\b(zb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bz\u0010\u007f\u001aU\u0010x\u001a\u00020y*\u00020\u00112\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020y0JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\f\b}\u0012\b\b~\u0012\u0004\b\b(zb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0005\bz\u0010\u0080\u0001\u001aU\u0010x\u001a\u00020y*\u00020\u00152\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020y0JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\f\b}\u0012\b\b~\u0012\u0004\b\b(zb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0005\bz\u0010\u0081\u0001\u001aY\u0010x\u001a\u00030\u0082\u0001*\u00020\u00022\u0013\u0010I\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0012\u0005\u0012\u00030\u0082\u00010JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0083\u0001b\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001\u001aY\u0010x\u001a\u00030\u0082\u0001*\u00020\r2\u0013\u0010I\u001a\u000f\u0012\u0004\u0012\u00020\f\u0012\u0005\u0012\u00030\u0082\u00010JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0083\u0001b\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0085\u0001\u001aY\u0010x\u001a\u00030\u0082\u0001*\u00020\u00112\u0013\u0010I\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0005\u0012\u00030\u0082\u00010JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0083\u0001b\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0086\u0001\u001aY\u0010x\u001a\u00030\u0082\u0001*\u00020\u00152\u0013\u0010I\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0005\u0012\u00030\u0082\u00010JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0083\u0001b\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0087\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0088\u0001"}, d2 = {"elementAt", "Lni/shikatu/kotlin/UInt;", "Lni/shikatu/kotlin/UIntArray;", "index", _UrlKt.FRAGMENT_ENCODE_SET, "elementAt-qFRl0hI", "([II)I", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", "Lni/shikatu/kotlin/ExperimentalUnsignedTypes;", "Lni/shikatu/kotlin/internal/InlineOnly;", "Lni/shikatu/kotlin/ULong;", "Lni/shikatu/kotlin/ULongArray;", "elementAt-r7IrZao", "([JI)J", "Lni/shikatu/kotlin/UByte;", "Lni/shikatu/kotlin/UByteArray;", "elementAt-PpDY95g", "([BI)B", "Lni/shikatu/kotlin/UShort;", "Lni/shikatu/kotlin/UShortArray;", "elementAt-nggk6HY", "([SI)S", "asList", _UrlKt.FRAGMENT_ENCODE_SET, "asList--ajY-9A", "([I)Ljava/util/List;", "asList-QwZRm1k", "([J)Ljava/util/List;", "asList-GBYM_sE", "([B)Ljava/util/List;", "asList-rL5Bavg", "([S)Ljava/util/List;", "binarySearch", "element", "fromIndex", "toIndex", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-EtDCXyQ", "([SSII)I", "max", "max--ajY-9A", "([I)Lkotlin/UInt;", "Lni/shikatu/kotlin/Deprecated;", "message", "Use maxOrNull instead.", "replaceWith", "Lni/shikatu/kotlin/ReplaceWith;", "expression", "this.maxOrNull()", "imports", "Lni/shikatu/kotlin/DeprecatedSinceKotlin;", "warningSince", "1.4", "errorSince", "1.5", "hiddenSince", "1.6", "max-QwZRm1k", "([J)Lkotlin/ULong;", "max-GBYM_sE", "([B)Lkotlin/UByte;", "max-rL5Bavg", "([S)Lkotlin/UShort;", "maxBy", "R", _UrlKt.FRAGMENT_ENCODE_SET, "selector", "Lni/shikatu/kotlin/Function1;", "maxBy-jgv0xPQ", "([ILkotlin/jvm/functions/Function1;)Lkotlin/UInt;", "Use maxByOrNull instead.", "this.maxByOrNull(selector)", "maxBy-MShoTSo", "([JLkotlin/jvm/functions/Function1;)Lkotlin/ULong;", "maxBy-JOV_ifY", "([BLkotlin/jvm/functions/Function1;)Lkotlin/UByte;", "maxBy-xTcfx_M", "([SLkotlin/jvm/functions/Function1;)Lkotlin/UShort;", "maxWith", "comparator", "Ljava/util/Comparator;", "Lni/shikatu/kotlin/Comparator;", "maxWith-YmdZ_VM", "([ILjava/util/Comparator;)Lkotlin/UInt;", "Use maxWithOrNull instead.", "this.maxWithOrNull(comparator)", "maxWith-zrEWJaI", "([JLjava/util/Comparator;)Lkotlin/ULong;", "maxWith-XMRcp5o", "([BLjava/util/Comparator;)Lkotlin/UByte;", "maxWith-eOHTfZs", "([SLjava/util/Comparator;)Lkotlin/UShort;", "min", "min--ajY-9A", "Use minOrNull instead.", "this.minOrNull()", "min-QwZRm1k", "min-GBYM_sE", "min-rL5Bavg", "minBy", "minBy-jgv0xPQ", "Use minByOrNull instead.", "this.minByOrNull(selector)", "minBy-MShoTSo", "minBy-JOV_ifY", "minBy-xTcfx_M", "minWith", "minWith-YmdZ_VM", "Use minWithOrNull instead.", "this.minWithOrNull(comparator)", "minWith-zrEWJaI", "minWith-XMRcp5o", "minWith-eOHTfZs", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Lni/shikatu/kotlin/OverloadResolutionByLambdaReturnType;", "Lni/shikatu/kotlin/jvm/JvmName;", "name", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, pn = "ni.shikatu.kotlin.collections", xi = 49, xs = "ni/shikatu/kotlin/collections/unsigned/UArraysKt")
class UArraysKt___UArraysJvmKt {

    private static final int m490elementAtqFRl0hI(int[] $this$elementAt_u2dqFRl0hI, int index) {
        Intrinsics.checkNotNullParameter($this$elementAt_u2dqFRl0hI, "$this$elementAt");
        return UIntArray.m161getpVg5ArA($this$elementAt_u2dqFRl0hI, index);
    }

    private static final long m491elementAtr7IrZao(long[] $this$elementAt_u2dr7IrZao, int index) {
        Intrinsics.checkNotNullParameter($this$elementAt_u2dr7IrZao, "$this$elementAt");
        return ULongArray.m240getsVKNKU($this$elementAt_u2dr7IrZao, index);
    }

    private static final byte m488elementAtPpDY95g(byte[] $this$elementAt_u2dPpDY95g, int index) {
        Intrinsics.checkNotNullParameter($this$elementAt_u2dPpDY95g, "$this$elementAt");
        return UByteArray.m82getw2LRezQ($this$elementAt_u2dPpDY95g, index);
    }

    private static final short m489elementAtnggk6HY(short[] $this$elementAt_u2dnggk6HY, int index) {
        Intrinsics.checkNotNullParameter($this$elementAt_u2dnggk6HY, "$this$elementAt");
        return UShortArray.m345getMh2AYeg($this$elementAt_u2dnggk6HY, index);
    }

    public static final List<UInt> m476asListajY9A(int[] $this$asList_u2d_u2dajY_u2d9A) {
        Intrinsics.checkNotNullParameter($this$asList_u2d_u2dajY_u2d9A, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$1($this$asList_u2d_u2dajY_u2d9A);
    }

    public static final List<ULong> m478asListQwZRm1k(long[] $this$asList_u2dQwZRm1k) {
        Intrinsics.checkNotNullParameter($this$asList_u2dQwZRm1k, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$2($this$asList_u2dQwZRm1k);
    }

    public static final List<UByte> m477asListGBYM_sE(byte[] $this$asList_u2dGBYM_sE) {
        Intrinsics.checkNotNullParameter($this$asList_u2dGBYM_sE, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$3($this$asList_u2dGBYM_sE);
    }

    public static final List<UShort> m479asListrL5Bavg(short[] $this$asList_u2drL5Bavg) {
        Intrinsics.checkNotNullParameter($this$asList_u2drL5Bavg, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$4($this$asList_u2drL5Bavg);
    }

    public static  int m481binarySearch2fe2U9s$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UIntArray.m162getSizeimpl(iArr);
        }
        return UArraysKt.m480binarySearch2fe2U9s(iArr, i, i2, i3);
    }

    public static final int m480binarySearch2fe2U9s(int[] $this$binarySearch_u2d2fe2U9s, int element, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$binarySearch_u2d2fe2U9s, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, UIntArray.m162getSizeimpl($this$binarySearch_u2d2fe2U9s));
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = $this$binarySearch_u2d2fe2U9s[mid];
            int cmp = UnsignedKt.uintCompare(midVal, element);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    public static  int m485binarySearchK6DWlUc$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m241getSizeimpl(jArr);
        }
        return UArraysKt.m484binarySearchK6DWlUc(jArr, j, i, i2);
    }

    public static final int m484binarySearchK6DWlUc(long[] $this$binarySearch_u2dK6DWlUc, long element, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$binarySearch_u2dK6DWlUc, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, ULongArray.m241getSizeimpl($this$binarySearch_u2dK6DWlUc));
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = $this$binarySearch_u2dK6DWlUc[mid];
            int cmp = UnsignedKt.ulongCompare(midVal, element);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    public static  int m487binarySearchWpHrYlw$default(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m83getSizeimpl(bArr);
        }
        return UArraysKt.m486binarySearchWpHrYlw(bArr, b, i, i2);
    }

    public static final int m486binarySearchWpHrYlw(byte[] $this$binarySearch_u2dWpHrYlw, byte element, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$binarySearch_u2dWpHrYlw, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, UByteArray.m83getSizeimpl($this$binarySearch_u2dWpHrYlw));
        int signedElement = element & UByte.MAX_VALUE;
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            byte midVal = $this$binarySearch_u2dWpHrYlw[mid];
            int cmp = UnsignedKt.uintCompare(midVal, signedElement);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    public static  int m483binarySearchEtDCXyQ$default(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m346getSizeimpl(sArr);
        }
        return UArraysKt.m482binarySearchEtDCXyQ(sArr, s, i, i2);
    }

    public static final int m482binarySearchEtDCXyQ(short[] $this$binarySearch_u2dEtDCXyQ, short element, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$binarySearch_u2dEtDCXyQ, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, UShortArray.m346getSizeimpl($this$binarySearch_u2dEtDCXyQ));
        int signedElement = 65535 & element;
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            short midVal = $this$binarySearch_u2dEtDCXyQ[mid];
            int cmp = UnsignedKt.uintCompare(midVal, signedElement);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  UInt m492maxajY9A(int[] $this$max_u2d_u2dajY_u2d9A) {
        Intrinsics.checkNotNullParameter($this$max_u2d_u2dajY_u2d9A, "$this$max");
        return UArraysKt.m885maxOrNullajY9A($this$max_u2d_u2dajY_u2d9A);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  ULong m494maxQwZRm1k(long[] $this$max_u2dQwZRm1k) {
        Intrinsics.checkNotNullParameter($this$max_u2dQwZRm1k, "$this$max");
        return UArraysKt.m887maxOrNullQwZRm1k($this$max_u2dQwZRm1k);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  UByte m493maxGBYM_sE(byte[] $this$max_u2dGBYM_sE) {
        Intrinsics.checkNotNullParameter($this$max_u2dGBYM_sE, "$this$max");
        return UArraysKt.m886maxOrNullGBYM_sE($this$max_u2dGBYM_sE);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  UShort m495maxrL5Bavg(short[] $this$max_u2drL5Bavg) {
        Intrinsics.checkNotNullParameter($this$max_u2drL5Bavg, "$this$max");
        return UArraysKt.m888maxOrNullrL5Bavg($this$max_u2drL5Bavg);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    private static final  <R extends Comparable<? super R>> UInt m498maxByjgv0xPQ(int[] $this$maxBy_u2djgv0xPQ, Function1<? super UInt, ? extends R> function1) {
        Intrinsics.checkNotNullParameter($this$maxBy_u2djgv0xPQ, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (UIntArray.m164isEmptyimpl($this$maxBy_u2djgv0xPQ)) {
            return null;
        }
        int iM161getpVg5ArA = UIntArray.m161getpVg5ArA($this$maxBy_u2djgv0xPQ, 0);
        int lastIndex = ArraysKt.getLastIndex($this$maxBy_u2djgv0xPQ);
        if (lastIndex != 0) {
            R rInvoke = function1.invoke(UInt.m95boximpl(iM161getpVg5ArA));
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    int iM161getpVg5ArA2 = UIntArray.m161getpVg5ArA($this$maxBy_u2djgv0xPQ, i);
                    R rInvoke2 = function1.invoke(UInt.m95boximpl(iM161getpVg5ArA2));
                    if (rInvoke.compareTo(rInvoke2) < 0) {
                        iM161getpVg5ArA = iM161getpVg5ArA2;
                        rInvoke = rInvoke2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        return UInt.m95boximpl(iM161getpVg5ArA);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    private static final  <R extends Comparable<? super R>> ULong m497maxByMShoTSo(long[] $this$maxBy_u2dMShoTSo, Function1<? super ULong, ? extends R> function1) {
        Intrinsics.checkNotNullParameter($this$maxBy_u2dMShoTSo, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (ULongArray.m243isEmptyimpl($this$maxBy_u2dMShoTSo)) {
            return null;
        }
        long jM240getsVKNKU = ULongArray.m240getsVKNKU($this$maxBy_u2dMShoTSo, 0);
        int lastIndex = ArraysKt.getLastIndex($this$maxBy_u2dMShoTSo);
        if (lastIndex != 0) {
            R rInvoke = function1.invoke(ULong.m174boximpl(jM240getsVKNKU));
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    long jM240getsVKNKU2 = ULongArray.m240getsVKNKU($this$maxBy_u2dMShoTSo, i);
                    R rInvoke2 = function1.invoke(ULong.m174boximpl(jM240getsVKNKU2));
                    if (rInvoke.compareTo(rInvoke2) < 0) {
                        jM240getsVKNKU = jM240getsVKNKU2;
                        rInvoke = rInvoke2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        return ULong.m174boximpl(jM240getsVKNKU);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    private static final  <R extends Comparable<? super R>> UByte m496maxByJOV_ifY(byte[] $this$maxBy_u2dJOV_ifY, Function1<? super UByte, ? extends R> function1) {
        Intrinsics.checkNotNullParameter($this$maxBy_u2dJOV_ifY, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (UByteArray.m85isEmptyimpl($this$maxBy_u2dJOV_ifY)) {
            return null;
        }
        byte bM82getw2LRezQ = UByteArray.m82getw2LRezQ($this$maxBy_u2dJOV_ifY, 0);
        int lastIndex = ArraysKt.getLastIndex($this$maxBy_u2dJOV_ifY);
        if (lastIndex != 0) {
            R rInvoke = function1.invoke(UByte.m18boximpl(bM82getw2LRezQ));
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    byte bM82getw2LRezQ2 = UByteArray.m82getw2LRezQ($this$maxBy_u2dJOV_ifY, i);
                    R rInvoke2 = function1.invoke(UByte.m18boximpl(bM82getw2LRezQ2));
                    if (rInvoke.compareTo(rInvoke2) < 0) {
                        bM82getw2LRezQ = bM82getw2LRezQ2;
                        rInvoke = rInvoke2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        return UByte.m18boximpl(bM82getw2LRezQ);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    private static final  <R extends Comparable<? super R>> UShort m499maxByxTcfx_M(short[] $this$maxBy_u2dxTcfx_M, Function1<? super UShort, ? extends R> function1) {
        Intrinsics.checkNotNullParameter($this$maxBy_u2dxTcfx_M, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (UShortArray.m348isEmptyimpl($this$maxBy_u2dxTcfx_M)) {
            return null;
        }
        short sM345getMh2AYeg = UShortArray.m345getMh2AYeg($this$maxBy_u2dxTcfx_M, 0);
        int lastIndex = ArraysKt.getLastIndex($this$maxBy_u2dxTcfx_M);
        if (lastIndex != 0) {
            R rInvoke = function1.invoke(UShort.m281boximpl(sM345getMh2AYeg));
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    short sM345getMh2AYeg2 = UShortArray.m345getMh2AYeg($this$maxBy_u2dxTcfx_M, i);
                    R rInvoke2 = function1.invoke(UShort.m281boximpl(sM345getMh2AYeg2));
                    if (rInvoke.compareTo(rInvoke2) < 0) {
                        sM345getMh2AYeg = sM345getMh2AYeg2;
                        rInvoke = rInvoke2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        return UShort.m281boximpl(sM345getMh2AYeg);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  UInt m501maxWithYmdZ_VM(int[] $this$maxWith_u2dYmdZ_VM, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$maxWith_u2dYmdZ_VM, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m894maxWithOrNullYmdZ_VM($this$maxWith_u2dYmdZ_VM, comparator);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  ULong m503maxWithzrEWJaI(long[] $this$maxWith_u2dzrEWJaI, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$maxWith_u2dzrEWJaI, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m896maxWithOrNullzrEWJaI($this$maxWith_u2dzrEWJaI, comparator);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  UByte m500maxWithXMRcp5o(byte[] $this$maxWith_u2dXMRcp5o, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$maxWith_u2dXMRcp5o, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m893maxWithOrNullXMRcp5o($this$maxWith_u2dXMRcp5o, comparator);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  UShort m502maxWitheOHTfZs(short[] $this$maxWith_u2deOHTfZs, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$maxWith_u2deOHTfZs, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m895maxWithOrNulleOHTfZs($this$maxWith_u2deOHTfZs, comparator);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  UInt m504minajY9A(int[] $this$min_u2d_u2dajY_u2d9A) {
        Intrinsics.checkNotNullParameter($this$min_u2d_u2dajY_u2d9A, "$this$min");
        return UArraysKt.m941minOrNullajY9A($this$min_u2d_u2dajY_u2d9A);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  ULong m506minQwZRm1k(long[] $this$min_u2dQwZRm1k) {
        Intrinsics.checkNotNullParameter($this$min_u2dQwZRm1k, "$this$min");
        return UArraysKt.m943minOrNullQwZRm1k($this$min_u2dQwZRm1k);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  UByte m505minGBYM_sE(byte[] $this$min_u2dGBYM_sE) {
        Intrinsics.checkNotNullParameter($this$min_u2dGBYM_sE, "$this$min");
        return UArraysKt.m942minOrNullGBYM_sE($this$min_u2dGBYM_sE);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  UShort m507minrL5Bavg(short[] $this$min_u2drL5Bavg) {
        Intrinsics.checkNotNullParameter($this$min_u2drL5Bavg, "$this$min");
        return UArraysKt.m944minOrNullrL5Bavg($this$min_u2drL5Bavg);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    private static final  <R extends Comparable<? super R>> UInt m510minByjgv0xPQ(int[] $this$minBy_u2djgv0xPQ, Function1<? super UInt, ? extends R> function1) {
        Intrinsics.checkNotNullParameter($this$minBy_u2djgv0xPQ, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (UIntArray.m164isEmptyimpl($this$minBy_u2djgv0xPQ)) {
            return null;
        }
        int iM161getpVg5ArA = UIntArray.m161getpVg5ArA($this$minBy_u2djgv0xPQ, 0);
        int lastIndex = ArraysKt.getLastIndex($this$minBy_u2djgv0xPQ);
        if (lastIndex != 0) {
            R rInvoke = function1.invoke(UInt.m95boximpl(iM161getpVg5ArA));
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    int iM161getpVg5ArA2 = UIntArray.m161getpVg5ArA($this$minBy_u2djgv0xPQ, i);
                    R rInvoke2 = function1.invoke(UInt.m95boximpl(iM161getpVg5ArA2));
                    if (rInvoke.compareTo(rInvoke2) > 0) {
                        iM161getpVg5ArA = iM161getpVg5ArA2;
                        rInvoke = rInvoke2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        return UInt.m95boximpl(iM161getpVg5ArA);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    private static final  <R extends Comparable<? super R>> ULong m509minByMShoTSo(long[] $this$minBy_u2dMShoTSo, Function1<? super ULong, ? extends R> function1) {
        Intrinsics.checkNotNullParameter($this$minBy_u2dMShoTSo, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (ULongArray.m243isEmptyimpl($this$minBy_u2dMShoTSo)) {
            return null;
        }
        long jM240getsVKNKU = ULongArray.m240getsVKNKU($this$minBy_u2dMShoTSo, 0);
        int lastIndex = ArraysKt.getLastIndex($this$minBy_u2dMShoTSo);
        if (lastIndex != 0) {
            R rInvoke = function1.invoke(ULong.m174boximpl(jM240getsVKNKU));
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    long jM240getsVKNKU2 = ULongArray.m240getsVKNKU($this$minBy_u2dMShoTSo, i);
                    R rInvoke2 = function1.invoke(ULong.m174boximpl(jM240getsVKNKU2));
                    if (rInvoke.compareTo(rInvoke2) > 0) {
                        jM240getsVKNKU = jM240getsVKNKU2;
                        rInvoke = rInvoke2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        return ULong.m174boximpl(jM240getsVKNKU);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    private static final  <R extends Comparable<? super R>> UByte m508minByJOV_ifY(byte[] $this$minBy_u2dJOV_ifY, Function1<? super UByte, ? extends R> function1) {
        Intrinsics.checkNotNullParameter($this$minBy_u2dJOV_ifY, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (UByteArray.m85isEmptyimpl($this$minBy_u2dJOV_ifY)) {
            return null;
        }
        byte bM82getw2LRezQ = UByteArray.m82getw2LRezQ($this$minBy_u2dJOV_ifY, 0);
        int lastIndex = ArraysKt.getLastIndex($this$minBy_u2dJOV_ifY);
        if (lastIndex != 0) {
            R rInvoke = function1.invoke(UByte.m18boximpl(bM82getw2LRezQ));
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    byte bM82getw2LRezQ2 = UByteArray.m82getw2LRezQ($this$minBy_u2dJOV_ifY, i);
                    R rInvoke2 = function1.invoke(UByte.m18boximpl(bM82getw2LRezQ2));
                    if (rInvoke.compareTo(rInvoke2) > 0) {
                        bM82getw2LRezQ = bM82getw2LRezQ2;
                        rInvoke = rInvoke2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        return UByte.m18boximpl(bM82getw2LRezQ);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    private static final  <R extends Comparable<? super R>> UShort m511minByxTcfx_M(short[] $this$minBy_u2dxTcfx_M, Function1<? super UShort, ? extends R> function1) {
        Intrinsics.checkNotNullParameter($this$minBy_u2dxTcfx_M, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (UShortArray.m348isEmptyimpl($this$minBy_u2dxTcfx_M)) {
            return null;
        }
        short sM345getMh2AYeg = UShortArray.m345getMh2AYeg($this$minBy_u2dxTcfx_M, 0);
        int lastIndex = ArraysKt.getLastIndex($this$minBy_u2dxTcfx_M);
        if (lastIndex != 0) {
            R rInvoke = function1.invoke(UShort.m281boximpl(sM345getMh2AYeg));
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    short sM345getMh2AYeg2 = UShortArray.m345getMh2AYeg($this$minBy_u2dxTcfx_M, i);
                    R rInvoke2 = function1.invoke(UShort.m281boximpl(sM345getMh2AYeg2));
                    if (rInvoke.compareTo(rInvoke2) > 0) {
                        sM345getMh2AYeg = sM345getMh2AYeg2;
                        rInvoke = rInvoke2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        return UShort.m281boximpl(sM345getMh2AYeg);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  UInt m513minWithYmdZ_VM(int[] $this$minWith_u2dYmdZ_VM, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$minWith_u2dYmdZ_VM, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m950minWithOrNullYmdZ_VM($this$minWith_u2dYmdZ_VM, comparator);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  ULong m515minWithzrEWJaI(long[] $this$minWith_u2dzrEWJaI, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$minWith_u2dzrEWJaI, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m952minWithOrNullzrEWJaI($this$minWith_u2dzrEWJaI, comparator);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  UByte m512minWithXMRcp5o(byte[] $this$minWith_u2dXMRcp5o, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$minWith_u2dXMRcp5o, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m949minWithOrNullXMRcp5o($this$minWith_u2dXMRcp5o, comparator);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  UShort m514minWitheOHTfZs(short[] $this$minWith_u2deOHTfZs, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$minWith_u2deOHTfZs, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m951minWithOrNulleOHTfZs($this$minWith_u2deOHTfZs, comparator);
    }

    private static final BigDecimal sumOfBigDecimal(int[] $this$sumOf_u2djgv0xPQ, Function1<? super UInt, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2djgv0xPQ, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal sum = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(...)");
        int iM162getSizeimpl = UIntArray.m162getSizeimpl($this$sumOf_u2djgv0xPQ);
        for (int i = 0; i < iM162getSizeimpl; i++) {
            int element = UIntArray.m161getpVg5ArA($this$sumOf_u2djgv0xPQ, i);
            BigDecimal bigDecimalAdd = sum.add(function1.invoke(UInt.m95boximpl(element)));
            Intrinsics.checkNotNullExpressionValue(bigDecimalAdd, "add(...)");
            sum = bigDecimalAdd;
        }
        return sum;
    }

    private static final BigDecimal sumOfBigDecimal(long[] $this$sumOf_u2dMShoTSo, Function1<? super ULong, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2dMShoTSo, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal sum = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(...)");
        int iM241getSizeimpl = ULongArray.m241getSizeimpl($this$sumOf_u2dMShoTSo);
        for (int i = 0; i < iM241getSizeimpl; i++) {
            long element = ULongArray.m240getsVKNKU($this$sumOf_u2dMShoTSo, i);
            BigDecimal bigDecimalAdd = sum.add(function1.invoke(ULong.m174boximpl(element)));
            Intrinsics.checkNotNullExpressionValue(bigDecimalAdd, "add(...)");
            sum = bigDecimalAdd;
        }
        return sum;
    }

    private static final BigDecimal sumOfBigDecimal(byte[] $this$sumOf_u2dJOV_ifY, Function1<? super UByte, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2dJOV_ifY, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal sum = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(...)");
        int iM83getSizeimpl = UByteArray.m83getSizeimpl($this$sumOf_u2dJOV_ifY);
        for (int i = 0; i < iM83getSizeimpl; i++) {
            byte element = UByteArray.m82getw2LRezQ($this$sumOf_u2dJOV_ifY, i);
            BigDecimal bigDecimalAdd = sum.add(function1.invoke(UByte.m18boximpl(element)));
            Intrinsics.checkNotNullExpressionValue(bigDecimalAdd, "add(...)");
            sum = bigDecimalAdd;
        }
        return sum;
    }

    private static final BigDecimal sumOfBigDecimal(short[] $this$sumOf_u2dxTcfx_M, Function1<? super UShort, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2dxTcfx_M, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal sum = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(...)");
        int iM346getSizeimpl = UShortArray.m346getSizeimpl($this$sumOf_u2dxTcfx_M);
        for (int i = 0; i < iM346getSizeimpl; i++) {
            short element = UShortArray.m345getMh2AYeg($this$sumOf_u2dxTcfx_M, i);
            BigDecimal bigDecimalAdd = sum.add(function1.invoke(UShort.m281boximpl(element)));
            Intrinsics.checkNotNullExpressionValue(bigDecimalAdd, "add(...)");
            sum = bigDecimalAdd;
        }
        return sum;
    }

    private static final BigInteger sumOfBigInteger(int[] $this$sumOf_u2djgv0xPQ, Function1<? super UInt, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2djgv0xPQ, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger sum = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(...)");
        int iM162getSizeimpl = UIntArray.m162getSizeimpl($this$sumOf_u2djgv0xPQ);
        for (int i = 0; i < iM162getSizeimpl; i++) {
            int element = UIntArray.m161getpVg5ArA($this$sumOf_u2djgv0xPQ, i);
            BigInteger bigIntegerAdd = sum.add(function1.invoke(UInt.m95boximpl(element)));
            Intrinsics.checkNotNullExpressionValue(bigIntegerAdd, "add(...)");
            sum = bigIntegerAdd;
        }
        return sum;
    }

    private static final BigInteger sumOfBigInteger(long[] $this$sumOf_u2dMShoTSo, Function1<? super ULong, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2dMShoTSo, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger sum = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(...)");
        int iM241getSizeimpl = ULongArray.m241getSizeimpl($this$sumOf_u2dMShoTSo);
        for (int i = 0; i < iM241getSizeimpl; i++) {
            long element = ULongArray.m240getsVKNKU($this$sumOf_u2dMShoTSo, i);
            BigInteger bigIntegerAdd = sum.add(function1.invoke(ULong.m174boximpl(element)));
            Intrinsics.checkNotNullExpressionValue(bigIntegerAdd, "add(...)");
            sum = bigIntegerAdd;
        }
        return sum;
    }

    private static final BigInteger sumOfBigInteger(byte[] $this$sumOf_u2dJOV_ifY, Function1<? super UByte, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2dJOV_ifY, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger sum = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(...)");
        int iM83getSizeimpl = UByteArray.m83getSizeimpl($this$sumOf_u2dJOV_ifY);
        for (int i = 0; i < iM83getSizeimpl; i++) {
            byte element = UByteArray.m82getw2LRezQ($this$sumOf_u2dJOV_ifY, i);
            BigInteger bigIntegerAdd = sum.add(function1.invoke(UByte.m18boximpl(element)));
            Intrinsics.checkNotNullExpressionValue(bigIntegerAdd, "add(...)");
            sum = bigIntegerAdd;
        }
        return sum;
    }

    private static final BigInteger sumOfBigInteger(short[] $this$sumOf_u2dxTcfx_M, Function1<? super UShort, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2dxTcfx_M, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger sum = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(...)");
        int iM346getSizeimpl = UShortArray.m346getSizeimpl($this$sumOf_u2dxTcfx_M);
        for (int i = 0; i < iM346getSizeimpl; i++) {
            short element = UShortArray.m345getMh2AYeg($this$sumOf_u2dxTcfx_M, i);
            BigInteger bigIntegerAdd = sum.add(function1.invoke(UShort.m281boximpl(element)));
            Intrinsics.checkNotNullExpressionValue(bigIntegerAdd, "add(...)");
            sum = bigIntegerAdd;
        }
        return sum;
    }
}
