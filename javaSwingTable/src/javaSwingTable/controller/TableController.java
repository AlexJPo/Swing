package javaSwingTable.controller;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javaSwingTable.model.TableModel;

public class TableController {
	public void Run() {
		JFrame frame = new JFrame();
		
		TableModel personsTable = new TableModel();
		
		JTable table = new JTable(personsTable);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 400));
			
		frame.setLayout(new BorderLayout());
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(scrollPane);
		
		frame.setVisible(true);
		frame.pack();
	}
}
