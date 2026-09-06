package ni.shikatu.kotlin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008a\u0004b\u0002\b\u0003\u001a\u001a\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008a\u0004b\u0002\b\u0003\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008a\u0004b\u0002\b\u0003\u001a\u001a\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008a\u0004b\u0002\b\u0003\u001a\u001a\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008a\u0004b\u0002\b\u0003\u001a\u0012\u0010\b\u001a\u00020\u0001*\u00020\u0001H\u0087\u008a\u0004b\u0002\b\u0003\u001a \u0010\t\u001a\u00020\u0001*\u00020\u0001H\u0087\u008a\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0003\u001a \u0010\r\u001a\u00020\u0001*\u00020\u0001H\u0087\u008a\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0003\u001a \u0010\u000e\u001a\u00020\u0001*\u00020\u000fH\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0003\u001a(\u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0003\u001a \u0010\u000e\u001a\u00020\u0001*\u00020\u0012H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0003\u001a(\u0010\u000e\u001a\u00020\u0001*\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0011H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0003\u001a \u0010\u000e\u001a\u00020\u0001*\u00020\u0013H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0003\u001a(\u0010\u000e\u001a\u00020\u0001*\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0003\u001a \u0010\u000e\u001a\u00020\u0001*\u00020\u0014H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0003\u001a(\u0010\u000e\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0003¨\u0006\u0015"}, d2 = {"plus", "Ljava/math/BigDecimal;", "other", "Lni/shikatu/kotlin/internal/InlineOnly;", "minus", "times", "div", "rem", "unaryMinus", "inc", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.2", "dec", "toBigDecimal", _UrlKt.FRAGMENT_ENCODE_SET, "mathContext", "Ljava/math/MathContext;", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/NumbersKt")
class NumbersKt__BigDecimalsKt {
    private static final BigDecimal plus(BigDecimal $this$plus, BigDecimal other) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigDecimal bigDecimalAdd = $this$plus.add(other);
        Intrinsics.checkNotNullExpressionValue(bigDecimalAdd, "add(...)");
        return bigDecimalAdd;
    }

    private static final BigDecimal minus(BigDecimal $this$minus, BigDecimal other) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigDecimal bigDecimalSubtract = $this$minus.subtract(other);
        Intrinsics.checkNotNullExpressionValue(bigDecimalSubtract, "subtract(...)");
        return bigDecimalSubtract;
    }

    private static final BigDecimal times(BigDecimal $this$times, BigDecimal other) {
        Intrinsics.checkNotNullParameter($this$times, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigDecimal bigDecimalMultiply = $this$times.multiply(other);
        Intrinsics.checkNotNullExpressionValue(bigDecimalMultiply, "multiply(...)");
        return bigDecimalMultiply;
    }

    private static final BigDecimal div(BigDecimal $this$div, BigDecimal other) {
        Intrinsics.checkNotNullParameter($this$div, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigDecimal bigDecimalDivide = $this$div.divide(other, RoundingMode.HALF_EVEN);
        Intrinsics.checkNotNullExpressionValue(bigDecimalDivide, "divide(...)");
        return bigDecimalDivide;
    }

    private static final BigDecimal rem(BigDecimal $this$rem, BigDecimal other) {
        Intrinsics.checkNotNullParameter($this$rem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigDecimal bigDecimalRemainder = $this$rem.remainder(other);
        Intrinsics.checkNotNullExpressionValue(bigDecimalRemainder, "remainder(...)");
        return bigDecimalRemainder;
    }

    private static final BigDecimal unaryMinus(BigDecimal $this$unaryMinus) {
        Intrinsics.checkNotNullParameter($this$unaryMinus, "<this>");
        BigDecimal bigDecimalNegate = $this$unaryMinus.negate();
        Intrinsics.checkNotNullExpressionValue(bigDecimalNegate, "negate(...)");
        return bigDecimalNegate;
    }

    private static final BigDecimal inc(BigDecimal $this$inc) {
        Intrinsics.checkNotNullParameter($this$inc, "<this>");
        BigDecimal bigDecimalAdd = $this$inc.add(BigDecimal.ONE);
        Intrinsics.checkNotNullExpressionValue(bigDecimalAdd, "add(...)");
        return bigDecimalAdd;
    }

    private static final BigDecimal dec(BigDecimal $this$dec) {
        Intrinsics.checkNotNullParameter($this$dec, "<this>");
        BigDecimal bigDecimalSubtract = $this$dec.subtract(BigDecimal.ONE);
        Intrinsics.checkNotNullExpressionValue(bigDecimalSubtract, "subtract(...)");
        return bigDecimalSubtract;
    }

    private static final BigDecimal toBigDecimal(int $this$toBigDecimal) {
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf($this$toBigDecimal);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        return bigDecimalValueOf;
    }

    private static final BigDecimal toBigDecimal(int $this$toBigDecimal, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal($this$toBigDecimal, mathContext);
    }

    private static final BigDecimal toBigDecimal(long $this$toBigDecimal) {
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf($this$toBigDecimal);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        return bigDecimalValueOf;
    }

    private static final BigDecimal toBigDecimal(long $this$toBigDecimal, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal($this$toBigDecimal, mathContext);
    }

    private static final BigDecimal toBigDecimal(float $this$toBigDecimal) {
        return new BigDecimal(String.valueOf($this$toBigDecimal));
    }

    private static final BigDecimal toBigDecimal(float $this$toBigDecimal, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(String.valueOf($this$toBigDecimal), mathContext);
    }

    private static final BigDecimal toBigDecimal(double $this$toBigDecimal) {
        return new BigDecimal(String.valueOf($this$toBigDecimal));
    }

    private static final BigDecimal toBigDecimal(double $this$toBigDecimal, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(String.valueOf($this$toBigDecimal), mathContext);
    }
}
