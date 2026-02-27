package ni.shikatu.kotlin.jvm.internal;

import java.io.Serializable;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Function;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function10;
import ni.shikatu.kotlin.jvm.functions.Function11;
import ni.shikatu.kotlin.jvm.functions.Function12;
import ni.shikatu.kotlin.jvm.functions.Function13;
import ni.shikatu.kotlin.jvm.functions.Function14;
import ni.shikatu.kotlin.jvm.functions.Function15;
import ni.shikatu.kotlin.jvm.functions.Function16;
import ni.shikatu.kotlin.jvm.functions.Function17;
import ni.shikatu.kotlin.jvm.functions.Function18;
import ni.shikatu.kotlin.jvm.functions.Function19;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.functions.Function20;
import ni.shikatu.kotlin.jvm.functions.Function21;
import ni.shikatu.kotlin.jvm.functions.Function22;
import ni.shikatu.kotlin.jvm.functions.Function3;
import ni.shikatu.kotlin.jvm.functions.Function4;
import ni.shikatu.kotlin.jvm.functions.Function5;
import ni.shikatu.kotlin.jvm.functions.Function6;
import ni.shikatu.kotlin.jvm.functions.Function7;
import ni.shikatu.kotlin.jvm.functions.Function8;
import ni.shikatu.kotlin.jvm.functions.Function9;

@Deprecated(level = DeprecationLevel.ERROR, message = "This class is no longer supported, do not use it.")
@Deprecated
public abstract class FunctionImpl implements Function, Serializable, Function0, Function1, Function2, Function3, Function4, Function5, Function6, Function7, Function8, Function9, Function10, Function11, Function12, Function13, Function14, Function15, Function16, Function17, Function18, Function19, Function20, Function21, Function22 {
    public abstract int getArity();

    public Object invokeVararg(Object... p) {
        throw new UnsupportedOperationException();
    }

    private void checkArity(int expected) {
        if (getArity() != expected) {
            throwWrongArity(expected);
        }
    }

    private void throwWrongArity(int expected) {
        throw new IllegalStateException("Wrong function arity, expected: " + expected + ", actual: " + getArity());
    }

    @Override
    public Object invoke() {
        checkArity(0);
        return invokeVararg(new Object[0]);
    }

    @Override
    public Object invoke(Object p1) {
        checkArity(1);
        return invokeVararg(p1);
    }

    @Override
    public Object invoke(Object p1, Object p2) {
        checkArity(2);
        return invokeVararg(p1, p2);
    }

    @Override
    public Object invoke(Object p1, Object p2, Object p3) {
        checkArity(3);
        return invokeVararg(p1, p2, p3);
    }

    @Override
    public Object invoke(Object p1, Object p2, Object p3, Object p4) {
        checkArity(4);
        return invokeVararg(p1, p2, p3, p4);
    }

    @Override
    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5) {
        checkArity(5);
        return invokeVararg(p1, p2, p3, p4, p5);
    }

    @Override
    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        checkArity(6);
        return invokeVararg(p1, p2, p3, p4, p5, p6);
    }

    @Override
    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        checkArity(7);
        return invokeVararg(p1, p2, p3, p4, p5, p6, p7);
    }

    @Override
    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        checkArity(8);
        return invokeVararg(p1, p2, p3, p4, p5, p6, p7, p8);
    }

    @Override
    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        checkArity(9);
        return invokeVararg(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    @Override
    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10) {
        checkArity(10);
        return invokeVararg(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }

    @Override
    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11) {
        checkArity(11);
        return invokeVararg(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11);
    }

    @Override
    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12) {
        checkArity(12);
        return invokeVararg(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12);
    }

    @Override
    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13) {
        checkArity(13);
        return invokeVararg(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13);
    }

    @Override
    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14) {
        checkArity(14);
        return invokeVararg(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14);
    }

    @Override
    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15) {
        checkArity(15);
        return invokeVararg(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15);
    }

    @Override
    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16) {
        checkArity(16);
        return invokeVararg(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16);
    }

    @Override
    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17) {
        checkArity(17);
        return invokeVararg(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17);
    }

    @Override
    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18) {
        checkArity(18);
        return invokeVararg(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18);
    }

    @Override
    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18, Object p19) {
        checkArity(19);
        return invokeVararg(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19);
    }

    @Override
    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18, Object p19, Object p20) {
        checkArity(20);
        return invokeVararg(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20);
    }

    @Override
    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18, Object p19, Object p20, Object p21) {
        checkArity(21);
        return invokeVararg(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21);
    }

    @Override
    public Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18, Object p19, Object p20, Object p21, Object p22) {
        checkArity(22);
        return invokeVararg(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22);
    }
}
