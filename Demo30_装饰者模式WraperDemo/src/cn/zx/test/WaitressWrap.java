package cn.zx.test;

public class WaitressWrap implements Waiter{
	
	Waiter watier  = null;
	public WaitressWrap(Waiter watier){
		this.watier = watier;
	}

	@Override
	public void service() {
		System.out.println("΢Ц:::");
		watier.service();
	}

}
