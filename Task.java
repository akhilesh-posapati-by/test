import java.util.*;

class Event{
	String component;
	String service;
	String status;
	Event(String component,String service,String status)
	{
		this.component=component;
		this.service= service;
		this.status=status;
	}
}
public class Task {
	List<Event> rule;
	Task(List<Event> rule)
	{
		this.rule=rule;
	}
	void add_rule(Event rule2)
	{
		rule.add(rule2);
	}
	boolean matching(Event payload)
	{   
		boolean match =false;
		if(rule.size()==0)
		{
			match = true;
			return match;
		}
		for(Event r:rule)
		{
			if(r.status=="ALL") {}
			else if( r.status==payload.status) 
			{
				  match=true;
			}
			else match = false;
			
			if(r.component=="ALL") {} 
			else if(r.component==payload.component ) 
			{
				match=true;
			}
			else match=false;
			
			if(r.service=="ALL") {} 
			else if (r.service==payload.service) 
			{
				  match=true;
			}
			else match = false;
			
			if(match) return match;
			
		}
		return false;
		
	}

    public static void main(String[] args)
    {   
    	List<Event> L= new ArrayList<Event>();
    	L.add(new Event("ALL","ALL","completed with error"));
    	L.add(new Event("ALL","ALL","ALL"));
    	
    	Task t = new Task(L);
    	
    	Event payload = new Event("dataprocessor","curated","completed with error");
    	
    	if(t.matching(payload))
    	{
    		System.out.println("Rule is found");
    	}
    	else System.out.println("Rule is not found");

    }
}
