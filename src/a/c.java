package a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public abstract class c {

    // bytes: "dex\n"

    public static final byte[] f0a = {100, 101, 120, 10};
    public static final String[] b = {"Lcom/windukk/stable/", "Lcom/windukk/hook/", "Lcom/ss/android/ugc/aweme/utils/CommonUtils", "Lni/shikatu/RuntimeRegistered", "Lni/shikatu/kotlin/", "Lni/shikatu/okhttp3/", "Lni/shikatu/okio/"};
    public static final String[] c = {"Lkotlin/", "Lokhttp3/", "Lokio/"};

    public static void a(List list) throws IOException {
        if (list.isEmpty()) {
            throw new IOException("Dynamic dex set is empty");
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (!file.isFile() || file.length() < 112) {
                throw new IOException("Dynamic payload is not a dex file");
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = f0a;
                for (int i = 0; i < 4; i++) {
                    if (fileInputStream.read() != (bArr[i] & 255)) {
                        throw new IOException("Invalid dex magic");
                    }
                }
                fileInputStream.close();
                for (String str : b.a(file)) {
                    for (String str2 : b) {
                        if (str.startsWith(str2)) {
                            throw new IOException(new StringBuilder().append("Dynamic dex contains stable/runtime class: ").append(str).toString());
                        }
                    }
                }
                for (String str3 : b.b(file)) {
                    for (String str4 : c) {
                        if (str3.startsWith(str4)) {
                            throw new IOException(new StringBuilder().append("Dynamic dex contains unrelocated reference: ").append(str3).toString());
                        }
                    }
                }
                for (String str5 : b.a(file)) {
                    if (!linkedHashSet.add(str5)) {
                        throw new IOException(new StringBuilder().append("Dynamic dex set contains duplicate class: ").append(str5).toString());
                    }
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
    }
}
