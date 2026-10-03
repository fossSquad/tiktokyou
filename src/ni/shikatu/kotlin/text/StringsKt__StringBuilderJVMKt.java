package ni.shikatu.kotlin.text;

import java.io.IOException;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecatedSinceKotlin;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\u001a4\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\bb\u0002\b\t\u001a4\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\nH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\bb\u0002\b\t\u001a<\u0010\u000b\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\bb\u0002\b\t\u001a<\u0010\u000b\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\nH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\bb\u0002\b\t\u001a(\u0010\u000e\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0087\u0080\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000fb\u0002\b\t\u001a&\u0010\u0010\u001a\u00020\u0011*\u00060\u0001j\u0002`\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0012H\u0087\u008a\u0004b\u0002\b\b\u001aD\u0010\u0013\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0016H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a4\u0010\u0018\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\f\u001a\u00020\rH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a<\u0010\u0019\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001aJ\u0010\u001a\u001a\u00020\u0011*\u00060\u0001j\u0002`\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\rH\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\b\u001aD\u0010\u001e\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001aD\u0010\u001e\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001aL\u0010 \u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001aL\u0010 \u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a6\u0010!\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\"H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a<\u0010!\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u000e\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a4\u0010!\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\rH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a4\u0010!\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\nH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a4\u0010!\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a4\u0010!\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020#H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a4\u0010!\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020$H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a4\u0010!\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020%H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001aZ\u0010&\u001a\u00060'j\u0002`(*\u00060'j\u0002`(H\u0087\u0080\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4\u001ah\u0010&\u001a\u00060'j\u0002`(*\u00060'j\u0002`(2\b\u0010\u0003\u001a\u0004\u0018\u00010\u001fH\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060'j\u0002`(*\u00060'j\u0002`(2\u0006\u0010\u0003\u001a\u00020\u0012H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001aZ\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0087\u0080\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4\u001ah\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\"H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001ah\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u001fH\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001ah\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0016H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001ah\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u000106H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001an\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u000e\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u001cH\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0012H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u000207H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\rH\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\nH\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020#H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020$H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020%H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b¨\u00068"}, d2 = {"append", "Ljava/lang/StringBuilder;", "Lni/shikatu/kotlin/text/StringBuilder;", "value", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.9", "Lni/shikatu/kotlin/internal/InlineOnly;", "Lni/shikatu/kotlin/IgnorableReturnValue;", _UrlKt.FRAGMENT_ENCODE_SET, "insert", "index", _UrlKt.FRAGMENT_ENCODE_SET, "clear", "1.3", "set", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "setRange", "startIndex", "endIndex", _UrlKt.FRAGMENT_ENCODE_SET, "1.4", "deleteAt", "deleteRange", "toCharArray", "destination", _UrlKt.FRAGMENT_ENCODE_SET, "destinationOffset", "appendRange", _UrlKt.FRAGMENT_ENCODE_SET, "insertRange", "appendLine", "Ljava/lang/StringBuffer;", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "appendln", "Ljava/lang/Appendable;", "Lni/shikatu/kotlin/text/Appendable;", "Lni/shikatu/kotlin/Deprecated;", "message", "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", "replaceWith", "Lni/shikatu/kotlin/ReplaceWith;", "expression", "appendLine()", "imports", "Lni/shikatu/kotlin/DeprecatedSinceKotlin;", "warningSince", "errorSince", "2.1", "appendLine(value)", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/text/StringsKt")
class StringsKt__StringBuilderJVMKt extends StringsKt__RegexExtensionsKt {
    @IgnorableReturnValue
    private static final StringBuilder append(StringBuilder $this$append, byte value) {
        Intrinsics.checkNotNullParameter($this$append, "<this>");
        StringBuilder sbAppend = $this$append.append((int) value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend;
    }

    @IgnorableReturnValue
    private static final StringBuilder append(StringBuilder $this$append, short value) {
        Intrinsics.checkNotNullParameter($this$append, "<this>");
        StringBuilder sbAppend = $this$append.append((int) value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend;
    }

    @IgnorableReturnValue
    private static final StringBuilder insert(StringBuilder $this$insert, int index, byte value) {
        Intrinsics.checkNotNullParameter($this$insert, "<this>");
        StringBuilder sbInsert = $this$insert.insert(index, (int) value);
        Intrinsics.checkNotNullExpressionValue(sbInsert, "insert(...)");
        return sbInsert;
    }

    @IgnorableReturnValue
    private static final StringBuilder insert(StringBuilder $this$insert, int index, short value) {
        Intrinsics.checkNotNullParameter($this$insert, "<this>");
        StringBuilder sbInsert = $this$insert.insert(index, (int) value);
        Intrinsics.checkNotNullExpressionValue(sbInsert, "insert(...)");
        return sbInsert;
    }

    @IgnorableReturnValue
    public static final StringBuilder clear(StringBuilder $this$clear) {
        Intrinsics.checkNotNullParameter($this$clear, "<this>");
        $this$clear.setLength(0);
        return $this$clear;
    }

    private static final void set(StringBuilder $this$set, int index, char value) {
        Intrinsics.checkNotNullParameter($this$set, "<this>");
        $this$set.setCharAt(index, value);
    }

    @IgnorableReturnValue
    private static final StringBuilder setRange(StringBuilder $this$setRange, int startIndex, int endIndex, String value) {
        Intrinsics.checkNotNullParameter($this$setRange, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder sbReplace = $this$setRange.replace(startIndex, endIndex, value);
        Intrinsics.checkNotNullExpressionValue(sbReplace, "replace(...)");
        return sbReplace;
    }

    @IgnorableReturnValue
    private static final StringBuilder deleteAt(StringBuilder $this$deleteAt, int index) {
        Intrinsics.checkNotNullParameter($this$deleteAt, "<this>");
        StringBuilder sbDeleteCharAt = $this$deleteAt.deleteCharAt(index);
        Intrinsics.checkNotNullExpressionValue(sbDeleteCharAt, "deleteCharAt(...)");
        return sbDeleteCharAt;
    }

    @IgnorableReturnValue
    private static final StringBuilder deleteRange(StringBuilder $this$deleteRange, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$deleteRange, "<this>");
        StringBuilder sbDelete = $this$deleteRange.delete(startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(sbDelete, "delete(...)");
        return sbDelete;
    }

    static  void toCharArray$default(StringBuilder $this$toCharArray_u24default, char[] destination, int destinationOffset, int startIndex, int endIndex, int i, Object obj) {
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
    }

    private static final void toCharArray(StringBuilder $this$toCharArray, char[] destination, int destinationOffset, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$toCharArray, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        $this$toCharArray.getChars(startIndex, endIndex, destination, destinationOffset);
    }

    @IgnorableReturnValue
    private static final StringBuilder appendRange(StringBuilder $this$appendRange, char[] value, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$appendRange, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder sbAppend = $this$appendRange.append(value, startIndex, endIndex - startIndex);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend;
    }

    @IgnorableReturnValue
    private static final StringBuilder appendRange(StringBuilder $this$appendRange, CharSequence value, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$appendRange, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder sbAppend = $this$appendRange.append(value, startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend;
    }

    @IgnorableReturnValue
    private static final StringBuilder insertRange(StringBuilder $this$insertRange, int index, char[] value, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$insertRange, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder sbInsert = $this$insertRange.insert(index, value, startIndex, endIndex - startIndex);
        Intrinsics.checkNotNullExpressionValue(sbInsert, "insert(...)");
        return sbInsert;
    }

    @IgnorableReturnValue
    private static final StringBuilder insertRange(StringBuilder $this$insertRange, int index, CharSequence value, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$insertRange, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder sbInsert = $this$insertRange.insert(index, value, startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(sbInsert, "insert(...)");
        return sbInsert;
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder $this$appendLine, StringBuffer value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        StringBuilder sbAppend = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend.append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder $this$appendLine, StringBuilder value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        StringBuilder sbAppend = $this$appendLine.append((CharSequence) value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend.append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder $this$appendLine, int value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        StringBuilder sbAppend = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend.append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder $this$appendLine, short value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        StringBuilder sbAppend = $this$appendLine.append((int) value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend.append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder $this$appendLine, byte value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        StringBuilder sbAppend = $this$appendLine.append((int) value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend.append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder $this$appendLine, long value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        StringBuilder sbAppend = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend.append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder $this$appendLine, float value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        StringBuilder sbAppend = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend.append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder $this$appendLine, double value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        StringBuilder sbAppend = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend.append('\n');
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    public static final Appendable appendln(Appendable $this$appendln) throws IOException {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        Appendable appendableAppend = $this$appendln.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(appendableAppend, "append(...)");
        return appendableAppend;
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final Appendable appendln(Appendable $this$appendln, CharSequence value) throws IOException {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        Appendable appendableAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(appendableAppend, "append(...)");
        return StringsKt.appendln(appendableAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final Appendable appendln(Appendable $this$appendln, char value) throws IOException {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        Appendable appendableAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(appendableAppend, "append(...)");
        return StringsKt.appendln(appendableAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    public static final StringBuilder appendln(StringBuilder $this$appendln) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend;
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, StringBuffer value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, CharSequence value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, String value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, Object value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, StringBuilder value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append((CharSequence) value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, char[] value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder sbAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, char value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, boolean value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, int value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, short value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append((int) value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, byte value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append((int) value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, long value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, float value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, double value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }
}
