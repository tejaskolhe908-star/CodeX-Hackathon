package com.smartnoticeboard.service;

import com.smartnoticeboard.entity.Notice;
import com.smartnoticeboard.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    public Notice addNotice(Notice notice) {
        return noticeRepository.save(notice);
    }

    public List<Notice> getAllNotices() {
        return noticeRepository.findAll();
    }

    public void deleteNotice(Long id) {
        noticeRepository.deleteById(id);
    }
    
    public List<Notice> getNoticesByRole(String role) {
        return noticeRepository.findByTargetRole(role);
    }
}