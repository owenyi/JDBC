-- 2021. 03. 23. 화요일
-- SQL은 문법순서와 실행순서가 다르다.
-- 부서별 평균 급여가 2000달러 이상인 부서 번호와 평균 급여
SELECT deptno, sal FROM emp;
SELECT deptno, AVG(sal) FROM emp;
SELECT deptno, AVG(sal)
  FROM emp
  WHERE AVG(sal) >= 2000; -- Error : 그룹 함수는 WHERE절에서 사용할 수 없음
SELECT deptno, AVG(sal)
  FROM emp
  GROUP BY deptno
  HAVING AVG(sal) >= 2000; -- HAVING절은 GROUP BY절 뒤에 와야한다.
SELECT deptno, AVG(sal)
  FROM emp
  WHERE deptno!=10
  GROUP BY deptno
  HAVING AVG(sal) >= 2000;
-- 최대 급여가 2900달러가 넘는 부서들의 최대급여를 출력
SELECT deptno, MAX(sal)
  FROM emp
  GROUP BY deptno
  HAVING MAX(sal) > 2900;