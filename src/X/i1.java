package X;

import android.content.SharedPreferences;

public final class i1 {
    public static SharedPreferences l;
    public static i1 m;
    public boolean a = l.getBoolean("region_spoof_enabled", true);
    public int b = l.getInt("selected_region", 0);
    public boolean c = l.getBoolean("hide_lives", false);
    public boolean d = l.getBoolean("hide_ads", true);
    public boolean e = l.getBoolean("hide_photos", false);
    public boolean f;
    public String g;
    public boolean h;
    public boolean i;
    public int j;
    public boolean k;

    public i1() {
        l.getBoolean("anti_burnout", false);
        this.f = l.getBoolean("hide_stories", false);
        this.g = l.getString("selected_font", "default");
        this.h = l.getBoolean("always_show_progress_bar", false);
        this.i = l.getBoolean("custom_colors_enabled", false);
        this.j = l.getInt("accent_color", 0);
        l.getInt("feed_overlay_opacity", 100);
        this.k = l.getBoolean("comment_translation_enabled", false);
    }

    public static i1 a() {
        return m;
    }

    public final void b(int i) {
        this.b = i;
        l.edit().putInt("selected_region", i).apply();
    }

    public final void c(boolean z) {
        this.i = z;
        l.edit().putBoolean("custom_colors_enabled", z).apply();
    }

    public final void d(boolean z) {
        this.d = z;
        l.edit().putBoolean("hide_ads", z).apply();
    }

    public final void e(boolean z) {
        this.c = z;
        l.edit().putBoolean("hide_lives", z).apply();
    }

    public final void f(boolean z) {
        this.e = z;
        l.edit().putBoolean("hide_photos", z).apply();
    }

    public final void g(boolean z) {
        this.f = z;
        l.edit().putBoolean("hide_stories", z).apply();
    }

    public final void h(boolean z) {
        this.a = z;
        l.edit().putBoolean("region_spoof_enabled", z).apply();
    }

    public final void a(String str) {
        this.g = str;
        l.edit().putString("selected_font", str).apply();
    }

    public static boolean c() {
        boolean z = l.getBoolean("launched_first_time", true);
        l.edit().putBoolean("launched_first_time", false).apply();
        return z;
    }

    public final o1 b() {
        int i = this.b;
        if (i >= 0) {
            o1[] o1VarArr = p1.a;
            if (i < 6) {
                return o1VarArr[i];
            }
        }
        return p1.a[0];
    }

    public boolean d() {
        return this.i;
    }

    public final void a(boolean z) {
        this.h = z;
        l.edit().putBoolean("always_show_progress_bar", z).apply();
    }

    public final void a(int i) {
        this.j = i;
        l.edit().putInt("accent_color", i).apply();
    }

    public final void b(boolean z) {
        this.k = z;
        l.edit().putBoolean("comment_translation_enabled", z).apply();
    }
}
