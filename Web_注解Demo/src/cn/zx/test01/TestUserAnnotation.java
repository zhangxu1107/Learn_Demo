package cn.zx.test01;

//����ʹ���Զ���ע��
public class TestUserAnnotation {
	@MyAnno01(timeout = 100, c = java.util.Date.class, strs = { "aaa", "bbb" }, ma = @MyAnno02)
	public void test01() {
	}
}
