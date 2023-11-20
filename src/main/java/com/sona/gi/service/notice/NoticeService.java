package com.sona.gi.service.notice;

import com.sona.gi.model.notice.dto.NoticeDto;

import java.util.List;

public interface NoticeService {

    int regist(NoticeDto noticeDto);
    List<NoticeDto> findAll();
    int modify(NoticeDto noticeDto);

    int delete(NoticeDto noticeDto);
}
