package me.junghaein.rollingpaperproject.Letter.repository;

import me.junghaein.rollingpaperproject.Letter.entity.Letter;
import me.junghaein.rollingpaperproject.RollingPaper.entity.RollingPaper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface LetterRepository extends JpaRepository<Letter, Long> {
    List<Letter> findAllByRollingPaper(RollingPaper rollingPaper);
}
