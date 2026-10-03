package a;

import android.content.Context;
import java.io.File;

public abstract class j {

    public static volatile Context f4a;

    public static String a() {
        Context context = f4a;
        if (context == null) {
            return null;
        }
        File file = new File(context.getFilesDir(), "tiktokyoulogs");
        if (file.isDirectory() || file.mkdirs()) {
            return new File(file, "ttmod-native.log").getAbsolutePath();
        }
        return null;
    }
}
