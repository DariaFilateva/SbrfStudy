package collections.testForQuestion.symmetricDiference;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dasha on 19.01.2018.
 * еализуйте метод, вычисляющий симметрическую разность двух множеств.
 * <p>
 * Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.
 * <p>
 * Пример
 * <p>
 * Симметрическая разность множеств {1, 2, 3} и {0, 1, 2} равна {0, 3}.
 */
public class SymmetricDifference {

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        HashSet<T> outPut = new HashSet<>();
        for (T t : set1) {
            if (!set2.contains(t)) outPut.add(t);
        }
        for (T t : set2) {
            if (!set1.contains(t)) outPut.add(t);
        }
        return outPut;
    }

    public static void main(String[] args) {
        HashSet set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        HashSet set2 = new HashSet<>();
        set2.add(0);
        set2.add(1);
        set2.add(2);

        System.out.println(symmetricDifference(set1, set2));
    }
}
