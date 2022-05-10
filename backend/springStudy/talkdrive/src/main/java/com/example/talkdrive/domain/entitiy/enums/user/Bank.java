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
public enum Bank {
    EMPTY(0,"없음"),
    KOOKMIN(1,"국민은행"),
    SHINHAN(2,"신한은행");


    private final Integer key;
    private final String bankName;

    private static final Map<String, Bank> bankNames =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(Bank::getBankName, Function.identity())));

    public static Bank find(String bankName) {
        return Optional.ofNullable(bankNames.get(bankName)).orElse(EMPTY);
    }



}
