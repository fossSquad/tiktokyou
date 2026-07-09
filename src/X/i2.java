package X;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.util.concurrent.atomic.AtomicBoolean;

public final class i2 implements Thread.UncaughtExceptionHandler {
    public static final AtomicBoolean c = new AtomicBoolean(false);
    public static final AtomicBoolean d = new AtomicBoolean(false);
    public static final AtomicBoolean e = new AtomicBoolean(false);
    public static volatile WeakReference f = new WeakReference(null);
    public final Context a;
    public final Thread.UncaughtExceptionHandler b;

    public i2(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = context;
        this.b = uncaughtExceptionHandler;
    }

    public static LinearLayout a(final Activity activity, final String str, final File file, final Dialog dialog) {
        int iA = (int) g2.a(activity, 1, 20.0f);
        boolean z = (activity.getResources().getConfiguration().uiMode & 48) == 32;
        int color = z ? Color.parseColor("#161616") : -1;
        int i = z ? -1 : -16777216;
        int color2 = Color.parseColor(z ? "#B0B0B0" : "#666666");
        int i2 = z ? -1 : -16777216;
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(iA, iA, iA, iA);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius((int) TypedValue.applyDimension(1, 18.0f, activity.getResources().getDisplayMetrics()));
        linearLayout.setBackground(gradientDrawable);
        TextView textView = new TextView(activity);
        textView.setText("TikTok You crash report");
        textView.setTextColor(i);
        textView.setTextSize(2, 22.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        linearLayout.addView(textView);
        TextView textView2 = new TextView(activity);
        textView2.setText("Прошлый запуск упал. Лог сохранен ниже, его можно выделить вручную или скопировать кнопкой.");
        textView2.setTextColor(color2);
        textView2.setTextSize(2, 14.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = (int) g2.a(activity, 1, 8.0f);
        linearLayout.addView(textView2, layoutParams);
        TextView textView3 = new TextView(activity);
        textView3.setText(str);
        textView3.setTextColor(i);
        textView3.setTextSize(2, 12.0f);
        textView3.setTypeface(Typeface.MONOSPACE);
        textView3.setTextIsSelectable(true);
        textView3.setPadding((int) TypedValue.applyDimension(1, 12.0f, activity.getResources().getDisplayMetrics()), (int) g2.a(activity, 1, 12.0f), (int) g2.a(activity, 1, 12.0f), (int) g2.a(activity, 1, 12.0f));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor(z ? "#0B0B0B" : "#F2F2F2"));
        gradientDrawable2.setCornerRadius((int) TypedValue.applyDimension(1, 12.0f, activity.getResources().getDisplayMetrics()));
        textView3.setBackground(gradientDrawable2);
        ScrollView scrollView = new ScrollView(activity);
        scrollView.addView(textView3, new FrameLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, (int) g2.a(activity, 1, 320.0f));
        layoutParams2.topMargin = (int) g2.a(activity, 1, 14.0f);
        linearLayout.addView(scrollView, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = (int) g2.a(activity, 1, 16.0f);
        linearLayout.addView(linearLayout2, layoutParams3);
        int i3 = i2;
        linearLayout2.addView(a(activity, "ic_close", R.drawable.ic_menu_close_clear_cancel, i3, z, 6, "Закрыть", new Runnable() {
            @Override
            public final void run() {
                i2.a(file, dialog);
            }
        }));
        linearLayout2.addView(a(activity, "ic_copy", R.drawable.ic_menu_save, i3, z, 10, "Скопировать", new Runnable() {
            @Override
            public final void run() {
                i2.b(activity, str, file, dialog);
            }
        }));
        return linearLayout;
    }

    public static void b(Activity activity, String str, File file, Dialog dialog) {
        try {
            ClipboardManager clipboardManager = (ClipboardManager) activity.getSystemService("clipboard");
            if (clipboardManager == null) {
                return;
            }
            clipboardManager.setPrimaryClip(ClipData.newPlainText("tiktok_you_java_crash", str));
            a(file);
            Toast.makeText(activity, "Crash report скопирован", 0).show();
            dialog.dismiss();
        } catch (Throwable th) {
            Log.w("TikTokYou-CrashHandler", "Failed to copy crash report from dialog", th);
            Toast.makeText(activity, "Не удалось скопировать crash report", 0).show();
        }
    }

    @Override
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            if (c.compareAndSet(false, true)) {
                String strA = a(thread, th);
                a(strA);
                a();
                ClipboardManager clipboardManager = (ClipboardManager) this.a.getSystemService("clipboard");
                if (clipboardManager != null) {
                    try {
                        clipboardManager.setPrimaryClip(ClipData.newPlainText("tiktok_you_java_crash", strA));
                    } catch (Throwable th2) {
                        Log.w("TikTokYou-CrashHandler", "Failed to copy crash report to clipboard", th2);
                    }
                }
            }
        } catch (Throwable th3) {
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
            System.exit(10);
        }
    }

