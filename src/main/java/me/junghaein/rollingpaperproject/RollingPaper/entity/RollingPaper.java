package me.junghaein.rollingpaperproject.RollingPaper.entity;

import jakarta.persistence.*;
import lombok.*;
import me.junghaein.rollingpaperproject.RollingPaper.dto.RollingPaperRequestDto;
//import me.junghaein.rollingpaperproject.user.entity.User;
import me.junghaein.rollingpaperproject.Letter.entity.Letter;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "rp_type", nullable = false)
    private String rpType;

    @Column(name = "rp_release", nullable = false)
    private LocalDateTime rpRelease;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "owner_id", nullable = false)
//    private User owner;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "rollingPaper", orphanRemoval = true)
    private List<Letter> messages = new ArrayList<>(); //@Builder가 무시

    public RollingPaper(RollingPaperRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.rpType = requestDto.getRpType();
        this.rpRelease = requestDto.getRpRelease();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void modify(RollingPaperRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.rpType = requestDto.getRpType();
        this.rpRelease = requestDto.getRpRelease();
        this.updatedAt = LocalDateTime.now();
    }
}
