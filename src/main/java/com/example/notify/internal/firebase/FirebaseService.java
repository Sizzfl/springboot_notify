package com.example.notify.internal.firebase;

import com.example.notify.web.dto.s2c.FCMResponseDto;
import com.google.firebase.messaging.*;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FirebaseService
{


    public String SendToOneToken(String token, Notification noti)
    {
        Message msg = Message.builder()
                .setToken(token)
                .setNotification(noti)
                .build();

        try
        {
            return FirebaseMessaging.getInstance().send(msg);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }

    @Async("threadPoolTaskExecutor")
    public FCMResponseDto SendToMultiToken(List<String> tokens, Notification noti)
    {
        MulticastMessage msg = MulticastMessage.builder()
                .addAllTokens(tokens)
                .setNotification(noti).build();

        try
        {
            BatchResponse res = FirebaseMessaging.getInstance().sendMulticast(msg);
            return FCMResponseDto.builder()
                    .s(res.getSuccessCount())
                    .f(res.getFailureCount()).build();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