    public static void a(ContextWrapper contextWrapper) {
        if (contextWrapper == null) {
            return;
        }
        synchronized (i2.class) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (!(defaultUncaughtExceptionHandler instanceof i2)) {
                Context applicationContext = contextWrapper.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = contextWrapper;
                }
                Thread.setDefaultUncaughtExceptionHandler(new i2(applicationContext, defaultUncaughtExceptionHandler));
            }
        }
        a((Context) contextWrapper);
    }

    public final void a(String str) throws IOException {
        File file = new File(this.a.getFilesDir(), "ttmod_crash");
        if (file.exists() || file.mkdirs()) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, "last_java_crash.txt"), false);
            try {
                fileOutputStream.write(bytes);
                fileOutputStream.close();
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file, "java_crash_" + System.currentTimeMillis() + ".txt"), false);
                try {
                    fileOutputStream2.write(bytes);
                    fileOutputStream2.close();
                } catch (Throwable th) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        }
    }

    public static void a(Context context) {
        Application application;
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        if (applicationContext instanceof Application) {
            application = (Application) applicationContext;
        } else if (context instanceof Application) {
            application = (Application) context;
        } else {
            application = g5.c;
            if (application == null) {
                application = null;
            }
        }
        if (application == null) {
            Log.w("TikTokYou-CrashHandler", "Cannot register crash report dialog: Application context is unavailable");
        } else if (d.compareAndSet(false, true)) {
            application.registerActivityLifecycleCallbacks(new h2());
        }
    }

    public static String a(Thread thread, Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        StringBuilder sb = new StringBuilder(2048);
        sb.append("time=").append(ZonedDateTime.now()).append("\nthread=");
        sb.append(thread != null ? thread.getName() : "unknown").append("\npid=");
        sb.append(Process.myPid()).append("\nversion=v3.4 (");
        sb.append(g5.a).append(")\nandroid=");
        sb.append(Build.VERSION.RELEASE).append(" sdk=").append(Build.VERSION.SDK_INT).append("\ndevice=");
        sb.append(Build.MANUFACTURER).append(' ').append(Build.MODEL).append("\n\n");
        sb.append(stringWriter);
        return sb.toString();
    }

    public final void a() {
        try {
            File file = new File(this.a.getFilesDir(), "ttmod_crash");
            if (file.exists() || file.mkdirs()) {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(file, "pending_clipboard_copy"), false);
                try {
                    fileOutputStream.write(Long.toString(System.currentTimeMillis()).getBytes(StandardCharsets.UTF_8));
                    fileOutputStream.close();
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            Log.w("TikTokYou-CrashHandler", "Failed to mark crash report for clipboard copy", th3);
        }
    }

    public static void a(Activity activity) {
        String str;
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        AtomicBoolean atomicBoolean = e;
        if (atomicBoolean.compareAndSet(false, true)) {
            Context applicationContext = activity.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = activity;
            }
            File file = new File(new File(applicationContext.getFilesDir(), "ttmod_crash"), "pending_clipboard_copy");
            if (!file.isFile()) {
                atomicBoolean.set(false);
                return;
            }
            File file2 = new File(new File(applicationContext.getFilesDir(), "ttmod_crash"), "last_java_crash.txt");
            if (!file2.isFile()) {
                a(file);
                atomicBoolean.set(false);
                return;
            }
            try {
                long length = file2.length();
                if (length > 0 && length <= 2147483647L) {
                    int i = (int) length;
                    byte[] bArr = new byte[i];
                    FileInputStream fileInputStream = new FileInputStream(file2);
                    int i2 = 0;
                    while (i2 < i) {
                        try {
                            int i3 = fileInputStream.read(bArr, i2, i - i2);
                            if (i3 < 0) {
                                break;
                            } else {
                                i2 += i3;
                            }
                        } catch (Throwable th) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    fileInputStream.close();
                    str = new String(bArr, 0, i2, StandardCharsets.UTF_8);
                } else {
                    str = "";
                }
                Dialog dialog = new Dialog(activity);
                dialog.requestWindowFeature(1);
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public final void onDismiss(DialogInterface dialogInterface) {
                        i2.e.set(false);
                    }
                });
                dialog.setContentView(a(activity, str, file, dialog));
                dialog.show();
                Window window = dialog.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                    window.setLayout(-1, -2);
                }
            } catch (Throwable th3) {
                e.set(false);
                Log.w("TikTokYou-CrashHandler", "Failed to show pending crash report dialog", th3);
            }
        }
    }

    public static  void a(File file, Dialog dialog) {
        a(file);
        dialog.dismiss();
    }

    public static ImageButton a(Activity activity, String str, int i, int i2, boolean z, int i3, String str2, final Runnable runnable) {
        ImageButton imageButton = new ImageButton(activity);
        Bitmap bitmapA = vb.a(activity, str);
        if (bitmapA != null) {
            imageButton.setImageBitmap(bitmapA);
        } else {
            imageButton.setImageResource(i);
        }
        imageButton.setColorFilter(i2);
        imageButton.setScaleType(ImageView.ScaleType.CENTER);
        imageButton.setMinimumWidth(0);
        imageButton.setMinimumHeight(0);
        int iA = (int) g2.a(activity, 1, i3);
        imageButton.setPadding(iA, iA, iA, iA);
        imageButton.setContentDescription(str2);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                runnable.run();
            }
        });
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(z ? "#2A2A2A" : "#EFEFEF"));
        gradientDrawable.setCornerRadius((int) TypedValue.applyDimension(1, 14.0f, activity.getResources().getDisplayMetrics()));
        imageButton.setBackground(gradientDrawable);
        float f2 = 44;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) g2.a(activity, 1, f2), (int) g2.a(activity, 1, f2));
        layoutParams.leftMargin = (int) g2.a(activity, 1, 8.0f);
        imageButton.setLayoutParams(layoutParams);
        return imageButton;
    }

    public static void a(File file) {
        if (file != null) {
            try {
                if (!file.exists() || file.delete()) {
                    return;
                }
                Log.w("TikTokYou-CrashHandler", "Failed to delete " + file.getAbsolutePath());
            } catch (Throwable th) {
            }
        }
    }
}
