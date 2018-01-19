package byteStreams.float6;

import java.nio.file.Path;
import java.util.Scanner;

/**
 * Напишите программу, читающую текст из System.in и выводящую в System.out
 * сумму всех встреченных в тексте вещественных чисел с точностью до шестого
 * знака после запятой.
 * Числом считается последовательность символов,
 * отделенная от окружающего текста пробелами или переводами строк и успешно разбираемая методом Double.parseDouble.
 */
public class Main {

    public static void sumFloat(Scanner sc) {
        double sum = 0;
        while (sc.hasNext()) {
            if (sc.hasNextDouble())
                sum += sc.nextDouble();
            else sc.next();
        }
        System.out.printf("%.6f", sum);
    }

    public static void main(String[] args) {
        System.out.println("Введите входные данные:");
        Scanner sc = new Scanner(System.in);
        sumFloat(sc);
    }
}
