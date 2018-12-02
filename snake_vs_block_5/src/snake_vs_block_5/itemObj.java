package snake_vs_block_5;


//this class is used to store the object to pass the values to main.java


/**
 *
 *<p>blueprint of the object being seriaized and deserialized from savedata.xml</p>
 *<p>4 attributes item,xpos,ypos,value</p>
 */
public class itemObj {

	private String item;
    private String xpos;
    private String ypos;
    private String value; 

    /**
     * @param item token/snake/score
     * @param xpos xcoordinate
     * @param ypos ycoordinate
     * @param value value of the item
     */
    public itemObj(String item, String xpos, String ypos, String value){
        this.item = item;
        this.xpos =xpos;
        this.ypos = ypos;
        this.value = value;
    }

	
    /**
     * @return item
     */
    public String getItem() {
		return item;
	}

	/**
	 * @param item token/snake/score
	 */
	public void setItem(String item) {
		this.item = item;
	}

	/**
	 * @return xpos 
	 */
	public String getXpos() {
		return xpos;
	}

	/**
	 * @param xpos xcoordinate
	 */
	public void setXpos(String xpos) {
		this.xpos = xpos;
	}

	/**
	 * @return ypos 
	 */
	public String getYpos() {
		return ypos;
	}

	/**
	 * @param ypos ycoordinate
	 */
	public void setYpos(String ypos) {
		this.ypos = ypos;
	}

	/**
	 * @return value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value value of the item
	 */
	public void setValue(String value) {
		this.value = value;
	}
}

