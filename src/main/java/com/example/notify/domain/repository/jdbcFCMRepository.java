package com.example.notify.domain.repository;

import com.example.notify.domain.fcm.UserFCMData;
import com.example.notify.internal.cache.UserFCMCache;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.notify.util.TimeFormatter.ToUTCMySQLTimeFormat;

@Repository
@RequiredArgsConstructor
public class jdbcFCMRepository implements FCMRepository
{
    private final JdbcTemplate jdbcTemplate;

    @Override
    public UserFCMCache findAll()
    {
        String query = "SELECT project_id, cs_code, fcm_token, term_promo, term_info, night_push_agree, lang_code, country_code, operating_system FROM user_fcm WHERE deleted_date IS NULL";
        List<UserFCMData> result = jdbcTemplate.queryForList(query, UserFCMData.class);

        Map<String, UserFCMData> mapCache = new HashMap<>();
        for(UserFCMData d : result)
        {
            mapCache.put(d.getCsCode(), d);
        }

        return new UserFCMCache(mapCache);
    }

    @Override
    public int upsert(String csCode, UserFCMData dto)
    {
        String logDate = ToUTCMySQLTimeFormat(LocalDateTime.now());

        String query = "INSERT INTO user_fcm(project_id, cs_code, fcm_token, term_promo, term_info, night_push_agree, lang_code, country_code, operating_system, created_date)" +
                " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE fcm_token = ?, term_promo = ?, term_info = ?, night_push_agree = ?, lang_code = ?, updated_date = ?, deleted_date = NULL";

        return jdbcTemplate.update(query, dto.getProjectId(), csCode, dto.getFcmToken(), dto.getTermPromo(),
                dto.getTermInfo(), dto.getNightPushAgree(), dto.getLangCode(), dto.getCountryCode(), dto.getOperatingSystem(), logDate,
                dto.getFcmToken(), dto.getTermPromo(), dto.getTermInfo(), dto.getNightPushAgree(), dto.getLangCode(), logDate);
    }
}
