package byteStreams.WindowsToUnix;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Напишите программу, которая будет преобразовывать переводы строк
 * из формата Windows в формат Unix. Данные в формате Windows подаются
 * программе в System.in, преобразованные данные должны выводиться в System.out.
 * На этот раз вам надо написать программу полностью,
 * т.е. объявить класс (с именем Main — таково ограничение проверяющей системы),
 * метод main, прописать все import'ы.
 */
public class Main {

    public static void changeWindowsToUnix(InputStream inputStream, OutputStream outputStream) throws IOException {
        int byte1 = inputStream.read();
        int byte2;
        while (byte1 != -1) {
            byte2 = inputStream.read();
            if (!(byte2 == 10 && byte1 == 13)) {
                outputStream.write(byte1);
            }
            byte1 = byte2;
        }
        outputStream.flush();
    }

    public static void main(String[] args) throws IOException {
        changeWindowsToUnix(System.in, System.out);
    }
}
