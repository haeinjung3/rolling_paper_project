package me.junghaein.rollingpaperproject.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import me.junghaein.rollingpaperproject.user.dto.UserRequestDto;
import me.junghaein.rollingpaperproject.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor //생성자 주입 방식으로 Service 객체 주입
public class UserController {

    private final UserService userService;

    //로그아웃
    @GetMapping("/users/logout")
    public void logout(HttpServletRequest requestDto, HttpServletResponse responseDto){
        new SecurityContextLogoutHandler().logout(requestDto, responseDto,
                SecurityContextHolder.getContext().getAuthentication());
        return;
    }

    //회원가입
    @PostMapping("/users/signup")
    public ResponseEntity<Long> signUpUser(@RequestBody UserRequestDto requestDto){  //@Valid 작성
        Long savedUser = userService.createUser(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    //회원 정보 조회
    @GetMapping("/users/{userId}/info")
    public void selectUserInfo(){

    }

    //회원 정보 수정
    @PutMapping("/users/{userId}/info")
    public void modifyUser(){

    }

    //유저 탈퇴
    @DeleteMapping("/users/{userId}/withdraw")
    public void deleteUser(){

    }

    //내가 만든 롤링페이퍼 목록 조회
    @GetMapping("/users/{userId}/my-rolling-paper")
    public void selectUserRollingPaper(){

    }


    //내가 보낸 편지 목록 조회
    @GetMapping("/users/{userId}/my-letter")
    public void selectUserLetter(){

    }
}
