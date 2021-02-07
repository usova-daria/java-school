package bean;

import lombok.extern.log4j.Log4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQMessageConsumer;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;
import java.util.Objects;

@Log4j
@Singleton
public class ReceiverConfigBean {

    @Inject
    private StandUpdateListener listener;

    @Inject
    @ConfigProperty(name = "broker-url")
    private String brokerUrl;

    @Inject
    @ConfigProperty(name = "destination")
    private String destination;

    private Connection connection = null;
    private Session session = null;

    public void openConnection() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(brokerUrl);
        try {
            connection = connectionFactory.createQueueConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue(destination);

            ActiveMQMessageConsumer messageConsumer = (ActiveMQMessageConsumer) session.createConsumer(queue);
            messageConsumer.setMessageListener(listener);
        } catch (JMSException e) {
            log.error("An error occurred while opening JMS connection", e);
        }
    }

    @PreDestroy
    public void closeConnection() {
        try {
            if (Objects.nonNull(connection) || Objects.nonNull(session)) {
                session.close();
                connection.close();
            }
        } catch (JMSException e) {
            log.error("An error occurred while closing JMS connection", e);
        }
    }

}
