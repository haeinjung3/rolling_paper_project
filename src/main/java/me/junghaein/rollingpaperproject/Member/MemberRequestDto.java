package me.junghaein.rollingpaperproject.Member;

import lombok.Getter;
import me.junghaein.rollingpaperproject.Message.Message;
import me.junghaein.rollingpaperproject.RollingPaper.RollingPaper;

import java.util.List;

@Getter
public class MemberRequestDto {

    private String nickname;
    private String memberId;
    private String password;
}
