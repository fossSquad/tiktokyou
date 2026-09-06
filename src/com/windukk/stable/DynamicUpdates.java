package com.windukk.stable;

import a.e;
import android.content.Context;
import android.net.Uri;
import c.f;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class DynamicUpdates {
    public static final long MAX_PACKAGE_BYTES = 201326592;

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

    public static DynamicStatus getStatus(Context context) {
        DynamicStatus dynamicStatus;
        e eVar = new e(context);
        synchronized (eVar) {
            eVar.f();
            String str = eVar.e().e;
            List listE = e.e(eVar.a());
            String strA = listE.isEmpty() ? null : e.a(listE);
            List listE2 = e.e(eVar.i());
            String strA2 = listE2.isEmpty() ? null : e.a(listE2);
            List listE3 = e.e(eVar.h());
            dynamicStatus = new DynamicStatus(str, strA, strA2, listE3.isEmpty() ? null : e.a(listE3), eVar.b().exists());
        }
        return dynamicStatus;
    }

    public static long highestAcceptedVersion(Context context) {
        return new e(context).g();
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
        e eVar = new e(context);
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
        File fileD = eVar.d();
        try {
            eVar.a(fileD, f.a(file, fileD, "release", a(context)).a.b);
        } catch (Throwable th3) {
            e.c(fileD);
            throw th3;
        }
    }

    public static void scheduleBundled(Context context) {
        e eVar = new e(context);
        synchronized (eVar) {
            eVar.f();
            e.c(eVar.h());
            e.b(new File(eVar.b, "force_bundled"), "1");
        }
    }

    public static void scheduleRollback(Context context) {
        e eVar = new e(context);
        synchronized (eVar) {
            if (!eVar.i(eVar.i())) {
                throw new IOException("No previous compatible healthy dynamic dex");
            }
            File fileD = eVar.d();
            e.a(eVar.i(), fileD);
            new File(fileD, "healthy").delete();
            eVar.a(fileD);
        }
    }

    public static int stableApiVersion() {
        return 1788704106;
    }

    public static long workingDynamicVersion(Context context) {
        long jC;
        e eVar = new e(context);
        synchronized (eVar) {
            eVar.f();
            jC = eVar.c();
        }
        return jC;
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
