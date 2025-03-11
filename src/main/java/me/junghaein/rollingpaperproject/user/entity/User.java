package me.junghaein.rollingpaperproject.user.entity;

import jakarta.persistence.*;
import lombok.*;
import me.junghaein.rollingpaperproject.Letter.Letter;
import me.junghaein.rollingpaperproject.RollingPaper.entity.RollingPaper;
import me.junghaein.rollingpaperproject.user.dto.UserRequestDto;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Setter
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "password", nullable = false)
    private String password;

    //카카오아이디나 이메일

    @OneToMany(mappedBy = "rollingPaper", orphanRemoval = true)
    private List<RollingPaper> myRollingPapers;

    @OneToMany(mappedBy = "message", orphanRemoval = true)
    private List<Letter> sentMessages;

    public User(UserRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.userId = requestDto.getUserId();
        this.password = requestDto.getPassword();
    }
}
