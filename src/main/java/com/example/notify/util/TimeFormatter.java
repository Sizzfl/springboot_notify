package com.example.notify.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class TimeFormatter
{
    public static LocalDateTime GetUTCNow()
    {
        return LocalDateTime.now(ZoneOffset.UTC);
    }

    public static String ToMySQLTimeFormat(LocalDateTime time)
    {
        return time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.999"));
    }

    public static String ToUTCMySQLTimeFormat(LocalDateTime time)
    {
        return time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.999"));
    }

    public static String ToISO8601Format(LocalDateTime time)
    {
        return time.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public static LocalDateTime ToUTC(LocalDateTime time)
    {
        return time.atZone(ZoneOffset.UTC).toLocalDateTime();
    }

    public static String ToUTCISO8601Format(LocalDateTime time)
    {
        return time.atZone(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
