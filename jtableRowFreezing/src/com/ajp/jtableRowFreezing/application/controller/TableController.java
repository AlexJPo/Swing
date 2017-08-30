package com.ajp.jtableRowFreezing.application.controller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;

import com.ajp.jtableRowFreezing.application.model.ColTableModel;
import com.ajp.jtableRowFreezing.application.model.RowTableModel;

public class TableController {
	private JFrame frame;
	private JButton addButton;
	private JButton removeButton;
	private ColTableModel customModel;
	private RowTableModel rowTableModel;
	
	public void Run() {
		frame = new JFrame();
		
		rowTableModel = new RowTableModel();
		customModel = new ColTableModel(rowTableModel.getSize());

		JTable table = new JTable(customModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JList rowHeader = new JList(rowTableModel);   
	    rowHeader.setFixedCellWidth(50);
	     
	    rowHeader.setFixedCellHeight(table.getRowHeight() + table.getRowMargin());
	    rowHeader.setCellRenderer(new RowHeaderRenderer(table));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setRowHeaderView(rowHeader);
		//scrollPane.setPreferredSize(new Dimension(400, 400));
		
		frame.setLayout(new BorderLayout());
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(scrollPane, BorderLayout.CENTER);
				
		frame.setVisible(true);
		frame.pack();
	}
	
	class RowHeaderRenderer extends JLabel implements ListCellRenderer {		   
		  RowHeaderRenderer(JTable table) {
			  JTableHeader header = table.getTableHeader();
			  
			  setOpaque(true);
			  setBorder(UIManager.getBorder("TableHeader.cellBorder"));
			  setHorizontalAlignment(CENTER);
			  setForeground(header.getForeground());
			  setBackground(header.getBackground());
			  setFont(header.getFont());
		  }
		   
		  public Component getListCellRendererComponent( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			  setText((value == null) ? "" : value.toString());
			  return this;
		  }
	}
}
