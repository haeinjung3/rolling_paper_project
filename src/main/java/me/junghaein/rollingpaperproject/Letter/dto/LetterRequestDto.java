package me.junghaein.rollingpaperproject.Letter.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class LetterRequestDto {
    private String letterType;
    private String nickname;
    private String contents;
}