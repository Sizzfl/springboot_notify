package com.example.notify.test;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService
{
    @Async("threadPoolTaskExecutor")
    public void testAsync(String msg)
    {
        for(int i = 0; i <= 10; i++)
        {
            System.out.println(msg + " Async : " + i);
        }
    }
}
