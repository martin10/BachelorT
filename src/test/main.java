package test;

import javax.swing.*;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.*;

@SuppressWarnings("serial")
public class main extends JFrame {
   
    
public static void main(String[] args) {
@SuppressWarnings("unused")
main frameTabel = new main();
}

//Lager buttons, panel og felter. 
JButton blogin = new JButton("Login");
JPanel panel = new JPanel();
JTextField txuser = new JTextField(15);
JPasswordField pass = new JPasswordField(15);
JLabel userName = new JLabel("Brukernavn :");
JLabel passWord = new JLabel("Passord :");
JTextArea nytext = new JTextArea(15, 70);
JButton uregistrert = new JButton("Bruk programmet som gjestebruker");

//setter sizen til vinduet
main(){
super("Analyseverkt??y logg inn");
setSize(800,600);
setLocation(500,280);
panel.setLayout (null);
setResizable(false);

//Setter dimensjoner og plassering til labels, buttons, og textfields
txuser.setBounds(320,220,150,20);
pass.setBounds(320,245,150,20);
blogin.setBounds(340,290,80,20);
userName.setBounds(240,220,150,20);
passWord.setBounds(262,245,150,20);
uregistrert.setBounds(250,330, 250,20);

//Denne skal v??re i bunn, satt til 0,0 fordi jeg ikke faar det til aa fungere.
nytext.setSize(0,0);
nytext.setText("Du m?? logge inn for ?? benytte menyen.");

//Adder labels, buttons og texfield til panel
panel.add(blogin);
panel.add(txuser);
panel.add(pass);
panel.add(userName);
panel.add(passWord);
panel.add(nytext);
panel.add(uregistrert);

//Henter content fra panel og setter visible til true slik at det vises
getContentPane().add(panel);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
actionlogin();
actionuregistrert();
}

//Actionlistener og event for uregistrerte brukere. 
public void actionuregistrert(){
uregistrert.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		@SuppressWarnings("unused")
		JButton clicked = (JButton) e.getSource();      
		Mats regFace =new Mats();
		regFace.setVisible(true);
		dispose();
    }});
}

public void actionlogin(){
blogin.addActionListener(new ActionListener()
{
//Actionevent, henter string fra brukernavn og passord, hvis det samstemmer med gitte paramenter skal startsiden vises. 
@Override
public void actionPerformed(ActionEvent ae) {
String bnavn = txuser.getText();
@SuppressWarnings("deprecation")
String pord = pass.getText();
if(bnavn.equals("Elg") && pord.equals("Elg")){
Mats regFace =new Mats();
regFace.setVisible(true);
dispose();
} 

//Legger til mulighet for at systemet godtar flere brukernavn.
if(bnavn.equals("Bibbi") && pord.equals("Bibbi")) {
Mats regFace =new Mats();
regFace.setVisible(true);
dispose();
} 
//Legger til mulighet for at systemet godtar flere brukernavn.
if(bnavn.equals("Test") && pord.equals("Test")) {
Mats regFace =new Mats();
regFace.setVisible(true);
dispose();
} 
//Legger til mulighet for at systemet godtar flere brukernavn.
if(bnavn.equals("Klikk") && pord.equals("Klikk")) {
Mats regFace =new Mats();
regFace.setVisible(true);
dispose();
} 
//Legger til mulighet for at systemet godtar flere brukernavn.
if(bnavn.equals("eli") && pord.equals("eli")) {
Mats regFace =new Mats();
regFace.setVisible(true);
dispose();
} 
 
else {

//hvis brukernavn/passord er feil, printer ut feil-melding og resetter feltene
JOptionPane.showMessageDialog(null,"Feil brukernavn og/eller passord");
txuser.setText("");
pass.setText("");
txuser.requestFocus();
}  
}
});
}

}