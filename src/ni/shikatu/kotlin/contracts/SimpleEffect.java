package ni.shikatu.kotlin.contracts;

import ni.shikatu.kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§\u0004¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlin/contracts/SimpleEffect;", "Lni/shikatu/kotlin/contracts/Effect;", "implies", "Lni/shikatu/kotlin/contracts/ConditionalEffect;", "booleanExpression", "", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface SimpleEffect extends Effect {
    ConditionalEffect implies(boolean z);
}
