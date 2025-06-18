//package me.junghaein.rollingpaperproject.user.service;
//
//import lombok.RequiredArgsConstructor;
//import me.junghaein.rollingpaperproject.user.dto.UserRequestDto;
//import me.junghaein.rollingpaperproject.user.entity.User;
//import me.junghaein.rollingpaperproject.user.repository.UserRepository;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@RequiredArgsConstructor
//@Service
//public class UserService {
//
//    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    public User createUser(UserRequestDto requestDto){
//
//        return saveUser(User.builder()
//                .username(requestDto.getUsername())
//                .userId(requestDto.getUserId())
//                .password(bCryptPasswordEncoder.encode(requestDto.getPassword()))
//                .email(requestDto.getEmail())
//                .build());
//    }
//
//    public User saveUser(User user){
//        return userRepository.save(user);
//    }
//
//    public User findById(Long userId){
//        return userRepository.findById(userId)
//                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
//    }
//}
