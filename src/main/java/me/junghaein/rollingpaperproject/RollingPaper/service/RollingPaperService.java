package me.junghaein.rollingpaperproject.RollingPaper.service;

import lombok.RequiredArgsConstructor;
import me.junghaein.rollingpaperproject.RollingPaper.dto.RollingPaperRequestDto;
import me.junghaein.rollingpaperproject.RollingPaper.dto.RollingPaperResponseDto;
import me.junghaein.rollingpaperproject.RollingPaper.entity.RollingPaper;
import me.junghaein.rollingpaperproject.RollingPaper.repository.RollingPaperRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    //롤링페이퍼 전체 조회
    public List<RollingPaperResponseDto> selectRollingPaperAll() {
        return rollingPaperRepository.findAll().stream()
                .map(RollingPaperResponseDto::new).toList();
    }

    //특정 유저 롤링페이퍼 전체 조회
//    public List<RollingPaperResponseDto> selectRollingPaperByUser(User user) {
//        return findRollingPaperByUser.stream()
//                .map(RollingPaperResponseDto::new).toList();
//    }

    //롤링페이퍼 조회
    public RollingPaperResponseDto selectRollingPaper(long rollingPaperId){
        //설정한 날짜가 되었는지 검사
        return new RollingPaperResponseDto(findRollingPaper(rollingPaperId));
    }

    //롤링페이퍼 수정
    @Transactional
    public RollingPaperResponseDto modify(long rollingPaperId, RollingPaperRequestDto requestDto){
        RollingPaper rollingPaper = findRollingPaper(rollingPaperId);
        //유저 권한 검사

        rollingPaper.modify(requestDto);

        return new RollingPaperResponseDto(rollingPaper);
    }

    //롤링페이퍼 삭제
    public void deleteRollingPaper(long rollingPaperId){
        //유저 권한 검사
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

    //유저로 롤링페이퍼 조회
//    public List<RollingPaper> findRollingPaperByUser(User user){
//        return rollingPaperRepository.findByUser(user).orElseThrow(() ->
//                new IllegalArgumentException("not found: " + user)
//        );
//    }
}
