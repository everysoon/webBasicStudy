package com.example.talkdrive.exception.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum UserErrorCode {


    NOT_EXIST_USER(HttpStatus.NOT_FOUND, "회원이 존재하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String detail;
}
