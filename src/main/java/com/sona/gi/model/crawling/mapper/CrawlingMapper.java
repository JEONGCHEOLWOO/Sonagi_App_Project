package com.sona.gi.model.crawling.mapper;

import com.sona.gi.model.crawling.dto.CrawlingDto;
import com.sona.gi.model.crawling.dto.CrawlingNaverDto;
import com.sona.gi.model.crawling.dto.CrawlingNoticeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CrawlingMapper {
    List<CrawlingDto> findAll();

    List<CrawlingNoticeDto> findNotice();

    List<CrawlingNaverDto> findNaver();
}