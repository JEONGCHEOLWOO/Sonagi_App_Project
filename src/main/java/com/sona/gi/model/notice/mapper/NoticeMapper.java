package com.sona.gi.model.notice.mapper;

import com.sona.gi.model.notice.dto.NoticeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    int regist(NoticeDto noticeDto);
    List<NoticeDto> findAll();

    List<NoticeDto> textNumSearch(NoticeDto noticeDto);
    int modify(NoticeDto noticeDto);

    int delete(NoticeDto noticeDto);
    List<NoticeDto> findByNum(String id);
}
