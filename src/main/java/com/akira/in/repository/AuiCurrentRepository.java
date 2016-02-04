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
	

	

	
	 @Query(nativeQuery = true, value ="Select distinct URLRequested from AUI_CURRENT where date(time)=?#{[0]}")
	 List<String>findDistinctUrl(String date);
	
	 @Query(nativeQuery = true, value ="Select Count(1) from AUI_CURRENT where URLRequested = ?#{[0]} AND statusCode Like '2__' AND date(time)=?#{[1]}")
	 int numberOfSuccess(String s,String date);

	 @Query(nativeQuery = true, value ="Select Count(1) from AUI_CURRENT where URLRequested = ?#{[0]} AND statusCode Like '3__' AND date(time)=?#{[1]}")
	 int numberOfRedirect(String s,String date);
	 
	 
	 @Query(nativeQuery = true, value ="Select Count(1) from AUI_CURRENT where URLRequested = ?#{[0]} AND  statusCode Like '4__' OR  statusCode Like '5__'    AND date(time)=?#{[1]}")
	 int numberOfFailure(String s,String date);	 
	 
	 @Query(nativeQuery = true, value ="SELECT avg(TimeInMicro) FROM akira.AUI_CURRENT where URLRequested = ?#{[0]}  AND date(time)=?#{[1]}")
	 int averageResponseTime(String s,String date);	
	 
	 Page<AuiCurrent>findByTimeBetween(Date t1,Date t2,Pageable p);
	 List<AuiCurrent>findByTimeBetween(Date t1,Date t2);
		
	 @Query(nativeQuery = true, value ="SELECT count(1) FROM akira.AUI_CURRENT where time between ?#{[0]} and ?#{[1]}")
	 int totalLogsBetween(String d0,String d1);

}
