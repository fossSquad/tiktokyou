package X;

import android.content.Context;
import android.content.SharedPreferences;

public final class y3 {
    public static final int o;
    public static SharedPreferences p;
    public static y3 q;
    public boolean a = p.getBoolean("region_spoof_enabled", true);
    public int b = p.getInt("selected_region", o);
    public boolean c = p.getBoolean("hide_lives", false);
    public boolean d = p.getBoolean("hide_ads", true);
    public boolean e = p.getBoolean("hide_photos", false);
    public boolean f;
    public String g;
    public boolean h;
    public boolean i;
    public int j;
    public boolean k;
    public String l;
    public String m;
    public String n;

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            f4[] f4VarArr = g4.a;
            if (i2 >= 203) {
                break;
            }
            f4 f4Var = f4VarArr[i2];
            if ("ua".equalsIgnoreCase(f4Var.c) || "region_ukraine".equals(f4Var.a)) {
                i = i2;
                break;
            }
            i2++;
        }
        o = i;
    }

    public y3() {
        p.getBoolean("anti_burnout", false);
        this.f = p.getBoolean("hide_stories", false);
        this.g = p.getString("selected_font", "default");
        this.h = p.getBoolean("always_show_progress_bar", false);
        this.i = p.getBoolean("custom_colors_enabled", false);
        this.j = p.getInt("accent_color", 0);
        p.getInt("feed_overlay_opacity", 100);
        p.getBoolean("comment_translation_enabled", false);
        this.k = p.getBoolean("auto_streak_nudge_enabled", true);
        this.l = p.getString("auto_streak_nudge_last_run_date", "");
        this.m = p.getString("spoofed_device_id", null);
        this.n = p.getString("random_android_id", null);
    }

    public static void a(Context context) {
        if (p == null) {
            p = context.getSharedPreferences("ttmod_settings", 0);
        }
        if (q == null) {
            q = new y3();
        }
    }

    public final void b(int i) {
        this.b = i;
        p.edit().putInt("selected_region", i).apply();
    }

    public final void c(boolean z) {
        this.i = z;
        p.edit().putBoolean("custom_colors_enabled", z).apply();
    }

    public final void d(boolean z) {
        this.d = z;
        p.edit().putBoolean("hide_ads", z).apply();
    }

    public final void e(boolean z) {
        this.c = z;
        p.edit().putBoolean("hide_lives", z).apply();
    }

    public final void f(boolean z) {
        this.e = z;
        p.edit().putBoolean("hide_photos", z).apply();
    }

    public final void g(boolean z) {
        this.f = z;
        p.edit().putBoolean("hide_stories", z).apply();
    }

    public final void h(boolean z) {
        this.a = z;
        p.edit().putBoolean("region_spoof_enabled", z).apply();
    }

    public static boolean c() {
        boolean z = p.getBoolean("launched_first_time", true);
        p.edit().putBoolean("launched_first_time", false).apply();
        return z;
    }

    public final f4 b() {
        int i = this.b;
        if (i >= 0) {
            f4[] f4VarArr = g4.a;
            if (i < 203) {
                return f4VarArr[i];
            }
        }
        return g4.a[o];
    }

    public boolean d() {
        return this.i;
    }

    public static y3 a() {
        return q;
    }

    public final void a(String str) {
        this.g = str;
        p.edit().putString("selected_font", str).apply();
    }

    public final void b(boolean z) {
        this.k = z;
        p.edit().putBoolean("auto_streak_nudge_enabled", z).apply();
    }

    public final void a(boolean z) {
        this.h = z;
        p.edit().putBoolean("always_show_progress_bar", z).apply();
    }

    public final void a(int i) {
        this.j = i;
        p.edit().putInt("accent_color", i).apply();
    }
}
