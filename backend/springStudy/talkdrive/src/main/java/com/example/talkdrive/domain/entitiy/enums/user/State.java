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
public enum State {
    ABLETOGUIDE(0, "가이드 신청자"),
    UNABLETOGUIDE(1, "가이드 미신청자");

    private final Integer key;
    private final String description;

}
