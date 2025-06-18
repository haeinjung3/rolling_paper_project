package me.junghaein.rollingpaperproject.RollingPaper.entity;

import jakarta.persistence.*;
import lombok.*;
import me.junghaein.rollingpaperproject.RollingPaper.dto.RollingPaperRequestDto;
//import me.junghaein.rollingpaperproject.user.entity.User;
import me.junghaein.rollingpaperproject.Letter.entity.Letter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Setter
@Table(name = "RollingPaper")
public class RollingPaper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    //nullable 임시로 지움
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "rp_type", nullable = false)
    private Long rpType;

//long으로 괜찮나
    @Column(name = "rp_release")
    private LocalDateTime rpRelease;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "owner_id", nullable = false)
//    private User owner;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "rollingPaper", orphanRemoval = true)
    private List<Letter> messages;

    public RollingPaper(RollingPaperRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.rpType = requestDto.getRpType();
        this.rpRelease = LocalDateTime.now(); //임시
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void modify(RollingPaperRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.rpType = requestDto.getRpType();
        this.rpRelease = LocalDateTime.now(); //임시
        this.updatedAt = LocalDateTime.now();
    }
}
