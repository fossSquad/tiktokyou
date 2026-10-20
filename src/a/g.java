package a;

import android.content.Context;
import com.windukk.stable.DynamicStatus;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.ToIntFunction;

public final class g {
    public static final Object e;

    public final Context f2a;
    public final File b;
    public final String c = "release";
    public final int d = 1792428213;

    static {
        e = new Object();
    }

    public g(Context context) {
        this.f2a = context;
        this.b = new File(context.getNoBackupFilesDir(), "tty_dynamic");
    }

    public static List e(File file) throws IOException {
        if (!file.isDirectory()) {
            return Collections.EMPTY_LIST;
        }
        File[] fileArrListFiles = file.listFiles(new FileFilter() {
            @Override
            public final boolean accept(File file2) {
                return g.f(file2);
            }
        });
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fileArrListFiles);
        arrayList.sort(Comparator.comparingInt(new ToIntFunction() {
            @Override
            public final int applyAsInt(Object obj) {
                return g.a(((File) obj).getName());
            }
        }));
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            arrayList2.add(((File) obj).getName());
        }
        a(arrayList2);
        return arrayList;
    }

    public static boolean f(File file) {
        String name;
        return file.isFile() && (name = file.getName()) != null && name.matches("classes(?:[2-9][0-9]*)?\\.dex");
    }

    public final File a() {
        return new File(this.b, "active");
    }

    public final File b() {
        return new File(this.b, "startup_attempt");
    }

    public final synchronized File c() {
        File file;
        f();
        file = new File(this.b, "pending.tmp");
        c(file);
        if (!file.mkdirs()) {
            throw new IOException("Cannot create pending staging directory");
        }
        return file;
    }

    public final a.e d() throws IOException {
        if (this.f2a == null) {
            throw new IOException("Bundled dex is unavailable without Android context");
        }
        String[] list = this.f2a.getAssets().list("tty/bundled");
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            String strDecrypt = "classes(?:[2-9][0-9]*)?\\.dex";
            for (String str : list) {
                if (str != null && str.matches(strDecrypt)) {
                    arrayList.add(str);
                }
            }
        }
        arrayList.sort(Comparator.comparingInt(new ToIntFunction() {
            @Override
            public final int applyAsInt(Object obj) {
                return g.a((String) obj);
            }
        }));
        a(arrayList);
        File file = new File(this.b, "bundled");
        File file2 = new File(this.b, "bundled.tmp");
        c(file2);
        if (!file2.mkdirs()) {
            throw new IOException("Cannot create bundled staging directory");
        }
        for (int i = 0; i < arrayList.size(); i++) {
            String str2 = (String) arrayList.get(i);
            File file3 = new File(file2, str2);
            InputStream inputStreamOpen = this.f2a.getAssets().open("tty/bundled/" + str2);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                try {
                    byte[] bArr = new byte[65536];
                    while (true) {
                        int i2 = inputStreamOpen.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i2);
                    }
                    fileOutputStream.getFD().sync();
                } finally {
                    fileOutputStream.close();
                }
            } finally {
                inputStreamOpen.close();
            }
        }
        List list2 = d(file2);
        c.a(list2);
        String strA = a(list2);
        String strA2 = null;
        if (file.isDirectory()) {
            List listE = e(file);
            if (!listE.isEmpty()) {
                strA2 = a(listE);
            }
        }
        if (!strA.equals(strA2)) {
            c(file);
            b(file2, file);
            h(file);
        } else {
            c(file2);
        }
        return new e("bundled", d(file), null, false, strA);
    }

    public final synchronized long g() {
        long jI;
        try {
            f();
            File fileA = a();
            jI = (e(fileA).isEmpty() || !b(fileA)) ? j(l()) ? i(l()) : e() : i(a());
            if (new File(this.b, "highest_accepted_version").isFile()) {
                try {
                    jI = Math.max(jI, Long.parseLong(new String(Files.readAllBytes(new File(this.b, "highest_accepted_version").toPath()), StandardCharsets.US_ASCII).trim()));
                } catch (NumberFormatException e2) {
                    throw new IOException("Invalid highest accepted dynamic version", e2);
                }
            }
            File[] fileArr = {k(), a(), l()};
            for (int i = 0; i < 3; i++) {
                File file = fileArr[i];
                if (b(file)) {
                    jI = Math.max(jI, i(file));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return jI;
    }

    public final  long h() {
        return i(a());
    }

    public final  long i() {
        return i(l());
    }

    public final  long j() {
        return i(k());
    }

    public final File k() {
        return new File(this.b, "pending");
    }

    public final File l() {
        return new File(this.b, "previous");
    }

    public final synchronized e m() {
        int i;
        f();
        int i2 = 0;
        if (b().exists()) {
            if (!a().exists() || j(a())) {
                b().delete();
            } else {
                File fileA = a();
                String strDecrypt = "startup-crash";
                File fileN = n();
                if (fileN.isFile()) {
                    try {
                        i = Integer.parseInt(new String(Files.readAllBytes(fileN.toPath()), StandardCharsets.US_ASCII).trim());
                    } catch (NumberFormatException e2) {
                        throw new IOException("Invalid startup crash count", e2);
                    }
                } else {
                    i = 0;
                }
                int i3 = i + 1;
                if (i3 >= 3) {
                    a(fileA, strDecrypt);
                    b().delete();
                    n().delete();
                } else {
                    b(n(), Integer.toString(i3));
                    b().delete();
                }
            }
        }
        if (new File(this.b, "force_bundled").exists()) {
            c(k());
            if (a().isDirectory()) {
                File fileA2 = a();
                File fileL = l();
                c(fileL);
                b(fileA2, fileL);
            }
            new File(this.b, "force_bundled").delete();
            return d();
        }
        if (k().isDirectory() && !b(k())) {
            a(k(), "incompatible-pending");
        }
        if (k().isDirectory()) {
            if (a().isDirectory() && j(a())) {
                File fileA3 = a();
                File fileL2 = l();
                c(fileL2);
                b(fileA3, fileL2);
            } else {
                a(a(), "unhealthy-active");
            }
            b(k(), a());
            b().delete();
            n().delete();
            b(b(), "active");
            String strDecrypt2 = "pending";
            File fileA4 = a();
            List listD = d(fileA4);
            c.a(listD);
            return new e(strDecrypt2, listD, fileA4, true, a(listD));
        }
        if (j(a())) {
            String strDecrypt3 = "active";
            File fileA5 = a();
            List listD2 = d(fileA5);
            c.a(listD2);
            return new e(strDecrypt3, listD2, fileA5, false, a(listD2));
        }
        File fileN2 = n();
        if (fileN2.isFile()) {
            try {
                i2 = Integer.parseInt(new String(Files.readAllBytes(fileN2.toPath()), StandardCharsets.US_ASCII).trim());
            } catch (NumberFormatException e3) {
                throw new IOException("Invalid startup crash count", e3);
            }
        }
        if (i2 > 0 && i2 < 3 && a().isDirectory() && b(a()) && !e(a()).isEmpty()) {
            b(b(), "active");
            String strDecrypt4 = "active";
            File fileA6 = a();
            List listD3 = d(fileA6);
            c.a(listD3);
            return new e(strDecrypt4, listD3, fileA6, true, a(listD3));
        }
        if (a().exists()) {
            a(a(), "unhealthy-active");
        }
        if (!j(l())) {
            if (l().exists()) {
                a(l(), "unhealthy-previous");
            }
            return d();
        }
        String strDecrypt5 = "previous";
        File fileL3 = l();
        List listD4 = d(fileL3);
        c.a(listD4);
        return new e(strDecrypt5, listD4, fileL3, false, a(listD4));
    }

    public final File n() {
        return new File(this.b, "startup_crashes");
    }

    public final synchronized DynamicStatus o() {
        String str;
        String strA;
        String strA2;
        String strA3;
        boolean zExists;
        long jA;
        long jA2;
        long jA3;
        long jA4;
        f();
        str = d().e;
        List listE = e(a());
        strA = listE.isEmpty() ? null : a(listE);
        List listE2 = e(l());
        strA2 = listE2.isEmpty() ? null : a(listE2);
        List listE3 = e(k());
        strA3 = listE3.isEmpty() ? null : a(listE3);
        zExists = b().exists();
        jA = 0;
        try {
            jA2 = new f() {
                @Override
                public final long a() {
                    return g.this.e();
                }
            }.a();
        } catch (IOException e2) {
            jA2 = 0;
        }
        try {
            jA3 = new f() {
                @Override
                public final long a() {
                    return g.this.h();
                }
            }.a();
        } catch (IOException e3) {
            jA3 = 0;
        }
        try {
            jA4 = new f() {
                @Override
                public final long a() {
                    return g.this.i();
                }
            }.a();
        } catch (IOException e4) {
            jA4 = 0;
        }
        try {
            jA = new f() {
                @Override
                public final long a() {
                    return g.this.j();
                }
            }.a();
        } catch (IOException e5) {
        }
        return new DynamicStatus(str, strA, strA2, strA3, zExists, jA2, jA3, jA4, jA);
    }

    public static void h(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                h(file2);
            }
        }
        if (file.isFile()) {
            file.setReadOnly();
        }
    }

    public static long i(File file) {
        File file2 = new File(file, "manifest.json");
        if (file2.isFile()) {
            return c.b.a(Files.readAllBytes(file2.toPath())).b;
        }
        return 0L;
    }

    public final boolean a(long j) throws IOException {
        if (j <= 0 || !new File(this.b, "highest_accepted_version").isFile()) {
            return false;
        }
        try {
            if (Long.parseLong(new String(Files.readAllBytes(new File(this.b, "highest_accepted_version").toPath()), StandardCharsets.US_ASCII).trim()) != j) {
                return false;
            }
            File[] fileArr = {k(), a(), l()};
            for (int i = 0; i < 3; i++) {
                File file = fileArr[i];
                if (file.isDirectory() && b(file) && i(file) == j) {
                    return false;
                }
            }
            return true;
        } catch (NumberFormatException e2) {
            throw new IOException("Invalid highest accepted dynamic version", e2);
        }
    }

    public final void b(long j) {
        synchronized (e) {
            f();
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.b, "verified_install.lock"), "rw");
            try {
                FileChannel channel = randomAccessFile.getChannel();
                try {
                    FileLock fileLockLock = channel.lock();
                    try {
                        c(j);
                        if (fileLockLock != null) {
                            fileLockLock.close();
                        }
                        channel.close();
                        randomAccessFile.close();
                    } catch (Throwable th) {
                        if (fileLockLock != null) {
                            try {
                                fileLockLock.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th6) {
                    th5.addSuppressed(th6);
                }
                throw th5;
            }
        }
    }

    public final boolean j(File file) {
        return !e(file).isEmpty() && new File(file, "healthy").isFile() && b(file);
    }

    public final void f() throws IOException {
        if (!this.b.isDirectory() && !this.b.mkdirs()) {
            throw new IOException("Cannot create dynamic store");
        }
    }

    public final boolean c(long j) throws IOException {
        long jG = g();
        boolean z = j == jG && a(jG);
        if (z || j > jG) {
            return z;
        }
        throw new IOException("Dynamic version " + j + " is not newer than the accepted version " + jG);
    }

    public static void c(File file, String str) throws IOException {
        File file2 = new File(file.getParentFile(), file.getName() + ".tmp");
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            fileOutputStream.write(str.getBytes(StandardCharsets.US_ASCII));
            fileOutputStream.getFD().sync();
            fileOutputStream.close();
            try {
                Files.move(file2.toPath(), file.toPath(), StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
            } catch (AtomicMoveNotSupportedException e2) {
                Files.move(file2.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
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

    public final synchronized void a(e eVar) {
        if (eVar.c != null) {
            b(new File(eVar.c, "healthy"), eVar.e);
        }
        b().delete();
        n().delete();
    }

    public final long e() throws IOException {
        Context context = this.f2a;
        if (context == null) {
            return 0L;
        }
        InputStream inputStreamOpen = context.getAssets().open("tty/bundled/manifest.json");
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[8192];
            int i = 0;
            while (true) {
                int i2 = inputStreamOpen.read(bArr);
                if (i2 == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    inputStreamOpen.close();
                    c.b bVarA = c.b.a(byteArray);
                    if (this.c.equals(bVarA.a) && this.d == bVarA.c) {
                        return bVarA.b;
                    }
                    throw new IOException("Bundled dex manifest is incompatible");
                }
                i += i2;
                if (i <= 262144) {
                    byteArrayOutputStream.write(bArr, 0, i2);
                } else {
                    throw new IOException("Bundled dex manifest is too large");
                }
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

    public final synchronized void a(e eVar, Throwable th) {
        int i;
        if (eVar.c == null) {
            b().delete();
            n().delete();
            return;
        }
        try {
            b(new File(eVar.c, "failure.txt"), th.toString());
            File file = eVar.c;
            String strDecrypt = "entrypoint";
            File fileN = n();
            if (fileN.isFile()) {
                try {
                    i = Integer.parseInt(new String(Files.readAllBytes(fileN.toPath()), StandardCharsets.US_ASCII).trim());
                } catch (NumberFormatException e2) {
                    throw new IOException("Invalid startup crash count", e2);
                }
            } else {
                i = 0;
            }
            int i2 = i + 1;
            if (i2 >= 3) {
                a(file, strDecrypt);
                b().delete();
                n().delete();
            } else {
                b(n(), Integer.toString(i2));
                b().delete();
            }
        } catch (IOException e3) {
        }
    }

    public final boolean b(File file) {
        if (this.c == null || !file.isDirectory()) {
            return true;
        }
        File file2 = new File(file, "manifest.json");
        if (!file2.isFile()) {
            return false;
        }
        try {
            c.b bVarA = c.b.a(Files.readAllBytes(file2.toPath()));
            return this.c.equals(bVarA.a) && this.d == bVarA.c;
        } catch (IOException e2) {
            return false;
        }
    }

    public static void c(File file) throws IOException {
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    c(file2);
                }
            }
            if (!file.delete()) {
                throw new IOException("Cannot delete " + file);
            }
        }
    }

    public static void b(File file, String str) throws IOException {
        File parentFile = file.getParentFile();
        if (!parentFile.isDirectory() && !parentFile.mkdirs()) {
            throw new IOException("Cannot create state directory");
        }
        Files.write(file.toPath(), str.getBytes(StandardCharsets.UTF_8), new OpenOption[0]);
    }

    public static void b(File file, File file2) throws IOException {
        File parentFile = file2.getParentFile();
        if (!parentFile.isDirectory() && !parentFile.mkdirs()) {
            throw new IOException("Cannot create destination");
        }
        try {
            Files.move(file.toPath(), file2.toPath(), StandardCopyOption.ATOMIC_MOVE);
        } catch (AtomicMoveNotSupportedException e2) {
            Files.move(file.toPath(), file2.toPath(), new CopyOption[0]);
        }
    }

    public final void a(File file, long j, d dVar) {
        synchronized (e) {
            f();
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.b, "verified_install.lock"), "rw");
            try {
                FileChannel channel = randomAccessFile.getChannel();
                try {
                    FileLock fileLockLock = channel.lock();
                    try {
                        c.a(d(file));
                        boolean zC = c(j);
                        if (dVar != null) {
                            dVar.run();
                        }
                        if (!zC) {
                            c(new File(this.b, "highest_accepted_version"), Long.toString(j));
                        }
                        c(k());
                        b(file, k());
                        h(k());
                        if (new File(this.b, "force_bundled").exists() && !new File(this.b, "force_bundled").delete()) {
                            throw new IOException("Cannot cancel the bundled dex request");
                        }
                        if (fileLockLock != null) {
                            fileLockLock.close();
                        }
                        channel.close();
                        randomAccessFile.close();
                    } catch (Throwable th) {
                        if (fileLockLock != null) {
                            try {
                                fileLockLock.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th6) {
                    th5.addSuppressed(th6);
                }
                throw th5;
            }
        }
    }

    public final synchronized void a(File file) {
        c.a(d(file));
        c(k());
        b(file, k());
        h(k());
        if (new File(this.b, "force_bundled").exists() && !new File(this.b, "force_bundled").delete()) {
            throw new IOException("Cannot cancel the bundled dex request");
        }
    }

    public static int a(String str) {
        if ("classes.dex".equals(str)) {
            return 1;
        }
        return Integer.parseInt(str.substring("classes".length(), str.length() - ".dex".length()));
    }

    public static void a(ArrayList arrayList) throws IOException {
        if (!arrayList.isEmpty()) {
            int i = 0;
            while (i < arrayList.size()) {
                String strDecrypt = i == 0 ? "classes.dex" : "classes" + (i + 1) + ".dex";
                if (!strDecrypt.equals(arrayList.get(i))) {
                    throw new IOException(new StringBuilder().append("Non-sequential dex set; expected ").append(strDecrypt).toString());
                }
                i++;
            }
            return;
        }
        throw new IOException("Bundled dex set is empty");
    }

    public static String a(List list) throws IOException {
        if (list.size() == 1) {
            FileInputStream fileInputStream = new FileInputStream((File) list.get(0));
            try {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                    byte[] bArr = new byte[65536];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            String strA = b.a.a(messageDigest.digest());
                            fileInputStream.close();
                            return strA;
                        }
                        messageDigest.update(bArr, 0, i);
                    }
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (NoSuchAlgorithmException e2) {
                throw new AssertionError(e2);
            }
        } else {
            StringBuilder sb = new StringBuilder();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                File file = (File) it.next();
                StringBuilder sbAppend = sb.append(file.getName()).append(':');
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    try {
                        MessageDigest messageDigest2 = MessageDigest.getInstance("SHA-256");
                        byte[] bArr2 = new byte[65536];
                        while (true) {
                            int i2 = fileInputStream2.read(bArr2);
                            if (i2 == -1) {
                                break;
                            }
                            messageDigest2.update(bArr2, 0, i2);
                        }
                        String strA2 = b.a.a(messageDigest2.digest());
                        fileInputStream2.close();
                        sbAppend.append(strA2).append('\n');
                    } catch (Throwable th3) {
                        try {
                            fileInputStream2.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                        throw th3;
                    }
                } catch (NoSuchAlgorithmException e3) {
                    throw new AssertionError(e3);
                }
            }
            try {
                return b.a.a(MessageDigest.getInstance("SHA-256").digest(sb.toString().getBytes(StandardCharsets.UTF_8)));
            } catch (NoSuchAlgorithmException e4) {
                throw new AssertionError(e4);
            }
        }
    }

    public final void a(File file, String str) throws IOException {
        if (file.exists()) {
            File file2 = new File(new File(this.b, "quarantine"), System.currentTimeMillis() + "-" + str);
            File parentFile = file2.getParentFile();
            if (!parentFile.isDirectory() && !parentFile.mkdirs()) {
                throw new IOException("Cannot create quarantine");
            }
            b(file, file2);
        }
    }

    public static void a(File file, File file2) throws IOException {
        if (file.isDirectory()) {
            if (!file2.isDirectory() && !file2.mkdirs()) {
                throw new IOException("Cannot copy directory");
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file3 : fileArrListFiles) {
                    if (!file3.getName().equals("healthy")) {
                        a(file3, new File(file2, file3.getName()));
                    }
                }
                return;
            }
            return;
        }
        Files.copy(file.toPath(), file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    public static List d(File file) throws IOException {
        List listE = e(file);
        if (listE.isEmpty()) {
            throw new IOException("Dynamic dex set is empty in " + file);
        }
        return listE;
    }
}
