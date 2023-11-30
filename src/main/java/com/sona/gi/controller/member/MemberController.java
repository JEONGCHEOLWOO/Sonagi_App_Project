package com.sona.gi.controller.member;

import com.sona.gi.model.member.dto.MemberDto;
import com.sona.gi.service.firebase.FireBaseService;
import com.sona.gi.service.member.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/boot/member")
public class MemberController {

    //로그 확인용
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MemberService memberService;
    @Autowired
    private FireBaseService fireBaseService;

    @PostMapping("/login") // id, password 필요!
    public List<MemberDto> login(@RequestBody MemberDto memberDto){
        List<MemberDto> list = memberService.login(memberDto);

        return list;
    }

    @PostMapping("/regist") // id, password, managerName, phoneNum, adTel, adName, address, totalHc, currHc, introduction, profileImage 필요!
    public int regist(@RequestBody MemberDto memberDto){
        int resultCnt = memberService.regist(memberDto);
        return resultCnt;
    }

    //    @RequestMapping(method = RequestMethod.POST, path = "/postMethod")
    // 아래랑 동일
    @GetMapping("/findAll")
    public HashMap<String,Object> findAll(){
        HashMap<String,Object> mv = new HashMap<>();
        List<MemberDto> list = memberService.findAll();
        mv.put("list",list);
        return mv;
    }

    //검색 get, 수정 삭제 post
    @PostMapping("/modify") // id, password, introduction, adTel, adName, address, totalHc, profileImage 필요!
    public HashMap<String,Object> modify(@RequestBody MemberDto memberDto){
        HashMap<String,Object> mv = new HashMap<>();
        int resultCnt= memberService.modify(memberDto);
        mv.put("resultCnt",resultCnt);
        return mv;
    }

    @PostMapping("/delete") // id만 필요!
    public HashMap<String,Object> delete(@RequestBody MemberDto memberDto){
        HashMap<String,Object> mv = new HashMap<>();
        int resultCnt= memberService.delete(memberDto);
        mv.put("resultCnt",resultCnt);
        return mv;
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

    @PostMapping("/token") // id, expotoken, fcmtoken 필요!
    public int addToken(@RequestBody MemberDto memberDto){
        int resultCnt = memberService.addToken(memberDto);

        return resultCnt;
    }

    @PostMapping("/updateImageUrl") // id, profileImage 필요!
    public int updateImageUrl(@RequestBody MemberDto memberDto){
        int resultCnt = memberService.updateImageUrl(memberDto);
        return resultCnt;
    }

    @PostMapping("/findById")
    public List<MemberDto> findById(@RequestBody MemberDto memberDto){
        List<MemberDto> list = memberService.findById(memberDto);
        return list;
    }

}
