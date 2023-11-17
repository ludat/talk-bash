/*
 * Developed by 10Pines SRL
 * License: 
 * This work is licensed under the 
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License. 
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-sa/3.0/ 
 * or send a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, 
 * California, 94041, USA.
 *  
 */
package boole;

import junit.framework.TestCase;

public class BooleanoTest extends TestCase {

	//not
	public void testVerdaderoNotIsFalso () {
		assertEquals (Booleano.falso,Booleano.verdadero.not());
	}

	public void testFalsoNotIsVerdadero () {
		assertEquals (Booleano.verdadero,Booleano.falso.not());
	}
	
	//And
	public void testVerdaderoAndVerdaderoIsVerdadero () {
		assertEquals (Booleano.verdadero,Booleano.verdadero.and(Booleano.verdadero));
	}

	public void testVerdaderoAndFalsoIsFalso () {
		assertEquals (Booleano.falso,Booleano.verdadero.and(Booleano.falso));
	}

	public void testFalsoAndVerdaderoIsFalso () {
		assertEquals (Booleano.falso,Booleano.falso.and(Booleano.verdadero));
	}

	public void testFalsoAndFalsoIsFalso () {
		assertEquals (Booleano.falso,Booleano.falso.and(Booleano.falso));
	}

	//Or
	public void testVerdaderoOrVerdaderoIsVerdadero () {
		assertEquals (Booleano.verdadero,Booleano.verdadero.or(Booleano.verdadero));
	}

	public void testVerdaderoOrFalsoIsVerdadero () {
		assertEquals (Booleano.verdadero,Booleano.verdadero.or(Booleano.falso));
	}

	public void testFalsoOrVerdaderoIsVerdadero () {
		assertEquals (Booleano.verdadero,Booleano.falso.or(Booleano.verdadero));
	}

	public void testFalsoOrFalsoIsFalso () {
		assertEquals (Booleano.falso,Booleano.falso.or(Booleano.falso));
	}
	
	
}
