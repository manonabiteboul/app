import java.util.ArrayList;


public class Categorie {
	String name;
	ArrayList a;
	
	public Categorie(){
		System.out.println("On a une category");
	}
	
	public Categorie(String cname,ArrayList al){
		System.out.println("Nous avons cree une categorie avec comme list:");
		for(int i=0; i<al.size();i++)
		{
			System.out.println(((Activite) al.get(i)).getName());
		}
		a=al;
		name = cname; 
		
	}
	
	public String getName(){
		return name;
	}
	public void setName(String newnom){
		name= newnom;
	}
	public ArrayList getArray(){
		return a;
	}
	public int getSize(){
		return a.size();
	}
	
	
}
