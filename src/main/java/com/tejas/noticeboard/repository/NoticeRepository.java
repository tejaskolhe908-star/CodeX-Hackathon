package com.tejas.noticeboard.repository;

import com.tejas.noticeboard.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

    List<Notice> findByRole(String role);

}