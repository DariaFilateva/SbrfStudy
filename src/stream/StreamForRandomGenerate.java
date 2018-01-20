package stream;

import java.util.stream.IntStream;

/**
 * Created by Dasha on 20.01.2018.
 * Напишите метод, возвращающий стрим псевдослучайных целых чисел. Алгоритм генерации чисел следующий:
 * <p>
 * Берется какое-то начальное неотрицательное число (оно будет передаваться в ваш метод проверяющей системой).
 * Первый элемент последовательности устанавливается равным этому числу.
 * Следующие элементы вычисляются по рекуррентной формуле
 * Rn+1=mid(R2n)Rn+1=mid(Rn2), где mid — это функция,
 * выделяющая второй, третий и четвертый разряд переданного числа.
 * Например, mid(123456)=345mid(123456)=345.
 */
public class StreamForRandomGenerate {

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> (n * n) / 10 % 1000);
    }

    public static void main(String[] args) {
        pseudoRandomStream(13);
    }
}
