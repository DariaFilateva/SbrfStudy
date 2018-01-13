package logging.loggerAndException;

/**
 * 4) Inspector – Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу в виде исключения,
 * если была обнаружена подобная посылка.
 * Если он заметил запрещенную посылку с одним из запрещенных содержимым
 * ("weapons" и "banned substance"), то он бросает IllegalPackageException.
 * Если он находит посылку, состоящую из камней (содержит слово "stones"),
 * то тревога прозвучит в виде StolenPackageException.
 * Оба исключения вы должны объявить самостоятельно в виде непроверяемых исключений.
 */
public class Inspector implements MailService {

    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            Package p = ((MailPackage) mail).getContent();
            if (p.getContent().equals(WEAPONS) || p.getContent()
                    .equals(BANNED_SUBSTANCE)) {
                throw new IllegalPackageException();
            }
            if (p.getContent().contains("stones")) throw new StolenPackageException();
        }
        return mail;
    }
}
