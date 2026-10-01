package com.windukk.stable;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ResourceOverlay {

    public static volatile File f5a;

    public static boolean exists(Context context, String str) {
        try {
            InputStream inputStreamOpen = open(context, str);
            if (inputStreamOpen != null) {
                inputStreamOpen.close();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static InputStream open(Context context, String str) throws IOException {
        if (str == null || str.isEmpty() || str.startsWith("/") || str.contains("\\")) {
            throw new IOException("Unsafe resource path");
        }
        for (String str2 : str.split("/", -1)) {
            if (str2.isEmpty() || str2.equals(".") || str2.equals("..")) {
                throw new IOException("Unsafe resource path");
            }
        }
        File file = f5a;
        if (file != null) {
            File file2 = new File(file, str);
            if (!file2.getCanonicalPath().startsWith(file.getCanonicalPath() + File.separator)) {
                throw new IOException("Unsafe resource path");
            }
            if (file2.isFile()) {
                return new FileInputStream(file2);
            }
        }
        return context.getAssets().open(str);
    }
}
