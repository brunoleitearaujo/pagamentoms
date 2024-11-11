package com.baraujo.pagamentoms.service;

import com.baraujo.pagamentoms.client.NotificationClient;
import com.baraujo.pagamentoms.entity.Transferir;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    private final NotificationClient notificationClient;

    public NotificationService(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    public void sendNotification(Transferir transferir) {

        try {
            logger.info("Enviando notificação...");

            var entity = notificationClient.sendNotification(transferir);

            if (entity.getStatusCode().isError()) {
                logger.error("Error ao enviar notificação, status code error");
            }
        } catch (Exception e) {
            logger.error("Error ao enviar notificação", e);
        }
    }
}
