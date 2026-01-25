package fake.d;

import com.bytedance.tt.reliability.monitor.catchchecker.TryCatchGuardChecker;

public final class e {
    public static final f a;

    static {
        f fVar;
        try {
            fVar = (f) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
            if (fVar == null) {
                fVar = new f();
            }
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            TryCatchGuardChecker.doCheck(e);
        }
        a = fVar;
    }

    public static String a(d dVar) {
        a.getClass();
        String string = dVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }
}
