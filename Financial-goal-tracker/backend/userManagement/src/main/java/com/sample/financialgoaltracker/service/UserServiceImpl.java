package com.sample.financialgoaltracker.service;


import com.sample.financialgoaltracker.dto.UserDTO;
import com.sample.financialgoaltracker.entity.User;
import com.sample.financialgoaltracker.mapper.UserMapper;
import com.sample.financialgoaltracker.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> findAll() {
        List<User> users = (List<User>) userRepository.findAll();
        if(users!=null) {
            List<UserDTO> userDTOs = userMapper.convertToDtos(users);
            return userDTOs;
        }
        return null;
    }

    @Override
    public UserDTO findById(int id) {

        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            UserDTO userDTO = userMapper.convertToDTO(user.get());
            return userDTO;
        }
        return null;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {

        User user = userMapper.convertToEntity(userDTO);
        User updatedUser = userRepository.save(user);
        UserDTO updatedUserDTO = userMapper.convertToDTO(updatedUser);
        return updatedUserDTO;
    }

    @Override
    public UserDTO getUserByAuth0Id(String auth0Id) {

        Optional<User> user = userRepository.getUserByAuth0Id(auth0Id);
        if(user.isPresent()){
            UserDTO userDTO = userMapper.convertToDTO(user.get());
            return userDTO;
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {

        userRepository.deleteById(id);
        return true;
    }
}