package Z;

public abstract class a9 {
    public static final p8 a;
    public static final p8 b;
    public static final p8 c;
    public static final p8 d;
    public static final z7 e;
    public static final z7 f;

    static {
        w6 w6Var = new w6("PLAYBACK_SPEED_MANAGER", "X.08Fw");
        a = new p8(w6Var, "SET_SPEED", new String[]{"LJ"});
        b = new p8(w6Var, "CAN_USE_SPEED", new String[]{"LIZ"});
        c = new p8(w6Var, "READ_SPEED", new String[]{"LIZIZ", "LIZJ"});
        d = new p8(w6Var, "ARM_NATIVE_PERSIST", new String[]{"LJI"});
        e = new z7(w6Var, "PERSIST_ENABLED", new String[]{"LJI"});
        f = new z7(w6Var, "PERSISTED_SPEED", new String[]{"LJII"});
    }
}
