/*원하는 결과값 찾기*/
select a.empno, a.ename, a.job,a.deptno, b.dname
from emp a, dept b
where a.deptno = b.deptno;


/*이름이 'ALLEN'인 사원의 부서 이름 찾기*/
select b.dname
from emp a, dept b
where a.deptno = b.deptno
and a.ename = 'ALLEN';  /*대소문자 구분함*/
/*위의 공식과 같음*/
select b.dname
from emp a, dept b
where a.deptno = b.deptno
and a.ename = (SELECT ename FROM emp WHERE ename ='ALLEN');


/*'ALLEN'과 부서가 같은 사원의 이름, 부서이름, 급여, 부서위치 찾기*/
select a.ename, b.dname, a.sal, b.loc
from emp a, dept b
where a.deptno = b.deptno 
and a.deptno =(select deptno from emp where ename = 'ALLEN') ;
/*(select deptno from emp where ename = 'ALLEN') = 30*/

/*직업이 manager와 saleman인 사원의 모든 정보 찾기*/
select * from emp
where deptno = (select deptno from emp where ename = 'ALLEN')
and job = 'MANAGER' or job = 'SALESMAN';

/*이름이 처음의 글자는 관계없고 두번재 글자가 A인 사원의 모든 정보*/
select * from emp
where ename like '_A%';
