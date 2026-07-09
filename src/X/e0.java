package X;

import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class e0 {
    public static bc a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str.trim());
            String strA = a(jSONObject.opt("usd"));
            String strB = b(jSONObject.opt("ruble"));
            if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strB)) {
                return new bc(strA, strB);
            }
            return null;
        } catch (Throwable th) {
            th.getMessage();
            int i = g5.a;
            return null;
        }
    }

    public static LinkedHashMap b(String str) {
        f1 f1VarA;
        if (TextUtils.isEmpty(str)) {
            return new LinkedHashMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!TextUtils.isEmpty(str)) {
            String strTrim = str.trim();
            if (strTrim.startsWith("[")) {
                try {
                    JSONArray jSONArray = new JSONArray(strTrim);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        Object objOpt = jSONArray.opt(i);
                        if ((objOpt instanceof JSONObject) && (f1VarA = a((JSONObject) objOpt)) != null) {
                            linkedHashMap.put(f1VarA.a, f1VarA);
                        }
                    }
                } catch (Throwable th) {
                    th.getMessage();
                    int i2 = g5.a;
                    return linkedHashMap;
                }
            }
        }
        return linkedHashMap;
    }

    public static f1 a(JSONObject jSONObject) {
        String strOptString;
        String strB;
        String strTrim;
        boolean zBooleanValue;
        String strTrim2 = "";
        String strTrim3 = jSONObject.optString("uid", "").trim();
        Boolean boolValueOf = null;
        if (strTrim3.isEmpty()) {
            return null;
        }
        boolean z = true;
        if (!jSONObject.optBoolean("isDeveloper", false) && !"developer".equalsIgnoreCase(jSONObject.optString("status", "").trim())) {
            z = false;
        }
        if (jSONObject.has("badgeUrl") && !jSONObject.isNull("badgeUrl")) {
            strOptString = jSONObject.optString("badgeUrl", "");
        } else {
            strOptString = "";
        }
        String strTrim4 = TextUtils.isEmpty(strOptString) ? "" : strOptString.trim();
        if (strTrim4.isEmpty()) {
            strB = z ? "asset:developer.png" : "asset:supporter.png";
        } else if ("supporter".equalsIgnoreCase(strTrim4)) {
            strB = "asset:supporter.png";
        } else if ("developer".equalsIgnoreCase(strTrim4)) {
            strB = "asset:developer.png";
        } else {
            strB = g1.b(strTrim4);
        }
        if (jSONObject.has("tinted") && !jSONObject.isNull("tinted")) {
            boolValueOf = Boolean.valueOf(jSONObject.optBoolean("tinted"));
        }
        if (jSONObject.has("text") && !jSONObject.isNull("text")) {
            strTrim = jSONObject.optString("text", "").trim();
        } else {
            strTrim = "";
        }
        if (jSONObject.has("bannerUrl") && !jSONObject.isNull("bannerUrl")) {
            strTrim2 = jSONObject.optString("bannerUrl", "").trim();
        }
        Boolean bool = boolValueOf;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        } else {
            boolean zIsEmpty = TextUtils.isEmpty(strOptString);
            String strB2 = g1.b(strB);
            if (zIsEmpty || TextUtils.equals(strB2, "asset:supporter.png") || TextUtils.equals(strB2, "asset:developer.png")) {
                zBooleanValue = z;
            } else {
                int iLastIndexOf = strB2.lastIndexOf(47);
                if (iLastIndexOf >= 0) {
                    strB2 = strB2.substring(iLastIndexOf + 1);
                }
                if (strB2.startsWith("asset:")) {
                    strB2 = strB2.substring(6);
                }
                int iLastIndexOf2 = strB2.lastIndexOf(46);
                if (iLastIndexOf2 > 0) {
                    strB2 = strB2.substring(0, iLastIndexOf2);
                }
                if ("hz".equalsIgnoreCase(strB2) || "designer".equalsIgnoreCase(strB2) || "dev".equalsIgnoreCase(strB2) || "supporter".equalsIgnoreCase(strB2) || "developer".equalsIgnoreCase(strB2)) {
                    zBooleanValue = z;
                } else {
                    zBooleanValue = false;
                }
            }
        }
        return new f1(strTrim3, strB, zBooleanValue, z, strTrim, strTrim2);
    }

    public static String b(Object obj) {
        if (obj == null || JSONObject.NULL.equals(obj)) {
            return null;
        }
        if (obj instanceof Number) {
            return String.valueOf((long) Math.ceil(((Number) obj).doubleValue()));
        }
        String strTrim = obj.toString().trim();
        if (strTrim.isEmpty()) {
            return null;
        }
        try {
            return String.valueOf((long) Math.ceil(Double.parseDouble(strTrim)));
        } catch (NumberFormatException e) {
            int iIndexOf = strTrim.indexOf(46);
            return iIndexOf > 0 ? strTrim.substring(0, iIndexOf) : strTrim;
        }
    }

    public static String a(Object obj) {
        if (obj == null || JSONObject.NULL.equals(obj)) {
            return null;
        }
        if (obj instanceof Number) {
            double dDoubleValue = ((Number) obj).doubleValue();
            long jRound = Math.round(dDoubleValue);
            if (Math.abs(dDoubleValue - jRound) < 1.0E-6d) {
                return String.valueOf(jRound);
            }
            String strSubstring = String.format(Locale.US, "%.2f", Double.valueOf(dDoubleValue));
            while (strSubstring.endsWith("0")) {
                strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
            }
            return strSubstring.endsWith(".") ? strSubstring.substring(0, strSubstring.length() - 1) : strSubstring;
        }
        String strTrim = obj.toString().trim();
        if (strTrim.isEmpty()) {
            return null;
        }
        return strTrim;
    }
}
