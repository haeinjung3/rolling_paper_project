package me.junghaein.rollingpaperproject.RollingPaper.controller;

import lombok.RequiredArgsConstructor;
import me.junghaein.rollingpaperproject.RollingPaper.dto.RollingPaperRequestDto;
import me.junghaein.rollingpaperproject.RollingPaper.dto.RollingPaperResponseDto;
import me.junghaein.rollingpaperproject.RollingPaper.entity.RollingPaper;
import me.junghaein.rollingpaperproject.RollingPaper.service.RollingPaperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class RollingPaperController {

    private final RollingPaperService rollingPaperService;

    //롤링 페이퍼 생성
    @PostMapping("/rolling-paper")
    public ResponseEntity<RollingPaperResponseDto> createRollingPaper(@RequestBody RollingPaperRequestDto requestDto){ //@RequestBody와 @RequestPart 차이 숙지하기
        RollingPaperResponseDto responseDto = rollingPaperService.createRollingPaper(requestDto);

        return ResponseEntity.ok()
                .body(responseDto);
    }

    //롤링페이퍼 상세 조회
    @GetMapping("/rolling-paper/{rolling-paperId}")
    public ResponseEntity<RollingPaperResponseDto> selectRollingPaper(
            @PathVariable("rolling-paperId") long rollingPaperId){
        RollingPaperResponseDto responseDto = rollingPaperService.selectRollingPaper(rollingPaperId);

        return ResponseEntity.ok()
                .body(responseDto);
    }

    //롤링페이퍼 전체 조회
    @GetMapping("/rolling-paper")
    public ResponseEntity<List<RollingPaperResponseDto>> selectRollingPaperAll(){
        List<RollingPaperResponseDto> responseDtos = rollingPaperService.selectRollingPaperAll();

        return ResponseEntity.ok()
                .body(responseDtos);
    }

    //특정 유저 롤링페이퍼 전체 조회
//    @GetMapping("/rolling-paper/user/{userId}")
//    public ResponseEntity<List<RollingPaperResponseDto>> selectRollingPaperByUser(User user){
//        List<RollingPaperResponseDto> responseDtos = rollingPaperService.selectRollingPaperByUser(user);
//
//        return ResponseEntity.ok()
//                .body(responseDtos);
//    }

   //롤링페이퍼 수정
    @PutMapping("/rolling-paper/{rolling-paperId}")
    public ResponseEntity<RollingPaperResponseDto> modifyRollingPaper(
            @PathVariable("rolling-paperId") long rollingPaperId, @RequestBody RollingPaperRequestDto requestDto){
        RollingPaperResponseDto modifiedRollingPaper = rollingPaperService.modifyRollingPaper(rollingPaperId, requestDto);

        return ResponseEntity.ok()
                .body(modifiedRollingPaper);
    }

    //롤링 페이퍼 삭제
    @DeleteMapping("/rolling-paper/{rolling-paperId}")
    public ResponseEntity<Void> deleteRollingPaper(
            @PathVariable("rolling-paperId") long rollingPaperId){
        rollingPaperService.deleteRollingPaper(rollingPaperId);

        return ResponseEntity.ok()
                .build();
    }
}
