-- 2021. 03. 24. 수요일
-- 서브쿼리
-- CLARK의 급여보다 더 많은 급여를 받는 사원은?
SELECT sal FROM emp WHERE ename='CLARK'; -- 서브
SELECT ename, sal FROM emp WHERE sal>2450; -- 메인
SELECT ename, sal FROM emp WHERE sal>(SELECT sal FROM emp WHERE ename='CLARK');
-- ename이 KING인 사원과 같은 부서에서 근무하는 사원을 검색
SELECT ename, deptno FROM emp WHERE deptno=(SELECT deptno FROM emp WHERE ename='KING');
-- 10번 부서에서 일하는 사원 중 사원의 전체 평균급여보다 더 많은 급여를 받는 사원을 검색
SELECT ename, sal FROM emp WHERE deptno=10 AND sal>(SELECT AVG(sal) FROM emp);
-- job별 가장 적은 평균급여
SELECT job, MIN(AVG(sal)) FROM emp GROUP BY job; -- 오라클 가능, MySQL X...그룹함수 중첩이 안됨
SELECT AVG(sal) FROM emp GROUP BY job;
SELECT job, AVG(sal) 
  FROM emp 
  GROUP BY job 
  HAVING AVG(sal)=(
    SELECT MIN(asal) 
      FROM (SELECT AVG(sal) asal FROM emp GROUP BY job) s); -- 테이블이 리턴되는 서브쿼리는 반드시 Alias 지정
SELECT AVG(sal) asal FROM emp GROUP BY job ORDER BY asal LIMIT 1;
SELECT job, AVG(sal) asal FROM emp GROUP BY job ORDER BY asal LIMIT 1;
-- scott의 급여보다 더 많은 급여를 받는 사원을 검색 (테이블 Alias 사용)
SELECT sal FROM emp WHERE ename='SCOTT';
SELECT * FROM emp WHERE sal>(SELECT sal FROM emp WHERE ename='SCOTT');
SELECT * FROM emp a, (SELECT sal FROM emp WHERE ename='SCOTT') b
WHERE a.sal>b.sal;

-- 단일행(=, >, <, !=, <=, >=) 연산자 사용하는 서브쿼리
-- 직속상관이 KING인 사원의 이름과 급여를 검색 (사원의 MGR 번호가 KING의 사원번호와 일치)
SELECT empno FROM emp WHERE ename='KING';
SELECT ename, sal, mgr FROM emp WHERE mgr=(SELECT empno FROM emp WHERE ename='KING');
-- job이 사원 7369의 업무와 같고, 급여가 사원 7876보다 많은 사원을 검색
SELECT * FROM emp
  WHERE job=(SELECT job FROM emp WHERE empno=7369)
    AND sal>(SELECT sal FROM emp WHERE empno=7876);
-- 부서별 최소급여 중에서 20번 부서의 최소급여보다 더 큰 최소급여를 검색
SELECT MIN(sal) FROM emp WHERE deptno=20;
SELECT deptno, MIN(sal) FROM emp
  GROUP BY deptno
  HAVING MIN(sal)>(SELECT MIN(sal) FROM emp WHERE deptno=20);
  
 -- 서브쿼리 결과가 다중행이면 단일행 연산자 사용 못함
SELECT empno, ename FROM emp
  WHERE sal=(SELECT MIN(sal) FROM emp GROUP BY deptno); -- 에러
SELECT MIN(sal) FROM emp GROUP BY deptno; -- 결과가 여러 행
SELECT empno, ename FROM emp
  WHERE sal IN (SELECT MIN(sal) FROM emp GROUP BY deptno); -- 다중행 연산자 IN
/*
다중행 연산자 : IN, ANY, ALL, (EXISTS는?)
ANY - 메인쿼리의 비교조건이 서브쿼리 결과와 하나 이상만 일치하면 참이 됨
ALL - 메인쿼리의 비교조건이 서브쿼리 결과와 모든 값이 일치하면 참이 됨
IN - 여러 개 중에서 같은 값을 찾음

>ANY - 최소값보다 많음
<ANY - 최대값보다 적음

>ALL - 최소값보다 많음
<ALL - 최대값보다 적음
*/
-- 급여를 3000 이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원을 검색
SELECT DISTINCT deptno FROM emp WHERE sal>3000; -- 다중행일 수 있음, 중복도 있을 수 있음
SELECT ename, deptno FROM emp
  WHERE deptno IN (SELECT DISTINCT deptno FROM emp WHERE sal>3000);
-- 급여가 어떤 점원(CLERK)보다 작으면서 CLERK은 아닌 사원을 검색
SELECT sal FROM emp WHERE job='CLERK'; -- (800, 1100, 950, 1300)
SELECT ename, sal, job FROM emp
  WHERE sal<ANY(SELECT sal FROM emp WHERE job='CLERK') -- WHERE sal<1300
    AND job<>'CLERK'; -- <>는 !=와 같음
-- 급여가 모든 부서의 평균급여보다 많은 사원을 검색
SELECT AVG(sal) FROM emp GROUP BY deptno;
SELECT ename, sal FROM emp
  WHERE sal>ALL(SELECT AVG(sal) FROM emp GROUP BY deptno);
