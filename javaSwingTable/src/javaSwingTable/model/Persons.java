package javaSwingTable.model;

public class Persons {
	private String fio;
	private String phone;
	
	public Persons() {
		this.fio = "";
		this.phone = "";
	}
	
	public Persons(String fio, String phoneNumber) {
		this.fio = fio;
		this.phone = phoneNumber;
	}
	
	public String getFIO() { return this.fio; }
	public void setFIO(String fio) { this.fio = fio; }
	
	public String getPhone() { return this.phone; }
	public void setPhone(String phoneNumber) { this.phone = phoneNumber; }
	
	/*@Override
	public String toString() {
		return "Person: FIO = " + this.fio + ", Pnone number = " + this.phone;
	}*/
}
