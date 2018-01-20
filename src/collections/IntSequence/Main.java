package collections.IntSequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Dasha on 20.01.2018.
 * Напишите программу, которая прочитает из System.in последовательность целых чисел,
 * разделенных пробелами, затем удалит из них все числа, стоящие на четных позициях,
 * и затем выведет получившуюся последовательность в обратном порядке в System.out.
 * <p>
 * Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.
 * <p>
 * В этом задании надо написать программу целиком, включая import'ы, декларацию класса Main и метода main.
 */
public class Main {

    public static void doThisTask(List<Integer> list) {
        int i = 1;
        ArrayList<Integer> newList = new ArrayList();
        while (i <= list.size() - 1) {
            newList.add(list.get(i));
            i = i + 2;
        }
        Collections.reverse(newList);
        for (Integer integer : newList)
            System.out.print(integer + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        doThisTask(list);
    }
}
