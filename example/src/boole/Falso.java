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

public class Falso extends Booleano {

	@Override
	public Booleano and(Booleano aBooleano) {
		return this;
	}

	@Override
	public Booleano not() {
		return Booleano.verdadero;
	}

	@Override
	public Booleano or(Booleano aBooleano) {
		return aBooleano;
	}

}
