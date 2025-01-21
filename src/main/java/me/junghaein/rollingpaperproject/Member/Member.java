package me.junghaein.rollingpaperproject.Member;

import jakarta.persistence.*;
import lombok.*;
import me.junghaein.rollingpaperproject.Message.Message;
import me.junghaein.rollingpaperproject.RollingPaper.RollingPaper;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Setter
@Table(name = "Member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "memberId", nullable = false)
    private String memberId;

    @Column(name = "password", nullable = false)
    private String password;

    //카카오아이디나 이메일

    @OneToMany(mappedBy = "rollingPaper", orphanRemoval = true)
    private List<RollingPaper> myRollingPapers;

    @OneToMany(mappedBy = "message", orphanRemoval = true)
    private List<Message> sentMessages;

    public Member(MemberRequestDto requestDto){
        this.nickname = requestDto.getNickname();
        this.memberId = requestDto.getMemberId();
        this.password = requestDto.getPassword();
    }
}
