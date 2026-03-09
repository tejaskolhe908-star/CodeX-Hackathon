package com.tejas.noticeboard.controller;

import com.tejas.noticeboard.entity.Notice;
import com.tejas.noticeboard.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @PostMapping("/add")
    public Notice addNotice(@RequestBody Notice notice){
        return noticeService.addNotice(notice);
    }

    @GetMapping("/all")
    public List<Notice> getAllNotice(){
        return noticeService.getAllNotices();
    }

    @GetMapping("/student")
    public List<Notice> getStudentNotices(){
        return noticeService.getStudentNotices();
    }

    @GetMapping("/faculty")
    public List<Notice> getFacultyNotices(){
        return noticeService.getFacultyNotices();
    }

    @GetMapping("/admin")
    public List<Notice> getAdminNotices(){
        return noticeService.getAdminNotices();
    }

    @PutMapping("/update/{id}")
    public Notice updateNotice(@PathVariable Long id, @RequestBody Notice notice){
        return noticeService.updateNotice(id, notice);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteNotice(@PathVariable Long id){
        noticeService.deleteNotice(id);
        return "Notice deleted successfully";
    }
}