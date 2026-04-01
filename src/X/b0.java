package X;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b0 implements Thread.UncaughtExceptionHandler {
    public static final AtomicBoolean c = new AtomicBoolean(false);
    public static final AtomicBoolean d = new AtomicBoolean(false);
    public final Context a;
    public final Thread.UncaughtExceptionHandler b;

    public b0(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = context;
        this.b = uncaughtExceptionHandler;
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

    @Override
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            if (d.compareAndSet(false, true)) {
                String strA = a(thread, th);
                a(strA);
                ClipboardManager clipboardManager = (ClipboardManager) this.a.getSystemService("clipboard");
                if (clipboardManager != null) {
                    clipboardManager.setPrimaryClip(ClipData.newPlainText("ttmod_java_crash", strA));
                }
            }
        } catch (Throwable th2) {
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
            System.exit(10);
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
        sb.append(Process.myPid()).append("\nversion=v1.4 (");
        sb.append(r1.b).append(")\nandroid=");
        sb.append(Build.VERSION.RELEASE).append(" sdk=").append(Build.VERSION.SDK_INT).append("\ndevice=");
        sb.append(Build.MANUFACTURER).append(' ').append(Build.MODEL).append("\n\n");
        sb.append(stringWriter);
        return sb.toString();
    }
}
