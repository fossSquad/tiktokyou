package ni.shikatu.kotlin.io.path;

import java.io.IOException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.SetsKt;
import ni.shikatu.kotlin.io.CloseableKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.InlineMarker;
import ni.shikatu.kotlin.jvm.internal.IntCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.sequences.Sequence;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0086\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010&\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a \u0010'\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a$\u0010(\u001a\u00020\u0002*\u00020\u00022\u0006\u0010)\u001a\u00020\u0002H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u001a$\u0010*\u001a\u00020\u0002*\u00020\u00022\u0006\u0010)\u001a\u00020\u0002H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u001a&\u0010+\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010)\u001a\u00020\u0002H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u001a6\u0010,\u001a\u00020\u0002*\u00020\u00022\u0006\u0010-\u001a\u00020\u00022\b\b\u0002\u0010.\u001a\u00020/H\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0\u001aE\u0010,\u001a\u00020\u0002*\u00020\u00022\u0006\u0010-\u001a\u00020\u00022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020302\"\u000203H\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0¢\u0006\u0002\u00104\u001a9\u00105\u001a\u00020/*\u00020\u00022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0002\u00107\u001a9\u00108\u001a\u00020/*\u00020\u00022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0002\u00107\u001a9\u00109\u001a\u00020/*\u00020\u00022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0002\u00107\u001a9\u0010:\u001a\u00020/*\u00020\u00022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0002\u00107\u001a \u0010;\u001a\u00020/*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a \u0010<\u001a\u00020/*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a \u0010=\u001a\u00020/*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a \u0010>\u001a\u00020/*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a \u0010?\u001a\u00020/*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a(\u0010@\u001a\u00020/*\u00020\u00022\u0006\u0010A\u001a\u00020\u0002H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a,\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00020C*\u00020\u00022\b\b\u0002\u0010D\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u001aV\u0010E\u001a\u0002HF\"\u0004\b\u0000\u0010F*\u00020\u00022\b\b\u0002\u0010D\u001a\u00020\u00012\u0018\u0010G\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020I\u0012\u0004\u0012\u0002HF0HH\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0ø\u0001\u0000¢\u0006\u0002\u0010J\u001aA\u0010K\u001a\u00020L*\u00020\u00022\b\b\u0002\u0010D\u001a\u00020\u00012\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020L0HH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013ø\u0001\u0000\u001a \u0010N\u001a\u00020O*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a \u0010P\u001a\u00020L*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a$\u0010Q\u001a\u00020/*\u00020\u0002H\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0\u001aE\u0010R\u001a\u00020\u0002*\u00020\u00022\u001a\u0010S\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030T02\"\u0006\u0012\u0002\b\u00030TH\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0¢\u0006\u0002\u0010U\u001aE\u0010V\u001a\u00020\u0002*\u00020\u00022\u001a\u0010S\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030T02\"\u0006\u0012\u0002\b\u00030TH\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0¢\u0006\u0002\u0010U\u001aA\u0010W\u001a\u00020\u0002*\u00020\u00022\u001a\u0010S\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030T02\"\u0006\u0012\u0002\b\u00030TH\u0087\u0080\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(Xb\u0002\b0¢\u0006\u0002\u0010U\u001aE\u0010Y\u001a\u00020\u0002*\u00020\u00022\u0006\u0010-\u001a\u00020\u00022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020302\"\u000203H\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0¢\u0006\u0002\u00104\u001a6\u0010Y\u001a\u00020\u0002*\u00020\u00022\u0006\u0010-\u001a\u00020\u00022\b\b\u0002\u0010.\u001a\u00020/H\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0\u001a \u0010Z\u001a\u00020[*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001aC\u0010\\\u001a\u0004\u0018\u00010]*\u00020\u00022\u0006\u0010^\u001a\u00020\u00012\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0002\u0010_\u001aO\u0010`\u001a\u00020\u0002*\u00020\u00022\u0006\u0010^\u001a\u00020\u00012\b\u0010a\u001a\u0004\u0018\u00010]2\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0¢\u0006\u0002\u0010b\u001aG\u0010c\u001a\u0004\u0018\u0001Hd\"\n\b\u0000\u0010d\u0018\u0001*\u00020e*\u00020\u00022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0002\u0010f\u001aE\u0010g\u001a\u0002Hd\"\n\b\u0000\u0010d\u0018\u0001*\u00020e*\u00020\u00022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0002\u0010f\u001a\"\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020\u00022\n\u0010k\u001a\u0006\u0012\u0002\b\u00030lH\u0081\u0080\u0004b\u0002\bm\u001aE\u0010n\u001a\u0002Ho\"\n\b\u0000\u0010o\u0018\u0001*\u00020p*\u00020\u00022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0002\u0010q\u001aO\u0010n\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010]0r*\u00020\u00022\u0006\u0010S\u001a\u00020\u00012\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0002\u0010s\u001a9\u0010t\u001a\u00020u*\u00020\u00022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0002\u0010v\u001a(\u0010w\u001a\u00020\u0002*\u00020\u00022\u0006\u0010a\u001a\u00020uH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a;\u0010x\u001a\u0004\u0018\u00010y*\u00020\u00022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0002\u0010z\u001a,\u0010{\u001a\u00020\u0002*\u00020\u00022\u0006\u0010a\u001a\u00020yH\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0\u001a?\u0010|\u001a\b\u0012\u0004\u0012\u00020~0}*\u00020\u00022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0002\u0010\u007f\u001a/\u0010\u0080\u0001\u001a\u00020\u0002*\u00020\u00022\f\u0010a\u001a\b\u0012\u0004\u0012\u00020~0}H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a-\u0010\u0081\u0001\u001a\u00020\u0002*\u00020\u00022\u0006\u0010-\u001a\u00020\u0002H\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0\u001aO\u0010\u0082\u0001\u001a\u00020\u0002*\u00020\u00022\u0006\u0010-\u001a\u00020\u00022\u001a\u0010S\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030T02\"\u0006\u0012\u0002\b\u00030TH\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0¢\u0006\u0003\u0010\u0083\u0001\u001a!\u0010\u0084\u0001\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001aF\u0010\u0085\u0001\u001a\u00020\u0002*\u00020\u00022\u001a\u0010S\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030T02\"\u0006\u0012\u0002\b\u00030TH\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0¢\u0006\u0002\u0010U\u001aY\u0010\u0086\u0001\u001a\u00020\u00022\u000b\b\u0002\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00012\u000b\b\u0002\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00012\u001a\u0010S\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030T02\"\u0006\u0012\u0002\b\u00030TH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0003\u0010\u0089\u0001\u001a`\u0010\u0086\u0001\u001a\u00020\u00022\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0002\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00012\u000b\b\u0002\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00012\u001a\u0010S\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030T02\"\u0006\u0012\u0002\b\u00030TH\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0003\u0010\u008b\u0001\u001aL\u0010\u008c\u0001\u001a\u00020\u00022\u000b\b\u0002\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00012\u001a\u0010S\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030T02\"\u0006\u0012\u0002\b\u00030TH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0003\u0010\u008d\u0001\u001aS\u0010\u008c\u0001\u001a\u00020\u00022\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0002\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00012\u001a\u0010S\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030T02\"\u0006\u0012\u0002\b\u00030TH\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0003\u0010\u008e\u0001\u001a)\u0010\u008f\u0001\u001a\u00020\u0002*\u00020\u00022\u0006\u0010A\u001a\u00020\u0002H\u0087\u008a\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a)\u0010\u008f\u0001\u001a\u00020\u0002*\u00020\u00022\u0006\u0010A\u001a\u00020\u0001H\u0087\u008a\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a%\u0010\u0090\u0001\u001a\u00020\u00022\u0006\u0010j\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a@\u0010\u0090\u0001\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00012\u0013\u0010\u0091\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000102\"\u00020\u0001H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0003\u0010\u0092\u0001\u001a\"\u0010\u0093\u0001\u001a\u00020\u0002*\u00030\u0094\u0001H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001aT\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020I*\u00020\u00022\u0014\u00101\u001a\u000b\u0012\u0007\b\u0001\u0012\u00030\u0096\u000102\"\u00030\u0096\u0001H\u0087\u0080\u0004b\u0012\b\u0098\u0001\u0012\r\b\u0099\u0001\u0012\b\b\fJ\u0004\b\t0\u001bb\r\b\u0007\u0012\t\b\b\u0012\u0005\b\b(\u009a\u0001¢\u0006\u0003\u0010\u0097\u0001\u001aY\u0010\u009b\u0001\u001a\u00020L*\u00020\u00022\u000e\u0010\u009c\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u009d\u00012\n\b\u0002\u0010\u009e\u0001\u001a\u00030\u009f\u00012\t\b\u0002\u0010 \u0001\u001a\u00020/H\u0087\u0080\u0004b\u0012\b\u0098\u0001\u0012\r\b\u0099\u0001\u0012\b\b\fJ\u0004\b\t0\u001bb\r\b\u0007\u0012\t\b\b\u0012\u0005\b\b(\u009a\u0001\u001ar\u0010\u009b\u0001\u001a\u00020L*\u00020\u00022\n\b\u0002\u0010\u009e\u0001\u001a\u00030\u009f\u00012\t\b\u0002\u0010 \u0001\u001a\u00020/2\u001a\u0010¡\u0001\u001a\u0015\u0012\u0005\u0012\u00030¢\u0001\u0012\u0004\u0012\u00020L0H¢\u0006\u0003\b£\u0001H\u0087\u0080\u0004b\u0012\b\u0098\u0001\u0012\r\b\u0099\u0001\u0012\b\b\fJ\u0004\b\t0\u001bb\r\b\u0007\u0012\t\b\b\u0012\u0005\b\b(\u009a\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001\u001a^\u0010¤\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u009d\u00012\u001a\u0010¡\u0001\u001a\u0015\u0012\u0005\u0012\u00030¢\u0001\u0012\u0004\u0012\u00020L0H¢\u0006\u0003\b£\u0001H\u0087\u0080\u0004b\u0012\b\u0098\u0001\u0012\r\b\u0099\u0001\u0012\b\b\fJ\u0004\b\t0\u001bb\r\b\u0007\u0012\t\b\b\u0012\u0005\b\b(\u009a\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\"-\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0084\br\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"-\u0010\n\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0084\br\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\f\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"-\u0010\r\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0084\br\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\f\u0012\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"2\u0010\u0010\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0084\br\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tr\u0002\b\u0013¢\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"-\u0010\u0014\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0084\br\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\f\u0012\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"n\u0010\u0017\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0084\br\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001ar\u0002\b\u001br6\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u001c\b\u001f\u0012\u0018\b\u000bB\u0014\b \u0012\b\b!\u0012\u0004\b\b(\u0014\u0012\u0006\b\"\u0012\u0002\b\f\u0012\n\b#\u0012\u0006\b\n0$8%r\u0002\b\u0013¢\u0006\f\u0012\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006¥\u0001"}, d2 = {"name", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/nio/file/Path;", "getName$annotations", "(Ljava/nio/file/Path;)V", "getName", "(Ljava/nio/file/Path;)Ljava/lang/String;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.5", "nameWithoutExtension", "getNameWithoutExtension$annotations", "getNameWithoutExtension", "extension", "getExtension$annotations", "getExtension", "pathString", "getPathString$annotations", "getPathString", "Lni/shikatu/kotlin/internal/InlineOnly;", "invariantSeparatorsPathString", "getInvariantSeparatorsPathString$annotations", "getInvariantSeparatorsPathString", "invariantSeparatorsPath", "getInvariantSeparatorsPath$annotations", "getInvariantSeparatorsPath", "1.4", "Lni/shikatu/kotlin/io/path/ExperimentalPathApi;", "Lni/shikatu/kotlin/Deprecated;", "message", "Use invariantSeparatorsPathString property instead.", "replaceWith", "Lni/shikatu/kotlin/ReplaceWith;", "expression", "imports", "level", "Lni/shikatu/kotlin/DeprecationLevel;", "ERROR", "absolute", "absolutePathString", "relativeTo", "base", "relativeToOrSelf", "relativeToOrNull", "copyTo", "target", "overwrite", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/IgnorableReturnValue;", "options", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/nio/file/CopyOption;", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;", "exists", "Ljava/nio/file/LinkOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "notExists", "isRegularFile", "isDirectory", "isSymbolicLink", "isExecutable", "isHidden", "isReadable", "isWritable", "isSameFileAs", "other", "listDirectoryEntries", _UrlKt.FRAGMENT_ENCODE_SET, "glob", "useDirectoryEntries", "T", "block", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/sequences/Sequence;", "(Ljava/nio/file/Path;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "forEachDirectoryEntry", _UrlKt.FRAGMENT_ENCODE_SET, "action", "fileSize", _UrlKt.FRAGMENT_ENCODE_SET, "deleteExisting", "deleteIfExists", "createDirectory", "attributes", "Ljava/nio/file/attribute/FileAttribute;", "(Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createDirectories", "createParentDirectories", "1.9", "moveTo", "fileStore", "Ljava/nio/file/FileStore;", "getAttribute", _UrlKt.FRAGMENT_ENCODE_SET, "attribute", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "setAttribute", "value", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/Object;[Ljava/nio/file/LinkOption;)Ljava/nio/file/Path;", "fileAttributesViewOrNull", "V", "Ljava/nio/file/attribute/FileAttributeView;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileAttributeView;", "fileAttributesView", "fileAttributeViewNotAvailable", _UrlKt.FRAGMENT_ENCODE_SET, "path", "attributeViewClass", "Ljava/lang/Class;", "Lni/shikatu/kotlin/PublishedApi;", "readAttributes", "A", "Ljava/nio/file/attribute/BasicFileAttributes;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/BasicFileAttributes;", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/util/Map;", "getLastModifiedTime", "Ljava/nio/file/attribute/FileTime;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileTime;", "setLastModifiedTime", "getOwner", "Ljava/nio/file/attribute/UserPrincipal;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/UserPrincipal;", "setOwner", "getPosixFilePermissions", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/nio/file/attribute/PosixFilePermission;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/util/Set;", "setPosixFilePermissions", "createLinkPointingTo", "createSymbolicLinkPointingTo", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "readSymbolicLink", "createFile", "createTempFile", "prefix", "suffix", "(Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "directory", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createTempDirectory", "(Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "div", "Path", "subpaths", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;", "toPath", "Ljava/net/URI;", "walk", "Lni/shikatu/kotlin/io/path/PathWalkOption;", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)Lkotlin/sequences/Sequence;", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "2.1", "visitFileTree", "visitor", "Ljava/nio/file/FileVisitor;", "maxDepth", _UrlKt.FRAGMENT_ENCODE_SET, "followLinks", "builderAction", "Lni/shikatu/kotlin/io/path/FileVisitorBuilder;", "Lni/shikatu/kotlin/ExtensionFunctionType;", "fileVisitor", "ni.shikatu.kotlin-stdlib-jdk7"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/io/path/PathsKt")
public class PathsKt__PathUtilsKt extends PathsKt__PathRecursiveFunctionsKt {
    public static  void getExtension$annotations(Path path) {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use invariantSeparatorsPathString property instead.", replaceWith = @ReplaceWith(expression = "invariantSeparatorsPathString", imports = {}))
    public static  void getInvariantSeparatorsPath$annotations(Path path) {
    }

    public static  void getInvariantSeparatorsPathString$annotations(Path path) {
    }

    public static  void getName$annotations(Path path) {
    }

    public static  void getNameWithoutExtension$annotations(Path path) {
    }

    public static  void getPathString$annotations(Path path) {
    }

    public static final String getName(Path $this$name) {
        Intrinsics.checkNotNullParameter($this$name, "<this>");
        Path fileName = $this$name.getFileName();
        String string = fileName != null ? fileName.toString() : null;
        return string == null ? _UrlKt.FRAGMENT_ENCODE_SET : string;
    }

    public static final String getNameWithoutExtension(Path $this$nameWithoutExtension) {
        String string;
        String strSubstringBeforeLast$default;
        Intrinsics.checkNotNullParameter($this$nameWithoutExtension, "<this>");
        Path fileName = $this$nameWithoutExtension.getFileName();
        return (fileName == null || (string = fileName.toString()) == null || (strSubstringBeforeLast$default = StringsKt.substringBeforeLast$default(string, ".", (String) null, 2, (Object) null)) == null) ? _UrlKt.FRAGMENT_ENCODE_SET : strSubstringBeforeLast$default;
    }

    public static final String getExtension(Path $this$extension) {
        String string;
        String strSubstringAfterLast;
        Intrinsics.checkNotNullParameter($this$extension, "<this>");
        Path fileName = $this$extension.getFileName();
        return (fileName == null || (string = fileName.toString()) == null || (strSubstringAfterLast = StringsKt.substringAfterLast(string, '.', _UrlKt.FRAGMENT_ENCODE_SET)) == null) ? _UrlKt.FRAGMENT_ENCODE_SET : strSubstringAfterLast;
    }

    private static final String getPathString(Path $this$pathString) {
        Intrinsics.checkNotNullParameter($this$pathString, "<this>");
        return $this$pathString.toString();
    }

    public static final String getInvariantSeparatorsPathString(Path $this$invariantSeparatorsPathString) {
        Intrinsics.checkNotNullParameter($this$invariantSeparatorsPathString, "<this>");
        String separator = $this$invariantSeparatorsPathString.getFileSystem().getSeparator();
        if (Intrinsics.areEqual(separator, "/")) {
            return $this$invariantSeparatorsPathString.toString();
        }
        String string = $this$invariantSeparatorsPathString.toString();
        Intrinsics.checkNotNull(separator);
        return StringsKt.replace$default(string, separator, "/", false, 4, (Object) null);
    }

    private static final String getInvariantSeparatorsPath(Path $this$invariantSeparatorsPath) {
        Intrinsics.checkNotNullParameter($this$invariantSeparatorsPath, "<this>");
        return PathsKt.getInvariantSeparatorsPathString($this$invariantSeparatorsPath);
    }

    private static final Path absolute(Path $this$absolute) {
        Intrinsics.checkNotNullParameter($this$absolute, "<this>");
        Path absolutePath = $this$absolute.toAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "toAbsolutePath(...)");
        return absolutePath;
    }

