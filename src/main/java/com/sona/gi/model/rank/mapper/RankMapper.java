package com.sona.gi.model.rank.mapper;

import com.sona.gi.model.member.dto.MemberDto;
import com.sona.gi.model.rank.dto.RankDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RankMapper {

    int regist(RankDto rankDto);
    List<RankDto> findAll();
    int modify(RankDto rankDto);

    int delete(RankDto rankDto);
}
