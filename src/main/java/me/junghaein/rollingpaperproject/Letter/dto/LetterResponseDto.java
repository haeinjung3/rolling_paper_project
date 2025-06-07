package me.junghaein.rollingpaperproject.Letter.dto;

import lombok.Getter;
import me.junghaein.rollingpaperproject.Letter.entity.Letter;
import me.junghaein.rollingpaperproject.RollingPaper.entity.RollingPaper;
import me.junghaein.rollingpaperproject.user.entity.User;

import java.time.LocalDateTime;

@Getter
public class LetterResponseDto {

    private final Long letterType;
    private final User writer;
    private final String nickname;
    private final String contents;
    private final RollingPaper rollingPaper;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public LetterResponseDto(Letter letter){
        this.letterType = letter.getLetterType();
        this.writer = letter.getWriter();
        this.nickname = letter.getNickname();
        this.contents = letter.getContents();
        this.rollingPaper = letter.getRollingPaper();
        this.createdAt = letter.getCreatedAt();
        this.updatedAt = letter.getUpdatedAt();
    }
}
