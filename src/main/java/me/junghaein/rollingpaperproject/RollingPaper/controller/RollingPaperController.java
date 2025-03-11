package me.junghaein.rollingpaperproject.RollingPaper.controller;

import lombok.RequiredArgsConstructor;
import me.junghaein.rollingpaperproject.RollingPaper.dto.RollingPaperRequestDto;
import me.junghaein.rollingpaperproject.RollingPaper.dto.RollingPaperResponseDto;
import me.junghaein.rollingpaperproject.RollingPaper.service.RollingPaperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class RollingPaperController {

    private final RollingPaperService rollingPaperService;

    //롤링 페이퍼 생성
    @PostMapping("/rolling-paper")
    public ResponseEntity<RollingPaperResponseDto> createRollingPaper(@RequestPart RollingPaperRequestDto requestDto){
        RollingPaperResponseDto result = rollingPaperService.createRollingPaper(requestDto);

        return ResponseEntity.ok()
                .body(result);
    }

    //롤링페이퍼 조회
    @GetMapping("/rolling-paper/{rolling-paperId}")
    public ResponseEntity<RollingPaperResponseDto> selectRollingPaper(
            @PathVariable long rollingPaperId){
        RollingPaperResponseDto result = rollingPaperService.selectRollingPaper(rollingPaperId);

        return ResponseEntity.ok()
                .body(result);
    }

//    //롤링페이퍼 수정
//    @PutMapping("/rolling-paper/{rolling-paperId}")
//    public ResponseEntity<RollingPaper> modifyRollingPaper(@PathVariable long id, @RequestBody RollingPaperRequestDto requestDto){
//        RollingPaper modifiedRollingPaper = rollingPaperService.modify(id, requestDto);
//
//        return ResponseEntity.ok()
//                .body(modifiedRollingPaper);
//    }

    //롤링 페이퍼 삭제
    @DeleteMapping("/rolling-paper/{rolling-paperId}")
    public ResponseEntity<Void> deleteRollingPaper(@PathVariable long rollingPaperId){
        rollingPaperService.deleteRollingPaper(rollingPaperId);

        return ResponseEntity.ok()
                .build();
    }
}
