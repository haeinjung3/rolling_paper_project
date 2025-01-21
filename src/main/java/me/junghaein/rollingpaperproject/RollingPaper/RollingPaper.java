package me.junghaein.rollingpaperproject.RollingPaper;

import jakarta.persistence.*;
import lombok.*;
import me.junghaein.rollingpaperproject.Member.Member;
import me.junghaein.rollingpaperproject.Message.Message;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_name", nullable = false)
    private Member owner;

    @OneToMany(mappedBy = "rollingPaper", orphanRemoval = true)
    private List<Message> messages;

    public RollingPaper(RollingPaperRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.owner = requestDto.getOwner();
    }
}
