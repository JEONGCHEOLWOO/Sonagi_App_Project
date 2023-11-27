package com.sona.gi.service.firebase;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;

@Service
public class FireBaseService {

    @Value("${firebase-bucket}")
    private String firebaseBucket;

    public String uploadFiles(MultipartFile file, String nameFile)
            throws IOException {
        Bucket bucket = StorageClient.getInstance().bucket(firebaseBucket);
        InputStream content = new ByteArrayInputStream(file.getBytes());

        // 파일 업로드
        BlobInfo blobInfo = bucket.create(nameFile, content, file.getContentType());

        // 이미지 URL 생성
        String imageUrl = "https://firebasestorage.googleapis.com/v0/b/" + firebaseBucket + "/o/"
                + blobInfo.getName() + "?alt=media";

        return imageUrl;
    }
}
