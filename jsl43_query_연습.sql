/*���ϴ� ����� ã��*/
select a.empno, a.ename, a.job,a.deptno, b.dname
from emp a, dept b
where a.deptno = b.deptno;


/*�̸��� 'ALLEN'�� ����� �μ� �̸� ã��*/
select b.dname
from emp a, dept b
where a.deptno = b.deptno
and a.ename = 'ALLEN';  /*��ҹ��� ������*/
/*���� ���İ� ����*/
select b.dname
from emp a, dept b
where a.deptno = b.deptno
and a.ename = (SELECT ename FROM emp WHERE ename ='ALLEN');


/*'ALLEN'�� �μ��� ���� ����� �̸�, �μ��̸�, �޿�, �μ���ġ ã��*/
select a.ename, b.dname, a.sal, b.loc
from emp a, dept b
where a.deptno = b.deptno 
and a.deptno =(select deptno from emp where ename = 'ALLEN') ;
/*(select deptno from emp where ename = 'ALLEN') = 30*/

/*������ manager�� saleman�� ����� ��� ���� ã��*/
select * from emp
where deptno = (select deptno from emp where ename = 'ALLEN')
and job = 'MANAGER' or job = 'SALESMAN';

/*�̸��� ó���� ���ڴ� ������� �ι��� ���ڰ� A�� ����� ��� ����*/
select * from emp
where ename like '_A%';
