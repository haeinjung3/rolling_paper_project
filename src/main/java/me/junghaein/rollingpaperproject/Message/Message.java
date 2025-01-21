package me.junghaein.rollingpaperproject.Message;

import jakarta.persistence.*;
import lombok.*;
import me.junghaein.rollingpaperproject.Member.Member;
import me.junghaein.rollingpaperproject.RollingPaper.RollingPaper;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Setter
@Table(name = "Message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rollingPaper", nullable = false)
    private RollingPaper rollingPaper;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", nullable = false)
    private Member sender;

    public Message(MessageRequestDto requestDto){
        this.content = requestDto.getContent();
        this.rollingPaper = requestDto.getRollingPaper();
        this.sender = requestDto.getSender();
    }
}
