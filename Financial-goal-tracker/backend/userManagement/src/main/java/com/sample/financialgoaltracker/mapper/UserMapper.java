package com.sample.financialgoaltracker.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.financialgoaltracker.dto.UserDTO;
import com.sample.financialgoaltracker.entity.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public User convertToEntity(UserDTO userDTO) {

        return modelMapper.map(userDTO, User.class);
    }

    public UserDTO convertToDTO(User user) {

        return modelMapper.map(user, UserDTO.class);
    }


    public List<UserDTO> convertToDtos(Collection<User> users) {
        return users.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public final List<User> convertToEntities(final Collection<UserDTO> userDTOS) {
        return userDTOS.stream().map(this::convertToEntity).collect(Collectors.toList());
    }
}
