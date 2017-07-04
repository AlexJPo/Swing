package com.ajp.memoryleak.application.controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.ajp.memoryleak.application.model.CustomModel;



public class TableController {
	private JFrame frame;
	private JButton addButton;
	private JButton removeButton;
	private CustomModel customModel;
	
	public void Run() {
		frame = new JFrame();		
		customModel = new CustomModel();
		
		createButton();
		
		JTable table = new JTable(customModel);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 400));
			
		frame.setLayout(new BorderLayout());
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 2));
		
		panel.add(addButton);
		panel.add(removeButton);
		
		frame.add(panel, BorderLayout.SOUTH);
		
		frame.setVisible(true);
		frame.pack();
	}
	
	private void createButton() {
		addButton = new JButton("Add 100 rows");
		addButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				customModel.addOneHundredRecords();				
			}
		});
		
		removeButton = new JButton("Remove 100 rows");
		removeButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				customModel.removeOneHundredRecords();				
			}
		});
	}
}
