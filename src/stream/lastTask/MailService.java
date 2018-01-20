package stream.lastTask;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by Dasha on 20.01.2018.
 */
public class MailService<T> extends HashMap implements Consumer<MailMessage> {

    @Override
    public void accept(MailMessage mailMessage) {
        List list = this.getMailBox().get(mailMessage.getTo());
        if (list == null) {
            list = new LinkedList<>();
            this.getMailBox().put(mailMessage.getTo(), list);
        }
        list.add(mailMessage.<T>getValue());
    }

    public Map<String, List<T>> getMailBox() {
        return this;
    }

    @Override
    public List get(Object key) {
        if (containsKey(key)) {
            return (List) super.get(key);
        } else {
            List list = new LinkedList<>();
            this.getMailBox().put((String) key, list);
            return list;
        }
    }
}