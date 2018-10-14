package cn.zx.test01;

//测试使用自定义注解
public class TestUserAnnotation {
	@MyAnno01(timeout = 100, c = java.util.Date.class, strs = { "aaa", "bbb" }, ma = @MyAnno02)
	public void test01() {
	}
}
