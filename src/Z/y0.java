package Z;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Locale;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.StringCompanionObject;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.kotlinx.serialization.json.JsonArray;
import ni.shikatu.kotlinx.serialization.json.JsonElement;
import ni.shikatu.kotlinx.serialization.json.JsonElementKt;
import ni.shikatu.kotlinx.serialization.json.JsonObject;
import ni.shikatu.kotlinx.serialization.json.JsonPrimitive;

public abstract class y0 {
    public static final rg a(String str) {
        Object obj;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            Json json = e7.a;
            String string = StringsKt.trim(str).toString();
            json.getSerializersModule();
            tg tgVar = (tg) json.decodeFromString(sg.a, string);
            obj = ResultCompat.constructor(new rg(a(tgVar.b), String.valueOf((long) Math.ceil(tgVar.a))));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = ResultCompat.constructor(ResultKt.createFailure(th));
        }
        Throwable th2 = ResultCompat.exceptionOrNull(obj);
        if (th2 != null) {
            g7.a(6, g7.a("Failed to parse support price JSON: %s", new Object[]{th2.getMessage()}), (Throwable) null);
        }
        return (rg) (ResultCompat.isFailure(obj) ? null : obj);
    }

    public static final LinkedHashMap b(String str) {
        Object obj;
        x1 x1Var;
        boolean z;
        String strB;
        boolean zBooleanValue;
        String str2;
        String str3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (str != null && !StringsKt.isBlank(str)) {
            JsonElement jsonArrayB = e7.b(StringsKt.trim(str).toString());
            JsonArray jsonArray = jsonArrayB instanceof JsonArray ? (JsonArray) jsonArrayB : null;
            if (jsonArray != null) {
                for (JsonElement jsonElement : jsonArray) {
                    try {
                        Result.Companion companion = Result.Companion;
                        Json json = e7.a;
                        json.getSerializersModule();
                        obj = ResultCompat.constructor((z1) json.decodeFromJsonElement(y1.a, jsonElement));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = ResultCompat.constructor(ResultKt.createFailure(th));
                    }
                    if (ResultCompat.isFailure(obj)) {
                        obj = null;
                    }
                    z1 z1Var = (z1) obj;
                    if (z1Var != null) {
                        String string = StringsKt.trim(z1Var.a).toString();
                        if (string.length() == 0) {
                            x1Var = null;
                            break;
                        }
                        int i = 0;
                        while (true) {
                            if (i >= string.length()) {
                                if (z1Var.b) {
                                    z = true;
                                } else {
                                    String strDecrypt = "developer";
                                    String str4 = z1Var.c;
                                    if (StringsKt.equals(strDecrypt, str4 != null ? StringsKt.trim(str4).toString() : null, true)) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                }
                                String str5 = z1Var.d;
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
                                    strB = a2.b(string2);
                                }
                                Boolean bool = z1Var.e;
                                if (bool != null) {
                                    zBooleanValue = bool.booleanValue();
                                } else {
                                    boolean z2 = str5.length() == 0;
                                    String strB2 = a2.b(strB);
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
                                String str6 = z1Var.f;
                                String string3 = str6 != null ? StringsKt.trim(str6).toString() : null;
                                if (string3 == null) {
                                    string3 = "";
                                }
                                String str7 = z1Var.g;
                                String string4 = str7 != null ? StringsKt.trim(str7).toString() : null;
                                x1Var = new x1(string, strB, zBooleanValue, z, string3, string4 != null ? string4 : "");
                                break;
                            }
                            char cCharAt = string.charAt(i);
                            if ('0' > cCharAt || cCharAt >= ':') {
                                x1Var = null;
                                break;
                            }
                            i++;
                        }
                        if (x1Var != null) {
                            linkedHashMap.put(x1Var.a, x1Var);
                        }
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public static final String a(String str, String str2, String str3) {
        String contentOrNull;
        if (str == null || StringsKt.isBlank(str) || str2 == null || StringsKt.isBlank(str2)) {
            return null;
        }
        JsonElement jsonObjectB = e7.b(StringsKt.trim(str2).toString());
        JsonObject jsonObject = jsonObjectB instanceof JsonObject ? (JsonObject) jsonObjectB : null;
        if (jsonObject == null) {
            return null;
        }
        Object obj = jsonObject.get("base");
        JsonPrimitive jsonPrimitive = obj instanceof JsonPrimitive ? (JsonPrimitive) obj : null;
        if (!Intrinsics.areEqual(jsonPrimitive != null ? JsonElementKt.getContentOrNull(jsonPrimitive) : null, str3)) {
            return null;
        }
        JsonElement jsonArrayB = e7.b(StringsKt.trim(str).toString());
        JsonArray jsonArray = jsonArrayB instanceof JsonArray ? (JsonArray) jsonArrayB : null;
        if (jsonArray == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (JsonElement jsonElement : jsonArray) {
            String strA = a(jsonElement);
            if (strA != null) {
                linkedHashMap.put(strA, jsonElement);
            }
        }
        Object obj2 = jsonObject.get("remove");
        JsonArray jsonArray2 = obj2 instanceof JsonArray ? (JsonArray) obj2 : null;
        if (jsonArray2 != null) {
            for (JsonElement jsonPrimitive2 : jsonArray2) {
                JsonPrimitive jsonPrimitive3 = jsonPrimitive2 instanceof JsonPrimitive ? (JsonPrimitive) jsonPrimitive2 : null;
                if (jsonPrimitive3 != null && (contentOrNull = JsonElementKt.getContentOrNull(jsonPrimitive3)) != null) {
                    linkedHashMap.remove(contentOrNull);
                }
            }
        }
        Object obj3 = jsonObject.get("upsert");
        JsonArray jsonArray3 = obj3 instanceof JsonArray ? (JsonArray) obj3 : null;
        if (jsonArray3 != null) {
            for (JsonElement jsonElement2 : jsonArray3) {
                String strA2 = a(jsonElement2);
                if (strA2 != null) {
                    linkedHashMap.put(strA2, jsonElement2);
                }
            }
        }
        Collection collectionValues = linkedHashMap.values();
        return new JsonArray(CollectionsKt.toList(collectionValues)).toString();
    }

    public static final String a(JsonElement jsonElement) {
        String contentOrNull;
        JsonObject jsonObject = jsonElement instanceof JsonObject ? (JsonObject) jsonElement : null;
        JsonElement jsonElement2 = jsonObject != null ? (JsonElement) jsonObject.get("uid") : null;
        JsonPrimitive jsonPrimitive = jsonElement2 instanceof JsonPrimitive ? (JsonPrimitive) jsonElement2 : null;
        if (jsonPrimitive == null || (contentOrNull = JsonElementKt.getContentOrNull(jsonPrimitive)) == null || contentOrNull.length() <= 0) {
            return null;
        }
        return contentOrNull;
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
