package ru.mail.mina.repository.impl;

import ru.mail.mina.repository.dao.CarPhotosGenericHibernateDao;
import ru.mail.mina.repository.model.CarPhotos;

/**
 * Created by Администратор on 06.08.2017.
 */
public class CarPhotosGenericHibernateDaoImpl extends GenericHibernateDaoImpl<CarPhotos, Integer> implements CarPhotosGenericHibernateDao {

    public CarPhotosGenericHibernateDaoImpl() {
        super(CarPhotos.class);
    }
}
