package Z;

import android.graphics.Bitmap;
import android.util.LruCache;
import java.util.ArrayList;

public final class d2 extends LruCache {
    public d2(int i) {
        super(i);
    }

    public final void a(String str) {
        if (str == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(snapshot().keySet());
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            String str2 = (String) obj;
            if (str2.startsWith(str)) {
                remove(str2);
            }
        }
    }

    @Override
    public final int sizeOf(Object obj, Object obj2) {
        Bitmap bitmap = (Bitmap) obj2;
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        try {
            return Math.max(1, bitmap.getAllocationByteCount());
        } catch (Throwable th) {
            try {
                return Math.max(1, bitmap.getByteCount());
            } catch (Throwable th2) {
                return 1;
            }
        }
    }
}
