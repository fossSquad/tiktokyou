package ni.shikatu.kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.sequences.Sequence;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001an\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0001*\u00020\u0004*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052 \u0010\u0006\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0007H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010\t\u001ap\u0010\u000e\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0001*\u00020\u0004*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052 \u0010\u0006\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0007H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010\t\u001a:\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00110\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u0086\u0080\u0004\u001a]\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052$\u0010\u0006\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00130\u0007H\u0086\u0088\u0004ø\u0001\u0000\u001a\u0082\u0001\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052$\u0010\u0006\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00140\u0007H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016b\u0002\b\u0017b\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0015ø\u0001\u0000¢\u0006\u0002\b\u0015\u001az\u0010\u001a\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0001\"\u0010\b\u0003\u0010\u001b*\n\u0012\u0006\b\u0000\u0012\u0002H\u00010\u001c*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u001d\u001a\u0002H\u001b2$\u0010\u0006\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00130\u0007H\u0087\u0088\bb\u0002\b\u001fø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a\u009c\u0001\u0010\u001a\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0001\"\u0010\b\u0003\u0010\u001b*\n\u0012\u0006\b\u0000\u0012\u0002H\u00010\u001c*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u001d\u001a\u0002H\u001b2$\u0010\u0006\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00140\u0007H\u0087\u0088\bb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016b\u0002\b\u0017b\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b( b\u0002\b\u001fø\u0001\u0000¢\u0006\u0004\b \u0010\u001e\u001aW\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001e\u0010\u0006\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0086\u0088\u0004ø\u0001\u0000\u001a]\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0001*\u00020\u0004*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052 \u0010\u0006\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0007H\u0086\u0088\u0004ø\u0001\u0000\u001az\u0010#\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0001*\u00020\u0004\"\u0010\b\u0003\u0010\u001b*\n\u0012\u0006\b\u0000\u0012\u0002H\u00010\u001c*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u001d\u001a\u0002H\u001b2 \u0010\u0006\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0007H\u0087\u0088\bb\u0002\b\u001fø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001at\u0010$\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0001\"\u0010\b\u0003\u0010\u001b*\n\u0012\u0006\b\u0000\u0012\u0002H\u00010\u001c*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u001d\u001a\u0002H\u001b2\u001e\u0010\u0006\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\bb\u0002\b\u001fø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001aK\u0010%\u001a\u00020&\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u00020&0\u0007H\u0086\u0088\u0004ø\u0001\u0000\u001a(\u0010(\u001a\u00020&\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u0086\u0080\u0004\u001aK\u0010(\u001a\u00020&\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u00020&0\u0007H\u0086\u0088\u0004ø\u0001\u0000\u001a,\u0010)\u001a\u00020*\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u0087\u0088\u0004b\u0002\b\r\u001aK\u0010)\u001a\u00020*\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u00020&0\u0007H\u0086\u0088\u0004ø\u0001\u0000\u001aO\u0010+\u001a\u00020,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001e\u0010-\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u00020,0\u0007H\u0087\u0088\u0004b\u0002\b.ø\u0001\u0000\u001a\u008c\u0001\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u000100*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001e\u00101\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(3b\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(2b\u0002\b\rø\u0001\u0000¢\u0006\u0002\b2\u001a{\u00104\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u000100*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001e\u00101\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016b\u0002\b\rø\u0001\u0000\u001aa\u00105\u001a\u000206\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001e\u00101\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002060\u0007H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016b\u0002\b\u0017b\u0002\b\rø\u0001\u0000\u001aa\u00105\u001a\u000207\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001e\u00101\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002070\u0007H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016b\u0002\b\u0017b\u0002\b\rø\u0001\u0000\u001av\u00105\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u000100*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001e\u00101\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016b\u0002\b\u0017b\u0002\b\rø\u0001\u0000¢\u0006\u0002\u00108\u001ah\u00109\u001a\u0004\u0018\u000106\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001e\u00101\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002060\u0007H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016b\u0002\b\u0017b\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010:\u001ah\u00109\u001a\u0004\u0018\u000107\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001e\u00101\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002070\u0007H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016b\u0002\b\u0017b\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010;\u001ax\u00109\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u000100*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001e\u00101\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016b\u0002\b\u0017b\u0002\b\rø\u0001\u0000¢\u0006\u0002\u00108\u001a\u0088\u0001\u0010<\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001a\u0010=\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010>j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`?2\u001e\u00101\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016b\u0002\b\u0017b\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010@\u001a\u008a\u0001\u0010A\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001a\u0010=\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010>j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`?2\u001e\u00101\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016b\u0002\b\u0017b\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010@\u001a\u008f\u0001\u0010B\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000522\u0010=\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b0>j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b`?H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(3b\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(Cb\u0002\b\r¢\u0006\u0004\bC\u0010D\u001a\u0081\u0001\u0010E\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000522\u0010=\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b0>j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b`?H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016b\u0002\b\r¢\u0006\u0002\u0010D\u001a\u008c\u0001\u0010F\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u000100*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001e\u00101\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(3b\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(Gb\u0002\b\rø\u0001\u0000¢\u0006\u0002\bG\u001a{\u0010H\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u000100*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001e\u00101\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016b\u0002\b\rø\u0001\u0000\u001aa\u0010I\u001a\u000206\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001e\u00101\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002060\u0007H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016b\u0002\b\u0017b\u0002\b\rø\u0001\u0000\u001aa\u0010I\u001a\u000207\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001e\u00101\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002070\u0007H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016b\u0002\b\u0017b\u0002\b\rø\u0001\u0000\u001av\u0010I\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u000100*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001e\u00101\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016b\u0002\b\u0017b\u0002\b\rø\u0001\u0000¢\u0006\u0002\u00108\u001ah\u0010J\u001a\u0004\u0018\u000106\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001e\u00101\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002060\u0007H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016b\u0002\b\u0017b\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010:\u001ah\u0010J\u001a\u0004\u0018\u000107\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001e\u00101\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002070\u0007H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016b\u0002\b\u0017b\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010;\u001ax\u0010J\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u000100*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001e\u00101\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016b\u0002\b\u0017b\u0002\b\rø\u0001\u0000¢\u0006\u0002\u00108\u001a\u0088\u0001\u0010K\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001a\u0010=\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010>j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`?2\u001e\u00101\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016b\u0002\b\u0017b\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010@\u001a\u008a\u0001\u0010L\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001a\u0010=\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010>j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`?2\u001e\u00101\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016b\u0002\b\u0017b\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010@\u001a\u008f\u0001\u0010M\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000522\u0010=\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b0>j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b`?H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(3b\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(Nb\u0002\b\r¢\u0006\u0004\bN\u0010D\u001a\u0081\u0001\u0010O\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000522\u0010=\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b0>j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b`?H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016b\u0002\b\r¢\u0006\u0002\u0010D\u001a(\u0010P\u001a\u00020&\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u0086\u0080\u0004\u001aK\u0010P\u001a\u00020&\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u00020&0\u0007H\u0086\u0088\u0004ø\u0001\u0000\u001ah\u0010Q\u001a\u0002HR\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0016\b\u0002\u0010R*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005*\u0002HR2\u001e\u0010-\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u00020,0\u0007H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(Tø\u0001\u0000¢\u0006\u0002\u0010S\u001a}\u0010U\u001a\u0002HR\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0016\b\u0002\u0010R*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005*\u0002HR23\u0010-\u001a/\u0012\u0013\u0012\u00110*¢\u0006\f\bW\u0012\b\b\u0019\u0012\u0004\b\b(X\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u00020,0VH\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016ø\u0001\u0000¢\u0006\u0002\u0010Y\u001a>\u0010Z\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b0\u0013\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u0087\u0088\u0004b\u0002\b\r\u001a:\u0010[\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b0\u0014\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u0086\u0080\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\\"}, d2 = {"firstNotNullOf", "R", "K", "V", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "transform", "Lni/shikatu/kotlin/Function1;", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.5", "Lni/shikatu/kotlin/internal/InlineOnly;", "firstNotNullOfOrNull", "toList", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/Pair;", "flatMap", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/sequences/Sequence;", "flatMapSequence", "1.4", "Lni/shikatu/kotlin/OverloadResolutionByLambdaReturnType;", "Lni/shikatu/kotlin/jvm/JvmName;", "name", "flatMapTo", "C", _UrlKt.FRAGMENT_ENCODE_SET, "destination", "(Ljava/util/Map;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "Lni/shikatu/kotlin/IgnorableReturnValue;", "flatMapSequenceTo", "map", "mapNotNull", "mapNotNullTo", "mapTo", "all", _UrlKt.FRAGMENT_ENCODE_SET, "predicate", "any", "count", _UrlKt.FRAGMENT_ENCODE_SET, "forEach", _UrlKt.FRAGMENT_ENCODE_SET, "action", "Lni/shikatu/kotlin/internal/HidesMembers;", "maxBy", _UrlKt.FRAGMENT_ENCODE_SET, "selector", "maxByOrThrow", "1.7", "maxByOrNull", "maxOf", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "maxOfOrNull", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "maxOfWith", "comparator", "Ljava/util/Comparator;", "Lni/shikatu/kotlin/Comparator;", "(Ljava/util/Map;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "maxOfWithOrNull", "maxWith", "maxWithOrThrow", "(Ljava/util/Map;Ljava/util/Comparator;)Ljava/util/Map$Entry;", "maxWithOrNull", "minBy", "minByOrThrow", "minByOrNull", "minOf", "minOfOrNull", "minOfWith", "minOfWithOrNull", "minWith", "minWithOrThrow", "minWithOrNull", "none", "onEach", "M", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "1.1", "onEachIndexed", "Lni/shikatu/kotlin/Function2;", "Lni/shikatu/kotlin/ParameterName;", "index", "(Ljava/util/Map;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "asIterable", "asSequence", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/collections/MapsKt")
public class MapsKt___MapsKt extends MapsKt___MapsJvmKt {

    private static final <K, V, R> R firstNotNullOf(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        R rInvoke;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            rInvoke = function1.invoke(it.next());
            if (rInvoke != null) {
                if (rInvoke != null) {
                    return rInvoke;
                }
                throw new NoSuchElementException("No element of the map was transformed to a non-null value.");
            }
        }
        rInvoke = null;
        if (rInvoke != null) {
            return rInvoke;
        }
        throw new NoSuchElementException("No element of the map was transformed to a non-null value.");
    }

    private static final <K, V, R> R firstNotNullOfOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R rInvoke = function1.invoke(it.next());
            if (rInvoke != null) {
                return rInvoke;
            }
        }
        return null;
    }

    public static final <K, V> List<Pair<K, V>> toList(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (map.size() == 0) {
            return CollectionsKt.emptyList();
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return CollectionsKt.emptyList();
        }
        Map.Entry<? extends K, ? extends V> next = it.next();
        if (!it.hasNext()) {
            return CollectionsKt.listOf(new Pair(next.getKey(), next.getValue()));
        }
        ArrayList result = new ArrayList(map.size());
        result.add(new Pair(next.getKey(), next.getValue()));
        do {
            Map.Entry<? extends K, ? extends V> next2 = it.next();
            result.add(new Pair(next2.getKey(), next2.getValue()));
        } while (it.hasNext());
        return result;
    }

    public static final <K, V, R> List<R> flatMap(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Collection destination$iv = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(destination$iv, function1.invoke(it.next()));
        }
        return (List) destination$iv;
    }

    public static final <K, V, R> List<R> flatMapSequence(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Collection destination$iv = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(destination$iv, function1.invoke(it.next()));
        }
        return (List) destination$iv;
    }

    @IgnorableReturnValue
    public static final <K, V, R, C extends Collection<? super R>> C flatMapTo(Map<? extends K, ? extends V> map, C c, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(c, function1.invoke(it.next()));
        }
        return c;
    }

    @IgnorableReturnValue
    public static final <K, V, R, C extends Collection<? super R>> C flatMapSequenceTo(Map<? extends K, ? extends V> map, C c, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(c, function1.invoke(it.next()));
        }
        return c;
    }

    public static final <K, V, R> List<R> map(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Collection destination$iv = new ArrayList(map.size());
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            destination$iv.add(function1.invoke(it.next()));
        }
        return (List) destination$iv;
    }

    public static final <K, V, R> List<R> mapNotNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Collection destination$iv = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R rInvoke = function1.invoke(it.next());
            if (rInvoke != null) {
                destination$iv.add(rInvoke);
            }
        }
        return (List) destination$iv;
    }

    @IgnorableReturnValue
    public static final <K, V, R, C extends Collection<? super R>> C mapNotNullTo(Map<? extends K, ? extends V> map, C c, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R rInvoke = function1.invoke(it.next());
            if (rInvoke != null) {
                c.add(rInvoke);
            }
        }
        return c;
    }

    @IgnorableReturnValue
    public static final <K, V, R, C extends Collection<? super R>> C mapTo(Map<? extends K, ? extends V> map, C c, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            c.add(function1.invoke(it.next()));
        }
        return c;
    }

    public static final <K, V> boolean all(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (!function1.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <K, V> boolean any(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return !map.isEmpty();
    }

    public static final <K, V> boolean any(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (map.isEmpty()) {
            return false;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (function1.invoke(it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    private static final <K, V> int count(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return map.size();
    }

    public static final <K, V> int count(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (map.isEmpty()) {
            return 0;
        }
        int count = 0;
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (function1.invoke(it.next()).booleanValue()) {
                count++;
            }
        }
        return count;
    }

    public static final <K, V> void forEach(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Unit> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            function1.invoke(it.next());
        }
    }

    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> maxByOrThrow(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterable $this$maxBy$iv = map.entrySet();
        Iterator iterator$iv = $this$maxBy$iv.iterator();
        if (!iterator$iv.hasNext()) {
            throw new NoSuchElementException();
        }
        Object maxElem$iv = iterator$iv.next();
        if (iterator$iv.hasNext()) {
            Comparable maxValue$iv = function1.invoke(maxElem$iv);
            do {
                Object e$iv = iterator$iv.next();
                R rInvoke = function1.invoke(e$iv);
                if (maxValue$iv.compareTo(rInvoke) < 0) {
                    maxElem$iv = e$iv;
                    maxValue$iv = rInvoke;
                }
            } while (iterator$iv.hasNext());
        }
        return (Map.Entry) maxElem$iv;
    }

    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> maxByOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Object maxElem$iv;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterable $this$maxByOrNull$iv = map.entrySet();
        Iterator iterator$iv = $this$maxByOrNull$iv.iterator();
        if (iterator$iv.hasNext()) {
            maxElem$iv = iterator$iv.next();
            if (iterator$iv.hasNext()) {
                Comparable maxValue$iv = function1.invoke(maxElem$iv);
                do {
                    Object e$iv = iterator$iv.next();
                    R rInvoke = function1.invoke(e$iv);
                    if (maxValue$iv.compareTo(rInvoke) < 0) {
                        maxElem$iv = e$iv;
                        maxValue$iv = rInvoke;
                    }
                } while (iterator$iv.hasNext());
            }
        } else {
            maxElem$iv = null;
        }
        return (Map.Entry) maxElem$iv;
    }

    private static final <K, V> double maxOf(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Double> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = function1.invoke((Object) it.next()).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, function1.invoke((Object) it.next()).doubleValue());
        }
        return dDoubleValue;
    }

    private static final <K, V> float m455maxOf(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Float> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = function1.invoke((Object) it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, function1.invoke((Object) it.next()).floatValue());
        }
        return fFloatValue;
    }

    private static final <K, V, R extends Comparable<? super R>> R m456maxOf(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R rInvoke = function1.invoke((Object) it.next());
        while (it.hasNext()) {
            R rInvoke2 = function1.invoke((Object) it.next());
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    private static final <K, V> Double m457maxOfOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Double> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = function1.invoke((Object) it.next()).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, function1.invoke((Object) it.next()).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <K, V> Float m458maxOfOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Float> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = function1.invoke((Object) it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, function1.invoke((Object) it.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    private static final <K, V, R extends Comparable<? super R>> R maxOfOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        R rInvoke = function1.invoke((Object) it.next());
        while (it.hasNext()) {
            R rInvoke2 = function1.invoke((Object) it.next());
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    private static final <K, V, R> R maxOfWith(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R rInvoke = function1.invoke((Object) it.next());
        while (it.hasNext()) {
            R rInvoke2 = function1.invoke((Object) it.next());
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    private static final <K, V, R> R maxOfWithOrNull(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        R rInvoke = function1.invoke((Object) it.next());
        while (it.hasNext()) {
            R rInvoke2 = function1.invoke((Object) it.next());
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = (Object) rInvoke2;
            }
        }
        return rInvoke;
    }

    private static final <K, V> Map.Entry<K, V> maxWithOrThrow(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (Map.Entry) CollectionsKt.maxWithOrThrow(map.entrySet(), comparator);
    }

    private static final <K, V> Map.Entry<K, V> maxWithOrNull(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (Map.Entry) CollectionsKt.maxWithOrNull(map.entrySet(), comparator);
    }

    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> minByOrThrow(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterable $this$minBy$iv = map.entrySet();
        Iterator iterator$iv = $this$minBy$iv.iterator();
        if (!iterator$iv.hasNext()) {
            throw new NoSuchElementException();
        }
        Object minElem$iv = iterator$iv.next();
        if (iterator$iv.hasNext()) {
            Comparable minValue$iv = function1.invoke(minElem$iv);
            do {
                Object e$iv = iterator$iv.next();
                R rInvoke = function1.invoke(e$iv);
                if (minValue$iv.compareTo(rInvoke) > 0) {
                    minElem$iv = e$iv;
                    minValue$iv = rInvoke;
                }
            } while (iterator$iv.hasNext());
        }
        return (Map.Entry) minElem$iv;
    }

    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> minByOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Object minElem$iv;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterable $this$minByOrNull$iv = map.entrySet();
        Iterator iterator$iv = $this$minByOrNull$iv.iterator();
        if (iterator$iv.hasNext()) {
            minElem$iv = iterator$iv.next();
            if (iterator$iv.hasNext()) {
                Comparable minValue$iv = function1.invoke(minElem$iv);
                do {
                    Object e$iv = iterator$iv.next();
                    R rInvoke = function1.invoke(e$iv);
                    if (minValue$iv.compareTo(rInvoke) > 0) {
                        minElem$iv = e$iv;
                        minValue$iv = rInvoke;
                    }
                } while (iterator$iv.hasNext());
            }
        } else {
            minElem$iv = null;
        }
        return (Map.Entry) minElem$iv;
    }

    private static final <K, V> double minOf(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Double> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = function1.invoke((Object) it.next()).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, function1.invoke((Object) it.next()).doubleValue());
        }
        return dDoubleValue;
    }

    private static final <K, V> float m459minOf(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Float> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = function1.invoke((Object) it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, function1.invoke((Object) it.next()).floatValue());
        }
        return fFloatValue;
    }

    private static final <K, V, R extends Comparable<? super R>> R m460minOf(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R rInvoke = function1.invoke((Object) it.next());
        while (it.hasNext()) {
            R rInvoke2 = function1.invoke((Object) it.next());
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    private static final <K, V> Double m461minOfOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Double> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = function1.invoke((Object) it.next()).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, function1.invoke((Object) it.next()).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <K, V> Float m462minOfOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Float> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = function1.invoke((Object) it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, function1.invoke((Object) it.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    private static final <K, V, R extends Comparable<? super R>> R minOfOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        R rInvoke = function1.invoke((Object) it.next());
        while (it.hasNext()) {
            R rInvoke2 = function1.invoke((Object) it.next());
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    private static final <K, V, R> R minOfWith(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R rInvoke = function1.invoke((Object) it.next());
        while (it.hasNext()) {
            R rInvoke2 = function1.invoke((Object) it.next());
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    private static final <K, V, R> R minOfWithOrNull(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        R rInvoke = function1.invoke((Object) it.next());
        while (it.hasNext()) {
            R rInvoke2 = function1.invoke((Object) it.next());
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = (Object) rInvoke2;
            }
        }
        return rInvoke;
    }

    private static final <K, V> Map.Entry<K, V> minWithOrThrow(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (Map.Entry) CollectionsKt.minWithOrThrow(map.entrySet(), comparator);
    }

    private static final <K, V> Map.Entry<K, V> minWithOrNull(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (Map.Entry) CollectionsKt.minWithOrNull(map.entrySet(), comparator);
    }

    public static final <K, V> boolean none(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return map.isEmpty();
    }

    public static final <K, V> boolean none(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (function1.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <K, V, M extends Map<? extends K, ? extends V>> M onEach(M m, Function1<? super Map.Entry<? extends K, ? extends V>, Unit> function1) {
        Intrinsics.checkNotNullParameter(m, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        Iterator<Map.Entry<K, V>> it = m.entrySet().iterator();
        while (it.hasNext()) {
            function1.invoke(it.next());
        }
        return m;
    }

    public static final <K, V, M extends Map<? extends K, ? extends V>> M onEachIndexed(M m, Function2<? super Integer, ? super Map.Entry<? extends K, ? extends V>, Unit> function2) {
        Intrinsics.checkNotNullParameter(m, "<this>");
        Intrinsics.checkNotNullParameter(function2, "action");
        Iterable $this$forEachIndexed$iv = m.entrySet();
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv2 = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            function2.invoke(Integer.valueOf(index$iv), item$iv);
            index$iv = index$iv2;
        }
        return m;
    }

    private static final <K, V> Iterable<Map.Entry<K, V>> asIterable(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return map.entrySet();
    }

    public static final <K, V> Sequence<Map.Entry<K, V>> asSequence(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return CollectionsKt.asSequence(map.entrySet());
    }
}
