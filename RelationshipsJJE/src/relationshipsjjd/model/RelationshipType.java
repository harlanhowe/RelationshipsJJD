package relationshipsjjd.model;


public class RelationshipType {
	
	private String relationshipName;
	private String maleType;
	private String femaleType;
	private String maleInverse;
	private String femaeInverse;
	
	/**
	 * Sets up a relationship type
	 * @param relationshipName
	 * @param maleType
	 * @param femaleType
	 * @param maleInverse
	 * @param femaleInverse
	 */
	public RelationshipType(String relationshipName, String maleType, String femaleType, String maleInverse, String femaleInverse)
	{
		this.relationshipName = relationshipName;
		this.maleType = maleType;
		this.femaleType = femaleType;
		this.maleInverse = maleInverse;
		this.femaeInverse = femaleInverse;
	}
	
}
