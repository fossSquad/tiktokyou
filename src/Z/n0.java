package Z;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.StringCompanionObject;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.kotlinx.serialization.json.JsonArray;
import ni.shikatu.kotlinx.serialization.json.JsonElement;

public abstract class n0 {
    public static final ze a(String str) {
        Object obj;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            Json json = f6.a;
            String string = StringsKt.trim(str).toString();
            json.getSerializersModule();
            bf bfVar = (bf) json.decodeFromString(af.a, string);
            obj = RCompat.m6constructorimpl(new ze(a(bfVar.b), String.valueOf((long) Math.ceil(bfVar.a))));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        Throwable th2 = RCompat.m9exceptionOrNullimpl(obj);
        if (th2 != null) {
            h6.a(6, h6.a("Failed to parse support price JSON: %s", new Object[]{th2.getMessage()}), (Throwable) null);
        }
        return (ze) (RCompat.m12isFailureimpl(obj) ? null : obj);
    }

    public static final LinkedHashMap b(String str) {
        Object obj;
        n1 n1Var;
        boolean z;
        String strB;
        boolean zBooleanValue;
        String str2;
        String str3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (str != null && !StringsKt.isBlank(str)) {
            JsonArray jsonArrayB = (JsonArray) f6.b(StringsKt.trim(str).toString());
            JsonArray jsonArray = jsonArrayB instanceof JsonArray ? jsonArrayB : null;
            if (jsonArray != null) {
                for (JsonElement jsonElement : jsonArray) {
                    try {
                        Result.Companion companion = Result.Companion;
                        Json json = f6.a;
                        json.getSerializersModule();
                        obj = RCompat.m6constructorimpl((p1) json.decodeFromJsonElement(o1.a, jsonElement));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
                    }
                    if (RCompat.m12isFailureimpl(obj)) {
                        obj = null;
                    }
                    p1 p1Var = (p1) obj;
                    if (p1Var != null) {
                        String string = StringsKt.trim(p1Var.a).toString();
                        if (string.length() == 0) {
                            n1Var = null;
                            break;
                        }
                        int i = 0;
                        while (true) {
                            if (i >= string.length()) {
                                if (p1Var.b) {
                                    z = true;
                                } else {
                                    String strDecrypt = "developer";
                                    String str4 = p1Var.c;
                                    if (StringsKt.equals(strDecrypt, str4 != null ? StringsKt.trim(str4).toString() : null, true)) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                }
                                String str5 = p1Var.d;
                                if (str5 == null) {
                                    str5 = "";
                                }
                                String string2 = StringsKt.trim(str5).toString();
                                if (string2.length() == 0) {
                                    strB = (z ? "asset:developer.png" : "asset:supporter.png");
                                } else if (StringsKt.equals("supporter", string2, true)) {
                                    strB = "asset:supporter.png";
                                } else if (StringsKt.equals("developer", string2, true)) {
                                    strB = "asset:developer.png";
                                } else {
                                    strB = q1.b(string2);
                                }
                                Boolean bool = p1Var.e;
                                if (bool != null) {
                                    zBooleanValue = bool.booleanValue();
                                } else {
                                    boolean z2 = str5.length() == 0;
                                    String strB2 = q1.b(strB);
                                    if (z2 || Intrinsics.areEqual(strB2, "asset:supporter.png") || Intrinsics.areEqual(strB2, "asset:developer.png")) {
                                        zBooleanValue = true;
                                    } else {
                                        String strSubstringAfterLast$default = StringsKt.substringAfterLast$default(strB2, '/', (String) null, 2, (Object) null);
                                        if (StringsKt.startsWith$default(strSubstringAfterLast$default, "asset:", false, 2, (Object) null)) {
                                            strSubstringAfterLast$default = StringsKt.removePrefix(strSubstringAfterLast$default, "asset:");
                                        }
                                        String strSubstringBeforeLast = StringsKt.substringBeforeLast(strSubstringAfterLast$default, '.', strSubstringAfterLast$default);
                                        if (StringsKt.equals(strSubstringBeforeLast, "hz", true) || StringsKt.equals(strSubstringBeforeLast, "designer", true) || StringsKt.equals(strSubstringBeforeLast, "dev", true) || StringsKt.equals(strSubstringBeforeLast, "supporter", true) || StringsKt.equals(strSubstringBeforeLast, "developer", true)) {
                                            zBooleanValue = true;
                                        } else {
                                            zBooleanValue = false;
                                        }
                                    }
                                }
                                String str6 = p1Var.f;
                                String string3 = str6 != null ? StringsKt.trim(str6).toString() : null;
                                if (string3 == null) {
                                    string3 = "";
                                }
                                String str7 = p1Var.g;
                                String string4 = str7 != null ? StringsKt.trim(str7).toString() : null;
                                n1Var = new n1(string, strB, zBooleanValue, z, string3, string4 != null ? string4 : "");
                                break;
                            }
                            char cCharAt = string.charAt(i);
                            if ('0' > cCharAt || cCharAt >= ':') {
                                n1Var = null;
                                break;
                            }
                            i++;
                        }
                        if (n1Var != null) {
                            linkedHashMap.put(n1Var.a, n1Var);
                        }
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public static final String a(double d) {
        long jRint = (long) Math.rint(d);
        if (Math.abs(d - jRint) < 1.0E-6d) {
            return String.valueOf(jRint);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d)}, 1));
        return StringsKt.trimEnd(StringsKt.trimEnd(str, new char[]{'0'}), new char[]{'.'});
    }
}
