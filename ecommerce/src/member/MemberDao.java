package member;

//DAO stands for Data Access Object. This interface will contain all the function prototypes of what we want to do with
//the database. 

public interface MemberDao {

	public String insert(MemberDto mdto);
	
}
