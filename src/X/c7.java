package X;

public abstract class c7 {
    public static final String[] a = {"X.0BH1", "X.0BH2", "X.0BH3", "X.0BH4", "X.0BH5", "X.0BH6", "X.0BH7", "X.0BH8", "X.0BH9", "X.0BHA", "X.0BHB", "X.0BHC"};

    public static void a(String str, String str2, String[] strArr) {
        if (strArr.length == 0) {
            throw new IllegalArgumentException(str + " mapping has no obfuscated name: " + str2);
        }
        String str3 = strArr[0];
    }
}
