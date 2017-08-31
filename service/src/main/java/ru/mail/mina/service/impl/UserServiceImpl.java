package ru.mail.mina.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mail.mina.repository.dao.UserGenericHibernateDao;
import ru.mail.mina.repository.model.Role;
import ru.mail.mina.repository.model.User;
import ru.mail.mina.service.dto.UserService;
import ru.mail.mina.service.model.UserDTO;
import ru.mail.mina.service.util.UserConverter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Администратор on 25.07.2017.
 */

@Service
public class UserServiceImpl implements UserService {


    private final UserGenericHibernateDao userGenericHibernateDao;

    private final PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserGenericHibernateDao userGenericHibernateDao,
                           PasswordEncoder bCryptPasswordEncoder) {
        this.userGenericHibernateDao = userGenericHibernateDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    @Transactional
    public Integer saveUser(UserDTO userDTO) {
        User user = UserConverter.convert(userDTO);
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setRole(Role.ROLE_User);
        return userGenericHibernateDao.insert(user);
    }

    @Override
    @Transactional
    public void update(UserDTO userDTO) {
        User user = UserConverter.convert(userDTO);
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setRole(Role.ROLE_User);
        userGenericHibernateDao.update(user);
    }

    @Override
    @Transactional
    public UserDTO getByUserName(String username) {
        User user = userGenericHibernateDao.getByUserName(username);
        UserDTO userDTO = UserConverter.convert(user);
        return userDTO;
    }

    @Override
    @Transactional
    public void saveOrUpdate(UserDTO userDTO) {
       User user = UserConverter.convert(userDTO);
       userGenericHibernateDao.saveOrUpdate(user);
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        userGenericHibernateDao.delete(id);
    }

    @Override
    @Transactional
    public List<UserDTO> findAll() {
        List<User> users = userGenericHibernateDao.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User element : users){
            userDTOS.add(UserConverter.convert(element));
        }
        return userDTOS;
    }

    @Override
    @Transactional
    public UserDTO getUserById(Integer id) {
        User user = userGenericHibernateDao.findById(id);
        UserDTO userDTO = UserConverter.convert(user);
        return userDTO;
    }
}
