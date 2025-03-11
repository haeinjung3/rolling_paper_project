package me.junghaein.rollingpaperproject.user.service;

import lombok.RequiredArgsConstructor;
import me.junghaein.rollingpaperproject.user.dto.UserRequestDto;
import me.junghaein.rollingpaperproject.user.entity.User;
import me.junghaein.rollingpaperproject.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User createUser(UserRequestDto requestDto){
        User user = new User(requestDto);

        return saveUser(user);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
}
