package com.sona.gi.controller.notice;

import com.sona.gi.model.notice.dto.NoticeDto;
import com.sona.gi.service.notice.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/boot/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;


    @PostMapping("/regist")
    public int regist(@RequestBody NoticeDto noticeDto){
        int resultCnt = noticeService.regist(noticeDto);
        return resultCnt;
    }

    // @RequestMapping(method = RequestMethod.POST, path = "/postMethod")
    // 아래랑 동일
    @GetMapping("/findAll")
    public List<NoticeDto> findAll(){
        List<NoticeDto> list = noticeService.findAll();
        return list;
    }

    @PostMapping("/textNumSearch")
    public List<NoticeDto> textNumSearch(@RequestBody NoticeDto noticeDto){
        List<NoticeDto> list = noticeService.textNumSearch(noticeDto);
        return list;
    }

    //검색 get, 수정 삭제 post
    @PostMapping("/modify")
    public HashMap<String,Object> modify(@RequestBody NoticeDto noticeDto){
        HashMap<String,Object> mv = new HashMap<>();
        int resultCnt= noticeService.modify(noticeDto);
        mv.put("resultCnt",resultCnt);
        return mv;
    }

    @PostMapping("/delete")
    public HashMap<String,Object> delete(@RequestBody NoticeDto noticeDto){
        HashMap<String,Object> mv = new HashMap<>();
        int resultCnt= noticeService.delete(noticeDto);
        mv.put("resultCnt",resultCnt);
        return mv;
    }

    @GetMapping("/{id}")
    public List<NoticeDto> findByNum(@PathVariable String id) {
        return noticeService.findByNum(id);
    }
}
