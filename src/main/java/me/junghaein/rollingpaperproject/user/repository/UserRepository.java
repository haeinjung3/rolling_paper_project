package me.junghaein.rollingpaperproject.user.repository;

import me.junghaein.rollingpaperproject.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
