package Z;
import java.io.IOException;

public final class t7 extends IOException {
    public final int a;

    public t7(int i, String str) {
        super(new StringBuilder().append("HTTP ").append(i).append(" for ").append(str).toString());
        this.a = i;
    }
}
