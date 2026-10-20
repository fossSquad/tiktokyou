package Z;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public abstract class w4 {
    public static Bitmap a(File file, int i) {
        if (file != null && file.exists() && file.length() > 0 && i > 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            try {
                BitmapFactory.decodeFile(file.getAbsolutePath(), options);
                if (options.outWidth > 0 && options.outHeight > 0) {
                    try {
                        Bitmap bitmapA = a(BitmapFactory.decodeFile(file.getAbsolutePath(), a(options, i)), i);
                        if (bitmapA == null) {
                            return null;
                        }
                        if (Math.max(options.outWidth, options.outHeight) > i) {
                            long jLastModified = file.lastModified();
                            try {
                                a(file, bitmapA);
                                if (jLastModified > 0) {
                                    file.setLastModified(jLastModified);
                                    return bitmapA;
                                }
                            } catch (IOException e) {
                                g7.a(6, g7.a("Failed to normalize bitmap cache %s: %s", new Object[]{file.getName(), e.getMessage()}), (Throwable) null);
                            }
                        }
                        return bitmapA;
                    } catch (Throwable th) {
                        g7.a(6, g7.a("Failed to decode bitmap cache %s: %s", new Object[]{file.getName(), th.getMessage()}), (Throwable) null);
                    }
                }
                return null;
            } catch (Throwable th2) {
                g7.a(6, g7.a("Failed to read bitmap bounds %s: %s", new Object[]{file.getName(), th2.getMessage()}), (Throwable) null);
            }
        }
        return null;
    }

    public static Bitmap a(byte[] bArr, int i) {
        if (bArr != null && bArr.length != 0 && i > 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            try {
                BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                if (options.outWidth > 0 && options.outHeight > 0) {
                    try {
                        return a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length, a(options, i)), i);
                    } catch (Throwable th) {
                        g7.a(6, g7.a("Failed to decode bitmap: %s", new Object[]{th.getMessage()}), (Throwable) null);
                    }
                }
                return null;
            } catch (Throwable th2) {
                g7.a(6, g7.a("Failed to read bitmap bounds: %s", new Object[]{th2.getMessage()}), (Throwable) null);
            }
        }
        return null;
    }

    public static void a(File file, Bitmap bitmap) throws IOException {
        if (file != null && !bitmap.isRecycled()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) {
                throw new IOException("Failed to create " + parentFile.getAbsolutePath());
            }
            File fileCreateTempFile = File.createTempFile("img", ".tmp", parentFile);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile, false);
                try {
                    if (bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)) {
                        fileOutputStream.getFD().sync();
                        fileOutputStream.close();
                        try {
                            Files.move(fileCreateTempFile.toPath(), file.toPath(), StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
                        } catch (AtomicMoveNotSupportedException e) {
                            Files.move(fileCreateTempFile.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        }
                        if (fileCreateTempFile.exists()) {
                            fileCreateTempFile.delete();
                            return;
                        }
                        return;
                    }
                    throw new IOException("Failed to encode bitmap cache entry");
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                if (fileCreateTempFile.exists()) {
                    fileCreateTempFile.delete();
                }
                throw th3;
            }
        }
        throw new IOException("Invalid bitmap cache entry");
    }

    public static BitmapFactory.Options a(BitmapFactory.Options options, int i) {
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        int i4 = 1;
        if (i2 > 0 && i3 > 0 && i > 0) {
            int iMax = Math.max(i2, i3);
            while (i4 <= 1073741823) {
                int i5 = i4 * 2;
                if (iMax / i5 < i) {
                    break;
                }
                i4 = i5;
            }
        }
        options2.inSampleSize = i4;
        options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options2.inScaled = false;
        return options2;
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        if (bitmap != null && !bitmap.isRecycled() && i > 0) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > 0 && height > 0) {
                int iMax = Math.max(width, height);
                if (iMax <= i) {
                    return bitmap;
                }
                float f = i / iMax;
                try {
                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.max(1, Math.round(width * f)), Math.max(1, Math.round(height * f)), true);
                    if (bitmapCreateScaledBitmap != bitmap) {
                        bitmap.recycle();
                    }
                    return bitmapCreateScaledBitmap;
                } catch (Throwable th) {
                    g7.a(6, g7.a("Failed to normalize bitmap: %s", new Object[]{th.getMessage()}), (Throwable) null);
                    bitmap.recycle();
                    return null;
                }
            }
            bitmap.recycle();
        }
        return null;
    }
}
