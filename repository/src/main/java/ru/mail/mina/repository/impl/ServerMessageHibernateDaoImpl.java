package ru.mail.mina.repository.impl;

import ru.mail.mina.repository.dao.ServerMessageHibernateDao;
import ru.mail.mina.repository.model.ServerMessage;

/**
 * Created by Администратор on 25.07.2017.
 */
public class ServerMessageHibernateDaoImpl extends GenericHibernateDaoImpl<ServerMessage, Integer> implements ServerMessageHibernateDao {

    public ServerMessageHibernateDaoImpl() {
        super(ServerMessage.class);
    }
}
