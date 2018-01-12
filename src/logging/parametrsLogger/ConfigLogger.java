package logging.parametrsLogger;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

/**
 * Created by Filateva on 12.01.2018.
 * <p>
 * В этой задаче вам нужно реализовать метод, настраивающий параметры логирования. Конфигурирование в коде позволяет выполнить более тонкую и хитрую настройку, чем при помощи properties-файла.
 * <p>
 * Требуется выставить такие настройки, чтобы:
 * <p>
 * Логгер с именем "org.stepic.java.logging.ClassA" принимал сообщения всех уровней.
 * Логгер с именем "org.stepic.java.logging.ClassB" принимал только сообщения уровня WARNING и серьезнее.
 * Все сообщения, пришедшие от нижестоящих логгеров на уровень "org.stepic.java", независимо от серьезности сообщения печатались в консоль в формате XML (*) и не передавались вышестоящим обработчикам на уровнях "org.stepic", "org" и "".
 * Не упомянутые здесь настройки изменяться не должны.
 */
public class ConfigLogger {
    private static void configureLogging() {

        // Логгер сообщений всех уровней
        Logger loggerAll = Logger.getLogger("org.stepic.java.logging.ClassA");
        loggerAll.setLevel(Level.ALL);

        // Логгер сообщений всех уровней WARNING и серьезнее
        Logger loggerSev = Logger.getLogger("org.stepic.java.logging.ClassB");
        loggerSev.setLevel(Level.WARNING);

        Logger logger = Logger.getLogger("org.stepic.java");
        XMLFormatter xmlFormatter = new XMLFormatter();
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(xmlFormatter);
        logger.addHandler(consoleHandler);
        logger.setUseParentHandlers(false);
    }
}
