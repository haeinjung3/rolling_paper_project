package me.junghaein.rollingpaperproject.RollingPaper;

import lombok.Getter;
import me.junghaein.rollingpaperproject.Member.Member;
import me.junghaein.rollingpaperproject.Message.Message;

import java.util.List;

@Getter
public class RollingPaperRequestDto {

    private String title;
    private Member owner;
}
