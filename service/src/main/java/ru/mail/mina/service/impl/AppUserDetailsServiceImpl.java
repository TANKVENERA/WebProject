package ru.mail.mina.service.impl;

/**
 * impl of {@link org.springframework.security.core.userdetails.UserDetailsService} interface
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mail.mina.repository.dao.UserGenericHibernateDao;
import ru.mail.mina.repository.model.User;
import ru.mail.mina.service.model.AppUserPrincipal;


@Service(value = "appUserDetailsService")
public class AppUserDetailsServiceImpl implements UserDetailsService {

    private final UserGenericHibernateDao userDao;

    @Autowired
    public AppUserDetailsServiceImpl(UserGenericHibernateDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        System.out.println(username);
        User user = userDao.getByUserName(username);
        if (user == null) {
            return null;
        }
        return new AppUserPrincipal(user);
    }
}