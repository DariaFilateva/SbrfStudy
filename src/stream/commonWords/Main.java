package stream.commonWords;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by Dasha on 20.01.2018.
 * Напишите программу, читающую из System.in текст в кодировке UTF-8,
 * подсчитывающую в нем частоту появления слов, и в конце выводящую 10 наиболее часто встречающихся слов.
 * <p>
 * Словом будем считать любую непрерывную последовательность символов,
 * состоящую только из букв и цифр. Например, в строке "Мама мыла раму 33 раза!"
 * ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".
 * <p>
 * Подсчет слов должен выполняться без учета регистра,
 * т.е. "МАМА", "мама" и "Мама" — это одно и то же слово. Выводите слова в нижнем регистре.
 * <p>
 * Если в тексте меньше 10 уникальных слов, то выводите сколько есть.
 * <p>
 * Если в тексте некоторые слова имеют одинаковую частоту,
 * т.е. их нельзя однозначно упорядочить только по частоте,
 * то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.
 */
public class Main {

    public static void getCommonWords(ArrayList<String> words) {
        Map<String, Integer> countsAndWords = words.stream().collect(Collectors.toConcurrentMap(n -> n, n -> 1, Integer::sum));

        countsAndWords.entrySet().stream().sorted(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) return o1.getKey().compareTo(o2.getKey());
                if (o1.getValue() < o2.getValue()) return 1;
                if (o1.getValue() > o2.getValue()) return -1;
                return 0;
            }
        }).limit(10).forEach(new Consumer<Map.Entry<String, Integer>>() {
            @Override
            public void accept(Map.Entry<String, Integer> stringIntegerEntry) {
                System.out.println(stringIntegerEntry.getKey());
            }
        });
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "UTF-8");
        ArrayList<String> words = new ArrayList();
        while (sc.hasNext()) {
            words.addAll(Arrays.asList(sc.next().toLowerCase().split("[^\\p{L}\\p{Digit}_]+")));
        }
        getCommonWords(words);
    }
}
