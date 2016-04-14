package za.ac.cs.teambravo.publications.publications;

public interface Mock
{
	void setState(State state) throws InvalidStateException;

	State getState();
	
	interface State
	{
	}
	
	class InvalidStateException extends Exception
	{
	}

}