package com.sona.gi.service.admin;

import com.sona.gi.model.admin.dto.AdminDto;
import java.util.List;

public interface AdminService {

    int requestAdmin(AdminDto adminDto);

    List<AdminDto> findAll();

    int delete(AdminDto adminDto);

}
