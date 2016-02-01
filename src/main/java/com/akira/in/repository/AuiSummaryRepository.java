package com.akira.in.repository;



import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.akira.in.model.AuiCurrent;
import com.akira.in.model.AuiSummary;

public interface AuiSummaryRepository extends JpaRepository<AuiSummary, Integer> {
	 Page<AuiSummary>findByDate(String d,Pageable p);
	
}
