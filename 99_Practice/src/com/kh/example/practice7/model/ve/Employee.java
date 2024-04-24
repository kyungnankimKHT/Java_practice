package com.kh.example.practice7.model.ve;

public class Employee {
	//필드
	public int empNo;
	public String empName;
	public String dept;
	public String job;
	public int age;
	public char gender;
	public int salary;
	public double bonusPoint;
	public String phone;
	public String address;
	
	//생성자
	public Employee() {
		
	}
	//번호와 이름을 필수로 추가 번호와 이름이외에 나머지는 필수가 아님
	public Employee(int empNo, String empName) {
		this.empNo = empNo;
		this.empName = empName;
	}
	public Employee(int empNo,String empName,String dept,String job,
					int age,char gender,int salary,double bonusPoint,
					String phone,String address) {
		this.empNo = empNo;
		this.empName = empName;
		this.dept = dept;
		this.job = job;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
		this.bonusPoint = bonusPoint;
		this.phone = phone;
		this.address = address;
		
	}


}









