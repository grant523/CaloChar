package sample;

// GUI Class

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class CaloChar extends JFrame implements ActionListener {
    JPanel panel;
    JRadioButton ham, cheese, dblHam, dblCheese;
    String[] columnNames = {"Metric", "Restaurants", "Amount"};
    String[][] data = {{"","",""}, {"","",""}, {"","",""}};
    JTable table;
    DefaultTableModel model = new DefaultTableModel(data, columnNames);

    public static void main(String args[]) {
        new CaloChar();
    }

    public CaloChar() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setSize(700, 400);
        this.setTitle("CaloChar");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel = new JPanel();

        JLabel label = new JLabel("What would you like to eat?");
        panel.add(label);

        ButtonGroup sel = new ButtonGroup();

        ham = new JRadioButton("Hamburger");
        ham.addActionListener(this);
        sel.add(ham);

        cheese = new JRadioButton("Cheeseburger");
        cheese.addActionListener(this);
        sel.add(cheese);

        dblHam = new JRadioButton("Double Hamburger");
        dblHam.addActionListener(this);
        sel.add(dblHam);

        dblCheese = new JRadioButton("Double Cheeseburger");
        dblCheese.addActionListener(this);
        sel.add(dblCheese);

        Box selBox = Box.createVerticalBox();

        selBox.add(ham);
        selBox.add(cheese);
        selBox.add(dblHam);
        selBox.add(dblCheese);
        panel.add(selBox);

        table = new JTable(model);

        model.fireTableDataChanged();
        Dimension d = new Dimension(400, table.getRowCount() * table.getRowHeight());
        JScrollPane scrollPane = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(d);
        panel.add(scrollPane);

        this.add(panel);
        this.pack();
    }

    public void actionPerformed(ActionEvent e) {
        data = App.returnData(e.getActionCommand());
        model = new DefaultTableModel(data, columnNames);
        table.setModel(model);
    }
}

