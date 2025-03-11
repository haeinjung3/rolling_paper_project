package me.junghaein.rollingpaperproject.RollingPaper.repository;

import me.junghaein.rollingpaperproject.RollingPaper.entity.RollingPaper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RollingPaperRepository extends JpaRepository<RollingPaper, Long> {
}
