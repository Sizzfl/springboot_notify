package com.example.notify.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
public class TypeCheckTest
{
    @Test
    public void TypeCheckExample()
    {
        String a = "str";
        Integer b = 2;
        byte[] c = {1,2,3,4};

        System.out.println(a.getClass().getSimpleName());
        System.out.println(b.getClass().getSimpleName());
        System.out.println(c.getClass().getSimpleName());
    }
}
