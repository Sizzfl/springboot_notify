package com.example.notify.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

@EnableAsync
@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncTest
{
    @Autowired
    private AsyncService asyncService;

    @Test
    public void testAsyncMain()
    {
        asyncService = new AsyncService();

        for(int i = 0; i < 100; i++)
        {
            asyncService.testAsync(String.valueOf(i));
        }
    }
}