package objects;

import java.util.*;

public interface BTTU extends CTX, CTH, GDS {
	
	public HashMap<Person, String> searchPerson();
	public HashMap<Person, String> searchPerson(Person similar);
	public HashMap<Person, String> searchPerson(Person similar, Address addr);
	public HashMap<Person, String> searchPerson(Person similar, byte min_age);
	public HashMap<Person, String> searchPerson(Person similar, String similar_name);
	public HashMap<Person, String> searchPerson(byte min_age, byte max_age);	

}
