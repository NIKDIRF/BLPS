package com.example.BLPS.logic.service.util;

import com.example.BLPS.model.Image;
import com.example.BLPS.throwable.exception.SaveImageException;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;
import java.io.FileOutputStream;

@Component
public class ImageUtil {

    @Value("./images/")
    private String imagePath;

    public void saveImage(Image image, String topic) {
        String fileName = new StringBuilder()
                .append(UUID.randomUUID())
                .append("-")
                .append(topic.replaceAll(" ", ""))
                .append(".")
                .append(image.getImageExtension())
                .toString();

        String filePath = new StringBuilder()
                .append(imagePath)
                .append("/")
                .append(fileName)
                .toString();

        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            fos.write(image.getImageContent());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            throw new SaveImageException(fileName);
        }
        image.setImageLink(new StringBuilder().append("/images/").append(fileName).toString());
    }
}
