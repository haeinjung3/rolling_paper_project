//package me.junghaein.rollingpaperproject.user.service;
//
//import lombok.RequiredArgsConstructor;
//import me.junghaein.rollingpaperproject.user.entity.User;
//import me.junghaein.rollingpaperproject.user.repository.UserRepository;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//
//@RequiredArgsConstructor
//@Service
//public class UserDetailService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    @Override
//    public User loadUserByUsername(String userId){
//
//        return userRepository.findByUserId(userId)
//                .orElseThrow(() -> new IllegalArgumentException((userId)));
//    }
//}
