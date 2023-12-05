package com.sona.gi.service.notice;

import com.sona.gi.model.notice.dto.NoticeDto;

import java.util.List;

public interface NoticeService {

    int regist(NoticeDto noticeDto);
    List<NoticeDto> findAll();
    List<NoticeDto> textNumSearch(NoticeDto noticeDto);
    int modify(NoticeDto noticeDto);

    int delete(NoticeDto noticeDto);
    List<NoticeDto> findByNum(String id);

}
