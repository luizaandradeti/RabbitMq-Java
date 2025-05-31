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
       TextMessage message1 = (TextMessage) api.receive();

        System.out.println("Rec1"+api.getText());
        TextMessage sustentacao = (TextMessage) sustentacao.receive();
        System.out.println("Consumer 2 "+sustentacao.getText());
        //https://www.ibm.com/docs/pt-br/was/8.5.5?topic=messaging-programming-use-jms-directly
        connection.close();
        initialContext.close();


    }

}
