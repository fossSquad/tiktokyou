package ni.shikatu.kotlin.text;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.coroutines.Continuation;
import ni.shikatu.kotlin.coroutines.intrinsics.IntrinsicsKt;
import ni.shikatu.kotlin.coroutines.jvm.internal.DebugMetadata;
import ni.shikatu.kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import ni.shikatu.kotlin.coroutines.jvm.internal.SpillingKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.FunctionReferenceImpl;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlin.sequences.Sequence;
import ni.shikatu.kotlin.sequences.SequenceScope;
import ni.shikatu.kotlin.sequences.SequencesKt;
import ni.shikatu.okhttp3.internal.http.HttpStatusCodesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 :2\u00060\u0001j\u0002`\u0002:\u00029:B\u0015\bA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0002\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\bV\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0005\u0010\nB\u0019\bV\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0005\u0010\rB\u001f\bV\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000f¢\u0006\u0004\b\u0005\u0010\u0010J\u0012\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0086\u0084\u0004J\u0012\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0086\u0080\u0004J\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0086\u0080\u0004J\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0 2\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0086\u0080\u0004J\u0014\u0010!\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0018\u001a\u00020\u0019H\u0086\u0080\u0004J*\u0010\"\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u001eH\u0087\u0080\u0004b\f\b$\u0012\b\b%\u0012\u0004\b\b(&J(\u0010'\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u001eH\u0087\u0080\u0004b\f\b$\u0012\b\b%\u0012\u0004\b\b(&J\u001a\u0010(\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\tH\u0086\u0080\u0004J&\u0010(\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00190+H\u0086\u0080\u0004J\u001a\u0010,\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\tH\u0086\u0080\u0004J\"\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0.2\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010/\u001a\u00020\u001eH\u0086\u0080\u0004J0\u00100\u001a\b\u0012\u0004\u0012\u00020\t0 2\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010/\u001a\u00020\u001eH\u0087\u0080\u0004b\f\b$\u0012\b\b%\u0012\u0004\b\b(1J\n\u00102\u001a\u00020\tH\u0096\u0080\u0004J\n\u00103\u001a\u00020\u0004H\u0086\u0080\u0004J\n\u00104\u001a\u000205H\u0082\u0080\u0004J\u0012\u00106\u001a\u0002072\u0006\u0010\u0018\u001a\u000208H\u0082\u0080\u0004R\u000f\u0010\u0003\u001a\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\b\u001a\u00020\t8FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000fX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000f8FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006;"}, d2 = {"Lni/shikatu/kotlin/text/Regex;", "Ljava/io/Serializable;", "Lni/shikatu/kotlin/io/Serializable;", "nativePattern", "Ljava/util/regex/Pattern;", "<init>", "(Ljava/util/regex/Pattern;)V", "Lni/shikatu/kotlin/PublishedApi;", "pattern", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;)V", "option", "Lni/shikatu/kotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;Ljava/util/Set;)V", "getPattern", "()Ljava/lang/String;", "_options", "getOptions", "()Ljava/util/Set;", "matches", _UrlKt.FRAGMENT_ENCODE_SET, "input", _UrlKt.FRAGMENT_ENCODE_SET, "containsMatchIn", "find", "Lni/shikatu/kotlin/text/MatchResult;", "startIndex", _UrlKt.FRAGMENT_ENCODE_SET, "findAll", "Lni/shikatu/kotlin/sequences/Sequence;", "matchEntire", "matchAt", "index", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.7", "matchesAt", "replace", "replacement", "transform", "Lni/shikatu/kotlin/Function1;", "replaceFirst", "split", _UrlKt.FRAGMENT_ENCODE_SET, "limit", "splitToSequence", "1.6", "toString", "toPattern", "writeReplace", _UrlKt.FRAGMENT_ENCODE_SET, "readObject", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/io/ObjectInputStream;", "Serialized", "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Regex implements Serializable {
    public static final Companion Companion = new Companion(null);
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    public Regex(Pattern nativePattern) {
        Intrinsics.checkNotNullParameter(nativePattern, "nativePattern");
        this.nativePattern = nativePattern;
    }

    public Regex(String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Pattern patternCompile = Pattern.compile(pattern);
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        this(patternCompile);
    }

    public Regex(String pattern, RegexOption option) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(option, "option");
        Pattern patternCompile = Pattern.compile(pattern, Companion.ensureUnicodeCase(option.getValue()));
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        this(patternCompile);
    }

    public Regex(String pattern, Set<? extends RegexOption> set) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(set, "options");
        Pattern patternCompile = Pattern.compile(pattern, Companion.ensureUnicodeCase(RegexKt.toInt(set)));
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        this(patternCompile);
    }

    public final String getPattern() {
        String strPattern = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue(strPattern, "pattern(...)");
        return strPattern;
    }

    public final Set<RegexOption> getOptions() {
        Set it = this._options;
        if (it != null) {
            return it;
        }
        final int value$iv = this.nativePattern.flags();
        EnumSet $this$fromInt_u24lambda_u240$iv = EnumSet.allOf(RegexOption.class);
        Intrinsics.checkNotNull($this$fromInt_u24lambda_u240$iv);
        CollectionsKt.retainAll($this$fromInt_u24lambda_u240$iv, new Function1<RegexOption, Boolean>() {
            @Override
            public final Boolean invoke(RegexOption regexOption) {
                return Boolean.valueOf((value$iv & regexOption.getMask()) == regexOption.getValue());
            }
        });
        Set<RegexOption> setUnmodifiableSet = Collections.unmodifiableSet($this$fromInt_u24lambda_u240$iv);
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(...)");
        this._options = setUnmodifiableSet;
        return setUnmodifiableSet;
    }

    public final boolean matches(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    public final boolean containsMatchIn(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    public static  MatchResult find$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.find(charSequence, i);
    }

    public final MatchResult find(CharSequence input, int startIndex) {
        Intrinsics.checkNotNullParameter(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        return RegexKt.findNext(matcher, startIndex, input);
    }

    public static  Sequence findAll$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.findAll(charSequence, i);
    }

    public final Sequence<MatchResult> findAll(final CharSequence input, final int startIndex) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (startIndex < 0 || startIndex > input.length()) {
            throw new IndexOutOfBoundsException("Start index out of bounds: " + startIndex + ", input length: " + input.length());
        }
        return SequencesKt.generateSequence(new Function0() {
            @Override
            public final Object invoke() {
                return this.f$0.find(input, startIndex);
            }
        }, (Function1) AnonymousClass2.INSTANCE);
    }

    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    static final  class AnonymousClass2 extends FunctionReferenceImpl implements Function1<MatchResult, MatchResult> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1, MatchResult.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override
        public final MatchResult invoke(MatchResult p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return p0.next();
        }
    }

    public final MatchResult matchEntire(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        return RegexKt.matchEntire(matcher, input);
    }

    public final MatchResult matchAt(CharSequence input, int index) {
        MatcherMatchResult matcherMatchResult;
        Intrinsics.checkNotNullParameter(input, "input");
        Matcher $this$matchAt_u24lambda_u240 = this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(index, input.length());
        if ($this$matchAt_u24lambda_u240.lookingAt()) {
            Intrinsics.checkNotNull($this$matchAt_u24lambda_u240);
            matcherMatchResult = new MatcherMatchResult($this$matchAt_u24lambda_u240, input);
        } else {
            matcherMatchResult = null;
        }
        return matcherMatchResult;
    }

    public final boolean matchesAt(CharSequence input, int index) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(index, input.length()).lookingAt();
    }

    public final String replace(CharSequence input, String replacement) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        String strReplaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        Intrinsics.checkNotNullExpressionValue(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }

    public final String replace(CharSequence input, Function1<? super MatchResult, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(function1, "transform");
        MatchResult match = find$default(this, input, 0, 2, null);
        if (match == null) {
            return input.toString();
        }
        int lastStart = 0;
        int length = input.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            MatchResult foundMatch = match;
            sb.append(input, lastStart, foundMatch.getRange().getStart().intValue());
            sb.append(function1.invoke(foundMatch));
            lastStart = foundMatch.getRange().getEndInclusive().intValue() + 1;
            match = foundMatch.next();
            if (lastStart >= length) {
                break;
            }
        } while (match != null);
        if (lastStart < length) {
            sb.append(input, lastStart, length);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final String replaceFirst(CharSequence input, String replacement) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        String strReplaceFirst = this.nativePattern.matcher(input).replaceFirst(replacement);
        Intrinsics.checkNotNullExpressionValue(strReplaceFirst, "replaceFirst(...)");
        return strReplaceFirst;
    }

    public static  List split$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }

    public final List<String> split(CharSequence input, int limit) {
        Intrinsics.checkNotNullParameter(input, "input");
        StringsKt.requireNonNegativeLimit(limit);
        Matcher matcher = this.nativePattern.matcher(input);
        if (limit == 1 || !matcher.find()) {
            return CollectionsKt.listOf(input.toString());
        }
        ArrayList result = new ArrayList(limit > 0 ? RangesKt.coerceAtMost(limit, 10) : 10);
        int lastStart = 0;
        int lastSplit = limit - 1;
        do {
            result.add(input.subSequence(lastStart, matcher.start()).toString());
            lastStart = matcher.end();
            if (lastSplit >= 0 && result.size() == lastSplit) {
                break;
            }
        } while (matcher.find());
        result.add(input.subSequence(lastStart, input.length()).toString());
        return result;
    }

    public static  Sequence splitToSequence$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.splitToSequence(charSequence, i);
    }

    public final Sequence<String> splitToSequence(CharSequence input, int limit) {
        Intrinsics.checkNotNullParameter(input, "input");
        StringsKt.requireNonNegativeLimit(limit);
        return SequencesKt.sequence(new AnonymousClass1(input, limit, null));
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/sequences/SequenceScope;", _UrlKt.FRAGMENT_ENCODE_SET}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "ni.shikatu.kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {296, 304, HttpStatusCodesKt.HTTP_PERM_REDIRECT}, m = "invokeSuspend", n = {"$this$sequence", "matcher", "$this$sequence", "matcher", "nextStart", "splitCount", "$this$sequence", "matcher", "nextStart", "splitCount"}, nl = {297, 305, 309}, s = {"L$0", "L$1", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"}, v = 2)
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super String>, Continuation<? super Unit>, Object> {
        final  CharSequence $input;
        final  int $limit;
        int I$0;
        int I$1;
        private  Object L$0;
        Object L$1;
        int label;

        AnonymousClass1(CharSequence charSequence, int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$input = charSequence;
            this.$limit = i;
        }

        @Override
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = Regex.this.new AnonymousClass1(this.$input, this.$limit, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override
        public final Object invoke(SequenceScope<? super String> sequenceScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override
        public final Object invokeSuspend(Object $result) throws Throwable {
            Matcher matcher;
            int nextStart;
            int splitCount;
            AnonymousClass1 anonymousClass1;
            SequenceScope $this$sequence = (SequenceScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    matcher = Regex.this.nativePattern.matcher(this.$input);
                    if (this.$limit == 1 || !matcher.find()) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable($this$sequence);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(matcher);
                        this.label = 1;
                        return $this$sequence.yield(this.$input.toString(), this) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                    }
                    nextStart = 0;
                    splitCount = 0;
                    anonymousClass1 = this;
                    anonymousClass1.L$0 = $this$sequence;
                    anonymousClass1.L$1 = matcher;
                    anonymousClass1.I$0 = nextStart;
                    anonymousClass1.I$1 = splitCount;
                    anonymousClass1.label = 2;
                    if ($this$sequence.yield(anonymousClass1.$input.subSequence(nextStart, matcher.start()).toString(), anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    nextStart = matcher.end();
                    splitCount++;
                    if (splitCount != anonymousClass1.$limit - 1 || !matcher.find()) {
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable($this$sequence);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(matcher);
                        anonymousClass1.I$0 = nextStart;
                        anonymousClass1.I$1 = splitCount;
                        anonymousClass1.label = 3;
                        if ($this$sequence.yield(anonymousClass1.$input.subSequence(nextStart, anonymousClass1.$input.length()).toString(), anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    anonymousClass1.L$0 = $this$sequence;
                    anonymousClass1.L$1 = matcher;
                    anonymousClass1.I$0 = nextStart;
                    anonymousClass1.I$1 = splitCount;
                    anonymousClass1.label = 2;
                    if ($this$sequence.yield(anonymousClass1.$input.subSequence(nextStart, matcher.start()).toString(), anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    nextStart = matcher.end();
                    splitCount++;
                    if (splitCount != anonymousClass1.$limit - 1) {
                    }
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable($this$sequence);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(matcher);
                    anonymousClass1.I$0 = nextStart;
                    anonymousClass1.I$1 = splitCount;
                    anonymousClass1.label = 3;
                    if ($this$sequence.yield(anonymousClass1.$input.subSequence(nextStart, anonymousClass1.$input.length()).toString(), anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure($result);
                case 2:
                    int nextStart2 = this.I$1;
                    int i = this.I$0;
                    Matcher matcher2 = (Matcher) this.L$1;
                    ResultKt.throwOnFailure($result);
                    splitCount = nextStart2;
                    matcher = matcher2;
                    anonymousClass1 = this;
                    nextStart = matcher.end();
                    splitCount++;
                    if (splitCount != anonymousClass1.$limit - 1) {
                        break;
                    }
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable($this$sequence);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(matcher);
                    anonymousClass1.I$0 = nextStart;
                    anonymousClass1.I$1 = splitCount;
                    anonymousClass1.label = 3;
                    if ($this$sequence.yield(anonymousClass1.$input.subSequence(nextStart, anonymousClass1.$input.length()).toString(), anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 3:
                    int i2 = this.I$1;
                    int i3 = this.I$0;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public String toString() {
        String string = this.nativePattern.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    private final Object writeReplace() {
        String strPattern = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue(strPattern, "pattern(...)");
        return new Serialized(strPattern, this.nativePattern.flags());
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000f2\u00060\u0001j\u0002`\u0002:\u0001\u000fB\u0019\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\r\u001a\u00020\u000eH\u0082\u0080\u0004R\u0015\u0010\u0003\u001a\u00020\u0004X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0005\u001a\u00020\u0006X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lni/shikatu/kotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lni/shikatu/kotlin/io/Serializable;", "pattern", _UrlKt.FRAGMENT_ENCODE_SET, "flags", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;I)V", "getPattern", "()Ljava/lang/String;", "getFlags", "()I", "readResolve", _UrlKt.FRAGMENT_ENCODE_SET, "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final class Serialized implements Serializable {
        public static final Companion Companion = new Companion(null);
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlin/text/Regex$Serialized$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "serialVersionUID", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public Serialized(String pattern, int flags) {
            Intrinsics.checkNotNullParameter(pattern, "pattern");
            this.pattern = pattern;
            this.flags = flags;
        }

        public final int getFlags() {
            return this.flags;
        }

        public final String getPattern() {
            return this.pattern;
        }

        private final Object readResolve() {
            Pattern patternCompile = Pattern.compile(this.pattern, this.flags);
            Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
            return new Regex(patternCompile);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0080\u0004J\u0012\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0080\u0004J\u0012\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0080\u0004J\u0012\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0082\u0080\u0004¨\u0006\r"}, d2 = {"Lni/shikatu/kotlin/text/Regex$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "fromLiteral", "Lni/shikatu/kotlin/text/Regex;", "literal", _UrlKt.FRAGMENT_ENCODE_SET, "escape", "escapeReplacement", "ensureUnicodeCase", _UrlKt.FRAGMENT_ENCODE_SET, "flags", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Regex fromLiteral(String literal) {
            Intrinsics.checkNotNullParameter(literal, "literal");
            return new Regex(literal, RegexOption.LITERAL);
        }

        public final String escape(String literal) {
            Intrinsics.checkNotNullParameter(literal, "literal");
            String strQuote = Pattern.quote(literal);
            Intrinsics.checkNotNullExpressionValue(strQuote, "quote(...)");
            return strQuote;
        }

        public final String escapeReplacement(String literal) {
            Intrinsics.checkNotNullParameter(literal, "literal");
            String strQuoteReplacement = Matcher.quoteReplacement(literal);
            Intrinsics.checkNotNullExpressionValue(strQuoteReplacement, "quoteReplacement(...)");
            return strQuoteReplacement;
        }

        public final int ensureUnicodeCase(int flags) {
            return (flags & 2) != 0 ? flags | 64 : flags;
        }
    }
}
