package com.sona.gi.model.admin.mapper;

import com.sona.gi.model.admin.dto.AdminDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    List<AdminDto> requestAdmin(AdminDto adminDto);
}
