package a;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.LinkedHashSet;

public abstract class b {
    public static LinkedHashSet a(File file) throws IOException {
        byte[] allBytes = Files.readAllBytes(file.toPath());
        if (allBytes.length < 112) {
            throw new IOException("Truncated dex header");
        }
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(allBytes).order(ByteOrder.LITTLE_ENDIAN);
        int iA = a(byteBufferOrder.getInt(56), "string_ids_size");
        int iA2 = a(byteBufferOrder.getInt(60), allBytes.length, "string_ids_off");
        int iA3 = a(byteBufferOrder.getInt(64), "type_ids_size");
        int iA4 = a(byteBufferOrder.getInt(68), allBytes.length, "type_ids_off");
        int iA5 = a(byteBufferOrder.getInt(96), "class_defs_size");
        int iA6 = a(byteBufferOrder.getInt(100), allBytes.length, "class_defs_off");
        a(iA2, iA, 4, allBytes.length);
        a(iA4, iA3, 4, allBytes.length);
        a(iA6, iA5, 32, allBytes.length);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i = 0; i < iA5; i++) {
            int i2 = byteBufferOrder.getInt((i * 32) + iA6);
            if (i2 < 0 || i2 >= iA3) {
                throw new IOException("Invalid class type index");
            }
            int i3 = byteBufferOrder.getInt((i2 * 4) + iA4);
            if (i3 < 0 || i3 >= iA) {
                throw new IOException("Invalid descriptor index");
            }
            linkedHashSet.add(a(allBytes, a(byteBufferOrder.getInt((i3 * 4) + iA2), allBytes.length, "string_data_off")));
        }
        return linkedHashSet;
    }

    public static LinkedHashSet b(File file) throws IOException {
        byte[] allBytes = Files.readAllBytes(file.toPath());
        if (allBytes.length < 112) {
            throw new IOException("Truncated dex header");
        }
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(allBytes).order(ByteOrder.LITTLE_ENDIAN);
        int iA = a(byteBufferOrder.getInt(56), "string_ids_size");
        int iA2 = a(byteBufferOrder.getInt(60), allBytes.length, "string_ids_off");
        int iA3 = a(byteBufferOrder.getInt(64), "type_ids_size");
        int iA4 = a(byteBufferOrder.getInt(68), allBytes.length, "type_ids_off");
        a(iA2, iA, 4, allBytes.length);
        a(iA4, iA3, 4, allBytes.length);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i = 0; i < iA3; i++) {
            int i2 = byteBufferOrder.getInt((i * 4) + iA4);
            if (i2 < 0 || i2 >= iA) {
                throw new IOException("Invalid type descriptor index");
            }
            linkedHashSet.add(a(allBytes, a(byteBufferOrder.getInt((i2 * 4) + iA2), allBytes.length, "string_data_off")));
        }
        return linkedHashSet;
    }

    public static String a(byte[] bArr, int i) throws IOException {
        int[] iArr = {i};
        for (int i2 = 0; i2 < 35; i2 += 7) {
            int i3 = iArr[0];
            if (i3 < bArr.length) {
                int i4 = i3 + 1;
                iArr[0] = i4;
                if ((bArr[i3] & 128) == 0) {
                    int i5 = i4;
                    while (i5 < bArr.length && bArr[i5] != 0) {
                        i5++;
                    }
                    if (i5 != bArr.length) {
                        return new String(bArr, i4, i5 - i4, StandardCharsets.UTF_8);
                    }
                    throw new IOException("Unterminated dex string");
                }
            } else {
                throw new IOException("Truncated uleb128");
            }
        }
        throw new IOException("Invalid uleb128");
    }

    public static int a(int i, String str) throws IOException {
        if (i >= 0) {
            return i;
        }
        throw new IOException(new StringBuilder().append("Invalid ").append(str).toString());
    }

    public static int a(int i, int i2, String str) throws IOException {
        if (i < 0 || i >= i2) {
            throw new IOException(new StringBuilder().append("Invalid ").append(str).toString());
        }
        return i;
    }

    public static void a(int i, int i2, int i3, int i4) throws IOException {
        if ((((long) i2) * ((long) i3)) + ((long) i) > i4) {
            throw new IOException("Dex table outside file");
        }
    }
}
