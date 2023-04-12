package com.example.notify.test;

import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FirebaseMessagingTest
{
    @Autowired
    private FirebaseApp firebaseApp;

    @Test
    public void drySendTest()
    {
        Notification noti = Notification.builder()
                .setTitle("Sample dry title")
                .setBody("Sample dry body").build();

        String fcmToken = "cxMh5YMhQqGH-xtAgfkyKg:APA91bGpf8a9oHMy-ulb0H70RTmMl4tsKDNTsgpkGLZRPS2q3w43MScKT_Nkpikgax5MGnYuKJMMknJR1jHac6D4Mn5BXNUbY9WOu1StO7cV-Py6beBc5XMKiDihDCeqP2Mmx5bsDYqn";
        Message sendMsg = Message.builder()
                .setNotification(noti).setToken(fcmToken).build();

        try
        {
            String messageID = FirebaseMessaging.getInstance(firebaseApp).send(sendMsg, true);

            System.out.println(messageID);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void sendAllTest()
    {
        Notification noti = Notification.builder()
                .setTitle("Sample dry title")
                .setBody("Sample dry body").build();

        List<String> fcmTokens = new ArrayList<>();
        fcmTokens.add("cxMh5YMhQqGH-xtAgfkyKg:APA91bGpf8a9oHMy-ulb0H70RTmMl4tsKDNTsgpkGLZRPS2q3w43MScKT_Nkpikgax5MGnYuKJMMknJR1jHac6D4Mn5BXNUbY9WOu1StO7cV-Py6beBc5XMKiDihDCeqP2Mmx5bsDYqn");
//        String fcmToken = "cxMh5YMhQqGH-xtAgfkyKg:APA91bGpf8a9oHMy-ulb0H70RTmMl4tsKDNTsgpkGLZRPS2q3w43MScKT_Nkpikgax5MGnYuKJMMknJR1jHac6D4Mn5BXNUbY9WOu1StO7cV-Py6beBc5XMKiDihDCeqP2Mmx5bsDYqn";
        MulticastMessage sendMsg = MulticastMessage.builder()
                .setNotification(noti)
                .addAllTokens(fcmTokens).build();

        try
        {
            BatchResponse res = FirebaseMessaging.getInstance(firebaseApp).sendMulticast(sendMsg, true);

            System.out.println(res);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
