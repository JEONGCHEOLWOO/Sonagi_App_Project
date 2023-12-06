package com.sona.gi.controller.review;

import com.sona.gi.model.review.dto.ReviewDto;
import com.sona.gi.service.firebase.FireBaseService;
import com.sona.gi.service.review.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/boot/review")
public class ReviewController {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private ReviewService reviewService;
    @Autowired
    private FireBaseService fireBaseService;


    @PostMapping("/regist")
    public int regist(@RequestBody ReviewDto reviewDto){
        int resultCnt = reviewService.regist(reviewDto);
        return resultCnt;
    }

    //    @RequestMapping(method = RequestMethod.POST, path = "/postMethod")
    // 아래랑 동일
    @GetMapping("/findAll")
    public List<ReviewDto> findAll(){
        List<ReviewDto> list = reviewService.findAll();
        return list;
    }

    //검색 get, 수정 삭제 post
    @PostMapping("/modify")
    public int modify(@RequestBody ReviewDto reviewDto){
        int resultCnt= reviewService.modify(reviewDto);
        return resultCnt;
    }

    @PostMapping("/delete")
    public int delete(@RequestBody ReviewDto reviewDto){
        int resultCnt= reviewService.delete(reviewDto);
        return resultCnt;
    }

    @PostMapping("/files")
    public String uploadFileToFirebase(
            @RequestParam("file") MultipartFile file,
            @RequestParam("nameFile") String nameFile,
            @RequestParam("folderName") String folderName
    ) {
        try {
            String imageUrl = fireBaseService.uploadFiles(file, nameFile, folderName);
            return imageUrl;
        } catch (Exception e) {
            return nameFile;
        }
    }

    @PostMapping("/updateImageUrl") // id, profileImage 필요!
    public int updateImageUrl(@RequestBody ReviewDto reviewDto){
        int resultCnt = reviewService.updateImageUrl(reviewDto);
        return resultCnt;
    }

    @PostMapping("/findByIdD")
    public List<ReviewDto> findByIdD(@RequestBody ReviewDto reviewDto){
        List<ReviewDto> list = reviewService.findByIdD(reviewDto);
        return list;
    }

    @PostMapping("/findByIdR")
    public List<ReviewDto> findByIdR(@RequestBody ReviewDto reviewDto){
        List<ReviewDto> list = reviewService.findByIdR(reviewDto);
        return list;
    }

    @PostMapping("/findByDonatorReciverReviewTitle")
    public List<ReviewDto> findByDonatorReciverReviewTitle(@RequestBody ReviewDto reviewDto){
        List<ReviewDto> list = reviewService.findByDonatorReciverReviewTitle(reviewDto);
        return list;
    }
}
