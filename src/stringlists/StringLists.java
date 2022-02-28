package stringlists;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 
 *Each instance of this class stores a list of strings.
 *
 */
// mutable klasse: je kunt de elementen instellen

public class StringLists {
	
	/**
	 * 
	 * @invar | elements != null
	 * @invar | Arrays.stream(elements).allMatch(e -> e != null) // elementen van elements mogen niet nul zijn
	 * @representationObject
	 */
	private String[] elements;
	
	/**
	 * 
	 * @create | result
	 * //als een inspector een nieuw object teruggeeft dan moeten we create gebruiken 
	 */
	
	//public String[] toArray() {return elements;} // REPRESENTATION EXPOSURE
	public String[] toArray() {return elements.clone();}
	
	/**
	 * geen documentatie, te complex
	 * 
	 */
	
	public String getConcatenation() {
		String result = "";
		for (String element: elements) //lus waarmee je beknopt kunt itereren over een array
									   //voer de body van de lus uit voor elke element 'element' van de array 'elements' 
			result = result.concat(element); //element achter result plakken
		return result;		
	}
	
	/**
	 * @pre | elements != null
	 * @throws IllegalArgumentException | Arrays.stream(elements).allMatch(e -> e != null)
	 * 
	 * @post | Arrays.equals(toArray(), elements)
	 * //toArray is zelfde array als wat we meegeven (qua inhoud en niet identiteit)
	 */
	
	//constructor
	public StringLists(String[] elements) {
		if (!Arrays.stream(elements).allMatch(e -> e != null))
			throw new IllegalArgumentException();
		//this.elements = elements;// REPRESENTATION EXPOSURE X2: 2e en 3e gevaar
		this.elements = elements.clone();
	}
	
	/**
	 * Sets the element at the given index to the given value.
	 * @pre | 0 <= index && index < toArray().length
	 * @throws IllegalArgumentException | value != null
	 * 
	 * @post | toArray().length == old(toArray().length)
	 * @post | toArray()[index] == value
	 * // dit: "@post | IntStream.range(0, toArray().length).allMatch(i -> toArray()[i] == old(toArray())[i])" geeft fout om één of andere manier
	 * @post | IntStream.range(0, toArray().length).allMatch(i -> i == index || toArray()[i] == old(toArray())[i]) // dit is dan wel just
	 * 
	 * //opm: allMatch(i -> toArray()[i] == old(toArray()[i]) mag je niet schrijven
	 * // want i bestaat niet in de pre toestand, enkel in de post toestand
	 * // in de pre-state alleen toArray() en in de post-state indexeer je erop
	 * 
	 * @mutates | this //dankzij dit mag je this wijzigen en alle representation objects van this
	 */
	public void set(int index, String value) {
		if (value == null)
			throw new IllegalArgumentException();
		elements[index] = value;
	}

}
