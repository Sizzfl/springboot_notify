package com.example.notify.web.dto.s2c;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FCMResponseDto
{
    int successCount;
    int failCount;

    @Builder
    public FCMResponseDto(int s, int f)
    {
        successCount = s;
        failCount = f;
    }
}