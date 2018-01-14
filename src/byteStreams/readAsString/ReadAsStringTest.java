package byteStreams.readAsString;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/**
 * Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.
 * Пример
 * InputStream последовательно возвращает четыре байта: 48 49 50 51.
 * Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку "0123".
 */
public class ReadAsStringTest {
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream, charset);
        int data;
        StringBuilder str = new StringBuilder("");
        while ((data = reader.read()) != -1) {
            str.append((char) data);
        }
        return str.toString();
    }

    public static void main(String[] args) throws IOException {
        byte[] bytes = {48, 49, 50, 51};
        ByteInputStream byteInputStream = new ByteInputStream(bytes, 4);
        System.out.println(readAsString(byteInputStream, Charset.forName("UTF-8")));
    }
}
