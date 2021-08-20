package com.login.app.mapper;

import com.login.app.dto.UserGetDTO;
import com.login.app.dto.UserPostDTO;
import com.shopping.cart.dto.*;
import com.login.app.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {

    UserGetDTO userToUserGetDto(User user);

    User userPostDTOToUser(UserPostDTO postDTO);

    List<UserGetDTO> usersToUserGetDTOs(List<User> userList);

}
