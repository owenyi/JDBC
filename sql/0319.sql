-- 2021 03 19

 -- emp 테이블에 있는 모든 데이터 검색하기
SELECT * FROM emp;

-- 사원 번호 10인 사원 디스플레이
SELECT * FROM emp WHERE DEPTNO = 10; -- Selection : 조건을 줘서 해당하는 row의 record만 디스플레이
-- 사원의 사원번호, 이름, 업무, 급여만 디스플레이
SELECT empno, ename, job, sal FROM emp; -- Projection : 원하는 컬럼만 디스플레이
-- 업무가 판매원인 직원의 이름, 업무, 상사번호 디스플레이
SELECT ename, job, mgr FROM emp WHERE job="SALESMAN"; -- Selection + Projection
-- 사원번호 7698인 사원의 이름, 사원번호, 업무 디스플레이
SELECT ename, empno, job FROM emp WHERE EMPNO=7698;

-- 정렬, 중복 제거, 개수 제한
SELECT deptno FROM emp;
SELECT DISTINCT(deptno) FROM emp; -- 중복 제거
SELECT DISTINCT(deptno) FROM emp ORDER BY deptno; -- 정렬(default : ASC)
SELECT DISTINCT(deptno) FROM emp ORDER BY deptno ASC;
SELECT DISTINCT(deptno) FROM emp ORDER BY deptno DESC; -- 역순
SELECT DISTINCT(job) FROM emp;
SELECT DISTINCT(job) FROM emp ORDER BY job; -- 문자도 정렬 가능
SELECT ename, hiredate FROM emp ORDER BY hiredate; -- 날짜도 정렬 가능
SELECT ename, comm FROM emp ORDER BY comm; -- null 값은 MySQL에서 가장 작은 값 취급 oracle은 큰 값 취급
SELECT ename, hiredate FROM emp ORDER BY hiredate DESC LIMIT 2; -- 개수 재한

-- null 값은 연산, 비교, 할당 자체가 불가능한 값이다.
SELECT ename, comm FROM emp WHERE comm=null;
SELECT ename, comm FROM emp WHERE comm is null;
SELECT ename, comm FROM emp WHERE comm is not null;
SELECT ename, sal, sal*12+comm, deptno FROM emp; -- comm이 null인 row에 문제가 생김
SELECT ename, sal, sal*12+IFNULL(comm, 0) AS AnnualSalary, deptno FROM emp; -- Alias 1
SELECT ename, sal, sal*12+IFNULL(comm, 0) AnnualSalary, deptno FROM emp; -- Alias 2 주로 이렇게 씀
SELECT ename, sal, sal*12+IFNULL(comm, 0) "Annual Salary", deptno FROM emp;
SELECT ename, sal, sal*12+IFNULL(comm, 0) AnnualSalary, deptno FROM emp ORDER BY AnnualSalary; -- Alias로 정렬

-- LIKE
-- 2번째 이름이 A로 시작하는 직원
SELECT ename FROM emp WHERE ename LIKE "_A%";
-- 이름이 R로 끝나는 직원
SELECT ename FROM emp WHERE ename LIKE "%R";
-- 81년도에 입사한 직원
SELECT ename, hiredate FROM emp WHERE hiredate LIKE "1981%";

-- IN
-- 지정된 상사번호인 tuple만
SELECT empno, ename, mgr FROM emp WHERE mgr=7902 OR mgr=7566 OR mgr=7788;
SELECT empno, ename, mgr FROM emp WHERE mgr IN (7902, 7566, 7788);
-- 반대
SELECT empno, ename, mgr FROM emp WHERE mgr!=7902 AND mgr!=7566 AND mgr!=7788;
SELECT empno, ename, mgr FROM emp WHERE mgr NOT IN (7902, 7566, 7788);