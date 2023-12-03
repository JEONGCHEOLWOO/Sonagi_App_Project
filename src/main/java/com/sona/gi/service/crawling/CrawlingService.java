package com.sona.gi.service.crawling;

import com.sona.gi.model.crawling.dto.CrawlingDto;
import com.sona.gi.model.crawling.dto.CrawlingNaverDto;
import com.sona.gi.model.crawling.dto.CrawlingNoticeDto;

import java.util.List;

public interface CrawlingService {

    List<CrawlingDto> findAll();
    List<CrawlingNoticeDto> findNotice();
    List<CrawlingNaverDto> findNaver();

}