package Z;
import java.io.IOException;

public final class r extends IOException {
    public final int a;

    public r(int i, String str) {
        super("HTTP " + i + " for " + str);
        this.a = i;
    }
}
