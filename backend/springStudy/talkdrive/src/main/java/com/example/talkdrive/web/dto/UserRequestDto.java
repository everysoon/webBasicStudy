package com.example.talkdrive.web.dto;

import com.example.talkdrive.domain.entitiy.User;
import com.example.talkdrive.domain.entitiy.enums.user.Bank;
import com.example.talkdrive.domain.entitiy.enums.user.Mbti;
import com.example.talkdrive.domain.entitiy.enums.user.Role;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRequestDto {

    @Getter
    @RequiredArgsConstructor
    public static class UserPost {
        @NotNull(message = "아이디를 필수로 입력하셔야됩니다.")
        private String userId;

        @NotNull(message = "비밀번호를 필수로 입력하셔야됩니다.")
        @Pattern(regexp = "(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\\\(\\\\)\\-_=+]).{8,16}$",
                message = "비밀번호는 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 16자의 비밀번호여야 합니다.")
        private String password;

        private String userMbti;

        private String userNick;

        @Size(max = 500, message = "최대 500자 까지 작성")
        private String userIntroduce;

        private String userBank;

        private String userAccount;

        private String userSecurityNum;

        public User toEntity() {
            return User.builder()
                    .vcUserId(userId)
                    .vcUserPw(password)
                    .vcUserMBTI(Mbti.find(userMbti))
                    .vcUserNick(userNick)
                    .vcUserIntroduce(userIntroduce)
                    .vcUserBank(Bank.find(userBank))
                    .vcUserAccount(userAccount)
                    .vcUserSecurityNum(userSecurityNum)
                    .vcLoginMethod(Role.USER)
                    .build();
        }
    }
}
