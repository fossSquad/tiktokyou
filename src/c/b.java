package c;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class b {
    public final String a;
    public final long b;

    public final int f1c;
    public final List d;
    public final Map e;
    public final List f;

    public b(String str, long j, int i, ArrayList arrayList, LinkedHashMap linkedHashMap, List list) {
        this.a = str;
        this.b = j;
        this.f1c = i;
        this.d = Collections.unmodifiableList(arrayList);
        String str2 = ((a) arrayList.get(0)).f0c;
        this.e = Collections.unmodifiableMap(linkedHashMap);
        this.f = Collections.unmodifiableList(list);
    }

    public static b a(byte[] bArr) throws IOException {
        String str;
        long j;
        List list;
        String str2 = new String(bArr, StandardCharsets.UTF_8);
        c cVar = new c(str2);
        Serializable serializableC = cVar.c();
        cVar.a();
        if (cVar.b != str2.length()) {
            cVar.a("Trailing data");
            throw null;
        }
        if (!(serializableC instanceof Map)) {
            throw new IOException("manifest.json must be an object");
        }
        Map map = (Map) serializableC;
        if (!"full".equals(b(map, "payloadType"))) {
            throw new IOException("Only full .ttydyn payloads are supported");
        }
        String strB = b(map, "variant");
        if (!strB.equals("debug") && !strB.equals("release")) {
            throw new IOException("variant must be debug or release");
        }
        long jA = a(map, "dynamicVersion");
        long jA2 = a(map, "stableApiVersion");
        if (jA < 0 || jA2 < 0 || jA2 > 2147483647L) {
            throw new IOException("Invalid numeric manifest field");
        }
        ArrayList arrayList = new ArrayList();
        Object obj = map.get("dexFiles");
        if (obj != null) {
            if (obj instanceof List) {
                List list2 = (List) obj;
                if (!list2.isEmpty()) {
                    Iterator it = list2.iterator();
                    int i = 1;
                    int i2 = 1;
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (!(next instanceof Map)) {
                            throw new IOException("dexFiles entries must be objects");
                        }
                        Map map2 = (Map) next;
                        String strDecrypt = i2 == i ? "classes.dex" : "classes" + i2 + ".dex";
                        String strB2 = b(map2, "name");
                        if (!strB2.equals(strDecrypt)) {
                            throw new IOException(a.a.a("g26CR6VsuvHWitpRMGBGuSDGqXkSZSoJM+NDPodwdzlHFfmjIsjdi7tUXBTwkygYVTxRWNMtAi/b6QewSA8J9g==", "zCYbqGeNGZU6cfd0", "aes", new StringBuilder(), strDecrypt));
                        }
                        if (!strB2.equals(b(map2, "payload"))) {
                            throw new IOException(a.a.a("0kAdb87DJtkhuipl23FETLakJcW8xW6pguY8OoQfrizHbAVr9k0cM5X/OujO92yU", "Eb90Vq1usVZ358WW", "aes", new StringBuilder(), strB2));
                        }
                        Iterator it2 = it;
                        String str3 = strB;
                        String strA = a(b(map2, "targetSha256"), strB2 + ".targetSha256");
                        long jA3 = a(map2, "targetSize");
                        long j2 = jA;
                        String str4 = strB2 + ".targetSize";
                        if (jA3 <= 0) {
                            throw new IOException(a.a.a("OcU67yg+apqqIrcZKvPdALLrdkaHSDNLAk9vJPcl+68=", "HsDylIlQXOSnKWVd", "aes", new StringBuilder(), str4));
                        }
                        arrayList.add(new a(strB2, strA, jA3));
                        i2++;
                        it = it2;
                        strB = str3;
                        jA = j2;
                        i = 1;
                    }
                    str = strB;
                    j = jA;
                }
            }
            throw new IOException("dexFiles must be a non-empty array");
        }
        String strA2 = a(b(map, "targetDexSha256"), "targetDexSha256");
        long jA4 = a(map, "targetSize");
        String strDecrypt2 = "targetSize";
        if (jA4 <= 0) {
            throw new IOException(a.a.a("OcU67yg+apqqIrcZKvPdALLrdkaHSDNLAk9vJPcl+68=", "HsDylIlQXOSnKWVd", "aes", new StringBuilder(), strDecrypt2));
        }
        arrayList.add(new a("classes.dex", strA2, jA4));
        str = strB;
        j = jA;
        Object obj2 = map.get("hashes");
        if (!(obj2 instanceof Map)) {
            throw new IOException("hashes must be an object");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : ((Map) obj2).entrySet()) {
            if (!(entry.getKey() instanceof String) || !(entry.getValue() instanceof String)) {
                throw new IOException("hashes must map names to SHA-256 strings");
            }
            linkedHashMap.put((String) entry.getKey(), a((String) entry.getValue(), "hashes." + entry.getKey()));
        }
        int i3 = (int) jA2;
        Object obj3 = map.get("commands");
        if (obj3 == null) {
            list = Collections.EMPTY_LIST;
        } else {
            if (!(obj3 instanceof List)) {
                throw new IOException("commands must be an array");
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj4 : (List) obj3) {
                if (obj4 instanceof String) {
                    String str5 = (String) obj4;
                    if (!str5.trim().isEmpty()) {
                        arrayList2.add(str5);
                    }
                }
                throw new IOException("commands must contain non-empty strings");
            }
            list = arrayList2;
        }
        return new b(str, j, i3, arrayList, linkedHashMap, list);
    }

    public static String b(Map map, String str) throws IOException {
        Object obj = map.get(str);
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (!str2.isEmpty()) {
                return str2;
            }
        }
        throw new IOException(a.a.a("L24x2nxfCfcpTYS+BnKrpMaWz2mvZHanOMeuf6GJNS9XczFc8U9JCAEcGGILRI5E", "iPMerlIhzlONTNpp", "aes", new StringBuilder(), str));
    }

    public static long a(Map map, String str) throws IOException {
        Object obj = map.get(str);
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        throw new IOException(a.a.a("+qoQlu/Zi68IdvlEdWU4iY7Qz02tOn0/TChWFYcqytgdyPsnzQ2S9q99PwbvFUJh", "q3R81G4JShKhYFpX", "aes", new StringBuilder(), str));
    }

    public static String a(String str, String str2) throws IOException {
        if (str.length() == 64 && str.matches("[0-9a-fA-F]{64}")) {
            return str.toLowerCase(Locale.ROOT);
        }
        throw new IOException(a.a.a("/Qo5E/0BMOb/22zos10zfiZO5WLJ225dHZmluisVUxF2qaTNgAqm/kBDZnudfqq0", "hDHK8RJbQhj3MM1B", "aes", new StringBuilder(), str2));
    }
}
