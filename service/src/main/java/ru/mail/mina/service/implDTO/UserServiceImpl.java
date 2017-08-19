package ru.mail.mina.service.implDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mail.mina.repository.dao.UserGenericHibernateDao;
import ru.mail.mina.repository.model.Role;
import ru.mail.mina.repository.model.User;
import ru.mail.mina.service.dto.UserService;
import ru.mail.mina.service.modelDTO.UserDTO;
import ru.mail.mina.service.util.UserConverter;


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

    //    private static  UserHibernateDaoImpl userHibernateDao = UserHibernateDaoImpl.getInstance();
//    @Transactional
//    public Integer insert(UserDTO userDTO) {
//        Integer number = null;
//        User user = new User();
//        user.setUsername(userDTO.getUsername());
//        user.setEmail(userDTO.getEmail());
//        user.setPassword(userDTO.getPassword());
//        try {
//            number = userGenericHibernateDao.insert(user);
//        } catch (Exception e) {
//        } finally {
//        }
//        return number;
//    }

    @Override
    @Transactional
    public UserDTO GetByUserName(String username) {
        User user = userGenericHibernateDao.getByUserName(username);
        UserDTO userDTO = UserConverter.convert(user);
        return userDTO;
    }
}
