package me.junghaein.rollingpaperproject.Letter.controller;

import lombok.RequiredArgsConstructor;
import me.junghaein.rollingpaperproject.Letter.dto.LetterRequestDto;
import me.junghaein.rollingpaperproject.Letter.dto.LetterResponseDto;
import me.junghaein.rollingpaperproject.Letter.service.LetterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class LetterController {

    private final LetterService letterService;

    //편지 생성
    @PostMapping("/rolling-paper/{rolling-paperId}/letter")
    public ResponseEntity<LetterResponseDto> createLetter(
            @PathVariable("rolling-paperId") long rollingPaperId, @RequestBody LetterRequestDto requestDto){
        LetterResponseDto responseDto = letterService.createLetter(rollingPaperId, requestDto);

        return ResponseEntity.ok()
                .body(responseDto);
    }

    //편지 상세 조회
    @GetMapping("/rolling-paper/{rolling-paperId}/letter/{letterId}")
    public ResponseEntity<LetterResponseDto> findLetter(
            @PathVariable("rolling-paperId") long rollingPaperId, @PathVariable("letterId") long letterId){
        LetterResponseDto responseDto = letterService.selectLetter(rollingPaperId, letterId);

        return ResponseEntity.ok()
                .body(responseDto);
    }

    //롤페별 편지 전체 조회
    @GetMapping("/rolling-paper/{rolling-paperId}/letter")
    public ResponseEntity<List<LetterResponseDto>> selectLetterAll(
            @PathVariable("rolling-paperId") long rollingPaperId
    ){
        List<LetterResponseDto> responseDtos = letterService.selectletterAll(rollingPaperId);

        return ResponseEntity.ok()
                .body(responseDtos);
        }


    //특정 유저 편지 전체 조회
//    @GetMapping("/rolling-paper/letter/user/{userId}")
//    public ResponseEntity<List<LetterResponseDto>> selectLetterByUser(User user){
//        List<LetterResponseDto> responseDtos = letterService.selectLetterByUser(user);
//
//        return ResponseEntity.ok()
//                .body(responseDtos);
//    }


    //편지 수정
    @PutMapping("/rolling-paper/{rolling-paperId}/letter/{letterId}")
    public ResponseEntity<LetterResponseDto> modifyLetter(
            @PathVariable("rolling-paperId") long rollingPaperId, @PathVariable("letterId") long letterId, @RequestBody LetterRequestDto requestDto){
        LetterResponseDto responseDto = letterService.modifyLetter(letterId, requestDto);

        return ResponseEntity.ok()
                .body(responseDto);
    }

    //편지 삭제
    @DeleteMapping("/rolling-paper/{rolling-paperId}/letter/{letterId}")
    public ResponseEntity<Void> deleteLetter(
            @PathVariable("letterId") long letterId){
        letterService.delete(letterId);

        return ResponseEntity.ok()
                .build();
    }
}
