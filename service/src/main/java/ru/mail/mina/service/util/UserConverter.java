package ru.mail.mina.service.util;

import ru.mail.mina.repository.model.User;
import ru.mail.mina.service.modelDTO.UserDTO;

/**
 * Created by Администратор on 16.08.2017.
 */
public class UserConverter {

    private UserConverter() {

    }

    public static User convert(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    public static UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }
}
