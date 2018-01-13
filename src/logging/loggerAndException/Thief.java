package logging.loggerAndException;

/**
 * 3) Thief – вор, который ворует самые ценные посылки и игнорирует все остальное.
 * Вор принимает в конструкторе переменную int – минимальную стоимость посылки, которую он будет воровать.
 * Также, в данном классе должен присутствовать метод getStolenValue,
 * который возвращает суммарную стоимость всех посылок, которые он своровал.
 * Воровство происходит следующим образом: вместо посылки, которая пришла вору,
 * он отдает новую, такую же, только с нулевой ценностью и содержимым посылки "stones instead of {content}".
 */
public class Thief implements MailService {

    private int minPrice;
    private int sum;

    public Thief(int minPrice) {
        this.minPrice = minPrice;
        sum = 0;
    }

    public int getStolenValue() {
        return sum;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        MailPackage mailPackage;
        if (mail instanceof MailPackage) {
            mailPackage = (MailPackage) mail;
            Package p = mailPackage.getContent();
            if (p.getPrice() >= minPrice) {
                sum += p.getPrice();
                Package newP = new Package("stones instead of " + p.getContent(), 0);
                return new MailPackage(mailPackage.getFrom(), mailPackage.getTo(), newP);
            }
        }
        return mail;
    }
}
