package com.tejas.noticeboard.service;

import com.tejas.noticeboard.entity.Notice;
import com.tejas.noticeboard.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    public Notice addNotice(Notice notice){
        return noticeRepository.save(notice);
    }

    public List<Notice> getAllNotices(){
        return noticeRepository.findAll();
    }

    public Notice updateNotice(Long id, Notice noticeDetails){

        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notice not found"));

        notice.setTitle(noticeDetails.getTitle());
        notice.setDescription(noticeDetails.getDescription());
        notice.setRole(noticeDetails.getRole());

        return noticeRepository.save(notice);
    }

    public void deleteNotice(Long id){
        noticeRepository.deleteById(id);
    }

    public List<Notice> getStudentNotices(){
        return noticeRepository.findByRole("STUDENT");
    }

    public List<Notice> getFacultyNotices(){
        return noticeRepository.findByRole("FACULTY");
    }

    public List<Notice> getAdminNotices(){
        return noticeRepository.findByRole("ADMIN");
    }
}