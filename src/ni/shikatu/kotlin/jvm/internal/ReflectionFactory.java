package ni.shikatu.kotlin.jvm.internal;

import java.util.List;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlin.reflect.KClassifier;
import ni.shikatu.kotlin.reflect.KDeclarationContainer;
import ni.shikatu.kotlin.reflect.KFunction;
import ni.shikatu.kotlin.reflect.KMutableProperty0;
import ni.shikatu.kotlin.reflect.KMutableProperty1;
import ni.shikatu.kotlin.reflect.KMutableProperty2;
import ni.shikatu.kotlin.reflect.KProperty0;
import ni.shikatu.kotlin.reflect.KProperty1;
import ni.shikatu.kotlin.reflect.KProperty2;
import ni.shikatu.kotlin.reflect.KType;
import ni.shikatu.kotlin.reflect.KTypeParameter;
import ni.shikatu.kotlin.reflect.KTypeProjection;
import ni.shikatu.kotlin.reflect.KVariance;

public class ReflectionFactory {
    private static final String KOTLIN_JVM_FUNCTIONS = "ni.shikatu.kotlin.jvm.functions.";

    public KClass createKotlinClass(Class javaClass) {
        return new ClassReference(javaClass);
    }

    public KClass createKotlinClass(Class javaClass, String internalName) {
        return new ClassReference(javaClass);
    }

    public KDeclarationContainer getOrCreateKotlinPackage(Class javaClass, String moduleName) {
        return new PackageReference(javaClass, moduleName);
    }

    public KClass getOrCreateKotlinClass(Class javaClass) {
        return new ClassReference(javaClass);
    }

    public KClass getOrCreateKotlinClass(Class javaClass, String internalName) {
        return new ClassReference(javaClass);
    }

    public String renderLambdaToString(Lambda lambda) {
        return renderLambdaToString((FunctionBase) lambda);
    }

    public String renderLambdaToString(FunctionBase lambda) {
        String result = lambda.getClass().getGenericInterfaces()[0].toString();
        return result.startsWith(KOTLIN_JVM_FUNCTIONS) ? result.substring(KOTLIN_JVM_FUNCTIONS.length()) : result;
    }

    public KFunction function(FunctionReference f) {
        return f;
    }

    public KProperty0 property0(PropertyReference0 p) {
        return p;
    }

    public KMutableProperty0 mutableProperty0(MutablePropertyReference0 p) {
        return p;
    }

    public KProperty1 property1(PropertyReference1 p) {
        return p;
    }

    public KMutableProperty1 mutableProperty1(MutablePropertyReference1 p) {
        return p;
    }

    public KProperty2 property2(PropertyReference2 p) {
        return p;
    }

    public KMutableProperty2 mutableProperty2(MutablePropertyReference2 p) {
        return p;
    }

    public KType typeOf(KClassifier klass, List<KTypeProjection> arguments, boolean isMarkedNullable) {
        return new TypeReference(klass, arguments, isMarkedNullable);
    }

    public KTypeParameter typeParameter(Object container, String name, KVariance variance, boolean isReified) {
        return new TypeParameterReference(container, name, variance, isReified);
    }

    public void setUpperBounds(KTypeParameter typeParameter, List<KType> bounds) {
        ((TypeParameterReference) typeParameter).setUpperBounds(bounds);
    }

    public KType platformType(KType lowerBound, KType upperBound) {
        return new TypeReference(lowerBound.getClassifier(), lowerBound.getArguments(), upperBound, ((TypeReference) lowerBound).getFlags$kotlin_stdlib());
    }

    public KType mutableCollectionType(KType type) {
        TypeReference typeRef = (TypeReference) type;
        return new TypeReference(type.getClassifier(), type.getArguments(), typeRef.getPlatformTypeUpperBound$kotlin_stdlib(), typeRef.getFlags$kotlin_stdlib() | 2);
    }

    public KType nothingType(KType type) {
        TypeReference typeRef = (TypeReference) type;
        return new TypeReference(type.getClassifier(), type.getArguments(), typeRef.getPlatformTypeUpperBound$kotlin_stdlib(), typeRef.getFlags$kotlin_stdlib() | 4);
    }
}
