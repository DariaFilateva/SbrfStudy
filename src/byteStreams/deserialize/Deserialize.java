package byteStreams.deserialize;

import java.io.*;

/**
 * Реализуйте метод, который из переданного массива байт восстановит массив объектов Animal.
 * Массив байт устроен следующим образом.
 * Сначала идет число типа int, записанное при помощи ObjectOutputStream.writeInt(size).
 * Далее подряд записано указанное количество объектов типа Animal,
 * сериализованных при помощи ObjectOutputStream.writeObject(animal).
 * <p>
 * Если вдруг массив байт не является корректным представлением массива экземпляров Animal,
 * то метод должен бросить исключение java.lang.IllegalArgumentException.
 * <p>
 * Причины некорректности могут быть разные.
 * Попробуйте подать на вход методу разные некорректные данные и посмотрите,
 * какие исключения будут возникать. Вот их-то и нужно превратить в IllegalArgumentException и выбросить.
 * Если что-то забудете, то проверяющая система подскажет.
 * Главное не глотать никаких исключений, т.е. не оставлять нигде пустой catch.
 */
public class Deserialize {
    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] animals;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream((new ByteArrayInputStream(data)));
            int count = objectInputStream.readInt();
            animals = new Animal[count];
            for (int i = 0; i < count; i++) {
                try {
                    animals[i] = (Animal) objectInputStream.readObject();

                } catch (ClassNotFoundException e) {
                    throw new IllegalArgumentException(e);
                } catch (ClassCastException e) {
                    throw new IllegalArgumentException(e);
                }
            }
            return animals;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        Animal horse = new Animal("Лошадка");
        Animal cat = new Animal("Киса");
        Animal dog = new Animal("Пёс");
        Animal[] animals = {horse, cat, dog};
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeInt(3);
        oos.writeObject(horse);
        oos.writeObject(cat);
        oos.writeObject(dog);
        oos.close();
        Animal[] animal2 = deserializeAnimalArray(os.toByteArray());
        System.out.println(animal2.toString());
    }

}
