package cn.zx.ö��2;

public enum Week2 {
	MON("����һ"),TUE("���ڶ�"),WED("������");
	
	private String name;
	private Week2(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}
}
