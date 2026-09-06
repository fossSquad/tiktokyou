package Z;

import com.ss.android.ugc.aweme.im.contacts.api.model.IMUser;
import java.lang.reflect.InvocationTargetException;

public interface z1 {
    public static final z1 a = new z1() {
        @Override
        public final String b(Object obj) {
            return z1.c(obj);
        }
    };
    public static final z1 b = new z1() {
        @Override
        public final String b(Object obj) {
            return z1.a(obj);
        }
    };

    static  String a(Object obj) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke = dd.a(obj.getClass(), "getExtra", new Class[0]).invoke(obj, null);
        if (objInvoke == null) {
            return null;
        }
        Object objInvoke2 = dd.a(objInvoke.getClass(), "getImUser", new Class[0]).invoke(objInvoke, null);
        if (objInvoke2 instanceof IMUser) {
            return ((IMUser) objInvoke2).getUid();
        }
        return null;
    }

    static  String c(Object obj) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke = dd.a(obj.getClass(), "getUid", new Class[0]).invoke(obj, null);
        if (objInvoke instanceof String) {
            return (String) objInvoke;
        }
        return null;
    }

    String b(Object obj);
}
