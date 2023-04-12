package com.example.notify.internal.cache;

import com.example.notify.domain.fcm.UserFCMData;
import com.example.notify.web.dto.c2s.FCMRequestDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;

@Getter
@RequiredArgsConstructor
@Component
public class UserFCMCache
{
    private final Map<String, UserFCMData> FCMCache;

    public void push(String csCode, UserFCMData data)
    {
        FCMCache.put(csCode, data);
    }

    public UserFCMData getOneToken(String csCode)
    {
        return FCMCache.get(csCode);
    }

    public ArrayList<String> getAllToken(String projectId, String langCode)
    {
        ArrayList<String> retDatas = new ArrayList<>();
        for(Map.Entry<String, UserFCMData> entry : FCMCache.entrySet())
        {
            if(entry.getValue().getProjectId().equals(projectId) && entry.getValue().getLangCode().equals(langCode))
            {
                retDatas.add(entry.getValue().getFcmToken());
            }
        }

        return retDatas;
    }

    public UserFCMData removeToken(String csCode)
    {
        return FCMCache.remove(csCode);
    }
}
