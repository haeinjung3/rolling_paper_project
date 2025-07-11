package me.junghaein.rollingpaperproject.user.service;

import lombok.RequiredArgsConstructor;
import me.junghaein.rollingpaperproject.user.dto.UserRequestDto;
import me.junghaein.rollingpaperproject.user.entity.User;
import me.junghaein.rollingpaperproject.user.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long createUser(UserRequestDto requestDto){

        return saveUser(User.builder()
                .username(requestDto.getUsername())
                .userId(requestDto.getUserId())
                .password(bCryptPasswordEncoder.encode(requestDto.getPassword()))  //시큐리티 설정에서 인코딩용으로 등록한 빈
                .email(requestDto.getEmail())
                .build()).getId();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User findById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }
}
