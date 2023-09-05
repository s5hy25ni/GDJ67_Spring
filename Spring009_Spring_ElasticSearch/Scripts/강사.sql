CREATE TABLE Teacher (
  id NUMBER GENERATED ALWAYS AS IDENTITY,
  nickname VARCHAR2(20),
  age NUMBER,
  gender VARCHAR2(10),
  introduction VARCHAR2(100),
  education CLOB CHECK (education IS JSON),
  available_location CLOB CHECK (available_location IS JSON),
  subject CLOB CHECK (subject IS JSON),
  specialty CLOB CHECK (specialty IS JSON),
  minimum_fee NUMBER,
  external_link_video VARCHAR2(500),
  external_link_website VARCHAR2(500),
  external_link_mobile VARCHAR2(500),
  experience CLOB CHECK (experience IS JSON),
  PRIMARY KEY (id),
  LAST_LIVISION DEFAULT SYSDATE NOT NULL
);

ALTER TABLE TEACHER ADD LAST_LIVISION DATE;
ALTER TABLE TEACHER MODIFY LAST_LIVISION DEFAULT SYSDATE NOT NULL;

INSERT INTO Teacher (age, gender, introduction, education, available_location, subject, specialty, minimum_fee, external_link_video, external_link_website, external_link_mobile, experience, nickname) 
VALUES (30, '남', '홍길동 강사입니다.', '{"univ":"한양대학교", "major":"컴퓨터공학과", "graduate":"석사"}', '["서울특별시 강남구", "경기도 수원시"]', '["자바", "파이썬"]', '["웹 개발", "알고리즘"]', 20, 'https://www.youtube.com/watch?v=abc123', 'https://www.hongkildong.com', 'https://m.hongkildong.com', '[{"company":"A회사", "position":"주니어 개발자", "year":"2018-2020"}, {"company":"B회사", "position":"시니어 개발자", "year":"2020-현재"}]', '홍사원');


INSERT INTO Teacher (age, gender, introduction, education, available_location, subject, specialty, minimum_fee, external_link_video, external_link_website, external_link_mobile, experience, NICKNAME) 
VALUES (25, '여', '김영희 강사입니다.', '{"univ":"서울대학교", "major":"경제학과", "graduate":"학사"}', '["서울특별시 송파구", "경기도 용인시"]', '["경제학", "수학"]', '["금융수학"]', 25, 'https://www.youtube.com/watch?v=xyz456', 'https://www.kimyounghee.com', 'https://m.kimyounghee.com', '[{"company":"C회사", "position":"인턴", "year":"2020-2021"}, {"company":"D회사", "position":"스타트업", "year":"2021-현재"}]', '김강사');

INSERT INTO Teacher (age, gender, introduction, education, available_location, subject, specialty, minimum_fee, external_link_video, external_link_website, external_link_mobile, experience, nickname) 
VALUES (40, '여', '새로 등록한 강사입니다.', '{"univ":"연세대학교", "major":"심리학과", "graduate":"학사"}', '["서울특별시 동대문구", "경기도 용인시"]', '["자바스크립트", "스프링"]', '["보안"]', 30, 'https://www.youtube.com/watch?v=xyz456', 'https://www.kimyounghee.com', 'https://m.kimyounghee.com', '[{"company":"C회사", "position":"인턴", "year":"2020-2021"}, {"company":"D회사", "position":"스타트업", "year":"2021-현재"}]', '이강사');

INSERT INTO Teacher (age, gender, introduction, education, available_location, subject, specialty, minimum_fee, external_link_video, external_link_website, external_link_mobile, experience, nickname) 
VALUES (45, '남', '새로 등록한 강사입니다.', '{"univ":"고려대학교", "major":"전자공학과", "graduate":"박사"}', '["부산특별시 서면구", "경상남도 대구시"]', '["코틀린", "플러터"]', '["모바일 앱 개발"]', 35, 'https://www.youtube.com/watch?v=xyz456', 'https://www.kimyounghee.com', 'https://m.kimyounghee.com', '[{"company":"C회사", "position":"인턴", "year":"2020-2021"}, {"company":"D회사", "position":"스타트업", "year":"2021-현재"}]', '앱등이');

INSERT INTO Teacher (age, gender, introduction, education, available_location, subject, specialty, minimum_fee, external_link_video, external_link_website, external_link_mobile, experience, nickname) 
VALUES (28, '여', '안녕하세요.', '{"univ":"서강대학교", "major":"컴퓨터공학과", "graduate":"학사"}', '["경기도 광명시", "서울특별시 금천구"]', '["스프링", "HTML"]', '["웹 개발"]', 20, 'https://www.youtube.com/watch?v=xyz456', 'https://www.kimyounghee.com', 'https://m.kimyounghee.com', '[{"company":"C회사", "position":"인턴", "year":"2020-2021"}, {"company":"D회사", "position":"스타트업", "year":"2021-현재"}]', '동글이');





