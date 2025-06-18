package me.junghaein.rollingpaperproject.RollingPaper.service;

import lombok.RequiredArgsConstructor;
import me.junghaein.rollingpaperproject.RollingPaper.dto.RollingPaperRequestDto;
import me.junghaein.rollingpaperproject.RollingPaper.dto.RollingPaperResponseDto;
import me.junghaein.rollingpaperproject.RollingPaper.entity.RollingPaper;
import me.junghaein.rollingpaperproject.RollingPaper.repository.RollingPaperRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RollingPaperService {

    private final RollingPaperRepository rollingPaperRepository;
//    private final LetterRepository letterRepository;

    //롤링페이퍼 등록
    public RollingPaperResponseDto createRollingPaper(RollingPaperRequestDto requestDto){
        RollingPaper rollingPaper = new RollingPaper(requestDto);

        return new RollingPaperResponseDto(saveRollingPaper(rollingPaper));
    }

    //롤링페이퍼 조회
    public RollingPaperResponseDto selectRollingPaper(long id){

        return new RollingPaperResponseDto(findRollingPaper(id));
    }

//    //롤링페이퍼 수정
    @Transactional
    public RollingPaper modify(long id, RollingPaperRequestDto requestDto){
        RollingPaper rollingPaper = rollingPaperRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " +id));

        rollingPaper.modify(requestDto);

        return rollingPaper;
    }

    //롤링페이퍼 삭제
    public void deleteRollingPaper(long id){
        rollingPaperRepository.deleteById(id);
    }

    public RollingPaper saveRollingPaper(RollingPaper rollingPaper){
        return rollingPaperRepository.save(rollingPaper);
    }

    public RollingPaper findRollingPaper(long rollingPaperId){
        return rollingPaperRepository.findById(rollingPaperId).orElseThrow(() ->
                new IllegalArgumentException("선택한 롤링페이퍼는 존재하지 않습니다.")
        );
    }
}
