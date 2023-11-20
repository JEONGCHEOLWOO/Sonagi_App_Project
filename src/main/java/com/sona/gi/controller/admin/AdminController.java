package com.sona.gi.controller.admin;

import com.sona.gi.model.admin.dto.AdminDto;
import com.sona.gi.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boot/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/requestAdmin")
    public int requestAdmin(@RequestBody AdminDto adminDto){
        int resultCnt  = adminService.requestAdmin(adminDto);
        return resultCnt;
    }
}
