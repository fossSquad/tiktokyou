package X;

import android.content.SharedPreferences;

public final class t1 {
    public static SharedPreferences m;
    public static t1 n;
    public boolean a = m.getBoolean("region_spoof_enabled", true);
    public int b = m.getInt("selected_region", 0);
    public boolean c = m.getBoolean("hide_lives", false);
    public boolean d = m.getBoolean("hide_ads", true);
    public boolean e = m.getBoolean("hide_photos", false);
    public boolean f;
    public String g;
    public boolean h;
    public boolean i;
    public int j;
    public boolean k;
    public String l;

    public t1() {
        m.getBoolean("anti_burnout", false);
        this.f = m.getBoolean("hide_stories", false);
        this.g = m.getString("selected_font", "default");
        this.h = m.getBoolean("always_show_progress_bar", false);
        this.i = m.getBoolean("custom_colors_enabled", false);
        this.j = m.getInt("accent_color", 0);
        m.getInt("feed_overlay_opacity", 100);
        m.getBoolean("comment_translation_enabled", false);
        this.k = m.getBoolean("auto_streak_nudge_enabled", true);
        this.l = m.getString("auto_streak_nudge_last_run_date", "");
    }

    public static t1 a() {
        return n;
    }

    public final void b(int i) {
        this.b = i;
        m.edit().putInt("selected_region", i).apply();
    }

    public final void c(boolean z) {
        this.i = z;
        m.edit().putBoolean("custom_colors_enabled", z).apply();
    }

    public final void d(boolean z) {
        this.d = z;
        m.edit().putBoolean("hide_ads", z).apply();
    }

    public final void e(boolean z) {
        this.c = z;
        m.edit().putBoolean("hide_lives", z).apply();
    }

    public final void f(boolean z) {
        this.e = z;
        m.edit().putBoolean("hide_photos", z).apply();
    }

    public final void g(boolean z) {
        this.f = z;
        m.edit().putBoolean("hide_stories", z).apply();
    }

    public final void h(boolean z) {
        this.a = z;
        m.edit().putBoolean("region_spoof_enabled", z).apply();
    }

    public final void a(String str) {
        this.g = str;
        m.edit().putString("selected_font", str).apply();
    }

    public static boolean c() {
        boolean z = m.getBoolean("launched_first_time", true);
        m.edit().putBoolean("launched_first_time", false).apply();
        return z;
    }

    public final z1 b() {
        int i = this.b;
        if (i >= 0) {
            z1[] z1VarArr = a2.a;
            if (i < 6) {
                return z1VarArr[i];
            }
        }
        return a2.a[0];
    }

    public boolean d() {
        return this.i;
    }

    public final void a(boolean z) {
        this.h = z;
        m.edit().putBoolean("always_show_progress_bar", z).apply();
    }

    public final void a(int i) {
        this.j = i;
        m.edit().putInt("accent_color", i).apply();
    }

    public final void b(boolean z) {
        this.k = z;
        m.edit().putBoolean("auto_streak_nudge_enabled", z).apply();
    }
}
