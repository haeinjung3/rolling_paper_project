package me.junghaein.rollingpaperproject.Letter.service;

import lombok.RequiredArgsConstructor;
import me.junghaein.rollingpaperproject.Letter.dto.LetterRequestDto;
import me.junghaein.rollingpaperproject.Letter.dto.LetterResponseDto;
import me.junghaein.rollingpaperproject.Letter.entity.Letter;
import me.junghaein.rollingpaperproject.Letter.repository.LetterRepository;
import me.junghaein.rollingpaperproject.RollingPaper.entity.RollingPaper;
import me.junghaein.rollingpaperproject.RollingPaper.service.RollingPaperService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LetterService {

    private final LetterRepository letterRepository;
    private final RollingPaperService rollingPaperService;

    //편지 생성
    @Transactional
    public LetterResponseDto createLetter(long rollingPaperId, LetterRequestDto requestDto){
        //유저 예외처리 작성 예정(로그인 하지 않은 유저는 비밀번호 필수)
        RollingPaper rollingPaper = rollingPaperService.findRollingPaper(rollingPaperId);

        Letter letter = new Letter(rollingPaper, requestDto);
        return new LetterResponseDto(saveLetter(letter));
        //알림 기능 작성 예정
    }

    //편지 상세 조회
    @Transactional(readOnly = true)
    public LetterResponseDto selectLetter(long rollingPaperId, long letterId){
        //설정한 날짜가 되거나 편지 작성자인지 검사 작성 예정
        return new LetterResponseDto(findLetter(letterId));
    }

    //롤페별 편지 전체 조회
    @Transactional(readOnly = true)
    public List<LetterResponseDto> selectletterAll(long rollingPaperId) {
        //user 권한 확인 예외처리 작성 예정
        RollingPaper rollingPaper = rollingPaperService.findRollingPaper(rollingPaperId);
        return letterRepository.findAllByRollingPaper(rollingPaper).stream()
                .map(LetterResponseDto::new).toList();
    }

    //특정 유저 편지 전체 조회
//    public List<LetterResponseDto> selectLetterByUser(User user) {
//        return findLetterByUser(user).stream()
//                .map(LetterResponseDto::new).toList();
//    }

    //편지 수정
    @Transactional
    public LetterResponseDto modifyLetter(long id, LetterRequestDto requestDto){
        Letter letter = findLetter(id);
        //유저 권한 검사(작성자) 작성 예정
        letter.modify(requestDto);

        return new LetterResponseDto(letter);
    }

    //편지 삭제
    @Transactional
    public void delete(long id){
        //유저 권한 검사(작성자 또는 롤링페이퍼 주인, 관리자) 작성 예정
        letterRepository.deleteById(id);
    }

    //편지 저장
    public Letter saveLetter(Letter letter){

        return letterRepository.save(letter);
    }

    //id로 편지 조회
    public Letter findLetter(long id){
        return letterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    //유저로 편지 조회
//    private List<Letter> findLetterByUser(User user) {
//        return letterRepository.findByUser(user).orElseThrow(() ->
//                new IllegalArgumentException("not found: " + user)
//        );
//    }
}
