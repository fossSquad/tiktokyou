package ni.shikatu.kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import ni.shikatu.kotlin.DeepRecursiveFunction;
import ni.shikatu.kotlin.DeepRecursiveKt;
import ni.shikatu.kotlin.DeepRecursiveScope;
import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.coroutines.Continuation;
import ni.shikatu.kotlin.coroutines.intrinsics.IntrinsicsKt;
import ni.shikatu.kotlin.coroutines.jvm.internal.ContinuationImpl;
import ni.shikatu.kotlin.coroutines.jvm.internal.DebugMetadata;
import ni.shikatu.kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import ni.shikatu.kotlin.coroutines.jvm.internal.SpillingKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function3;
import ni.shikatu.kotlin.jvm.internal.IntCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.json.JsonArray;
import ni.shikatu.kotlinx.serialization.json.JsonConfiguration;
import ni.shikatu.kotlinx.serialization.json.JsonElement;
import ni.shikatu.kotlinx.serialization.json.JsonLiteral;
import ni.shikatu.kotlinx.serialization.json.JsonNull;
import ni.shikatu.kotlinx.serialization.json.JsonObject;
import ni.shikatu.kotlinx.serialization.json.JsonPrimitive;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\r\u001a\u00020\u000eH\u0082\u0080\u0004J\u001f\u0010\r\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000e0\u000fH\u0082À\u0004¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015H\u0082\u0088\u0004J\n\u0010\u0016\u001a\u00020\u000eH\u0082\u0080\u0004J\u0012\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0082\u0080\u0004J\n\u0010\u001a\u001a\u00020\u000eH\u0086\u0080\u0004J\n\u0010\u001b\u001a\u00020\u000eH\u0082\u0080\u0004R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\b\u001a\u00020\tX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\n\u001a\u00020\tX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u000b\u001a\u00020\fX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/JsonTreeReader;", _UrlKt.FRAGMENT_ENCODE_SET, "configuration", "Lni/shikatu/kotlinx/serialization/json/JsonConfiguration;", "lexer", "Lni/shikatu/kotlinx/serialization/json/internal/AbstractJsonLexer;", "<init>", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/json/internal/AbstractJsonLexer;)V", "isLenient", _UrlKt.FRAGMENT_ENCODE_SET, "trailingCommaAllowed", "stackDepth", _UrlKt.FRAGMENT_ENCODE_SET, "readObject", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", "Lni/shikatu/kotlin/DeepRecursiveScope;", _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlin/DeepRecursiveScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readObjectImpl", "Lni/shikatu/kotlinx/serialization/json/JsonObject;", "reader", "Lni/shikatu/kotlin/Function0;", "readArray", "readValue", "Lni/shikatu/kotlinx/serialization/json/JsonPrimitive;", "isString", "read", "readDeepRecursive", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JsonTreeReader {
    private final boolean isLenient;
    private final AbstractJsonLexer lexer;
    private int stackDepth;
    private final boolean trailingCommaAllowed;

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "ni.shikatu.kotlinx.serialization.json.internal.JsonTreeReader", f = "JsonTreeReader.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {22}, m = "readObject", n = {"$this$readObject", "this_$iv", "result$iv", "key$iv", "$i$f$readObjectImpl", "lastToken$iv", "$i$a$-readObjectImpl-JsonTreeReader$readObject$3"}, nl = {127}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "B$0", "I$1"}, v = 2)
    final class AnonymousClass2 extends ContinuationImpl {
        byte B$0;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
         Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super((Continuation<Object>) (Continuation) continuation);
        }

        @Override
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= IntCompanionObject.MIN_VALUE;
            return JsonTreeReader.this.readObject(null, this);
        }
    }

    public JsonTreeReader(JsonConfiguration configuration, AbstractJsonLexer lexer) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        this.lexer = lexer;
        this.isLenient = configuration.isLenient();
        this.trailingCommaAllowed = configuration.getAllowTrailingComma();
    }

    private final JsonElement readObject() {
        byte lastToken$iv = this.lexer.consumeNextToken((byte) 6);
        if (this.lexer.peekNextToken() == 4) {
            AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        LinkedHashMap result$iv = new LinkedHashMap();
        while (this.lexer.canConsumeValue()) {
            String key$iv = this.isLenient ? this.lexer.consumeStringLenient() : this.lexer.consumeString();
            this.lexer.consumeNextToken((byte) 5);
            JsonElement element$iv = read();
            result$iv.put(key$iv, element$iv);
            lastToken$iv = this.lexer.consumeNextToken();
            if (lastToken$iv != 4) {
                if (lastToken$iv == 7) {
                    break;
                }
                AbstractJsonLexer.fail$default(this.lexer, "Expected end of the object or comma", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
        }
        if (lastToken$iv == 6) {
            this.lexer.consumeNextToken((byte) 7);
        } else if (lastToken$iv == 4) {
            if (!this.trailingCommaAllowed) {
                JsonExceptionsKt.invalidTrailingComma$default(this.lexer, null, 1, null);
                throw new KotlinNothingValueException();
            }
            this.lexer.consumeNextToken((byte) 7);
        }
        return new JsonObject(result$iv);
    }

    public final java.lang.Object readObject(ni.shikatu.kotlin.DeepRecursiveScope<ni.shikatu.kotlin.Unit, ni.shikatu.kotlinx.serialization.json.JsonElement> r25, ni.shikatu.kotlin.coroutines.Continuation<? super ni.shikatu.kotlinx.serialization.json.JsonElement> r26) throws java.lang.Throwable {

        throw new UnsupportedOperationException("Method not decompiled: ni.shikatu.kotlinx.serialization.json.internal.JsonTreeReader.readObject(ni.shikatu.kotlin.DeepRecursiveScope, ni.shikatu.kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final JsonObject readObjectImpl(Function0<? extends JsonElement> function0) {
        byte lastToken = this.lexer.consumeNextToken((byte) 6);
        if (this.lexer.peekNextToken() == 4) {
            AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        LinkedHashMap result = new LinkedHashMap();
        while (this.lexer.canConsumeValue()) {
            String key = this.isLenient ? this.lexer.consumeStringLenient() : this.lexer.consumeString();
            this.lexer.consumeNextToken((byte) 5);
            JsonElement element = function0.invoke();
            result.put(key, element);
            lastToken = this.lexer.consumeNextToken();
            if (lastToken != 4) {
                if (lastToken == 7) {
                    break;
                }
                AbstractJsonLexer.fail$default(this.lexer, "Expected end of the object or comma", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
        }
        if (lastToken == 6) {
            this.lexer.consumeNextToken((byte) 7);
        } else if (lastToken == 4) {
            if (!this.trailingCommaAllowed) {
                JsonExceptionsKt.invalidTrailingComma$default(this.lexer, null, 1, null);
                throw new KotlinNothingValueException();
            }
            this.lexer.consumeNextToken((byte) 7);
        }
        return new JsonObject(result);
    }

    public final JsonElement readArray() {
        byte lastToken = this.lexer.consumeNextToken();
        if (this.lexer.peekNextToken() == 4) {
            AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        ArrayList result = new ArrayList();
        while (this.lexer.canConsumeValue()) {
            JsonElement element = read();
            result.add(element);
            lastToken = this.lexer.consumeNextToken();
            if (lastToken != 4) {
                AbstractJsonLexer $this$iv = this.lexer;
                boolean condition$iv = lastToken == 9;
                int position$iv = $this$iv.currentPosition;
                if (!condition$iv) {
                    AbstractJsonLexer.fail$default($this$iv, "Expected end of the array or comma", position$iv, null, 4, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (lastToken == 8) {
            this.lexer.consumeNextToken((byte) 9);
        } else if (lastToken == 4) {
            if (!this.trailingCommaAllowed) {
                JsonExceptionsKt.invalidTrailingComma(this.lexer, "array");
                throw new KotlinNothingValueException();
            }
            this.lexer.consumeNextToken((byte) 9);
        }
        return new JsonArray(result);
    }

    public final JsonPrimitive readValue(boolean isString) {
        String strConsumeStringLenient;
        if (this.isLenient || !isString) {
            strConsumeStringLenient = this.lexer.consumeStringLenient();
        } else {
            strConsumeStringLenient = this.lexer.consumeString();
        }
        String string = strConsumeStringLenient;
        return (isString || !Intrinsics.areEqual(string, AbstractJsonLexerKt.NULL)) ? new JsonLiteral(string, isString, null, 4, null) : JsonNull.INSTANCE;
    }

    public final JsonElement read() {
        JsonElement object;
        byte token = this.lexer.peekNextToken();
        if (token == 1) {
            return readValue(true);
        }
        if (token == 0) {
            return readValue(false);
        }
        if (token == 6) {
            this.stackDepth++;
            if (this.stackDepth == 200) {
                object = readDeepRecursive();
            } else {
                object = readObject();
            }
            this.stackDepth--;
            return object;
        }
        if (token == 8) {
            return readArray();
        }
        AbstractJsonLexer.fail$default(this.lexer, "Cannot read Json element because of unexpected " + AbstractJsonLexerKt.tokenDescription(token), 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", "Lni/shikatu/kotlin/DeepRecursiveScope;", _UrlKt.FRAGMENT_ENCODE_SET, "it"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "ni.shikatu.kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1", f = "JsonTreeReader.kt", i = {0}, l = {113}, m = "invokeSuspend", n = {"$this$DeepRecursiveFunction"}, nl = {114}, s = {"L$0"}, v = 2)
    final class AnonymousClass1 extends RestrictedSuspendLambda implements Function3<DeepRecursiveScope<Unit, JsonElement>, Unit, Continuation<? super JsonElement>, Object> {
        private  Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(3, (Continuation<Object>) (Continuation) continuation);
        }

        @Override
        public final Object invoke(DeepRecursiveScope<Unit, JsonElement> deepRecursiveScope, Unit unit, Continuation<? super JsonElement> continuation) {
            AnonymousClass1 anonymousClass1 = JsonTreeReader.this.new AnonymousClass1((Continuation<? super AnonymousClass1>) (Continuation) continuation);
            anonymousClass1.L$0 = deepRecursiveScope;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override
        public final Object invokeSuspend(Object $result) throws Throwable {
            Object object;
            DeepRecursiveScope $this$DeepRecursiveFunction = (DeepRecursiveScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    byte bPeekNextToken = JsonTreeReader.this.lexer.peekNextToken();
                    if (bPeekNextToken == 1) {
                        return JsonTreeReader.this.readValue(true);
                    }
                    if (bPeekNextToken == 0) {
                        return JsonTreeReader.this.readValue(false);
                    }
                    if (bPeekNextToken == 6) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable($this$DeepRecursiveFunction);
                        this.label = 1;
                        object = JsonTreeReader.this.readObject($this$DeepRecursiveFunction, this);
                        if (object == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (bPeekNextToken == 8) {
                            return JsonTreeReader.this.readArray();
                        }
                        AbstractJsonLexer.fail$default(JsonTreeReader.this.lexer, "Can't begin reading element, unexpected token", 0, null, 6, null);
                        throw new KotlinNothingValueException();
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    object = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return (JsonElement) object;
        }
    }

    private final JsonElement readDeepRecursive() {
        return (JsonElement) DeepRecursiveKt.invoke(new DeepRecursiveFunction(new AnonymousClass1(null)), Unit.INSTANCE);
    }
}
