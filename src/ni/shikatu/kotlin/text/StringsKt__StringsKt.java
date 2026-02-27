package ni.shikatu.kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.collections.CharIterator;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.IntProgression;
import ni.shikatu.kotlin.ranges.IntRange;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlin.sequences.Sequence;
import ni.shikatu.kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\bø\u0001\u0000\u001a$\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\bø\u0001\u0000\u001a$\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\bø\u0001\u0000\u001a$\u0010\u0007\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\bø\u0001\u0000\u001a$\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\bø\u0001\u0000\u001a$\u0010\b\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\bø\u0001\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\n\u0010\t\u001a\u00020\n\"\u00020\u0004\u001a\u0016\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0004\u001a\u0016\u0010\u0007\u001a\u00020\u0006*\u00020\u00062\n\u0010\t\u001a\u00020\n\"\u00020\u0004\u001a\u0016\u0010\b\u001a\u00020\u0001*\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0004\u001a\u0016\u0010\b\u001a\u00020\u0006*\u00020\u00062\n\u0010\t\u001a\u00020\n\"\u00020\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\r\u0010\u0000\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0001\u001a\r\u0010\u0007\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0001\u001a\r\u0010\b\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\u001c\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u001a\u001c\u0010\u000b\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u001a\u001c\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u001a\u001c\u0010\u000f\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u001a \u0010\u0010\u001a\u00020\u0005*\u0004\u0018\u00010\u0001H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u0010\u0011\u001a\u00020\u0005*\u00020\u0001H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u0005*\u00020\u0001H\u0087\b\u001a\n\u0010\u0013\u001a\u00020\u0005*\u00020\u0001\u001a\r\u0010\u0014\u001a\u00020\u0005*\u00020\u0001H\u0087\b\u001a \u0010\u0015\u001a\u00020\u0005*\u0004\u0018\u00010\u0001H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u0010\u0016\u001a\u00020\u0017*\u00020\u0001H\u0086\u0002\u001a\u000f\u0010\u0018\u001a\u00020\u0006*\u0004\u0018\u00010\u0006H\u0087\b\u001aD\u0010\u0019\u001a\u0002H\u001a\"\f\b\u0000\u0010\u001b*\u00020\u0001*\u0002H\u001a\"\u0004\b\u0001\u0010\u001a*\u0002H\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001dH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u001e\u001aD\u0010\u001f\u001a\u0002H\u001a\"\f\b\u0000\u0010\u001b*\u00020\u0001*\u0002H\u001a\"\u0004\b\u0001\u0010\u001a*\u0002H\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001dH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u001e\u001a\u0012\u0010'\u001a\u00020\u0005*\u00020\u00012\u0006\u0010(\u001a\u00020\r\u001a\u0012\u0010)\u001a\u00020\u0006*\u00020\u00062\u0006\u0010*\u001a\u00020!\u001a\u0012\u0010+\u001a\u00020\u0001*\u00020\u00012\u0006\u0010*\u001a\u00020!\u001a\u001d\u0010+\u001a\u00020\u0001*\u00020\u00062\u0006\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\rH\u0087\b\u001a\u001f\u0010)\u001a\u00020\u0006*\u00020\u00012\u0006\u0010.\u001a\u00020\r2\b\b\u0002\u0010/\u001a\u00020\rH\u0087\b\u001a\u0012\u0010)\u001a\u00020\u0006*\u00020\u00012\u0006\u0010*\u001a\u00020!\u001a\u001c\u00100\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u0006\u001a\u001c\u00100\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a\u001c\u00103\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u0006\u001a\u001c\u00103\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a\u001c\u00104\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u0006\u001a\u001c\u00104\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a\u001c\u00105\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u0006\u001a\u001c\u00105\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a\"\u00106\u001a\u00020\u0001*\u00020\u00012\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r2\u0006\u00107\u001a\u00020\u0001\u001a%\u00106\u001a\u00020\u0006*\u00020\u00062\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r2\u0006\u00107\u001a\u00020\u0001H\u0087\b\u001a\u001a\u00106\u001a\u00020\u0001*\u00020\u00012\u0006\u0010*\u001a\u00020!2\u0006\u00107\u001a\u00020\u0001\u001a\u001d\u00106\u001a\u00020\u0006*\u00020\u00062\u0006\u0010*\u001a\u00020!2\u0006\u00107\u001a\u00020\u0001H\u0087\b\u001a\u001a\u00108\u001a\u00020\u0001*\u00020\u00012\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r\u001a\u001d\u00108\u001a\u00020\u0006*\u00020\u00062\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\rH\u0087\b\u001a\u0012\u00108\u001a\u00020\u0001*\u00020\u00012\u0006\u0010*\u001a\u00020!\u001a\u0015\u00108\u001a\u00020\u0006*\u00020\u00062\u0006\u0010*\u001a\u00020!H\u0087\b\u001a\u0012\u00109\u001a\u00020\u0001*\u00020\u00012\u0006\u0010:\u001a\u00020\u0001\u001a\u0012\u00109\u001a\u00020\u0006*\u00020\u00062\u0006\u0010:\u001a\u00020\u0001\u001a\u0012\u0010;\u001a\u00020\u0001*\u00020\u00012\u0006\u0010<\u001a\u00020\u0001\u001a\u0012\u0010;\u001a\u00020\u0006*\u00020\u00062\u0006\u0010<\u001a\u00020\u0001\u001a\u001a\u0010=\u001a\u00020\u0001*\u00020\u00012\u0006\u0010:\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u0001\u001a\u001a\u0010=\u001a\u00020\u0006*\u00020\u00062\u0006\u0010:\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u0001\u001a\u0012\u0010=\u001a\u00020\u0001*\u00020\u00012\u0006\u00101\u001a\u00020\u0001\u001a\u0012\u0010=\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u0001\u001a$\u0010>\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a$\u0010>\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a$\u0010?\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a$\u0010?\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a$\u0010@\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a$\u0010@\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a$\u0010A\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a$\u0010A\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a\u001d\u0010B\u001a\u00020\u0006*\u00020\u00012\u0006\u0010C\u001a\u00020D2\u0006\u00107\u001a\u00020\u0006H\u0087\b\u001a.\u0010B\u001a\u00020\u0006*\u00020\u00012\u0006\u0010C\u001a\u00020D2\u0014\b\b\u0010E\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\u00010\u0003H\u0087\bø\u0001\u0000\u001a\u001d\u0010G\u001a\u00020\u0006*\u00020\u00012\u0006\u0010C\u001a\u00020D2\u0006\u00107\u001a\u00020\u0006H\u0087\b\u001a)\u0010H\u001a\u00020\u0006*\u00020\u00062\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\bø\u0001\u0000¢\u0006\u0002\bI\u001a)\u0010H\u001a\u00020\u0006*\u00020\u00062\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0087\bø\u0001\u0000¢\u0006\u0002\bJ\u001a\u0015\u0010K\u001a\u00020\u0005*\u00020\u00012\u0006\u0010C\u001a\u00020DH\u0087\f\u001a4\u0010L\u001a\u00020\u0005*\u00020\u00012\u0006\u0010M\u001a\u00020\r2\u0006\u0010N\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010P\u001a\u00020\u0005H\u0000\u001a\u001c\u0010Q\u001a\u00020\u0005*\u00020\u00012\u0006\u0010R\u001a\u00020\u00042\b\b\u0002\u0010P\u001a\u00020\u0005\u001a\u001c\u0010S\u001a\u00020\u0005*\u00020\u00012\u0006\u0010R\u001a\u00020\u00042\b\b\u0002\u0010P\u001a\u00020\u0005\u001a\u001c\u0010Q\u001a\u00020\u0005*\u00020\u00012\u0006\u0010:\u001a\u00020\u00012\b\b\u0002\u0010P\u001a\u00020\u0005\u001a$\u0010Q\u001a\u00020\u0005*\u00020\u00012\u0006\u0010:\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a\u001c\u0010S\u001a\u00020\u0005*\u00020\u00012\u0006\u0010<\u001a\u00020\u00012\b\b\u0002\u0010P\u001a\u00020\u0005\u001a\u001c\u0010T\u001a\u00020\u0006*\u00020\u00012\u0006\u0010N\u001a\u00020\u00012\b\b\u0002\u0010P\u001a\u00020\u0005\u001a\u001c\u0010U\u001a\u00020\u0006*\u00020\u00012\u0006\u0010N\u001a\u00020\u00012\b\b\u0002\u0010P\u001a\u00020\u0005\u001a&\u0010V\u001a\u00020\r*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a&\u0010W\u001a\u00020\r*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a;\u0010X\u001a\u00020\r*\u00020\u00012\u0006\u0010N\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r2\u0006\u0010P\u001a\u00020\u00052\b\b\u0002\u0010Y\u001a\u00020\u0005H\u0002¢\u0006\u0002\bZ\u001aE\u0010[\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\\*\u00020\u00012\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00060^2\u0006\u0010.\u001a\u00020\r2\u0006\u0010P\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u0005H\u0002¢\u0006\u0002\b_\u001a:\u0010[\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\\*\u00020\u00012\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00060^2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a:\u0010`\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\\*\u00020\u00012\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00060^2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a,\u0010V\u001a\u00020\r*\u00020\u00012\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00060^2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a,\u0010W\u001a\u00020\r*\u00020\u00012\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00060^2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a&\u0010X\u001a\u00020\r*\u00020\u00012\u0006\u0010R\u001a\u00020\u00042\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a&\u0010X\u001a\u00020\r*\u00020\u00012\u0006\u0010a\u001a\u00020\u00062\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a&\u0010b\u001a\u00020\r*\u00020\u00012\u0006\u0010R\u001a\u00020\u00042\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a&\u0010b\u001a\u00020\r*\u00020\u00012\u0006\u0010a\u001a\u00020\u00062\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a\u001f\u0010c\u001a\u00020\u0005*\u00020\u00012\u0006\u0010N\u001a\u00020\u00012\b\b\u0002\u0010P\u001a\u00020\u0005H\u0086\u0002\u001a\u001f\u0010c\u001a\u00020\u0005*\u00020\u00012\u0006\u0010R\u001a\u00020\u00042\b\b\u0002\u0010P\u001a\u00020\u0005H\u0086\u0002\u001a\u0015\u0010c\u001a\u00020\u0005*\u00020\u00012\u0006\u0010C\u001a\u00020DH\u0087\n\u001a=\u0010d\u001a\b\u0012\u0004\u0012\u00020!0e*\u00020\u00012\u0006\u0010f\u001a\u00020\n2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010g\u001a\u00020\rH\u0002¢\u0006\u0002\bh\u001aG\u0010d\u001a\b\u0012\u0004\u0012\u00020!0e*\u00020\u00012\u000e\u0010f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060i2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010g\u001a\u00020\rH\u0002¢\u0006\u0004\bh\u0010j\u001a\u0010\u0010k\u001a\u00020l2\u0006\u0010g\u001a\u00020\rH\u0000\u001a=\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00060e*\u00020\u00012\u0012\u0010f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060i\"\u00020\u00062\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010g\u001a\u00020\r¢\u0006\u0002\u0010n\u001a=\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00060p*\u00020\u00012\u0012\u0010f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060i\"\u00020\u00062\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010g\u001a\u00020\r¢\u0006\u0002\u0010q\u001a0\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00060e*\u00020\u00012\n\u0010f\u001a\u00020\n\"\u00020\u00042\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010g\u001a\u00020\r\u001a0\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00060p*\u00020\u00012\n\u0010f\u001a\u00020\n\"\u00020\u00042\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010g\u001a\u00020\r\u001a/\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00060p*\u00020\u00012\u0006\u00101\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\rH\u0002¢\u0006\u0002\br\u001a%\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00060p*\u00020\u00012\u0006\u0010C\u001a\u00020D2\b\b\u0002\u0010g\u001a\u00020\rH\u0087\b\u001a%\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00060e*\u00020\u00012\u0006\u0010C\u001a\u00020D2\b\b\u0002\u0010g\u001a\u00020\rH\u0087\b\u001a\u0010\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00060e*\u00020\u0001\u001a\u0010\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00060p*\u00020\u0001\u001a\u0018\u0010u\u001a\u00020\u0005*\u0004\u0018\u00010\u00012\b\u0010N\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0018\u0010v\u001a\u00020\u0005*\u0004\u0018\u00010\u00012\b\u0010N\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\f\u0010w\u001a\u00020\u0005*\u00020\u0006H\u0007\u001a\u0013\u0010x\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0007¢\u0006\u0002\u0010y\"\u0015\u0010 \u001a\u00020!*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\"\u0010#\"\u0015\u0010$\u001a\u00020\r*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b%\u0010&\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006z"}, d2 = {"trim", "", "predicate", "Lni/shikatu/kotlin/Function1;", "", "", "", "trimStart", "trimEnd", "chars", "", "padStart", "length", "", "padChar", "padEnd", "isNullOrEmpty", "isEmpty", "isNotEmpty", "isBlank", "isNotBlank", "isNullOrBlank", "iterator", "Lni/shikatu/kotlin/collections/CharIterator;", "orEmpty", "ifEmpty", "R", "C", "defaultValue", "Lni/shikatu/kotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifBlank", "indices", "Lni/shikatu/kotlin/ranges/IntRange;", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "getLastIndex", "(Ljava/lang/CharSequence;)I", "hasSurrogatePairAt", "index", "substring", "range", "subSequence", "start", "end", "startIndex", "endIndex", "substringBefore", "delimiter", "missingDelimiterValue", "substringAfter", "substringBeforeLast", "substringAfterLast", "replaceRange", "replacement", "removeRange", "removePrefix", "prefix", "removeSuffix", "suffix", "removeSurrounding", "replaceBefore", "replaceAfter", "replaceAfterLast", "replaceBeforeLast", "replace", "regex", "Lni/shikatu/kotlin/text/Regex;", "transform", "Lni/shikatu/kotlin/text/MatchResult;", "replaceFirst", "replaceFirstChar", "replaceFirstCharWithChar", "replaceFirstCharWithCharSequence", "matches", "regionMatchesImpl", "thisOffset", "other", "otherOffset", "ignoreCase", "startsWith", "char", "endsWith", "commonPrefixWith", "commonSuffixWith", "indexOfAny", "lastIndexOfAny", "indexOf", "last", "indexOf$StringsKt__StringsKt", "findAnyOf", "Lni/shikatu/kotlin/Pair;", "strings", "", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "string", "lastIndexOf", "contains", "rangesDelimitedBy", "Lni/shikatu/kotlin/sequences/Sequence;", "delimiters", "limit", "rangesDelimitedBy$StringsKt__StringsKt", "", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "requireNonNegativeLimit", "", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "split", "", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "lineSequence", "lines", "contentEqualsIgnoreCaseImpl", "contentEqualsImpl", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "ni/shikatu/kotlin/text/StringsKt")
public class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public static final CharSequence trim(CharSequence $this$trim, Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter($this$trim, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int startIndex = 0;
        int endIndex = $this$trim.length() - 1;
        boolean startFound = false;
        while (startIndex <= endIndex) {
            int index = !startFound ? startIndex : endIndex;
            boolean match = function1.invoke(Character.valueOf($this$trim.charAt(index))).booleanValue();
            if (!startFound) {
                if (!match) {
                    startFound = true;
                } else {
                    startIndex++;
                }
            } else {
                if (!match) {
                    break;
                }
                endIndex--;
            }
        }
        return $this$trim.subSequence(startIndex, endIndex + 1);
    }

    public static final String trim(String $this$trim, Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter($this$trim, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        String $this$trim$iv = $this$trim;
        int startIndex$iv = 0;
        int endIndex$iv = $this$trim$iv.length() - 1;
        boolean startFound$iv = false;
        while (startIndex$iv <= endIndex$iv) {
            int index$iv = !startFound$iv ? startIndex$iv : endIndex$iv;
            boolean match$iv = function1.invoke(Character.valueOf($this$trim$iv.charAt(index$iv))).booleanValue();
            if (!startFound$iv) {
                if (!match$iv) {
                    startFound$iv = true;
                } else {
                    startIndex$iv++;
                }
            } else {
                if (!match$iv) {
                    break;
                }
                endIndex$iv--;
            }
        }
        return $this$trim$iv.subSequence(startIndex$iv, endIndex$iv + 1).toString();
    }

    public static final CharSequence trimStart(CharSequence $this$trimStart, Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter($this$trimStart, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = $this$trimStart.length();
        for (int index = 0; index < length; index++) {
            if (!function1.invoke(Character.valueOf($this$trimStart.charAt(index))).booleanValue()) {
                return $this$trimStart.subSequence(index, $this$trimStart.length());
            }
        }
        return "";
    }

    public static final String trimStart(String $this$trimStart, Function1<? super Character, Boolean> function1) {
        String strSubSequence;
        Intrinsics.checkNotNullParameter($this$trimStart, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        String $this$trimStart$iv = $this$trimStart;
        int length = $this$trimStart$iv.length();
        for (int index$iv = 0; index$iv < length; index$iv++) {
            if (!function1.invoke(Character.valueOf($this$trimStart$iv.charAt(index$iv))).booleanValue()) {
                strSubSequence = $this$trimStart$iv.subSequence(index$iv, $this$trimStart$iv.length());
                return strSubSequence.toString();
            }
        }
        return strSubSequence.toString();
    }

    public static final CharSequence trimEnd(CharSequence $this$trimEnd, Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter($this$trimEnd, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = $this$trimEnd.length() - 1;
        if (length >= 0) {
            do {
                int index = length;
                length--;
                if (!function1.invoke(Character.valueOf($this$trimEnd.charAt(index))).booleanValue()) {
                    return $this$trimEnd.subSequence(0, index + 1);
                }
            } while (length >= 0);
        }
        return "";
    }

    public static final String trimEnd(String $this$trimEnd, Function1<? super Character, Boolean> function1) {
        String strSubSequence;
        Intrinsics.checkNotNullParameter($this$trimEnd, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        String $this$trimEnd$iv = $this$trimEnd;
        int length = $this$trimEnd$iv.length() - 1;
        if (length >= 0) {
            do {
                int index$iv = length;
                length--;
                if (!function1.invoke(Character.valueOf($this$trimEnd$iv.charAt(index$iv))).booleanValue()) {
                    strSubSequence = $this$trimEnd$iv.subSequence(0, index$iv + 1);
                }
            } while (length >= 0);
        }
        return strSubSequence.toString();
    }

    public static final CharSequence trim(CharSequence $this$trim, char... chars) {
        Intrinsics.checkNotNullParameter($this$trim, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int startIndex$iv = 0;
        int endIndex$iv = $this$trim.length() - 1;
        boolean startFound$iv = false;
        while (startIndex$iv <= endIndex$iv) {
            int index$iv = !startFound$iv ? startIndex$iv : endIndex$iv;
            char it = $this$trim.charAt(index$iv);
            boolean match$iv = ArraysKt.contains(chars, it);
            if (!startFound$iv) {
                if (!match$iv) {
                    startFound$iv = true;
                } else {
                    startIndex$iv++;
                }
            } else {
                if (!match$iv) {
                    break;
                }
                endIndex$iv--;
            }
        }
        CharSequence $this$trim$iv = $this$trim.subSequence(startIndex$iv, endIndex$iv + 1);
        return $this$trim$iv;
    }

    public static final String trim(String $this$trim, char... chars) {
        Intrinsics.checkNotNullParameter($this$trim, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        String $this$trim$iv$iv = $this$trim;
        int startIndex$iv$iv = 0;
        int endIndex$iv$iv = $this$trim$iv$iv.length() - 1;
        boolean startFound$iv$iv = false;
        while (startIndex$iv$iv <= endIndex$iv$iv) {
            int index$iv$iv = !startFound$iv$iv ? startIndex$iv$iv : endIndex$iv$iv;
            char it = $this$trim$iv$iv.charAt(index$iv$iv);
            boolean match$iv$iv = ArraysKt.contains(chars, it);
            if (!startFound$iv$iv) {
                if (!match$iv$iv) {
                    startFound$iv$iv = true;
                } else {
                    startIndex$iv$iv++;
                }
            } else {
                if (!match$iv$iv) {
                    break;
                }
                endIndex$iv$iv--;
            }
        }
        String $this$trim$iv = $this$trim$iv$iv.subSequence(startIndex$iv$iv, endIndex$iv$iv + 1).toString();
        return $this$trim$iv;
    }

    public static final CharSequence trimStart(CharSequence $this$trimStart, char... chars) {
        Intrinsics.checkNotNullParameter($this$trimStart, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = $this$trimStart.length();
        for (int index$iv = 0; index$iv < length; index$iv++) {
            char it = $this$trimStart.charAt(index$iv);
            if (!ArraysKt.contains(chars, it)) {
                return $this$trimStart.subSequence(index$iv, $this$trimStart.length());
            }
        }
        return "";
    }

    public static final String trimStart(String $this$trimStart, char... chars) {
        String strSubSequence;
        Intrinsics.checkNotNullParameter($this$trimStart, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        String $this$trimStart$iv$iv = $this$trimStart;
        int length = $this$trimStart$iv$iv.length();
        for (int index$iv$iv = 0; index$iv$iv < length; index$iv$iv++) {
            char it = $this$trimStart$iv$iv.charAt(index$iv$iv);
            if (!ArraysKt.contains(chars, it)) {
                strSubSequence = $this$trimStart$iv$iv.subSequence(index$iv$iv, $this$trimStart$iv$iv.length());
                String $this$trimStart$iv = strSubSequence.toString();
                return $this$trimStart$iv;
            }
        }
        String $this$trimStart$iv2 = strSubSequence.toString();
        return $this$trimStart$iv2;
    }

    public static final CharSequence trimEnd(CharSequence $this$trimEnd, char... chars) {
        Intrinsics.checkNotNullParameter($this$trimEnd, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = $this$trimEnd.length() - 1;
        if (length >= 0) {
            do {
                int index$iv = length;
                length--;
                char it = $this$trimEnd.charAt(index$iv);
                if (!ArraysKt.contains(chars, it)) {
                    return $this$trimEnd.subSequence(0, index$iv + 1);
                }
            } while (length >= 0);
        }
        return "";
    }

    public static final String trimEnd(String $this$trimEnd, char... chars) {
        String strSubSequence;
        Intrinsics.checkNotNullParameter($this$trimEnd, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        String $this$trimEnd$iv$iv = $this$trimEnd;
        int length = $this$trimEnd$iv$iv.length() - 1;
        if (length >= 0) {
            do {
                int index$iv$iv = length;
                length--;
                char it = $this$trimEnd$iv$iv.charAt(index$iv$iv);
                if (!ArraysKt.contains(chars, it)) {
                    strSubSequence = $this$trimEnd$iv$iv.subSequence(0, index$iv$iv + 1);
                }
            } while (length >= 0);
        }
        String $this$trimEnd$iv = strSubSequence.toString();
        return $this$trimEnd$iv;
    }

    public static final CharSequence trim(CharSequence $this$trim) {
        Intrinsics.checkNotNullParameter($this$trim, "<this>");
        int startIndex$iv = 0;
        int endIndex$iv = $this$trim.length() - 1;
        boolean startFound$iv = false;
        while (startIndex$iv <= endIndex$iv) {
            int index$iv = !startFound$iv ? startIndex$iv : endIndex$iv;
            char p0 = $this$trim.charAt(index$iv);
            boolean match$iv = CharsKt.isWhitespace(p0);
            if (!startFound$iv) {
                if (!match$iv) {
                    startFound$iv = true;
                } else {
                    startIndex$iv++;
                }
            } else {
                if (!match$iv) {
                    break;
                }
                endIndex$iv--;
            }
        }
        CharSequence $this$trim$iv = $this$trim.subSequence(startIndex$iv, endIndex$iv + 1);
        return $this$trim$iv;
    }

    private static final String trim(String $this$trim) {
        Intrinsics.checkNotNullParameter($this$trim, "<this>");
        return StringsKt.trim((CharSequence) $this$trim).toString();
    }

    public static final CharSequence trimStart(CharSequence $this$trimStart) {
        Intrinsics.checkNotNullParameter($this$trimStart, "<this>");
        int length = $this$trimStart.length();
        for (int index$iv = 0; index$iv < length; index$iv++) {
            char p0 = $this$trimStart.charAt(index$iv);
            if (!CharsKt.isWhitespace(p0)) {
                return $this$trimStart.subSequence(index$iv, $this$trimStart.length());
            }
        }
        return "";
    }

    private static final String trimStart(String $this$trimStart) {
        Intrinsics.checkNotNullParameter($this$trimStart, "<this>");
        return StringsKt.trimStart((CharSequence) $this$trimStart).toString();
    }

    public static final CharSequence trimEnd(CharSequence $this$trimEnd) {
        Intrinsics.checkNotNullParameter($this$trimEnd, "<this>");
        int length = $this$trimEnd.length() - 1;
        if (length >= 0) {
            do {
                int index$iv = length;
                length--;
                char p0 = $this$trimEnd.charAt(index$iv);
                if (!CharsKt.isWhitespace(p0)) {
                    return $this$trimEnd.subSequence(0, index$iv + 1);
                }
            } while (length >= 0);
        }
        return "";
    }

    private static final String trimEnd(String $this$trimEnd) {
        Intrinsics.checkNotNullParameter($this$trimEnd, "<this>");
        return StringsKt.trimEnd((CharSequence) $this$trimEnd).toString();
    }

    public static  CharSequence padStart$default(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return StringsKt.padStart(charSequence, i, c);
    }

    public static final CharSequence padStart(CharSequence $this$padStart, int length, char padChar) {
        Intrinsics.checkNotNullParameter($this$padStart, "<this>");
        if (length < 0) {
            throw new IllegalArgumentException("Desired length " + length + " is less than zero.");
        }
        if (length <= $this$padStart.length()) {
            return $this$padStart.subSequence(0, $this$padStart.length());
        }
        StringBuilder sb = new StringBuilder(length);
        int i = 1;
        int length2 = length - $this$padStart.length();
        if (1 <= length2) {
            while (true) {
                sb.append(padChar);
                if (i == length2) {
                    break;
                }
                i++;
            }
        }
        sb.append($this$padStart);
        return sb;
    }

    public static  String padStart$default(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return StringsKt.padStart(str, i, c);
    }

    public static final String padStart(String $this$padStart, int length, char padChar) {
        Intrinsics.checkNotNullParameter($this$padStart, "<this>");
        return StringsKt.padStart((CharSequence) $this$padStart, length, padChar).toString();
    }

    public static  CharSequence padEnd$default(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return StringsKt.padEnd(charSequence, i, c);
    }

    public static final CharSequence padEnd(CharSequence $this$padEnd, int length, char padChar) {
        Intrinsics.checkNotNullParameter($this$padEnd, "<this>");
        if (length < 0) {
            throw new IllegalArgumentException("Desired length " + length + " is less than zero.");
        }
        if (length <= $this$padEnd.length()) {
            return $this$padEnd.subSequence(0, $this$padEnd.length());
        }
        StringBuilder sb = new StringBuilder(length);
        sb.append($this$padEnd);
        int i = 1;
        int length2 = length - $this$padEnd.length();
        if (1 <= length2) {
            while (true) {
                sb.append(padChar);
                if (i == length2) {
                    break;
                }
                i++;
            }
        }
        return sb;
    }

    public static  String padEnd$default(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return StringsKt.padEnd(str, i, c);
    }

    public static final String padEnd(String $this$padEnd, int length, char padChar) {
        Intrinsics.checkNotNullParameter($this$padEnd, "<this>");
        return StringsKt.padEnd((CharSequence) $this$padEnd, length, padChar).toString();
    }

    private static final boolean isNullOrEmpty(CharSequence $this$isNullOrEmpty) {
        return $this$isNullOrEmpty == null || $this$isNullOrEmpty.length() == 0;
    }

    private static final boolean isEmpty(CharSequence $this$isEmpty) {
        Intrinsics.checkNotNullParameter($this$isEmpty, "<this>");
        return $this$isEmpty.length() == 0;
    }

    private static final boolean isNotEmpty(CharSequence $this$isNotEmpty) {
        Intrinsics.checkNotNullParameter($this$isNotEmpty, "<this>");
        return $this$isNotEmpty.length() > 0;
    }

    public static final boolean isBlank(CharSequence $this$isBlank) {
        Intrinsics.checkNotNullParameter($this$isBlank, "<this>");
        for (int i = 0; i < $this$isBlank.length(); i++) {
            char element$iv = $this$isBlank.charAt(i);
            if (!CharsKt.isWhitespace(element$iv)) {
                return false;
            }
        }
        return true;
    }

    private static final boolean isNotBlank(CharSequence $this$isNotBlank) {
        Intrinsics.checkNotNullParameter($this$isNotBlank, "<this>");
        return !StringsKt.isBlank($this$isNotBlank);
    }

    private static final boolean isNullOrBlank(CharSequence $this$isNullOrBlank) {
        return $this$isNullOrBlank == null || StringsKt.isBlank($this$isNullOrBlank);
    }

    public static final CharIterator iterator(final CharSequence $this$iterator) {
        Intrinsics.checkNotNullParameter($this$iterator, "<this>");
        return new CharIterator() {
            private int index;

            @Override
            public char nextChar() {
                CharSequence charSequence = $this$iterator;
                int i = this.index;
                this.index = i + 1;
                return charSequence.charAt(i);
            }

            @Override
            public boolean hasNext() {
                return this.index < $this$iterator.length();
            }
        };
    }

    private static final String orEmpty(String $this$orEmpty) {
        return $this$orEmpty == null ? "" : $this$orEmpty;
    }

    private static final <C extends CharSequence & R, R> R ifEmpty(C c, Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        return c.length() == 0 ? function0.invoke() : c;
    }

    private static final <C extends CharSequence & R, R> R ifBlank(C c, Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        return StringsKt.isBlank(c) ? function0.invoke() : c;
    }

    public static final IntRange getIndices(CharSequence $this$indices) {
        Intrinsics.checkNotNullParameter($this$indices, "<this>");
        return new IntRange(0, $this$indices.length() - 1);
    }

    public static final int getLastIndex(CharSequence $this$lastIndex) {
        Intrinsics.checkNotNullParameter($this$lastIndex, "<this>");
        return $this$lastIndex.length() - 1;
    }

    public static final boolean hasSurrogatePairAt(CharSequence $this$hasSurrogatePairAt, int index) {
        Intrinsics.checkNotNullParameter($this$hasSurrogatePairAt, "<this>");
        return (index >= 0 && index <= $this$hasSurrogatePairAt.length() + (-2)) && Character.isHighSurrogate($this$hasSurrogatePairAt.charAt(index)) && Character.isLowSurrogate($this$hasSurrogatePairAt.charAt(index + 1));
    }

    public static final String substring(String $this$substring, IntRange range) {
        Intrinsics.checkNotNullParameter($this$substring, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        String strSubstring = $this$substring.substring(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final CharSequence subSequence(CharSequence $this$subSequence, IntRange range) {
        Intrinsics.checkNotNullParameter($this$subSequence, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return $this$subSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
    }

    @Deprecated(message = "Use parameters named startIndex and endIndex.", replaceWith = @ReplaceWith(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    private static final CharSequence subSequence(String $this$subSequence, int start, int end) {
        Intrinsics.checkNotNullParameter($this$subSequence, "<this>");
        return $this$subSequence.subSequence(start, end);
    }

    static  String substring$default(CharSequence $this$substring_u24default, int startIndex, int endIndex, int i, Object obj) {
        if ((i & 2) != 0) {
            endIndex = $this$substring_u24default.length();
        }
        Intrinsics.checkNotNullParameter($this$substring_u24default, "<this>");
        return $this$substring_u24default.subSequence(startIndex, endIndex).toString();
    }

    private static final String substring(CharSequence $this$substring, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$substring, "<this>");
        return $this$substring.subSequence(startIndex, endIndex).toString();
    }

    public static final String substring(CharSequence $this$substring, IntRange range) {
        Intrinsics.checkNotNullParameter($this$substring, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return $this$substring.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1).toString();
    }

    public static  String substringBefore$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringBefore(str, c, str2);
    }

    public static final String substringBefore(String $this$substringBefore, char delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter($this$substringBefore, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.indexOf$default((CharSequence) $this$substringBefore, delimiter, 0, false, 6, (Object) null);
        if (index == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = $this$substringBefore.substring(0, index);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static  String substringBefore$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.substringBefore(str, str2, str3);
    }

    public static final String substringBefore(String $this$substringBefore, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter($this$substringBefore, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.indexOf$default((CharSequence) $this$substringBefore, delimiter, 0, false, 6, (Object) null);
        if (index == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = $this$substringBefore.substring(0, index);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static  String substringAfter$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringAfter(str, c, str2);
    }

    public static final String substringAfter(String $this$substringAfter, char delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter($this$substringAfter, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.indexOf$default((CharSequence) $this$substringAfter, delimiter, 0, false, 6, (Object) null);
        if (index == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = $this$substringAfter.substring(index + 1, $this$substringAfter.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static  String substringAfter$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.substringAfter(str, str2, str3);
    }

    public static final String substringAfter(String $this$substringAfter, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter($this$substringAfter, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.indexOf$default((CharSequence) $this$substringAfter, delimiter, 0, false, 6, (Object) null);
        if (index == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = $this$substringAfter.substring(delimiter.length() + index, $this$substringAfter.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static  String substringBeforeLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringBeforeLast(str, c, str2);
    }

    public static final String substringBeforeLast(String $this$substringBeforeLast, char delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter($this$substringBeforeLast, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.lastIndexOf$default((CharSequence) $this$substringBeforeLast, delimiter, 0, false, 6, (Object) null);
        if (index == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = $this$substringBeforeLast.substring(0, index);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static  String substringBeforeLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.substringBeforeLast(str, str2, str3);
    }

    public static final String substringBeforeLast(String $this$substringBeforeLast, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter($this$substringBeforeLast, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.lastIndexOf$default((CharSequence) $this$substringBeforeLast, delimiter, 0, false, 6, (Object) null);
        if (index == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = $this$substringBeforeLast.substring(0, index);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static  String substringAfterLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringAfterLast(str, c, str2);
    }

    public static final String substringAfterLast(String $this$substringAfterLast, char delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter($this$substringAfterLast, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.lastIndexOf$default((CharSequence) $this$substringAfterLast, delimiter, 0, false, 6, (Object) null);
        if (index == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = $this$substringAfterLast.substring(index + 1, $this$substringAfterLast.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static  String substringAfterLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.substringAfterLast(str, str2, str3);
    }

    public static final String substringAfterLast(String $this$substringAfterLast, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter($this$substringAfterLast, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.lastIndexOf$default((CharSequence) $this$substringAfterLast, delimiter, 0, false, 6, (Object) null);
        if (index == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = $this$substringAfterLast.substring(delimiter.length() + index, $this$substringAfterLast.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final CharSequence replaceRange(CharSequence $this$replaceRange, int startIndex, int endIndex, CharSequence replacement) {
        Intrinsics.checkNotNullParameter($this$replaceRange, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        if (endIndex < startIndex) {
            throw new IndexOutOfBoundsException("End index (" + endIndex + ") is less than start index (" + startIndex + ").");
        }
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkNotNullExpressionValue(sb.append($this$replaceRange, 0, startIndex), "append(...)");
        sb.append(replacement);
        Intrinsics.checkNotNullExpressionValue(sb.append($this$replaceRange, endIndex, $this$replaceRange.length()), "append(...)");
        return sb;
    }

    private static final String replaceRange(String $this$replaceRange, int startIndex, int endIndex, CharSequence replacement) {
        Intrinsics.checkNotNullParameter($this$replaceRange, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return StringsKt.replaceRange((CharSequence) $this$replaceRange, startIndex, endIndex, replacement).toString();
    }

    public static final CharSequence replaceRange(CharSequence $this$replaceRange, IntRange range, CharSequence replacement) {
        Intrinsics.checkNotNullParameter($this$replaceRange, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return StringsKt.replaceRange($this$replaceRange, range.getStart().intValue(), range.getEndInclusive().intValue() + 1, replacement);
    }

    private static final String replaceRange(String $this$replaceRange, IntRange range, CharSequence replacement) {
        Intrinsics.checkNotNullParameter($this$replaceRange, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return StringsKt.replaceRange((CharSequence) $this$replaceRange, range, replacement).toString();
    }

    public static final CharSequence removeRange(CharSequence $this$removeRange, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$removeRange, "<this>");
        if (endIndex < startIndex) {
            throw new IndexOutOfBoundsException("End index (" + endIndex + ") is less than start index (" + startIndex + ").");
        }
        if (endIndex == startIndex) {
            return $this$removeRange.subSequence(0, $this$removeRange.length());
        }
        StringBuilder sb = new StringBuilder($this$removeRange.length() - (endIndex - startIndex));
        Intrinsics.checkNotNullExpressionValue(sb.append($this$removeRange, 0, startIndex), "append(...)");
        Intrinsics.checkNotNullExpressionValue(sb.append($this$removeRange, endIndex, $this$removeRange.length()), "append(...)");
        return sb;
    }

    private static final String removeRange(String $this$removeRange, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$removeRange, "<this>");
        return StringsKt.removeRange((CharSequence) $this$removeRange, startIndex, endIndex).toString();
    }

    public static final CharSequence removeRange(CharSequence $this$removeRange, IntRange range) {
        Intrinsics.checkNotNullParameter($this$removeRange, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return StringsKt.removeRange($this$removeRange, range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
    }

    private static final String removeRange(String $this$removeRange, IntRange range) {
        Intrinsics.checkNotNullParameter($this$removeRange, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return StringsKt.removeRange((CharSequence) $this$removeRange, range).toString();
    }

    public static final CharSequence removePrefix(CharSequence $this$removePrefix, CharSequence prefix) {
        Intrinsics.checkNotNullParameter($this$removePrefix, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (StringsKt.startsWith$default($this$removePrefix, prefix, false, 2, (Object) null)) {
            return $this$removePrefix.subSequence(prefix.length(), $this$removePrefix.length());
        }
        return $this$removePrefix.subSequence(0, $this$removePrefix.length());
    }

    public static final String removePrefix(String $this$removePrefix, CharSequence prefix) {
        Intrinsics.checkNotNullParameter($this$removePrefix, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (StringsKt.startsWith$default((CharSequence) $this$removePrefix, prefix, false, 2, (Object) null)) {
            String strSubstring = $this$removePrefix.substring(prefix.length());
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring;
        }
        return $this$removePrefix;
    }

    public static final CharSequence removeSuffix(CharSequence $this$removeSuffix, CharSequence suffix) {
        Intrinsics.checkNotNullParameter($this$removeSuffix, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (StringsKt.endsWith$default($this$removeSuffix, suffix, false, 2, (Object) null)) {
            return $this$removeSuffix.subSequence(0, $this$removeSuffix.length() - suffix.length());
        }
        return $this$removeSuffix.subSequence(0, $this$removeSuffix.length());
    }

    public static final String removeSuffix(String $this$removeSuffix, CharSequence suffix) {
        Intrinsics.checkNotNullParameter($this$removeSuffix, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (StringsKt.endsWith$default((CharSequence) $this$removeSuffix, suffix, false, 2, (Object) null)) {
            String strSubstring = $this$removeSuffix.substring(0, $this$removeSuffix.length() - suffix.length());
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring;
        }
        return $this$removeSuffix;
    }

    public static final CharSequence removeSurrounding(CharSequence $this$removeSurrounding, CharSequence prefix, CharSequence suffix) {
        Intrinsics.checkNotNullParameter($this$removeSurrounding, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if ($this$removeSurrounding.length() >= prefix.length() + suffix.length() && StringsKt.startsWith$default($this$removeSurrounding, prefix, false, 2, (Object) null) && StringsKt.endsWith$default($this$removeSurrounding, suffix, false, 2, (Object) null)) {
            return $this$removeSurrounding.subSequence(prefix.length(), $this$removeSurrounding.length() - suffix.length());
        }
        return $this$removeSurrounding.subSequence(0, $this$removeSurrounding.length());
    }

    public static final String removeSurrounding(String $this$removeSurrounding, CharSequence prefix, CharSequence suffix) {
        Intrinsics.checkNotNullParameter($this$removeSurrounding, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if ($this$removeSurrounding.length() >= prefix.length() + suffix.length() && StringsKt.startsWith$default((CharSequence) $this$removeSurrounding, prefix, false, 2, (Object) null) && StringsKt.endsWith$default((CharSequence) $this$removeSurrounding, suffix, false, 2, (Object) null)) {
            String strSubstring = $this$removeSurrounding.substring(prefix.length(), $this$removeSurrounding.length() - suffix.length());
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring;
        }
        return $this$removeSurrounding;
    }

    public static final CharSequence removeSurrounding(CharSequence $this$removeSurrounding, CharSequence delimiter) {
        Intrinsics.checkNotNullParameter($this$removeSurrounding, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        return StringsKt.removeSurrounding($this$removeSurrounding, delimiter, delimiter);
    }

    public static final String removeSurrounding(String $this$removeSurrounding, CharSequence delimiter) {
        Intrinsics.checkNotNullParameter($this$removeSurrounding, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        return StringsKt.removeSurrounding($this$removeSurrounding, delimiter, delimiter);
    }

    public static  String replaceBefore$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return StringsKt.replaceBefore(str, c, str2, str3);
    }

    public static final String replaceBefore(String $this$replaceBefore, char delimiter, String replacement, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter($this$replaceBefore, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.indexOf$default((CharSequence) $this$replaceBefore, delimiter, 0, false, 6, (Object) null);
        return index == -1 ? missingDelimiterValue : StringsKt.replaceRange((CharSequence) $this$replaceBefore, 0, index, (CharSequence) replacement).toString();
    }

    public static  String replaceBefore$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return StringsKt.replaceBefore(str, str2, str3, str4);
    }

    public static final String replaceBefore(String $this$replaceBefore, String delimiter, String replacement, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter($this$replaceBefore, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.indexOf$default((CharSequence) $this$replaceBefore, delimiter, 0, false, 6, (Object) null);
        return index == -1 ? missingDelimiterValue : StringsKt.replaceRange((CharSequence) $this$replaceBefore, 0, index, (CharSequence) replacement).toString();
    }

    public static  String replaceAfter$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return StringsKt.replaceAfter(str, c, str2, str3);
    }

    public static final String replaceAfter(String $this$replaceAfter, char delimiter, String replacement, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter($this$replaceAfter, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.indexOf$default((CharSequence) $this$replaceAfter, delimiter, 0, false, 6, (Object) null);
        if (index == -1) {
            return missingDelimiterValue;
        }
        return StringsKt.replaceRange((CharSequence) $this$replaceAfter, index + 1, $this$replaceAfter.length(), (CharSequence) replacement).toString();
    }

    public static  String replaceAfter$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return StringsKt.replaceAfter(str, str2, str3, str4);
    }

    public static final String replaceAfter(String $this$replaceAfter, String delimiter, String replacement, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter($this$replaceAfter, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.indexOf$default((CharSequence) $this$replaceAfter, delimiter, 0, false, 6, (Object) null);
        if (index == -1) {
            return missingDelimiterValue;
        }
        return StringsKt.replaceRange((CharSequence) $this$replaceAfter, delimiter.length() + index, $this$replaceAfter.length(), (CharSequence) replacement).toString();
    }

    public static  String replaceAfterLast$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return StringsKt.replaceAfterLast(str, str2, str3, str4);
    }

    public static final String replaceAfterLast(String $this$replaceAfterLast, String delimiter, String replacement, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter($this$replaceAfterLast, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.lastIndexOf$default((CharSequence) $this$replaceAfterLast, delimiter, 0, false, 6, (Object) null);
        if (index == -1) {
            return missingDelimiterValue;
        }
        return StringsKt.replaceRange((CharSequence) $this$replaceAfterLast, delimiter.length() + index, $this$replaceAfterLast.length(), (CharSequence) replacement).toString();
    }

    public static  String replaceAfterLast$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return StringsKt.replaceAfterLast(str, c, str2, str3);
    }

    public static final String replaceAfterLast(String $this$replaceAfterLast, char delimiter, String replacement, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter($this$replaceAfterLast, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.lastIndexOf$default((CharSequence) $this$replaceAfterLast, delimiter, 0, false, 6, (Object) null);
        if (index == -1) {
            return missingDelimiterValue;
        }
        return StringsKt.replaceRange((CharSequence) $this$replaceAfterLast, index + 1, $this$replaceAfterLast.length(), (CharSequence) replacement).toString();
    }

    public static  String replaceBeforeLast$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return StringsKt.replaceBeforeLast(str, c, str2, str3);
    }

    public static final String replaceBeforeLast(String $this$replaceBeforeLast, char delimiter, String replacement, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter($this$replaceBeforeLast, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.lastIndexOf$default((CharSequence) $this$replaceBeforeLast, delimiter, 0, false, 6, (Object) null);
        return index == -1 ? missingDelimiterValue : StringsKt.replaceRange((CharSequence) $this$replaceBeforeLast, 0, index, (CharSequence) replacement).toString();
    }

    public static  String replaceBeforeLast$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return StringsKt.replaceBeforeLast(str, str2, str3, str4);
    }

    public static final String replaceBeforeLast(String $this$replaceBeforeLast, String delimiter, String replacement, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter($this$replaceBeforeLast, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.lastIndexOf$default((CharSequence) $this$replaceBeforeLast, delimiter, 0, false, 6, (Object) null);
        return index == -1 ? missingDelimiterValue : StringsKt.replaceRange((CharSequence) $this$replaceBeforeLast, 0, index, (CharSequence) replacement).toString();
    }

    private static final String replace(CharSequence $this$replace, Regex regex, String replacement) {
        Intrinsics.checkNotNullParameter($this$replace, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return regex.replace($this$replace, replacement);
    }

    private static final String replace(CharSequence $this$replace, Regex regex, Function1<? super MatchResult, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter($this$replace, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(function1, "transform");
        return regex.replace($this$replace, function1);
    }

    private static final String replaceFirst(CharSequence $this$replaceFirst, Regex regex, String replacement) {
        Intrinsics.checkNotNullParameter($this$replaceFirst, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return regex.replaceFirst($this$replaceFirst, replacement);
    }

    private static final String replaceFirstCharWithChar(String $this$replaceFirstChar, Function1<? super Character, Character> function1) {
        Intrinsics.checkNotNullParameter($this$replaceFirstChar, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        if (!($this$replaceFirstChar.length() > 0)) {
            return $this$replaceFirstChar;
        }
        char cCharValue = function1.invoke(Character.valueOf($this$replaceFirstChar.charAt(0))).charValue();
        String strSubstring = $this$replaceFirstChar.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return cCharValue + strSubstring;
    }

    private static final String replaceFirstCharWithCharSequence(String $this$replaceFirstChar, Function1<? super Character, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter($this$replaceFirstChar, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        if (!($this$replaceFirstChar.length() > 0)) {
            return $this$replaceFirstChar;
        }
        StringBuilder sbAppend = new StringBuilder().append((Object) function1.invoke(Character.valueOf($this$replaceFirstChar.charAt(0))));
        String strSubstring = $this$replaceFirstChar.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return sbAppend.append(strSubstring).toString();
    }

    private static final boolean matches(CharSequence $this$matches, Regex regex) {
        Intrinsics.checkNotNullParameter($this$matches, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.matches($this$matches);
    }

    public static final boolean regionMatchesImpl(CharSequence $this$regionMatchesImpl, int thisOffset, CharSequence other, int otherOffset, int length, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$regionMatchesImpl, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (otherOffset < 0 || thisOffset < 0 || thisOffset > $this$regionMatchesImpl.length() - length || otherOffset > other.length() - length) {
            return false;
        }
        for (int index = 0; index < length; index++) {
            if (!CharsKt.equals($this$regionMatchesImpl.charAt(thisOffset + index), other.charAt(otherOffset + index), ignoreCase)) {
                return false;
            }
        }
        return true;
    }

    public static  boolean startsWith$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.startsWith(charSequence, c, z);
    }

    public static final boolean startsWith(CharSequence $this$startsWith, char c, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        return $this$startsWith.length() > 0 && CharsKt.equals($this$startsWith.charAt(0), c, ignoreCase);
    }

    public static  boolean endsWith$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.endsWith(charSequence, c, z);
    }

    public static final boolean endsWith(CharSequence $this$endsWith, char c, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$endsWith, "<this>");
        return $this$endsWith.length() > 0 && CharsKt.equals($this$endsWith.charAt(StringsKt.getLastIndex($this$endsWith)), c, ignoreCase);
    }

    public static  boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.startsWith(charSequence, charSequence2, z);
    }

    public static final boolean startsWith(CharSequence $this$startsWith, CharSequence prefix, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!ignoreCase && ($this$startsWith instanceof String) && (prefix instanceof String)) {
            return StringsKt.startsWith$default((String) $this$startsWith, (String) prefix, false, 2, (Object) null);
        }
        return StringsKt.regionMatchesImpl($this$startsWith, 0, prefix, 0, prefix.length(), ignoreCase);
    }

    public static  boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.startsWith(charSequence, charSequence2, i, z);
    }

    public static final boolean startsWith(CharSequence $this$startsWith, CharSequence prefix, int startIndex, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (ignoreCase || !($this$startsWith instanceof String) || !(prefix instanceof String)) {
            return StringsKt.regionMatchesImpl($this$startsWith, startIndex, prefix, 0, prefix.length(), ignoreCase);
        }
        return StringsKt.startsWith$default((String) $this$startsWith, (String) prefix, startIndex, false, 4, (Object) null);
    }

    public static  boolean endsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.endsWith(charSequence, charSequence2, z);
    }

    public static final boolean endsWith(CharSequence $this$endsWith, CharSequence suffix, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$endsWith, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (!ignoreCase && ($this$endsWith instanceof String) && (suffix instanceof String)) {
            return StringsKt.endsWith$default((String) $this$endsWith, (String) suffix, false, 2, (Object) null);
        }
        return StringsKt.regionMatchesImpl($this$endsWith, $this$endsWith.length() - suffix.length(), suffix, 0, suffix.length(), ignoreCase);
    }

    public static  String commonPrefixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.commonPrefixWith(charSequence, charSequence2, z);
    }

    public static final String commonPrefixWith(CharSequence $this$commonPrefixWith, CharSequence other, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$commonPrefixWith, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int shortestLength = Math.min($this$commonPrefixWith.length(), other.length());
        int i = 0;
        while (i < shortestLength && CharsKt.equals($this$commonPrefixWith.charAt(i), other.charAt(i), ignoreCase)) {
            i++;
        }
        if (StringsKt.hasSurrogatePairAt($this$commonPrefixWith, i - 1) || StringsKt.hasSurrogatePairAt(other, i - 1)) {
            i--;
        }
        return $this$commonPrefixWith.subSequence(0, i).toString();
    }

    public static  String commonSuffixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.commonSuffixWith(charSequence, charSequence2, z);
    }

    public static final String commonSuffixWith(CharSequence $this$commonSuffixWith, CharSequence other, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$commonSuffixWith, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int thisLength = $this$commonSuffixWith.length();
        int otherLength = other.length();
        int shortestLength = Math.min(thisLength, otherLength);
        int i = 0;
        while (i < shortestLength && CharsKt.equals($this$commonSuffixWith.charAt((thisLength - i) - 1), other.charAt((otherLength - i) - 1), ignoreCase)) {
            i++;
        }
        if (StringsKt.hasSurrogatePairAt($this$commonSuffixWith, (thisLength - i) - 1) || StringsKt.hasSurrogatePairAt(other, (otherLength - i) - 1)) {
            i--;
        }
        return $this$commonSuffixWith.subSequence(thisLength - i, thisLength).toString();
    }

    public static  int indexOfAny$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.indexOfAny(charSequence, cArr, i, z);
    }

    public static final int indexOfAny(CharSequence $this$indexOfAny, char[] chars, int startIndex, boolean ignoreCase) {
        boolean z;
        Intrinsics.checkNotNullParameter($this$indexOfAny, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        if (!ignoreCase && chars.length == 1 && ($this$indexOfAny instanceof String)) {
            return ((String) $this$indexOfAny).indexOf(ArraysKt.single(chars), startIndex);
        }
        int index = RangesKt.coerceAtLeast(startIndex, 0);
        int lastIndex = StringsKt.getLastIndex($this$indexOfAny);
        if (index > lastIndex) {
            return -1;
        }
        while (true) {
            char charAtIndex = $this$indexOfAny.charAt(index);
            int length = chars.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    char element$iv = chars[i];
                    if (CharsKt.equals(element$iv, charAtIndex, ignoreCase)) {
                        z = true;
                        break;
                    }
                    i++;
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                if (index == lastIndex) {
                    return -1;
                }
                index++;
            } else {
                return index;
            }
        }
    }

    public static  int lastIndexOfAny$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.lastIndexOfAny(charSequence, cArr, i, z);
    }

    public static final int lastIndexOfAny(CharSequence $this$lastIndexOfAny, char[] chars, int startIndex, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$lastIndexOfAny, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        if (!ignoreCase && chars.length == 1 && ($this$lastIndexOfAny instanceof String)) {
            return ((String) $this$lastIndexOfAny).lastIndexOf(ArraysKt.single(chars), startIndex);
        }
        for (int index = RangesKt.coerceAtMost(startIndex, StringsKt.getLastIndex($this$lastIndexOfAny)); -1 < index; index--) {
            char charAtIndex = $this$lastIndexOfAny.charAt(index);
            boolean z = false;
            for (char element$iv : chars) {
                if (CharsKt.equals(element$iv, charAtIndex, ignoreCase)) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return index;
            }
        }
        return -1;
    }

    static  int indexOf$StringsKt__StringsKt$default(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        return indexOf$StringsKt__StringsKt(charSequence, charSequence2, i, i2, z, z2);
    }

    private static final int indexOf$StringsKt__StringsKt(CharSequence $this$indexOf, CharSequence other, int startIndex, int endIndex, boolean ignoreCase, boolean last) {
        IntRange intRangeDownTo;
        CharSequence charSequence = other;
        if (!last) {
            intRangeDownTo = new IntRange(RangesKt.coerceAtLeast(startIndex, 0), RangesKt.coerceAtMost(endIndex, $this$indexOf.length()));
        } else {
            intRangeDownTo = RangesKt.downTo(RangesKt.coerceAtMost(startIndex, StringsKt.getLastIndex($this$indexOf)), RangesKt.coerceAtLeast(endIndex, 0));
        }
        IntProgression indices = intRangeDownTo;
        if (($this$indexOf instanceof String) && (charSequence instanceof String)) {
            int index = indices.getFirst();
            int last2 = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && index <= last2) || (step < 0 && last2 <= index)) {
                int index2 = index;
                while (!StringsKt.regionMatches((String) charSequence, 0, (String) $this$indexOf, index2, ((String) charSequence).length(), ignoreCase)) {
                    if (index2 == last2) {
                        return -1;
                    }
                    index2 += step;
                }
                return index2;
            }
            return -1;
        }
        int index3 = indices.getFirst();
        int last3 = indices.getLast();
        int step2 = indices.getStep();
        if ((step2 > 0 && index3 <= last3) || (step2 < 0 && last3 <= index3)) {
            int index4 = index3;
            while (!StringsKt.regionMatchesImpl(charSequence, 0, $this$indexOf, index4, charSequence.length(), ignoreCase)) {
                if (index4 == last3) {
                    return -1;
                }
                index4 += step2;
                charSequence = other;
            }
            return index4;
        }
        return -1;
    }

    private static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(CharSequence $this$findAnyOf, Collection<String> collection, int startIndex, boolean ignoreCase, boolean last) {
        IntRange intRangeDownTo;
        Object element$iv;
        String it;
        Object element$iv2;
        String it2;
        if (!ignoreCase && collection.size() == 1) {
            String string = (String) CollectionsKt.single(collection);
            int index = !last ? StringsKt.indexOf$default($this$findAnyOf, string, startIndex, false, 4, (Object) null) : StringsKt.lastIndexOf$default($this$findAnyOf, string, startIndex, false, 4, (Object) null);
            if (index < 0) {
                return null;
            }
            return TuplesKt.to(Integer.valueOf(index), string);
        }
        if (!last) {
            intRangeDownTo = new IntRange(RangesKt.coerceAtLeast(startIndex, 0), $this$findAnyOf.length());
        } else {
            intRangeDownTo = RangesKt.downTo(RangesKt.coerceAtMost(startIndex, StringsKt.getLastIndex($this$findAnyOf)), 0);
        }
        IntProgression indices = intRangeDownTo;
        if ($this$findAnyOf instanceof String) {
            int index2 = indices.getFirst();
            int last2 = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && index2 <= last2) || (step < 0 && last2 <= index2)) {
                int index3 = index2;
                while (true) {
                    Collection<String> $this$firstOrNull$iv = collection;
                    Iterator it3 = $this$firstOrNull$iv.iterator();
                    do {
                        if (!it3.hasNext()) {
                            element$iv2 = null;
                            break;
                        }
                        element$iv2 = it3.next();
                        it2 = (String) element$iv2;
                    } while (!StringsKt.regionMatches(it2, 0, (String) $this$findAnyOf, index3, it2.length(), ignoreCase));
                    String matchingString = (String) element$iv2;
                    if (matchingString == null) {
                        if (index3 != last2) {
                            index3 += step;
                        }
                    } else {
                        return TuplesKt.to(Integer.valueOf(index3), matchingString);
                    }
                }
            }
        } else {
            int index4 = indices.getFirst();
            int last3 = indices.getLast();
            int step2 = indices.getStep();
            if ((step2 > 0 && index4 <= last3) || (step2 < 0 && last3 <= index4)) {
                int index5 = index4;
                while (true) {
                    Collection<String> $this$firstOrNull$iv2 = collection;
                    Iterator it4 = $this$firstOrNull$iv2.iterator();
                    do {
                        if (!it4.hasNext()) {
                            element$iv = null;
                            break;
                        }
                        element$iv = it4.next();
                        it = (String) element$iv;
                    } while (!StringsKt.regionMatchesImpl(it, 0, $this$findAnyOf, index5, it.length(), ignoreCase));
                    String matchingString2 = (String) element$iv;
                    if (matchingString2 == null) {
                        if (index5 != last3) {
                            index5 += step2;
                        }
                    } else {
                        return TuplesKt.to(Integer.valueOf(index5), matchingString2);
                    }
                }
            }
        }
        return null;
    }

    public static  Pair findAnyOf$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.findAnyOf(charSequence, collection, i, z);
    }

    public static final Pair<Integer, String> findAnyOf(CharSequence $this$findAnyOf, Collection<String> collection, int startIndex, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$findAnyOf, "<this>");
        Intrinsics.checkNotNullParameter(collection, "strings");
        return findAnyOf$StringsKt__StringsKt($this$findAnyOf, collection, startIndex, ignoreCase, false);
    }

    public static  Pair findLastAnyOf$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.findLastAnyOf(charSequence, collection, i, z);
    }

    public static final Pair<Integer, String> findLastAnyOf(CharSequence $this$findLastAnyOf, Collection<String> collection, int startIndex, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$findLastAnyOf, "<this>");
        Intrinsics.checkNotNullParameter(collection, "strings");
        return findAnyOf$StringsKt__StringsKt($this$findLastAnyOf, collection, startIndex, ignoreCase, true);
    }

    public static  int indexOfAny$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.indexOfAny(charSequence, (Collection<String>) collection, i, z);
    }

    public static final int indexOfAny(CharSequence $this$indexOfAny, Collection<String> collection, int startIndex, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$indexOfAny, "<this>");
        Intrinsics.checkNotNullParameter(collection, "strings");
        Pair<Integer, String> pairFindAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt($this$indexOfAny, collection, startIndex, ignoreCase, false);
        if (pairFindAnyOf$StringsKt__StringsKt != null) {
            return pairFindAnyOf$StringsKt__StringsKt.getFirst().intValue();
        }
        return -1;
    }

    public static  int lastIndexOfAny$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.lastIndexOfAny(charSequence, (Collection<String>) collection, i, z);
    }

    public static final int lastIndexOfAny(CharSequence $this$lastIndexOfAny, Collection<String> collection, int startIndex, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$lastIndexOfAny, "<this>");
        Intrinsics.checkNotNullParameter(collection, "strings");
        Pair<Integer, String> pairFindAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt($this$lastIndexOfAny, collection, startIndex, ignoreCase, true);
        if (pairFindAnyOf$StringsKt__StringsKt != null) {
            return pairFindAnyOf$StringsKt__StringsKt.getFirst().intValue();
        }
        return -1;
    }

    public static  int indexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.indexOf(charSequence, c, i, z);
    }

    public static final int indexOf(CharSequence $this$indexOf, char c, int startIndex, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$indexOf, "<this>");
        return (ignoreCase || !($this$indexOf instanceof String)) ? StringsKt.indexOfAny($this$indexOf, new char[]{c}, startIndex, ignoreCase) : ((String) $this$indexOf).indexOf(c, startIndex);
    }

    public static  int indexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.indexOf(charSequence, str, i, z);
    }

    public static final int indexOf(CharSequence $this$indexOf, String string, int startIndex, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$indexOf, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (ignoreCase || !($this$indexOf instanceof String)) {
            return indexOf$StringsKt__StringsKt$default($this$indexOf, string, startIndex, $this$indexOf.length(), ignoreCase, false, 16, null);
        }
        return ((String) $this$indexOf).indexOf(string, startIndex);
    }

    public static  int lastIndexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.lastIndexOf(charSequence, c, i, z);
    }

    public static final int lastIndexOf(CharSequence $this$lastIndexOf, char c, int startIndex, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$lastIndexOf, "<this>");
        return (ignoreCase || !($this$lastIndexOf instanceof String)) ? StringsKt.lastIndexOfAny($this$lastIndexOf, new char[]{c}, startIndex, ignoreCase) : ((String) $this$lastIndexOf).lastIndexOf(c, startIndex);
    }

    public static  int lastIndexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.lastIndexOf(charSequence, str, i, z);
    }

    public static final int lastIndexOf(CharSequence $this$lastIndexOf, String string, int startIndex, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$lastIndexOf, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (ignoreCase || !($this$lastIndexOf instanceof String)) {
            return indexOf$StringsKt__StringsKt($this$lastIndexOf, string, startIndex, 0, ignoreCase, true);
        }
        return ((String) $this$lastIndexOf).lastIndexOf(string, startIndex);
    }

    public static  boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.contains(charSequence, charSequence2, z);
    }

    public static final boolean contains(CharSequence $this$contains, CharSequence other, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (other instanceof String) {
            return StringsKt.indexOf$default($this$contains, (String) other, 0, ignoreCase, 2, (Object) null) >= 0;
        }
        return indexOf$StringsKt__StringsKt$default($this$contains, other, 0, $this$contains.length(), ignoreCase, false, 16, null) >= 0;
    }

    public static  boolean contains$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.contains(charSequence, c, z);
    }

    public static final boolean contains(CharSequence $this$contains, char c, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return StringsKt.indexOf$default($this$contains, c, 0, ignoreCase, 2, (Object) null) >= 0;
    }

    private static final boolean contains(CharSequence $this$contains, Regex regex) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.containsMatchIn($this$contains);
    }

    static  Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, cArr, i, z, i2);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence $this$rangesDelimitedBy, final char[] delimiters, int startIndex, final boolean ignoreCase, int limit) {
        StringsKt.requireNonNegativeLimit(limit);
        return new DelimitedRangesSequence($this$rangesDelimitedBy, startIndex, limit, new Function2() {
            @Override
            public final Object invoke(Object obj, Object obj2) {
                return StringsKt__StringsKt.rangesDelimitedBy$lambda$14$StringsKt__StringsKt(delimiters, ignoreCase, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    public static final Pair rangesDelimitedBy$lambda$14$StringsKt__StringsKt(char[] $delimiters, boolean $ignoreCase, CharSequence $this$DelimitedRangesSequence, int currentIndex) {
        Intrinsics.checkNotNullParameter($this$DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        int it = StringsKt.indexOfAny($this$DelimitedRangesSequence, $delimiters, currentIndex, $ignoreCase);
        if (it < 0) {
            return null;
        }
        return TuplesKt.to(Integer.valueOf(it), 1);
    }

    static  Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, strArr, i, z, i2);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence $this$rangesDelimitedBy, String[] delimiters, int startIndex, final boolean ignoreCase, int limit) {
        StringsKt.requireNonNegativeLimit(limit);
        final List delimitersList = ArraysKt.asList(delimiters);
        return new DelimitedRangesSequence($this$rangesDelimitedBy, startIndex, limit, new Function2() {
            @Override
            public final Object invoke(Object obj, Object obj2) {
                return StringsKt__StringsKt.rangesDelimitedBy$lambda$16$StringsKt__StringsKt(delimitersList, ignoreCase, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    public static final Pair rangesDelimitedBy$lambda$16$StringsKt__StringsKt(List $delimitersList, boolean $ignoreCase, CharSequence $this$DelimitedRangesSequence, int currentIndex) {
        Intrinsics.checkNotNullParameter($this$DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        Pair<Integer, String> pairFindAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt($this$DelimitedRangesSequence, $delimitersList, currentIndex, $ignoreCase, false);
        if (pairFindAnyOf$StringsKt__StringsKt == null) {
            return null;
        }
        Pair it = TuplesKt.to(pairFindAnyOf$StringsKt__StringsKt.getFirst(), Integer.valueOf(pairFindAnyOf$StringsKt__StringsKt.getSecond().length()));
        return it;
    }

    public static final void requireNonNegativeLimit(int limit) {
        if (!(limit >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + limit).toString());
        }
    }

    public static  Sequence splitToSequence$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return StringsKt.splitToSequence(charSequence, strArr, z, i);
    }

    public static final Sequence<String> splitToSequence(final CharSequence $this$splitToSequence, String[] delimiters, boolean ignoreCase, int limit) {
        Intrinsics.checkNotNullParameter($this$splitToSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        return SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default($this$splitToSequence, delimiters, 0, ignoreCase, limit, 2, (Object) null), new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return StringsKt__StringsKt.splitToSequence$lambda$18$StringsKt__StringsKt($this$splitToSequence, (IntRange) obj);
            }
        });
    }

    public static final String splitToSequence$lambda$18$StringsKt__StringsKt(CharSequence $this_splitToSequence, IntRange it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.substring($this_splitToSequence, it);
    }

    public static  List split$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return StringsKt.split(charSequence, strArr, z, i);
    }

    public static final List<String> split(CharSequence $this$split, String[] delimiters, boolean ignoreCase, int limit) {
        Intrinsics.checkNotNullParameter($this$split, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String delimiter = delimiters[0];
            if (!(delimiter.length() == 0)) {
                return split$StringsKt__StringsKt($this$split, delimiter, ignoreCase, limit);
            }
        }
        Iterable $this$map$iv = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default($this$split, delimiters, 0, ignoreCase, limit, 2, (Object) null));
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            IntRange it = (IntRange) item$iv$iv;
            destination$iv$iv.add(StringsKt.substring($this$split, it));
        }
        return (List) destination$iv$iv;
    }

    public static  Sequence splitToSequence$default(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return StringsKt.splitToSequence(charSequence, cArr, z, i);
    }

    public static final Sequence<String> splitToSequence(final CharSequence $this$splitToSequence, char[] delimiters, boolean ignoreCase, int limit) {
        Intrinsics.checkNotNullParameter($this$splitToSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        return SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default($this$splitToSequence, delimiters, 0, ignoreCase, limit, 2, (Object) null), new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return StringsKt__StringsKt.splitToSequence$lambda$20$StringsKt__StringsKt($this$splitToSequence, (IntRange) obj);
            }
        });
    }

    public static final String splitToSequence$lambda$20$StringsKt__StringsKt(CharSequence $this_splitToSequence, IntRange it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.substring($this_splitToSequence, it);
    }

    public static  List split$default(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return StringsKt.split(charSequence, cArr, z, i);
    }

    public static final List<String> split(CharSequence $this$split, char[] delimiters, boolean ignoreCase, int limit) {
        Intrinsics.checkNotNullParameter($this$split, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return split$StringsKt__StringsKt($this$split, String.valueOf(delimiters[0]), ignoreCase, limit);
        }
        Iterable $this$map$iv = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default($this$split, delimiters, 0, ignoreCase, limit, 2, (Object) null));
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            IntRange it = (IntRange) item$iv$iv;
            destination$iv$iv.add(StringsKt.substring($this$split, it));
        }
        return (List) destination$iv$iv;
    }

    private static final List<String> split$StringsKt__StringsKt(CharSequence $this$split, String delimiter, boolean ignoreCase, int limit) {
        StringsKt.requireNonNegativeLimit(limit);
        int currentOffset = 0;
        int nextIndex = StringsKt.indexOf($this$split, delimiter, 0, ignoreCase);
        if (nextIndex != -1) {
            if (limit != 1) {
                boolean isLimited = limit > 0;
                ArrayList result = new ArrayList(isLimited ? RangesKt.coerceAtMost(limit, 10) : 10);
                do {
                    result.add($this$split.subSequence(currentOffset, nextIndex).toString());
                    currentOffset = nextIndex + delimiter.length();
                    if (isLimited && result.size() == limit - 1) {
                        break;
                    }
                    nextIndex = StringsKt.indexOf($this$split, delimiter, currentOffset, ignoreCase);
                } while (nextIndex != -1);
                result.add($this$split.subSequence(currentOffset, $this$split.length()).toString());
                return result;
            }
        }
        return CollectionsKt.listOf($this$split.toString());
    }

    static  List split$default(CharSequence $this$split_u24default, Regex regex, int limit, int i, Object obj) {
        if ((i & 2) != 0) {
            limit = 0;
        }
        Intrinsics.checkNotNullParameter($this$split_u24default, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.split($this$split_u24default, limit);
    }

    private static final List<String> split(CharSequence $this$split, Regex regex, int limit) {
        Intrinsics.checkNotNullParameter($this$split, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.split($this$split, limit);
    }

    static  Sequence splitToSequence$default(CharSequence $this$splitToSequence_u24default, Regex regex, int limit, int i, Object obj) {
        if ((i & 2) != 0) {
            limit = 0;
        }
        Intrinsics.checkNotNullParameter($this$splitToSequence_u24default, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.splitToSequence($this$splitToSequence_u24default, limit);
    }

    private static final Sequence<String> splitToSequence(CharSequence $this$splitToSequence, Regex regex, int limit) {
        Intrinsics.checkNotNullParameter($this$splitToSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.splitToSequence($this$splitToSequence, limit);
    }

    public static final Sequence<String> lineSequence(final CharSequence $this$lineSequence) {
        Intrinsics.checkNotNullParameter($this$lineSequence, "<this>");
        return new Sequence<String>() {
            @Override
            public Iterator<String> iterator() {
                return new LinesIterator($this$lineSequence);
            }
        };
    }

    public static final List<String> lines(CharSequence $this$lines) {
        Intrinsics.checkNotNullParameter($this$lines, "<this>");
        return SequencesKt.toList(StringsKt.lineSequence($this$lines));
    }

    public static final boolean contentEqualsIgnoreCaseImpl(CharSequence $this$contentEqualsIgnoreCaseImpl, CharSequence other) {
        if (($this$contentEqualsIgnoreCaseImpl instanceof String) && (other instanceof String)) {
            return StringsKt.equals((String) $this$contentEqualsIgnoreCaseImpl, (String) other, true);
        }
        if ($this$contentEqualsIgnoreCaseImpl == other) {
            return true;
        }
        if ($this$contentEqualsIgnoreCaseImpl == null || other == null || $this$contentEqualsIgnoreCaseImpl.length() != other.length()) {
            return false;
        }
        int length = $this$contentEqualsIgnoreCaseImpl.length();
        for (int i = 0; i < length; i++) {
            if (!CharsKt.equals($this$contentEqualsIgnoreCaseImpl.charAt(i), other.charAt(i), true)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean contentEqualsImpl(CharSequence $this$contentEqualsImpl, CharSequence other) {
        if (($this$contentEqualsImpl instanceof String) && (other instanceof String)) {
            return Intrinsics.areEqual($this$contentEqualsImpl, other);
        }
        if ($this$contentEqualsImpl == other) {
            return true;
        }
        if ($this$contentEqualsImpl == null || other == null || $this$contentEqualsImpl.length() != other.length()) {
            return false;
        }
        int length = $this$contentEqualsImpl.length();
        for (int i = 0; i < length; i++) {
            if ($this$contentEqualsImpl.charAt(i) != other.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean toBooleanStrict(String $this$toBooleanStrict) {
        Intrinsics.checkNotNullParameter($this$toBooleanStrict, "<this>");
        if (Intrinsics.areEqual($this$toBooleanStrict, "true")) {
            return true;
        }
        if (Intrinsics.areEqual($this$toBooleanStrict, "false")) {
            return false;
        }
        throw new IllegalArgumentException("The string doesn't represent a boolean value: " + $this$toBooleanStrict);
    }

    public static final Boolean toBooleanStrictOrNull(String $this$toBooleanStrictOrNull) {
        Intrinsics.checkNotNullParameter($this$toBooleanStrictOrNull, "<this>");
        if (Intrinsics.areEqual($this$toBooleanStrictOrNull, "true")) {
            return true;
        }
        return Intrinsics.areEqual($this$toBooleanStrictOrNull, "false") ? false : null;
    }
}
