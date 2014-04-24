package test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Klasse for inserting i DB. 
public class User{

    private String      feltId;
    private String		ValdNr;
    private String      ValdNavn;
    private String      Jaktleder;
    private String      Dato;
    private String		Alder;
    private String      Kjønn;
    private String      FeltDyr;
    private String      AntallTagger;
    private String      AntattVekt;
	private java.lang.String JaktFeltNr;
	private java.lang.String VeidVekt;
	private java.lang.String AntallKalv;
	private String 		RadioButton;


    private static String db_table = "tannanalyse";
    public User(String feltId, String ValdNr, String Alder, String ValdNavn, String JaktFeltNr, String Jaktleder, String Dato, String VeidVekt
    		,String Kjønn, String FeltDyr, String AntallKalv, String AntallTagger, String AntattVekt, String RadioButton) {
        this.feltId = feltId;
        this.ValdNr = ValdNr;
        this.ValdNavn = ValdNavn;
        this.Alder = Alder;
        this.JaktFeltNr = JaktFeltNr;
        this.Jaktleder = Jaktleder;
        this.Dato  = Dato;
        this.VeidVekt = VeidVekt;
        this.Kjønn = Kjønn;
        this.FeltDyr = FeltDyr;
        this.AntallKalv = AntallKalv;
        this.AntallTagger = AntallTagger;
        this.AntattVekt = AntattVekt;
        this.RadioButton = RadioButton;
          
    }
   
 
	public boolean doUpdate(boolean commit, boolean close){     
        try {           
            DBM dbm = new DBM();
            User.clientUpdate(dbm, this, close, commit);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static User getByfeltId(DBM dbm, String feltId, String ValdNr, String ValdNavn, String Alder,  String JaktFeltNr, String Jaktleder, String Dato, String VeidVekt
    		,String Kjønn, String FeltDyr, String AntallKalv, String AntallTagger, String AntattVekt, String RadioButton, boolean close) throws Exception{
        User o                 = null;
        PreparedStatement preState = null;
        ResultSet resultSet        = null;
        try {
            String sql = "SELECT * FROM "+db_table;
            preState   = dbm.initConnection().prepareStatement(sql); 
            preState.setString(1, feltId);
            preState.setString(2, ValdNr);
            preState.setString(3, ValdNavn);
            preState.setString(4, JaktFeltNr);
            preState.setString(5, Jaktleder);
            preState.setString(6, Dato);
            preState.setString(7, VeidVekt);
            preState.setString(8, Kjønn);
            preState.setString(9, FeltDyr);
            preState.setString(10, AntallKalv);
            preState.setString(11, AntallTagger);
            preState.setString(12, AntattVekt);
            preState.setString(13, Alder);
            preState.setString(14, RadioButton);
         
            resultSet  = preState.executeQuery();
           
            while (resultSet.next()) {
            
                o = new User(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),
                		resultSet.getString(8),resultSet.getString(9),resultSet.getString(10),resultSet.getString(11),resultSet.getString(12),resultSet.getString(13), resultSet.getString(14));
           

            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            if( preState != null )
                preState.close();
            if( close && dbm.connection != null )
                dbm.connection.close();         
        }
        
        return o;
    }
    

    public static boolean clientUpdate(DBM dbm, User o, boolean close, boolean commit) throws Exception{        
        boolean returnValue = true;
        PreparedStatement preState = null;
        try {
            User dbo = getByfeltId(dbm,o.getfeltId(), o.getValdNr(), o.getValdNavn(), o.getJaktFeltNr(), 
            		o.getJaktleder(), o.getDato(),o.getAlder(), o.getVeidVekt(), o.getKjønn(), o.getFeltDyr(),o.getAntallKalv(), o.getAntallTagger(), o.getAntattVekt(), o.getRadioButton(), false);           
            if(dbo==null){
                String sql = null;
               

                //SQL insert spøøørringen og rekkeføøølgen pøøø hvordanden skal tolke stringene
                sql = "INSERT INTO tannanalyse (feltId, Valdnr, ValdNavn, JaktFeltNr, Jaktleder, Dato, Alder, VeidVekt, Kjøøønn, FeltDyr, AntallKalv, AntallTagger, AntattVekt, unchecked) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                preState = dbm.initConnection().prepareStatement(sql); 
                preState.setString(1, o.getfeltId());
                preState.setString(2, o.getValdNr());
                preState.setString(7, o.getValdNavn());
                preState.setString(4, o.getJaktFeltNr());
                preState.setString(5, o.getJaktleder());
                preState.setString(6, o.getDato());     
                preState.setString(3, o.getAlder());
                preState.setString(8, o.getVeidVekt());
                preState.setString(9, o.getKjønn());
                preState.setString(10, o.getFeltDyr());
                preState.setString(13, o.getAntallKalv());
                preState.setString(11, o.getAntallTagger());
                preState.setString(12, o.getAntattVekt()); 
                preState.setString(14, o.getRadioButton());
                preState.executeUpdate();
            }else{              
                String sql = null;
                sql = "UPDATE  "+db_table+" set _feltId=?";
                preState = dbm.initConnection().prepareStatement(sql); 
                      //Ikke køøødd med rekkeføøølgen, dette funker. 
                preState.setString(1, o.getfeltId());
                preState.setString(2, o.getValdNr());
                preState.setString(7, o.getValdNavn());
                preState.setString(4, o.getJaktFeltNr());
                preState.setString(5, o.getJaktleder());
                preState.setString(6, o.getDato());     
                preState.setString(3, o.getAlder());
                preState.setString(8, o.getVeidVekt());
                preState.setString(9, o.getKjønn());
                preState.setString(10, o.getFeltDyr());
                preState.setString(13, o.getAntallKalv());
                preState.setString(11, o.getAntallTagger());
                preState.setString(12, o.getAntattVekt());
                preState.setString(14, o.getRadioButton());

            }
        }catch (Exception e) {
            returnValue = false; 
            e.printStackTrace();
        }finally{
            if( preState != null )
                preState.close();
            if( dbm.connection != null ){
                if( commit ){
                    if( returnValue )
                        dbm.connection.commit();
                    else
                        dbm.connection.rollback();
                }
                if( close )
                    dbm.connection.close();
            }
        }
        return returnValue;
    }


//Get og set for alle stringene. 
	public String getAntallTagger() {
        return AntallTagger;
    }
    public void setAntallTagger(String AntallTagger) {
        this.AntallTagger = AntallTagger;
    }
    public String getAntattVekt() {
        return AntattVekt;
    }
    public void setAntattVekt(String AntattVekt) {
        this.AntattVekt = AntattVekt;
    }
    public void setValdNavn(String ValdNavn) {
        this.ValdNavn = ValdNavn;
    }
    public String getValdNavn() {
        return ValdNavn;
    }
    public void setJaktleder(String Jaktleder) {
        this.Jaktleder = Jaktleder;
    }
    public String getJaktleder() {
        return Jaktleder;
    }
    public void setDato(String Dato) {
        this.Dato = Dato;
  
    }
    public String getDato() {
        return Dato;
    }
    public void setKjønn(String Kjønn) {
        this.Kjønn = Kjønn;
    }
    public String getKjønn() {
        return Kjønn;
    }
    public void setFeltDyr(String FeltDyr) {
        this.FeltDyr = FeltDyr;
    }
    public String getFeltDyr() {
        return FeltDyr;
    }
    public void setJaktFeltNr(String JaktFeltNr) {
        this.JaktFeltNr = JaktFeltNr;
    }
    public String getJaktFeltNr() {
        return JaktFeltNr;
    }
    public void setValdtNr(String ValdNr) {
        this.ValdNr = ValdNr;
  
    }
    public String getfeltId() {
        return feltId;
    }
    public void setfeltId(String feltId) {
        this.feltId = feltId;
    }
    public String getValdNr() {
        return ValdNr;
    }
    public void setVeidVekt(String VeidVekt) {
        this.VeidVekt = VeidVekt;
    }  
    public String getVeidVekt() {
        return VeidVekt;
    }
    public void setAntallKalv(String AntallKalv) {
        this.AntallKalv = AntallKalv;
    }
    public String getAntallKalv() {
        return AntallKalv;
    }
    public void setAlder(String Alder) {
        this.Alder = Alder;
    }
    public String getAlder() {
        return Alder;
    }
    public void setRadioButton(String RadioButton){
    	this.RadioButton = RadioButton;
    }
    private String getRadioButton() {
		return RadioButton;
	}

  
}
