package dto;

public class J0803_1_dto {
	String empno, ename, job, dname;
	int sal;
	public J0803_1_dto(String empno, String ename, String job, String dname, int sal) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.dname = dname;
		this.sal = sal;
	}
	public String getEmpno() {
		return empno;
	}
	public String getEname() {
		return ename;
	}
	public String getJob() {
		return job;
	}
	public String getDname() {
		return dname;
	}
	public int getSal() {
		return sal;
	}
	

}
