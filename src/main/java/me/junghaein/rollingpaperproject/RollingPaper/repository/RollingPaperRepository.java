package me.junghaein.rollingpaperproject.RollingPaper.repository;

import me.junghaein.rollingpaperproject.RollingPaper.entity.RollingPaper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RollingPaperRepository extends JpaRepository<RollingPaper, Long> {

    List<RollingPaper> findAll();
}
