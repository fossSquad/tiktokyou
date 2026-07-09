package X;

public abstract class g8 {
    public static final String[] a = {"X.0Bn1", "X.0Bn2", "X.0Bn3", "X.0Bn4", "X.0Bn5", "X.0Bn6", "X.0Bn7", "X.0Bn8", "X.0Bn9", "X.0BnA", "X.0BnB", "X.0BnC"};

    public static void a(String str, String str2, String[] strArr) {
        if (strArr.length == 0) {
            throw new IllegalArgumentException(str + " mapping has no obfuscated name: " + str2);
        }
        String str3 = strArr[0];
    }
}
