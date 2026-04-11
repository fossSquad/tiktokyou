package X;

import java.util.concurrent.ThreadLocalRandom;

public abstract class a1 {
    public static String a(String str) {
        String str2 = str;
        for (int i = 0; i < 8 && str2.equals(str); i++) {
            str2 = String.format("%04d", Integer.valueOf(ThreadLocalRandom.current().nextInt(10000)));
        }
        return str2.equals(str) ? String.format("%04d", Integer.valueOf((Integer.parseInt(str) + 1) % 10000)) : str2;
    }
}
