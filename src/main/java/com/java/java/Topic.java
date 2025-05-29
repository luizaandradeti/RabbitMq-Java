package com.java.java;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Topic {

    public static void main(String[] args) throws Exception {


        InitialContext context = new InitialContext();
        Topic sistemaTopico = (Topic) context.lookup("topic/sistemaTopico");

        ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = connectionFactory.createConnection();

        Session session = connection.createSession();
        MessageProducer producer = session.createProducer(sistemaTopico);

        MessageConsumer api = session.createConsumer(sistemaTopico);
        MessageConsumer sustentacao = session.createConsumer(sistemaTopico);

        TextMessage message = session.createTextMessage("Send.");

        producer.send(message);

        connection.start();
        // TODO

    }

}







