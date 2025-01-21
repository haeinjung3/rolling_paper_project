package me.junghaein.rollingpaperproject.RollingPaper;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RollingPaperController {

    private final RollingPaperService rollingPaperService;
}
