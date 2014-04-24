package test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;


public class BeiteRegistrering extends Mats {


	
    public BeiteRegistrering(String furu, String bjørk, String ros, String eik, String einer) {
    	
    	  this.furu = furu;
    	  this.bjørk = bjørk;
    	  this.ros = ros;
    	  this.eik = eik;
    	  this.einer = einer;

    
	}
    private static String db_table = "beiteregistrering";

	private JTextField txtBeiteRegistrering; 
	private String furu, bjørk, ros, eik, einer;
	private JPanel Panel1; 
	private JLabel beiteContent;
	private JButton btnSaveDBB;
	private JTextArea info1;

		public static void main(String[] args) {
		@SuppressWarnings("unused")
		main frameTabel = new main();
		}
	
		BeiteRegistrering(){
		
		
		setSize(800,600);
		setLocation(500,280);
		
		
		Panel1 = new JPanel();
        JTextArea info1 = new JTextArea("her kommer UI til publisering");
     
		txtBeiteRegistrering = new JTextField(10);
	    

        Panel1.add(info1);
        

	    
	    
		//Henter content fra panel og setter visible til true slik at det vises
		BeiteContent.setVisible(true);
    	mainContent.setVisible(false);
    	Panel1.setVisible(false);
    	VarDataContent.setVisible(false);
		}


		
	    
		public boolean doUpdate(boolean commit, boolean close){     
	        try {           
	            DBM dbm = new DBM();
	            BeiteRegistrering.clientUpdate(dbm, this, close, commit);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    public static BeiteRegistrering getByBeite(DBM dbm, String furu, String bjørk, String ros, String eik, String einer,  boolean close) throws Exception{
	        BeiteRegistrering b                 = null;
	        PreparedStatement preState = null;
	        ResultSet resultSet        = null;
	        try {
	            String sql = "SELECT * FROM "+db_table;
	            preState   = dbm.initConnection().prepareStatement(sql); 
	            preState.setString(1, furu);
	            preState.setString(2, bjørk);
	            preState.setString(3, ros);
	            preState.setString(4, eik);
	            preState.setString(5, einer);

	            	
	           
	         
	            resultSet  = preState.executeQuery();
	            while (resultSet.next()) {
	            
	                b = new BeiteRegistrering(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
	            }
	        }catch (Exception e) {
	            e.printStackTrace();
	        }finally{
	            if( preState != null )
	                preState.close();
	            if( close && dbm.connection != null )
	                dbm.connection.close();         
	        }
	        return b;
	    }

	    public static boolean clientUpdate(DBM dbm, BeiteRegistrering b, boolean close, boolean commit) throws Exception{        
	        boolean returnValue = true;
	        PreparedStatement preState = null;
	        try {
	            BeiteRegistrering dbo = getByBeite(dbm,b.getfuru(), b.getbjørk(), b.getros(), b.geteik(), b.geteiner(), false);           
	            if(dbo==null){
	                String sql = null;
	               

	                //SQL insert spøøørringen og rekkeføøølgen pøøø hvordanden skal tolke stringene
	                sql = "INSERT INTO beiteregistrering (furu, bjøøørk, ros, eik, einer) VALUES (?, ?, ?, ?, ?)";
	                preState = dbm.initConnection().prepareStatement(sql); 
	               
	                preState.setString(1, b.getfuru());
	                preState.setString(2, b.getbjørk());
	                preState.setString(3, b.getros());
	                preState.setString(4, b.geteik());
	                preState.setString(5, b.geteiner());	                
	                preState.executeUpdate();
	            }else{              
	                String sql = null;
	                sql = "UPDATE  "+db_table+" set _beiteregistrering=?";
	                preState = dbm.initConnection().prepareStatement(sql); 
	                      //Ikke køøødd med rekkeføøølgen, dette funker. 
	                preState.setString(1, b.getfuru());
	                preState.setString(2, b.getbjørk());
	                preState.setString(3, b.getros());
	                preState.setString(4, b.geteik());
	                preState.setString(5, b.geteiner());

	               
	                
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
		public String getfuru() {
	        return furu;
	    }
	    public void setfuru(String furu) {
	        this.furu = furu;
	    }
		public String getbjørk() {
	        return bjørk;
	    }
	    public void setbjørk(String bjørk) {
	        this.bjørk = bjørk;
	    }
		public String getros() {
	        return ros;
	    }
	    public void setros(String ros) {
	        this.ros = ros;
	    }
		public String geteik() {
	        return eik;
	    }
	    public void seteik(String eik) {
	        this.eik = eik;
	    }
		public String geteiner() {
	        return einer;
	    }
	    public void seteiner(String einer) {
	        this.einer = einer;
	    }
	    

}
