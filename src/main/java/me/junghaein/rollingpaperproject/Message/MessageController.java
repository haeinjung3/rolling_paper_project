package me.junghaein.rollingpaperproject.Message;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MessageController {

    private final MessageService messageService;
}
