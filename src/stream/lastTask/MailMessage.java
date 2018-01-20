package stream.lastTask;

/**
 * Created by Dasha on 20.01.2018.
 */
public class MailMessage {
    private String from, to, content;

    MailMessage(String from, String to, String content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getContent() {
        return content;
    }

    public <T> T getValue() {
        return (T) this.getContent();
    }
}
