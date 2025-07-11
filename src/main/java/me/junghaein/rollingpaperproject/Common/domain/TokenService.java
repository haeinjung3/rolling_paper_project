package me.junghaein.rollingpaperproject.Common.domain;

import lombok.RequiredArgsConstructor;
import me.junghaein.rollingpaperproject.Common.config.jwt.TokenProvider;
import me.junghaein.rollingpaperproject.user.entity.User;
import me.junghaein.rollingpaperproject.user.service.UserService;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    public String createNewAccessToken(String refreshToken){
        if(!tokenProvider.validToken(refreshToken)){
            throw new IllegalArgumentException("Unexpected token");
        }

        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        User user = userService.findById(userId);

        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }
}
