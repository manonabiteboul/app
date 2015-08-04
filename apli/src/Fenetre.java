import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.util.ArrayList;
public class Fenetre extends JFrame implements ActionListener {
	private JPanel container = new JPanel();
	private JPanel container2 = new JPanel();
	private JPanel container3 = new JPanel();
	private JPanel parentAddCat = new JPanel();
	private JPanel parentRemoveCat = new JPanel();
	private JPanel checkremove = new JPanel();
	private Activite a;
	
	
	private JLabel parentRemoveCatLabel= new JLabel("Veuillez cocher le nom de la categorie que vous souhaitez enlever:");
	ArrayList ouinon = new ArrayList();
	JRadioButton jr1 = new JRadioButton("oui");
    JRadioButton jr2 = new JRadioButton("non");
    String aEnlever;
	
	private JLabel parentAddCatLabel= new JLabel("Veuillez entrer le nom de la categorie que vous souhaitez ajouter:");
	JPanel addCatPanel=new JPanel();
	private JTextField addCatNom = new JTextField("");
	private JTextField addActiviteNom1 = new JTextField(" ");
	private JTextField addActiviteNom2 = new JTextField(" ");
	private JTextField addActiviteNom3 = new JTextField(" ");
	private JTextField addActiviteNom4 = new JTextField("");
	JPanel addCatActPanel=new JPanel();
	private JLabel parentAddCatActLabel= new JLabel("Veuillez entrer le nom des activites que vous voudriez dans cette categorie:");
	private JLabel label= new JLabel("Select which main activity you want to do:");
	private JLabel choix = new JLabel("Tu n'as pas encore choisi");
	private ArrayList lmanger = new ArrayList();
	private ArrayList activite= new ArrayList();
	private ArrayList test= new ArrayList();
	private Categorie store = new Categorie();
	private Thread t;
	private int j;
	private JButton bouton2 = new JButton("ca");
	private JButton OK = new JButton("OK");
	private JButton OK2 = new JButton("Retour");
	private JButton retour = new JButton("Retour au menu principale");
	private JButton retour2 = new JButton("Retour au menu principale");
	private JButton parent = new JButton("Changer les configurations");
	private JButton addActivite = new JButton("Ajouter des activites a l'interieur d'une categorie");
	private JButton removeActivite = new JButton("Enlever des activites a l'interieur d'une categorie");
	private JButton addCategorie = new JButton("Ajouter une categorie d'activite");
	private JButton removeCategorie = new JButton("Enlever une categorie d'activite");
	private String s,m,n;
	JPanel suboptions=new JPanel();
	JPanel options=new JPanel();

	public Fenetre(){
		
		container2.setLayout(new BorderLayout());
		container2.add(retour, BorderLayout.SOUTH);
		retour.addActionListener(new BoutonRetour());
		
		container3.setLayout(new BorderLayout());
		container3.add(retour2, BorderLayout.SOUTH);
		retour2.addActionListener(new BoutonRetour());
		JPanel parentOptions = new JPanel();
		parentOptions.add(addActivite);
		parentOptions.add(removeActivite);
		parentOptions.add(addCategorie);
		addCategorie.addActionListener(new BoutonAddCat());
		
		
		
		parentOptions.add(removeCategorie);
		removeCategorie.addActionListener(new BoutonRemoveCat());
		container3.add(parentOptions);
		parent.addActionListener(new BoutonParent());
		Activite m = new Activite("cereales", Color.BLUE);
		lmanger.add(m);
		Activite p = new Activite("pain", Color.RED);
		lmanger.add(p);
		Activite pa = new Activite("pates", Color.BLACK);
		lmanger.add(pa);
		Activite g = new Activite("gateau", Color.RED);
		lmanger.add(g);
		Categorie manger= new  Categorie("manger",lmanger);
		activite.add(manger);
		
		
		ArrayList lboire = new ArrayList();
		Activite e = new Activite("eau", Color.RED);
		lboire.add(e);
		Activite jdr = new Activite("jus d'orange", Color.RED);
		lboire.add(jdr);
		Activite c = new Activite("coca", Color.RED);
		lboire.add(c);
		Categorie boire= new Categorie("boire",lboire);
		activite.add(boire);
		
		ArrayList ltoilettes = new ArrayList();
		Categorie toilettes= new Categorie("aller aux toilettes",ltoilettes);
		activite.add(toilettes);
		
		ArrayList ljouer = new ArrayList();
		Activite be = new Activite("ball.e", Color.RED);
		ljouer.add(be);
		Activite cr = new Activite("courir", Color.RED);
		ljouer.add(cr);
		Activite ds = new Activite("dessiner", Color.RED);
		ljouer.add(ds);
		Categorie jouer= new Categorie("jouer",ljouer);
		activite.add(jouer);
		
		ArrayList lsortir = new ArrayList();
		Activite P = new Activite("Piscine", Color.RED);
		lsortir.add(P);
		Activite C = new Activite("Courir", Color.RED);
		lsortir.add(C);
		Activite B = new Activite("Balancoire", Color.RED);
		lsortir.add(B);
		Activite Pr = new Activite("parc", Color.RED);
		lsortir.add(Pr);
		Categorie sortir = new Categorie("sortir", lsortir);
		activite.add(sortir);
		
		
		options.setLayout(new GridLayout(4, 3));
		int n= activite.size();
		

		
//		JButton a = new JButton();
//			a.setText(((Categorie)activite.get(0)).getName());
//			options.add(a); 
//
//		JButton b = new JButton();
//			b.setText(((Categorie)activite.get(1)).getName());
//			options.add(b);
//			
//		JButton c = new JButton();
//		c.setText(((Categorie)activite.get(2)).getName());
//		options.add(c);
//		
//		JButton d = new JButton();
//		d.setText(((Categorie)activite.get(3)).getName());
//		options.add(d);

		
		for(int i = 0 ;i<activite.size(); i++)
		{
			JButton b = new JButton();
			b.setText(((Categorie)activite.get(i)).getName());
			
			options.add(b);
			b.addActionListener(new BoutonListener());
		}
		
	

		
		this.setTitle("Test d'apli");
		this.setSize(210,320);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());

