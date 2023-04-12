package com.example.notify.domain.repository;

import com.example.notify.domain.fcm.UserFCMData;
import com.example.notify.internal.cache.UserFCMCache;
import com.example.notify.web.dto.c2s.FCMRequestDto;

import java.util.Map;

public interface FCMRepository
{
    UserFCMCache findAll();
    int upsert(String csCode, UserFCMData dto);
}
