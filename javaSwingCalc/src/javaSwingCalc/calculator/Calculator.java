package javaSwingCalc.calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator {
	private int firstValue;
	private String operation;
	private int secondValue;
	
	private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bPlus, bMinus, bMulty, bDivide, bSumm, bReset;
	private JTextField resultText;
	
	private ButtonActionListenerNumber buttonActionNumber;
	private ButtonActionListenerOperation buttonActionOperation;
	
	public void Run() {
		JFrame calculatorFram = new JFrame();
		BorderLayout borderLayut = new BorderLayout();		
		resultText = new JTextField("");
		
		calculatorFram.setLayout(borderLayut);
		
		setCalculatorElements(calculatorFram);
		
		calculatorFram.setSize(300, 150);
		calculatorFram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculatorFram.setVisible(true);
		calculatorFram.pack();
	}
	/**
	 * Add Components(JButtons, JTextField) on form(JFrame)
	 * @param JFrame frame - current form
	 * 
	 */
	private void setCalculatorElements(JFrame frame) {
		JPanel panelButtonNumber = new JPanel();
		JPanel panelButtonAction = new JPanel();
		
		panelButtonNumber.setLayout(new GridLayout(3, 4));
		panelButtonAction.setLayout(new GridLayout(5, 1));
		
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		bSumm = new JButton("=");

		bReset = new JButton("C");
		bPlus = new JButton("+");
		bMinus = new JButton("-");
		bMulty = new JButton("*");
		bDivide = new JButton("/");		
		
		addButtonEvents();
		
		panelButtonNumber.add(b0, BorderLayout.CENTER);
		panelButtonNumber.add(b1, BorderLayout.CENTER);
		panelButtonNumber.add(b2, BorderLayout.CENTER);
		panelButtonNumber.add(b3, BorderLayout.CENTER);
		panelButtonNumber.add(b4, BorderLayout.CENTER);
		panelButtonNumber.add(b5, BorderLayout.CENTER);
		panelButtonNumber.add(b6, BorderLayout.CENTER);
		panelButtonNumber.add(b7, BorderLayout.CENTER);
		panelButtonNumber.add(b8, BorderLayout.CENTER);
		panelButtonNumber.add(b9, BorderLayout.CENTER);
		frame.add(bSumm, BorderLayout.SOUTH);
		
		panelButtonAction.add(bReset, BorderLayout.EAST);
		panelButtonAction.add(bPlus, BorderLayout.EAST);
		panelButtonAction.add(bMinus, BorderLayout.EAST);
		panelButtonAction.add(bMulty, BorderLayout.EAST);
		panelButtonAction.add(bDivide, BorderLayout.EAST);
		
		frame.add(panelButtonNumber, BorderLayout.CENTER);
		frame.add(panelButtonAction, BorderLayout.EAST);
		frame.add(resultText, BorderLayout.NORTH);
	}
	/**
	 * Add JButton ActionListener
	 */
	private void addButtonEvents() {
		buttonActionNumber = new ButtonActionListenerNumber();
		buttonActionOperation = new ButtonActionListenerOperation();
		
		b0.addActionListener(buttonActionNumber);
		b1.addActionListener(buttonActionNumber);
		b2.addActionListener(buttonActionNumber);
		b3.addActionListener(buttonActionNumber);
		b4.addActionListener(buttonActionNumber);
		b5.addActionListener(buttonActionNumber);
		b6.addActionListener(buttonActionNumber);
		b7.addActionListener(buttonActionNumber);
		b8.addActionListener(buttonActionNumber);
		b9.addActionListener(buttonActionNumber);
		
		bPlus.addActionListener(buttonActionOperation);
		bMinus.addActionListener(buttonActionOperation);
		bMulty.addActionListener(buttonActionOperation);
		bDivide.addActionListener(buttonActionOperation);
		
		bSumm.addActionListener(new ButtonActionListenerResult());		
		bReset.addActionListener(new ButtonActionListenerReset());
	}
	/**
	 * ActionListener class for JButton components for numbers(0 - 9) 
	 */
	private class ButtonActionListenerNumber implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			JButton currentButton = (JButton) event.getSource();
			resultText.setText(resultText.getText() + currentButton.getText());
		}		
	}
	/**
	 * ActionListener class for JButton components for operations(+, -, *, /) 
	 */
	private class ButtonActionListenerOperation implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			JButton currentButton = (JButton) event.getSource();
			
			firstValue = Integer.valueOf(resultText.getText());
			operation = currentButton.getText();
			resultText.setText("");			
		}		
	}
	/**
	 * ActionListener class for JButton component for reset 
	 */
	private class ButtonActionListenerReset implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			resultText.setText("");
		}		
	}
	/**
	 * ActionListener class for JButton component for result(=) 
	 */
	private class ButtonActionListenerResult implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			secondValue = Integer.valueOf(resultText.getText());
			
			switch (operation) {
				case "+":
					resultText.setText(String.valueOf(firstValue + secondValue));
					break;
				case "-":
					resultText.setText(String.valueOf(firstValue - secondValue));
					break;
				case "*":
					resultText.setText(String.valueOf(firstValue * secondValue));
					break;
				case "/":
					resultText.setText(String.valueOf(firstValue / secondValue));
					break;
			}
		}		
	}
	
}
