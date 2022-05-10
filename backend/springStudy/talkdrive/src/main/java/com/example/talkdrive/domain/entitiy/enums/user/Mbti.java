package com.example.talkdrive.domain.entitiy.enums.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum Mbti {
    INTJ("INTJ"),
    INTP("INTP"),
    ENTJ("ENTJ"),
    ENTP("ENTP"),

    INFJ("INFJ"),
    INFP("INFP"),
    ENFJ("ENFJ"),
    ENFP("ENFP"),

    ISTJ("ISTJ"),
    ISFJ("ISFJ"),
    ESTJ("ESTJ"),
    ESFJ("ESFJ"),

    ISTP("ISTP"),
    ISFP("ISFP"),
    ESTP("ESTP"),
    ESFP("ESFP"),

    EMPTY("없음");

    private final String name;

    private static final Map<String, Mbti> mbtiNames =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(Mbti::getName, Function.identity())));

    public static Mbti find(String mbtiName) {
        return Optional.ofNullable(mbtiNames.get(mbtiName)).orElse(EMPTY);
    }
}
