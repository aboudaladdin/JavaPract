 

public class TitanicPassenger
{
	private String pclass;
	private String survived;
	private String name;
	private String sex;
	private float age;
	private String siblings;
	private String parentchilds;
	private String ticketNo;
	private float fare;
	private String cabin;
	private String embarked;
	private String boat;
	private	String body;
	private String homeDest;
 
	public TitanicPassenger()
	{
		
	}
	public TitanicPassenger(String pclass, String survived, String name, String sex, String age, String siblings,
			String parentchilds, String ticketNo, String fare, String cabin, String embarked, String boat, String body,String homeDest)
	{
		this.pclass = pclass;
		this.survived = survived;
		this.name = name;
		this.sex = sex;
		this.age = Float.valueOf(age);
		this.siblings = siblings;
		this.parentchilds = parentchilds;
		this.ticketNo = ticketNo;
		this.fare = Float.valueOf(fare);
		this.cabin = cabin;
		this.embarked = embarked;
		this.boat = boat;
		this.body = body;
		this.homeDest = homeDest;
	}
	public String getPclass()
	{
		return pclass;
	}
	public String getSurvived()
	{
		return survived;
	}
	public String getName()
	{
		return name;
	}
	public String getSex()
	{
		return sex;
	}
	public float getAge()
	{
		return age;
	}
	public String getSiblings()
	{
		return siblings;
	}
	public String getParentchilds()
	{
		return parentchilds;
	}
	public String getTicketNo()
	{
		return ticketNo;
	}
	public float getFare()
	{
		return fare;
	}
	public String getCabin()
	{
		return cabin;
	}
	public String getEmbarked()
	{
		return embarked;
	}
	public String getBoat()
	{
		return boat;
	}
	public String getBody()
	{
		return body;
	}
	public String getHomeDest()
	{
		return homeDest;
	}
	public void setPclass(String pclass)
	{
		this.pclass = pclass;
	}
	public void setSurvived(String survived)
	{
		this.survived = survived;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public void setAge(float age)
	{
		this.age = age;
	}
	public void setSiblings(String siblings)
	{
		this.siblings = siblings;
	}
	public void setParentchilds(String parentchilds)
	{
		this.parentchilds = parentchilds;
	}
	public void setTicketNo(String ticketNo)
	{
		this.ticketNo = ticketNo;
	}
	public void setFare(float fare)
	{
		this.fare = fare;
	}
	public void setCabin(String cabin)
	{
		this.cabin = cabin;
	}
	public void setEmbarked(String embarked)
	{
		this.embarked = embarked;
	}
	public void setBoat(String boat)
	{
		this.boat = boat;
	}
	public void setBody(String body)
	{
		this.body = body;
	}
	public void setHomeDest(String homeDest)
	{
		this.homeDest = homeDest;
	}
	@Override
	public String toString()
	{
		return "TitanicPassenger [pclass=" + pclass + ", survived=" + survived + ", name=" + name + ", sex=" + sex
				+ ", age=" + age + ", siblings=" + siblings + ", parentchilds=" + parentchilds + ", ticketNo="
				+ ticketNo + ", fare=" + fare + ", cabin=" + cabin + ", embarked=" + embarked + ", boat=" + boat
				+ ", body=" + body + ", homeDest=" + homeDest + "]";
	}
	
}
