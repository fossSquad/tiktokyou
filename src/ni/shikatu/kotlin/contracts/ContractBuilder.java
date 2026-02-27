package ni.shikatu.kotlin.contracts;

import ni.shikatu.kotlin.Function;
import ni.shikatu.kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H'J\b\u0010\u0005\u001a\u00020\u0006H'J&\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH'¨\u0006\u000e"}, d2 = {"Lni/shikatu/kotlin/contracts/ContractBuilder;", "", "returns", "Lni/shikatu/kotlin/contracts/Returns;", "value", "returnsNotNull", "Lni/shikatu/kotlin/contracts/ReturnsNotNull;", "callsInPlace", "Lni/shikatu/kotlin/contracts/CallsInPlace;", "R", "lambda", "Lni/shikatu/kotlin/Function;", "kind", "Lni/shikatu/kotlin/contracts/InvocationKind;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ContractBuilder {
    <R> CallsInPlace callsInPlace(Function<? extends R> function, InvocationKind invocationKind);

    Returns returns();

    Returns returns(Object obj);

    ReturnsNotNull returnsNotNull();

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
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
