package me.junghaein.rollingpaperproject.Message;

import lombok.Getter;
import me.junghaein.rollingpaperproject.Member.Member;
import me.junghaein.rollingpaperproject.RollingPaper.RollingPaper;

@Getter
public class MessageRequestDto {
    private String content;
    private RollingPaper rollingPaper;
    private Member sender;
}
