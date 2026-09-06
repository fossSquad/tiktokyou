package ni.shikatu.kotlin.contracts;

import ni.shikatu.kotlin.Function;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H§\u0080\u0004b\u0002\b\u0004J\u0018\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H§\u0080\u0004b\u0002\b\u0004J\u000e\u0010\u0006\u001a\u00020\u0007H§\u0080\u0004b\u0002\b\u0004J,\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH§\u0080\u0004b\u0002\b\u0004J,\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0007H§\u0084\u0004b\u0002\b\u0012b\u0002\b\u0004b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015J8\u0010\u0016\u001a\u00020\u0017\"\u0004\b\u0000\u0010\n*\u00020\u00112\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH§\u0084\u0004b\u0002\b\u0012b\u0002\b\u0004b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015J0\u0010\u0018\u001a\u00020\u0010\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH§\u0080\u0004b\u0002\b\u0004b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0019Ê\u0001\u0002\b\u0004Ê\u0001\u0002\b\u001bÊ\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001c¨\u0006\u001a"}, d2 = {"Lni/shikatu/kotlin/contracts/ContractBuilder;", _UrlKt.FRAGMENT_ENCODE_SET, "returns", "Lni/shikatu/kotlin/contracts/Returns;", "Lni/shikatu/kotlin/internal/ContractsDsl;", "value", "returnsNotNull", "Lni/shikatu/kotlin/contracts/ReturnsNotNull;", "callsInPlace", "Lni/shikatu/kotlin/contracts/CallsInPlace;", "R", "lambda", "Lni/shikatu/kotlin/Function;", "kind", "Lni/shikatu/kotlin/contracts/InvocationKind;", "implies", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/contracts/ExperimentalExtendedContracts;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "2.2", "holdsIn", "Lni/shikatu/kotlin/contracts/HoldsIn;", "returnsResultOf", "2.4", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/contracts/ExperimentalContracts;", "1.3"}, k = 1, mv = {2, 4, 0}, xi = 48)
public interface ContractBuilder {
    <R> CallsInPlace callsInPlace(Function<? extends R> function, InvocationKind invocationKind);

    <R> HoldsIn holdsIn(boolean z, Function<? extends R> function);

    void implies(boolean z, ReturnsNotNull returnsNotNull);

    Returns returns();

    Returns returns(Object obj);

    ReturnsNotNull returnsNotNull();

    <R> void returnsResultOf(Function<? extends R> function);

    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    public static final class DefaultImpls {
        public static  CallsInPlace callsInPlace$default(ContractBuilder contractBuilder, Function function, InvocationKind invocationKind, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callsInPlace");
            }
            if ((i & 2) != 0) {
                invocationKind = InvocationKind.UNKNOWN;
            }
            return contractBuilder.callsInPlace(function, invocationKind);
        }
    }
}
