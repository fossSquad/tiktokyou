package com.oplus.ocs.base.utils;

import X.0wS0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

public final class e {

    public static class a {
        public Object a;
        public List<String> b;

        public a(Object obj) {
            d.a(obj);
            this.a = obj;
            this.b = new ArrayList();
        }

        public final a a(String str, Object obj) {
            List<String> list = this.b;
            StringBuilder sbLIZ = 0wS0.LIZ();
            sbLIZ.append(str);
            sbLIZ.append("=");
            sbLIZ.append(obj);
            String strLIZIZ = 0wS0.LIZIZ(sbLIZ);
            d.a(strLIZIZ);
            list.add(strLIZIZ);
            return this;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.a.getClass().getSimpleName());
            sb.append('{');
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                sb.append((String) ListProtector.get(this.b, i));
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static a a(Object obj) {
        return new a(obj);
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
