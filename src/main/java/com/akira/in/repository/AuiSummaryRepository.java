package com.akira.in.repository;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.akira.in.model.AuiSummary;

public interface AuiSummaryRepository extends JpaRepository<AuiSummary, Integer> {
	 Page<AuiSummary>findByDate(String d,Pageable p);
	 List<AuiSummary>findByDate(String d);
	 
	 
	 @Query(nativeQuery = true, value ="Select distinct URLRequested from aui_summary where LogDate between ?#{[0]} and ?#{[1]}")
	 List<String>getDistinctUrl(String startDate,String endDate);
		 
	 
	 @Query(nativeQuery = true, value ="SELECT SuccessStatusCode FROM akira.AUI_SUMMARY where URLRequested=?#{[0]} and LogDate between ?#{[1]} and ?#{[2]}")
	 List<Integer>findSuccessListByUrlBetweenDates(String url,String startDate,String endDate);
	
	 @Query(nativeQuery = true, value ="SELECT AverageTimeInMicro FROM akira.aui_summary where URLRequested=?#{[0]} and LogDate between ?#{[1]} and ?#{[2]}")
	 List<Integer>findResponseTimeListByUrlBetweenDates(String url,String startDate,String endDate);
	 
	 @Query(nativeQuery = true, value ="SELECT FailureStatusCode FROM akira.aui_summary where URLRequested=?#{[0]} and LogDate between ?#{[1]} and ?#{[2]}")
	 List<Integer>findFailureListByUrlBetweenDates(String url,String startDate,String endDate);

	 @Query(nativeQuery = true, value ="SELECT RedirectStatusCode FROM akira.aui_summary where URLRequested=?#{[0]} and LogDate between ?#{[1]} and ?#{[2]}")
	 List<Integer>findRedirectListByUrlBetweenDates(String url,String startDate,String endDate);
	
	 
	 @Query(nativeQuery = true, value ="SELECT distinct LogDate FROM akira.aui_summary where URLRequested=?#{[0]} and LogDate between  ?#{[1]} and ?#{[2]} order by LogDate ASC;")
	 List<String>findDateListByUrlBetweenDates(String url,String startDate,String endDate);
	
	 
}
