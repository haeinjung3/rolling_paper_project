package me.junghaein.rollingpaperproject.RollingPaper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RollingPaperService {

    private final RollingPaperRepository rollingPaperRepository;

    public RollingPaper createRollingPaper(RollingPaperRequestDto requestDto){
        RollingPaper rollingPaper = new RollingPaper(requestDto);

        return rollingPaperRepository.save(rollingPaper);
    }
}
