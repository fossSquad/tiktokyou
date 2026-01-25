package fake.com.bytedance.ttc2pa;

import fake.d.c;

public final class UnhandledException extends Exception {

    public UnhandledException(String str) {
        super(str);
        c.b(str, "message");
    }
}
