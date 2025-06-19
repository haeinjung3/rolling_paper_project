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
    public RollingPaperResponseDto selectRollingPaper(long rollingPaperId){

        return new RollingPaperResponseDto(findRollingPaper(rollingPaperId));
    }

//    //롤링페이퍼 수정
    @Transactional
    public RollingPaperResponseDto modify(long rollingPaperId, RollingPaperRequestDto requestDto){
        RollingPaper rollingPaper = findRollingPaper(rollingPaperId);

        rollingPaper.modify(requestDto);

        return new RollingPaperResponseDto(rollingPaper);
    }

    //롤링페이퍼 삭제
    public void deleteRollingPaper(long rollingPaperId){

        rollingPaperRepository.deleteById(rollingPaperId);
    }


    //롤링페이퍼 저장
    public RollingPaper saveRollingPaper(RollingPaper rollingPaper){
        return rollingPaperRepository.save(rollingPaper);
    }

    //롤링페이퍼 조회
    public RollingPaper findRollingPaper(long rollingPaperId){
        return rollingPaperRepository.findById(rollingPaperId).orElseThrow(() ->
                new IllegalArgumentException("not found: " + rollingPaperId)
        );
    }
}
