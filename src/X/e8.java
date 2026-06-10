package X;

import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;

public final class e8 extends CharacterStyle implements UpdateAppearance {
    @Override
    public final void updateDrawState(TextPaint textPaint) {
        float fMax = Math.max(textPaint.getTextSize() * 10.0f, 1.0f);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, fMax, 0.0f, f8.a, (float[]) null, Shader.TileMode.MIRROR);
        Matrix matrix = new Matrix();
        matrix.setTranslate(((System.currentTimeMillis() % 1800) / 1800.0f) * fMax * 2.0f, 0.0f);
        linearGradient.setLocalMatrix(matrix);
        textPaint.setShader(linearGradient);
    }
}
