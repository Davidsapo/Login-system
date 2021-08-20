package com.login.app.service;

import com.login.app.entity.User;
import com.login.app.dto.UserGetDTO;
import com.login.app.dto.UserPostDTO;

import java.util.List;

public interface UserService {

    User addNewUser(UserPostDTO userPostDTO);

    List<UserGetDTO> getAllPersons();

    UserGetDTO getAuthorizedPersonGetDTO();

    void loginUser(User user);

}
