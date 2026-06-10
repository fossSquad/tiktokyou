package X;

import com.ss.android.ugc.aweme.im.contacts.api.model.IMUser;
import java.lang.reflect.InvocationTargetException;

public interface l1 {
    public static final l1 a = new l1() {
        @Override
        public final String b(Object obj) {
            return l1.c(obj);
        }
    };
    public static final l1 b = new l1() {
        @Override
        public final String b(Object obj) {
            return l1.a(obj);
        }
    };

    static  String a(Object obj) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke = g8.a(obj.getClass(), "getExtra", new Class[0]).invoke(obj, null);
        if (objInvoke == null) {
            return null;
        }
        Object objInvoke2 = g8.a(objInvoke.getClass(), "getImUser", new Class[0]).invoke(objInvoke, null);
        if (objInvoke2 instanceof IMUser) {
            return ((IMUser) objInvoke2).getUid();
        }
        return null;
    }

    static  String c(Object obj) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke = g8.a(obj.getClass(), "getUid", new Class[0]).invoke(obj, null);
        if (objInvoke instanceof String) {
            return (String) objInvoke;
        }
        return null;
    }

    String b(Object obj);
}
