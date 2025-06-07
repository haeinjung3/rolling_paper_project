package me.junghaein.rollingpaperproject.RollingPaper.entity;

import jakarta.persistence.*;
import lombok.*;
import me.junghaein.rollingpaperproject.RollingPaper.dto.RollingPaperRequestDto;
import me.junghaein.rollingpaperproject.user.entity.User;
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

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "rp_type", nullable = false)
    private Long rpType;
//long으로 괜찮나
    @Column(name = "rp_release", nullable = false)
    private LocalDateTime rpRelease;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "rollingPaper", orphanRemoval = true)
    private List<Letter> messages;

    public RollingPaper(RollingPaperRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.rpType = requestDto.getRpType();
        this.rpRelease = requestDto.getRpRelease();
        this.createdAt = requestDto.getCreatedAt();
        this.updatedAt = requestDto.getUpdatedAt();
    }

    public void modify(RollingPaperRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.rpType = requestDto.getRpType();
        this.rpRelease = requestDto.getRpRelease();
        this.updatedAt = requestDto.getUpdatedAt();
    }
}
