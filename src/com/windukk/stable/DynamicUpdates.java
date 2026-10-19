package com.windukk.stable;

import a.d;
import a.g;
import a.h;
import android.content.Context;
import android.net.Uri;
import c.b;
import c.e;
import c.f;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class DynamicUpdates {
    public static final long MAX_PACKAGE_BYTES = 201326592;

    public static void a(final Context context, g gVar, File file) {
        File fileC = gVar.c();
        try {
            final e eVarA = f.a(file, fileC, "release", a(context));
            gVar.a(fileC, eVarA.a.b, new d() {
                public final void run() {
                    h.a(context, eVarA.a.f);
                }
            });
        } catch (Throwable th) {
            g.c(fileC);
            throw th;
        }
    }

    public static DynamicStatus getStatus(Context context) {
        return new g(context).o();
    }

    public static long highestAcceptedVersion(Context context) {
        return new g(context).g();
    }

    public static void importFile(Context context, Uri uri) throws IOException {
        File fileCreateTempFile = File.createTempFile("tty-dynamic-import-", ".tmp", context.getCacheDir());
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            try {
                if (inputStreamOpenInputStream == null) {
                    throw new IOException("Cannot open selected file");
                }
                a(inputStreamOpenInputStream, fileCreateTempFile);
                inputStreamOpenInputStream.close();
                importPackage(context, fileCreateTempFile);
                fileCreateTempFile.delete();
            } catch (Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            fileCreateTempFile.delete();
            throw th3;
        }
    }

    public static void importPackage(Context context, File file) throws IOException {
        if (file == null || !file.isFile()) {
            throw new IOException("Package does not exist");
        }
        g gVar = new g(context);
        boolean z = false;
        if (file.length() >= 4) {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                if (fileInputStream.read() == 100 && fileInputStream.read() == 101 && fileInputStream.read() == 120 && fileInputStream.read() == 10) {
                    z = true;
                }
                fileInputStream.close();
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (z) {
            throw new IOException("Raw dex import is disabled in release builds");
        }
        a(context, gVar, file);
    }

    public static long otaVersionFloor(Context context) {
        long jG;
        g gVar = new g(context);
        synchronized (gVar) {
            jG = gVar.g();
            if (jG > 0 && gVar.a(jG)) {
                jG--;
            }
        }
        return jG;
    }

    public static void preview(Context context, Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
        try {
            if (inputStreamOpenInputStream == null) {
                throw new IOException("Cannot open selected file");
            }
            b bVarA = f.a(inputStreamOpenInputStream);
            f.a(bVarA, "release");
            new g(context).b(bVarA.b);
            inputStreamOpenInputStream.close();
        } catch (Throwable th) {
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static void scheduleBundled(Context context) {
        g gVar = new g(context);
        synchronized (gVar) {
            gVar.f();
            g.c(gVar.k());
            g.b(new File(gVar.b, "force_bundled"), "1");
        }
    }

    public static void scheduleRollback(Context context) {
        g gVar = new g(context);
        synchronized (gVar) {
            if (!gVar.j(gVar.l())) {
                throw new IOException("No previous compatible healthy dynamic dex");
            }
            File fileC = gVar.c();
            g.a(gVar.l(), fileC);
            new File(fileC, "healthy").delete();
            gVar.a(fileC);
        }
    }

    public static int stableApiVersion() {
        return 1792428213;
    }

    public static long workingDynamicVersion(Context context) {
        long jI;
        g gVar = new g(context);
        synchronized (gVar) {
            gVar.f();
            File fileA = gVar.a();
            if (g.e(fileA).isEmpty() || !gVar.b(fileA)) {
                jI = gVar.j(gVar.l()) ? g.i(gVar.l()) : gVar.e();
            } else {
                jI = g.i(gVar.a());
            }
        }
        return jI;
    }

    public static byte[] a(Context context) throws IOException {
        InputStream inputStreamOpen = context.getAssets().open("tty/public_key.der");
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStreamOpen.read(bArr);
                if (i == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    inputStreamOpen.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (Throwable th) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static void a(InputStream inputStream, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            byte[] bArr = new byte[65536];
            long j = 0;
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    fileOutputStream.getFD().sync();
                    fileOutputStream.close();
                    return;
                } else {
                    j += (long) i;
                    if (j <= MAX_PACKAGE_BYTES) {
                        fileOutputStream.write(bArr, 0, i);
                    } else {
                        throw new IOException("Selected file is too large");
                    }
                }
            }
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
