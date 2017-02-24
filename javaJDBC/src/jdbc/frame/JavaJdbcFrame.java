package jdbc.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import jdbc.dao.SpectrAero;
import jdbc.table.model.UserRoutes;
import jdbc.table.model.UserRoutesModel;

public class JavaJdbcFrame {
	private JFrame frame;
	private JTable table;
	
	private SpectrAero spectrAero;
	private UserRoutesModel userRoutesModel;
		
	public void run() {
		frame = new JFrame("Data base viewer");
		BorderLayout borderLayout = new BorderLayout(); 
		
		frame.setLayout(borderLayout);
		
		setSearchComponent();
		setTableComponent();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(600, 400);
		frame.setMinimumSize(new Dimension(600, 400));
		frame.setVisible(true);
		frame.pack();
		
		try {
			spectrAero = new SpectrAero();
			
			userRoutesModel = new UserRoutesModel(spectrAero.getAllUserRoutes());
			table.setModel(userRoutesModel);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void setSearchComponent() {		
		JTextField searchTextField = new JTextField();
		searchTextField.setPreferredSize(new Dimension(100, 25));
		
		JButton searchBtn = new JButton("Search");
		searchBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String searchValue = searchTextField.getText();
				List<UserRoutes> userRoutesList = new ArrayList<UserRoutes>();
				
				try {
					if (searchValue.equals("")) {
						userRoutesList = spectrAero.getAllUserRoutes();
					} else {
						userRoutesList = spectrAero.findUserRoutes(searchValue);
					}
					
					userRoutesModel = new UserRoutesModel(userRoutesList);
					table.setModel(userRoutesModel);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frame, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
				}				
			}
		});
	
		JPanel searchPanel = new JPanel();
		
		searchPanel.add(searchTextField);
		searchPanel.add(searchBtn);
		
		frame.add(searchPanel, BorderLayout.NORTH);
	}
	
	private void setTableComponent() {
		table = new JTable();
		JPanel panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane);
		
		frame.add(panel, BorderLayout.WEST);		
	}
}
