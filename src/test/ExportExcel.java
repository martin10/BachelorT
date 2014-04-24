package test;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class ExportExcel {
public static void main(String[] args) {

Vector headers = new Vector();
Vector data = new Vector();

File file = new File("tannanalyse.xls");
try {
Workbook workbook = Workbook.getWorkbook(file);
Sheet sheet = workbook.getSheet(0);
headers.clear();
for (int i = 0; i < sheet.getColumns(); i++) {
Cell cell1 = sheet.getCell(i, 0);
headers.add(cell1.getContents());
}
data.clear();
for (int j = 1; j < sheet.getRows(); j++) {
Vector d = new Vector();
for (int i = 0; i < sheet.getColumns(); i++) {
Cell cell = sheet.getCell(i, j);
d.add(cell.getContents());
}
d.add("\n");
data.add(d);
}
}
catch (Exception e) {
e.printStackTrace();
}
JTable table = new JTable();
DefaultTableModel model = new DefaultTableModel(data,headers);
table.setModel(model);
table.setAutoCreateRowSorter(true);
model = new DefaultTableModel(data, headers);
table.setModel(model);
JScrollPane scroll = new JScrollPane(table);
JFrame f=new JFrame();
f.add(scroll);
f.setSize(400, 200);
f.setResizable(true);
f.setVisible(true);
}
}