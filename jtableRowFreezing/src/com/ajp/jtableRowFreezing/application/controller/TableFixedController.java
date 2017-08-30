package com.ajp.jtableRowFreezing.application.controller;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;

import com.ajp.jtableRowFreezing.application.model.CustomModel;
import com.ajp.jtableRowFreezing.application.model.CustomModel2;

public class TableFixedController {
	private JFrame frame;
	private CustomModel customModel;
	private CustomModel2 customModel2;
	
	private JTable table, fixedTable;
	
	public void Run() {
		frame = new JFrame();
		
		customModel = new CustomModel();
		customModel2 = new CustomModel2();
		
		table = new JTable(customModel2);
		fixedTable = new JTable(customModel);

		fixedTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    fixedTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	    JScrollPane scrollPane = new JScrollPane(table);
	    JViewport viewport = new JViewport();
	    
	    viewport.setView(fixedTable);
	    viewport.setPreferredSize(fixedTable.getPreferredSize());
	    
	    scrollPane.setRowHeaderView(viewport);
	    scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, fixedTable.getTableHeader());
		
		frame.setLayout(new BorderLayout());
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(scrollPane, BorderLayout.CENTER);
				
		frame.setVisible(true);
		frame.pack();
	}
}
