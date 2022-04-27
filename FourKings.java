import javax.swing.*;

public class FourKings
{
	public static void main(String[] args)
	{
		// Kartenvariablen
		
		int karte = 0;
		int koenig = 0;
		int sieben = 0;
		int acht = 0;
		int neun = 0;
		int zehn = 0;
		int bube = 0;
		int dame = 0;
		int ass = 0;
		int zaehler = 1;
		
			
		//Exception setzen um Falsche eingaben abzufangen
		try{
		String dialog = "";
		int eingabe = 0 ;
		dialog = JOptionPane.showInputDialog("<html><h1>FourKings</h1></html>" + "\n" + " " + "\nStandard-Spiel (1)" +"\nKarten selber belegen (2)"+ "\nBeenden (3)" +
		"\n" + " ");
		eingabe = Integer.parseInt(dialog);
		
		if(eingabe < 1 && eingabe > 3)
		{
				System.out.println("Falsche Eingabe!");
				System.out.println("Programm Ende");
				System.exit(0);
		}
	  
		//1. If-Anweisung: Gibt Vorgegebene Regeln wieder.
		if(eingabe == 1)
		{
			while(koenig != 4)
			{
	    
				karte = (int)(Math.random()*8+1);
				
		
					switch(karte)
					{
						case 1:
							if(sieben!= 4)
							{
								JOptionPane.showMessageDialog(null, zaehler++ +".Karte" + "\n" + "<html><h1>7</h1></html>" + "\n" + "<html><h3>Aktion: Schmipfwort bei Zahlen mit 7 und Teiler von Sieben</h3></html>");
								sieben++;
							}
							break;	
						case 2:
							if(acht!= 4)
							{
								JOptionPane.showMessageDialog(null, zaehler++ +".Karte" + "\n" + "<html><h1>8</h1></html>" + "\n" + "<html><h3>Aktion: Wortspiel</h3></html>");
								acht++;
							}
							break;
						case 3:
							if(neun!= 4)
							{
								JOptionPane.showMessageDialog(null, zaehler++ +".Karte" + "\n" + "<html><h1>9</h1></html>" + "\n" + "<html><h3>Aktion: Klopfen</h3></html>");
								neun++;
							}
							break;
						case 4:
							if(zehn!= 4)
							{
								JOptionPane.showMessageDialog(null, zaehler++ +".Karte" + "\n" + "<html><h1>10</h1></html>" + "\n" + "<html><h3>Aktion: Wortgruppe</h3></html>");
								zehn++;
							}
							break;
						case 5:
							if(bube!= 4)
							{
								JOptionPane.showMessageDialog(null, zaehler++ +".Karte" + "\n" + "<html><h1>Bube</h1></html>" + "\n" + "<html><h3>Aktion: Alle Maenner trinken!</h3></html>");
								bube++;
							}
							break;
						case 6:
							if(dame!= 4)
							{
								JOptionPane.showMessageDialog(null, zaehler++ +".Karte" + "\n" + "<html><h1>Dame</h1></html>" + "\n" + "<html><h3>Aktion: MiniGame!</h3></html>");
								dame++;
							}
							break;
						case 7:
							JOptionPane.showMessageDialog(null, zaehler++ +".Karte" + "\n" + "<html><h1>Koenig</h1></html>" + "\n" + "<html><h3>Aktion: Abgiessen in den KingsCup</h3></html>");
							koenig++;
							break;
						case 8:
							if(ass!= 4)
							{
								JOptionPane.showMessageDialog(null, zaehler++ +".Karte" + "\n" + "<html><h1>Ass</h1></html>" + "\n" + "<html><h3>Aktion: Regel aufstellen</h3></html>");
								ass++;
							}
							break;
					}
			
			}
		
			JOptionPane.showMessageDialog(null, "<html><h1>Fertig !</h1></html>" + "\n" + "<html><h3>Es wurden 4 Koenige gezogen!</h3></html>");
			System.out.println("Programme Ende");	
		
		}
			
			//2. If-Anweisung: Benutzer draf Regel selbst setzen
			if(eingabe ==2)
			{
				
				String seven = JOptionPane.showInputDialog("Welche Aktion soll die 7 haben?");
				String eight = JOptionPane.showInputDialog("Welche Aktion soll die 8 haben?");
				String nine = JOptionPane.showInputDialog("Welche Aktion soll die 9 haben?");
				String ten = JOptionPane.showInputDialog("Welche Aktion soll die 10 haben?");
				String boy = JOptionPane.showInputDialog("Welche Aktion soll die Bube haben?");
				String lady = JOptionPane.showInputDialog("Welche Aktion soll die Dame haben?");
				String aß = JOptionPane.showInputDialog("Welche Aktion soll die Ass haben?");
				
				
				int map = 0;
				int koenigEins = 0;
				int siebenEins = 0;
				int achtEins = 0;
				int neunEins = 0;
				int zehnEins = 0;
				int bubeEins = 0;
				int dameEins = 0;
				int assEins = 0;
				int zaehlerEins = 1;
				
				while(koenigEins != 4)
				{
	    
					map = (int)(Math.random()*8+1);
				
		
					switch(map)
					{
						case 1:
							if(siebenEins!= 4)
							{
								JOptionPane.showMessageDialog(null, zaehlerEins++ +".Karte" + "\n" + "<html><h1>7</h1></html>" + "\n" + "Aktion: " + seven);
								siebenEins++;
							}
							break;	
						case 2:
							if(achtEins!= 4)
							{
								JOptionPane.showMessageDialog(null, zaehlerEins++ +".Karte" + "\n" + "<html><h1>8</h1></html>" + "\n" + "Aktion: " + eight);
								achtEins++;
							}
							break;
						case 3:
							if(neunEins!= 4)
							{
								JOptionPane.showMessageDialog(null, zaehlerEins++ +".Karte" + "\n" + "<html><h1>9</h1></html>" + "\n" + "Aktion: " + nine);
								neunEins++;
							}
							break;
						case 4:
							if(zehnEins!= 4)
							{
								JOptionPane.showMessageDialog(null, zaehlerEins++ +".Karte" + "\n" + "<html><h1>10</h1></html>" + "\n" + "Aktion: " + ten);
								zehnEins++;
							}
							break;
						case 5:
							if(bubeEins!= 4)
							{
								JOptionPane.showMessageDialog(null, zaehlerEins++ +".Karte" + "\n" + "<html><h1>Bube</h1></html>" + "\n" + "Aktion: " + boy);
								bubeEins++;
							}
							break;
						case 6:
							if(dameEins!= 4)
							{
								JOptionPane.showMessageDialog(null, zaehlerEins++ +".Karte" + "\n" + "<html><h1>Dame</h1></html>" + "\n" + "Aktion: "+ lady);
								dameEins++;
							}
							break;
						case 7:
							JOptionPane.showMessageDialog(null, zaehlerEins++ +".Karte" + "\n" + "<html><h1>Koenig</h1></html>" + "\n" + "Aktion: Abgiessen in den KingsCup!\n");
							koenigEins++;
							break;
						case 8:
							if(assEins!= 4)
							{
								JOptionPane.showMessageDialog(null, zaehlerEins++ +".Karte" + "\n" + "<html><h1>Ass</h1></html>" + "\n" + "Aktion: " + aß);
								assEins++;
							}
							break;
					}
			
			}
			}	
			//3. If-Anweisung: Programm wird geschlossen
			if(eingabe == 3)
			{
				System.out.println("Programm Ende");
				System.exit(0);
			}
	
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Bitte nur die vorgegebenen Zahlen 1, 2 und 3 eingeben!" + "\n" + "Die Zahlen ausshalb des Bereich werden nicht erkannt");
				System.out.println("Programm Ende");
				System.exit(0);
			}
		
	
	}//main
}//class

