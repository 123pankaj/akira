SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

DROP SCHEMA IF EXISTS akira;
CREATE SCHEMA akira;
USE akira;


-- -------------------------------------------------
-- language -> Language name with Id
-- --------------------------------------------------
CREATE TABLE userLogin (uid INT UNSIGNED NOT NULL, uname VARCHAR(20) NOT NULL,password VARCHAR(20) NOT NULL, email VARCHAR(50) NOT NULL , isAdmin CHAR(1) ,PRIMARY KEY  (uid));

CREATE TABLE apacheFormat (afid INT UNSIGNED NOT NULL, logFormat VARCHAR(100) NOT NULL, PRIMARY KEY  (afid) );

-- CREATE TABLE compApachePreferences(afid VARCHAR(20) NOT NULL, cid VARCHAR(50) NOT NULL, PRIMARY KEY  (afid,cid),CONSTRAINT fk_user_id FOREIGN KEY (uid) REFERENCES userLogin (uid) ON DELETE RESTRICT ON UPDATE CASCADE, CONSTRAINT fk_apacheFormat_id FOREIGN KEY (afid) REFERENCES apacheFormat (afid) ON DELETE RESTRICT ON UPDATE CASCADE);

CREATE TABLE AUI_CURRENT (id INT UNSIGNED NOT NULL AUTO_INCREMENT, time TIMESTAMP ,Endpoint VARCHAR(255),RemoteHostName VARCHAR(16),RequestMethod VARCHAR(10), URLRequested VARCHAR(255),QueryStr VARCHAR(255), statusCode VARCHAR(3),byteSent INT, TimeInMicro INT UNSIGNED,ProcessId VARCHAR(10), ReferHead VARCHAR(255),userAgent VARCHAR(255),
 KEY fk_id (id));	 
 
CREATE TABLE akira.AUI_SUMMARY (sid INT UNSIGNED NOT NULL AUTO_INCREMENT, LogDate varchar(12) , URLRequested VARCHAR(255) ,SuccessStatusCode int,RedirectStatusCode int,FailureStatusCode int, AverageTimeInMicro INT UNSIGNED, KEY fk_id (sid));	 


create view SuccessCount as SELECT distinct URLRequested as url,count(statusCode) as num  FROM akira.aui_current where statusCode like '2__' and date(time)='2016-01-29' group by URLRequested  ;
create view RedirectCount as SELECT distinct URLRequested  as url,count(statusCode) as num  FROM akira.aui_current where statusCode like '3__' and date(time)='2016-01-29'  group by URLRequested;
create view FailureCount as SELECT distinct URLRequested  as url,count(statusCode) as num FROM akira.aui_current where statusCode like '4__' and date(time)='2016-01-29'  or statusCode like '5__' group by URLRequested;
create view  averagecount as SELECT distinct URLRequested  as url ,avg(TimeInMicro) as num FROM akira.aui_current  where date(time)='2016-01-29' group by URLRequested;
