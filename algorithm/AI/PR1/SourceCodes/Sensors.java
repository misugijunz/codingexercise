/**
* @author
*    <b>Name: </b> Oscar Kurniawan Manule
*    <b>NPM: </b> 0706272080
* @version 1.0
* @date 22 September 2009
*/

/**
* Kelas <i>Sensors</i> akan mencatat apa yang ada di lingkungan
*/
public class Sensors
{
	private Environtment env;
	private Rectangle2D currentpos; //posisi awal dari agent
	private Rectangle2D prevpos; //posisi sebelumnya dari agent, awalnya null
	private boolean dirt_status_currentpos;
	
	/**
	* Constructor untuk menginisialisasi environment dimana agent berada
	* @param env Environment tempat agent berada
	*/
	public Sensors(Environtment env)
	{
		this.env = env;
		currentpos = Agent.INITIAL_POSITION;
		dirt_status_currentpos = env.getDirtStatus(currentpos);
	}
	
	/**
	* Method untuk mengetes kondisi kotak perpindahan
	* @param pos Posisi yang baru
	*/
	public void move(Rectangle2D pos)
	{
		prevpos = currentpos;
		currentpos = pos;
		dirt_status_currentpos = env.getDirtStatus(currentpos);
	}
	
	public getEnvironment()
	{
		return env;
	}

}