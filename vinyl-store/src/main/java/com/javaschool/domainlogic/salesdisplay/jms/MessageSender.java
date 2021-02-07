package com.javaschool.domainlogic.salesdisplay.jms;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Log4j
@Component
public class MessageSender {

    @Autowired
    @Qualifier("jmsQueueTemplate")
    private JmsTemplate jmsTemplate;

    public void sendMessage() {
        MessageCreator messageCreator = session -> session.createTextMessage("update best products");
        jmsTemplate.send(messageCreator);
    }

}
