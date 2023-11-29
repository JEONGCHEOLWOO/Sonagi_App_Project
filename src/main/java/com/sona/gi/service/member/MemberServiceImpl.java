package com.sona.gi.service.member;

import com.sona.gi.model.member.dto.MemberDto;
import com.sona.gi.model.member.mapper.MemberMapper;
import com.sona.gi.model.restaurant.dto.RestaurantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

        @Autowired
        private MemberMapper memberMapper;

        @Override
        public int regist(MemberDto memberDto){return memberMapper.regist(memberDto);}

        @Override
        public List<MemberDto> findAll() {
                return memberMapper.findAll();
        }

        @Override
        public int modify(MemberDto memberDto) {
                return memberMapper.modify(memberDto);
        }

        @Override
        public int delete(MemberDto memberDto) {
                return memberMapper.delete(memberDto);
        }

        @Override
        public int findSearch(MemberDto memberDto) { return memberMapper.findSearch(memberDto); }

        @Override
        public List<MemberDto> login(MemberDto memberDto) { return memberMapper.login(memberDto); }

        @Override
        public int addToken(MemberDto memberDto) {
                return memberMapper.addToken(memberDto);
        }

        @Override
        public int updateImageUrl(MemberDto memberDto) {
                return memberMapper.updateImageUrl(memberDto);
        }

        @Override
        public List<MemberDto> findById(MemberDto memberDto) { return memberMapper.findById(memberDto); }

}
