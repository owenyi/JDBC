-- 2020. 03. 22. 월요일
/*
MySQL 함수
1. 문자 관련 함수
2. 날짜 관련 함수
3. 숫자 관련 함수
4. 분석 함수
*/

-- 1. 문자 관련 함수
-- CONCAT('문자열1', '문자열2') : 문자열(혹은 컬럼)들을 연결하는 함수
SELECT CONCAT(ename, ' is a ', job) AS "emp's Information" FROM emp;
SELECT CONCAT(ename, ' is a ', job) "emp's Information" FROM emp;
SELECT CONCAT('Good', 'Morning') "Morning Greeting"; -- Oracle에는 dual이 필요하지만 MySQL은 그냥 가능하다.
-- INSERT('문자열', 시작위치, 길이, '새로운 문자열') : 문자열의 시작부터 길이만큼 새로운 문자열로 대치
SELECT INSERT(job, 6, 6, 'PERSON') FROM emp WHERE job='SALESMAN';
-- INSTR('문자열', '찾는 문자열') : index string, 찾는 문자열의 인덱스
SELECT DISTINCT INSTR(job, 'A') FROM emp WHERE job='SALESMAN';
-- SUBSTR('문자열', 시작위치, 개수) : 문자열 중에서 부분을 추출하는 기능
SELECT ename, SUBSTR(job, 1, 5) FROM emp WHERE job='SALESMAN';
-- SUBSTR() 사용해서 MAN으로 끝나는 업무를 가진 직원들의 이름과 업무를 출력 / LIKE로도 해보기
SELECT ename, job FROM emp WHERE SUBSTR(job, -3, 3)='MAN';
SELECT ename, job FROM emp WHERE job LIKE '%MAN';

-- 2. 날짜 관련 함수
-- YEAR(DATE), MONTH(DATE), DAY(DATE)
-- SUBSTR() 사용해서 직원들의 이름과 입사년, 월, 일 출력
SELECT ename, SUBSTR(hiredate, 1, 4) 'year', SUBSTR(hiredate, 6, 2) 'month', SUBSTR(hiredate, 9, 2) 'day' FROM emp;
SELECT ename, YEAR(hiredate) 'year', MONTH(hiredate) 'month', DAY(hiredate) 'day' FROM emp; -- 날짜 함수 사용
-- 현재 연월일시각 : NOW(), SYSDATE()
SELECT NOW();
SELECT SYSDATE();
-- 현재 연월일 : CURDATE(), CURRENT_DATE()
SELECT CURDATE();
SELECT CURRENT_DATE();
-- 현재 시각 : CURTIME(), CURRENT_TIME()
SELECT CURTIME();
SELECT CURRENT_TIME();
-- 날짜 - 날짜 = 일수
-- 날짜 +- 숫자 = 날짜
SELECT DATE_ADD(CURDATE(), INTERVAL 100 DAY); -- 오늘 사귄 연인의 100일을 구하시오.
SELECT DATEDIFF(CURDATE(), '1995-12-05'); -- 내가 며칠 살았는지, '1995-12-05'는 암시적 형변환
SELECT DATEDIFF(CURDATE(), STR_TO_DATE('1995-12-05', '%Y-%m-%d')); -- 명시적 형변환
SELECT ename, job, ROUND(DATEDIFF(CURDATE(), hiredate)/7) 근무주수 FROM emp WHERE job='MANAGER'; -- MANAGER 오늘까지 근무한 주 수
SELECT ename, IFNULL(mgr, '없음') CEO FROM emp WHERE ename='KING'; -- 상사가 없는 사원의 mgr 컬럼 값을 '없음'으로 치환해서 검색...Alias CEO
SELECT ename, IFNULL(CONVERT(mgr, CHAR), '없음') CEO FROM emp WHERE ename='KING'; -- 자료형 맞추기

