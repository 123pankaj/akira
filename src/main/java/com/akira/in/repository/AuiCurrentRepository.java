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
	

	
/*	 @Query(nativeQuery = true, value ="SELECT * FROM akira.aui_current WHERE cast(time as date) = ?#{[0]} "
	 		+ "ORDER BY "
	 		+ "CASE ?#{[4]} "
	 		+ "WHEN 'id' THEN id "
	 		+ "WHEN 'TimeInMicro' THEN TimeInMicro "
	 		+ "END, CASE ?#{[4]} "
	 		+ "WHEN 'Endpoint' THEN Endpoint "
	 		+ "WHEN 'RemoteHostName' THEN RemoteHostName "
	 		+ "WHEN 'RequestMethod' THEN RequestMethod "
	 		+ "WHEN 'statusCode' THEN statusCode "
	 		+ "WHEN 'byteSent' THEN byteSent "
	 		+ "WHEN 'ReferHead' THEN ReferHead "
	 		+ "WHEN 'userAgent' THEN userAgent "
	 		+ "WHEN 'ProcessId' THEN ProcessId "
	 		+ "END, CASE ?#{[4]} "
	 		+ "WHEN 'time' THEN time "
	 		+ "END ASC LIMIT ?#{[1]} OFFSET ?#{[2]}")
	 Set<AuiCurrent>findLogsByDateAsc(String date,int limit, int offset, String order,String sortBy);
*/
	 Page<AuiCurrent>findByTimeBetween(Date t1,Date t2,Pageable p);
	 List<AuiCurrent>findByTimeBetween(Date t1,Date t2);
		
	 

}
