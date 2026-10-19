package ni.shikatu.kotlin.contracts;

import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§\u0084\bb\u0002\b\u0006b\u0002\b\u0007b\u0002\b\bÊ\u0001\u0002\b\u0006Ê\u0001\u0002\b\u0007Ê\u0001\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¨\u0006\t"}, d2 = {"Lni/shikatu/kotlin/contracts/SimpleEffect;", "Lni/shikatu/kotlin/contracts/Effect;", "implies", "Lni/shikatu/kotlin/contracts/ConditionalEffect;", "booleanExpression", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/internal/ContractsDsl;", "Lni/shikatu/kotlin/contracts/ExperimentalContracts;", "Lni/shikatu/kotlin/IgnorableReturnValue;", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3"}, k = 1, mv = {2, 4, 0}, xi = 48)
public interface SimpleEffect extends Effect {
    @IgnorableReturnValue
    ConditionalEffect implies(boolean z);
}
