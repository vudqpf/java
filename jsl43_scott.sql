select a.ename, a.hiredate, b.dname
From emp a, dept b
where a.deptno = b.deptno
and a.empno='7499';

select *
from emp
where job = 'MANAGER' or job = 'SALESMAN'
/*where job in ('BANAGER', 'SALESMAN')*/
;

SELECT empno, ename, hiredate, deptno
from emp
where ename like 'S%'
;

SELECT*
FROM emp
where ename like '_A%'
;

SELECT a.deptno, b.dname, a.ename, a.sal
FROM emp a, dept b
where a.deptno = b.deptno
;

SELECT b.dname
FROM emp a, dept b
where a.deptno = b.deptno
and a.ename = 'ALLEN'
;

SELECT a.ename, b.dname, a.sal, b.loc
FROM emp a, dept b
where a.deptno = b.deptno
and a.job = (SELECT job FROM emp WHERE ename = 'AllEN')
;

SELECT a.deptno, a.ename, b.dname, a.hiredate, b.loc
FROM emp a, dept b
where a.deptno = b.deptno
and a.job in (select job from emp where deptno='20')
;
/*'='하나의 값을 원할 때 사용, 'in'은 하나이상의 값을 원할 때*/
