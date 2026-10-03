package Z;

import Z.a;
import Z.a7;
import Z.a8;
import Z.a9;
import Z.ae;
import Z.ag;
import Z.b;
import Z.b1;
import Z.b4;
import Z.b7;
import Z.b9;
import Z.ba;
import Z.bb;
import Z.bg;
import Z.c1;
import Z.c4;
import Z.c7;
import Z.ca;
import Z.cb;
import Z.cf;
import Z.cg;
import Z.d1;
import Z.d5;
import Z.d7;
import Z.d8;
import Z.d9;
import Z.db;
import Z.dd;
import Z.df;
import Z.dg;
import Z.e;
import Z.e1;
import Z.e8;
import Z.e9;
import Z.eb;
import Z.ec;
import Z.ef;
import Z.eg;
import Z.f1;
import Z.f6;
import Z.f8;
import Z.fb;
import Z.fc;
import Z.ff;
import Z.fg;
import Z.g1;
import Z.g8;
import Z.g9;
import Z.ga;
import Z.gb;
import Z.gc;
import Z.gf;
import Z.gg;
import Z.h1;
import Z.h4;
import Z.h6;
import Z.h9;
import Z.hb;
import Z.hc;
import Z.hf;
import Z.hg;
import Z.i1;
import Z.i4;
import Z.i5;
import Z.i9;
import Z.ia;
import Z.ic;
import Z.id;
import Z.j1;
import Z.j4;
import Z.j5;
import Z.j9;
import Z.ja;
import Z.jb;
import Z.jf;
import Z.k2;
import Z.k4;
import Z.k5;
import Z.k8;
import Z.k9;
import Z.ka;
import Z.kf;
import Z.l2;
import Z.l4;
import Z.l6;
import Z.l8;
import Z.l9;
import Z.la;
import Z.le;
import Z.lf;
import Z.m0;
import Z.m4;
import Z.m5;
import Z.m8;
import Z.m9;
import Z.ma;
import Z.mf;
import Z.n0;
import Z.n4;
import Z.n5;
import Z.n8;
import Z.n9;
import Z.na;
import Z.nd;
import Z.nf;
import Z.o;
import Z.o0;
import Z.o4;
import Z.o5;
import Z.o6;
import Z.o8;
import Z.o9;
import Z.oa;
import Z.of;
import Z.p0;
import Z.p2;
import Z.p4;
import Z.p5;
import Z.p8;
import Z.pd;
import Z.pf;
import Z.q0;
import Z.q1;
import Z.q4;
import Z.q5;
import Z.q6;
import Z.q8;
import Z.qa;
import Z.qd;
import Z.qf;
import Z.r0;
import Z.r1;
import Z.r2;
import Z.r4;
import Z.r5;
import Z.r6;
import Z.r8;
import Z.r9;
import Z.rd;
import Z.rf;
import Z.s0;
import Z.s1;
import Z.s4;
import Z.s6;
import Z.s8;
import Z.s9;
import Z.sd;
import Z.sf;
import Z.t0;
import Z.t4;
import Z.t6;
import Z.t8;
import Z.ta;
import Z.td;
import Z.te;
import Z.tf;
import Z.tg;
import Z.u0;
import Z.u4;
import Z.u6;
import Z.u8;
import Z.ua;
import Z.ud;
import Z.ue;
import Z.uf;
import Z.v0;
import Z.v4;
import Z.v5;
import Z.v6;
import Z.v8;
import Z.v9;
import Z.vd;
import Z.ve;
import Z.vf;
import Z.w0;
import Z.w1;
import Z.w4;
import Z.w7;
import Z.w8;
import Z.w9;
import Z.wa;
import Z.wd;
import Z.we;
import Z.wf;
import Z.x0;
import Z.x1;
import Z.x4;
import Z.x8;
import Z.x9;
import Z.xd;
import Z.xf;
import Z.y0;
import Z.y4;
import Z.y8;
import Z.y9;
import Z.yf;
import Z.z0;
import Z.z4;
import Z.z7;
import Z.z8;
import Z.z9;
import Z.zd;
import Z.zf;
import Z.zg;
import com.windukk.hook.HookMethod;
import Z.ConfigHooks;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;

class p2 extends HookMethod {
    final  int a;
    final  Method b;
    final  String c;

