package com.sona.gi.service.rank;

import com.sona.gi.model.rank.dto.RankDto;

import java.util.List;

public interface RankService {

    int regist(RankDto rankDto);
    List<RankDto> findAll();
    int modify(RankDto rankDto);

    int delete(RankDto rankDto);
}
