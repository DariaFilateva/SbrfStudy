package stream;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

/**
 * Created by Dasha on 20.01.2018.
 * Напишите метод, находящий в стриме минимальный и максимальный элементы в соответствии порядком, заданным Comparator'ом.
 * <p>
 * Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:
 * <p>
 * minMaxConsumer.accept(min, max);
 * Если стрим не содержит элементов, то вызовите
 * minMaxConsumer.accept(null, null);
 */
public class StreamMinMax {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        Object[] items = stream.sorted(order).toArray();
        if (items.length == 0) {
            minMaxConsumer.accept(null, null);
        } else {
            T min = (T) items[0];
            T max = (T) items[items.length - 1];

            minMaxConsumer.accept(min, max);
        }
    }
}
