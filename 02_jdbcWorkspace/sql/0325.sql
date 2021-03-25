-- 2021. 03. 25. 목요일
-- JOIN
/*
하나 이상의(보통 둘 이상)의 테이블로부터 데이터를 가져오는 방법에 JOIN 기법이 사용된다.
SELECT * FROM emp; emp에 있는 사원의 정보를 받아온다.
SELECT * FROM dept; dept에 있는 부서의 정보를 받아온다.
*/
-- ######## 조건 없이 ########
SELECT * FROM emp, dept; -- Cartesian Product : 14 * 4 해서 56줄 나온다
/*
Cartesian Product : 발생 가능한 모든 경우의 수
1) 조인 조건을 잘못 줬거나
2) 조인 조건을 생략했거나
*/

-- ####### Equi JOIN, = 연산자를 사용하는 조인, 두 테이블의 공통적으로 연결된 컬럼을 = 표시) #######
-- 하나 이상의 테이블로부터 데이터를 질의하기 위해서 조인을 사용함
-- 하나 이상의 테이블에 똑같은 컬럼 이름이 있을 때 이런 컬럼이 바로 조인 조건이 되며 이 컬럼명 앞에 테이블을 지정한다.
SELECT * FROM emp, dept WHERE emp.deptno = dept.deptno;
-- 문제점 --> * 사용하지 말자. 노출되면 안 되는 정보들이 다 노출된다.
SELECT empno, ename, sal, deptno, dname, loc FROM emp, dept WHERE emp.deptno=dept.deptno; -- 테이블 alias는 간단하게 준다.
-- 그렇지만 이렇게 하면 에러가 난다 : deptno가 누구 건지를 모른다.
-- 에러가 안 난다 해도 테이블 전체에서 찾기 때문에 문제가 있다.
-- > 테이블 alias를 사용(아주 간단한 이름으로)하고 어떤 테이블의 컬럼인지를 써라!
SELECT e.empno, e.ename, e.sal, e.deptno, d.dname, d.loc FROM emp e, dept d WHERE e.deptno=d.deptno;
-- WHERE절에 조인 조건과 비조인 조건을 동시에 사용
-- 사원이름, 급여, 부서번호, 부서이름, 부서위치를 검색...단 급여가 2000 이상이고 30번 부서에 한해서만
SELECT e.ename, e.sal, e.deptno, d.dname, d.loc
  FROM emp, e, dept d
  WHERE e.deptno=d.deptno
    AND e.sal>2000
    AND d.dept=30;
-- 뉴욕에서 근무하는 사원의 이름과 급여를 검색
SELECT e.ename, e.sal FROM emp e, dept d
  WHERE e.deptno=d.deptno
    AND d.loc='NEW YORK';
-- SMITH의 상사의 이름을 검색
SELECT * FROM emp e1, emp e2; -- 16 x 16
SELECT m.ename FROM emp m, emp e
  WHERE m.empno=e.mgr
    AND e.ename='SMITH';
SELECT empno, ename, mgr FROM emp WHERE ename='SMITH';
SELECT empno, ename FROM emp;
