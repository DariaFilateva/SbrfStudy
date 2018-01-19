package genericsTasks;

/**
 * Created by Dasha on 19.01.2018.
 * Реализуйте generic-класс Pair, похожий на Optional,
 * но содержащий пару элементов разных типов и не запрещающий элементам принимать значение null.
 * <p>
 * Реализуйте методы getFirst(), getSecond(), equals() и hashCode(), а также статический фабричный метод of(). Конструктор должен быть закрытым (private).
 * <p>
 * С корректно реализованным классом Pair должен компилироваться и успешно работать следующий код:
 * <p>
 * Pair<Integer, String> pair = Pair.of(1, "hello");
 * Integer i = pair.getFirst(); // 1
 * String s = pair.getSecond(); // "hello"
 * <p>
 * Pair<Integer, String> pair2 = Pair.of(1, "hello");
 * boolean mustBeTrue = pair.equals(pair2); // true!
 * boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
 * <p>
 * <p>
 * Пожалуйста, не меняйте модификатор доступа класса Pair. Для корректной проверки класс должен иметь пакетную видимость.
 */
public class Pair<T, S> {
    T t;
    S s;

    private Pair(T t, S s) {
        this.t = t;
        this.s = s;
    }

    public static <T, S> Pair<T, S> of(T t, S s) {
        return new Pair<>(t, s);
    }

    public T getFirst() {
        return t;
    }

    public S getSecond() {
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (t != null ? !t.equals(pair.t) : pair.t != null) return false;
        if (s != null ? !s.equals(pair.s) : pair.s != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = t != null ? t.hashCode() : 0;
        result = 31 * result + (s != null ? s.hashCode() : 0);
        return result;
    }
}
