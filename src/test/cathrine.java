package test;
import java.awt.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import java.awt.event.*;
//Klasse 
public class cathrine extends SearchResult implements ActionListener
{
    public void cathrine()
    {
        Vector columnNames = new Vector();
        Vector data = new Vector();

        try
        {
            //  Connect to an Access Database

  

        	String driver = "com.mysql.jdbc.Driver";
        	String url = "jdbc:mysql://sql4.freemysqlhosting.net/sql435045";
        	String userid = "sql435045";
        	String password = "mG2%nR5!";

            Class.forName( driver );
            Connection connection = DriverManager.getConnection( url, userid, password );

            //  Read data from a table

           
            String sql = "Select * from tannanalyse where FeltDyr = ''  or Kj??nn = ''  or FeltId = '' or ValdNr = ''  or ValdNavn = '' or JaktFeltNr = '' or JaktLeder = '' or Dato = '' or VeidVekt = '' or AntallKalv = '' or AntallTagger = ''  or AntattVekt = ''";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names

            for (int i = 1; i <= columns; i++)
            {
                columnNames.addElement( md.getColumnName(i) );
            }

            //  Get row data

            while (rs.next())
            {
                Vector row = new Vector(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.addElement( rs.getObject(i) );
                }

                data.addElement( row );
            }

            rs.close();
            stmt.close();
            connection.close();
        }
        catch(Exception e)
        {
            System.out.println( e );
        }

        //  Create table with database data

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

    public static void main(String[] args)
    {
        cathrine frame = new cathrine();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}