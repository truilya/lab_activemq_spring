package springJMS.jms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class Listener {

    @Autowired
    private Producer producer;

    @JmsListener(destination = "testQueue")
    public void recieve(Message message) throws JMSException {
        if (message instanceof TextMessage){
            producer.send("testQueue2",((TextMessage) message).getText());
        }
    }

}
