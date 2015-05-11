/**
* @author
*    <b>Name: </b> Oscar Kurniawan Manule
*    <b>NPM: </b> 0706272080
* @version 1.0
* @date 23 September 2009
*/

/**
* Kelas <i>Actuators</i> akan menentukan langkah yang diambil di lingkungan berdasarkan info yang ada di sensors
*/
public class Actuators
{
	private Sensors sensor;
	private Environment env;
	private Rectangle2D currentpos; //posisi awal dari agent
	private Rectangle2D prevpos; //posisi sebelumnya dari agent, awalnya null
	private boolean dirt_status_currentpos;
	
	/**
	* Constructor untuk menginisialisasi environment dimana agent berada
	* @param env Environment tempat agent berada
	*/
	public Actuators(Sensors sensor)
	{
		this.sensor = sensor;
		env = sensor.getEnvironment();
	}
	
	/**
	* Method untuk membersihkan lantai yang kotor
	* @param pos Posisi yang baru
	*/
	public void suck(Rectangle2D pos)
	{
		env.changeDirtStatus(pos, false);
	}
	
	/**
	* Method untuk berpindah ke kiri
	* @param pos Posisi yang baru
	*/
	public void left(Rectangle2D pos)
	{
		Rectangle rect = new Rectangle( (int)(pos.getX()-pos.getWidth()),(int)pos.getY());
		sensor.move(rect);
	}
	
	/**
	* Method untuk berpindah ke kanan
	* @param pos Posisi yang baru
	*/
	public void right(Rectangle2D pos)
	{
		Rectangle rect = new Rectangle( (int)(pos.getX()+pos.getWidth()),(int)pos.getY());
		sensor.move(rect);
	}
	
	/**
	* Method untuk berpindah ke atas
	* @param pos Posisi yang baru
	*/
	public void up(Rectangle2D pos)
	{
		//not implemented
	}
	
	/**
	* Method untuk berpindah ke bawah
	* @param pos Posisi yang baru
	*/
	public void down(Rectangle2D pos)
	{
		//not implemented
	}
	

}