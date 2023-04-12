package com.example.notify.web;

import com.example.notify.domain.fcm.UserFCMData;
import com.example.notify.service.fcm.FCMService;
import com.example.notify.web.dto.c2s.FCMMessageDto;
import com.example.notify.web.dto.c2s.FCMRequestDto;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/applications/{application_id}")
public class FCMController
{
    private final FCMService fcmService;

    @PostMapping("users/{cs_code}")
    public int UpsertToken(@PathVariable("application_id") @NotNull String projectId, @PathVariable("cs_code") @NotNull String csCode, @RequestBody FCMRequestDto dto)
    {
        UserFCMData data = UserFCMData.builder()
                .pid(projectId)
                .cs(csCode)
                .token(dto.getFcmToken())
                .promo(dto.getTermPromo())
                .night(dto.getNightPushAgree())
                .info(dto.getTermInfo())
                .lang(dto.getLangCode())
                .country(dto.getCountryCode())
                .os(dto.getOperatingSystem())
                .build();

        return fcmService.save(csCode, data);
    }

    @PostMapping("push/all")
    public int sendAll(@PathVariable("application_id") @NotNull String projectId, @RequestBody FCMMessageDto dto)
    {
        return fcmService.sendAll(projectId, dto);
    }

//    @GetMapping("/async")
//    @ResponseStatus(code = HttpStatus.OK)
//    public void printAsyncMessage()
//    {
//        for(int i = 0; i < 100; i++)
//        {
//            fcmService.printAsync(String.valueOf(i));
//        }
//    }
}
