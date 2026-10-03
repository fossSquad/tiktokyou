package Z;

import android.content.ClipData;
import com.windukk.hook.HookMethod;
import java.util.ArrayList;
import java.util.Iterator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.IntIterator;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.IntRange;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"com/windukk/mod/hooks/CleanLinkHooks$init$1", "Lcom/windukk/hook/HookMethod;", "beforeHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class CleanLinkHooks$init$1 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String string;
        Object[] objArr = hookMethodParam.args;
        Object orNull = ArraysKt.getOrNull(objArr, 0);
        ClipData clipData = orNull instanceof ClipData ? (ClipData) orNull : null;
        if (clipData == null) {
            return;
        }
        IntRange intRangeUntil = RangesKt.until(0, clipData.getItemCount());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
        IntIterator it = intRangeUntil.iterator();
        while (it.hasNext()) {
            CharSequence text = clipData.getItemAt(it.nextInt()).getText();
            if (text == null || (string = text.toString()) == null) {
                return;
            } else {
                arrayList.add(string);
            }
        }
        Regex regex = CleanLinkHooks.a;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            arrayList2.add(CleanLinkHooks.a((String) obj));
        }
        if (Intrinsics.areEqual(arrayList2, arrayList)) {
            return;
        }
        Object[] objArr2 = hookMethodParam.args;
        ClipData clipDataNewPlainText = ClipData.newPlainText(clipData.getDescription().getLabel(), (CharSequence) CollectionsKt.first(arrayList2));
        Iterator it2 = CollectionsKt.drop(arrayList2, 1).iterator();
        while (it2.hasNext()) {
            clipDataNewPlainText.addItem(new ClipData.Item((String) it2.next()));
        }
        Unit unit = Unit.INSTANCE;
        objArr2[0] = clipDataNewPlainText;
    }
}
