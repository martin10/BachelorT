package test;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;
import java.util.Vector;
import java.awt.event.*;

@SuppressWarnings("serial")
public class SearchResult extends Mats implements ActionListener{
	JFrame frame3, frame2, frame4;
	JTextField txtSearch;
	JLabel label, labelU ;
	JButton btnSearch, btnSearchU;
	JPanel panel, SearchContent;
	
	static JTable table;
	//Globale variabler for DB tilkobling 
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://sql4.freemysqlhosting.net/sql435045";
	String userName = "sql435045";
	String password = "mG2%nR5!";
	String[] columnVIDs = {"vardata", "VID"};
	String[] tannanalyse = {"FeltId", "ValdNr", "ValdNavn", "JaktFeltNr", "JaktLeder", "Dato", "Alder", "VeidVekt", "Kj??nn", "FeltDyr", "AntallKalv", "AntallTagger", "AntattVekt", "unchecked"};
	
	public void createUI()
	{
		JFrame frame = new JFrame("Database søk resultat");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		txtSearch = new JTextField();
		txtSearch.setBounds(310,250,150,20); 
		label = new JLabel("Søk etter værdata");

		label.setBounds(330, 140, 200, 200);
		btnSearch = new JButton("Søk");
		btnSearchU = new JButton("Søk etter ufullstendige rader");
		btnSearch.setBounds(340,290, 80, 20);
		btnSearchU.setBounds(280, 370, 220, 20);
		btnSearch.addActionListener(this);
		btnSearchU.addActionListener(this);

		frame.add(txtSearch);
		frame.add(label);
		frame.add(btnSearch);
		frame.add(btnSearchU);
		
		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.setLocation(500, 200);
		
		
	}	
	
	public void actionPerformed1(ActionEvent ae)
	{
		btnSearch = (JButton)ae.getSource();
		System.out.println("Viser tabelldata");
			showTableData();
	  }





	public void showTableData()
	{
		
		frame2 = new JFrame("Database Search Result");
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setLayout(new BorderLayout());		
		//TableModel tm = new TableModel();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnVIDs);
		//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnVIDs());		
		//table = new JTable(model);
		table = new JTable();
		table.setModel(model);		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);		
		String textvalue = txtSearch.getText();
		String roll= "";
		String VID= "";
	
		try
		{			
			Class.forName(driverName);		
			Connection con = DriverManager.getConnection(url, userName, password);
			String sql = "select * from vardata where vardata = "+textvalue;
			PreparedStatement ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        int i =0;
			if(rs.next())
	        {
				roll = rs.getString("vardata");
				VID = rs.getString("VID");
									
				model.addRow(new Object[]{roll, VID });
				i++;				
	        }
			if(i <1)
			{
				JOptionPane.showMessageDialog(null, "Ingen treff","Error",
						JOptionPane.ERROR_MESSAGE);
			}
			if(i ==1)
			{
			System.out.println(i+" treff funnet");
			}
			else
			{
				System.out.println(i+" treff funnet");
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
		}
		frame2.add(scroll);
		frame2.setVisible(true);
		frame2.setSize(400,300);
		frame2.setLocation(500,280);
	        setResizable(false);
	    
	}
	//Actionperformed for s??????k etter ufullstendig. Fungerer ikke. 
	@Override
	public void actionPerformed(ActionEvent e)
	{
		btnSearchU = (JButton)e.getSource();
		System.out.println("Viser alltabelldata");
			showTableDataU();
}
	//Denne metoden vil ikke kj??????re, ufullstendig metode. 
	public void showTableDataU()
    {
        Vector columnNames = new Vector();
        Vector data = new Vector();

        try
        {
            // Lager access til database. 
            Class.forName(driverName);
            Connection connection = DriverManager.getConnection(url, userName, password);

            //  Leser data fra database utfra gitt sp??????rring. 

            String sqlU = "Select * from tannanalyse where FeltDyr = ''  or Kjønn = ''  or FeltId = '' or ValdNr = ''  or ValdNavn = '' or JaktFeltNr = '' or JaktLeder = '' or Dato = '' or VeidVekt = '' or AntallKalv = '' or AntallTagger = ''  or AntattVekt = ''";
            Statement stmt = connection.createStatement();
            ResultSet rsU = stmt.executeQuery(sqlU);
            ResultSetMetaData mdU = rsU.getMetaData();
            int columns = mdU.getColumnCount();

            //  Henter column navn basert p?????? sp??????rring. 

            for (int i = 1; i <= columns; i++)
            {
                columnNames.addElement( mdU.getColumnName(i));
            }

            //  Henter data fra sp??????rringen. 

            while (rsU.next())
            {
                Vector row = new Vector(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.addElement( rsU.getObject(i) );
                }

                data.addElement(row);
            }

            rsU.close();
            stmt.close();
            connection.close();
        }
        catch(Exception e)
        {
            System.out.println( e );
        }

        //  Lager et view med data, basert p?????? sp??????rringen. 

        JTable table = new JTable(data, columnNames)
      
        {
            @Override
			public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };

        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );

        JPanel buttonPanel = new JPanel();
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
    }
	
	public static void main(String args[])
	{
		SearchResult sr = new SearchResult();
		        sr.createUI();
		        
	}
}
