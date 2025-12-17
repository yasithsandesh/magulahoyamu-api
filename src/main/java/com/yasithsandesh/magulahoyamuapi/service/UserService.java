package com.yasithsandesh.magulahoyamuapi.service;

import com.yasithsandesh.magulahoyamuapi.dto.request.CreateAccountDTO;
import com.yasithsandesh.magulahoyamuapi.dto.response.ResponseDTO;

public interface UserService {

    ResponseDTO createAccount(CreateAccountDTO createAccountDTO);
    ResponseDTO login(String email, String password);
}
