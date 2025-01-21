package me.junghaein.rollingpaperproject.Message;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public Message createMessage(MessageRequestDto requestDto){
        Message message = new Message(requestDto);

        return messageRepository.save(message);
    }
}
