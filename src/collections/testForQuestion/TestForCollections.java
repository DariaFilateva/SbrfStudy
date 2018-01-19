package collections.testForQuestion;

import javafx.beans.property.ListProperty;

import java.util.*;

/**
 * Created by Dasha on 19.01.2018.
 * Предположим, у нас есть две переменных:
 * <p>
 * Collection<?> collection = ...;
 * Object object = ...;
 * <p>
 * <p>
 * Какие операции над collection допустимы?
 */
public class TestForCollections {
    public static void main(String[] args) {
        Collection<?> collection = new HashSet<>();
        Object object = new Object();
        System.out.println(collection.size());
        System.out.println(collection.contains(object));
        System.out.println(collection.iterator());
        collection.clear();
       // collection.addAll(Arrays.asList(object));
        collection.toArray();
       // collection.add(object);
        collection.remove(object);
    }
}

