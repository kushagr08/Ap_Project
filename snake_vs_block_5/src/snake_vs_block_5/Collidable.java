package snake_vs_block_5;

import java.io.IOException;
/**
 * interface for collide method implemented by ball,block,coin,magnet, destroyblock and shield
 * 
 *
 */
public interface Collidable {
	/**
	 * 
	 * @param s Snake on the gamescreen
	 * @throws IOException methods throwing IOException are called from inside collide
	 * @throws ClassNotFoundException methods fro deserializing are called from inside collide
	 */
	public void collide(snake s)throws IOException, ClassNotFoundException;

}
