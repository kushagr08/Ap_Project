/**
 * 
 */
package snake_vs_block_5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * class to save attributes of tokens/snake/score at every instance in an xml file.
 *
 */

public class SaveGameData {

	/**
	 * @throws IOException
	 * <p>starts saving the data</p>
	 */
	void startsave() throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter("savedata.xml"));
		writer.write("<game>");
		writer.close();
	}
	
	
	/**
	 * <p>method to save attributes of each object on the screen</p>
	 * @param item identifier for token/snake/score
	 * @param xpos xcoordinate of the object
	 * @param ypos ycoordinate of the object
	 * @param val  value of the object- 0 for cases where not required like wall etc.
	 * @throws IOException could be thrown 
	 */
	void savegame(int item, double xpos, double ypos, int val) throws IOException {
	BufferedWriter writer = new BufferedWriter(new FileWriter("savedata.xml",true));
	String tmpStr="<items>\n<item>" + item +"</item>\n<xpos>"+ xpos+ "</xpos>\n<ypos>"+ypos+"</ypos>\n<value>"+val+"</value></items>";
	writer.append(tmpStr);
	writer.close();
	}
	
	
	/**
	 * @throws IOException could be thrown
	 *<p> method to close the write stream</p>
	 */
	void endsave() throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter("savedata.xml",true));
		writer.append("</game>");
		writer.close();
	}
}
