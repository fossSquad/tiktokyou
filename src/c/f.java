package c;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public abstract class f {
    public static b a(InputStream inputStream) throws IOException {
        ZipEntry nextEntry;
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(inputStream));
        do {
            try {
                nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    throw new IOException("Missing manifest.json");
                }
            } catch (Throwable th) {
                try {
                    zipInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } while (!"manifest.json".equals(nextEntry.getName().replace('\\', '/')));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        int i = 0;
        while (true) {
            int i2 = zipInputStream.read(bArr);
            if (i2 == -1) {
                b bVarA = b.a(byteArrayOutputStream.toByteArray());
                zipInputStream.close();
                return bVarA;
            }
            i += i2;
            if (i > 524288) {
                throw new IOException("manifest.json is too large");
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }

    public static void a(b bVar, String str) throws IOException {
        if (str.equals(bVar.a)) {
            if (1792428213 != bVar.f1c) {
                throw new IOException("Stable API mismatch: expected " + 1792428213 + ", package is " + bVar.f1c);
            }
            return;
        }
        throw new IOException("Variant mismatch: expected " + str + ", package is " + bVar.a);
    }

    public static e a(File file, File file2, String str, byte[] bArr) throws IOException {
        FileInputStream fileInputStream;
        if (file.isFile()) {
            if (!file2.isDirectory() && !file2.mkdirs()) {
                throw new IOException("Cannot create staging directory");
            }
            ZipFile zipFile = new ZipFile(file);
            try {
                LinkedHashMap linkedHashMapA = a(zipFile);
                String strDecrypt = "manifest.json";
                ZipEntry zipEntry = (ZipEntry) linkedHashMapA.get(strDecrypt);
                if (zipEntry != null) {
                    byte[] bArrA = a(zipFile, zipEntry, 524288);
                    b bVarA = b.a(bArrA);
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    Iterator it = bVarA.d.iterator();
                    while (it.hasNext()) {
                        linkedHashSet.add(((a) it.next()).b);
                    }
                    LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                    for (String str2 : linkedHashMapA.keySet()) {
                        if (str2.matches("classes(?:[2-9][0-9]*)?\\.dex")) {
                            linkedHashSet2.add(str2);
                        }
                    }
                    if (linkedHashSet2.equals(linkedHashSet)) {
                        a(bVarA, str);
                        String strDecrypt2 = "signature.der";
                        ZipEntry zipEntry2 = (ZipEntry) linkedHashMapA.get(strDecrypt2);
                        if (zipEntry2 != null) {
                            a(bArrA, a(zipFile, zipEntry2, 4096), bArr);
                            LinkedHashSet<String> linkedHashSet3 = new LinkedHashSet();
                            for (String str3 : linkedHashMapA.keySet()) {
                                if (!str3.equals("manifest.json") && !str3.equals("signature.der")) {
                                    linkedHashSet3.add(str3);
                                }
                            }
                            if (linkedHashSet3.equals(bVarA.e.keySet())) {
                                for (String str4 : linkedHashSet3) {
                                    InputStream inputStream = zipFile.getInputStream((ZipEntry) linkedHashMapA.get(str4));
                                    try {
                                        d dVar = new d(inputStream);
                                        try {
                                            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                                            byte[] bArr2 = new byte[65536];
                                            while (true) {
                                                int i = dVar.read(bArr2);
                                                linkedHashSet3 = linkedHashSet3;
                                                if (i == -1) {
                                                    break;
                                                }
                                                messageDigest.update(bArr2, 0, i);
                                                linkedHashSet3 = linkedHashSet3;
                                            }
                                            if (!b.a.a((String) bVarA.e.get(str4), b.a.a(messageDigest.digest()))) {
                                                throw new IOException("Hash mismatch for " + str4);
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                        } catch (NoSuchAlgorithmException e) {
                                            throw new AssertionError(e);
                                        }
                                    } catch (Throwable th) {
                                        if (inputStream == null) {
                                            throw th;
                                        }
                                        try {
                                            inputStream.close();
                                            throw th;
                                        } catch (Throwable th2) {
                                            th.addSuppressed(th2);
                                            throw th;
                                        }
                                    }
                                }
                                LinkedHashSet<String> linkedHashSet4 = linkedHashSet3;
                                ArrayList arrayList = new ArrayList();
                                Iterator it2 = bVarA.d.iterator();
                                while (it2.hasNext()) {
                                    a aVar = (a) it2.next();
                                    File file3 = new File(file2, aVar.a);
                                    String str5 = aVar.b;
                                    ZipEntry zipEntry3 = (ZipEntry) linkedHashMapA.get(str5);
                                    if (zipEntry3 != null) {
                                        a(zipFile.getInputStream(zipEntry3), file3);
                                        byte[] bArr3 = bArrA;
                                        b bVar = bVarA;
                                        if (file3.length() == aVar.d) {
                                            FileInputStream fileInputStream2 = new FileInputStream(file3);
                                            try {
                                                String str6 = aVar.f0c;
                                                try {
                                                    MessageDigest messageDigest2 = MessageDigest.getInstance("SHA-256");
                                                    Iterator it3 = it2;
                                                    byte[] bArr4 = new byte[65536];
                                                    while (true) {
                                                        int i2 = fileInputStream2.read(bArr4);
                                                        fileInputStream = fileInputStream2;
                                                        if (i2 == -1) {
                                                            break;
                                                        }
                                                        try {
                                                            messageDigest2.update(bArr4, 0, i2);
                                                            fileInputStream2 = fileInputStream;
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            Throwable th4 = th;
                                                            try {
                                                                fileInputStream.close();
                                                                throw th4;
                                                            } catch (Throwable th5) {
                                                                th4.addSuppressed(th5);
                                                                throw th4;
                                                            }
                                                        }
                                                    }
                                                    if (b.a.a(str6, b.a.a(messageDigest2.digest()))) {
                                                        fileInputStream.close();
                                                        arrayList.add(file3);
                                                        it2 = it3;
                                                        bArrA = bArr3;
                                                        bVarA = bVar;
                                                    } else {
                                                        throw new IOException("Target dex SHA-256 mismatch for " + aVar.a);
                                                    }
                                                } catch (NoSuchAlgorithmException e2) {
                                                    throw new AssertionError(e2);
                                                }
                                            } catch (Throwable th6) {
                                                th = th6;
                                                fileInputStream = fileInputStream2;
                                            }
                                        } else {
                                            throw new IOException("Target dex size mismatch for " + aVar.a);
                                        }
                                    } else {
                                        throw new IOException("Missing " + str5);
                                    }
                                }
                                byte[] bArr5 = bArrA;
                                b bVar2 = bVarA;
                                a.c.a(arrayList);
                                File file4 = new File(file2, "resources");
                                for (String str7 : linkedHashSet4) {
                                    if (str7.startsWith("resources/")) {
                                        String strSubstring = str7.substring("resources/".length());
                                        if (!strSubstring.isEmpty()) {
                                            File fileA = a(file4, strSubstring);
                                            a(zipFile.getInputStream((ZipEntry) linkedHashMapA.get(str7)), fileA);
                                            fileA.setReadOnly();
                                        } else {
                                            throw new IOException("Empty resource path");
                                        }
                                    }
                                }
                                int size = arrayList.size();
                                int i3 = 0;
                                while (i3 < size) {
                                    Object obj = arrayList.get(i3);
                                    i3++;
                                    ((File) obj).setReadOnly();
                                }
                                Files.write(new File(file2, "manifest.json").toPath(), bArr5, new OpenOption[0]);
                                new File(file2, "manifest.json").setReadOnly();
                                e eVar = new e(bVar2, arrayList);
                                zipFile.close();
                                return eVar;
                            }
                            throw new IOException("Manifest hashes do not exactly cover payload/resources");
                        }
                        throw new IOException("Missing " + strDecrypt2);
                    }
                    throw new IOException("Package dex payloads do not match manifest");
                }
                throw new IOException("Missing " + strDecrypt);
            } catch (Throwable th7) {
                try {
                    zipFile.close();
                    throw th7;
                } catch (Throwable th8) {
                    th7.addSuppressed(th8);
                    throw th7;
                }
            }
        }
        throw new IOException("Package does not exist");
    }

    public static LinkedHashMap a(ZipFile zipFile) throws IOException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            String strReplace = zipEntryNextElement.getName().replace('\\', '/');
            if (!zipEntryNextElement.isDirectory()) {
                if (!strReplace.isEmpty() && !strReplace.startsWith("/") && !strReplace.contains("\u0000")) {
                    for (String str : strReplace.split("/", -1)) {
                        if (str.isEmpty() || str.equals(".") || str.equals("..")) {
                            throw new IOException(a.a.a("D92eqNOz+ZI/+6zgKhiIxNmGICx7DVolXHnr669J7WCl+cP4Dvby5YeyeRu0PEKh", "0QnmdQie62wPXLqB", "aes", new StringBuilder(), strReplace));
                        }
                    }
                    if (!strReplace.equals("manifest.json") && !strReplace.equals("signature.der") && !strReplace.matches("classes(?:[2-9][0-9]*)?\\.dex") && !strReplace.startsWith("resources/")) {
                        throw new IOException(a.a.a("x04MtO+8pCBtuxvvvKMnDNUPVTSVv6YwIKCX3PLicKSZrZFxZ8E6rme6IMMFe6LZ", "i6wNMRXFKlhoxFvp", "aes", new StringBuilder(), strReplace));
                    }
                    if (zipEntryNextElement.getSize() <= 134217728) {
                        if (linkedHashMap.put(strReplace, zipEntryNextElement) != null) {
                            throw new IOException(a.a.a("D2KQEwZKcreSgvfiCdXOxt+gF0+e6gUHvLE2KvAWO1kHtwnwmPZZ+EQHiJGD50g4", "tl8Htd6MYKBt2UD9", "aes", new StringBuilder(), strReplace));
                        }
                    } else {
                        throw new IOException(a.a.a("J9SIhsbrvjYZO678pR3sEc+iPZLlMn7fEQoUH6ltn0MjyU9E4pPLVMQFPJW+HMD+", "Vn5ipMPoiBGLsLyO", "aes", new StringBuilder(), strReplace));
                    }
                } else {
                    throw new IOException(a.a.a("WkFArlWujuwQuZhNN7UcacPYuk/SwoirlOROT3PUgzawqStAO/OKvVaPtNvykeQL", "1h6YszzwFfkm4IHC", "aes", new StringBuilder(), strReplace));
                }
            }
        }
        return linkedHashMap;
    }

    public static File a(File file, String str) throws IOException {
        File file2 = new File(file, str);
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath() + File.separator)) {
            File parentFile = file2.getParentFile();
            if (parentFile.isDirectory() || parentFile.mkdirs()) {
                return file2;
            }
            throw new IOException("Cannot create resource directory");
        }
        throw new IOException("Resource path escapes root");
    }

    public static byte[] a(ZipFile zipFile, ZipEntry zipEntry, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        int i2 = 0;
        while (true) {
            try {
                int i3 = inputStream.read(bArr);
                if (i3 == -1) {
                    inputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                i2 += i3;
                if (i2 <= i) {
                    byteArrayOutputStream.write(bArr, 0, i3);
                } else {
                    throw new IOException(zipEntry.getName() + " is too large");
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    public static void a(InputStream inputStream, File file) throws IOException {
        File parentFile = file.getParentFile();
        if (!parentFile.isDirectory() && !parentFile.mkdirs()) {
            throw new IOException("Cannot create output directory");
        }
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                byte[] bArr = new byte[65536];
                long j = 0;
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        bufferedOutputStream.close();
                        inputStream.close();
                        return;
                    } else {
                        j += (long) i;
                        if (j <= 134217728) {
                            bufferedOutputStream.write(bArr, 0, i);
                        } else {
                            throw new IOException("Entry exceeds size limit");
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    bufferedOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (Throwable th4) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th4;
        }
    }

    public static void a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws InvalidKeySpecException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, IOException {
        if (bArr3 != null && bArr3.length != 0) {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(bArr3));
            if ((publicKeyGeneratePublic instanceof ECPublicKey) && ((ECPublicKey) publicKeyGeneratePublic).getParams().getCurve().getField().getFieldSize() == 256) {
                Signature signature = Signature.getInstance("SHA256withECDSA");
                signature.initVerify(publicKeyGeneratePublic);
                signature.update(bArr);
                if (!signature.verify(bArr2)) {
                    throw new IOException("Invalid .ttydyn signature");
                }
                return;
            }
            throw new IOException("Dynamic public key must use ECDSA P-256");
        }
        throw new IOException("No dynamic public key");
    }
}
