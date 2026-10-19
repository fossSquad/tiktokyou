package Z;

public abstract class ha {
    public static final v9 a;
    public static final v9 b;
    public static final v9 c;
    public static final v9 d;
    public static final e9 e;
    public static final e9 f;

    static {
        w7 w7Var = new w7("PLAYBACK_SPEED_MANAGER", "X.08HI");
        a = new v9(w7Var, "SET_SPEED", new String[]{"LJ"});
        b = new v9(w7Var, "CAN_USE_SPEED", new String[]{"LIZ"});
        c = new v9(w7Var, "READ_SPEED", new String[]{"LIZIZ", "LIZJ"});
        d = new v9(w7Var, "ARM_NATIVE_PERSIST", new String[]{"LJI"});
        e = new e9(w7Var, "PERSIST_ENABLED", new String[]{"LJI"});
        f = new e9(w7Var, "PERSISTED_SPEED", new String[]{"LJII"});
    }
}
