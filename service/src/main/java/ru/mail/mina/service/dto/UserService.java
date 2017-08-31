package ru.mail.mina.service.dto;

import org.springframework.stereotype.Service;
import ru.mail.mina.service.model.UserDTO;

import java.util.List;

/**
 * Created by Администратор on 13.08.2017.
 */
@Service
public interface UserService {

    Integer saveUser (UserDTO userDTO);

    UserDTO getByUserName(String username);

    void update (UserDTO userDTO);

    void saveOrUpdate(UserDTO userDTO);

    List<UserDTO> findAll();

    UserDTO getUserById (Integer id);

    void deleteUser (Integer id);

}
