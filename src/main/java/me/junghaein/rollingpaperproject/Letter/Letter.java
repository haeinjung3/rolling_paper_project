package me.junghaein.rollingpaperproject.Letter;

import jakarta.persistence.*;
import lombok.*;
import me.junghaein.rollingpaperproject.user.entity.User;
import me.junghaein.rollingpaperproject.RollingPaper.entity.RollingPaper;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Setter
@Table(name = "Message")
public class Letter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "letter_type", nullable = false)
    private Long letterType;
//long이 ㄱㅊ을까
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id", nullable = true)
    private User writer;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "contents", nullable = false)
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rp_id", nullable = false)
    private RollingPaper rollingPaper;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;


    public Letter(RollingPaper rollingPaper, LetterRequestDto requestDto){
        this.letterType = requestDto.getLetterType();
//        this.writer = user;
        this.nickname = requestDto.getNickname();
        this.contents = requestDto.getContents();
        this.rollingPaper = rollingPaper;
        this.createdAt = requestDto.getCreatedAt();
        this.updatedAt = requestDto.getUpdatedAt();
    }
    //user 정보가 없을 때는 기본 정보가 들어가도록 설정하기

    public void modify(LetterRequestDto requestDto){
        this.letterType = requestDto.getLetterType();
        this.nickname = requestDto.getNickname();
        this.contents = requestDto.getContents();
        this.updatedAt = requestDto.getUpdatedAt();
    }
}
