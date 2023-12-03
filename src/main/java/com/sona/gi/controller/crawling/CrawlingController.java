package com.sona.gi.controller.crawling;

import com.sona.gi.model.crawling.dto.CrawlingDto;
import com.sona.gi.model.crawling.dto.CrawlingNaverDto;
import com.sona.gi.model.crawling.dto.CrawlingNoticeDto;
import com.sona.gi.service.crawling.CrawlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/boot/crawling")
public class CrawlingController {
    @Autowired
    private CrawlingService crawlingService;

    @GetMapping("/findAll")
    public HashMap<String,Object> findAll(){
        HashMap<String,Object> mv = new HashMap<>();
        List<CrawlingDto> list = crawlingService.findAll();
        mv.put("list",list);
        return mv;
    }
    @GetMapping("/findNotice")
    public HashMap<String,Object> findNotice(){
        HashMap<String,Object> mv = new HashMap<>();
        List<CrawlingNoticeDto> list = crawlingService.findNotice();
        mv.put("list",list);
        return mv;
    }
    @GetMapping("/findNaver")
    public HashMap<String,Object> findNaver(){
        HashMap<String,Object> mv = new HashMap<>();
        List<CrawlingNaverDto> list = crawlingService.findNaver();
        mv.put("list",list);
        return mv;
    }
}