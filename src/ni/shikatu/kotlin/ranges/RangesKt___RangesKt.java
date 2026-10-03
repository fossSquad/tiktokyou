package ni.shikatu.kotlin.ranges;

import java.util.NoSuchElementException;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecatedSinceKotlin;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.random.Random;
import ni.shikatu.kotlin.random.RandomKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000f\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0006*\u00020\u0007H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a\u001c\u0010\u0000\u001a\u00020\b*\u00020\tH\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a#\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005¢\u0006\u0002\u0010\u000b\u001a#\u0010\n\u001a\u0004\u0018\u00010\u0006*\u00020\u0007H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005¢\u0006\u0002\u0010\f\u001a#\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\tH\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005¢\u0006\u0002\u0010\r\u001a\u001c\u0010\u000e\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a\u001c\u0010\u000e\u001a\u00020\u0006*\u00020\u0007H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a\u001c\u0010\u000e\u001a\u00020\b*\u00020\tH\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a#\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005¢\u0006\u0002\u0010\u000b\u001a#\u0010\u000f\u001a\u0004\u0018\u00010\u0006*\u00020\u0007H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005¢\u0006\u0002\u0010\f\u001a#\u0010\u000f\u001a\u0004\u0018\u00010\b*\u00020\tH\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005¢\u0006\u0002\u0010\r\u001a \u0010\u0010\u001a\u00020\u0001*\u00020\u0011H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012b\u0002\b\u0013\u001a \u0010\u0010\u001a\u00020\u0006*\u00020\u0014H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012b\u0002\b\u0013\u001a \u0010\u0010\u001a\u00020\b*\u00020\u0015H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012b\u0002\b\u0013\u001a$\u0010\u0010\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0016H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u001a$\u0010\u0010\u001a\u00020\u0006*\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0016H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u001a$\u0010\u0010\u001a\u00020\b*\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0016H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u001a'\u0010\u0017\u001a\u0004\u0018\u00010\u0001*\u00020\u0011H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019b\u0002\b\u0013¢\u0006\u0002\u0010\u0018\u001a'\u0010\u0017\u001a\u0004\u0018\u00010\u0006*\u00020\u0014H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019b\u0002\b\u0013¢\u0006\u0002\u0010\u001a\u001a'\u0010\u0017\u001a\u0004\u0018\u00010\b*\u00020\u0015H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019b\u0002\b\u0013¢\u0006\u0002\u0010\u001b\u001a+\u0010\u0017\u001a\u0004\u0018\u00010\u0001*\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0016H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019¢\u0006\u0002\u0010\u001c\u001a+\u0010\u0017\u001a\u0004\u0018\u00010\u0006*\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0016H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019¢\u0006\u0002\u0010\u001d\u001a+\u0010\u0017\u001a\u0004\u0018\u00010\b*\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0016H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019¢\u0006\u0002\u0010\u001e\u001a/\u0010\u001f\u001a\u00020 *\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0087\u008a\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012b\u0002\b\u0013¢\u0006\u0002\u0010\"\u001a/\u0010\u001f\u001a\u00020 *\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\u0006H\u0087\u008a\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012b\u0002\b\u0013¢\u0006\u0002\u0010#\u001a/\u0010\u001f\u001a\u00020 *\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\bH\u0087\u008a\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012b\u0002\b\u0013¢\u0006\u0002\u0010$\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00010%2\u0006\u0010&\u001a\u00020'H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b((¢\u0006\u0002\b(\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00060%2\u0006\u0010&\u001a\u00020'H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(+¢\u0006\u0002\b+\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020,0%2\u0006\u0010&\u001a\u00020'H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(-¢\u0006\u0002\b-\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020.0%2\u0006\u0010&\u001a\u00020'H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(/¢\u0006\u0002\b/\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u0002080%2\u0006\u0010&\u001a\u00020'H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(9¢\u0006\u0002\b9\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00010:2\u0006\u0010&\u001a\u00020'H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b((b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b(\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00060:2\u0006\u0010&\u001a\u00020'H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(+b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b+\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020,0:2\u0006\u0010&\u001a\u00020'H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(-b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b-\u001a\u001a\u0010\u001f\u001a\u00020 *\u00020\u00112\u0006\u0010&\u001a\u00020'H\u0087\u008a\u0004b\u0002\b\u0013\u001a\u001a\u0010\u001f\u001a\u00020 *\u00020\u00142\u0006\u0010&\u001a\u00020'H\u0087\u008a\u0004b\u0002\b\u0013\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00010%2\u0006\u0010&\u001a\u00020.H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b((¢\u0006\u0002\b(\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00060%2\u0006\u0010&\u001a\u00020.H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(+¢\u0006\u0002\b+\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020'0%2\u0006\u0010&\u001a\u00020.H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(?¢\u0006\u0002\b?\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020,0%2\u0006\u0010&\u001a\u00020.H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(-¢\u0006\u0002\b-\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u0002080%2\u0006\u0010&\u001a\u00020.H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(9¢\u0006\u0002\b9\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00010%2\u0006\u0010&\u001a\u000208H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b((¢\u0006\u0002\b(\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00060%2\u0006\u0010&\u001a\u000208H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(+¢\u0006\u0002\b+\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020'0%2\u0006\u0010&\u001a\u000208H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(?¢\u0006\u0002\b?\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020,0%2\u0006\u0010&\u001a\u000208H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(-¢\u0006\u0002\b-\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020.0%2\u0006\u0010&\u001a\u000208H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(/¢\u0006\u0002\b/\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020.0:2\u0006\u0010&\u001a\u000208H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(/b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b/\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00060%2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(+¢\u0006\u0002\b+\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020'0%2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(?¢\u0006\u0002\b?\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020,0%2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(-¢\u0006\u0002\b-\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020.0%2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(/¢\u0006\u0002\b/\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u0002080%2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(9¢\u0006\u0002\b9\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00060:2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(+b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b+\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020'0:2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(?b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b?\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020,0:2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(-b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b-\u001a\u001a\u0010\u001f\u001a\u00020 *\u00020\u00142\u0006\u0010&\u001a\u00020\u0001H\u0087\u008a\u0004b\u0002\b\u0013\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00010%2\u0006\u0010&\u001a\u00020\u0006H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b((¢\u0006\u0002\b(\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020'0%2\u0006\u0010&\u001a\u00020\u0006H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(?¢\u0006\u0002\b?\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020,0%2\u0006\u0010&\u001a\u00020\u0006H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(-¢\u0006\u0002\b-\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020.0%2\u0006\u0010&\u001a\u00020\u0006H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(/¢\u0006\u0002\b/\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u0002080%2\u0006\u0010&\u001a\u00020\u0006H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(9¢\u0006\u0002\b9\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00010:2\u0006\u0010&\u001a\u00020\u0006H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b((b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b(\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020'0:2\u0006\u0010&\u001a\u00020\u0006H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(?b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b?\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020,0:2\u0006\u0010&\u001a\u00020\u0006H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(-b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b-\u001a\u001a\u0010\u001f\u001a\u00020 *\u00020\u00112\u0006\u0010&\u001a\u00020\u0006H\u0087\u008a\u0004b\u0002\b\u0013\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00010%2\u0006\u0010&\u001a\u00020,H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b((¢\u0006\u0002\b(\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00060%2\u0006\u0010&\u001a\u00020,H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(+¢\u0006\u0002\b+\u001a/\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020'0%2\u0006\u0010&\u001a\u00020,H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(?¢\u0006\u0002\b?\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020.0%2\u0006\u0010&\u001a\u00020,H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(/¢\u0006\u0002\b/\u001a_\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u0002080%2\u0006\u0010&\u001a\u00020,H\u0087\u0082\u0004b\f\b0\u0012\b\b1\u0012\u0004\b\b(2b \b3\u0012\b\b4\u0012\u0004\b\b(\u0012\u0012\b\b5\u0012\u0004\b\b(\u0019\u0012\b\b6\u0012\u0004\b\b(7b\f\b)\u0012\b\b*\u0012\u0004\b\b(9¢\u0006\u0002\b9\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00010:2\u0006\u0010&\u001a\u00020,H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b((b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b(\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00060:2\u0006\u0010&\u001a\u00020,H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(+b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b+\u001aO\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020'0:2\u0006\u0010&\u001a\u00020,H\u0087\u0082\u0004b\f\b)\u0012\b\b*\u0012\u0004\b\b(?b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(;b\u0010\b<\u0012\f\b=\u0012\b\b\fJ\u0004\b\t0>¢\u0006\u0002\b?\u001a\u001a\u0010\u001f\u001a\u00020 *\u00020\u00112\u0006\u0010&\u001a\u00020,H\u0087\u008a\u0004b\u0002\b\u0013\u001a\u001a\u0010\u001f\u001a\u00020 *\u00020\u00142\u0006\u0010&\u001a\u00020,H\u0087\u008a\u0004b\u0002\b\u0013\u001a\u0016\u0010@\u001a\u00020\u0002*\u00020\u00012\u0006\u0010A\u001a\u00020'H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0007*\u00020\u00062\u0006\u0010A\u001a\u00020'H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0002*\u00020'2\u0006\u0010A\u001a\u00020'H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0002*\u00020,2\u0006\u0010A\u001a\u00020'H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\t*\u00020\b2\u0006\u0010A\u001a\u00020\bH\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0002*\u00020\u00012\u0006\u0010A\u001a\u00020\u0001H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0007*\u00020\u00062\u0006\u0010A\u001a\u00020\u0001H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0002*\u00020'2\u0006\u0010A\u001a\u00020\u0001H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0002*\u00020,2\u0006\u0010A\u001a\u00020\u0001H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0007*\u00020\u00012\u0006\u0010A\u001a\u00020\u0006H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0007*\u00020\u00062\u0006\u0010A\u001a\u00020\u0006H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0007*\u00020'2\u0006\u0010A\u001a\u00020\u0006H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0007*\u00020,2\u0006\u0010A\u001a\u00020\u0006H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0002*\u00020\u00012\u0006\u0010A\u001a\u00020,H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0007*\u00020\u00062\u0006\u0010A\u001a\u00020,H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0002*\u00020'2\u0006\u0010A\u001a\u00020,H\u0086\u0084\u0004\u001a\u0016\u0010@\u001a\u00020\u0002*\u00020,2\u0006\u0010A\u001a\u00020,H\u0086\u0084\u0004\u001a\u000e\u0010B\u001a\u00020\u0002*\u00020\u0002H\u0086\u0080\u0004\u001a\u000e\u0010B\u001a\u00020\u0007*\u00020\u0007H\u0086\u0080\u0004\u001a\u000e\u0010B\u001a\u00020\t*\u00020\tH\u0086\u0080\u0004\u001a\u0016\u0010C\u001a\u00020\u0002*\u00020\u00022\u0006\u0010C\u001a\u00020\u0001H\u0086\u0084\u0004\u001a\u0016\u0010C\u001a\u00020\u0007*\u00020\u00072\u0006\u0010C\u001a\u00020\u0006H\u0086\u0084\u0004\u001a\u0016\u0010C\u001a\u00020\t*\u00020\t2\u0006\u0010C\u001a\u00020\u0001H\u0086\u0084\u0004\u001a\u0015\u0010D\u001a\u0004\u0018\u00010'*\u00020\u0001H\u0080\u0080\u0004¢\u0006\u0002\u0010E\u001a\u0015\u0010D\u001a\u0004\u0018\u00010'*\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\u0010F\u001a\u0015\u0010D\u001a\u0004\u0018\u00010'*\u00020,H\u0080\u0080\u0004¢\u0006\u0002\u0010G\u001a\u0015\u0010D\u001a\u0004\u0018\u00010'*\u00020.H\u0080\u0080\u0004¢\u0006\u0002\u0010H\u001a\u0015\u0010D\u001a\u0004\u0018\u00010'*\u000208H\u0080\u0080\u0004¢\u0006\u0002\u0010I\u001a\u0015\u0010J\u001a\u0004\u0018\u00010\u0001*\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\u0010K\u001a\u0015\u0010J\u001a\u0004\u0018\u00010\u0001*\u00020.H\u0080\u0080\u0004¢\u0006\u0002\u0010L\u001a\u0015\u0010J\u001a\u0004\u0018\u00010\u0001*\u000208H\u0080\u0080\u0004¢\u0006\u0002\u0010M\u001a\u0015\u0010N\u001a\u0004\u0018\u00010\u0006*\u00020.H\u0080\u0080\u0004¢\u0006\u0002\u0010O\u001a\u0015\u0010N\u001a\u0004\u0018\u00010\u0006*\u000208H\u0080\u0080\u0004¢\u0006\u0002\u0010P\u001a\u0015\u0010Q\u001a\u0004\u0018\u00010,*\u00020\u0001H\u0080\u0080\u0004¢\u0006\u0002\u0010R\u001a\u0015\u0010Q\u001a\u0004\u0018\u00010,*\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\u0010S\u001a\u0015\u0010Q\u001a\u0004\u0018\u00010,*\u00020.H\u0080\u0080\u0004¢\u0006\u0002\u0010T\u001a\u0015\u0010Q\u001a\u0004\u0018\u00010,*\u000208H\u0080\u0080\u0004¢\u0006\u0002\u0010U\u001a\u0016\u0010V\u001a\u00020\u0011*\u00020\u00012\u0006\u0010A\u001a\u00020'H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0014*\u00020\u00062\u0006\u0010A\u001a\u00020'H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0011*\u00020'2\u0006\u0010A\u001a\u00020'H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0011*\u00020,2\u0006\u0010A\u001a\u00020'H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0015*\u00020\b2\u0006\u0010A\u001a\u00020\bH\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0011*\u00020\u00012\u0006\u0010A\u001a\u00020\u0001H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0014*\u00020\u00062\u0006\u0010A\u001a\u00020\u0001H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0011*\u00020'2\u0006\u0010A\u001a\u00020\u0001H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0011*\u00020,2\u0006\u0010A\u001a\u00020\u0001H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0014*\u00020\u00012\u0006\u0010A\u001a\u00020\u0006H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0014*\u00020\u00062\u0006\u0010A\u001a\u00020\u0006H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0014*\u00020'2\u0006\u0010A\u001a\u00020\u0006H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0014*\u00020,2\u0006\u0010A\u001a\u00020\u0006H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0011*\u00020\u00012\u0006\u0010A\u001a\u00020,H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0014*\u00020\u00062\u0006\u0010A\u001a\u00020,H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0011*\u00020'2\u0006\u0010A\u001a\u00020,H\u0086\u0084\u0004\u001a\u0016\u0010V\u001a\u00020\u0011*\u00020,2\u0006\u0010A\u001a\u00020,H\u0086\u0084\u0004\u001a+\u0010W\u001a\u0002HX\"\u000e\b\u0000\u0010X*\b\u0012\u0004\u0012\u0002HX0Y*\u0002HX2\u0006\u0010Z\u001a\u0002HXH\u0086\u0080\u0004¢\u0006\u0002\u0010[\u001a\u0016\u0010W\u001a\u00020'*\u00020'2\u0006\u0010Z\u001a\u00020'H\u0086\u0080\u0004\u001a\u0016\u0010W\u001a\u00020,*\u00020,2\u0006\u0010Z\u001a\u00020,H\u0086\u0080\u0004\u001a\u0016\u0010W\u001a\u00020\u0001*\u00020\u00012\u0006\u0010Z\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0016\u0010W\u001a\u00020\u0006*\u00020\u00062\u0006\u0010Z\u001a\u00020\u0006H\u0086\u0080\u0004\u001a\u0016\u0010W\u001a\u000208*\u0002082\u0006\u0010Z\u001a\u000208H\u0086\u0080\u0004\u001a\u0016\u0010W\u001a\u00020.*\u00020.2\u0006\u0010Z\u001a\u00020.H\u0086\u0080\u0004\u001a+\u0010\\\u001a\u0002HX\"\u000e\b\u0000\u0010X*\b\u0012\u0004\u0012\u0002HX0Y*\u0002HX2\u0006\u0010]\u001a\u0002HXH\u0086\u0080\u0004¢\u0006\u0002\u0010[\u001a\u0016\u0010\\\u001a\u00020'*\u00020'2\u0006\u0010]\u001a\u00020'H\u0086\u0080\u0004\u001a\u0016\u0010\\\u001a\u00020,*\u00020,2\u0006\u0010]\u001a\u00020,H\u0086\u0080\u0004\u001a\u0016\u0010\\\u001a\u00020\u0001*\u00020\u00012\u0006\u0010]\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0016\u0010\\\u001a\u00020\u0006*\u00020\u00062\u0006\u0010]\u001a\u00020\u0006H\u0086\u0080\u0004\u001a\u0016\u0010\\\u001a\u000208*\u0002082\u0006\u0010]\u001a\u000208H\u0086\u0080\u0004\u001a\u0016\u0010\\\u001a\u00020.*\u00020.2\u0006\u0010]\u001a\u00020.H\u0086\u0080\u0004\u001a7\u0010^\u001a\u0002HX\"\u000e\b\u0000\u0010X*\b\u0012\u0004\u0012\u0002HX0Y*\u0002HX2\b\u0010Z\u001a\u0004\u0018\u0001HX2\b\u0010]\u001a\u0004\u0018\u0001HXH\u0086\u0080\u0004¢\u0006\u0002\u0010_\u001a\u001e\u0010^\u001a\u00020'*\u00020'2\u0006\u0010Z\u001a\u00020'2\u0006\u0010]\u001a\u00020'H\u0086\u0080\u0004\u001a\u001e\u0010^\u001a\u00020,*\u00020,2\u0006\u0010Z\u001a\u00020,2\u0006\u0010]\u001a\u00020,H\u0086\u0080\u0004\u001a\u001e\u0010^\u001a\u00020\u0001*\u00020\u00012\u0006\u0010Z\u001a\u00020\u00012\u0006\u0010]\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u001e\u0010^\u001a\u00020\u0006*\u00020\u00062\u0006\u0010Z\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\u0006H\u0086\u0080\u0004\u001a\u001e\u0010^\u001a\u000208*\u0002082\u0006\u0010Z\u001a\u0002082\u0006\u0010]\u001a\u000208H\u0086\u0080\u0004\u001a\u001e\u0010^\u001a\u00020.*\u00020.2\u0006\u0010Z\u001a\u00020.2\u0006\u0010]\u001a\u00020.H\u0086\u0080\u0004\u001a?\u0010^\u001a\u0002HX\"\u000e\b\u0000\u0010X*\b\u0012\u0004\u0012\u0002HX0Y*\u0002HX2\f\u0010`\u001a\b\u0012\u0004\u0012\u0002HX0aH\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(c¢\u0006\u0002\u0010b\u001a1\u0010^\u001a\u0002HX\"\u000e\b\u0000\u0010X*\b\u0012\u0004\u0012\u0002HX0Y*\u0002HX2\f\u0010`\u001a\b\u0012\u0004\u0012\u0002HX0%H\u0086\u0080\u0004¢\u0006\u0002\u0010d\u001a\u001c\u0010^\u001a\u00020\u0001*\u00020\u00012\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00010%H\u0086\u0080\u0004\u001a\u001c\u0010^\u001a\u00020\u0006*\u00020\u00062\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00060%H\u0086\u0080\u0004¨\u0006e"}, d2 = {"first", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/ranges/IntProgression;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.7", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/ranges/LongProgression;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/ranges/CharProgression;", "firstOrNull", "(Lkotlin/ranges/IntProgression;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongProgression;)Ljava/lang/Long;", "(Lkotlin/ranges/CharProgression;)Ljava/lang/Character;", "last", "lastOrNull", "random", "Lni/shikatu/kotlin/ranges/IntRange;", "1.3", "Lni/shikatu/kotlin/internal/InlineOnly;", "Lni/shikatu/kotlin/ranges/LongRange;", "Lni/shikatu/kotlin/ranges/CharRange;", "Lni/shikatu/kotlin/random/Random;", "randomOrNull", "(Lkotlin/ranges/IntRange;)Ljava/lang/Integer;", "1.4", "(Lkotlin/ranges/LongRange;)Ljava/lang/Long;", "(Lkotlin/ranges/CharRange;)Ljava/lang/Character;", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)Ljava/lang/Long;", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)Ljava/lang/Character;", "contains", _UrlKt.FRAGMENT_ENCODE_SET, "element", "(Lkotlin/ranges/IntRange;Ljava/lang/Integer;)Z", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;)Z", "(Lkotlin/ranges/CharRange;Ljava/lang/Character;)Z", "Lni/shikatu/kotlin/ranges/ClosedRange;", "value", _UrlKt.FRAGMENT_ENCODE_SET, "intRangeContains", "Lni/shikatu/kotlin/jvm/JvmName;", "name", "longRangeContains", _UrlKt.FRAGMENT_ENCODE_SET, "shortRangeContains", _UrlKt.FRAGMENT_ENCODE_SET, "doubleRangeContains", "Lni/shikatu/kotlin/Deprecated;", "message", "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.", "Lni/shikatu/kotlin/DeprecatedSinceKotlin;", "warningSince", "errorSince", "hiddenSince", "1.5", _UrlKt.FRAGMENT_ENCODE_SET, "floatRangeContains", "Lni/shikatu/kotlin/ranges/OpenEndRange;", "1.9", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/ExperimentalStdlibApi;", "byteRangeContains", "downTo", "to", "reversed", "step", "toByteExactOrNull", "(I)Ljava/lang/Byte;", "(J)Ljava/lang/Byte;", "(S)Ljava/lang/Byte;", "(D)Ljava/lang/Byte;", "(F)Ljava/lang/Byte;", "toIntExactOrNull", "(J)Ljava/lang/Integer;", "(D)Ljava/lang/Integer;", "(F)Ljava/lang/Integer;", "toLongExactOrNull", "(D)Ljava/lang/Long;", "(F)Ljava/lang/Long;", "toShortExactOrNull", "(I)Ljava/lang/Short;", "(J)Ljava/lang/Short;", "(D)Ljava/lang/Short;", "(F)Ljava/lang/Short;", "until", "coerceAtLeast", "T", _UrlKt.FRAGMENT_ENCODE_SET, "minimumValue", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "coerceAtMost", "maximumValue", "coerceIn", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "range", "Lni/shikatu/kotlin/ranges/ClosedFloatingPointRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "1.1", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/ranges/RangesKt")
public class RangesKt___RangesKt extends RangesKt__RangesKt {
    public static final int first(IntProgression $this$first) {
        Intrinsics.checkNotNullParameter($this$first, "<this>");
        if ($this$first.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$first + " is empty.");
        }
        return $this$first.getFirst();
    }

    public static final long first(LongProgression $this$first) {
        Intrinsics.checkNotNullParameter($this$first, "<this>");
        if ($this$first.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$first + " is empty.");
        }
        return $this$first.getFirst();
    }

    public static final char first(CharProgression $this$first) {
        Intrinsics.checkNotNullParameter($this$first, "<this>");
        if ($this$first.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$first + " is empty.");
        }
        return $this$first.getFirst();
    }

    public static final Integer firstOrNull(IntProgression $this$firstOrNull) {
        Intrinsics.checkNotNullParameter($this$firstOrNull, "<this>");
        if ($this$firstOrNull.isEmpty()) {
            return null;
        }
        return Integer.valueOf($this$firstOrNull.getFirst());
    }

    public static final Long firstOrNull(LongProgression $this$firstOrNull) {
        Intrinsics.checkNotNullParameter($this$firstOrNull, "<this>");
        if ($this$firstOrNull.isEmpty()) {
            return null;
        }
        return Long.valueOf($this$firstOrNull.getFirst());
    }

    public static final Character firstOrNull(CharProgression $this$firstOrNull) {
        Intrinsics.checkNotNullParameter($this$firstOrNull, "<this>");
        if ($this$firstOrNull.isEmpty()) {
            return null;
        }
        return Character.valueOf($this$firstOrNull.getFirst());
    }

    public static final int last(IntProgression $this$last) {
        Intrinsics.checkNotNullParameter($this$last, "<this>");
        if ($this$last.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$last + " is empty.");
        }
        return $this$last.getLast();
    }

    public static final long last(LongProgression $this$last) {
        Intrinsics.checkNotNullParameter($this$last, "<this>");
        if ($this$last.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$last + " is empty.");
        }
        return $this$last.getLast();
    }

    public static final char last(CharProgression $this$last) {
        Intrinsics.checkNotNullParameter($this$last, "<this>");
        if ($this$last.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$last + " is empty.");
        }
        return $this$last.getLast();
    }

    public static final Integer lastOrNull(IntProgression $this$lastOrNull) {
        Intrinsics.checkNotNullParameter($this$lastOrNull, "<this>");
        if ($this$lastOrNull.isEmpty()) {
            return null;
        }
        return Integer.valueOf($this$lastOrNull.getLast());
    }

    public static final Long lastOrNull(LongProgression $this$lastOrNull) {
        Intrinsics.checkNotNullParameter($this$lastOrNull, "<this>");
        if ($this$lastOrNull.isEmpty()) {
            return null;
        }
        return Long.valueOf($this$lastOrNull.getLast());
    }

    public static final Character lastOrNull(CharProgression $this$lastOrNull) {
        Intrinsics.checkNotNullParameter($this$lastOrNull, "<this>");
        if ($this$lastOrNull.isEmpty()) {
            return null;
        }
        return Character.valueOf($this$lastOrNull.getLast());
    }

    private static final int random(IntRange $this$random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        return RangesKt.random($this$random, Random.Default);
    }

    private static final long random(LongRange $this$random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        return RangesKt.random($this$random, Random.Default);
    }

    private static final char random(CharRange $this$random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        return RangesKt.random($this$random, Random.Default);
    }

    public static final int random(IntRange $this$random, Random random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return RandomKt.nextInt(random, $this$random);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final long random(LongRange $this$random, Random random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return RandomKt.nextLong(random, $this$random);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final char random(CharRange $this$random, Random random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return (char) random.nextInt($this$random.getFirst(), $this$random.getLast() + 1);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    private static final Integer randomOrNull(IntRange $this$randomOrNull) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        return RangesKt.randomOrNull($this$randomOrNull, Random.Default);
    }

    private static final Long randomOrNull(LongRange $this$randomOrNull) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        return RangesKt.randomOrNull($this$randomOrNull, Random.Default);
    }

    private static final Character randomOrNull(CharRange $this$randomOrNull) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        return RangesKt.randomOrNull($this$randomOrNull, Random.Default);
    }

    public static final Integer randomOrNull(IntRange $this$randomOrNull, Random random) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if ($this$randomOrNull.isEmpty()) {
            return null;
        }
        return Integer.valueOf(RandomKt.nextInt(random, $this$randomOrNull));
    }

    public static final Long randomOrNull(LongRange $this$randomOrNull, Random random) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if ($this$randomOrNull.isEmpty()) {
            return null;
        }
        return Long.valueOf(RandomKt.nextLong(random, $this$randomOrNull));
    }

    public static final Character randomOrNull(CharRange $this$randomOrNull, Random random) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if ($this$randomOrNull.isEmpty()) {
            return null;
        }
        return Character.valueOf((char) random.nextInt($this$randomOrNull.getFirst(), $this$randomOrNull.getLast() + 1));
    }

    private static final boolean contains(IntRange $this$contains, Integer element) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return element != null && $this$contains.contains(element.intValue());
    }

    private static final boolean contains(LongRange $this$contains, Long element) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return element != null && $this$contains.contains(element.longValue());
    }

    private static final boolean contains(CharRange $this$contains, Character element) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return element != null && $this$contains.contains(element.charValue());
    }

    public static final boolean intRangeContains(ClosedRange<Integer> closedRange, byte value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Integer.valueOf(value));
    }

    public static final boolean longRangeContains(ClosedRange<Long> closedRange, byte value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Long.valueOf(value));
    }

    public static final boolean shortRangeContains(ClosedRange<Short> closedRange, byte value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Short.valueOf(value));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final  boolean doubleRangeContains(ClosedRange $this$contains, byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains(Double.valueOf(value));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final  boolean floatRangeContains(ClosedRange $this$contains, byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains(Float.valueOf(value));
    }

    public static final boolean intRangeContains(OpenEndRange<Integer> openEndRange, byte value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Integer.valueOf(value));
    }

    public static final boolean longRangeContains(OpenEndRange<Long> openEndRange, byte value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Long.valueOf(value));
    }

    public static final boolean shortRangeContains(OpenEndRange<Short> openEndRange, byte value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Short.valueOf(value));
    }

    private static final boolean contains(IntRange $this$contains, byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return RangesKt.intRangeContains((ClosedRange<Integer>) $this$contains, value);
    }

    private static final boolean contains(LongRange $this$contains, byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return RangesKt.longRangeContains((ClosedRange<Long>) $this$contains, value);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final  boolean intRangeContains(ClosedRange $this$contains, double value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Integer it = RangesKt.toIntExactOrNull(value);
        if (it != null) {
            return $this$contains.contains(it);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final  boolean longRangeContains(ClosedRange $this$contains, double value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Long it = RangesKt.toLongExactOrNull(value);
        if (it != null) {
            return $this$contains.contains(it);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final  boolean byteRangeContains(ClosedRange $this$contains, double value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Byte it = RangesKt.toByteExactOrNull(value);
        if (it != null) {
            return $this$contains.contains(it);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final  boolean shortRangeContains(ClosedRange $this$contains, double value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Short it = RangesKt.toShortExactOrNull(value);
        if (it != null) {
            return $this$contains.contains(it);
        }
        return false;
    }

    public static final boolean floatRangeContains(ClosedRange<Float> closedRange, double value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Float.valueOf((float) value));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final  boolean intRangeContains(ClosedRange $this$contains, float value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Integer it = RangesKt.toIntExactOrNull(value);
        if (it != null) {
            return $this$contains.contains(it);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final  boolean longRangeContains(ClosedRange $this$contains, float value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Long it = RangesKt.toLongExactOrNull(value);
        if (it != null) {
            return $this$contains.contains(it);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final  boolean byteRangeContains(ClosedRange $this$contains, float value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Byte it = RangesKt.toByteExactOrNull(value);
        if (it != null) {
            return $this$contains.contains(it);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final  boolean shortRangeContains(ClosedRange $this$contains, float value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Short it = RangesKt.toShortExactOrNull(value);
        if (it != null) {
            return $this$contains.contains(it);
        }
        return false;
    }

    public static final boolean doubleRangeContains(ClosedRange<Double> closedRange, float value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Double.valueOf(value));
    }

    public static final boolean doubleRangeContains(OpenEndRange<Double> openEndRange, float value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Double.valueOf(value));
    }

    public static final boolean longRangeContains(ClosedRange<Long> closedRange, int value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Long.valueOf(value));
    }

    public static final boolean byteRangeContains(ClosedRange<Byte> closedRange, int value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Byte it = RangesKt.toByteExactOrNull(value);
        if (it != null) {
            return closedRange.contains(it);
        }
        return false;
    }

    public static final boolean shortRangeContains(ClosedRange<Short> closedRange, int value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Short it = RangesKt.toShortExactOrNull(value);
        if (it != null) {
            return closedRange.contains(it);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final  boolean doubleRangeContains(ClosedRange $this$contains, int value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains(Double.valueOf(value));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final  boolean floatRangeContains(ClosedRange $this$contains, int value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains(Float.valueOf(value));
    }

    public static final boolean longRangeContains(OpenEndRange<Long> openEndRange, int value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Long.valueOf(value));
    }

    public static final boolean byteRangeContains(OpenEndRange<Byte> openEndRange, int value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Byte it = RangesKt.toByteExactOrNull(value);
        if (it != null) {
            return openEndRange.contains(it);
        }
        return false;
    }

    public static final boolean shortRangeContains(OpenEndRange<Short> openEndRange, int value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Short it = RangesKt.toShortExactOrNull(value);
        if (it != null) {
            return openEndRange.contains(it);
        }
        return false;
    }

    private static final boolean contains(LongRange $this$contains, int value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return RangesKt.longRangeContains((ClosedRange<Long>) $this$contains, value);
    }

    public static final boolean intRangeContains(ClosedRange<Integer> closedRange, long value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Integer it = RangesKt.toIntExactOrNull(value);
        if (it != null) {
            return closedRange.contains(it);
        }
        return false;
    }

    public static final boolean byteRangeContains(ClosedRange<Byte> closedRange, long value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Byte it = RangesKt.toByteExactOrNull(value);
        if (it != null) {
            return closedRange.contains(it);
        }
        return false;
    }

    public static final boolean shortRangeContains(ClosedRange<Short> closedRange, long value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Short it = RangesKt.toShortExactOrNull(value);
        if (it != null) {
            return closedRange.contains(it);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final  boolean doubleRangeContains(ClosedRange $this$contains, long value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains(Double.valueOf(value));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final  boolean floatRangeContains(ClosedRange $this$contains, long value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains(Float.valueOf(value));
    }

    public static final boolean intRangeContains(OpenEndRange<Integer> openEndRange, long value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Integer it = RangesKt.toIntExactOrNull(value);
        if (it != null) {
            return openEndRange.contains(it);
        }
        return false;
    }

    public static final boolean byteRangeContains(OpenEndRange<Byte> openEndRange, long value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Byte it = RangesKt.toByteExactOrNull(value);
        if (it != null) {
            return openEndRange.contains(it);
        }
        return false;
    }

    public static final boolean shortRangeContains(OpenEndRange<Short> openEndRange, long value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Short it = RangesKt.toShortExactOrNull(value);
        if (it != null) {
            return openEndRange.contains(it);
        }
        return false;
    }

    private static final boolean contains(IntRange $this$contains, long value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return RangesKt.intRangeContains((ClosedRange<Integer>) $this$contains, value);
    }

    public static final boolean intRangeContains(ClosedRange<Integer> closedRange, short value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Integer.valueOf(value));
    }

    public static final boolean longRangeContains(ClosedRange<Long> closedRange, short value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Long.valueOf(value));
    }

    public static final boolean byteRangeContains(ClosedRange<Byte> closedRange, short value) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Byte it = RangesKt.toByteExactOrNull(value);
        if (it != null) {
            return closedRange.contains(it);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final  boolean doubleRangeContains(ClosedRange $this$contains, short value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains(Double.valueOf(value));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final  boolean floatRangeContains(ClosedRange $this$contains, short value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains(Float.valueOf(value));
    }

    public static final boolean intRangeContains(OpenEndRange<Integer> openEndRange, short value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Integer.valueOf(value));
    }

    public static final boolean longRangeContains(OpenEndRange<Long> openEndRange, short value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Long.valueOf(value));
    }

    public static final boolean byteRangeContains(OpenEndRange<Byte> openEndRange, short value) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Byte it = RangesKt.toByteExactOrNull(value);
        if (it != null) {
            return openEndRange.contains(it);
        }
        return false;
    }

    private static final boolean contains(IntRange $this$contains, short value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return RangesKt.intRangeContains((ClosedRange<Integer>) $this$contains, value);
    }

    private static final boolean contains(LongRange $this$contains, short value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return RangesKt.longRangeContains((ClosedRange<Long>) $this$contains, value);
    }

    public static final IntProgression downTo(int $this$downTo, byte to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final LongProgression downTo(long $this$downTo, byte to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, to, -1L);
    }

    public static final IntProgression downTo(byte $this$downTo, byte to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final IntProgression downTo(short $this$downTo, byte to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final CharProgression downTo(char $this$downTo, char to) {
        return CharProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final IntProgression downTo(int $this$downTo, int to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final LongProgression downTo(long $this$downTo, int to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, to, -1L);
    }

    public static final IntProgression downTo(byte $this$downTo, int to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final IntProgression downTo(short $this$downTo, int to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final LongProgression downTo(int $this$downTo, long to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, to, -1L);
    }

    public static final LongProgression downTo(long $this$downTo, long to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, to, -1L);
    }

    public static final LongProgression downTo(byte $this$downTo, long to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, to, -1L);
    }

    public static final LongProgression downTo(short $this$downTo, long to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, to, -1L);
    }

    public static final IntProgression downTo(int $this$downTo, short to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final LongProgression downTo(long $this$downTo, short to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, to, -1L);
    }

    public static final IntProgression downTo(byte $this$downTo, short to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final IntProgression downTo(short $this$downTo, short to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final IntProgression reversed(IntProgression $this$reversed) {
        Intrinsics.checkNotNullParameter($this$reversed, "<this>");
        return IntProgression.Companion.fromClosedRange($this$reversed.getLast(), $this$reversed.getFirst(), -$this$reversed.getStep());
    }

    public static final LongProgression reversed(LongProgression $this$reversed) {
        Intrinsics.checkNotNullParameter($this$reversed, "<this>");
        return LongProgression.Companion.fromClosedRange($this$reversed.getLast(), $this$reversed.getFirst(), -$this$reversed.getStep());
    }

    public static final CharProgression reversed(CharProgression $this$reversed) {
        Intrinsics.checkNotNullParameter($this$reversed, "<this>");
        return CharProgression.Companion.fromClosedRange($this$reversed.getLast(), $this$reversed.getFirst(), -$this$reversed.getStep());
    }

    public static final IntProgression step(IntProgression $this$step, int step) {
        Intrinsics.checkNotNullParameter($this$step, "<this>");
        RangesKt.checkStepIsPositive(step > 0, Integer.valueOf(step));
        return IntProgression.Companion.fromClosedRange($this$step.getFirst(), $this$step.getLast(), $this$step.getStep() > 0 ? step : -step);
    }

    public static final LongProgression step(LongProgression $this$step, long step) {
        Intrinsics.checkNotNullParameter($this$step, "<this>");
        RangesKt.checkStepIsPositive(step > 0, Long.valueOf(step));
        return LongProgression.Companion.fromClosedRange($this$step.getFirst(), $this$step.getLast(), $this$step.getStep() > 0 ? step : -step);
    }

    public static final CharProgression step(CharProgression $this$step, int step) {
        Intrinsics.checkNotNullParameter($this$step, "<this>");
        RangesKt.checkStepIsPositive(step > 0, Integer.valueOf(step));
        return CharProgression.Companion.fromClosedRange($this$step.getFirst(), $this$step.getLast(), $this$step.getStep() > 0 ? step : -step);
    }

    public static final Byte toByteExactOrNull(int $this$toByteExactOrNull) {
        boolean z = false;
        if (-128 <= $this$toByteExactOrNull && $this$toByteExactOrNull < 128) {
            z = true;
        }
        if (z) {
            return Byte.valueOf((byte) $this$toByteExactOrNull);
        }
        return null;
    }

    public static final Byte toByteExactOrNull(long $this$toByteExactOrNull) {
        boolean z = false;
        if (-128 <= $this$toByteExactOrNull && $this$toByteExactOrNull < 128) {
            z = true;
        }
        if (z) {
            return Byte.valueOf((byte) $this$toByteExactOrNull);
        }
        return null;
    }

    public static final Byte toByteExactOrNull(short $this$toByteExactOrNull) {
        boolean z = false;
        if (-128 <= $this$toByteExactOrNull && $this$toByteExactOrNull < 128) {
            z = true;
        }
        if (z) {
            return Byte.valueOf((byte) $this$toByteExactOrNull);
        }
        return null;
    }

    public static final Byte toByteExactOrNull(double $this$toByteExactOrNull) {
        boolean z = false;
        if (-128.0d <= $this$toByteExactOrNull && $this$toByteExactOrNull <= 127.0d) {
            z = true;
        }
        if (z) {
            return Byte.valueOf((byte) $this$toByteExactOrNull);
        }
        return null;
    }

    public static final Byte toByteExactOrNull(float $this$toByteExactOrNull) {
        boolean z = false;
        if (-128.0f <= $this$toByteExactOrNull && $this$toByteExactOrNull <= 127.0f) {
            z = true;
        }
        if (z) {
            return Byte.valueOf((byte) $this$toByteExactOrNull);
        }
        return null;
    }

    public static final Integer toIntExactOrNull(long $this$toIntExactOrNull) {
        boolean z = false;
        if (-2147483648L <= $this$toIntExactOrNull && $this$toIntExactOrNull < 2147483648L) {
            z = true;
        }
        if (z) {
            return Integer.valueOf((int) $this$toIntExactOrNull);
        }
        return null;
    }

    public static final Integer toIntExactOrNull(double $this$toIntExactOrNull) {
        boolean z = false;
        if (-2.147483648E9d <= $this$toIntExactOrNull && $this$toIntExactOrNull <= 2.147483647E9d) {
            z = true;
        }
        if (z) {
            return Integer.valueOf((int) $this$toIntExactOrNull);
        }
        return null;
    }

    public static final Integer toIntExactOrNull(float $this$toIntExactOrNull) {
        boolean z = false;
        if (-2.1474836E9f <= $this$toIntExactOrNull && $this$toIntExactOrNull <= 2.1474836E9f) {
            z = true;
        }
        if (z) {
            return Integer.valueOf((int) $this$toIntExactOrNull);
        }
        return null;
    }

    public static final Long toLongExactOrNull(double $this$toLongExactOrNull) {
        boolean z = false;
        if (-9.223372036854776E18d <= $this$toLongExactOrNull && $this$toLongExactOrNull <= 9.223372036854776E18d) {
            z = true;
        }
        if (z) {
            return Long.valueOf((long) $this$toLongExactOrNull);
        }
        return null;
    }

    public static final Long toLongExactOrNull(float $this$toLongExactOrNull) {
        boolean z = false;
        if (-9.223372E18f <= $this$toLongExactOrNull && $this$toLongExactOrNull <= 9.223372E18f) {
            z = true;
        }
        if (z) {
            return Long.valueOf((long) $this$toLongExactOrNull);
        }
        return null;
    }

    public static final Short toShortExactOrNull(int $this$toShortExactOrNull) {
        boolean z = false;
        if (-32768 <= $this$toShortExactOrNull && $this$toShortExactOrNull < 32768) {
            z = true;
        }
        if (z) {
            return Short.valueOf((short) $this$toShortExactOrNull);
        }
        return null;
    }

    public static final Short toShortExactOrNull(long $this$toShortExactOrNull) {
        boolean z = false;
        if (-32768 <= $this$toShortExactOrNull && $this$toShortExactOrNull < 32768) {
            z = true;
        }
        if (z) {
            return Short.valueOf((short) $this$toShortExactOrNull);
        }
        return null;
    }

    public static final Short toShortExactOrNull(double $this$toShortExactOrNull) {
        boolean z = false;
        if (-32768.0d <= $this$toShortExactOrNull && $this$toShortExactOrNull <= 32767.0d) {
            z = true;
        }
        if (z) {
            return Short.valueOf((short) $this$toShortExactOrNull);
        }
        return null;
    }

    public static final Short toShortExactOrNull(float $this$toShortExactOrNull) {
        boolean z = false;
        if (-32768.0f <= $this$toShortExactOrNull && $this$toShortExactOrNull <= 32767.0f) {
            z = true;
        }
        if (z) {
            return Short.valueOf((short) $this$toShortExactOrNull);
        }
        return null;
    }

    public static final IntRange until(int $this$until, byte to) {
        return new IntRange($this$until, to - 1);
    }

    public static final LongRange until(long $this$until, byte to) {
        return new LongRange($this$until, ((long) to) - 1);
    }

    public static final IntRange until(byte $this$until, byte to) {
        return new IntRange($this$until, to - 1);
    }

    public static final IntRange until(short $this$until, byte to) {
        return new IntRange($this$until, to - 1);
    }

    public static final CharRange until(char $this$until, char to) {
        return to <= 0 ? CharRange.Companion.getEMPTY() : new CharRange($this$until, (char) (to - 1));
    }

    public static final IntRange until(int $this$until, int to) {
        return to <= Integer.MIN_VALUE ? IntRange.Companion.getEMPTY() : new IntRange($this$until, to - 1);
    }

    public static final LongRange until(long $this$until, int to) {
        return new LongRange($this$until, ((long) to) - 1);
    }

    public static final IntRange until(byte $this$until, int to) {
        return to <= Integer.MIN_VALUE ? IntRange.Companion.getEMPTY() : new IntRange($this$until, to - 1);
    }

    public static final IntRange until(short $this$until, int to) {
        return to <= Integer.MIN_VALUE ? IntRange.Companion.getEMPTY() : new IntRange($this$until, to - 1);
    }

    public static final LongRange until(int $this$until, long to) {
        return to <= Long.MIN_VALUE ? LongRange.Companion.getEMPTY() : new LongRange($this$until, to - 1);
    }

    public static final LongRange until(long $this$until, long to) {
        return to <= Long.MIN_VALUE ? LongRange.Companion.getEMPTY() : new LongRange($this$until, to - 1);
    }

    public static final LongRange until(byte $this$until, long to) {
        return to <= Long.MIN_VALUE ? LongRange.Companion.getEMPTY() : new LongRange($this$until, to - 1);
    }

    public static final LongRange until(short $this$until, long to) {
        return to <= Long.MIN_VALUE ? LongRange.Companion.getEMPTY() : new LongRange($this$until, to - 1);
    }

    public static final IntRange until(int $this$until, short to) {
        return new IntRange($this$until, to - 1);
    }

    public static final LongRange until(long $this$until, short to) {
        return new LongRange($this$until, ((long) to) - 1);
    }

    public static final IntRange until(byte $this$until, short to) {
        return new IntRange($this$until, to - 1);
    }

    public static final IntRange until(short $this$until, short to) {
        return new IntRange($this$until, to - 1);
    }

    public static final <T extends Comparable<? super T>> T coerceAtLeast(T t, T t2) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(t2, "minimumValue");
        return t.compareTo(t2) < 0 ? t2 : t;
    }

    public static final byte coerceAtLeast(byte $this$coerceAtLeast, byte minimumValue) {
        return $this$coerceAtLeast < minimumValue ? minimumValue : $this$coerceAtLeast;
    }

    public static final short coerceAtLeast(short $this$coerceAtLeast, short minimumValue) {
        return $this$coerceAtLeast < minimumValue ? minimumValue : $this$coerceAtLeast;
    }

    public static final int coerceAtLeast(int $this$coerceAtLeast, int minimumValue) {
        return $this$coerceAtLeast < minimumValue ? minimumValue : $this$coerceAtLeast;
    }

    public static final long coerceAtLeast(long $this$coerceAtLeast, long minimumValue) {
        return $this$coerceAtLeast < minimumValue ? minimumValue : $this$coerceAtLeast;
    }

    public static final float coerceAtLeast(float $this$coerceAtLeast, float minimumValue) {
        return $this$coerceAtLeast < minimumValue ? minimumValue : $this$coerceAtLeast;
    }

    public static final double coerceAtLeast(double $this$coerceAtLeast, double minimumValue) {
        return $this$coerceAtLeast < minimumValue ? minimumValue : $this$coerceAtLeast;
    }

    public static final <T extends Comparable<? super T>> T coerceAtMost(T t, T t2) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(t2, "maximumValue");
        return t.compareTo(t2) > 0 ? t2 : t;
    }

    public static final byte coerceAtMost(byte $this$coerceAtMost, byte maximumValue) {
        return $this$coerceAtMost > maximumValue ? maximumValue : $this$coerceAtMost;
    }

    public static final short coerceAtMost(short $this$coerceAtMost, short maximumValue) {
        return $this$coerceAtMost > maximumValue ? maximumValue : $this$coerceAtMost;
    }

    public static final int coerceAtMost(int $this$coerceAtMost, int maximumValue) {
        return $this$coerceAtMost > maximumValue ? maximumValue : $this$coerceAtMost;
    }

    public static final long coerceAtMost(long $this$coerceAtMost, long maximumValue) {
        return $this$coerceAtMost > maximumValue ? maximumValue : $this$coerceAtMost;
    }

    public static final float coerceAtMost(float $this$coerceAtMost, float maximumValue) {
        return $this$coerceAtMost > maximumValue ? maximumValue : $this$coerceAtMost;
    }

    public static final double coerceAtMost(double $this$coerceAtMost, double maximumValue) {
        return $this$coerceAtMost > maximumValue ? maximumValue : $this$coerceAtMost;
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T t, T t2, T t3) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        if (t2 != null && t3 != null) {
            if (t2.compareTo(t3) > 0) {
                throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + t3 + " is less than minimum " + t2 + '.');
            }
            if (t.compareTo(t2) < 0) {
                return t2;
            }
            if (t.compareTo(t3) > 0) {
                return t3;
            }
        } else {
            if (t2 != null && t.compareTo(t2) < 0) {
                return t2;
            }
            if (t3 != null && t.compareTo(t3) > 0) {
                return t3;
            }
        }
        return t;
    }

    public static final byte coerceIn(byte $this$coerceIn, byte minimumValue, byte maximumValue) {
        if (minimumValue > maximumValue) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) maximumValue) + " is less than minimum " + ((int) minimumValue) + '.');
        }
        if ($this$coerceIn < minimumValue) {
            return minimumValue;
        }
        return $this$coerceIn > maximumValue ? maximumValue : $this$coerceIn;
    }

    public static final short coerceIn(short $this$coerceIn, short minimumValue, short maximumValue) {
        if (minimumValue > maximumValue) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) maximumValue) + " is less than minimum " + ((int) minimumValue) + '.');
        }
        if ($this$coerceIn < minimumValue) {
            return minimumValue;
        }
        return $this$coerceIn > maximumValue ? maximumValue : $this$coerceIn;
    }

    public static final int coerceIn(int $this$coerceIn, int minimumValue, int maximumValue) {
        if (minimumValue > maximumValue) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + maximumValue + " is less than minimum " + minimumValue + '.');
        }
        if ($this$coerceIn < minimumValue) {
            return minimumValue;
        }
        return $this$coerceIn > maximumValue ? maximumValue : $this$coerceIn;
    }

    public static final long coerceIn(long $this$coerceIn, long minimumValue, long maximumValue) {
        if (minimumValue > maximumValue) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + maximumValue + " is less than minimum " + minimumValue + '.');
        }
        if ($this$coerceIn < minimumValue) {
            return minimumValue;
        }
        return $this$coerceIn > maximumValue ? maximumValue : $this$coerceIn;
    }

    public static final float coerceIn(float $this$coerceIn, float minimumValue, float maximumValue) {
        if (minimumValue > maximumValue) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + maximumValue + " is less than minimum " + minimumValue + '.');
        }
        if ($this$coerceIn < minimumValue) {
            return minimumValue;
        }
        return $this$coerceIn > maximumValue ? maximumValue : $this$coerceIn;
    }

    public static final double coerceIn(double $this$coerceIn, double minimumValue, double maximumValue) {
        if (minimumValue > maximumValue) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + maximumValue + " is less than minimum " + minimumValue + '.');
        }
        if ($this$coerceIn < minimumValue) {
            return minimumValue;
        }
        return $this$coerceIn > maximumValue ? maximumValue : $this$coerceIn;
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T t, ClosedFloatingPointRange<T> closedFloatingPointRange) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(closedFloatingPointRange, "range");
        if (closedFloatingPointRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedFloatingPointRange + '.');
        }
        if (!closedFloatingPointRange.lessThanOrEquals(t, closedFloatingPointRange.getStart()) || closedFloatingPointRange.lessThanOrEquals(closedFloatingPointRange.getStart(), t)) {
            return (!closedFloatingPointRange.lessThanOrEquals(closedFloatingPointRange.getEndInclusive(), t) || closedFloatingPointRange.lessThanOrEquals(t, closedFloatingPointRange.getEndInclusive())) ? t : closedFloatingPointRange.getEndInclusive();
        }
        return closedFloatingPointRange.getStart();
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T t, ClosedRange<T> closedRange) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(closedRange, "range");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return (T) RangesKt.coerceIn((Comparable) t, (ClosedFloatingPointRange) closedRange);
        }
        if (closedRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + '.');
        }
        if (t.compareTo(closedRange.getStart()) < 0) {
            return (T) closedRange.getStart();
        }
        return t.compareTo(closedRange.getEndInclusive()) > 0 ? (T) closedRange.getEndInclusive() : t;
    }

    public static final int coerceIn(int $this$coerceIn, ClosedRange<Integer> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, "range");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((Number) RangesKt.coerceIn(Integer.valueOf($this$coerceIn), (ClosedFloatingPointRange<Integer>) closedRange)).intValue();
        }
        if (closedRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + '.');
        }
        if ($this$coerceIn < ((Number) closedRange.getStart()).intValue()) {
            return ((Number) closedRange.getStart()).intValue();
        }
        return $this$coerceIn > ((Number) closedRange.getEndInclusive()).intValue() ? ((Number) closedRange.getEndInclusive()).intValue() : $this$coerceIn;
    }

    public static final long coerceIn(long $this$coerceIn, ClosedRange<Long> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, "range");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((Number) RangesKt.coerceIn(Long.valueOf($this$coerceIn), (ClosedFloatingPointRange<Long>) closedRange)).longValue();
        }
        if (closedRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + '.');
        }
        if ($this$coerceIn < ((Number) closedRange.getStart()).longValue()) {
            return ((Number) closedRange.getStart()).longValue();
        }
        return $this$coerceIn > ((Number) closedRange.getEndInclusive()).longValue() ? ((Number) closedRange.getEndInclusive()).longValue() : $this$coerceIn;
    }
}
