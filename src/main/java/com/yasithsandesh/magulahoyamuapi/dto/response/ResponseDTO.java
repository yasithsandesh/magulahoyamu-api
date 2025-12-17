package com.yasithsandesh.magulahoyamuapi.dto.response;


import lombok.Data;

@Data
public class ResponseDTO<T> {
    T data;
    String message;
    boolean success;
}
