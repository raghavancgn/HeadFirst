package HeadFirst;
class base1
{
	final public void Fun()
	{
		System.out.println("In the final method..");
	}
}

class derived extends base1
{
	public void Fun()
	{
		System.out.println("In the final method");
	}
}
public class FinalDemo {
	public static void main(String[] args) {
		derived d = new derived();
		d.Fun();
	}
}