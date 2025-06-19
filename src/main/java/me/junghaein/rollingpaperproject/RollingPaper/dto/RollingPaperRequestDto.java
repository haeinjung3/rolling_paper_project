package me.junghaein.rollingpaperproject.RollingPaper.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RollingPaperRequestDto {

    private String title;
    private String rpType;
    private LocalDateTime rpRelease;
}
