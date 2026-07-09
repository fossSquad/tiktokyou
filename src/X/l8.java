package X;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;

public final class l8 {
    public static final int A;
    public static SharedPreferences B;
    public static l8 C;
    public int a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public String i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public boolean n;
    public int o;
    public int p;
    public String q;
    public boolean r;
    public String s;
    public boolean t;
    public String u;
    public String v;
    public LinkedHashSet w;
    public long x;
    public long y;
    public long z;

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            ia[] iaVarArr = ja.a;
            if (i2 >= 202) {
                break;
            }
            ia iaVar = iaVarArr[i2];
            if ("ua".equalsIgnoreCase(iaVar.c) || "region_ukraine".equals(iaVar.a)) {
                i = i2;
                break;
            }
            i2++;
        }
        A = i;
    }

    public l8() {
        B.getBoolean("region_spoof_enabled", true);
        this.a = B.getInt("selected_region", A);
        this.b = B.getBoolean("hide_lives", false);
        this.c = B.getBoolean("hide_ads", true);
        this.d = B.getBoolean("hide_photos", false);
        this.e = B.getBoolean("anti_burnout", false);
        this.f = B.getBoolean("anti_burnout_show_on_main", true);
        this.g = B.getBoolean("anti_burnout_enable_on_start", false);
        this.h = B.getBoolean("hide_stories", false);
        this.i = B.getString("selected_font", "default");
        this.j = B.getBoolean("always_show_progress_bar", false);
        this.k = B.getBoolean("custom_colors_enabled", false);
        this.l = B.getInt("accent_color", 0);
        int i = 100;
        int i2 = B.getInt("feed_overlay_transparency", 100);
        if (i2 < 0) {
            i = 0;
        } else if (i2 <= 100) {
            i = i2;
        }
        this.m = i;
        B.getBoolean("comment_translation_enabled", false);
        this.n = B.getBoolean("auto_streak_nudge_enabled", true);
        int i3 = 12;
        int i4 = B.getInt("auto_streak_nudge_hour", 12);
        if (i4 >= 0 && i4 <= 23) {
            i3 = i4;
        }
        this.o = i3;
        int i5 = B.getInt("auto_streak_nudge_minute", 0);
        this.p = (i5 < 0 || i5 > 59) ? 0 : i5;
        this.q = B.getString("auto_streak_nudge_last_run_date", "");
        this.r = B.getBoolean("rainbow_mode_enabled", false);
        this.s = B.getString("launcher_icon", "default");
        this.t = B.getBoolean("skip_quality_picker", false);
        this.u = B.getString("spoofed_device_id", null);
        this.v = B.getString("random_android_id", null);
        this.w = new LinkedHashSet(B.getStringSet("hide_by_words_filter", Collections.EMPTY_SET));
        this.x = B.getLong("hide_by_likes", 0L);
        this.y = B.getLong("hide_by_views", 0L);
        this.z = B.getLong("hide_by_publish_date", 0L);
    }

    public static void a(Context context) {
        if (B == null) {
            B = context.getSharedPreferences("ttmod_settings", 0);
        }
        if (C == null) {
            C = new l8();
        }
    }

    public final ia b() {
        int i = this.a;
        if (i >= 0) {
            ia[] iaVarArr = ja.a;
            if (i < 202) {
                return iaVarArr[i];
            }
        }
        return ja.a[A];
    }

    public final void c(int i) {
        this.a = i;
        B.edit().putInt("selected_region", i).apply();
    }

    public final void d(boolean z) {
        this.f = z;
        B.edit().putBoolean("anti_burnout_show_on_main", z).apply();
    }

    public final void e(boolean z) {
        this.n = z;
        B.edit().putBoolean("auto_streak_nudge_enabled", z).apply();
    }

    public final void f(boolean z) {
        this.k = z;
        B.edit().putBoolean("custom_colors_enabled", z).apply();
    }

    public final void g(boolean z) {
        this.c = z;
        B.edit().putBoolean("hide_ads", z).apply();
    }

    public final void h(boolean z) {
        this.b = z;
        B.edit().putBoolean("hide_lives", z).apply();
    }

    public final void i(boolean z) {
        this.d = z;
        B.edit().putBoolean("hide_photos", z).apply();
    }

    public final void j(boolean z) {
        this.h = z;
        B.edit().putBoolean("hide_stories", z).apply();
    }

    public final void k(boolean z) {
        this.r = z;
        B.edit().putBoolean("rainbow_mode_enabled", z).apply();
    }

    public final void l(boolean z) {
        this.t = z;
        B.edit().putBoolean("skip_quality_picker", z).apply();
    }

    public final void c(boolean z) {
        this.e = z;
        B.edit().putBoolean("anti_burnout", z).apply();
    }

    public boolean d() {
        return this.k;
    }

    public static boolean c() {
        boolean z = B.getBoolean("launched_first_time", true);
        B.edit().putBoolean("launched_first_time", false).apply();
        return z;
    }

    public final void b(boolean z) {
        this.g = z;
        B.edit().putBoolean("anti_burnout_enable_on_start", z).apply();
    }

    public static l8 a() {
        return C;
    }

    public final void a(boolean z) {
        this.j = z;
        B.edit().putBoolean("always_show_progress_bar", z).apply();
    }

    public final void b(String str) {
        this.i = str;
        B.edit().putString("selected_font", str).apply();
    }

    public final void c(long j) {
        this.y = j;
        B.edit().putLong("hide_by_views", this.y).apply();
    }

    public final void a(int i) {
        this.l = i;
        B.edit().putInt("accent_color", i).apply();
    }

    public final void b(int i) {
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        this.m = i;
        B.edit().putInt("feed_overlay_transparency", this.m).apply();
    }

    public final void a(int i, int i2) {
        if (i < 0 || i > 23) {
            i = 12;
        }
        this.o = i;
        if (i2 < 0 || i2 > 59) {
            i2 = 0;
        }
        this.p = i2;
        B.edit().putInt("auto_streak_nudge_hour", this.o).putInt("auto_streak_nudge_minute", this.p).apply();
    }

    public final void b(long j) {
        this.z = j;
        B.edit().putLong("hide_by_publish_date", this.z).apply();
    }

    public final void a(String str) {
        if (str.isEmpty()) {
            str = "default";
        }
        this.s = str;
        B.edit().putString("launcher_icon", this.s).apply();
    }

    public final void a(LinkedHashSet linkedHashSet) {
        this.w = new LinkedHashSet(linkedHashSet);
        B.edit().putStringSet("hide_by_words_filter", new HashSet(this.w)).apply();
    }

    public final void a(long j) {
        this.x = j;
        B.edit().putLong("hide_by_likes", this.x).apply();
    }
}
