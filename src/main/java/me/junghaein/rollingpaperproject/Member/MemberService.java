package me.junghaein.rollingpaperproject.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public Member createMember(MemberRequestDto requestDto){
        Member member = new Member(requestDto);

        return memberRepository.save(member);
    }
}
