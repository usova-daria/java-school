package bean;

import lombok.extern.log4j.Log4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@Log4j
@Dependent
public class StandUpdateListener implements MessageListener {

    @Inject
    private BestProductsView bestProducts;

    @Override
    public void onMessage(Message message) {
        try {
            log.info("Message " + message.getJMSMessageID() + " received");
            processMessage(message);
        } catch (JMSException e) {
            log.error("An error occurred while processing the message", e);
        }
    }

    private void processMessage(Message message) throws JMSException {
        bestProducts.updateStand();
        log.info("Message " + message.getJMSMessageID() + " has been processed");
    }


}
