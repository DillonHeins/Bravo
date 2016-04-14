package za.ac.cs.teambravo.publications.publications;

public class BaseMock implements Mock 
{

	public BaseMock() 
	{
	}

	public State getState()
	{
		return state;
	}

	public void setState(State state)
	{
		this.state = state;
	}

	private State state;

}