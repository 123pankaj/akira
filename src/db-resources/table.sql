SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

DROP SCHEMA IF EXISTS akira;
CREATE SCHEMA akira;
USE akira;


-- -------------------------------------------------
-- language -> Language name with Id
-- --------------------------------------------------
CREATE TABLE userLogin (uid VARCHAR(20) NOT NULL, uname VARCHAR(20) NOT NULL, email VARCHAR(50) NOT NULL , isAdmin CHAR(1) ,PRIMARY KEY  (uid));

CREATE TABLE apacheFormat (afid VARCHAR(20) NOT NULL, logFormat VARCHAR(50) NOT NULL, PRIMARY KEY  (afid) );

CREATE TABLE userApachePreferences(afid VARCHAR(20) NOT NULL, uid VARCHAR(50) NOT NULL, PRIMARY KEY  (afid,uid),CONSTRAINT fk_user_id FOREIGN KEY (uid) REFERENCES userLogin (uid) ON DELETE RESTRICT ON UPDATE CASCADE, CONSTRAINT fk_apacheFormat_id FOREIGN KEY (afid) REFERENCES apacheFormat (afid) ON DELETE RESTRICT ON UPDATE CASCADE);
