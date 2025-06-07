package me.junghaein.rollingpaperproject.Letter.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class LetterRequestDto {
    private Long letterType;
    private String nickname;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}