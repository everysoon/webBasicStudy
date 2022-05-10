package com.example.talkdrive.exception.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserCustomException extends RuntimeException{
    private final UserErrorCode errorCode;
}
