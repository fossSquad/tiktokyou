package a;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class h {
    public static void a(Context context, List list) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        String absolutePath = context.getFilesDir().getAbsolutePath();
        String absolutePath2 = context.getCacheDir().getAbsolutePath();
        String absolutePath3 = context.getNoBackupFilesDir().getAbsolutePath();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String strReplace = ((String) it.next()).replace("{filesDir}", absolutePath).replace("{cacheDir}", absolutePath2).replace("{noBackupFilesDir}", absolutePath3);
            Process processExec = Runtime.getRuntime().exec(strReplace);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Thread threadA = a(processExec.getInputStream(), byteArrayOutputStream);
            Thread threadA2 = a(processExec.getErrorStream(), byteArrayOutputStream);
            try {
                if (!processExec.waitFor(30L, TimeUnit.SECONDS)) {
                    processExec.destroyForcibly();
                    throw new IOException(new StringBuilder().append("Command timed out: ").append(strReplace).toString());
                }
                try {
                    threadA.join(1000L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                try {
                    threadA2.join(1000L);
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                }
                int iExitValue = processExec.exitValue();
                if (iExitValue != 0) {
                    String strTrim = new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8).trim();
                    throw new IOException("Command failed (" + iExitValue + "): " + strReplace + (strTrim.isEmpty() ? "" : "\n".concat(strTrim)));
                }
            } catch (InterruptedException e3) {
                processExec.destroyForcibly();
                Thread.currentThread().interrupt();
                throw new IOException("Command interrupted", e3);
            }
        }
    }

    public static  void b(InputStream inputStream, ByteArrayOutputStream byteArrayOutputStream) {
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    return;
                }
                int size = 65536 - byteArrayOutputStream.size();
                if (size > 0) {
                    byteArrayOutputStream.write(bArr, 0, Math.min(i, size));
                }
            } catch (IOException e) {
                return;
            }
        }
    }

    public static Thread a(final InputStream inputStream, final ByteArrayOutputStream byteArrayOutputStream) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public final void run() {
                h.b(inputStream, byteArrayOutputStream);
            }
        }, "tty-manifest-command");
        thread.setDaemon(true);
        thread.start();
        return thread;
    }
}
