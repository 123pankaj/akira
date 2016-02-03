package com.akira.in.repository;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.akira.in.model.AuiCurrent;
import com.akira.in.model.User;
import java.util.Date;
import java.util.List;

import java.lang.Integer;

public interface AuiCurrentRepository extends JpaRepository<AuiCurrent, Integer>{
	

	

	
	 @Query(nativeQuery = true, value ="Select distinct URLRequested from aui_current")
	 List<String>findDistinctUrl();
	
	 @Query(nativeQuery = true, value ="Select Count(*) from aui_current where URLRequested = ?#{[0]} AND statusCode=200")
	 int numberOfSuccess(String s);
	 
	 @Query(nativeQuery = true, value ="Select Count(*) from aui_current where URLRequested = ?#{[0]} AND statusCode<>200")
	 int numberOfFailure(String s);	 
	 
	 @Query(nativeQuery = true, value ="SELECT avg(TimeInMicro) FROM akira.aui_current where URLRequested = ?#{[0]}")
	 int averageResponseTime(String s);	
	 
	 Page<AuiCurrent>findByTimeBetween(Date t1,Date t2,Pageable p);
	 List<AuiCurrent>findByTimeBetween(Date t1,Date t2);
		
	 @Query(nativeQuery = true, value ="SELECT count(*) FROM akira.aui_current where time between ?#{[0]} and ?#{[1]}")
	 int totalLogsBetween(String d0,String d1);

}
