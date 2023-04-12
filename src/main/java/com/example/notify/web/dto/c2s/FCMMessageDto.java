package com.example.notify.web.dto.c2s;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FCMMessageDto
{
    String title;
    String body;
    String imageURL;
    String langCode;

    @Builder
    public FCMMessageDto(String t, String b, String i, String l)
    {
        title = t;
        body = b;
        imageURL = i;
        langCode = l;
    }
}
