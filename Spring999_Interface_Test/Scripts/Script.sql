SELECT JOB_ID, JOB_TITLE, MIN_SALARY , MAX_SALARY, USEAGE  
	FROM JOBS;
	
INSERT INTO HR.JOBS
(JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY)
VALUES('DEV', 'Developer', 10000, 20000);


ALTER TABLE JOBS ADD USEAGE CHAR(1) DEFAULT 'Y';

UPDATE JOBS SET USEAGE='N';