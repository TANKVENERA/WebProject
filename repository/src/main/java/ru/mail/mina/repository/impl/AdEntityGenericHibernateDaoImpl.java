package ru.mail.mina.repository.impl;

import org.springframework.stereotype.Repository;
import ru.mail.mina.repository.dao.AdEntityGenericHibernateDao;
import ru.mail.mina.repository.model.AdEntity;


/**
 * Created by Администратор on 06.08.2017.
 */
@Repository
public class AdEntityGenericHibernateDaoImpl extends GenericHibernateDaoImpl<AdEntity, Integer> implements AdEntityGenericHibernateDao {

    public AdEntityGenericHibernateDaoImpl() {
        super(AdEntity.class);
    }


}
