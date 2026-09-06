package ni.shikatu.kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u001b\n\u0002\b\u0006\u001a;\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0081\u0080\u0004¢\u0006\u0002\u0010\b\u001aa\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00072\u0014\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00070\u0007H\u0081\u0080\u0004¢\u0006\u0002\u0010\r\u001aq\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00072\u0014\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00070\u00072\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007H\u0081\u0080\u0004¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"createSimpleEnumSerializer", "Lni/shikatu/kotlinx/serialization/KSerializer;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "serialName", _UrlKt.FRAGMENT_ENCODE_SET, "values", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;[Ljava/lang/Enum;)Lkotlinx/serialization/KSerializer;", "createMarkedEnumSerializer", "names", "annotations", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;[Ljava/lang/Enum;[Ljava/lang/String;[[Ljava/lang/annotation/Annotation;)Lkotlinx/serialization/KSerializer;", "createAnnotatedEnumSerializer", "entryAnnotations", "classAnnotations", "(Ljava/lang/String;[Ljava/lang/Enum;[Ljava/lang/String;[[Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)Lkotlinx/serialization/KSerializer;", "ni.shikatu.kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class EnumsKt {
    public static final <T extends Enum<T>> KSerializer<T> createSimpleEnumSerializer(String serialName, T[] tArr) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(tArr, "values");
        return new EnumSerializer(serialName, tArr);
    }

    public static final <T extends Enum<T>> KSerializer<T> createMarkedEnumSerializer(String serialName, T[] tArr, String[] names, Annotation[][] annotations) {
        String[] strArr = names;
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(tArr, "values");
        Intrinsics.checkNotNullParameter(strArr, "names");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        EnumDescriptor descriptor = new EnumDescriptor(serialName, tArr.length);
        T[] tArr2 = tArr;
        int index$iv = 0;
        int length = tArr2.length;
        int i = 0;
        while (i < length) {
            T t = tArr2[i];
            int index$iv2 = index$iv + 1;
            String elementName = (String) ArraysKt.getOrNull(strArr, index$iv);
            if (elementName == null) {
                elementName = t.name();
            }
            T[] tArr3 = tArr2;
            int i2 = 0;
            PluginGeneratedSerialDescriptor.addElement$default(descriptor, elementName, false, 2, null);
            Annotation[] annotationArr = (Annotation[]) ArraysKt.getOrNull(annotations, index$iv);
            if (annotationArr != null) {
                int length2 = annotationArr.length;
                while (i2 < length2) {
                    descriptor.pushAnnotation(annotationArr[i2]);
                    i2++;
                    annotationArr = annotationArr;
                }
            }
            i++;
            strArr = names;
            index$iv = index$iv2;
            tArr2 = tArr3;
        }
        return new EnumSerializer(serialName, tArr, descriptor);
    }

    public static final <T extends Enum<T>> KSerializer<T> createAnnotatedEnumSerializer(String serialName, T[] tArr, String[] names, Annotation[][] entryAnnotations, Annotation[] classAnnotations) {
        String[] strArr = names;
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(tArr, "values");
        Intrinsics.checkNotNullParameter(strArr, "names");
        Intrinsics.checkNotNullParameter(entryAnnotations, "entryAnnotations");
        EnumDescriptor descriptor = new EnumDescriptor(serialName, tArr.length);
        if (classAnnotations != null) {
            for (Annotation annotation : classAnnotations) {
                descriptor.pushClassAnnotation(annotation);
            }
        }
        T[] tArr2 = tArr;
        int index$iv = 0;
        int length = tArr2.length;
        int i = 0;
        while (i < length) {
            T t = tArr2[i];
            int index$iv2 = index$iv + 1;
            String elementName = (String) ArraysKt.getOrNull(strArr, index$iv);
            if (elementName == null) {
                elementName = t.name();
            }
            T[] tArr3 = tArr2;
            int i2 = 0;
            PluginGeneratedSerialDescriptor.addElement$default(descriptor, elementName, false, 2, null);
            Annotation[] annotationArr = (Annotation[]) ArraysKt.getOrNull(entryAnnotations, index$iv);
            if (annotationArr != null) {
                int length2 = annotationArr.length;
                while (i2 < length2) {
                    descriptor.pushAnnotation(annotationArr[i2]);
                    i2++;
                    annotationArr = annotationArr;
                }
            }
            i++;
            strArr = names;
            index$iv = index$iv2;
            tArr2 = tArr3;
        }
        return new EnumSerializer(serialName, tArr, descriptor);
    }
}