		container.add(options, BorderLayout.CENTER);
		container.add(parent, BorderLayout.SOUTH);
		//choix.setForeground(Color.BLACK);
		//Font police = new Font("Tahoma", Font.PLAIN, 16 );
		//choix.setFont(police);
		//choix.setHorizontalAlignment(JLabel.CENTER);
		//container.add(choix, BorderLayout.SOUTH);
		
		
		this.setContentPane(container);
		this.setVisible(true);
//		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//this.setContentPane(container2);
		//container.remove(options);
		
		
	}
		




	
public void actionPerformed(ActionEvent arg0) {
	
}


class BoutonRetour implements ActionListener {
	public void actionPerformed(ActionEvent arg0){
		
		setContentPane(container);
		setVisible(true);
			
		
	}
}



class BoutonParent implements ActionListener {
	public void actionPerformed(ActionEvent arg0){
		
		setContentPane(container3);
		setVisible(true);
			
		
	}
}
class BoutonRemoveCat implements ActionListener{
	public void actionPerformed(ActionEvent arg0){
		parentRemoveCat.removeAll();
		setContentPane(parentRemoveCat);
		
		JPanel removeCatPanel = new JPanel();
		for(int i = 0 ;i<activite.size(); i++)
		{
			JCheckBox check = new JCheckBox(((Categorie)activite.get(i)).getName());
			check.addActionListener(new CheckListener());
			removeCatPanel.add(check);
		}
		OK2.addActionListener(new BoutonSetRemoveCat());
		parentRemoveCat.setLayout(new BorderLayout());
		parentRemoveCat.add(parentRemoveCatLabel,BorderLayout.NORTH);
		parentRemoveCat.add(removeCatPanel,BorderLayout.CENTER);
		parentRemoveCat.add(OK2,BorderLayout.SOUTH);
		
		setVisible(true);
		
	}
}

class CheckListener implements ActionListener{
	 
    public void actionPerformed(ActionEvent e) {
    	checkremove.removeAll();
    	JLabel verif = new JLabel("Etes vous sures que vous voulez enlever "+  ((JCheckBox)e.getSource()).getText());
    	aEnlever = ((JCheckBox)e.getSource()).getText();
    	checkremove.add(verif);
    	ButtonGroup bg = new ButtonGroup();

        
        jr1.addActionListener(new StateListener());
        jr2.addActionListener(new StateListener());
        
        bg.add(jr1);
        bg.add(jr2);
        
        checkremove.add(jr1);
        checkremove.add(jr2);
    	

    	setContentPane(checkremove);
    	setVisible(true);
    
           
    }
    
}
class StateListener implements ActionListener{
	 
    public void actionPerformed(ActionEvent e) {
            System.out.println("source : " + jr1.getText() + " - état : " + jr1.isSelected());
            System.out.println("source : " + jr2.getText() + " - état : " + jr2.isSelected());
            if( jr1.isSelected() == true)
            {
            	System.out.println("on a decide d'enlever "+aEnlever);
        		for(int i = 0 ;i<activite.size(); i++)
        		{
        			if((((Categorie)activite.get(i)).getName())==aEnlever) 
        			{
        				activite.remove(i);
        				
        			}
        		}
        		options.removeAll();
        		for(int i = 0 ;i<activite.size(); i++)
        		{
        			JButton b = new JButton();
        			b.setText(((Categorie)activite.get(i)).getName());
        			options.add(b);
        			b.addActionListener(new BoutonListener());
        		}
            }
            
            setContentPane(container3);
        	setVisible(true);
    }
    
}

class BoutonSetRemoveCat implements ActionListener{
	public void actionPerformed(ActionEvent arg0){
		setContentPane(container3);
	}
}

