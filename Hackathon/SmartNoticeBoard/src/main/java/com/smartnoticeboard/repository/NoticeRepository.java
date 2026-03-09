package com.smartnoticeboard.repository;

import com.smartnoticeboard.entity.Notice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
	
	List<Notice> findByTargetRole(String targetRole);

}