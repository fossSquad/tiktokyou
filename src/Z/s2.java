package Z;

import com.vapro.vae.stringfog.StringFogRuntime;

public abstract  class s2 {
    public static String a(String str, String str2, String str3, StringBuilder sb) {
        return sb.append(StringFogRuntime.decrypt(str, str2, str3)).toString();
    }
}
