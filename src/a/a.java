package a;

import com.vapro.vae.stringfog.StringFogRuntime;

public abstract  class a {
    public static String a(String str, String str2, String str3, StringBuilder sb, String str4) {
        return sb.append(StringFogRuntime.decrypt(str, str2, str3)).append(str4).toString();
    }
}
