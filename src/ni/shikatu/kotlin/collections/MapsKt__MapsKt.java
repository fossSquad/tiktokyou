package ni.shikatu.kotlin.collections;
import java.util.Map.Entry;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.TypeIntrinsics;
import ni.shikatu.kotlin.sequences.Sequence;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000¨\u0001\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010&\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010(\n\u0002\u0010)\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u001d\u001a\"\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\u0086\u0080\u0004\u001aS\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u0006\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007H\u0086\u0080\u0004¢\u0006\u0002\u0010\b\u001a&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\u0087\u0088\u0004b\u0002\b\t\u001a4\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\u0087\u0088\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000eb\u0002\b\t\u001aS\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u0006\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007H\u0086\u0080\u0004¢\u0006\u0002\u0010\b\u001aI\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0010j\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003`\u0011\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\u0087\u0088\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000eb\u0002\b\t¢\u0006\u0002\u0010\u0012\u001ac\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0010j\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003`\u0011\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u0006\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0013\u001aI\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0015j\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003`\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\u0087\u0088\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000eb\u0002\b\t¢\u0006\u0002\u0010\u0017\u001ac\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0015j\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003`\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u0006\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0018\u001ao\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032)\b\u0001\u0010\u001a\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0002\b\u001d:\u0002\b\u001eH\u0087\u0088\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001fb\u0002\b\tø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001aw\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010 \u001a\u00020!2)\b\u0001\u0010\u001a\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0002\b\u001d:\u0002\b\u001eH\u0087\u0088\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001fb\u0002\b\tø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a,\u0010\"\u001a\u00020#\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\u0088\u0004b\u0002\b\t\u001aM\u0010$\u001a\u00020#\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001H\u0087\u0088\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(%b\u0002\b\t\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a8\u0010&\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001H\u0087\u0088\u0004b\u0002\b\t\u001a_\u0010'\u001a\u0002H(\"\u0014\b\u0000\u0010)*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001*\u0002H(\"\u0004\b\u0001\u0010(*\u0002H)2\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H(0+H\u0087\u0088\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(%b\u0002\b\tø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010,\u001a>\u0010-\u001a\u00020#\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b.\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010/\u001a\u0002H\u0002H\u0087\u008a\u0004b\u0002\b\t¢\u0006\u0002\u00100\u001a@\u00101\u001a\u0004\u0018\u0001H\u0003\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b.\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010/\u001a\u0002H\u0002H\u0087\u008a\u0004b\u0002\b\t¢\u0006\u0002\u00102\u001a?\u00103\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000b2\u0006\u0010/\u001a\u0002H\u00022\u0006\u00104\u001a\u0002H\u0003H\u0087\u008a\u0004b\u0002\b\t¢\u0006\u0002\u00105\u001a6\u00106\u001a\u00020#\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b.*\u000e\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0002\b\u00030\u00012\u0006\u0010/\u001a\u0002H\u0002H\u0087\u0088\u0004b\u0002\b\t¢\u0006\u0002\u00100\u001a<\u00107\u001a\u00020#\"\u0004\b\u0000\u0010\u0002\"\t\b\u0001\u0010\u0003¢\u0006\u0002\b.*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u00104\u001a\u0002H\u0003H\u0087\u0088\u0004b\u0002\b\t¢\u0006\u0002\u00100\u001aD\u00108\u001a\u0004\u0018\u0001H\u0003\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b.\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000b2\u0006\u0010/\u001a\u0002H\u0002H\u0087\u0088\bb\u0002\b\tb\u0002\b9¢\u0006\u0002\u00102\u001a/\u0010:\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030;H\u0087\u008a\u0004b\u0002\b\t¢\u0006\u0002\u0010<\u001a/\u0010=\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030;H\u0087\u008a\u0004b\u0002\b\t¢\u0006\u0002\u0010<\u001a6\u0010>\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030;H\u0087\u0088\u0004b\u0002\b\t\u001aD\u0010?\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030;\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030;H\u0087\u0080\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(@b\u0002\bA\u001a7\u0010B\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030;\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010/\u001a\u0002H\u00022\u0006\u00104\u001a\u0002H\u0003H\u0080\u0080\u0004¢\u0006\u0002\u0010C\u001aU\u0010D\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010/\u001a\u0002H\u00022\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u00030+H\u0087\u0088\u0004b\u0002\b\tø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0002\u0010E\u001ag\u0010F\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010/\u001a\u0002H\u00022\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u00030+H\u0087\u0088\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(Gb\u0002\b\tb\u0002\bAø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0002\u0010E\u001ag\u0010H\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010/\u001a\u0002H\u00022\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u00030+H\u0087\u0088\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(Gb\u0002\b\tb\u0002\bAø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0002\u0010E\u001aA\u0010I\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010/\u001a\u0002H\u0002H\u0087\u0080\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\u0002\u00102\u001aD\u0010J\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000b2\u0006\u0010/\u001a\u0002H\u00022\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u00030+H\u0086\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010E\u001ai\u0010K\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000b2\u0006\u0010/\u001a\u0002H\u00022\u000e\b\u0004\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u00030+H\u0087\u0088\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(Gb\u0002\b\tb\u0002\bAø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0002\u0010E\u001ai\u0010L\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000b2\u0006\u0010/\u001a\u0002H\u00022\u000e\b\u0004\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u00030+H\u0087\u0088\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(Gb\u0002\b\tb\u0002\bAø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0002\u0010E\u001a>\u0010M\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030;0N\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\u008a\u0004b\u0002\b\t\u001aO\u0010M\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030P0O\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000bH\u0087\u008a\u0004b\f\bR\u0012\b\bS\u0012\u0004\b\b(Qb\u0002\b\t¢\u0006\u0002\bQ\u001a|\u0010T\u001a\u0002H)\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010(\"\u0018\b\u0003\u0010)*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H(0\u000b*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010U\u001a\u0002H)2\u001e\u0010V\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030;\u0012\u0004\u0012\u0002H(0\u001bH\u0087\u0088\bb\u0002\b9ø\u0001\u0000¢\u0006\u0002\u0010W\u001a|\u0010X\u001a\u0002H)\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010(\"\u0018\b\u0003\u0010)*\u0012\u0012\u0006\b\u0000\u0012\u0002H(\u0012\u0006\b\u0000\u0012\u0002H\u00030\u000b*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010U\u001a\u0002H)2\u001e\u0010V\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030;\u0012\u0004\u0012\u0002H(0\u001bH\u0087\u0088\bb\u0002\b9ø\u0001\u0000¢\u0006\u0002\u0010W\u001aK\u0010Y\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\u000b2\u001a\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u0006H\u0086\u0080\u0004¢\u0006\u0002\u0010Z\u001aD\u0010Y\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\u000b2\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070[H\u0086\u0080\u0004\u001aD\u0010Y\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\u000b2\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\\H\u0086\u0080\u0004\u001a]\u0010]\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H(0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010(*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001e\u0010V\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030;\u0012\u0004\u0012\u0002H(0\u001bH\u0086\u0088\u0004ø\u0001\u0000\u001a]\u0010^\u001a\u000e\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010(*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001e\u0010V\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030;\u0012\u0004\u0012\u0002H(0\u001bH\u0086\u0088\u0004ø\u0001\u0000\u001aK\u0010_\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020#0\u001bH\u0086\u0088\u0004ø\u0001\u0000\u001aK\u0010a\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020#0\u001bH\u0086\u0088\u0004ø\u0001\u0000\u001av\u0010b\u001a\u0002H)\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0018\b\u0002\u0010)*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\u000b*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010U\u001a\u0002H)2\u001e\u0010`\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030;\u0012\u0004\u0012\u00020#0\u001bH\u0087\u0088\bb\u0002\b9ø\u0001\u0000¢\u0006\u0002\u0010W\u001aW\u0010c\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001e\u0010`\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030;\u0012\u0004\u0012\u00020#0\u001bH\u0086\u0088\u0004ø\u0001\u0000\u001av\u0010d\u001a\u0002H)\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0018\b\u0002\u0010)*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\u000b*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010U\u001a\u0002H)2\u001e\u0010`\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030;\u0012\u0004\u0012\u00020#0\u001bH\u0087\u0088\bb\u0002\b9ø\u0001\u0000¢\u0006\u0002\u0010W\u001aW\u0010e\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001e\u0010`\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030;\u0012\u0004\u0012\u00020#0\u001bH\u0086\u0088\u0004ø\u0001\u0000\u001a8\u0010f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070[H\u0086\u0080\u0004\u001aW\u0010f\u001a\u0002H)\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0018\b\u0002\u0010)*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\u000b*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070[2\u0006\u0010U\u001a\u0002H)H\u0087\u0080\bb\u0002\b9¢\u0006\u0002\u0010g\u001a?\u0010f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u0006H\u0086\u0080\u0004¢\u0006\u0002\u0010\b\u001aY\u0010f\u001a\u0002H)\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0018\b\u0002\u0010)*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\u000b*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u00062\u0006\u0010U\u001a\u0002H)H\u0087\u0080\bb\u0002\b9¢\u0006\u0002\u0010h\u001a8\u0010f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\\H\u0086\u0080\u0004\u001aW\u0010f\u001a\u0002H)\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0018\b\u0002\u0010)*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\u000b*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\\2\u0006\u0010U\u001a\u0002H)H\u0087\u0080\bb\u0002\b9¢\u0006\u0002\u0010i\u001aB\u0010f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\u0080\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u001aB\u0010j\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\u0080\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u001aa\u0010f\u001a\u0002H)\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0018\b\u0002\u0010)*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\u000b*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010U\u001a\u0002H)H\u0087\u0080\bb\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000eb\u0002\b9¢\u0006\u0002\u0010k\u001aH\u0010l\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007H\u0086\u0082\u0004\u001aN\u0010l\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070[H\u0086\u0082\u0004\u001aU\u0010l\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u0006H\u0086\u0082\u0004¢\u0006\u0002\u0010n\u001aN\u0010l\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\\H\u0086\u0082\u0004\u001aJ\u0010l\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0014\u0010o\u001a\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0086\u0082\u0004\u001aB\u0010p\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\u000b2\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007H\u0087\u008a\u0004b\u0002\b\t\u001aH\u0010p\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\u000b2\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070[H\u0087\u008a\u0004b\u0002\b\t\u001aO\u0010p\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\u000b2\u001a\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u0006H\u0087\u008a\u0004b\u0002\b\t¢\u0006\u0002\u0010Z\u001aH\u0010p\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\u000b2\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\\H\u0087\u008a\u0004b\u0002\b\t\u001aB\u0010p\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\u000b2\u0012\u0010o\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\u008a\u0004b\u0002\b\t\u001aO\u0010q\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010/\u001a\u0002H\u0002H\u0087\u0082\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\u0002\u0010r\u001aP\u0010q\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010s\u001a\b\u0012\u0004\u0012\u0002H\u00020[H\u0087\u0082\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u001aW\u0010q\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u000e\u0010s\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0087\u0082\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\u0002\u0010t\u001aP\u0010q\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010s\u001a\b\u0012\u0004\u0012\u0002H\u00020\\H\u0087\u0082\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u001aE\u0010u\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000b2\u0006\u0010/\u001a\u0002H\u0002H\u0087\u008a\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000eb\u0002\b\t¢\u0006\u0002\u0010v\u001aF\u0010u\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000b2\f\u0010s\u001a\b\u0012\u0004\u0012\u0002H\u00020[H\u0087\u008a\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000eb\u0002\b\t\u001aM\u0010u\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000b2\u000e\u0010s\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0087\u008a\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000eb\u0002\b\t¢\u0006\u0002\u0010w\u001aF\u0010u\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000b2\f\u0010s\u001a\b\u0012\u0004\u0012\u0002H\u00020\\H\u0087\u008a\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000eb\u0002\b\t\u001a2\u0010x\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0080\u0080\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006y"}, d2 = {"emptyMap", _UrlKt.FRAGMENT_ENCODE_SET, "K", "V", "mapOf", "pairs", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/Pair;", "([Lkotlin/Pair;)Ljava/util/Map;", "Lni/shikatu/kotlin/internal/InlineOnly;", "mutableMapOf", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.1", "hashMapOf", "Ljava/util/HashMap;", "Lni/shikatu/kotlin/collections/HashMap;", "()Ljava/util/HashMap;", "([Lkotlin/Pair;)Ljava/util/HashMap;", "linkedMapOf", "Ljava/util/LinkedHashMap;", "Lni/shikatu/kotlin/collections/LinkedHashMap;", "()Ljava/util/LinkedHashMap;", "([Lkotlin/Pair;)Ljava/util/LinkedHashMap;", "buildMap", "builderAction", "Lni/shikatu/kotlin/Function1;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/ExtensionFunctionType;", "Lni/shikatu/kotlin/BuilderInference;", "1.6", "capacity", _UrlKt.FRAGMENT_ENCODE_SET, "isNotEmpty", _UrlKt.FRAGMENT_ENCODE_SET, "isNullOrEmpty", "1.3", "orEmpty", "ifEmpty", "R", "M", "defaultValue", "Lni/shikatu/kotlin/Function0;", "(Ljava/util/Map;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "contains", "Lni/shikatu/kotlin/internal/OnlyInputTypes;", "key", "(Ljava/util/Map;Ljava/lang/Object;)Z", "get", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "set", "value", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", "containsKey", "containsValue", "remove", "Lni/shikatu/kotlin/IgnorableReturnValue;", "component1", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "component2", "toPair", "copy", "2.3", "Lni/shikatu/kotlin/ExperimentalStdlibApi;", "mapEntryOf", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map$Entry;", "getOrElse", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrElseIfNull", "2.4", "getOrElseIfMissing", "getValue", "getOrPut", "getOrPutIfNull", "getOrPutIfMissing", "iterator", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "mutableIterator", "Lni/shikatu/kotlin/jvm/JvmName;", "name", "mapValuesTo", "destination", "transform", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "mapKeysTo", "putAll", "(Ljava/util/Map;[Lkotlin/Pair;)V", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/sequences/Sequence;", "mapValues", "mapKeys", "filterKeys", "predicate", "filterValues", "filterTo", "filter", "filterNotTo", "filterNot", "toMap", "(Ljava/lang/Iterable;Ljava/util/Map;)Ljava/util/Map;", "([Lkotlin/Pair;Ljava/util/Map;)Ljava/util/Map;", "(Lkotlin/sequences/Sequence;Ljava/util/Map;)Ljava/util/Map;", "toMutableMap", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "plus", "pair", "(Ljava/util/Map;[Lkotlin/Pair;)Ljava/util/Map;", "map", "plusAssign", "minus", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/Map;", "keys", "(Ljava/util/Map;[Ljava/lang/Object;)Ljava/util/Map;", "minusAssign", "(Ljava/util/Map;Ljava/lang/Object;)V", "(Ljava/util/Map;[Ljava/lang/Object;)V", "optimizeReadOnlyMap", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/collections/MapsKt")
public class MapsKt__MapsKt extends MapsKt__MapsJVMKt {
    public static final <K, V> Map<K, V> emptyMap() {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        Intrinsics.checkNotNull(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    public static final <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        return pairArr.length > 0 ? MapsKt.toMap(pairArr, new LinkedHashMap(MapsKt.mapCapacity(pairArr.length))) : MapsKt.emptyMap();
    }

    private static final <K, V> Map<K, V> mapOf() {
        return MapsKt.emptyMap();
    }

    private static final <K, V> Map<K, V> mutableMapOf() {
        return new LinkedHashMap();
    }

    public static final <K, V> Map<K, V> mutableMapOf(Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        LinkedHashMap $this$mutableMapOf_u24lambda_u240 = new LinkedHashMap(MapsKt.mapCapacity(pairArr.length));
        MapsKt.putAll($this$mutableMapOf_u24lambda_u240, pairArr);
        return $this$mutableMapOf_u24lambda_u240;
    }

    private static final <K, V> HashMap<K, V> hashMapOf() {
        return new HashMap<>();
    }

    public static final <K, V> HashMap<K, V> hashMapOf(Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        HashMap<K, V> map = new HashMap<>(MapsKt.mapCapacity(pairArr.length));
        MapsKt.putAll(map, pairArr);
        return map;
    }

    private static final <K, V> LinkedHashMap<K, V> linkedMapOf() {
        return new LinkedHashMap<>();
    }

    public static final <K, V> LinkedHashMap<K, V> linkedMapOf(Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        return (LinkedHashMap) MapsKt.toMap(pairArr, new LinkedHashMap(MapsKt.mapCapacity(pairArr.length)));
    }

    private static final <K, V> Map<K, V> buildMap(Function1<? super Map<K, V>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        ((Function1) function1).invoke(mapCreateMapBuilder);
        return MapsKt.build(mapCreateMapBuilder);
    }

    private static final <K, V> Map<K, V> buildMap(int capacity, Function1<? super Map<K, V>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        Map mapCreateMapBuilder = MapsKt.createMapBuilder(capacity);
        ((Function1) function1).invoke(mapCreateMapBuilder);
        return MapsKt.build(mapCreateMapBuilder);
    }

    private static final <K, V> boolean isNotEmpty(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return !map.isEmpty();
    }

    private static final <K, V> boolean isNullOrEmpty(Map<? extends K, ? extends V> map) {
        return map == null || map.isEmpty();
    }

    private static final <K, V> Map<K, V> orEmpty(Map<K, ? extends V> map) {
        return map == null ? MapsKt.emptyMap() : map;
    }

    private static final Object ifEmpty(Map $this$ifEmpty, Function0 defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return $this$ifEmpty.isEmpty() ? defaultValue.invoke() : $this$ifEmpty;
    }

    private static final <K, V> boolean contains(Map<? extends K, ? extends V> map, K k) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return map.containsKey(k);
    }

    private static final <K, V> V get(Map<? extends K, ? extends V> map, K k) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return map.get(k);
    }

    private static final <K, V> void set(Map<K, V> map, K k, V v) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        map.put(k, v);
    }

    private static final <K> boolean containsKey(Map<? extends K, ?> map, K k) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return map.containsKey(k);
    }

    private static final <K, V> boolean containsValue(Map<K, ? extends V> map, V v) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return map.containsValue(v);
    }

    @IgnorableReturnValue
    private static final <K, V> V remove(Map<? extends K, V> map, K k) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return (V) TypeIntrinsics.asMutableMap(map).remove(k);
    }

    private static final <K, V> K component1(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "<this>");
        return entry.getKey();
    }

    private static final <K, V> V component2(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "<this>");
        return entry.getValue();
    }

    private static final <K, V> Pair<K, V> toPair(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "<this>");
        return new Pair<>(entry.getKey(), entry.getValue());
    }

    public static final <K, V> Map.Entry<K, V> copy(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "<this>");
        DetachedMapEntry detachedMapEntry = entry instanceof DetachedMapEntry ? (DetachedMapEntry) entry : null;
        return detachedMapEntry != null ? detachedMapEntry : MapsKt.mapEntryOf(entry.getKey(), entry.getValue());
    }

    public static final <K, V> Map.Entry<K, V> mapEntryOf(K k, V v) {
        return new DetachedMapEntry(k, v);
    }

    private static final <K, V> V getOrElse(Map<K, ? extends V> map, K k, Function0<? extends V> function0) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        V v = map.get(k);
        return v == null ? function0.invoke() : v;
    }

    private static final <K, V> V getOrElseIfNull(Map<K, ? extends V> map, K k, Function0<? extends V> function0) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        V v = map.get(k);
        return v == null ? function0.invoke() : v;
    }

    private static final <K, V> V getOrElseIfMissing(Map<K, ? extends V> map, K k, Function0<? extends V> function0) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        V v = map.get(k);
        if (v == null && !map.containsKey(k)) {
            return function0.invoke();
        }
        return v;
    }

    public static final <K, V> V getValue(Map<K, ? extends V> map, K k) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return (V) MapsKt.getOrImplicitDefaultNullable(map, k);
    }

    public static final <K, V> V getOrPut(Map<K, V> map, K k, Function0<? extends V> function0) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        V v = map.get(k);
        if (v == null) {
            V vInvoke = function0.invoke();
            map.put(k, vInvoke);
            return vInvoke;
        }
        return v;
    }

    private static final <K, V> V getOrPutIfNull(Map<K, V> map, K k, Function0<? extends V> function0) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        V v = map.get(k);
        if (v == null) {
            V vInvoke = function0.invoke();
            map.put(k, vInvoke);
            return vInvoke;
        }
        return v;
    }

    private static final <K, V> V getOrPutIfMissing(Map<K, V> map, K k, Function0<? extends V> function0) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        V v = map.get(k);
        if (v == null && !map.containsKey(k)) {
            V vInvoke = function0.invoke();
            map.put(k, vInvoke);
            return vInvoke;
        }
        return v;
    }

    private static final <K, V> Iterator<Map.Entry<K, V>> iterator(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return (Iterator<Entry<K,V>>) ((Iterator<Map.Entry<K, V>>) (map.entrySet().iterator()));
    }

    private static final <K, V> Iterator<Map.Entry<K, V>> mutableIterator(Map<K, V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return map.entrySet().iterator();
    }

    @IgnorableReturnValue
    public static final <K, V, R, M extends Map<? super K, ? super R>> M mapValuesTo(Map<? extends K, ? extends V> map, M m, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterable $this$associateByTo$iv = map.entrySet();
        for (Object element$iv : $this$associateByTo$iv) {
            Map.Entry it = (Map.Entry) element$iv;
            ((Map) m).put(it.getKey(), ((Function1) function1).invoke(element$iv));
        }
        return m;
    }

    @IgnorableReturnValue
    public static final <K, V, R, M extends Map<? super R, ? super V>> M mapKeysTo(Map<? extends K, ? extends V> map, M m, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterable $this$associateByTo$iv = map.entrySet();
        for (Object element$iv : $this$associateByTo$iv) {
            Map.Entry it = (Map.Entry) element$iv;
            ((Map) m).put(((Function1) function1).invoke(element$iv), it.getValue());
        }
        return m;
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairArr) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            Object key = pair.component1();
            Object value = pair.component2();
            ((Map) map).put(key, value);
        }
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "pairs");
        for (Pair<? extends K, ? extends V> pair : iterable) {
            Object key = pair.component1();
            Object value = pair.component2();
            ((Map) map).put(key, value);
        }
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> map, Sequence<? extends Pair<? extends K, ? extends V>> sequence) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "pairs");
        for (Pair<? extends K, ? extends V> pair : sequence) {
            Object key = pair.component1();
            Object value = pair.component2();
            ((Map) map).put(key, value);
        }
    }

    public static final <K, V, R> Map<K, R> mapValues(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Object obj : map.entrySet()) {
            linkedHashMap.put(((Map.Entry) obj).getKey(), ((Function1) function1).invoke(obj));
        }
        return linkedHashMap;
    }

    public static final <K, V, R> Map<R, V> mapKeys(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Object obj : map.entrySet()) {
            linkedHashMap.put(((Function1) function1).invoke(obj), ((Map.Entry) obj).getValue());
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> filterKeys(Map<? extends K, ? extends V> map, Function1<? super K, Boolean> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (function1.invoke(entry.getKey()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> filterValues(Map<? extends K, ? extends V> map, Function1<? super V, Boolean> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (function1.invoke(entry.getValue()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @IgnorableReturnValue
    public static final <K, V, M extends Map<? super K, ? super V>> M filterTo(Map<? extends K, ? extends V> map, M m, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (function1.invoke(entry).booleanValue()) {
                m.put(entry.getKey(), entry.getValue());
            }
        }
        return m;
    }

    public static final <K, V> Map<K, V> filter(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Map destination$iv = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (function1.invoke(entry).booleanValue()) {
                destination$iv.put(entry.getKey(), entry.getValue());
            }
        }
        return destination$iv;
    }

    @IgnorableReturnValue
    public static final <K, V, M extends Map<? super K, ? super V>> M filterNotTo(Map<? extends K, ? extends V> map, M m, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!function1.invoke(entry).booleanValue()) {
                m.put(entry.getKey(), entry.getValue());
            }
        }
        return m;
    }

    public static final <K, V> Map<K, V> filterNot(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Map destination$iv = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!function1.invoke(entry).booleanValue()) {
                destination$iv.put(entry.getKey(), entry.getValue());
            }
        }
        return destination$iv;
    }

    public static final <K, V> Map<K, V> toMap(Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            switch (((Collection) iterable).size()) {
                case 0:
                    return MapsKt.emptyMap();
                case 1:
                    return MapsKt.mapOf((Pair) (iterable instanceof List ? ((List) iterable).get(0) : ((Collection) iterable).iterator().next()));
                default:
                    return MapsKt.toMap(iterable, new LinkedHashMap(MapsKt.mapCapacity(((Collection) iterable).size())));
            }
        }
        return MapsKt.optimizeReadOnlyMap(MapsKt.toMap(iterable, new LinkedHashMap()));
    }

    @IgnorableReturnValue
    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Iterable<? extends Pair<? extends K, ? extends V>> iterable, M m) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(m, "destination");
        MapsKt.putAll(m, iterable);
        return m;
    }

    public static final <K, V> Map<K, V> toMap(Pair<? extends K, ? extends V>[] pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "<this>");
        switch (pairArr.length) {
            case 0:
                return MapsKt.emptyMap();
            case 1:
                return MapsKt.mapOf(pairArr[0]);
            default:
                return MapsKt.toMap(pairArr, new LinkedHashMap(MapsKt.mapCapacity(pairArr.length)));
        }
    }

    @IgnorableReturnValue
    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Pair<? extends K, ? extends V>[] pairArr, M m) {
        Intrinsics.checkNotNullParameter(pairArr, "<this>");
        Intrinsics.checkNotNullParameter(m, "destination");
        MapsKt.putAll(m, pairArr);
        return m;
    }

    public static final <K, V> Map<K, V> toMap(Sequence<? extends Pair<? extends K, ? extends V>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return MapsKt.optimizeReadOnlyMap(MapsKt.toMap(sequence, new LinkedHashMap()));
    }

    @IgnorableReturnValue
    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Sequence<? extends Pair<? extends K, ? extends V>> sequence, M m) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(m, "destination");
        MapsKt.putAll(m, sequence);
        return m;
    }

    public static final <K, V> Map<K, V> toMap(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        switch (map.size()) {
            case 0:
                return MapsKt.emptyMap();
            case 1:
                return MapsKt.toSingletonMap(map);
            default:
                return MapsKt.toMutableMap(map);
        }
    }

    public static final <K, V> Map<K, V> toMutableMap(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return new LinkedHashMap(map);
    }

    @IgnorableReturnValue
    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Map<? extends K, ? extends V> map, M m) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(m, "destination");
        m.putAll(map);
        return m;
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(pair, "pair");
        if (map.isEmpty()) {
            return MapsKt.mapOf(pair);
        }
        LinkedHashMap $this$plus_u24lambda_u240 = new LinkedHashMap(map);
        $this$plus_u24lambda_u240.put(pair.getFirst(), pair.getSecond());
        return $this$plus_u24lambda_u240;
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "pairs");
        if (map.isEmpty()) {
            return MapsKt.toMap(iterable);
        }
        LinkedHashMap $this$plus_u24lambda_u241 = new LinkedHashMap(map);
        MapsKt.putAll($this$plus_u24lambda_u241, iterable);
        return $this$plus_u24lambda_u241;
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Pair<? extends K, ? extends V>[] pairArr) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        if (map.isEmpty()) {
            return MapsKt.toMap(pairArr);
        }
        LinkedHashMap $this$plus_u24lambda_u242 = new LinkedHashMap(map);
        MapsKt.putAll($this$plus_u24lambda_u242, pairArr);
        return $this$plus_u24lambda_u242;
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Sequence<? extends Pair<? extends K, ? extends V>> sequence) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "pairs");
        LinkedHashMap $this$plus_u24lambda_u243 = new LinkedHashMap(map);
        MapsKt.putAll($this$plus_u24lambda_u243, sequence);
        return MapsKt.optimizeReadOnlyMap($this$plus_u24lambda_u243);
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(map2, "map");
        LinkedHashMap $this$plus_u24lambda_u244 = new LinkedHashMap(map);
        $this$plus_u24lambda_u244.putAll(map2);
        return $this$plus_u24lambda_u244;
    }

    private static final <K, V> void plusAssign(Map<? super K, ? super V> map, Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(pair, "pair");
        map.put(pair.getFirst(), pair.getSecond());
    }

    private static final <K, V> void plusAssign(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "pairs");
        MapsKt.putAll(map, iterable);
    }

    private static final <K, V> void plusAssign(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairArr) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        MapsKt.putAll(map, pairArr);
    }

    private static final <K, V> void plusAssign(Map<? super K, ? super V> map, Sequence<? extends Pair<? extends K, ? extends V>> sequence) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "pairs");
        MapsKt.putAll(map, sequence);
    }

    private static final <K, V> void plusAssign(Map<? super K, ? super V> map, Map<K, ? extends V> map2) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(map2, "map");
        map.putAll(map2);
    }

    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> map, K k) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Map $this$minus_u24lambda_u240 = MapsKt.toMutableMap(map);
        $this$minus_u24lambda_u240.remove(k);
        return MapsKt.optimizeReadOnlyMap($this$minus_u24lambda_u240);
    }

    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> map, Iterable<? extends K> iterable) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "keys");
        Map $this$minus_u24lambda_u241 = MapsKt.toMutableMap(map);
        CollectionsKt.removeAll($this$minus_u24lambda_u241.keySet(), iterable);
        return MapsKt.optimizeReadOnlyMap($this$minus_u24lambda_u241);
    }

    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> map, K[] kArr) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(kArr, "keys");
        Map $this$minus_u24lambda_u242 = MapsKt.toMutableMap(map);
        CollectionsKt.removeAll($this$minus_u24lambda_u242.keySet(), kArr);
        return MapsKt.optimizeReadOnlyMap($this$minus_u24lambda_u242);
    }

    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> map, Sequence<? extends K> sequence) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "keys");
        Map $this$minus_u24lambda_u243 = MapsKt.toMutableMap(map);
        CollectionsKt.removeAll($this$minus_u24lambda_u243.keySet(), sequence);
        return MapsKt.optimizeReadOnlyMap($this$minus_u24lambda_u243);
    }

    private static final <K, V> void minusAssign(Map<K, V> map, K k) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        map.remove(k);
    }

    private static final <K, V> void minusAssign(Map<K, V> map, Iterable<? extends K> iterable) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "keys");
        CollectionsKt.removeAll(map.keySet(), iterable);
    }

    private static final <K, V> void minusAssign(Map<K, V> map, K[] kArr) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(kArr, "keys");
        CollectionsKt.removeAll(map.keySet(), kArr);
    }

    private static final <K, V> void minusAssign(Map<K, V> map, Sequence<? extends K> sequence) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "keys");
        CollectionsKt.removeAll(map.keySet(), sequence);
    }

    public static final <K, V> Map<K, V> optimizeReadOnlyMap(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        switch (map.size()) {
            case 0:
                return MapsKt.emptyMap();
            case 1:
                return MapsKt.toSingletonMap(map);
            default:
                return (Map<K,V>) (map);
        }
    }
}
