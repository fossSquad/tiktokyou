package X;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public final class h1 extends OutputStream {
    public final OutputStream a;
    public final ByteArrayOutputStream b = new ByteArrayOutputStream();

    public h1(OutputStream outputStream) {
        this.a = outputStream;
    }

    @Override
    public final void close() {
        try {
            byte[] byteArray = this.b.toByteArray();
            int length = byteArray.length;
            ArrayList arrayList = q2.a;
            if (byteArray.length > 12 && byteArray[4] == 102 && byteArray[5] == 116 && byteArray[6] == 121 && byteArray[7] == 112) {
                Bitmap bitmapDecodeByteArray = null;
                try {
                    Class<?> cls = Class.forName("com.bytedance.fresco.heif.HeifBitmapFactoryImpl");
                    Object objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
                    Class<?> cls2 = Integer.TYPE;
                    bitmapDecodeByteArray = (Bitmap) cls.getMethod("decodeByteArray", byte[].class, cls2, cls2, BitmapFactory.Options.class).invoke(objNewInstance, byteArray, 0, Integer.valueOf(byteArray.length), null);
                } catch (Exception e) {
                    e.getMessage();
                    ArrayList arrayList2 = q2.a;
                }
                if (bitmapDecodeByteArray == null && Build.VERSION.SDK_INT >= 28) {
                    try {
                        bitmapDecodeByteArray = ImageDecoder.decodeBitmap(ImageDecoder.createSource(ByteBuffer.wrap(byteArray)));
                    } catch (Exception e2) {
                        e2.getMessage();
                        ArrayList arrayList3 = q2.a;
                    }
                }
                if (bitmapDecodeByteArray == null) {
                    bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                }
                if (bitmapDecodeByteArray != null) {
                    bitmapDecodeByteArray.compress(Bitmap.CompressFormat.JPEG, 95, this.a);
                    bitmapDecodeByteArray.getWidth();
                    bitmapDecodeByteArray.getHeight();
                    bitmapDecodeByteArray.recycle();
                } else {
                    this.a.write(byteArray);
                }
            } else {
                if (byteArray.length > 7) {
                    byte b = byteArray[4];
                }
                if (byteArray.length > 7) {
                    byte b2 = byteArray[5];
                }
                if (byteArray.length > 7) {
                    byte b3 = byteArray[6];
                }
                if (byteArray.length > 7) {
                    byte b4 = byteArray[7];
                }
                this.a.write(byteArray);
            }
            try {
                this.a.flush();
            } catch (Exception e3) {
            }
        } catch (Exception e4) {
            e4.getMessage();
            ArrayList arrayList4 = q2.a;
            try {
                this.a.flush();
            } catch (Exception e5) {
            }
        } finally {
            try {
                this.a.flush();
            } catch (Exception e6) {
            }
            try {
                this.a.close();
            } catch (Exception e7) {
            }
        }
        try {
            this.a.close();
        } catch (Exception e8) {
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
