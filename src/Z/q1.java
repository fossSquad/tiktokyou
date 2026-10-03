package Z;

public abstract class q1 {
    static {
    }

    public static boolean a(String str) {
        if (str != null) {
            return str.startsWith("https://") || str.startsWith("http://");
        }
        return false;
    }

    public static String b(String str) {
        if (str == null || str.isEmpty()) {
            return "asset:supporter.png";
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return "asset:supporter.png";
        }
        return (a(strTrim) || strTrim.startsWith("asset:")) ? strTrim : new StringBuilder().append("asset:").append(strTrim).toString();
    }
}
