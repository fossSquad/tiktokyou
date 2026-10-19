package Z;
import com.windukk.hook.HookMethod;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

class a3 extends HookMethod {
    final  int a;
    final  Method b;
    final  String c;

    public a3(int i, Method method, String str) {
        this.a = i;
        this.b = method;
        this.c = str;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) throws Throwable {
        Object objA;
        boolean z;
        Object objNewInstance;
        Class clsA;
        Object obj;
        Object[] objArr = hookMethodParam.args;
        int length = objArr.length;
        int i = this.a;
        if (length > i) {
            Object obj2 = objArr[i];
            if (obj2 instanceof String) {
                String str = (String) obj2;
                Class<?> returnType = this.b.getReturnType();
                HashMap map = b3.a;
                Object objA2 = null;
                if (map.containsKey(str)) {
                    Object objValueOf = map.get(str);
                    Object result = hookMethodParam.getResult();
                    if (objValueOf instanceof String) {
                        String str2 = (String) objValueOf;
                        String strTrim = str2.trim();
                        if (!((strTrim.startsWith("{") && strTrim.endsWith("}")) || (strTrim.startsWith("[") && strTrim.endsWith("]"))) || vj.a((Class) returnType) || (clsA = b3.a(str, hookMethodParam.args, result, returnType)) == null || vj.a(clsA)) {
                            z = true;
                            if (returnType.isPrimitive()) {
                                objNewInstance = null;
                            } else {
                                objNewInstance = null;
                            }
                            if (objNewInstance != null) {
                                Objects.toString(result);
                                objNewInstance.toString();
                                hookMethodParam.setResult(objNewInstance);
                            } else if (returnType != Void.TYPE) {
                                if (objValueOf == null) {
                                    objValueOf = null;
                                } else if (returnType != Boolean.TYPE) {
                                    if (!(objValueOf instanceof Boolean)) {
                                        if (objValueOf instanceof Number) {
                                            if (((Number) objValueOf).intValue() == 0) {
                                                z = false;
                                            }
                                            objValueOf = Boolean.valueOf(z);
                                        } else if (objValueOf instanceof String) {
                                            objValueOf = Boolean.valueOf(Boolean.parseBoolean((String) objValueOf));
                                        }
                                    }
                                } else if (!(objValueOf instanceof Boolean)) {
                                    if (objValueOf instanceof Number) {
                                        if (((Number) objValueOf).intValue() == 0) {
                                            z = false;
                                        }
                                        objValueOf = Boolean.valueOf(z);
                                    } else if (objValueOf instanceof String) {
                                        objValueOf = Boolean.valueOf(Boolean.parseBoolean((String) objValueOf));
                                    }
                                }
                                if (objValueOf != null) {
                                    Objects.toString(result);
                                    objValueOf.toString();
                                    hookMethodParam.setResult(objValueOf);
                                }
                            } else {
                                if (objValueOf == null) {
                                    objValueOf = null;
                                } else if (returnType != Boolean.TYPE) {
                                    if (!(objValueOf instanceof Boolean)) {
                                        if (objValueOf instanceof Number) {
                                            if (((Number) objValueOf).intValue() == 0) {
                                                z = false;
                                            }
                                            objValueOf = Boolean.valueOf(z);
                                        } else if (objValueOf instanceof String) {
                                            objValueOf = Boolean.valueOf(Boolean.parseBoolean((String) objValueOf));
                                        }
                                    }
                                } else if (!(objValueOf instanceof Boolean)) {
                                    if (objValueOf instanceof Number) {
                                        if (((Number) objValueOf).intValue() == 0) {
                                            z = false;
                                        }
                                        objValueOf = Boolean.valueOf(z);
                                    } else if (objValueOf instanceof String) {
                                        objValueOf = Boolean.valueOf(Boolean.parseBoolean((String) objValueOf));
                                    }
                                }
                                if (objValueOf != null) {
                                    Objects.toString(result);
                                    objValueOf.toString();
                                    hookMethodParam.setResult(objValueOf);
                                }
                            }
                        } else {
                            ConcurrentHashMap concurrentHashMap = b3.g;
                            com.windukk.mod.hooks.a aVar = (com.windukk.mod.hooks.a) concurrentHashMap.get(str);
                            if (aVar != null && aVar.a.equals(str2) && aVar.b == clsA) {
                                obj = aVar.c;
                            } else {
                                try {
                                    Object objA3 = vj.a(str2, clsA);
                                    if (objA3 != null) {
                                        concurrentHashMap.put(str, new com.windukk.mod.hooks.a(clsA, objA3, str2));
                                    }
                                    obj = objA3;
                                } catch (Throwable th) {
                                    String strA = di.a("u0Fku/o88drSZqV/wsn7OG6OK62KMmvAlTs33YdjkOhw1k8FURdaT/+f/ZtHiWC3yPWlQKg6ndghe1epA62ciw==", "NWmCofNcjUTEjM8b", "aes", new StringBuilder(), str);
                                    Object obj3 = g7.a;
                                    g7.a(6, String.valueOf(strA), th);
                                    obj = null;
                                }
                            }
                            if (obj != null) {
                                Objects.toString(result);
                                obj.toString();
                                hookMethodParam.setResult(obj);
                            }
                        }
                    } else {
                        z = true;
                        if (returnType.isPrimitive() || returnType == Boolean.class || returnType == Integer.class || returnType == Long.class || returnType == String.class || ((objValueOf instanceof Boolean) && !((Boolean) objValueOf).booleanValue())) {
                            objNewInstance = null;
                        } else if ("comment_new_long_press_panel".equals(str)) {
                            int iIntValue = objValueOf instanceof Number ? ((Number) objValueOf).intValue() : 1;
                            try {
                                Class<?> cls = Class.forName("com.ss.android.ugc.aweme.comment.experiment.CommentLongPressConfig");
                                Class<?> cls2 = Integer.TYPE;
                                objNewInstance = cls.getConstructor(cls2, Long.TYPE, cls2).newInstance(Integer.valueOf(iIntValue), 500L, 15);
                            } catch (Throwable th2) {
                                String strDecrypt = "Failed to force comment_new_long_press_panel";
                                Object obj4 = g7.a;
                                g7.a(6, String.valueOf(strDecrypt), th2);
                                objNewInstance = null;
                            }
                        } else if ("comment_sticker_consumption_spec".equals(str)) {
                            int iIntValue2 = objValueOf instanceof Number ? ((Number) objValueOf).intValue() : 1;
                            try {
                                Class<?> cls3 = Class.forName("com.ss.android.ugc.aweme.experiment.CommentStickerConsumptionSpecExp$CommentStickerConsumptionConfig");
                                Class<?> cls4 = Integer.TYPE;
                                objNewInstance = cls3.getConstructor(cls4, cls4, cls4, cls4).newInstance(Integer.valueOf(iIntValue2), 0, 0, 0);
                            } catch (Throwable th3) {
                                String strDecrypt2 = "Failed to force comment_sticker_consumption_spec";
                                Object obj5 = g7.a;
                                g7.a(6, String.valueOf(strDecrypt2), th3);
                                objNewInstance = null;
                            }
                        } else {
                            objNewInstance = null;
                        }
                        if (objNewInstance != null) {
                            Objects.toString(result);
                            objNewInstance.toString();
                            hookMethodParam.setResult(objNewInstance);
                        } else if (returnType != Void.TYPE || returnType == Void.class || returnType.isPrimitive() || returnType == Boolean.class || returnType == Integer.class || returnType == Long.class || returnType == Float.class || returnType == Double.class || returnType == String.class || (objValueOf != null && (!(objValueOf instanceof Boolean) || ((Boolean) objValueOf).booleanValue()))) {
                            if (objValueOf == null) {
                                objValueOf = null;
                            } else {
                                try {
                                    if (returnType != Boolean.TYPE || returnType == Boolean.class) {
                                        if (!(objValueOf instanceof Boolean)) {
                                            if (objValueOf instanceof Number) {
                                                if (((Number) objValueOf).intValue() == 0) {
                                                    z = false;
                                                }
                                                objValueOf = Boolean.valueOf(z);
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
                                    String str3 = "Failed to convert value " + objValueOf + " to " + returnType.getName();
                                    Object obj6 = g7.a;
                                    g7.a(6, String.valueOf(str3), e);
                                }
                            }
                            if (objValueOf != null) {
                                Objects.toString(result);
                                objValueOf.toString();
                                hookMethodParam.setResult(objValueOf);
                            }
                        } else {
                            Object objA4 = b3.a(hookMethodParam.args, returnType);
                            Objects.toString(result);
                            Objects.toString(objA4);
                            hookMethodParam.setResult(objA4);
                        }
                    }
                }
                if (vj.a((Class) returnType)) {
                    return;
                }
                Map map2 = (Map) b3.d.get(str);
                if (map2 != null && !map2.isEmpty()) {
                    Object result2 = hookMethodParam.getResult();
                    Class clsA2 = b3.a(str, hookMethodParam.args, hookMethodParam.getResult(), returnType);
                    com.windukk.mod.hooks.b bVar = (com.windukk.mod.hooks.b) b3.h.get(str);
                    if (bVar == null || !(bVar.a == result2 || bVar.b == result2)) {
                        if (result2 != null) {
                            objA = result2;
                        } else if (clsA2 != null && !vj.a(clsA2)) {
                            try {
                                objA = vj.a("{}", clsA2);
                                if (objA != null) {
                                }
                            } catch (Throwable th4) {
                                String strA2 = di.a("Fo6cBQJV+ADr2wjDPFC0VkBRlYt7XiEvQuSM0sHIZhk=", "77uyIRiBRvWG482D", "aes", new StringBuilder().append("Failed to create ").append(clsA2.getName()), str);
                                Object obj7 = g7.a;
                                g7.a(6, String.valueOf(strA2), th4);
                            }
                        }
                        if (!(objA instanceof Class)) {
                            Class<?> cls5 = objA.getClass();
                            if (!vj.a((Class) cls5) && !cls5.isArray() && !(objA instanceof Iterable) && !(objA instanceof Map)) {
                                if (objA == b3.i.get(str)) {
                                    try {
                                        objA2 = vj.a(vj.a(objA), objA.getClass());
                                    } catch (Throwable th5) {
                                        String strA3 = di.a("YVsCfqushNZo+Re65GFrFNO0RztW9w81KFvuQTJND13vHcYpJRm2H1hfTZ+PHvlkKNyLjujTcqsq//4Lw+z5aQ==", "pdFFXhfl3oSoml6K", "aes", new StringBuilder(), str);
                                        Object obj8 = g7.a;
                                        g7.a(6, String.valueOf(strA3), th5);
                                    }
                                } else {
                                    objA2 = objA;
                                }
                                for (Map.Entry entry : map2.entrySet()) {
                                    try {
                                        Field fieldA = se.a((Class) objA2.getClass(), (String) entry.getKey());
                                        fieldA.set(objA2, vj.a((String) entry.getValue(), fieldA.getGenericType()));
                                    } catch (Throwable th6) {
                                        String string = ve.a("H6ec9aq8leg+wx2GRWYeuB2m4OwfMC0uVOgo9uA+LWqPA+ffzrs1YHQBMQ5rC1b2", "poqVwsySUMX9tJTJ", "aes", new StringBuilder(), str).append(".").append((String) entry.getKey()).toString();
                                        Object obj9 = g7.a;
                                        g7.a(6, String.valueOf(string), th6);
                                    }
                                }
                                b3.h.put(str, new com.windukk.mod.hooks.b(result2, objA2));
                                Objects.toString(map2.keySet());
                            }
                        }
                    } else {
                        objA2 = bVar.b;
                    }
                    if (objA2 != null) {
                        hookMethodParam.setResult(objA2);
                    }
                }
                Object[] objArr2 = hookMethodParam.args;
                Object result3 = hookMethodParam.getResult();
                if (objArr2 != null) {
                    for (Object obj10 : objArr2) {
                        if (obj10 instanceof Class) {
                            b3.f.put(str, (Class) obj10);
                            break;
                        }
                    }
                }
                if (result3 == null || vj.a((Class) result3.getClass())) {
                    return;
                }
                b3.e.put(str, result3);
            }
        }
    }
}
