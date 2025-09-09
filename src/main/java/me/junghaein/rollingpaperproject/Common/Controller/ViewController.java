package me.junghaein.rollingpaperproject.Common.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor //생성자 주입 방식으로 Service 객체 주입
public class ViewController {

    //로그인 페이지 불러오기
    @GetMapping("/login-page")
    public String loginPage(){
        return "login";
    }

    //회원가입 페이지 불러오기
    @GetMapping("/signup-page")
    public String signupPage(){
        return "signup";
    }

    //로그아웃 페이지 불러오기
    @GetMapping("/logout-page")
    public String logoutPage(){
        return "logout";
    }
}
