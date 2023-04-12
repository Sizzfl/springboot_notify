package com.example.notify.domain.fcm;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserFCMData
{
    String projectId;
    String csCode;
    String fcmToken;
    Boolean termPromo;
    Boolean termInfo;
    Boolean nightPushAgree;
    String langCode;
    String countryCode;
    String operatingSystem;

    @Builder
    public UserFCMData(String pid, String cs, String token, Boolean promo, Boolean info, Boolean night,
                       String lang, String country, String os)
    {
        projectId = pid;
        csCode = cs;
        fcmToken = token;
        termPromo = promo;
        termInfo = info;
        nightPushAgree = night;
        langCode = lang;
        countryCode = country;
        operatingSystem = os;
    }
}
