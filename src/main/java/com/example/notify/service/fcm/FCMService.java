package com.example.notify.service.fcm;

import com.example.notify.domain.fcm.UserFCMData;
import com.example.notify.domain.repository.FCMRepository;
import com.example.notify.internal.cache.UserFCMCache;
import com.example.notify.internal.firebase.FirebaseService;
import com.example.notify.web.dto.c2s.FCMMessageDto;
import com.example.notify.web.dto.c2s.FCMRequestDto;
import com.example.notify.web.dto.s2c.FCMResponseDto;
import com.google.firebase.messaging.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FCMService
{
    private final int MAX_TOKEN_COUNT = 500;

    private final FCMRepository fcmRepository;
    private final FirebaseService fbService;
    private final UserFCMCache cache;

    @Transactional
    public int save(String csCode, UserFCMData dto)
    {
        cache.push(csCode, dto);
        return fcmRepository.upsert(csCode, dto);
    }

//    @Async("threadPoolTaskExecutor")
//    public void printAsync(String msg)
//    {
//        System.out.println(msg);
//    }

    @Transactional
    public int sendAll(String projectId, FCMMessageDto dto)
    {
        List<String> tokens = cache.getAllToken(projectId, dto.getLangCode());
        Notification noti = Notification.builder()
                .setTitle(dto.getTitle())
                .setBody(dto.getBody())
                .setImage(dto.getImageURL()).build();

        if (tokens.size() > MAX_TOKEN_COUNT)
        {
            for(int i = 0; i < tokens.size();)
            {
                int sliceEnd = Math.min(i + MAX_TOKEN_COUNT, tokens.size());

                List<String> subList = new ArrayList<>();
                for(int j = i; j < sliceEnd; j++)
                {
                    subList.add(tokens.get(j));
                }

                FCMResponseDto result = fbService.SendToMultiToken(subList, noti);

                i += MAX_TOKEN_COUNT;
            }

        }
        else
        {
            FCMResponseDto result = fbService.SendToMultiToken(tokens, noti);

        }
        return HttpStatus.OK.value();
    }

    @Transactional
    public int sendOne(String projectId, String csCode, FCMMessageDto dto)
    {
        return 0;
    }
}
