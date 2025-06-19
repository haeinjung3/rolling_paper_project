package me.junghaein.rollingpaperproject.Letter.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.junghaein.rollingpaperproject.Letter.dto.LetterRequestDto;
import me.junghaein.rollingpaperproject.Letter.dto.LetterResponseDto;
import me.junghaein.rollingpaperproject.Letter.entity.Letter;
import me.junghaein.rollingpaperproject.Letter.repository.LetterRepository;
import me.junghaein.rollingpaperproject.RollingPaper.entity.RollingPaper;
import me.junghaein.rollingpaperproject.RollingPaper.service.RollingPaperService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LetterService {

    private final LetterRepository letterRepository;
    private final RollingPaperService rollingPaperService;

//편지 생성
    public LetterResponseDto createLetter(long rollingPaperId, LetterRequestDto requestDto){
        RollingPaper rollingPaper = rollingPaperService.findRollingPaper(rollingPaperId);

        Letter letter = new Letter(rollingPaper, requestDto);
        return new LetterResponseDto(saveLetter(letter));
    } //rollingpaper 없을 때 처리?

    //편지 조회
    @Transactional
    public LetterResponseDto selectLetter(long rollingPaperId, long letterId){
        return new LetterResponseDto(findLetter(letterId));
    }

    //편지 수정
    @Transactional
    public LetterResponseDto modifyLetter(long id, LetterRequestDto requestDto){
        Letter letter = findLetter(id);

        letter.modify(requestDto);

        return new LetterResponseDto(letter);
    }

    //편지 삭제
    public void delete(long id){

        letterRepository.deleteById(id);
    }

    //저장
    public Letter saveLetter(Letter letter){

        return letterRepository.save(letter);
    }

    public Letter findLetter(long id){
        return letterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }
}
