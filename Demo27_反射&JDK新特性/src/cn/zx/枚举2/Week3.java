package cn.zx.ö��2;

public enum Week3 {
	MON("����һ"){
		public void show() {
			System.out.println("����һ");
		}
	},TUE("���ڶ�"){
		public void show() {
			System.out.println("���ڶ�");
		}
	},WED("������"){
		public void show() {
			System.out.println("������");
		}
	};
	
	private String name;
	private Week3(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public abstract void show();
	
}
