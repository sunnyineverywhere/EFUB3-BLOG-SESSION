package blog.sunn.domain.account.domain;

import blog.sunn.domain.account.domain.AccountStatus;
import blog.sunn.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import static blog.sunn.domain.account.domain.AccountStatus.REGISTERED;
import static blog.sunn.domain.account.domain.AccountStatus.UNREGISTERED;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", updatable = false)
    private Long accountId;

    @Column(nullable = false, length = 60)//DB에 저장될 때 조건(물리적인 데이터베이스 컬럼의 특성을 나타냄), 유효성 체크를 해주지는 않음
    private String email;


    @Column(nullable = false)
    private String encodedPassword;

    @Column(nullable = false, updatable = false, length = 16)
    private String nickname;// 닉네임 변경 불가

    private String bio;//length 따로 지정하지 않으면 기본적으로 255이다.

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @Builder
    public Account(String email, String password, String nickname, String bio) {
        this.email = email;
        this.encodedPassword = password;
        this.nickname = nickname;
        this.bio = bio;
        this.status = REGISTERED;
    }

    public void updateAccount(String bio, String nickname){
        this.bio = bio;
        this.nickname = nickname;
    }

    public void withdrawAccount(){
        this.status = UNREGISTERED;
    }


}
