package com.example.talkdrive.domain.entitiy.enums.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 회원"),
    NAVER("ROLE_NAVER", "네이버 회원");


    private final String key;
    private final String description;

    private static final Map<String, Role> roleKey =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(Role::getKey, Function.identity())));

    public static Role find(String key) {
        return Optional.ofNullable(roleKey.get(key)).orElse(USER);
    }
}
