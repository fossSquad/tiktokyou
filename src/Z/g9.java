package Z;

public abstract class g9 {
    public static final v9 a;

    static {
        w7 w7Var = new w7("FRAGMENT_MANAGER_CLASS", "androidx.fragment.app.FragmentManager");
        wb.a("method", "FRAGMENT_MANAGER_POP_BACK_STACK", (String[]) new String[]{"LJLLJ", "popBackStack"}.clone());
        wb.a("method", "FRAGMENT_MANAGER_BEGIN_TRANSACTION", (String[]) new String[]{"LJIIJ", "beginTransaction"}.clone());
        wb.a("method", "FRAGMENT_MANAGER_BACK_STACK_COUNT", (String[]) new String[]{"LJJLIIIJ", "getBackStackEntryCount"}.clone());
        a = new v9(w7Var, "FRAGMENT_MANAGER_FIND_FRAGMENT", new String[]{"LJJJJZ", "findFragment"});
    }
}
