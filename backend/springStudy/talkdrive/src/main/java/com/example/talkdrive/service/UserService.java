package com.example.talkdrive.service;

import com.example.talkdrive.domain.entitiy.User;
import com.example.talkdrive.domain.repository.UserRepository;
import com.example.talkdrive.exception.user.UserCustomException;
import com.example.talkdrive.exception.user.UserErrorCode;
import com.example.talkdrive.web.dto.UserRequestDto;
import com.example.talkdrive.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final  UserRepository userRepository;

    @Transactional
    public Long save (UserRequestDto.UserPost userPost) {
        return userRepository.save(userPost.toEntity()).getId();
    }

    @Transactional
    public UserResponseDto.FindOne findOne (Long userId) {
        if(!userRepository.existsById(userId)){
            throw new UserCustomException(UserErrorCode.NOT_EXIST_USER);
        }
        User user = userRepository.findById(userId).get();
        UserResponseDto.FindOne userResDto = UserResponseDto.FindOne.builder().user(user).build();
        return userResDto;
    }

}
