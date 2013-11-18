package relationshipsjje.model;


public class Relationship {
	
	private int IDPerson1;
	private int IDPerson2;
	private int IDRelationType;
	
	public Relationship(int IDPerson1, int IDPerson2, int IDRelationType)
	{
		this.IDPerson1 = IDPerson1;
		this.IDPerson2 = IDPerson2;
		this.IDRelationType = IDRelationType;
	}
	
	@Override
	public String toString()
	{
		return super.toString();
	}
	
}
