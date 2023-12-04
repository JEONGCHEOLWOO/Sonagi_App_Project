package com.sona.gi.service.admin;

import com.sona.gi.model.admin.dto.AdminDto;
import com.sona.gi.model.admin.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int requestAdmin(AdminDto adminDto) {return adminMapper.requestAdmin(adminDto);}

    @Override
    public List<AdminDto> findAll(AdminDto adminDto) { return adminMapper.findAll(adminDto); }

}
