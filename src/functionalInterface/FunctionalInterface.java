package functionalInterface;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Dasha on 20.01.
 * Дан предикат condition и две функции ifTrue и ifFalse.
 * Напишите метод ternaryOperator, который из них построит новую функцию,
 * возвращающую значение функции ifTrue, если предикат выполнен, и значение ifFalse иначе..
 */
public class FunctionalInterface {

    /**
     * @param condition- предикат
     * @param ifTrue     - функция
     * @param ifFalse    - функция
     * @param <T> - Супер тип для пар-ра
     * @param <U> - Родитель пар-ра
     * @return - новая функция, возвращающая значение функции ifTrue, если предикат выполнен, и значение ifFalse иначе
     */
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }

    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
        System.out.println(safeStringLength);
    }
}
