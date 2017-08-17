package ru.mail.mina.repository.impl;

import ru.mail.mina.repository.dao.MessageGenericHibernateDao;
import ru.mail.mina.repository.model.Message;

/**
 * Created by Администратор on 25.07.2017.
 */
public class MessageGenericHibernateDaoImpl extends GenericHibernateDaoImpl<Message, Integer> implements MessageGenericHibernateDao {

    public MessageGenericHibernateDaoImpl() {
        super(Message.class);
    }
}
