package fake.e;

import java.nio.charset.Charset;

public final class a {
    public static final Charset a;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        fake.d.c.a((Object) charsetForName, "forName(\"UTF-8\")");
        a = charsetForName;
        fake.d.c.a((Object) Charset.forName("UTF-16"), "forName(\"UTF-16\")");
        fake.d.c.a((Object) Charset.forName("UTF-16BE"), "forName(\"UTF-16BE\")");
        fake.d.c.a((Object) Charset.forName("UTF-16LE"), "forName(\"UTF-16LE\")");
        fake.d.c.a((Object) Charset.forName("US-ASCII"), "forName(\"US-ASCII\")");
        fake.d.c.a((Object) Charset.forName("ISO-8859-1"), "forName(\"ISO-8859-1\")");
    }
}
