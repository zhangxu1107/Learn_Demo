package cn.zx.ö��;

public abstract class Week3 {
	
	public static final Week3 MON = new Week3("����һ") {
		public void show() {
			System.out.println("����һ");
		}
	};
	public static final Week3 TUE = new Week3("���ڶ�"){
		public void show() {
			System.out.println("���ڶ�");
		}
	};
	public static final Week3 WED = new Week3("������"){
		public void show() {
			System.out.println("������");
		}
	};
	
	private String name;
	private Week3(String name){
		this.name = name;
	}						//˽�й���,���������ഴ���������
	public String getName() {
		return name;
	}
	
	public abstract void show();
}