    private static final String absolutePathString(Path $this$absolutePathString) {
        Intrinsics.checkNotNullParameter($this$absolutePathString, "<this>");
        return $this$absolutePathString.toAbsolutePath().toString();
    }

    public static final Path relativeTo(Path $this$relativeTo, Path base) {
        Intrinsics.checkNotNullParameter($this$relativeTo, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        try {
            return PathRelativizer.INSTANCE.tryRelativeTo($this$relativeTo, base);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage() + "\nthis path: " + $this$relativeTo + "\nbase path: " + base, e);
        }
    }

    public static final Path relativeToOrSelf(Path $this$relativeToOrSelf, Path base) {
        Intrinsics.checkNotNullParameter($this$relativeToOrSelf, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        Path pathRelativeToOrNull = PathsKt.relativeToOrNull($this$relativeToOrSelf, base);
        return pathRelativeToOrNull == null ? $this$relativeToOrSelf : pathRelativeToOrNull;
    }

    public static final Path relativeToOrNull(Path $this$relativeToOrNull, Path base) {
        Intrinsics.checkNotNullParameter($this$relativeToOrNull, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        try {
            return PathRelativizer.INSTANCE.tryRelativeTo($this$relativeToOrNull, base);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    static  Path copyTo$default(Path $this$copyTo_u24default, Path target, boolean overwrite, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            overwrite = false;
        }
        Intrinsics.checkNotNullParameter($this$copyTo_u24default, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        CopyOption[] options = overwrite ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path pathCopy = Files.copy($this$copyTo_u24default, target, (CopyOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(pathCopy, "copy(...)");
        return pathCopy;
    }

    @IgnorableReturnValue
    private static final Path copyTo(Path $this$copyTo, Path target, boolean overwrite) throws IOException {
        Intrinsics.checkNotNullParameter($this$copyTo, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        CopyOption[] options = overwrite ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path pathCopy = Files.copy($this$copyTo, target, (CopyOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(pathCopy, "copy(...)");
        return pathCopy;
    }

    @IgnorableReturnValue
    private static final Path copyTo(Path $this$copyTo, Path target, CopyOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$copyTo, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(options, "options");
        Path pathCopy = Files.copy($this$copyTo, target, (CopyOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(pathCopy, "copy(...)");
        return pathCopy;
    }

    private static final boolean exists(Path $this$exists, LinkOption... options) {
        Intrinsics.checkNotNullParameter($this$exists, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return Files.exists($this$exists, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    private static final boolean notExists(Path $this$notExists, LinkOption... options) {
        Intrinsics.checkNotNullParameter($this$notExists, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return Files.notExists($this$notExists, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    private static final boolean isRegularFile(Path $this$isRegularFile, LinkOption... options) {
        Intrinsics.checkNotNullParameter($this$isRegularFile, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return Files.isRegularFile($this$isRegularFile, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    private static final boolean isDirectory(Path $this$isDirectory, LinkOption... options) {
        Intrinsics.checkNotNullParameter($this$isDirectory, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return Files.isDirectory($this$isDirectory, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    private static final boolean isSymbolicLink(Path $this$isSymbolicLink) {
        Intrinsics.checkNotNullParameter($this$isSymbolicLink, "<this>");
        return Files.isSymbolicLink($this$isSymbolicLink);
    }

    private static final boolean isExecutable(Path $this$isExecutable) {
        Intrinsics.checkNotNullParameter($this$isExecutable, "<this>");
        return Files.isExecutable($this$isExecutable);
    }

    private static final boolean isHidden(Path $this$isHidden) throws IOException {
        Intrinsics.checkNotNullParameter($this$isHidden, "<this>");
        return Files.isHidden($this$isHidden);
    }

    private static final boolean isReadable(Path $this$isReadable) {
        Intrinsics.checkNotNullParameter($this$isReadable, "<this>");
        return Files.isReadable($this$isReadable);
    }

    private static final boolean isWritable(Path $this$isWritable) {
        Intrinsics.checkNotNullParameter($this$isWritable, "<this>");
        return Files.isWritable($this$isWritable);
    }

    private static final boolean isSameFileAs(Path $this$isSameFileAs, Path other) throws IOException {
        Intrinsics.checkNotNullParameter($this$isSameFileAs, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return Files.isSameFile($this$isSameFileAs, other);
    }

    public static  List listDirectoryEntries$default(Path path, String str, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            str = "*";
        }
        return PathsKt.listDirectoryEntries(path, str);
    }

    public static final List<Path> listDirectoryEntries(Path $this$listDirectoryEntries, String glob) throws IOException {
        Intrinsics.checkNotNullParameter($this$listDirectoryEntries, "<this>");
        Intrinsics.checkNotNullParameter(glob, "glob");
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream($this$listDirectoryEntries, glob);
        try {
            DirectoryStream<Path> directoryStream = directoryStreamNewDirectoryStream;
            Intrinsics.checkNotNull(directoryStream);
            List<Path> list = CollectionsKt.toList(directoryStream);
            CloseableKt.closeFinally(directoryStreamNewDirectoryStream, null);
            return list;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(directoryStreamNewDirectoryStream, th);
                throw th2;
            }
        }
    }

    static  Object useDirectoryEntries$default(Path $this$useDirectoryEntries_u24default, String glob, Function1 block, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            glob = "*";
        }
        Intrinsics.checkNotNullParameter($this$useDirectoryEntries_u24default, "<this>");
        Intrinsics.checkNotNullParameter(glob, "glob");
        Intrinsics.checkNotNullParameter(block, "block");
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream($this$useDirectoryEntries_u24default, glob);
        try {
            DirectoryStream<Path> directoryStream = directoryStreamNewDirectoryStream;
            Intrinsics.checkNotNull(directoryStream);
            Object objInvoke = block.invoke(CollectionsKt.asSequence(directoryStream));
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(directoryStreamNewDirectoryStream, null);
            InlineMarker.finallyEnd(1);
            return objInvoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                CloseableKt.closeFinally(directoryStreamNewDirectoryStream, th);
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
    }

    @IgnorableReturnValue
    private static final <T> T useDirectoryEntries(Path $this$useDirectoryEntries, String glob, Function1<? super Sequence<? extends Path>, ? extends T> function1) throws IOException {
        Intrinsics.checkNotNullParameter($this$useDirectoryEntries, "<this>");
        Intrinsics.checkNotNullParameter(glob, "glob");
        Intrinsics.checkNotNullParameter(function1, "block");
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream($this$useDirectoryEntries, glob);
        try {
            DirectoryStream<Path> directoryStream = directoryStreamNewDirectoryStream;
            Intrinsics.checkNotNull(directoryStream);
            T tInvoke = function1.invoke(CollectionsKt.asSequence(directoryStream));
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(directoryStreamNewDirectoryStream, null);
            InlineMarker.finallyEnd(1);
            return tInvoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                CloseableKt.closeFinally(directoryStreamNewDirectoryStream, th);
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
    }

    static  void forEachDirectoryEntry$default(Path $this$forEachDirectoryEntry_u24default, String glob, Function1 action, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            glob = "*";
        }
        Intrinsics.checkNotNullParameter($this$forEachDirectoryEntry_u24default, "<this>");
        Intrinsics.checkNotNullParameter(glob, "glob");
        Intrinsics.checkNotNullParameter(action, "action");
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream($this$forEachDirectoryEntry_u24default, glob);
        try {
            DirectoryStream<Path> directoryStream = directoryStreamNewDirectoryStream;
            Intrinsics.checkNotNull(directoryStream);
            DirectoryStream<Path> $this$forEach$iv = directoryStream;
            Iterator<Path> it = $this$forEach$iv.iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            Unit unit = Unit.INSTANCE;
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(directoryStreamNewDirectoryStream, null);
            InlineMarker.finallyEnd(1);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                CloseableKt.closeFinally(directoryStreamNewDirectoryStream, th);
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
    }

    private static final void forEachDirectoryEntry(Path $this$forEachDirectoryEntry, String glob, Function1<? super Path, Unit> function1) throws IOException {
        Intrinsics.checkNotNullParameter($this$forEachDirectoryEntry, "<this>");
        Intrinsics.checkNotNullParameter(glob, "glob");
        Intrinsics.checkNotNullParameter(function1, "action");
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream($this$forEachDirectoryEntry, glob);
        try {
            DirectoryStream<Path> directoryStream = directoryStreamNewDirectoryStream;
            Intrinsics.checkNotNull(directoryStream);
            DirectoryStream<Path> $this$forEach$iv = directoryStream;
            for (Object element$iv : $this$forEach$iv) {
                function1.invoke(element$iv);
            }
            Unit unit = Unit.INSTANCE;
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(directoryStreamNewDirectoryStream, null);
            InlineMarker.finallyEnd(1);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                CloseableKt.closeFinally(directoryStreamNewDirectoryStream, th);
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
    }

    private static final long fileSize(Path $this$fileSize) throws IOException {
        Intrinsics.checkNotNullParameter($this$fileSize, "<this>");
        return Files.size($this$fileSize);
    }

    private static final void deleteExisting(Path $this$deleteExisting) throws IOException {
        Intrinsics.checkNotNullParameter($this$deleteExisting, "<this>");
        Files.delete($this$deleteExisting);
    }

    @IgnorableReturnValue
    private static final boolean deleteIfExists(Path $this$deleteIfExists) throws IOException {
        Intrinsics.checkNotNullParameter($this$deleteIfExists, "<this>");
        return Files.deleteIfExists($this$deleteIfExists);
    }

    @IgnorableReturnValue
    private static final Path createDirectory(Path $this$createDirectory, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter($this$createDirectory, "<this>");
        Intrinsics.checkNotNullParameter(fileAttributeArr, "attributes");
        Path pathCreateDirectory = Files.createDirectory($this$createDirectory, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateDirectory, "createDirectory(...)");
        return pathCreateDirectory;
    }

    @IgnorableReturnValue
    private static final Path createDirectories(Path $this$createDirectories, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter($this$createDirectories, "<this>");
        Intrinsics.checkNotNullParameter(fileAttributeArr, "attributes");
        Path pathCreateDirectories = Files.createDirectories($this$createDirectories, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateDirectories, "createDirectories(...)");
        return pathCreateDirectories;
    }

    @IgnorableReturnValue
    public static final Path createParentDirectories(Path $this$createParentDirectories, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter($this$createParentDirectories, "<this>");
        Intrinsics.checkNotNullParameter(fileAttributeArr, "attributes");
        Path parent = $this$createParentDirectories.getParent();
        if (parent != null && !Files.isDirectory(parent, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
            try {
                FileAttribute[] fileAttributeArr2 = (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length);
                Intrinsics.checkNotNullExpressionValue(Files.createDirectories(parent, (FileAttribute[]) Arrays.copyOf(fileAttributeArr2, fileAttributeArr2.length)), "createDirectories(...)");
            } catch (FileAlreadyExistsException e) {
                if (!Files.isDirectory(parent, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                    throw e;
                }
            }
        }
        return $this$createParentDirectories;
    }

    @IgnorableReturnValue
    private static final Path moveTo(Path $this$moveTo, Path target, CopyOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$moveTo, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(options, "options");
        Path pathMove = Files.move($this$moveTo, target, (CopyOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(pathMove, "move(...)");
        return pathMove;
    }

    static  Path moveTo$default(Path $this$moveTo_u24default, Path target, boolean overwrite, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            overwrite = false;
        }
        Intrinsics.checkNotNullParameter($this$moveTo_u24default, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        CopyOption[] options = overwrite ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path pathMove = Files.move($this$moveTo_u24default, target, (CopyOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(pathMove, "move(...)");
        return pathMove;
    }

    @IgnorableReturnValue
    private static final Path moveTo(Path $this$moveTo, Path target, boolean overwrite) throws IOException {
        Intrinsics.checkNotNullParameter($this$moveTo, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        CopyOption[] options = overwrite ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path pathMove = Files.move($this$moveTo, target, (CopyOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(pathMove, "move(...)");
        return pathMove;
    }

    private static final FileStore fileStore(Path $this$fileStore) throws IOException {
        Intrinsics.checkNotNullParameter($this$fileStore, "<this>");
        FileStore fileStore = Files.getFileStore($this$fileStore);
        Intrinsics.checkNotNullExpressionValue(fileStore, "getFileStore(...)");
        return fileStore;
    }

    private static final Object getAttribute(Path $this$getAttribute, String attribute, LinkOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$getAttribute, "<this>");
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        Intrinsics.checkNotNullParameter(options, "options");
        return Files.getAttribute($this$getAttribute, attribute, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    @IgnorableReturnValue
    private static final Path setAttribute(Path $this$setAttribute, String attribute, Object value, LinkOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$setAttribute, "<this>");
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        Intrinsics.checkNotNullParameter(options, "options");
        Path attribute2 = Files.setAttribute($this$setAttribute, attribute, value, (LinkOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(attribute2, "setAttribute(...)");
        return attribute2;
    }

    private static final  <V extends FileAttributeView> V fileAttributesViewOrNull(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        Intrinsics.reifiedOperationMarker(4, "V");
        return (V) Files.getFileAttributeView(path, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final  <V extends FileAttributeView> V fileAttributesView(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        Intrinsics.reifiedOperationMarker(4, "V");
        V v = (V) Files.getFileAttributeView(path, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        if (v != null) {
            return v;
        }
        Intrinsics.reifiedOperationMarker(4, "V");
        PathsKt.fileAttributeViewNotAvailable(path, FileAttributeView.class);
        throw new KotlinNothingValueException();
    }

    public static final Void fileAttributeViewNotAvailable(Path path, Class<?> cls) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(cls, "attributeViewClass");
        throw new UnsupportedOperationException("The desired attribute view type " + cls + " is not available for the file " + path + '.');
    }

    private static final  <A extends BasicFileAttributes> A readAttributes(Path path, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        Intrinsics.reifiedOperationMarker(4, "A");
        A a = (A) Files.readAttributes(path, BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(a, "readAttributes(...)");
        return a;
    }

    private static final Map<String, Object> readAttributes(Path $this$readAttributes, String attributes, LinkOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$readAttributes, "<this>");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(options, "options");
        Map<String, Object> attributes2 = Files.readAttributes($this$readAttributes, attributes, (LinkOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(attributes2, "readAttributes(...)");
        return attributes2;
    }

    private static final FileTime getLastModifiedTime(Path $this$getLastModifiedTime, LinkOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$getLastModifiedTime, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        FileTime lastModifiedTime = Files.getLastModifiedTime($this$getLastModifiedTime, (LinkOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(lastModifiedTime, "getLastModifiedTime(...)");
        return lastModifiedTime;
    }

    private static final Path setLastModifiedTime(Path $this$setLastModifiedTime, FileTime value) throws IOException {
        Intrinsics.checkNotNullParameter($this$setLastModifiedTime, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        Path lastModifiedTime = Files.setLastModifiedTime($this$setLastModifiedTime, value);
        Intrinsics.checkNotNullExpressionValue(lastModifiedTime, "setLastModifiedTime(...)");
        return lastModifiedTime;
    }

    private static final UserPrincipal getOwner(Path $this$getOwner, LinkOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$getOwner, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return Files.getOwner($this$getOwner, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    @IgnorableReturnValue
    private static final Path setOwner(Path $this$setOwner, UserPrincipal value) throws IOException {
        Intrinsics.checkNotNullParameter($this$setOwner, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        Path owner = Files.setOwner($this$setOwner, value);
        Intrinsics.checkNotNullExpressionValue(owner, "setOwner(...)");
        return owner;
    }

    private static final Set<PosixFilePermission> getPosixFilePermissions(Path $this$getPosixFilePermissions, LinkOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$getPosixFilePermissions, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Set<PosixFilePermission> posixFilePermissions = Files.getPosixFilePermissions($this$getPosixFilePermissions, (LinkOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(posixFilePermissions, "getPosixFilePermissions(...)");
        return posixFilePermissions;
    }

    private static final Path setPosixFilePermissions(Path $this$setPosixFilePermissions, Set<? extends PosixFilePermission> set) throws IOException {
        Intrinsics.checkNotNullParameter($this$setPosixFilePermissions, "<this>");
        Intrinsics.checkNotNullParameter(set, "value");
        Path posixFilePermissions = Files.setPosixFilePermissions($this$setPosixFilePermissions, set);
        Intrinsics.checkNotNullExpressionValue(posixFilePermissions, "setPosixFilePermissions(...)");
        return posixFilePermissions;
    }

    @IgnorableReturnValue
    private static final Path createLinkPointingTo(Path $this$createLinkPointingTo, Path target) throws IOException {
        Intrinsics.checkNotNullParameter($this$createLinkPointingTo, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Path pathCreateLink = Files.createLink($this$createLinkPointingTo, target);
        Intrinsics.checkNotNullExpressionValue(pathCreateLink, "createLink(...)");
        return pathCreateLink;
    }

    @IgnorableReturnValue
    private static final Path createSymbolicLinkPointingTo(Path $this$createSymbolicLinkPointingTo, Path target, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter($this$createSymbolicLinkPointingTo, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(fileAttributeArr, "attributes");
        Path pathCreateSymbolicLink = Files.createSymbolicLink($this$createSymbolicLinkPointingTo, target, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateSymbolicLink, "createSymbolicLink(...)");
        return pathCreateSymbolicLink;
    }

    private static final Path readSymbolicLink(Path $this$readSymbolicLink) throws IOException {
        Intrinsics.checkNotNullParameter($this$readSymbolicLink, "<this>");
        Path symbolicLink = Files.readSymbolicLink($this$readSymbolicLink);
        Intrinsics.checkNotNullExpressionValue(symbolicLink, "readSymbolicLink(...)");
        return symbolicLink;
    }

    @IgnorableReturnValue
    private static final Path createFile(Path $this$createFile, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter($this$createFile, "<this>");
        Intrinsics.checkNotNullParameter(fileAttributeArr, "attributes");
        Path pathCreateFile = Files.createFile($this$createFile, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateFile, "createFile(...)");
        return pathCreateFile;
    }

    static  Path createTempFile$default(String prefix, String suffix, FileAttribute[] attributes, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            prefix = null;
        }
        if ((i & 2) != 0) {
            suffix = null;
        }
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Path pathCreateTempFile = Files.createTempFile(prefix, suffix, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateTempFile, "createTempFile(...)");
        return pathCreateTempFile;
    }

    private static final Path createTempFile(String prefix, String suffix, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(fileAttributeArr, "attributes");
        Path pathCreateTempFile = Files.createTempFile(prefix, suffix, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateTempFile, "createTempFile(...)");
        return pathCreateTempFile;
    }

    public static  Path createTempFile$default(Path path, String str, String str2, FileAttribute[] fileAttributeArr, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return PathsKt.createTempFile(path, str, str2, fileAttributeArr);
    }

    public static final Path createTempFile(Path directory, String prefix, String suffix, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(fileAttributeArr, "attributes");
        if (directory != null) {
            Path pathCreateTempFile = Files.createTempFile(directory, prefix, suffix, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
            Intrinsics.checkNotNullExpressionValue(pathCreateTempFile, "createTempFile(...)");
            return pathCreateTempFile;
        }
        Path pathCreateTempFile2 = Files.createTempFile(prefix, suffix, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateTempFile2, "createTempFile(...)");
        return pathCreateTempFile2;
    }

    static  Path createTempDirectory$default(String prefix, FileAttribute[] attributes, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            prefix = null;
        }
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Path pathCreateTempDirectory = Files.createTempDirectory(prefix, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateTempDirectory, "createTempDirectory(...)");
        return pathCreateTempDirectory;
    }

    private static final Path createTempDirectory(String prefix, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(fileAttributeArr, "attributes");
        Path pathCreateTempDirectory = Files.createTempDirectory(prefix, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateTempDirectory, "createTempDirectory(...)");
        return pathCreateTempDirectory;
    }

    public static  Path createTempDirectory$default(Path path, String str, FileAttribute[] fileAttributeArr, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            str = null;
        }
        return PathsKt.createTempDirectory(path, str, fileAttributeArr);
    }

    public static final Path createTempDirectory(Path directory, String prefix, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(fileAttributeArr, "attributes");
        if (directory != null) {
            Path pathCreateTempDirectory = Files.createTempDirectory(directory, prefix, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
            Intrinsics.checkNotNullExpressionValue(pathCreateTempDirectory, "createTempDirectory(...)");
            return pathCreateTempDirectory;
        }
        Path pathCreateTempDirectory2 = Files.createTempDirectory(prefix, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateTempDirectory2, "createTempDirectory(...)");
        return pathCreateTempDirectory2;
    }

    private static final Path div(Path $this$div, Path other) {
        Intrinsics.checkNotNullParameter($this$div, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Path pathResolve = $this$div.resolve(other);
        Intrinsics.checkNotNullExpressionValue(pathResolve, "resolve(...)");
        return pathResolve;
    }

    private static final Path div(Path $this$div, String other) {
        Intrinsics.checkNotNullParameter($this$div, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Path pathResolve = $this$div.resolve(other);
        Intrinsics.checkNotNullExpressionValue(pathResolve, "resolve(...)");
        return pathResolve;
    }

    private static final Path Path(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        Path path2 = Paths.get(path, new String[0]);
        Intrinsics.checkNotNullExpressionValue(path2, "get(...)");
        return path2;
    }

    private static final Path Path(String base, String... subpaths) {
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(subpaths, "subpaths");
        Path path = Paths.get(base, (String[]) Arrays.copyOf(subpaths, subpaths.length));
        Intrinsics.checkNotNullExpressionValue(path, "get(...)");
        return path;
    }

    private static final Path toPath(URI $this$toPath) {
        Intrinsics.checkNotNullParameter($this$toPath, "<this>");
        Path path = Paths.get($this$toPath);
        Intrinsics.checkNotNullExpressionValue(path, "get(...)");
        return path;
    }

    public static final Sequence<Path> walk(Path $this$walk, PathWalkOption... options) {
        Intrinsics.checkNotNullParameter($this$walk, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return new PathTreeWalk($this$walk, options);
    }

    public static  void visitFileTree$default(Path path, FileVisitor fileVisitor, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = IntCompanionObject.MAX_VALUE;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        PathsKt.visitFileTree(path, (FileVisitor<Path>) fileVisitor, i, z);
    }

    public static final void visitFileTree(Path $this$visitFileTree, FileVisitor<Path> fileVisitor, int maxDepth, boolean followLinks) throws IOException {
        Intrinsics.checkNotNullParameter($this$visitFileTree, "<this>");
        Intrinsics.checkNotNullParameter(fileVisitor, "visitor");
        Set options = followLinks ? SetsKt.setOf(FileVisitOption.FOLLOW_LINKS) : SetsKt.emptySet();
        Files.walkFileTree($this$visitFileTree, options, maxDepth, fileVisitor);
    }

    public static  void visitFileTree$default(Path path, int i, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = IntCompanionObject.MAX_VALUE;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        PathsKt.visitFileTree(path, i, z, (Function1<? super FileVisitorBuilder, Unit>) function1);
    }

    public static final void visitFileTree(Path $this$visitFileTree, int maxDepth, boolean followLinks, Function1<? super FileVisitorBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$visitFileTree, "<this>");
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        PathsKt.visitFileTree($this$visitFileTree, PathsKt.fileVisitor(function1), maxDepth, followLinks);
    }

    public static final FileVisitor<Path> fileVisitor(Function1<? super FileVisitorBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        FileVisitorBuilderImpl fileVisitorBuilderImpl = new FileVisitorBuilderImpl();
        function1.invoke(fileVisitorBuilderImpl);
        return fileVisitorBuilderImpl.build();
    }
}
