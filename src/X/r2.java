package X;

import android.content.Context;
import android.content.SharedPreferences;

public final class r2 {
    public static final int n;
    public static SharedPreferences o;
    public static r2 p;
    public boolean a = o.getBoolean("region_spoof_enabled", true);
    public int b = o.getInt("selected_region", n);
    public boolean c = o.getBoolean("hide_lives", false);
    public boolean d = o.getBoolean("hide_ads", true);
    public boolean e = o.getBoolean("hide_photos", false);
    public boolean f;
    public String g;
    public boolean h;
    public boolean i;
    public int j;
    public boolean k;
    public String l;
    public String m;

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            x2[] x2VarArr = y2.a;
            if (i2 >= 203) {
                break;
            }
            x2 x2Var = x2VarArr[i2];
            if ("ua".equalsIgnoreCase(x2Var.c) || "region_ukraine".equals(x2Var.a)) {
                i = i2;
                break;
            }
            i2++;
        }
        n = i;
    }

    public r2() {
        o.getBoolean("anti_burnout", false);
        this.f = o.getBoolean("hide_stories", false);
        this.g = o.getString("selected_font", "default");
        this.h = o.getBoolean("always_show_progress_bar", false);
        this.i = o.getBoolean("custom_colors_enabled", false);
        this.j = o.getInt("accent_color", 0);
        o.getInt("feed_overlay_opacity", 100);
        o.getBoolean("comment_translation_enabled", false);
        this.k = o.getBoolean("auto_streak_nudge_enabled", true);
        this.l = o.getString("auto_streak_nudge_last_run_date", "");
        this.m = o.getString("random_android_id", null);
    }

    public static void a(Context context) {
        if (o == null) {
            o = context.getSharedPreferences("ttmod_settings", 0);
        }
        if (p == null) {
            p = new r2();
        }
    }

    public final void b(int i) {
        this.b = i;
        o.edit().putInt("selected_region", i).apply();
    }

    public final void c(boolean z) {
        this.i = z;
        o.edit().putBoolean("custom_colors_enabled", z).apply();
    }

    public final void d(boolean z) {
        this.d = z;
        o.edit().putBoolean("hide_ads", z).apply();
    }

    public final void e(boolean z) {
        this.c = z;
        o.edit().putBoolean("hide_lives", z).apply();
    }

    public final void f(boolean z) {
        this.e = z;
        o.edit().putBoolean("hide_photos", z).apply();
    }

    public final void g(boolean z) {
        this.f = z;
        o.edit().putBoolean("hide_stories", z).apply();
    }

    public final void h(boolean z) {
        this.a = z;
        o.edit().putBoolean("region_spoof_enabled", z).apply();
    }

    public static boolean c() {
        boolean z = o.getBoolean("launched_first_time", true);
        o.edit().putBoolean("launched_first_time", false).apply();
        return z;
    }

    public final x2 b() {
        int i = this.b;
        if (i >= 0) {
            x2[] x2VarArr = y2.a;
            if (i < 203) {
                return x2VarArr[i];
            }
        }
        return y2.a[n];
    }

    public boolean d() {
        return this.i;
    }

    public static r2 a() {
        return p;
    }

    public final void a(boolean z) {
        this.h = z;
        o.edit().putBoolean("always_show_progress_bar", z).apply();
    }

    public final void b(String str) {
        this.g = str;
        o.edit().putString("selected_font", str).apply();
    }

    public final void a(int i) {
        this.j = i;
        o.edit().putInt("accent_color", i).apply();
    }

    public final void b(boolean z) {
        this.k = z;
        o.edit().putBoolean("auto_streak_nudge_enabled", z).apply();
    }

    public final void a(String str) {
        this.m = str;
        o.edit().putString("random_android_id", str).apply();
    }
}