class BoutonAddCat implements ActionListener{
	public void actionPerformed(ActionEvent arg0){
		addCatNom.setPreferredSize(new Dimension(150, 30));
		addActiviteNom1.setPreferredSize(new Dimension(150, 30));
		addActiviteNom2.setPreferredSize(new Dimension(150, 30));
		addActiviteNom3.setPreferredSize(new Dimension(150, 30));
		addActiviteNom4.setPreferredSize(new Dimension(150, 30));
		setContentPane(parentAddCat);
		addCatPanel.add(parentAddCatLabel);
		addCatPanel.add(addCatNom);
		addCatActPanel.add(parentAddCatActLabel);
		addCatActPanel.add(addActiviteNom1);
		addCatActPanel.add(addActiviteNom2);
		addCatActPanel.add(addActiviteNom3);
		addCatActPanel.add(addActiviteNom4);
		parentAddCat.setLayout(new BorderLayout());
		parentAddCat.add(addCatPanel,BorderLayout.NORTH);
		parentAddCat.add(addCatActPanel,BorderLayout.CENTER);
		parentAddCat.add(OK,BorderLayout.SOUTH);
		OK.addActionListener(new BoutonSetAddCat());
		setVisible(true);
		
	}
}

class BoutonSetAddCat implements ActionListener{
	public void actionPerformed(ActionEvent arg0){
		if(addCatNom.getText() != null && (addCatNom.getText()).length() == 0)
		{
			setContentPane(container3);
		}
		else
		{
			ArrayList listAdd = new ArrayList();
			if(addActiviteNom1.getText() != null && (addActiviteNom1.getText()).length() == 0)
			{
			}
			else
			{
				Activite a = new Activite(addActiviteNom1.getText(), Color.RED);
				listAdd.add(a);
				
			}
			if(addActiviteNom2.getText() != null && (addActiviteNom2.getText()).length() == 0)
			{
			}
			else
			{
				Activite a = new Activite(addActiviteNom2.getText(), Color.RED);
				listAdd.add(a);
				
			}
			if(addActiviteNom3.getText() != null && (addActiviteNom3.getText()).length() == 0)
			{
			}
			else
			{
				Activite a = new Activite(addActiviteNom3.getText(), Color.RED);
				listAdd.add(a);
				
			}
			if(addActiviteNom4.getText() != null && (addActiviteNom4.getText()).length() == 0)
			{
			}
			else
			{
				Activite a = new Activite(addActiviteNom4.getText(), Color.RED);
				listAdd.add(a);
				
			}
			
			Categorie nouvellecat = new Categorie(addCatNom.getText(),listAdd);
			activite.add(nouvellecat);
			JButton nouvellecatbouton = new JButton(addCatNom.getText());
			options.add(nouvellecatbouton);
			nouvellecatbouton.addActionListener(new BoutonListener());
			setContentPane(container3);
		
			addCatNom.setText("");
			addActiviteNom1.setText("");
			addActiviteNom2.setText("");
			addActiviteNom3.setText("");
			addActiviteNom4.setText("");
		}
		
	}
}
	
class BoutonListener implements ActionListener {
	public void actionPerformed(ActionEvent arg0){
		
			JButton btn = (JButton)arg0.getSource();
			System.out.println("on va faire:"+btn.getText());
			suboptions.removeAll();
			
			
			container2.setBackground(Color.WHITE);
			System.out.println("activite a pour taille : "+ activite.size());
			for(int i = 0 ;i<activite.size(); i++)
			{
				
				System.out.println("Maintenant nous considerons la categorie "+((Categorie) activite.get(i)).getName());
				System.out.println("On compare"+btn.getText()+"et"+((Categorie) activite.get(i)).getName()+"y a il un espace et on obtient"+ (btn.getText()==((Categorie) activite.get(i)).getName()));
				m=btn.getText();
				n=((Categorie) activite.get(i)).getName();
				//if(btn.getText()==((Categorie) activite.get(i)).getName())
				if(m==n)
				{
					System.out.println("C'est la bonne categorie! L'activite "+i+" de activite a pour nom "+((Categorie) activite.get(i)).getName());
				
					for(j=0;j< (((Categorie) activite.get(i)).getArray()).size();j++)
					{
						
						Activite a = (Activite) ((((Categorie) activite.get(i)).getArray()).get(j));
						String S=a.getName();
						JButton b = new JButton();
						b.setText(S);
						b.setBackground(a.getColor());
						suboptions.add(b);
						
						
						System.out.println("On va creer le bouton " +S);
					
						
					}
				}
				container2.add(suboptions, BorderLayout.CENTER);
					//System.out.println("Est-ce bien?" + ((Categorie) activite.get(i)).getName());
				test = ((Categorie) activite.get(i)).getArray();
				//System.out.println("Et la taille est elle bonne? " +(((Categorie) activite.get(i)).getArray()).size());
					
					
				
			}
			setContentPane(container2);
			setVisible(true);
			
		
	}
}

}