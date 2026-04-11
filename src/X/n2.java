package X;

import android.content.res.Resources;
import de.robv.android.xposed.XposedBridge;
import java.util.Locale;
import java.util.TimeZone;

public abstract class n2 {
    public static final Locale a = new Locale("ru", "398");
    public static final TimeZone b;

    static {
        String id = TimeZone.getDefault().getID();
        if (id.contains("Europe/Kaliningrad")) {
            id = "Africa/Johannesburg";
        } else if (id.contains("Europe/Moscow")) {
            id = "Europe/Istanbul";
        } else if (id.contains("Europe/Samara") || id.contains("Europe/Saratov")) {
            id = "Asia/Dubai";
        } else if (id.contains("Asia/Yekaterinburg")) {
            id = "Asia/Karachi";
        } else if (id.contains("Asia/Omsk")) {
            id = "Asia/Dhaka";
        } else if (id.contains("Asia/Krasnoyarsk") || id.contains("Asia/Novosibirsk")) {
            id = "Asia/Jakarta";
        } else if (id.contains("Asia/Irkutsk")) {
            id = "Asia/Singapore";
        } else if (id.contains("Asia/Yakutsk") || id.contains("Asia/Chita")) {
            id = "Asia/Seoul";
        } else if (id.contains("Asia/Vladivostok")) {
            id = "Australia/Brisbane";
        } else if (id.contains("Asia/Magadan") || id.contains("Asia/Sakhalin")) {
            id = "Pacific/Noumea";
        } else if (id.contains("Asia/Kamchatka") || id.contains("Asia/Anadyr")) {
            id = "Pacific/Majuro";
        }
        b = TimeZone.getTimeZone(id);
    }

    public static void a() {
        if (Locale.getDefault().getLanguage().equals("ru")) {
            try {
                XposedBridge.hookMethod(TimeZone.class.getMethod("getDefault", null), new k2());
                XposedBridge.hookMethod(Locale.class.getMethod("getDefault", null), new l2());
                XposedBridge.hookMethod(Resources.class.getMethod("getConfiguration", null), new m2());
            } catch (Exception e) {
            }
        }
    }
}
