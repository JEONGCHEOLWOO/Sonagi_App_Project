package com.sona.gi.service.firebase;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
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

        // 파일 이름을 URL로 인코딩하여 사용
        String encodedFileName = URLEncoder.encode(nameFile, StandardCharsets.UTF_8.toString());

        BlobInfo blobInfo = bucket.create(encodedFileName, content, file.getContentType());

        // 파일의 URL 생성
        String downloadUrl = "https://storage.googleapis.com/" + firebaseBucket + "/" + encodedFileName;

        return downloadUrl;
    }
}
