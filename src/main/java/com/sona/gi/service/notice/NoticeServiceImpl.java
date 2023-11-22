package com.sona.gi.service.notice;

import com.sona.gi.model.notice.dto.NoticeDto;
import com.sona.gi.model.notice.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public int regist(NoticeDto noticeDto) {
        return noticeMapper.regist(noticeDto);
    }

    @Override
    public List<NoticeDto> findAll() {
        return noticeMapper.findAll();
    }
    @Override
    public List<NoticeDto> textNumSearch() { return noticeMapper.textNumSearch(); }

    @Override
    public int modify(NoticeDto noticeDto) {
        return noticeMapper.modify(noticeDto);
    }

    @Override
    public int delete(NoticeDto noticeDto) {
        return noticeMapper.delete(noticeDto);
    }
}
