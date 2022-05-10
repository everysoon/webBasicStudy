package com.example.talkdrive.domain.entitiy;

import com.example.talkdrive.domain.entitiy.enums.user.Bank;
import com.example.talkdrive.domain.entitiy.enums.user.Mbti;
import com.example.talkdrive.domain.entitiy.enums.user.Role;
import com.example.talkdrive.domain.entitiy.enums.user.State;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@RequiredArgsConstructor
public class User extends BaseTime {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String vcUserId;

    @Column(nullable = false)
    private String vcUserPw;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Mbti vcUserMBTI;

    @Column(nullable = true)
    private String vcUserNick;

    @Column(nullable = true, length = 1000)
    private String vcUserIntroduce;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Bank vcUserBank;

    @Column(nullable = true)
    private String vcUserAccount;

    @Column(nullable = true)
    private String vcUserSecurityNum;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private State nUserState;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role vcLoginMethod;

    @Builder
    public User(String vcUserId, String vcUserPw, Mbti vcUserMBTI, String vcUserNick, String vcUserIntroduce, Bank vcUserBank, String vcUserAccount, String vcUserSecurityNum, Role vcLoginMethod) {
        this.vcUserId = vcUserId;
        this.vcUserPw = vcUserPw;
        this.vcUserMBTI = vcUserMBTI;
        this.vcUserNick = vcUserNick;
        this.vcUserIntroduce = vcUserIntroduce;
        this.vcUserBank =  vcUserBank;
        if(!vcUserBank.equals(Bank.EMPTY)){
            this.vcUserAccount = vcUserAccount;
        }
        this.nUserState = State.UNABLETOGUIDE;
        this.vcUserSecurityNum = vcUserSecurityNum;
        this.vcLoginMethod = vcLoginMethod;

    }

}
