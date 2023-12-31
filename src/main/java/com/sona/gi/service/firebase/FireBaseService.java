package com.sona.gi.service.firebase;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStream;

@Service
public class FireBaseService {
    public String uploadFiles(MultipartFile file, String nameFile, String folderName) throws IOException {

        // Firebase Admin SDK 인증 정보 설정
        InputStream serviceAccount = FireBaseService.class.getResourceAsStream("/serviceAccountKey.json");
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();

        // Firebase Storage 버킷명 설정
        String bucketName = "sonagi-671d0.appspot.com"; // Firebase Storage 버킷 이름
        System.out.println(bucketName);
        String contentType = file.getContentType();

        // Firebase Storage에 업로드할 이미지 이름 설정
        String imageName = nameFile;

        // Firebase Storage에 이미지 업로드
        String objectName = folderName + "/" + imageName; // 폴더명을 추가
        BlobId blobId = BlobId.of(bucketName, objectName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(contentType).build();
        storage.create(blobInfo, file.getBytes()); // 파일의 바이트 배열을 업로드

        // 이미지 URL 생성
        String imageUrl = "https://firebasestorage.googleapis.com/v0/b/" + bucketName + "/o/"
                + java.net.URLEncoder.encode(objectName, "UTF-8") + "?alt=media";

        System.out.println(imageUrl);
        return imageUrl; // 업로드된 이미지 이름 또는 URL 반환
    }
}
