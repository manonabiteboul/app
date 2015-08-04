import java.awt.Color;
import java.util.ArrayList;


public class Activite {

	String name;
	Color c;
	int increment=0;
	public Activite(){
		//System.out.println("On a une activit");
	}
	
	public Activite(String cname,Color col){
		//System.out.println("Nous avons cree une activite avec pour nom "+cname+ " et pour couleur "+col);
		name = cname;
		c= col;
		
	}
	
	public String getName(){
		return name;
	}
	public void setName(String n){
		name = n;
	}
	
	public Color getColor(){
		return c;
	}
	public void setColor(Color col){
		c=col;
	}
	public int getI(){
		return increment;
	}
	public void setI(int I){
		increment = I;
	}
	
}
