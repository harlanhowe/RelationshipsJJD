package relationshipsjjd.model;


public class RelationshipType {
	
	private String relationshipName;
	private String maleType;
	private String femaleType;
	private String maleInverse;
	private String femaleInverse;
	
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
		this.femaleInverse = femaleInverse;
	}
	
	public String getRelationshipName()
	{
		return relationshipName;
	}
	
	public String getNameForPerson(boolean isMale)
	{
		if(isMale)
			return maleType;
		return femaleType;
	}
	
	public String getNameForInverse(boolean isMale)
	{
		if(isMale)
			return maleInverse;
		return femaleInverse;
	}
	
}
