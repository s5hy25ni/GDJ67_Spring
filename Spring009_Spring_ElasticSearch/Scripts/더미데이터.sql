DECLARE
  CURSOR subjects_cur IS SELECT ko_title FROM subjects;
  TYPE subjects_tbl_type IS TABLE OF subjects_cur%ROWTYPE INDEX BY BINARY_INTEGER;
  subjects_tbl subjects_tbl_type;
  v_subjects    VARCHAR2(1000);
  age_arr       NUMBER := 5;
  gender_arr    VARCHAR2(40) := '남,여';
  univ_arr      VARCHAR2(150) := '서강대학교,한양대학교,서울대학교,연세대학교,고려대학교';
  major_arr     VARCHAR2(120) := '컴퓨터공학과,경제학과,심리학과,전자공학과';
  graduate_arr  VARCHAR2(20) := '학사,석사';
  indx_sub      INTEGER;
  indx_sub_plus INTEGER;
BEGIN
  OPEN subjects_cur;
  FETCH subjects_cur BULK COLLECT INTO subjects_tbl;
  CLOSE subjects_cur;

  FOR i IN 1 .. 200
  LOOP
    indx_sub := MOD(i, subjects_tbl.COUNT) + 1;
    indx_sub_plus := MOD(i + 1, subjects_tbl.COUNT) + 1;

    v_subjects := '["' || subjects_tbl(indx_sub).ko_title || '", "' || subjects_tbl(indx_sub_plus).ko_title || '"]';

    INSERT INTO Teacher (
      age,
      gender,
      introduction,
      education,
      available_location,
      subject,
      specialty,
      minimum_fee,
      external_link_video,
      external_link_website,
      external_link_mobile,
      experience,
      nickname
    ) VALUES (
      20 + MOD(i, age_arr),
      REGEXP_SUBSTR(gender_arr, '[^,]+', 1, ROUND(MOD(i, 2)+1)),
      '안녕하세요.',
      '{"univ":"' || REGEXP_SUBSTR(univ_arr, '[^,]+', 1, ROUND(MOD(i, 5)+1) ) || '", "major":"' || REGEXP_SUBSTR(major_arr, '[^,]+', 1, ROUND(MOD(i, 4)+1) ) || '", "graduate":"' || REGEXP_SUBSTR(graduate_arr, '[^,]+', 1, ROUND(MOD(i, 2)+1) ) || '"}',
      '["경기도 광명시", "서울특별시 금천구"]',
      v_subjects,
      '["웹 개발"]',
      20,
      'https://www.youtube.com/watch?v=xyz456',
      'https://www.kimyounghee.com',
      'https://m.kimyounghee.com',
      '[{"company":"C회사", "position":"인턴", "year":"2020-2021"}, {"company":"D회사", "position":"스타트업", "year":"2021-현재"}]',
      '닉네임' || i
    );
  END LOOP;
  COMMIT;
END;

UPDATE TEACHER SET GENDER = '여' WHERE GENDER = ',';

DECLARE
  CURSOR subjects_cur IS SELECT ko_title FROM subjects;
  TYPE subjects_tbl_type IS TABLE OF subjects_cur%ROWTYPE INDEX BY BINARY_INTEGER;
  subjects_tbl subjects_tbl_type;
  v_subjects    VARCHAR2(1000);
  age_arr       NUMBER := 5;
  gender_arr    VARCHAR2(40) := '남,여';
  univ_arr      VARCHAR2(150) := '서강대학교,한양대학교,서울대학교,연세대학교,고려대학교';
  major_arr     VARCHAR2(120) := '컴퓨터공학과,경제학과,심리학과,전자공학과';
  graduate_arr  VARCHAR2(20) := '학사,석사';
  indx_sub      INTEGER;
  indx_sub_plus INTEGER;
  v_introduction VARCHAR2(2000);
BEGIN
  OPEN subjects_cur;
  FETCH subjects_cur BULK COLLECT INTO subjects_tbl;
  CLOSE subjects_cur;

  FOR i IN 1 .. 10000
  LOOP
    indx_sub := MOD(i, subjects_tbl.COUNT) + 1;
    indx_sub_plus := MOD(i + 1, subjects_tbl.COUNT) + 1;

    v_subjects := '["' || subjects_tbl(indx_sub).ko_title || '", "' || subjects_tbl(indx_sub_plus).ko_title || '"]';
    v_introduction := '안녕하세요. ' || subjects_tbl(indx_sub).ko_title || '를 잘 가르치는 강사입니다. ' || subjects_tbl(indx_sub_plus).ko_title || '도 가능해요.';

    INSERT INTO Teacher (
      age,
      gender,
      introduction,
      education,
      available_location,
      subject,
      specialty,
      minimum_fee,
      external_link_video,
      external_link_website,
      external_link_mobile,
      experience,
      nickname
    ) VALUES (
      20 + MOD(i, age_arr),
      REGEXP_SUBSTR(gender_arr, '[^,]+', 1, ROUND(MOD(i, 2)+1)),
      v_introduction,
      '{"univ":"' || REGEXP_SUBSTR(univ_arr, '[^,]+', 1, ROUND(MOD(i, 5)+1) ) || '", "major":"' || REGEXP_SUBSTR(major_arr, '[^,]+', 1, ROUND(MOD(i, 4)+1) ) || '", "graduate":"' || REGEXP_SUBSTR(graduate_arr, '[^,]+', 1, ROUND(MOD(i, 2)+1) ) || '"}',
      '["경기도 광명시", "서울특별시 금천구"]',
      v_subjects,
      '["웹 개발"]',
      20,
      'https://www.youtube.com/watch?v=xyz456',
      'https://www.kimyounghee.com',
      'https://m.kimyounghee.com',
      '[{"company":"C회사", "position":"인턴", "year":"2020-2021"}, {"company":"D회사", "position":"스타트업", "year":"2021-현재"}]',
      '닉네임' || i
    );
  END LOOP;
  COMMIT;
END;

