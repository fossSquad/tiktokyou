package X;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public final class c3 extends OutputStream {
    public final OutputStream a;
    public final ByteArrayOutputStream b = new ByteArrayOutputStream();

    public c3(OutputStream outputStream) {
        this.a = outputStream;
    }

    public final void a(byte[] bArr) throws IOException {
        Bitmap bitmapDecodeByteArray;
        if (bArr.length <= 12 || bArr[4] != 102 || bArr[5] != 116 || bArr[6] != 121 || bArr[7] != 112) {
            if (bArr.length > 7) {
                byte b = bArr[4];
            }
            if (bArr.length > 7) {
                byte b2 = bArr[5];
            }
            if (bArr.length > 7) {
                byte b3 = bArr[6];
            }
            if (bArr.length > 7) {
                byte b4 = bArr[7];
            }
            int i = p4.a;
            this.a.write(bArr);
            return;
        }
        int i2 = p4.a;
        Bitmap bitmapDecodeBitmap = null;
        try {
            Class<?> cls = Class.forName("com.bytedance.fresco.heif.HeifBitmapFactoryImpl");
            Object objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
            Class cls2 = Integer.TYPE;
            bitmapDecodeByteArray = (Bitmap) g8.a(cls, "decodeByteArray", byte[].class, cls2, cls2, BitmapFactory.Options.class).invoke(objNewInstance, bArr, 0, Integer.valueOf(bArr.length), null);
        } catch (Exception e) {
            e.getMessage();
            int i3 = p4.a;
            bitmapDecodeByteArray = null;
        }
        if (bitmapDecodeByteArray == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    bitmapDecodeBitmap = ImageDecoder.decodeBitmap(ImageDecoder.createSource(ByteBuffer.wrap(bArr)));
                } catch (Exception e2) {
                    e2.getMessage();
                    int i4 = p4.a;
                }
                if (bitmapDecodeBitmap != null) {
                    bitmapDecodeByteArray = bitmapDecodeBitmap;
                } else {
                    bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                }
            } else {
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            }
        }
        if (bitmapDecodeByteArray == null) {
            this.a.write(bArr);
            return;
        }
        bitmapDecodeByteArray.compress(Bitmap.CompressFormat.JPEG, 95, this.a);
        bitmapDecodeByteArray.getWidth();
        bitmapDecodeByteArray.getHeight();
        bitmapDecodeByteArray.recycle();
    }

    @Override
    public final void close() {
        try {
            byte[] byteArray = this.b.toByteArray();
            int length = byteArray.length;
            int i = p4.a;
            a(byteArray);
        } catch (Exception e) {
            e.getMessage();
            int i2 = p4.a;
        } finally {
            try {
                this.a.flush();
            } catch (Exception e2) {
            }
            try {
                this.a.close();
            } catch (Exception e3) {
            }
        }
    }

    @Override
    public final void flush() {
    }

    @Override
    public final void write(int i) {
        this.b.write(i);
    }

    @Override
    public final void write(byte[] bArr) {
        this.b.write(bArr, 0, bArr.length);
    }

    @Override
    public final void write(byte[] bArr, int i, int i2) {
        this.b.write(bArr, i, i2);
    }
}
