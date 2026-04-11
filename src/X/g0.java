package X;

import com.ss.android.ugc.aweme.im.contacts.api.model.IMUser;
import java.lang.reflect.InvocationTargetException;

public interface g0 {
    public static final g0 a = new g0() {
        @Override
        public final String b(Object obj) {
            return g0.c(obj);
        }
    };
    public static final g0 b = new g0() {
        @Override
        public final String b(Object obj) {
            return g0.a(obj);
        }
    };

    static  String a(Object obj) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke = k0.a(obj.getClass(), "getExtra", new Class[0]).invoke(obj, null);
        if (objInvoke == null) {
            return null;
        }
        Object objInvoke2 = k0.a(objInvoke.getClass(), "getImUser", new Class[0]).invoke(objInvoke, null);
        if (objInvoke2 instanceof IMUser) {
            return ((IMUser) objInvoke2).getUid();
        }
        return null;
    }

    static  String c(Object obj) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke = k0.a(obj.getClass(), "getUid", new Class[0]).invoke(obj, null);
        if (objInvoke instanceof String) {
            return (String) objInvoke;
        }
        return null;
    }

    String b(Object obj);
}