    public p2(int i, Method method, String str) {
        this.a = i;
        this.b = method;
        this.c = str;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object objNewInstance;
        Class<?> cls;
        Object[] objArr = hookMethodParam.args;
        int length = objArr.length;
        int i = this.a;
        if (length > i) {
            Object obj = objArr[i];
            if (obj instanceof String) {
                String str = (String) obj;
                Object result = hookMethodParam.getResult();
                HashMap map = ConfigHooks.a;
                if (map.containsKey(str)) {
                    Object objValueOf = map.get(str);
                    Class<?> returnType = this.b.getReturnType();
                    Object obj2 = null;
                    if (returnType.isPrimitive() || returnType == Boolean.class || returnType == Integer.class || returnType == Long.class || returnType == String.class || ((objValueOf instanceof Boolean) && !((Boolean) objValueOf).booleanValue())) {
                        objNewInstance = null;
                    } else if ("comment_new_long_press_panel".equals(str)) {
                        int iIntValue = objValueOf instanceof Number ? ((Number) objValueOf).intValue() : 1;
                        try {
                            Class<?> cls2 = Class.forName("com.ss.android.ugc.aweme.comment.experiment.CommentLongPressConfig");
                            Class<?> cls3 = Integer.TYPE;
                            objNewInstance = cls2.getConstructor(cls3, Long.TYPE, cls3).newInstance(Integer.valueOf(iIntValue), 500L, 15);
                        } catch (Throwable th) {
                            String strDecrypt = "Failed to force comment_new_long_press_panel";
                            Object obj3 = h6.a;
                            h6.a(6, String.valueOf(strDecrypt), th);
                            objNewInstance = null;
                        }
                    } else if ("comment_sticker_consumption_spec".equals(str)) {
                        int iIntValue2 = objValueOf instanceof Number ? ((Number) objValueOf).intValue() : 1;
                        try {
                            Class<?> cls4 = Class.forName("com.ss.android.ugc.aweme.experiment.CommentStickerConsumptionSpecExp$CommentStickerConsumptionConfig");
                            Class<?> cls5 = Integer.TYPE;
                            objNewInstance = cls4.getConstructor(cls5, cls5, cls5, cls5).newInstance(Integer.valueOf(iIntValue2), 0, 0, 0);
                        } catch (Throwable th2) {
                            String strDecrypt2 = "Failed to force comment_sticker_consumption_spec";
                            Object obj4 = h6.a;
                            h6.a(6, String.valueOf(strDecrypt2), th2);
                            objNewInstance = null;
                        }
                    } else {
                        objNewInstance = null;
                    }
                    if (objNewInstance != null) {
                        Objects.toString(result);
                        objNewInstance.toString();
                        hookMethodParam.setResult(objNewInstance);
                        return;
                    }
                    if (returnType != Void.TYPE && returnType != Void.class && !returnType.isPrimitive() && returnType != Boolean.class && returnType != Integer.class && returnType != Long.class && returnType != Float.class && returnType != Double.class && returnType != String.class && (objValueOf == null || ((objValueOf instanceof Boolean) && !((Boolean) objValueOf).booleanValue()))) {
                        Object[] objArr2 = hookMethodParam.args;
                        if (objArr2 != null) {
                            for (int length2 = objArr2.length - 1; length2 >= 0; length2--) {
                                Object obj5 = objArr2[length2];
                                if (obj5 != null && (cls = obj5.getClass()) != String.class && cls != Class.class && cls != Boolean.class && !Number.class.isAssignableFrom(cls) && (returnType == Object.class || returnType.isInstance(obj5))) {
                                    obj2 = obj5;
                                    break;
                                }
                            }
                        }
                        Objects.toString(result);
                        Objects.toString(obj2);
                        hookMethodParam.setResult(obj2);
                        return;
                    }
                    if (objValueOf == null) {
                        objValueOf = null;
                    } else {
                        try {
                            if (returnType == Boolean.TYPE || returnType == Boolean.class) {
                                if (!(objValueOf instanceof Boolean)) {
                                    if (objValueOf instanceof Number) {
                                        objValueOf = Boolean.valueOf(((Number) objValueOf).intValue() != 0);
                                    } else if (objValueOf instanceof String) {
                                        objValueOf = Boolean.valueOf(Boolean.parseBoolean((String) objValueOf));
                                    }
                                }
                            } else if (returnType == Integer.TYPE || returnType == Integer.class) {
                                if (objValueOf instanceof Number) {
                                    objValueOf = Integer.valueOf(((Number) objValueOf).intValue());
                                } else if (objValueOf instanceof Boolean) {
                                    objValueOf = Integer.valueOf(((Boolean) objValueOf).booleanValue() ? 1 : 0);
                                } else if (objValueOf instanceof String) {
                                    objValueOf = Integer.valueOf(Integer.parseInt((String) objValueOf));
                                }
                            } else if (returnType == Long.TYPE || returnType == Long.class) {
                                if (objValueOf instanceof Number) {
                                    objValueOf = Long.valueOf(((Number) objValueOf).longValue());
                                } else if (objValueOf instanceof String) {
                                    objValueOf = Long.valueOf(Long.parseLong((String) objValueOf));
                                }
                            } else if (returnType == Float.TYPE || returnType == Float.class) {
                                if (objValueOf instanceof Number) {
                                    objValueOf = Float.valueOf(((Number) objValueOf).floatValue());
                                } else if (objValueOf instanceof String) {
                                    objValueOf = Float.valueOf(Float.parseFloat((String) objValueOf));
                                }
                            } else if (returnType == Double.TYPE || returnType == Double.class) {
                                if (objValueOf instanceof Number) {
                                    objValueOf = Double.valueOf(((Number) objValueOf).doubleValue());
                                } else if (objValueOf instanceof String) {
                                    objValueOf = Double.valueOf(Double.parseDouble((String) objValueOf));
                                }
                            } else if (returnType == String.class) {
                                objValueOf = String.valueOf(objValueOf);
                            }
                        } catch (Exception e) {
                            String str2 = "Failed to convert value " + objValueOf + " to " + returnType.getName();
                            Object obj6 = h6.a;
                            h6.a(6, String.valueOf(str2), e);
                        }
                    }
                    if (objValueOf != null) {
                        Objects.toString(result);
                        objValueOf.toString();
                        hookMethodParam.setResult(objValueOf);
                    }
                }
            }
        }
    }
}
