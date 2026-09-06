package ni.shikatu.kotlinx.serialization.json;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.json.internal.DescriptorSchemaCache;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0084\b¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"schemaCache", "Lni/shikatu/kotlinx/serialization/json/internal/DescriptorSchemaCache;", "Lni/shikatu/kotlinx/serialization/json/Json;", "getSchemaCache$annotations", "(Lkotlinx/serialization/json/Json;)V", "getSchemaCache", "(Lkotlinx/serialization/json/Json;)Lkotlinx/serialization/json/internal/DescriptorSchemaCache;", "ni.shikatu.kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class JsonSchemaCacheKt {
    public static  void getSchemaCache$annotations(Json json) {
    }

    public static final DescriptorSchemaCache getSchemaCache(Json $this$schemaCache) {
        Intrinsics.checkNotNullParameter($this$schemaCache, "<this>");
        return $this$schemaCache.get_schemaCache$kotlinx_serialization_json();
    }
}
