package X;

public abstract class y5 {
    public static final x5 a;
    public static final x5 b;
    public static final x5 c;
    public static final x5 d;
    public static final p5 e;
    public static final p5 f;

    static {
        x4 x4Var = new x4("PLAYBACK_SPEED_MANAGER", "X.0L4K");
        a = new x5(x4Var, "SET_SPEED", new String[]{"LJ"});
        b = new x5(x4Var, "CAN_USE_SPEED", new String[]{"LIZ"});
        c = new x5(x4Var, "READ_SPEED", new String[]{"LIZIZ", "LIZJ"});
        d = new x5(x4Var, "ARM_NATIVE_PERSIST", new String[]{"LJI"});
        e = new p5(x4Var, "PERSIST_ENABLED", new String[]{"LJI"});
        f = new p5(x4Var, "PERSISTED_SPEED", new String[]{"LJII"});
    }
}
