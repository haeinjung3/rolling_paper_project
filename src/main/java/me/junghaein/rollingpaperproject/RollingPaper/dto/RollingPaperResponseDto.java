package me.junghaein.rollingpaperproject.RollingPaper.dto;

import lombok.Getter;
import me.junghaein.rollingpaperproject.Letter.Letter;
import me.junghaein.rollingpaperproject.RollingPaper.entity.RollingPaper;
import me.junghaein.rollingpaperproject.user.entity.User;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class RollingPaperResponseDto {

    private final String title;
    private final Long rpType;
    private final LocalDateTime rpRelease;
    private final User owner;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final List<Letter> message;

    public RollingPaperResponseDto(RollingPaper rollingPaper){
        this.title = rollingPaper.getTitle();
        this.rpType = rollingPaper.getRpType();
        this.rpRelease = rollingPaper.getRpRelease();
        this.owner = rollingPaper.getOwner();
        this.createdAt = rollingPaper.getCreatedAt();
        this.updatedAt = rollingPaper.getUpdatedAt();
        this.message = rollingPaper.getMessages(); //이따 검색
    }
}
