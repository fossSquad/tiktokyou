package X;

public final class C1AjY {
    public static C1AjZ LIZ(C1Ajl c1Ajl) {
        return new C1AjZ(c1Ajl, 0, "");
    }

    public static C1AjZ LIZIZ(C1Ajl c1Ajl, int i, String str) {
        if (i < 0) {
            return new C1AjZ(c1Ajl, i, str);
        }
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("Error code must be negative, got ");
        sbLIZ.append(i);
        String strLIZIZ = 0wS0.LIZIZ(sbLIZ);
        strLIZIZ.toString();
        throw new IllegalArgumentException(strLIZIZ);
    }
}
