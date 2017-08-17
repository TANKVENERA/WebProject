package ru.mail.mina.service.implDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mail.mina.repository.impl.UserHibernateDaoImpl;
import ru.mail.mina.repository.model.User;
import ru.mail.mina.service.dto.UserService;
import ru.mail.mina.service.modelDTO.UserDTO;
import ru.mail.mina.service.util.UserConverter;


/**
 * Created by Администратор on 25.07.2017.
 */

@Service("UserService")
public class UserServicempl implements UserService {


    private final UserHibernateDaoImpl userHibernateDaoImpl;

    @Autowired
    public UserServicempl(UserHibernateDaoImpl userHibernateDaoImpl) {
        this.userHibernateDaoImpl = userHibernateDaoImpl;
    }

    @Override
    public Integer saveUser(UserDTO userDTO) {
       User user = UserConverter.convert(userDTO);
        return userHibernateDaoImpl.insert(user);
    }

    private static  UserHibernateDaoImpl userHibernateDao = UserHibernateDaoImpl.getInstance();

    public Integer insert (UserDTO userDTO) {
        Integer number = null;
        User user = new User();
        user.setLogin(userDTO.getLogin());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        try {
          //  session.beginTransaction();
            number = userHibernateDao.insert(user);
         ///   session.getTransaction().commit();
        } catch (Exception e) {

        }finally {
         //   if (session != null && session.isOpen()) {
          //      session.close();
         //   }
        }
        return number;
    }

}
