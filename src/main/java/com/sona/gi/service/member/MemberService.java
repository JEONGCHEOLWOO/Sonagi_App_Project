package com.sona.gi.service.member;

import com.sona.gi.model.member.dto.MemberDto;
import java.util.List;

public interface MemberService {

    int regist(MemberDto memberDto);
    List<MemberDto> findAll();
    int modify(MemberDto memberDto);
    int delete(MemberDto memberDto);
    int findSearch(MemberDto memberDto);
    List<MemberDto> login(MemberDto memberDto);
    int addToken(MemberDto memberDto);


}
