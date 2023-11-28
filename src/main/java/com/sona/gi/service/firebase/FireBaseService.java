//package com.sona.gi.service.firebase;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.charset.StandardCharsets;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.cloud.storage.*;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.google.firebase.cloud.StorageClient;
//
//@Service
//public class FireBaseService {
//
//    @Value("${firebase-bucket}")
//    private String firebaseBucket;
//
//    public String uploadFiles(String imageUrl)
//            throws IOException {
//
////        // Firebase Admin SDK 인증 정보 설정
////        InputStream serviceAccount = getClass().getResourceAsStream(firebaseBucket); // Firebase Admin SDK 인증 파일 경로
////        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
////        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
////
////        // Firebase Storage 버킷명 설정
////        String bucketName = "gs://sonagi-671d0.appspot.com"; // Firebase Storage 버킷 이름
////
////        // 이미지 URL을 통해 이미지를 읽어와 바이트 배열로 변환
////        // 이미지를 읽어오는 코드는 여기서는 간략하게 예시로 작성되었습니다.
////        // 실제로는 URL을 통해 이미지를 다운로드하는 방법을 사용해야 합니다.
////        byte[] imageData = readImageFromUrl(imageUrl);
////
////        // Firebase Storage에 업로드할 이미지 이름 설정
////        String imageName = "uploaded-image.jpg"; // 업로드할 이미지 이름
////
////        // Firebase Storage에 이미지 업로드
////        BlobId blobId = BlobId.of(bucketName, imageName);
////        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
////        storage.create(blobInfo, new ByteArrayInputStream(imageData));
//////    }
//
////    private byte[] readImageFromUrl(String imageUrl) throws IOException {
////        // 이미지 URL을 통해 이미지를 읽어와 바이트 배열로 변환하는 로직을 구현해야 합니다.
////        // 이미지를 읽어오는 방법은 프로젝트에 맞게 구현되어야 합니다.
////        // 이 예시에서는 이미지 URL을 직접 사용하여 바이트 배열로 변환하는 방식을 사용하지 않습니다.
////        // 이미지를 읽어오는 코드는 실제로 이미지를 다운로드하여 바이트 배열로 변환하는 방식을 사용해야 합니다.
////        // 해당 부분은 프로젝트에서 이미지를 다운로드하는 방식을 구현해야 합니다.
////        return new byte[0];
////    }
////}
//////
//        Bucket bucket = StorageClient.getInstance().bucket(firebaseBucket);
//        InputStream content = new ByteArrayInputStream(file.getBytes());
//
//        // 파일 업로드
//        BlobInfo blobInfo = bucket.create(nameFile, content, file.getContentType());
//
//        // 이미지 URL 생성
//        String imageUrl = "https://firebasestorage.googleapis.com/v0/b/" + firebaseBucket + "/o/"
//                + blobInfo.getName() + "?alt=media";
//
//        return imageUrl;
//    }
//}
