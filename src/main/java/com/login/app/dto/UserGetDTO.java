package com.login.app.dto;

import com.login.app.enums.Role;
import lombok.Data;

@Data
public class UserGetDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private Role role;

    private String email;

}
