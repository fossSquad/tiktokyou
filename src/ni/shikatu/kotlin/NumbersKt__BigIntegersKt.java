package ni.shikatu.kotlin;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\u0007\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\r\u0010\b\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\r\u0010\n\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\r\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\f\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\f\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0010H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0013H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u0015*\u00020\u0001H\u0087\b\u001a!\u0010\u0014\u001a\u00020\u0015*\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0087\b¨\u0006\u0019"}, d2 = {"plus", "Ljava/math/BigInteger;", "other", "minus", "times", "div", "rem", "unaryMinus", "inc", "dec", "inv", "and", "or", "xor", "shl", "n", "", "shr", "toBigInteger", "", "toBigDecimal", "Ljava/math/BigDecimal;", "scale", "mathContext", "Ljava/math/MathContext;", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "ni/shikatu/kotlin/NumbersKt")
class NumbersKt__BigIntegersKt extends NumbersKt__BigDecimalsKt {
    private static final BigInteger plus(BigInteger $this$plus, BigInteger other) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger bigIntegerAdd = $this$plus.add(other);
        Intrinsics.checkNotNullExpressionValue(bigIntegerAdd, "add(...)");
        return bigIntegerAdd;
    }

    private static final BigInteger minus(BigInteger $this$minus, BigInteger other) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger bigIntegerSubtract = $this$minus.subtract(other);
        Intrinsics.checkNotNullExpressionValue(bigIntegerSubtract, "subtract(...)");
        return bigIntegerSubtract;
    }

    private static final BigInteger times(BigInteger $this$times, BigInteger other) {
        Intrinsics.checkNotNullParameter($this$times, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger bigIntegerMultiply = $this$times.multiply(other);
        Intrinsics.checkNotNullExpressionValue(bigIntegerMultiply, "multiply(...)");
        return bigIntegerMultiply;
    }

    private static final BigInteger div(BigInteger $this$div, BigInteger other) {
        Intrinsics.checkNotNullParameter($this$div, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger bigIntegerDivide = $this$div.divide(other);
        Intrinsics.checkNotNullExpressionValue(bigIntegerDivide, "divide(...)");
        return bigIntegerDivide;
    }

    private static final BigInteger rem(BigInteger $this$rem, BigInteger other) {
        Intrinsics.checkNotNullParameter($this$rem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger bigIntegerRemainder = $this$rem.remainder(other);
        Intrinsics.checkNotNullExpressionValue(bigIntegerRemainder, "remainder(...)");
        return bigIntegerRemainder;
    }

    private static final BigInteger unaryMinus(BigInteger $this$unaryMinus) {
        Intrinsics.checkNotNullParameter($this$unaryMinus, "<this>");
        BigInteger bigIntegerNegate = $this$unaryMinus.negate();
        Intrinsics.checkNotNullExpressionValue(bigIntegerNegate, "negate(...)");
        return bigIntegerNegate;
    }

    private static final BigInteger inc(BigInteger $this$inc) {
        Intrinsics.checkNotNullParameter($this$inc, "<this>");
        BigInteger bigIntegerAdd = $this$inc.add(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(bigIntegerAdd, "add(...)");
        return bigIntegerAdd;
    }

    private static final BigInteger dec(BigInteger $this$dec) {
        Intrinsics.checkNotNullParameter($this$dec, "<this>");
        BigInteger bigIntegerSubtract = $this$dec.subtract(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(bigIntegerSubtract, "subtract(...)");
        return bigIntegerSubtract;
    }

    private static final BigInteger inv(BigInteger $this$inv) {
        Intrinsics.checkNotNullParameter($this$inv, "<this>");
        BigInteger bigIntegerNot = $this$inv.not();
        Intrinsics.checkNotNullExpressionValue(bigIntegerNot, "not(...)");
        return bigIntegerNot;
    }

    private static final BigInteger and(BigInteger $this$and, BigInteger other) {
        Intrinsics.checkNotNullParameter($this$and, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger bigIntegerAnd = $this$and.and(other);
        Intrinsics.checkNotNullExpressionValue(bigIntegerAnd, "and(...)");
        return bigIntegerAnd;
    }

    private static final BigInteger or(BigInteger $this$or, BigInteger other) {
        Intrinsics.checkNotNullParameter($this$or, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger bigIntegerOr = $this$or.or(other);
        Intrinsics.checkNotNullExpressionValue(bigIntegerOr, "or(...)");
        return bigIntegerOr;
    }

    private static final BigInteger xor(BigInteger $this$xor, BigInteger other) {
        Intrinsics.checkNotNullParameter($this$xor, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger bigIntegerXor = $this$xor.xor(other);
        Intrinsics.checkNotNullExpressionValue(bigIntegerXor, "xor(...)");
        return bigIntegerXor;
    }

    private static final BigInteger shl(BigInteger $this$shl, int n) {
        Intrinsics.checkNotNullParameter($this$shl, "<this>");
        BigInteger bigIntegerShiftLeft = $this$shl.shiftLeft(n);
        Intrinsics.checkNotNullExpressionValue(bigIntegerShiftLeft, "shiftLeft(...)");
        return bigIntegerShiftLeft;
    }

    private static final BigInteger shr(BigInteger $this$shr, int n) {
        Intrinsics.checkNotNullParameter($this$shr, "<this>");
        BigInteger bigIntegerShiftRight = $this$shr.shiftRight(n);
        Intrinsics.checkNotNullExpressionValue(bigIntegerShiftRight, "shiftRight(...)");
        return bigIntegerShiftRight;
    }

    private static final BigInteger toBigInteger(int $this$toBigInteger) {
        BigInteger bigIntegerValueOf = BigInteger.valueOf($this$toBigInteger);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        return bigIntegerValueOf;
    }

    private static final BigInteger toBigInteger(long $this$toBigInteger) {
        BigInteger bigIntegerValueOf = BigInteger.valueOf($this$toBigInteger);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        return bigIntegerValueOf;
    }

    private static final BigDecimal toBigDecimal(BigInteger $this$toBigDecimal) {
        Intrinsics.checkNotNullParameter($this$toBigDecimal, "<this>");
        return new BigDecimal($this$toBigDecimal);
    }

    static  BigDecimal toBigDecimal$default(BigInteger $this$toBigDecimal_u24default, int scale, MathContext mathContext, int i, Object obj) {
        if ((i & 1) != 0) {
            scale = 0;
        }
        if ((i & 2) != 0) {
            mathContext = MathContext.UNLIMITED;
        }
        Intrinsics.checkNotNullParameter($this$toBigDecimal_u24default, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal($this$toBigDecimal_u24default, scale, mathContext);
    }

    private static final BigDecimal toBigDecimal(BigInteger $this$toBigDecimal, int scale, MathContext mathContext) {
        Intrinsics.checkNotNullParameter($this$toBigDecimal, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal($this$toBigDecimal, scale, mathContext);
    }
}
