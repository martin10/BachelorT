package test;

//ulike importer
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class Mats extends JFrame implements ActionListener {
	
	private JRadioButton Ufullstendig;
    public JButton btnLogin, btnPath, btnSave, btnSaveTann, btnSaveDB, btnSaveDBB, btnSaveV;
    public JMenuItem searchResult, excelInn, excelUt, publisering, grafer, multivariat, bivariat, univariat, settElg, tannanalyse, værdata, skogsanalyse, beiteregistrering, RedigerArkiv, SokArkiv;
    public JPanel masterPanel, buttonPanel, loginBtn, mainContent,  masterCenter, importExcelContent, publiseringPanel, registrerTann, BeiteContent, VarDataContent;
    public JMenu hjemMenu;
    public JMenuBar menuBar;
    @SuppressWarnings("rawtypes")
	private JComboBox valgImport;
    private JTextField filePath, txtFeltid, txtValdnr, txtValdnavn, RadioButton, txtJaktfeltnr, txtJaktfeltnavn, txtJaktleder, txtDato, txtAlder, txtVeidVekt, txtKjønn, txtFeltDyr, txtAntallKalv, txtAntallTagger, txtAntattVekt;
    private JTextField txtros, txteiner, txteik, txtbjørk, txtfuru, txtVarData;
    private JTextArea textArea1, textArea2, textArea3, textArea4, textArea5;
    private JFrame frame;
   
        
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public Mats() {
          
        setTitle("Analyseverktøøøy");
        setSize(800, 600);
        setLocation(500,280);
        setResizable(false);
        
        //Lager menybar for JFrame
        menuBar = new JMenuBar();
        //Adder menybaren til Framen
        setJMenuBar(menuBar);
        hjemMenu = new JMenu("Hjem");
        
        //lager dropdown menyer
        JMenu importMenu = new JMenu("Import");
        JMenu exportMenu = new JMenu("Export");
        JMenu statistikkMenu = new JMenu("Statistikk");
        JMenu registreringMenu = new JMenu("Registrering");
        JMenu arkivMenu = new JMenu("Arkiv");
        
        //legges til i menybaren
        menuBar.add(hjemMenu);
        menuBar.add(importMenu);
        menuBar.add(exportMenu);
        menuBar.add(statistikkMenu);
        menuBar.add(registreringMenu);
        menuBar.add(arkivMenu);
        
        //Lager menuItems
        excelInn = new JMenuItem("Excel");
        excelUt = new JMenuItem("Excel");
        publisering = new JMenuItem("Publisering");
        grafer = new JMenuItem("Grafer");
        multivariat = new JMenuItem("Multivariat analyse");
        bivariat = new JMenuItem("Bivariat analyse");
        univariat = new JMenuItem("Univariat analyse");
        settElg = new JMenuItem("Sett elg");
        tannanalyse = new JMenuItem("Tannanalyse");
        værdata = new JMenuItem("Vøøørdata");
        skogsanalyse = new JMenuItem("Skogsanalyse");
        beiteregistrering = new JMenuItem("Beiteregistrering");
        searchResult = new JMenuItem("Arkiv");
        RedigerArkiv = new JMenuItem("Søk I Arkivet");
        SokArkiv = new JMenuItem("Rediger Arkiv");
        
        //Adder ulike menuItmen til øøønskede dropdowner. 
        importMenu.add(excelInn);
        exportMenu.add(excelUt);
        exportMenu.add(publisering);
        statistikkMenu.add(grafer);
        statistikkMenu.add(multivariat);
        statistikkMenu.add(bivariat);
        statistikkMenu.add(univariat);
        registreringMenu.add(settElg);
        registreringMenu.add(tannanalyse);
        registreringMenu.add(værdata);
        registreringMenu.add(skogsanalyse);
        registreringMenu.add(beiteregistrering);
        arkivMenu.add(searchResult);
        arkivMenu.add(RedigerArkiv);
        arkivMenu.add(SokArkiv);
        
        //Ulike paneler
        loginBtn = new JPanel(new FlowLayout());
        btnLogin = new JButton("Login");
        loginBtn.add(btnLogin);
        
        masterCenter = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridx = 0;
        c.gridy = 0;
        c.gridx = 1;
        c.gridy = 0;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        masterCenter.add(loginBtn, c);
        
        //panel skall for ui tl publisering
        publiseringPanel = new JPanel();
        publiseringPanel.setSize(800, 600);
        JTextArea info = new JTextArea("her kommer UI til publisering");
        info.setBounds(340,290,80,20);
        publiseringPanel.add(info);
        
        //panel skall for ui tl forsiden/hovedsiden
        mainContent = new JPanel(new GridLayout(1,1));
        JTextArea infoText = new JTextArea(10, 60);
        infoText.setText("Her skal det komme brukerveiledning =)");
        infoText.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(infoText);
        mainContent.add(scrollPane);
        
        //Kode for dropdown menyen, elementene i dropdown er strings, det er en ArrayList. 
        importExcelContent = new JPanel(new GridBagLayout());
        String[] importValg = {"Sett elg", "Tannanalyse", "Vøøørdata", "Skogsanalyse", "Beiteregistrering"};
        valgImport = new JComboBox(importValg);
        valgImport.setSelectedIndex(0);
        filePath = new JTextField(15);
        filePath.setText("Ingen fil valgt");
        
        //Hvert felt i dropdownen føøør sitt eget textfelt.
        textArea1 = new JTextArea(10, 40);
        textArea1.setText("Du har valg Sett Elg");
        textArea2 = new JTextArea(10, 40);
        textArea2.setText("Du har valg Tannanalyse");
        textArea3 = new JTextArea(10, 40);
        textArea3.setText("Du har valg Vøøørdata");
        textArea4 = new JTextArea(10, 40);
        textArea4.setText("Du har valgt Skogsanalyse");
        textArea5 = new JTextArea(10, 40);
        textArea5.setText("Du har valgt Beiteregistrering");
        btnPath = new JButton("Velg fil");
        btnSave = new JButton("Importer");
        
        //beiteanalyse GUI
        BeiteContent = new JPanel(new GridBagLayout());
        BeiteContent.setSize(800, 600);
        txtfuru = new JTextField(15);
        txtbjørk = new JTextField(15);
        txteik = new JTextField(15);
        txtros = new JTextField(15);
        txteiner = new JTextField(15);
        JButton btnSaveDBB = new JButton("Exporter Til DB");
        JLabel bjørk = new JLabel("Bjøøørk");
        JLabel furu = new JLabel("Furu");
        JLabel eik = new JLabel("Eik");
        JLabel ros = new JLabel("Ros");
        JLabel einer = new JLabel("Einer");
        c.gridx = 0;
        c.gridy = 1;
        BeiteContent.add(txtfuru, c);
        c.gridx = 0;
        c.gridy = 0; 
        BeiteContent.add(furu, c);
        c.gridx = 0;
        c.gridy = 3;
        BeiteContent.add(txtbjørk, c);
        c.gridx = 0;
        c.gridy = 2;
        BeiteContent.add(bjørk, c);
        c.gridx = 0;
        c.gridy = 5;
        BeiteContent.add(txteik, c);
        c.gridx = 0;
        c.gridy = 4;
        BeiteContent.add(eik, c);
        c.gridx = 0;
        c.gridy = 7;
        BeiteContent.add(txteiner, c);
        c.gridx = 0;
        c.gridy = 6;
        BeiteContent.add(ros, c);
        c.gridx = 0;
        c.gridy = 9;
        BeiteContent.add(txtros, c);
        c.gridx = 0;
        c.gridy = 8;
        BeiteContent.add(einer, c);
        c.gridx = 0;
        c.gridy = 10;
        BeiteContent.add(btnSaveDBB, c);


        //Vøøørdata GUI
        VarDataContent = new JPanel(new GridBagLayout());
        VarDataContent.setSize(800, 600);
        txtVarData = new JTextField(15);
        JButton btnSaveDBV = new JButton("Exporter Til DB");
        JLabel VarData = new JLabel("Registrer Vøøørdata");
        JButton btnSaveV = new JButton("Exporter Til DB");
        c.gridx = 0;
        c.gridy = 1;
        VarDataContent.add(txtVarData, c);
        c.gridx = 0;
        c.gridy = 0; 
        VarDataContent.add(VarData, c);
        c.gridx = 0;
        c.gridy = 10;
        VarDataContent.add(btnSaveV, c);
        
        //Tar indexen fra arrayen, setter riktig textfield til riktig array. 
        //Mye kode kan dette gjøøøres annerledes? 
        valgImport.addActionListener(
                         new ActionListener() {
                            @Override
							public void actionPerformed(ActionEvent actionEvent ) {
                               if (valgImport.getSelectedIndex() == 0 ) {
                                  textArea1.setVisible(true);
                               }

                               if (valgImport.getSelectedIndex() == (valgImport.getItemCount()-1)) {
                                  textArea1.setVisible(false);
                                  textArea2.setVisible(false);
                                  textArea3.setVisible(false);
                                  textArea4.setVisible(false);
                                  textArea5.setVisible(true);

                               }
                               if (valgImport.getSelectedIndex() == (valgImport.getItemCount()-2)) {
                            	   textArea1.setVisible(false);
                                   textArea2.setVisible(false);
                                   textArea3.setVisible(false);
                                   textArea4.setVisible(true);
                                   textArea5.setVisible(false);
                               }
                               if (valgImport.getSelectedIndex() == (valgImport.getItemCount()-3)) {
                            	   textArea1.setVisible(false);
                                   textArea2.setVisible(false);
                                   textArea3.setVisible(true);
                                   textArea4.setVisible(false);
                                   textArea5.setVisible(false);
                               }
                               if (valgImport.getSelectedIndex() == (valgImport.getItemCount()-4)) {
                            	   textArea1.setVisible(false);
                                   textArea2.setVisible(true);
                                   textArea3.setVisible(false);
                                   textArea4.setVisible(false);
                                   textArea5.setVisible(false);
                               }
                            }
                         }
                       );
        valgImport.addActionListener(this);
        valgImport.setVisible(true);
        textArea2.setVisible(false);
        textArea3.setVisible(false);
        textArea4.setVisible(false);
        textArea5.setVisible(false);

        //plassering av elementer
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 10, 10);
        importExcelContent.add(filePath, c);
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 10, 10);
        importExcelContent.add(btnPath, c);
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        importExcelContent.add(valgImport, c);
        c.gridx = 3;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        importExcelContent.add(textArea1, c);
        c.gridx = 3;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        importExcelContent.add(textArea2, c);
        c.gridx = 3;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        importExcelContent.add(textArea3, c);
        c.gridx = 3;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        importExcelContent.add(textArea4, c);
        c.gridx = 3;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        importExcelContent.add(textArea5, c);
        c.gridx = 0;
        c.gridy = 2;
        importExcelContent.add(btnSave, c);
        
        JRadioButton bool = new JRadioButton("fullstendig?", true);
        bool.setActionCommand("false");
     
        //ActionButtons for Exporter til database, en button for hvert av skjemaene. 
        JButton btnSaveDB = new JButton("Exporter Til DB");
        btnSaveDB.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });
        
        
        btnSaveDBB.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                saveDataB();
            }
        });
	
        btnSaveV.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                saveDataV();
            }
        });
        
        
        //Panel for registrere tannanalyse, labels og textfelt.
        registrerTann = new JPanel(new GridBagLayout());
        JLabel feltid = new JLabel("Felt Id");
        JLabel valdnr = new JLabel("Valdnr. HR");
        JLabel valdnavn = new JLabel("Valdnavn");
        JLabel jaktfeltnr = new JLabel("Jaktfeltnr. HR");
        JLabel jaktfeltnavn = new JLabel("Jaktfeltnavn");
        JLabel jaktleder = new JLabel("Jaktleder");
        JLabel dato = new JLabel("Dato");
        JLabel alder = new JLabel("Alder");
        JLabel veidVekt = new JLabel("Veid Vekt");
        JLabel kjønn = new JLabel("Kjøøønn");
        JLabel feltDyr = new JLabel("Felt dyr");
        JLabel antallKalv = new JLabel("Antall kalv");
        JLabel antallTagger = new JLabel("Antall tagger");
        JLabel antattVekt = new JLabel("Antatt vekt");
        txtFeltid = new JTextField(15);
        txtValdnr = new JTextField(15);
        txtValdnavn = new JTextField(15);
        txtJaktfeltnr = new JTextField(15);
        txtJaktfeltnavn = new JTextField(15);
        txtJaktleder = new JTextField(15);
        txtDato = new JTextField(15);
        txtAlder = new JTextField(15);
        txtVeidVekt = new JTextField(15);
        txtKjønn = new JTextField(15);
        txtFeltDyr = new JTextField(15);
        txtAntallKalv = new JTextField(15);
        txtAntallTagger = new JTextField(15);
        txtAntattVekt = new JTextField(15);
        RadioButton = new JTextField(15);
        
        Ufullstendig = new JRadioButton("Ufullstendig?");
        
        //Actionlistener for radiobutton i tannanalyse, ufullstendig. 
        Ufullstendig.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        	RadioButton.setText(((JRadioButton) e.getSource()).getText());
        	}
        	});
        
        
        // GUI til tannanalyse. Gridbag Layout er definert tidligere. 
        btnSaveTann = new JButton("Exporter Til Excel");
        c.gridx = 0;
        c.gridy = 0;
        registrerTann.add(feltid, c);
        c.gridx = 0;
        c.gridy = 2;
        registrerTann.add(valdnr, c);
        c.gridx = 0;
        c.gridy = 4;
        registrerTann.add(valdnavn, c);
        c.gridx = 0;
        c.gridy = 6;
        registrerTann.add(jaktfeltnr, c);
        c.gridx = 0;
        c.gridy = 8;
        registrerTann.add(jaktfeltnavn, c);
        c.gridx = 2;
        c.gridy = 0;
        registrerTann.add(jaktleder, c);
        c.gridx = 2;
        c.gridy = 2;
        registrerTann.add(dato, c);
        c.gridx = 2;
        c.gridy = 4;
        registrerTann.add(alder, c);
        c.gridx = 2;
        c.gridy = 6;
        registrerTann.add(veidVekt, c);
        c.gridx = 2;
        c.gridy = 8;
        registrerTann.add(kjønn, c);
        c.gridx = 4;
        c.gridy = 0;
        registrerTann.add(feltDyr, c);
        c.gridx = 4;
        c.gridy = 2;
        registrerTann.add(antallKalv, c);
        c.gridx = 4;
        c.gridy = 4;
        registrerTann.add(antallTagger, c);
        c.gridx = 4;
        c.gridy = 6;
        registrerTann.add(antattVekt, c);
        c.gridx = 0;
        c.gridy = 1;
        registrerTann.add(txtFeltid, c);
        c.gridx = 0;
        c.gridy = 3;
        registrerTann.add(txtValdnr, c);
        c.gridx = 0;
        c.gridy = 5;
        registrerTann.add(txtValdnavn, c);
        c.gridx = 0;
        c.gridy = 7;
        registrerTann.add(txtJaktfeltnr, c);
        c.gridx = 0;
        c.gridy = 9;
        registrerTann.add(txtJaktfeltnavn, c);
        c.gridx = 2;
        c.gridy = 1;
        registrerTann.add(txtJaktleder, c);
        c.gridx = 2;
        c.gridy = 3;
        registrerTann.add(txtDato, c);
        c.gridx = 2;
        c.gridy = 5;
        registrerTann.add(txtAlder, c);
        c.gridx = 2;
        c.gridy = 7;
        registrerTann.add(txtVeidVekt, c);
        c.gridx = 2;
        c.gridy = 9;
        registrerTann.add(txtKjønn, c);
        c.gridx = 4;
        c.gridy = 1;
        registrerTann.add(txtFeltDyr, c);
        c.gridx = 4;
        c.gridy = 3;
        registrerTann.add(txtAntallKalv, c);
        c.gridx = 4;
        c.gridy = 5;
        registrerTann.add(txtAntallTagger, c);
        c.gridx = 4;
        c.gridy = 7;
        registrerTann.add(txtAntattVekt, c);
        c.gridx = 4;
        c.gridy = 9;
        registrerTann.add(btnSaveTann, c);
        c.gridx = 6;
        c.gridy = 7;
        registrerTann.add(bool, c);
        c.gridy = 9;
        c.gridx = 6;
        registrerTann.add(btnSaveDB, c);
       
        
        //Lager et masterPanel som er en kombi av andre paneler
        masterPanel = new JPanel(new GridBagLayout());
        masterPanel.add(registrerTann);
        masterPanel.add(importExcelContent);
        masterPanel.add(mainContent);
        masterPanel.add(masterCenter);
        masterPanel.add(publiseringPanel);
        masterPanel.add(BeiteContent);
        masterPanel.add(VarDataContent);

       
        add(masterPanel, BorderLayout.CENTER);
        
        //Lyttere
        btnPath.addActionListener(this);
        btnLogin.addActionListener(this);
        excelInn.addActionListener(this);
        excelUt.addActionListener(this);
        publisering.addActionListener(this);
        grafer.addActionListener(this);
        multivariat.addActionListener(this);
        bivariat.addActionListener(this);
        univariat.addActionListener(this);
        settElg.addActionListener(this);
        tannanalyse.addActionListener(this);
        værdata.addActionListener(this);
        skogsanalyse.addActionListener(this);
        beiteregistrering.addActionListener(this);
        searchResult.addActionListener(this);
        btnSaveTann.addActionListener(this);
        publisering.addActionListener(this);
        SokArkiv.addActionListener(this);
        RedigerArkiv.addActionListener(this);
        
        
        //Definerer hvilket content som skal vøøøre visible og hvilke som skal vøøøre usynelige. 
        menuBar.setVisible(false);
        mainContent.setVisible(false);
        importExcelContent.setVisible(false);
        registrerTann.setVisible(false);
        masterCenter.setVisible(false);
        menuBar.setVisible(true);
        mainContent.setVisible(true);
        publiseringPanel.setVisible(false);
        BeiteContent.setVisible(false);
        VarDataContent.setVisible(false);
    
    }
    
    
    public static void main(String[] args) {
        Mats me = new Mats();
        me.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        me.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	 BufferedWriter writer;
    try {
    	 
             //skriver ut filen tannanalyse.xls, legges default i workspace mappa. 
             writer = new BufferedWriter(new FileWriter("Tannanalyse.xls",  true));
             //Henter text fra alle felter, skriver de inn i excel arket. 
             writer.write(txtFeltid.getText() + "\t" + txtValdnr.getText() + "\t" + txtValdnavn.getText() + "\t" + txtJaktfeltnr.getText() + "\t" + txtJaktfeltnavn.getText() + "\t" + txtJaktleder.getText()
            		 + "\t" + txtDato.getText()+ "\t" + txtAlder.getText()+ "\t" + txtVeidVekt.getText()+ "\t" + txtKjønn.getText()+ "\t" + txtFeltDyr.getText()+ "\t" + txtAntallKalv.getText()
            		 + "\t" + txtAntallTagger.getText()+ "\t" + txtAntattVekt.getText());
             writer.newLine();
             writer.close();
           //Tøøømmer feltene etter registrert analyse
             txtFeltid.setText("");
             txtValdnr.setText("");
             txtValdnavn.setText("");
             txtJaktfeltnr.setText("");
             txtJaktfeltnavn.setText("");
             txtJaktleder.setText("");
             txtDato.setText("");
             txtAlder.setText("");
             txtVeidVekt.setText("");
             txtKjønn.setText("");
             txtFeltDyr.setText("");
             txtAntallKalv.setText("");
             txtAntallTagger.setText("");
             txtAntattVekt.setText("");
             //Vetta fader hva det her er. 
         } catch(FileNotFoundException ex) {
             ex.printStackTrace();
         } catch (IOException ex) {
             ex.printStackTrace();
         }
   
    	
            //Ulike content til ulike menyvalg. 
    if (e.getSource() == btnSaveTann) {
    	JOptionPane.showMessageDialog(null,"Din Tannanalyse er registrert!"
    			+ "\n" + "Du kan se din registrering i Tannanalyse.xls, som du finner på skrivebordet.");
    	
    	}


            if (e.getSource() == excelInn) { 
                    
            	excelTojTable1 sr = new excelTojTable1();
            	dispose();
            	
            	
            
            }
            if (e.getSource() == publisering){
            	menuBar.setVisible(true);
            	publiseringPanel.setVisible(true);
            	mainContent.setVisible(false);
                registrerTann.setVisible(false);
                importExcelContent.setVisible(false);

            }
            
            if(e.getSource() == beiteregistrering){
        		BeiteRegistrering regFace =new BeiteRegistrering();
        		regFace.setVisible(true);
        		VarDataContent.setVisible(false);
        		dispose();
        		
        		
            }
            if(e.getSource() == SokArkiv){
            	SearchResult sr = new SearchResult();
		        sr.createUI();
            }
            if(e.getSource() == RedigerArkiv){
            	excelTojTable1 sr = new excelTojTable1();
            	dispose();
            	
            }
            
            if (e.getSource() == excelUt) { 
                
            	 masterCenter.setVisible(false);
                 menuBar.setVisible(true);
                 mainContent.setVisible(false);
                 importExcelContent.setVisible(false);
                 registrerTann.setVisible(false);
                 publiseringPanel.setVisible(false);

            }
            if (e.getSource() == værdata) { 
                
           	 	masterCenter.setVisible(false);
                menuBar.setVisible(true);
                mainContent.setVisible(false);
                VarDataContent.setVisible(true);
                BeiteContent.setVisible(false);
                registrerTann.setVisible(false);

           }
            if (e.getSource() == btnPath) {
                    
                    JFileChooser chooseFile = new JFileChooser();
                    chooseFile.showOpenDialog(null);
                    File f = chooseFile.getSelectedFile();
                    if (f != null) {
                            String filename = f.getAbsolutePath();
                            filePath.setText(filename);
                    }
                    else {
                            filePath.setText("Ingen fil valgt");
                    }
            }
            if (e.getSource() == tannanalyse) {
                    
            masterCenter.setVisible(false);
            menuBar.setVisible(true);
            mainContent.setVisible(false);
            importExcelContent.setVisible(false);
            registrerTann.setVisible(true);
            publiseringPanel.setVisible(false);
            BeiteContent.setVisible(false);
            VarDataContent.setVisible(false);
            }
           
    }   	//Metode for øøø hente data fra textfields.
            protected void saveData(){
                String feltId = this.txtFeltid.getText();
                String ValdNr = this.txtValdnr.getText();
                String ValdNavn = this.txtValdnavn.getText();
                String JaktFeltNr = this.txtJaktfeltnr.getText();
                String Jaktleder = this.txtJaktleder.getText();
                String Dato = this.txtDato.getText();
                String VeidVekt = this.txtVeidVekt.getText();
                String Kjønn = this.txtKjønn.getText();
                String AntallKalv = this.txtAntallKalv.getText();
                String FeltDyr = this.txtFeltDyr.getText();
                String AntallTagger = this.txtAntallTagger.getText();
                String AntattVekt = this.txtAntattVekt.getText();
                String Alder = this.txtAlder.getText();
                String RadioButton = this.RadioButton.getText();
               
           
                // Dataene valideres føøør de sendes til DB.    
                User user = new User(feltId, ValdNr, ValdNavn, Alder, JaktFeltNr, Jaktleder, Dato, VeidVekt, Kjønn, FeltDyr, AntattVekt, AntallKalv, AntallTagger, RadioButton); 
                boolean result = user.doUpdate(true, true);
                if(result){
                    JOptionPane.showMessageDialog(this,"Dataen er Lagt i Databasen.");
                }else{
                    JOptionPane.showMessageDialog(this,"Databasen Feilet.");
                }
            }
                protected void saveDataB(){
                    String furu = this.txtfuru.getText();
                    String bjørk = this.txtbjørk.getText();
                    String einer = this.txteiner.getText();
                    String ros = this.txtros.getText();
                    String eik = this.txteik.getText();


                    
               
                    // Dataene valideres føøør de sendes til DB.    
                    BeiteRegistrering beiteregistrering = new BeiteRegistrering(furu, bjørk, einer, eik, ros); 
                    boolean result = beiteregistrering.doUpdate(true, true);
                    if(result){
                        JOptionPane.showMessageDialog(this,"Dataen er Lagt i Databasen.");
                    }else{
                        JOptionPane.showMessageDialog(this,"Databasen Feilet.");
                    }

        }
                //SaveDatametode for vøøørdata.(vardata) 
                protected void saveDataV(){
                    String VarDataNo = this.txtVarData.getText();
                   


                    
               
                    // Dataene valideres føøør de sendes til DB.    
                    vardata VarData = new vardata(VarDataNo); 
                    boolean result = VarData.doUpdate(true, true);
                    if(result){
                        JOptionPane.showMessageDialog(this,"Dataen er Lagt i Databasen.");
                    }else{
                        JOptionPane.showMessageDialog(this,"Databasen Feilet.");
                    }

        }
    }


        

    


