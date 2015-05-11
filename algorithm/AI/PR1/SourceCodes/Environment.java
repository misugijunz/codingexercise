/**
* @author
*    <b>Name: </b> Oscar Kurniawan Manule
*    <b>NPM: </b> 0706272080
* @version 1.0
* @date 22 September 2009
*/

/**
* Kelas ini adalah representasi yang mewakili karakteristik dari <i>Environment</i>
*/
public class Environtment
{
	private Shape shp; //shape yang akan dibangun
	HashMap<Rectangle2D,Boolean> dirt_placement = new HashMap<Rectangle2D,Boolean>();//dirt placement; false == clean; true == dirty
	
	/**
	* Constructor non argument ini untuk menginisialisasi <i>shape</i> dari <i>environtment</i>
	*/
	public Environtment()
	{
		shp = new Area();
	}
	
	/**
	* Constructor non argument ini untuk menginisialisasi <i>shape</i> dari <i>environtment</i>
	* @param s menyatakan bentuk spesifik dari suatu area <i>environment</i> misalkan <i>Rectangle</i>
	*/
	public Environtment(Shape s)
	{
		shp = new Area(s);
	}
	
	/**
	* Method ini untuk menambahkan suatu kotak ke dalam area
	* @param rect kotak yang akan ditambahkan
	* @param dirt_status apakah kotak tersebut awalnya kotor atau tidak
	*/
	public void addRectangleArea(Rectangle rect, Boolean dirt_status)
	{
		if (!shp.contains(rect))
		{
			shp.add(new Area(rect));
			dirt_placement.put(rect, dirt_status);
		}
	}
	
	/**
	* Method ini untuk us suatu area kotak di dalam area
	* @param rect area kotak yang akan dihapus dari area utama
	*/
	public void removeRectangleArea(Rectangle rect)
	{
		if (!shp.contains(rect))
		{
			shp.subtract(new Area(rect));
		}
	}
	
	/**
	* Method ini untuk merubah status kotor suatu kotak di dalam area
	* @param rect kotak yang akan diubah
	* @param dirt_status status baru kotak yang akan diaplikasikan
	* @return true jika berhasil diganti, false jika tidak berhasil atau tidak ditemukan kotak yang akan diubah
	*/
	public boolean changeDirtStatus(Rectangle rect, Boolean dirt_status)
	{
		if (dirt_placement.containsKey(rect))
		{
			dirt_placement.remove(rect);
			dirt_placement.put(rect, dirt_status);//replace dengan status yang baru
			
			return true;
		}
		
		return false;
		
	}
	
	/**
	* Method ini untuk mengecek apakah suatu area kotak dalam area besar ini kotor apa tidak, 
	* 	diasumsikan kotak yang akan dites ada di dalam area besar
	* @param rect kotak yang akan dites
	* @return apakah kotak tersebut dirty (true) atau  clean (false)
	*/
	public boolean isDirtyRectangle(Rectangle rect)
	{
		dirt_placement.get(rect);
	}
	
	/**
	* Method ini untuk mengetes apakah areanya diisi oleh suatu <i>shape</i> atau tidak
	* @return true jika berhasil diganti, false jika tidak berhasil atau tidak ditemukan kotak yang akan diubah
	*/
	public boolean isAreaEmpty()
	{
		return shp.isEmpty();
	}
	
	/**
	* Method ini untuk mereset suatu area ke keadaan semula
	*/
	public void resetArea()
	{
		shp.reset();
	}

}