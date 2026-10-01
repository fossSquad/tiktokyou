package Z;

import android.content.ClipboardManager;
import com.windukk.hook.HookBridge;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.SetsKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.text.MatchResult;
import ni.shikatu.kotlin.text.Regex;
import ni.shikatu.kotlin.text.RegexOption;
import ni.shikatu.kotlin.text.StringsKt;

public abstract class CleanLinkHooks {
    public static final Regex a = new Regex("https?://[^\\s\\\"'<>]+", RegexOption.IGNORE_CASE);
    public static final Set b = SetsKt.setOf(new String[]{"_r", "_t", "share_item_id", "share_link_id", "share_app_id", "timestamp", "tt_from", "u_code", "ug_btm", "user_id", "source", "utm_source", "utm_medium", "utm_campaign", "enter_from", "enter_method", "iid", "device_id", "region", "sec_user_id", "did", "aid", "web_id", "webid", "mstoken", "share_scene", "share_uid", "share_author_id"});

    public static final void a() {
        HookBridge.hookAllMethods(ClipboardManager.class, "setPrimaryClip", new CleanLinkHooks$init$1());
    }

    public static String a(String str) {
        return a.replace(str, new Function1() {
            public final Object invoke(Object obj) {
                return CleanLinkHooks.a((MatchResult) obj);
            }
        });
    }

    public static final CharSequence a(MatchResult matchResult) {
        String value = matchResult.getValue();
        if (!new Regex("https?://[^/]*?(tiktok\\.com|tiktokv\\.com|douyin\\.com|musical\\.ly)", RegexOption.IGNORE_CASE).containsMatchIn(value)) {
            return value;
        }
        String strSubstringBefore$default = StringsKt.substringBefore$default(value, '?', (String) null, 2, (Object) null);
        String strSubstringAfter = StringsKt.substringAfter(value, '?', "");
        if (strSubstringAfter.length() == 0) {
            return value;
        }
        List listSplit$default = StringsKt.split$default(StringsKt.substringBefore$default(strSubstringAfter, '#', (String) null, 2, (Object) null), new char[]{'&'}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listSplit$default) {
            Set set = b;
            String lowerCase = StringsKt.substringBefore$default((String) obj, '=', (String) null, 2, (Object) null).toLowerCase(Locale.ROOT);
            if (!set.contains(lowerCase)) {
                arrayList.add(obj);
            }
        }
        return strSubstringBefore$default + CollectionsKt.joinToString$default(arrayList, "&", "?", (CharSequence) null, 0, (CharSequence) null, (Function1) null, 60, (Object) null) + (StringsKt.contains$default(strSubstringAfter, '#', false, 2, (Object) null) ? "#" + StringsKt.substringAfter$default(strSubstringAfter, '#', (String) null, 2, (Object) null) : "");
    }
}
