package X;

import com.windukk.hook.HookMethod;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;

class w1 extends HookMethod {
    final  int a;
    final  Method b;
    final  String c;

    public w1(int i, Method method, String str) {
        this.a = i;
        this.b = method;
        this.c = str;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        int length = objArr.length;
        int i = this.a;
        if (length > i) {
            Object obj = objArr[i];
            if (obj instanceof String) {
                String str = (String) obj;
                Object result = hookMethodParam.getResult();
                HashMap map = x1.a;
                if (map.containsKey(str)) {
                    Object objValueOf = map.get(str);
                    Class<?> returnType = this.b.getReturnType();
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
                            objValueOf.toString();
                            returnType.getClass();
                            int i2 = p4.a;
                        }
                    }
                    if (objValueOf != null) {
                        Objects.toString(result);
                        objValueOf.toString();
                        int i3 = p4.a;
                        hookMethodParam.setResult(objValueOf);
                    }
                }
            }
        }
    }
}
