package X;

import com.ss.android.ugc.aweme.im.contacts.api.model.IMUser;
import java.lang.reflect.InvocationTargetException;

public interface p0 {
    public static final p0 a = new p0() {
        @Override
        public final String b(Object obj) {
            return p0.c(obj);
        }
    };
    public static final p0 b = new p0() {
        @Override
        public final String b(Object obj) {
            return p0.a(obj);
        }
    };

    static  String a(Object obj) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke = e4.a(obj.getClass(), "getExtra", new Class[0]).invoke(obj, null);
        if (objInvoke == null) {
            return null;
        }
        Object objInvoke2 = e4.a(objInvoke.getClass(), "getImUser", new Class[0]).invoke(objInvoke, null);
        if (objInvoke2 instanceof IMUser) {
            return ((IMUser) objInvoke2).getUid();
        }
        return null;
    }

    static  String c(Object obj) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke = e4.a(obj.getClass(), "getUid", new Class[0]).invoke(obj, null);
        if (objInvoke instanceof String) {
            return (String) objInvoke;
        }
        return null;
    }

    String b(Object obj);
}
