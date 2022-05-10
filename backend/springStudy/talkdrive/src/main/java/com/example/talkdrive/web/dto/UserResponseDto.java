package com.example.talkdrive.web.dto;

import com.example.talkdrive.domain.entitiy.User;
import com.example.talkdrive.domain.entitiy.enums.user.Bank;
import com.example.talkdrive.domain.entitiy.enums.user.Mbti;
import com.example.talkdrive.domain.entitiy.enums.user.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserResponseDto {

    @Getter
    @RequiredArgsConstructor
    public static class FindOne {

        private String userId;

        private String password;

        private String userMbti;

        @Builder
        public FindOne(User user) {
            this.userId = user.getVcUserId();
            this.password = user.getVcUserPw();
            this.userMbti = user.getVcUserMBTI().getName();
        }
    }
}
