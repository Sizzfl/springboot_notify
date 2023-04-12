package com.example.notify.web.dto.c2s;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class FCMRequestDto
{
    private String projectId;
    private String fcmToken;
    private Boolean termPromo;
    private Boolean termInfo;
    private Boolean nightPushAgree;
    private String langCode;
    private String countryCode;
    private String operatingSystem;

    @Builder
    public FCMRequestDto(String pid, String token, Boolean promo, Boolean info, Boolean night,
                         String lang, String country,String os)
    {
        this.projectId = pid;
        this.fcmToken = token;
        this.termPromo = promo;
        this.termInfo = info;
        this.nightPushAgree = night;
        this.langCode = lang;
        this.countryCode = country;
        this.operatingSystem = os;
    }
}
