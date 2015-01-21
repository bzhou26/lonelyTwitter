package ca.ualberta.cs.lonelytwitter;


public abstract class User extends Object
{
	protected String name;

	
	public String getName()
	{
	
		return name;
	}

	
	public abstract void setName(String name);

	public User(String name)
	{

		super();
		this.name = name; //name=n;
	}
	
//	public void User(){
//		super();
//		name="anonymous";
//	}
//	
}