-- 3. 숫자 관련 함수
-- 절대값 : ABS(숫자)
SELECT ABS(-10.54321);
-- 올림 : CEILING(숫자)
SELECT CEILING(-10.54321);
-- 내림 : FLOOR(숫자)
SELECT FLOOR(-10.54321);
-- 반올림 : ROUND(숫자, 자릿수)
-- 버림 : TRUNCATE(숫자, 자릿수)
SELECT ROUND(-10.54321, 3); -- 3번째자리"까지"
SELECT TRUNCATE(-10.54321, 3);
SELECT ROUND(-10.54321, 0);
SELECT ROUND(-10.54321); -- default
SELECT TRUNCATE(-10.54321, 0);
SELECT TRUNCATE(-10.54321); -- default 없음
SELECT ROUND(-10.54321, -1);
SELECT TRUNCATE(-10.54321, -1);
-- 나머지 : MOD(나눌 숫자, 나누는 숫자)
SELECT ename, empno FROM emp WHERE MOD(empno, 2)=1; -- 사원번호 홀수인 사원의 이름과 사원 번호
SELECT ename, job, sal, comm, MOD(sal, comm) "나머지" FROM emp WHERE job='SALESMAN'; -- job이 SALESMAN인 모든 사원에 대해 보너스로 급여를 나눈 나머지를 검색
-- 빼기
SELECT sal FROM emp WHERE ename='KING';
SELECT sal FROM emp WHERE ename='SCOTT';
SELECT ABS((SELECT sal FROM emp WHERE ename='KING')-(SELECT sal FROM emp WHERE ename='SCOTT')) AS '급여차이';
-- 최대값 : GREATEST(숫자1, 숫자2, ...)
SELECT GREATEST(1, 2, 3);
-- 최소값 : LEAST(숫자1, 숫자2, ...)
SELECT LEAST(1, 2, 3);

-- 4. 분석 함수
/*
그룹 함수(집계 함수?) : COUNT, MAX, MIN, AVG, SUM
- 숫자 데이터에만 적용되는 건 SUM과 AVG
- NULL값은 건너뛰고 계산함
*/
-- MIN(), MAX() 
SELECT MIN(hiredate), MAX(hiredate) FROM emp; -- 가장 오래된 사원, 가장 신규인 사원의 hiredate
SELECT SUM(sal) AS '급여의 총합' FROM emp; -- 모든 사원의 급여의 총합
-- COUNT() : 테이블 행의 수를 리턴
SELECT COUNT(*) FROM emp; -- 모든 행의 개수
SELECT COUNT(-1) FROM emp; -- 모든 행의 개수, 성능이 더 좋음???검색해보면 안나옴???
SELECT COUNT(empno) FROM emp; -- empno(NOT NULL) 컬럼에 해당하는 행의 수를 리턴
SELECT COUNT(job) FROM emp;
SELECT COUNT(DISTINCT job) FROM emp;
SELECT COUNT(deptno) FROM emp WHERE deptno IN (10, 20); -- 부서 번호가 10 or 20인 사원의 인원수
SELECT COUNT(deptno) FROM emp WHERE deptno=10 OR deptno=20;
-- AVG(), SUM()
SELECT ROUND(AVG(sal), 2) FROM emp; -- 모든 사원들의 평균 급여...소수점 둘째자리까지 반올림
SELECT ROUND(AVG(IFNULL(comm, 0))) FROM emp;-- 모든 사원들의 보너스 평균, NULL값 처리 중요
-- 그룹함수에 적용되지 않는 컬럼(deptno)이 SELECT 절에 나열되면 안된다.
-- 그룹함수에 적용되지 않는 컬럼은 GROUP BY절 뒤에 명시되어야한다...그룹을 세분화
SELECT AVG(sal) FROM emp;
SELECT deptno, AVG(sal) FROM emp;
SELECT deptno, AVG(sal) FROM emp GROUP BY deptno;
SELECT deptno, AVG(sal) FROM emp GROUP BY deptno ORDER BY deptno;
SELECT deptno Dname, AVG(sal) FROM emp GROUP BY deptno ORDER BY deptno;
SELECT deptno Dname, AVG(sal) FROM emp GROUP BY Dname ORDER BY Dname; -- Alias로도 됨
SELECT deptno, AVG(sal) -- 순서 기억하기
  FROM emp 
  WHERE deptno!=20 -- FROM다음 WHERE
  GROUP BY deptno 
  ORDER BY deptno; -- 가장 마지막은 ORDER BY
SELECT YEAR(hiredate) 입사년도, COUNT(deptno) 인원수 -- 입사년도별 사원의 인원수를 출력 AS 인원수
  FROM emp
  GROUP BY YEAR(hiredate)
  ORDER BY YEAR(hiredate);
SELECT YEAR(hiredate) 입사년도, COUNT(deptno) 인원수 -- Alias로
  FROM emp
  GROUP BY 입사년도
  ORDER BY 입사년도;
SELECT DATE_FORMAT(hiredate, '%Y') 입사년도, COUNT(deptno) 인원수 -- DATE_FORMAT(DATE, Y OR m or d)
  FROM emp
  GROUP BY 입사년도
  ORDER BY 입사년도;
