package com.sona.gi.service.firebase;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FireBaseService {

    public String uploadToFirebaseStorage(MultipartFile file) {
        try {
            // Firebase Admin SDK 인증 정보 설정
            InputStream serviceAccount = getClass().getResourceAsStream("/path/to/serviceAccountKey.json"); // Firebase Admin SDK 인증 파일 경로
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
            Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();

            // Firebase Storage 버킷명 설정
            String bucketName = "your-firebase-storage-bucket-name"; // Firebase Storage 버킷 이름

            // 업로드할 파일명 설정
            String fileName = "uploaded-image.jpg"; // 업로드할 파일 이름

            // Firebase Storage에 업로드
            BlobInfo blobInfo = storage.create(
                    BlobInfo.newBuilder(bucketName, fileName)
                            .setContentType(file.getContentType())
                            .build(),
                    file.getBytes() // MultipartFile을 byte 배열로 변환하여 업로드
            );

            // 업로드한 파일의 URL 생성
            String imageUrl = blobInfo.getMediaLink(); // 업로드한 파일의 URL

            return imageUrl;
        } catch (IOException e) {
            e.printStackTrace();
            // 오류 발생 시 예외 처리
            return null;
        }
    }
}
