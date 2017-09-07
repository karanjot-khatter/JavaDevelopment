import java.util.ArrayList;

public class Club
{
    private ArrayList<Membership> members;
    
    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
       members = new ArrayList<Membership>();
        
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
        members.add(member);
    }

     public int joinedMonth(int month)
    {
        int groupSize=0;
        for( Membership member : members){
            //compare months with months
            if( member.getMonth() == month) {
                groupSize= groupSize + 1;
            }
        }
     return groupSize;
}
   
public int numberOfMembers()
{
        return members.size();
}
    
public ArrayList purge(int month,int year)
{
       
}
}
