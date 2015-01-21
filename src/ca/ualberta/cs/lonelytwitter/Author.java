package ca.ualberta.cs.lonelytwitter;


public class Author extends User implements userlike
{
	public Author(String string){
		super(string);
		}

	@Override
	public void setName(String name)
	{

		this.name=name;// TODO Auto-generated method stub
		
	}

}
