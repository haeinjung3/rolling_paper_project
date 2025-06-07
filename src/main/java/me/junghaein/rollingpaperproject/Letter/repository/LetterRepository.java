package me.junghaein.rollingpaperproject.Letter.repository;

import me.junghaein.rollingpaperproject.Letter.entity.Letter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LetterRepository extends JpaRepository<Letter, Long> {
}
