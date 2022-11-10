package objects;

import java.util.ArrayList;

public class Cat extends Animal {

	@Override
	public ArrayList<String> getInfo() {
		// TODO Auto-generated method stub
		ArrayList<String> tmp = new ArrayList<>();
		
		tmp.add("Cat");
		tmp.add("Tiger");
		tmp.add("Lion");
		
		return tmp;
	}

}
