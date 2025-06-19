package me.junghaein.rollingpaperproject.RollingPaper.dto;

import lombok.Getter;
import me.junghaein.rollingpaperproject.Letter.dto.LetterResponseDto;
import me.junghaein.rollingpaperproject.Letter.entity.Letter;
import me.junghaein.rollingpaperproject.RollingPaper.entity.RollingPaper;
//import me.junghaein.rollingpaperproject.user.entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class RollingPaperResponseDto {
    private final Long id;
    private final String title;
    private final String rpType;
    private final LocalDateTime rpRelease;
//    private final User owner;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final List<LetterResponseDto> messages;

    public RollingPaperResponseDto(RollingPaper rollingPaper){
        this.id = rollingPaper.getId();
        this.title = rollingPaper.getTitle();
        this.rpType = rollingPaper.getRpType();
        this.rpRelease = rollingPaper.getRpRelease();
//        this.owner = rollingPaper.getOwner();
        this.createdAt = rollingPaper.getCreatedAt();
        this.updatedAt = rollingPaper.getUpdatedAt();
        this.messages = rollingPaper.getMessages().stream().
                map(LetterResponseDto::new).toList();
        }
}
