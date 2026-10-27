package Z;
import com.windukk.hook.HookBridge;
import java.util.List;

public abstract class o7 {
    static {
    }

    public static void a() {
        try {
            v9 v9Var = com.windukk.mod.a.a;
            HookBridge.hookMethod(v9Var.a(Class.forName(v9Var.a.b), List.class), new n7());
        } catch (Throwable th) {
            String strDecrypt = "FavoriteListReorderGuard init failed";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }
}
