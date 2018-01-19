package byteStreams;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Напишите метод, читающий входной поток и вычисляющий контрольную сумму прочитанных данных.
 * <p>
 * Контрольная сумма данных вычисляется по следующему алгоритму:
 * <p>
 * Контрольная сумма представляет собой число типа int. Контрольная сумма пустого набора данных равна нулю.
 * Контрольная сумма непустого набора данных вычисляется по следующей рекуррентной формуле:
 * Cn+1=rotateLeft(Cn) xor bn+1Cn+1=rotateLeft(Cn) xor bn+1 ,
 * где CnCn — контрольная сумма первых n байт данных,
 * rotateLeft — циклический сдвиг бит числа на один бит влево
 * (чтобы не изобретать велосипед, используйте Integer.rotateLeft),
 * bnbn — n-ный байт данных.
 * Поскольку метод не открывал данный InputStream,
 * то и закрывать его он не должен. Выброшенное из методов InputStream исключение должно выбрасываться из метода.
 * <p>
 * Пример
 * На вход подан InputStream, последовательно возвращающий три байта:
 * 0x33 0x45 0x01. В качестве контрольной суммы должно быть возвращено число 71.
 */
public class ByteStreams {

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int control = 0;
        int data;
        while ((data = inputStream.read()) >= 0) {
            control = Integer.rotateLeft(control, 1) ^ data;
        }
        return control;
    }

    public static void main(String[] args) throws IOException {
        ByteArrayInputStream bytes = new ByteArrayInputStream(new byte[]{0x33, 0x45, 0x01});
        ByteArrayInputStream bytes0 = new ByteArrayInputStream(new byte[]{});
        System.out.println(checkSumOfStream(bytes));
        System.out.println(checkSumOfStream(bytes0));
    }
}
