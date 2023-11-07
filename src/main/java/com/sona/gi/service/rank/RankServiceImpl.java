package com.sona.gi.service.rank;

import com.sona.gi.model.donation.mapper.DonationMapper;
import com.sona.gi.model.rank.dto.RankDto;
import com.sona.gi.model.rank.mapper.RankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankServiceImpl implements RankService{

    @Autowired
    private RankMapper rankMapper;
    @Override
    public int regist(RankDto rankDto) {
        return rankMapper.regist(rankDto);
    }

    @Override
    public List<RankDto> findAll() {
        return rankMapper.findAll();
    }

    @Override
    public int modify(RankDto rankDto) {
        return rankMapper.modify(rankDto);
    }

    @Override
    public int delete(RankDto rankDto) {
        return rankMapper.delete(rankDto);
    }
}
