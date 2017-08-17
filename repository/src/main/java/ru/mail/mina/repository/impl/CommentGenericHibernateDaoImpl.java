package ru.mail.mina.repository.impl;

import ru.mail.mina.repository.dao.CommentGenericHibernateDao;
import ru.mail.mina.repository.model.Comment;

/**
 * Created by Администратор on 24.07.2017.
 */
public class CommentGenericHibernateDaoImpl extends GenericHibernateDaoImpl<Comment, Integer> implements CommentGenericHibernateDao {

    public CommentGenericHibernateDaoImpl() {
        super(Comment.class);
    }
}
