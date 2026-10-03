package Z;

public abstract class b8 {
    public static final p8 a;

    static {
        w6 w6Var = new w6("FRAGMENT_MANAGER_CLASS", "androidx.fragment.app.FragmentManager");
        oa.a("method", "FRAGMENT_MANAGER_POP_BACK_STACK", (String[]) new String[]{"LJLLILLLL", "popBackStack", "LJLLJ"}.clone());
        oa.a("method", "FRAGMENT_MANAGER_BEGIN_TRANSACTION", (String[]) new String[]{"LJIIJ", "beginTransaction"}.clone());
        oa.a("method", "FRAGMENT_MANAGER_BACK_STACK_COUNT", (String[]) new String[]{"LJJLIIIIJ", "getBackStackEntryCount", "LJJLIIIJ"}.clone());
        a = new p8(w6Var, "FRAGMENT_MANAGER_FIND_FRAGMENT", new String[]{"LJJJJLL", "findFragment", "LJJJJZ"});
    }
}
