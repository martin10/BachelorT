package test;


import java.sql.*;


public class Arkiv extends Mats{


public static void main(String[] args) {
	@SuppressWarnings("unused")
	main frameTabel = new main();
	}

	Arkiv(){
	
	
	setSize(800,600);
	setLocation(500,280);

    
    
	//Henter content fra panel og setter visible til true slik at det vises
	mainContent.setVisible(false);
	publiseringPanel.setVisible(true);
	
	}
	public static void viewTable(Connection con, String dbName)
		    throws SQLException {

		    Statement stmt = null;
		    String query =
		        "select * from tannanalyse";

		    try {
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		            String coffeeName = rs.getString("COF_NAME");
		            int supplierID = rs.getInt("SUP_ID");
		            float price = rs.getFloat("PRICE");
		            int sales = rs.getInt("SALES");
		            int total = rs.getInt("TOTAL");
		            System.out.println(coffeeName + "\t" + supplierID +
		                               "\t" + price + "\t" + sales +
		                               "\t" + total);
		        }
		    } catch (SQLException e ) {
		      
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }
		}
	
}
    