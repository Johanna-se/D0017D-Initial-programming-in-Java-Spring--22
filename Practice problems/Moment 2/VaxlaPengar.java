/**
*Från LTU
*Skriv ett Javaprogram som delar upp ett, av användaren, 
*inmatat belopp i 20-sedlar, 10-kronor, 5-kronor och 1-kronor. 
*Använd klassen JOptionPane för inmatning och utmatning:
*/

import javax.swing.JOptionPane;
import java.util.Scanner; 

class VaxlaPengar
{
	public static void main(String[] args)
	{
		//Initiera skanning
		Scanner userInput = new Scanner(System.in);
  
		//Variabler:
		int tjuga, tia, femKrona, enKrona, belopp, kvarvarandeBelopp; 
		String initialtBelopp, utText;

		//Fråga Användaren efter summa
		initialtBelopp = JOptionPane.showInputDialog(null, "Vilket belopp ska växlas?", "Växling", JOptionPane.QUESTION_MESSAGE);

		//Konvertera från sträng till int
		belopp = Integer.parseInt(initialtBelopp);

		//Beräkning av antal 20-lappar
		tjuga = belopp / 20; 
		kvarvarandeBelopp = belopp% 20;

		//Beräkning av antal 10-lappar
		tia = kvarvarandeBelopp/10;
		kvarvarandeBelopp = kvarvarandeBelopp% 10;

		//Beräkning av antal fem kronor
		femKrona = kvarvarandeBelopp / 5;
		kvarvarandeBelopp = kvarvarandeBelopp% 5;

		//Beräkning av antal enkronor
		enKrona = kvarvarandeBelopp;

		//Skapa sträng till medelande
		utText = "Antal 20: " + tjuga + "\n" + "Antal 10: " + tia + "\n" + "Antal 5: " + femKrona + "\n" + "Antal 1: " + enKrona;


		//Ge svar till Användaren
		JOptionPane.showMessageDialog (null, utText);
  
		//TEST
		System.out.println(tjuga);
		System.out.println(tia);
		System.out.println(femKrona);
		System.out.println(enKrona);
	}
}
