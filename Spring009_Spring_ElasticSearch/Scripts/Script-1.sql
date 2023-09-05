CREATE TABLE CAREERCERT (
    NAME VARCHAR2(100),          -- 성명
    CONTACT VARCHAR2(100),       -- 연락처
    AFFILIATION VARCHAR2(100),   -- 소속
    POSITION VARCHAR2(100),      -- 직위
    PERIOD VARCHAR2(100),     			 -- 재직기간 (월 단위로 가정)
    JOB_DESC VARCHAR2(500),      -- 담당업무 
    ISSUER_NAME VARCHAR2(100),   -- 발급담당자명
    ISSUER_CONTACT VARCHAR2(100),-- 발급담당자연락처 
    CREATE_DATE VARCHAR2(100), 			 -- 작성일 (기본값은 현재 시스템 날짜)
    COMPANY_NAME VARCHAR2(200)   -- 회사명
);

DROP TABLE CAREERCERT;


