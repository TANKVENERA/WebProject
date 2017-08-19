package ru.mail.mina.service.dto;

import org.springframework.stereotype.Service;
import ru.mail.mina.repository.model.User;
import ru.mail.mina.service.modelDTO.UserDTO;

/**
 * Created by Администратор on 13.08.2017.
 */
@Service
public interface UserService {

    Integer saveUser (UserDTO userDTO);

    UserDTO GetByUserName(String username);

}
