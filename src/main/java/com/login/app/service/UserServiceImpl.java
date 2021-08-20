package com.login.app.service;

import com.login.app.entity.User;
import com.login.app.enums.Role;
import com.login.app.exception.exceptions.NonUniqueValueException;
import com.login.app.mapper.Mapper;
import com.login.app.repository.UserRepository;
import com.login.app.dto.UserGetDTO;
import com.login.app.dto.UserPostDTO;
import com.login.app.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final Mapper mapper;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Mapper mapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User addNewUser(UserPostDTO userPostDTO) {
        if (userRepository.existsByEmailIgnoreCase(userPostDTO.getEmail())) {
            throw new NonUniqueValueException("Person", "email", userPostDTO.getEmail());
        }
        User user = mapper.userPostDTOToUser(userPostDTO);
        user.setRole(Role.USER);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
       return user;
    }

    @Override
    public List<UserGetDTO> getAllPersons() {
        return mapper.usersToUserGetDTOs(userRepository.findAll());
    }


    @Override
    public UserGetDTO getAuthorizedPersonGetDTO() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.getByEmail(userName);
        return mapper.userToUserGetDto(user);
    }

    @Override
    public void loginUser(User user) {
        CustomUserDetails userDetails = new CustomUserDetails(user);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

}
