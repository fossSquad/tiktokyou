package Z;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.ConfigHooks;
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

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) throws Throwable {
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
