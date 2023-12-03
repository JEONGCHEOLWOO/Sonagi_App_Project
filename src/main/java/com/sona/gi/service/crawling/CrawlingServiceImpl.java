package com.sona.gi.service.crawling;

import com.sona.gi.model.crawling.dto.CrawlingDto;
import com.sona.gi.model.crawling.dto.CrawlingNaverDto;
import com.sona.gi.model.crawling.dto.CrawlingNoticeDto;
import com.sona.gi.model.crawling.mapper.CrawlingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrawlingServiceImpl implements CrawlingService{

    @Autowired
    private CrawlingMapper crawlingMapper;

    @Override
    public List<CrawlingNoticeDto> findNotice() {
        return crawlingMapper.findNotice();
    }

    @Override
    public List<CrawlingNaverDto> findNaver() {
        return crawlingMapper.findNaver();
    }

    @Override
    public List<CrawlingDto> findAll() {return crawlingMapper.findAll();}
}