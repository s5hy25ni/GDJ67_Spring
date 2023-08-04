package com.min.edu.bean2;

public class JobAddress {

	private EmployeeAddress addr;
	private String jobName;

	public JobAddress() {
		addr = new EmployeeAddress("고라파덕", "물", "10");
	}

	public JobAddress(EmployeeAddress addr, String jobName) {
		super();
		this.addr = addr;
		this.jobName = jobName;
	}

	@Override
	public String toString() {
		return "JobAddress [addr=" + addr + ", jobName=" + jobName + "]";
	}

}
