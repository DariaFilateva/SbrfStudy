package logging.loggerAndException;

/**
 * 1) UntrustworthyMailWorker – класс, моделирующий ненадежного работника почты,
 * который вместо того, чтобы передать почтовый объект непосредственно в сервис почты,
 * последовательно передает этот объект набору третьих лиц, а затем, в конце концов,
 * передает получившийся объект непосредственно экземпляру RealMailService.
 * <p>
 * У UntrustworthyMailWorker должен быть конструктор от массива MailService
 * ( результат вызова processMail первого элемента массива передается на вход
 * processMail второго элемента, и т. д.) и метод getRealMailService,
 * который возвращает ссылку на внутренний экземпляр RealMailService.
 */
public class UntrustworthyMailWorker implements MailService {

    private RealMailService realMailService;
    private MailService[] mailServices;

    public UntrustworthyMailWorker(MailService[] mailServices) {
        this.mailServices = mailServices;
        this.realMailService = new RealMailService();
    }

    public RealMailService getRealMailService() {
        return realMailService;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        Sendable sendable = mail;
        for (MailService service : mailServices) {
            sendable = service.processMail(sendable);
        }
        return getRealMailService().processMail(sendable);
    }
}
