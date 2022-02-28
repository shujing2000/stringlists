package stringlists;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringListsTest {

	@Test
	void test() {
		String[] myStrings = {"Hello, ","world!"};
		StringLists myStringList = new StringLists(myStrings);
		
		//myStrings[0] = null; //geeft het 2e gevaar van REPRESENTATION EXPOSURE
		//assertEquals("Hello, world!", myStringList.getConcatenation());
		
		assertEquals("Hello, ", myStrings[0]);
		myStringList.set(0, "Bye, ");
		assertEquals("Hello, ", myStrings[0]); 
		//3e gevaar van representation exposure:
		//mutator oproepen op een abstractie kan gevolgen hebben 
		//voor andere objecten van de klant waarbij de klant niet door heeft
		//dat bv wijzigingen op myStringList object ook gevolgen heeft voor myStrings object
	
	}

}
