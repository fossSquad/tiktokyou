package ni.shikatu.kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.coroutines.Continuation;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nH\u0086\u0080\u0004J\u001a\u0010\u000b\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nH\u0082\u0080\u0004R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lni/shikatu/kotlin/coroutines/jvm/internal/ModuleNameRetriever;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "notOnJava9", "Lni/shikatu/kotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "cache", "getModuleName", _UrlKt.FRAGMENT_ENCODE_SET, "continuation", "Lni/shikatu/kotlin/coroutines/Continuation;", "buildCache", "Cache", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class ModuleNameRetriever {
    private static Cache cache;
    public static final ModuleNameRetriever INSTANCE = new ModuleNameRetriever();
    private static final Cache notOnJava9 = new Cache(null, null, null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\bF\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0084\b\u0092\u0002\u0002\b\b¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0084\b\u0092\u0002\u0002\b\b¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0084\b\u0092\u0002\u0002\b\b¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lni/shikatu/kotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", _UrlKt.FRAGMENT_ENCODE_SET, "getModuleMethod", "Ljava/lang/reflect/Method;", "getDescriptorMethod", "nameMethod", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "Lni/shikatu/kotlin/jvm/JvmField;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final class Cache {
        public final Method getDescriptorMethod;
        public final Method getModuleMethod;
        public final Method nameMethod;

        public Cache(Method getModuleMethod, Method getDescriptorMethod, Method nameMethod) {
            this.getModuleMethod = getModuleMethod;
            this.getDescriptorMethod = getDescriptorMethod;
            this.nameMethod = nameMethod;
        }
    }

    private ModuleNameRetriever() {
    }

    public final String getModuleName(Continuation<Object> continuation) {
        Method method;
        Object module;
        Method method2;
        Object descriptor;
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Cache cache2 = cache;
        if (cache2 == null) {
            cache2 = buildCache(continuation);
        }
        if (cache2 == notOnJava9 || (method = cache2.getModuleMethod) == null || (module = method.invoke(continuation.getClass(), new Object[0])) == null || (method2 = cache2.getDescriptorMethod) == null || (descriptor = method2.invoke(module, new Object[0])) == null) {
            return null;
        }
        Method method3 = cache2.nameMethod;
        Object objInvoke = method3 != null ? method3.invoke(descriptor, new Object[0]) : null;
        if (objInvoke instanceof String) {
            return (String) objInvoke;
        }
        return null;
    }

    private final Cache buildCache(Continuation<Object> continuation) {
        try {
            Method getModuleMethod = Class.class.getDeclaredMethod("getModule", new Class[0]);
            Method getDescriptorMethod = continuation.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]);
            Method nameMethod = continuation.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]);
            Cache it = new Cache(getModuleMethod, getDescriptorMethod, nameMethod);
            cache = it;
            return it;
        } catch (Exception e) {
            Cache it2 = notOnJava9;
            cache = it2;
            return it2;
        }
    }
}
