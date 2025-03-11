package me.junghaein.rollingpaperproject.Letter;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class LetterController {

    private final LetterService letterService;

    //편지 생성
    @PostMapping("/rolling-paper/{rolling-paperId}/letter")
    public ResponseEntity<LetterResponseDto> createLetter(@PathVariable long rollingPaperId, @RequestPart LetterRequestDto requestDto){
        LetterResponseDto responseDto = letterService.createLetter(rollingPaperId, requestDto);

        return ResponseEntity.ok()
                .body(responseDto);
    }

    //편지 상세 조회
    @GetMapping("/rolling-paper/{rolling-paperId}/letter/{letterId}")
    public ResponseEntity<LetterResponseDto> findLetter(@PathVariable long rollingPaperId, @PathVariable long letterId){
        LetterResponseDto responseDto = letterService.selectLetter(rollingPaperId, letterId);

        return ResponseEntity.ok()
                .body(responseDto);
    }

    //편지 수정
    @PutMapping("/rolling-paper/{rolling-paperId}/letter/{letterId}")
    public ResponseEntity<LetterResponseDto> modifyLetter(@PathVariable long rollingPaperId, @PathVariable long letterId, @RequestPart LetterRequestDto requestDto){
        LetterResponseDto responseDto = letterService.modifyLetter(letterId, requestDto);

        return ResponseEntity.ok()
                .body(responseDto);
    }

    //편지 삭제
    @DeleteMapping("/rolling-paper/{rolling-paperId}/letter/{letterId}")
    public ResponseEntity<Void> deleteLetter(@PathVariable long letterId){
        letterService.delete(letterId);

        return ResponseEntity.ok()
                .build();
    }
}
