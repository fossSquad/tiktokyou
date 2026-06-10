package X;

import android.content.Context;
import android.content.SharedPreferences;

public final class d7 {
    public static final int t;
    public static SharedPreferences u;
    public static d7 v;
    public boolean a = u.getBoolean("region_spoof_enabled", true);
    public int b = u.getInt("selected_region", t);
    public boolean c = u.getBoolean("hide_lives", false);
    public boolean d = u.getBoolean("hide_ads", true);
    public boolean e = u.getBoolean("hide_photos", false);
    public boolean f = u.getBoolean("anti_burnout", false);
    public boolean g = u.getBoolean("hide_stories", false);
    public String h = u.getString("selected_font", "default");
    public boolean i = u.getBoolean("always_show_progress_bar", false);
    public boolean j = u.getBoolean("custom_colors_enabled", false);
    public int k = u.getInt("accent_color", 0);
    public int l;
    public boolean m;
    public int n;
    public int o;
    public String p;
    public boolean q;
    public String r;
    public String s;

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            h8[] h8VarArr = i8.a;
            if (i2 >= 202) {
                break;
            }
            h8 h8Var = h8VarArr[i2];
            if ("ua".equalsIgnoreCase(h8Var.c) || "region_ukraine".equals(h8Var.a)) {
                i = i2;
                break;
            }
            i2++;
        }
        t = i;
    }

    public d7() {
        int i = u.getInt("feed_overlay_opacity", 0);
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        this.l = i;
        u.getBoolean("comment_translation_enabled", false);
        this.m = u.getBoolean("auto_streak_nudge_enabled", true);
        int i2 = 12;
        int i3 = u.getInt("auto_streak_nudge_hour", 12);
        if (i3 >= 0 && i3 <= 23) {
            i2 = i3;
        }
        this.n = i2;
        int i4 = u.getInt("auto_streak_nudge_minute", 0);
        this.o = (i4 < 0 || i4 > 59) ? 0 : i4;
        this.p = u.getString("auto_streak_nudge_last_run_date", "");
        this.q = u.getBoolean("rainbow_mode_enabled", false);
        this.r = u.getString("spoofed_device_id", null);
        this.s = u.getString("random_android_id", null);
    }

    public static void a(Context context) {
        if (u == null) {
            u = context.getSharedPreferences("ttmod_settings", 0);
        }
        if (v == null) {
            v = new d7();
        }
    }

    public final h8 b() {
        int i = this.b;
        if (i >= 0) {
            h8[] h8VarArr = i8.a;
            if (i < 202) {
                return h8VarArr[i];
            }
        }
        return i8.a[t];
    }

    public final void c(int i) {
        this.b = i;
        u.edit().putInt("selected_region", i).apply();
    }

    public boolean d() {
        return this.j;
    }

    public final void e(boolean z) {
        this.d = z;
        u.edit().putBoolean("hide_ads", z).apply();
    }

    public final void f(boolean z) {
        this.c = z;
        u.edit().putBoolean("hide_lives", z).apply();
    }

    public final void g(boolean z) {
        this.e = z;
        u.edit().putBoolean("hide_photos", z).apply();
    }

    public final void h(boolean z) {
        this.g = z;
        u.edit().putBoolean("hide_stories", z).apply();
    }

    public final void i(boolean z) {
        this.q = z;
        u.edit().putBoolean("rainbow_mode_enabled", z).apply();
    }

    public final void j(boolean z) {
        this.a = z;
        u.edit().putBoolean("region_spoof_enabled", z).apply();
    }

    public final void d(boolean z) {
        this.j = z;
        u.edit().putBoolean("custom_colors_enabled", z).apply();
    }

    public final void c(boolean z) {
        this.m = z;
        u.edit().putBoolean("auto_streak_nudge_enabled", z).apply();
    }

    public static boolean c() {
        boolean z = u.getBoolean("launched_first_time", true);
        u.edit().putBoolean("launched_first_time", false).apply();
        return z;
    }

    public final void b(boolean z) {
        this.f = z;
        u.edit().putBoolean("anti_burnout", z).apply();
    }

    public static d7 a() {
        return v;
    }

    public final void a(String str) {
        this.h = str;
        u.edit().putString("selected_font", str).apply();
    }

    public final void b(int i) {
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        this.l = i;
        u.edit().putInt("feed_overlay_opacity", this.l).apply();
    }

    public final void a(boolean z) {
        this.i = z;
        u.edit().putBoolean("always_show_progress_bar", z).apply();
    }

    public final void a(int i) {
        this.k = i;
        u.edit().putInt("accent_color", i).apply();
    }

    public final void a(int i, int i2) {
        if (i < 0 || i > 23) {
            i = 12;
        }
        this.n = i;
        if (i2 < 0 || i2 > 59) {
            i2 = 0;
        }
        this.o = i2;
        u.edit().putInt("auto_streak_nudge_hour", this.n).putInt("auto_streak_nudge_minute", this.o).apply();
    }
}
