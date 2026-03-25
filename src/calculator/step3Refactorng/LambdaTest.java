package calculator.step3Refactorng;

// Enum에서 BiFunction을 이용해서 람다식을 사용하였기 때문에 이제 필요없어짐
@FunctionalInterface
public interface LambdaTest {
    double apply (double a, double b);
}
