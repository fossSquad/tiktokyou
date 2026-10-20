package Z;

import com.ss.android.ugc.aweme.im.contacts.api.model.IMUser;
import java.lang.reflect.InvocationTargetException;

public interface i2 {
    public static final i2 a = new i2() {
        @Override
        public final String a(Object obj) {
            return i2.b(obj);
        }
    };

    static String b(Object obj) {
        try {
            Object objInvoke = se.a(obj.getClass(), "getExtra", new Class[0]).invoke(obj, null);
            if (objInvoke == null) {
                return null;
            }
            Object objInvoke2 = se.a(objInvoke.getClass(), "getImUser", new Class[0]).invoke(objInvoke, null);
            if (objInvoke2 instanceof IMUser) {
                return ((IMUser) objInvoke2).getUid();
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    String a(Object obj);
}
