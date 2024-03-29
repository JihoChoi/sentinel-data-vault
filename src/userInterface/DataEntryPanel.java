package userInterface;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.event.TreeSelectionEvent;

import controllers.DatabaseManager;
import dataManagement.DataEntry;

import net.miginfocom.swing.MigLayout;



public class DataEntryPanel extends JPanel{
	//private JPanel panel = new JPanel();
	private JPanel panel = new JPanel();
	private JLabel info = new JLabel("Select Data Entry");
	public DataEntryPanel() {
		
		initialize();
		// getCreditCardPanel();
		
	}
	
	public void initialize() {
		
	}
	
/*
	public JPanel getAccountLoginPanel(DataEntry data){
			
		panel.removeAll();	
		panel.setLayout(new MigLayout("", "[grow]", "[][][][][][][][][][][][]"));
		
		String title = "Account Login";
		
		JLabel label_0 = new JLabel(title);
		panel.add(label_0, "cell 0 0");
		
		JLabel label_1 = new JLabel("User Name");
		panel.add(label_1, "cell 0 1");
		
		JFormattedTextField formattedTextField1 = new JFormattedTextField();
		formattedTextField1.setText("username@gmail.com");
		panel.add(formattedTextField1, "cell 0 2,growx");
		
		JLabel label_2 = new JLabel("Password");
		panel.add(label_2, "cell 0 3");
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setText("password");
		panel.add(formattedTextField_1, "cell 0 4,growx");
		
		JLabel label_3 = new JLabel("Web URL");
		panel.add(label_3, "cell 0 5");
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setText("https://www.google.com");
		panel.add(formattedTextField, "cell 0 6,growx");
		
		
		
		
		return panel;
	}
	*/
	
	public JPanel getAccountLoginPanelWithData(DataEntry data){
		
		panel.removeAll();	
		panel.setLayout(new MigLayout("", "[grow]", "[][][][][][][][][][][][]"));
		
		String title = "Account Login";
		
		JLabel label_0 = new JLabel(title);
		panel.add(label_0, "cell 0 0");
		
		JLabel label_1 = new JLabel("User Name");
		panel.add(label_1, "cell 0 1");
		
		JFormattedTextField formattedTextField1 = new JFormattedTextField();
		formattedTextField1.setText(data.getFieldDataList().get(0));
		panel.add(formattedTextField1, "cell 0 2,growx");
		
		JLabel label_2 = new JLabel("Password");
		panel.add(label_2, "cell 0 3");
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setText(data.getFieldDataList().get(1));
		panel.add(passwordField, "cell 0 4,growx");
		passwordField.setEditable(false);
		passwordField.putClientProperty("JPasswordField.cutCopyAllowed",true);
		
		char a = passwordField.getEchoChar();

		JCheckBox chckbxShowPassword = new JCheckBox("Show Password");
		chckbxShowPassword.setBounds(130, 176, 128, 23);

		chckbxShowPassword.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					passwordField.setEchoChar((char)0);
				} else {
					passwordField.setEchoChar(a); 
				}
			}
		});
		panel.add(chckbxShowPassword, "cell 0 5,growx");
		
		JLabel label_3 = new JLabel("Web URL");
		panel.add(label_3, "cell 0 6");
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setText(data.getFieldDataList().get(2));
		panel.add(formattedTextField, "cell 0 7,growx");
		
		JButton btnEditData = new JButton("Edit Entry");
		btnEditData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DatabaseManager dm = new DatabaseManager("vault_database");
				EditDataEntryView editDataEntry = new EditDataEntryView(dm.retrieveUserFromDatabase(data.getOwner()), data);
				editDataEntry.getJframe().setVisible(true);
			}
		});
		btnEditData.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		
		JButton btnShareData = new JButton("Share Entry");
		btnShareData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(data != null){
					DatabaseManager dm = new DatabaseManager("vault_database");
					ShareView share = new ShareView(dm.retrieveUserFromDatabase(data.getOwner()), data);
					share.setLocationRelativeTo(null);
					share.setVisible(true);
				}
			}
		});
		btnShareData.setFont(new Font("Lucida Grande", Font.PLAIN, 10));

		panel.add(btnEditData, "cell 0 8,growx");
		panel.add(btnShareData, "cell 0 8,growx");
		
		return panel;
	}
	/*
	
	public JPanel getCreditCardPanel(DataEntry data) {
		panel.removeAll();	
		panel.setLayout(new MigLayout("", "[grow]", "[][][][][][][][][][][][]"));
		
		String title = "Card Name";
		
		JLabel label_0 = new JLabel(title);
		panel.add(label_0, "cell 0 0");
		
		JLabel label_1 = new JLabel("Card Type");
		panel.add(label_1, "cell 0 1");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"American Express", "MasterCard", "Discovery", "Visa"}));
		panel.add(comboBox, "cell 0 2,growx");
		
		JLabel label_2 = new JLabel("Card Number");
		panel.add(label_2, "cell 0 3");
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setText("**** **** **** ****");
		panel.add(formattedTextField, "cell 0 4,growx");
		
		JLabel label_3 = new JLabel("Name on Card");
		panel.add(label_3, "cell 0 5");
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setText("Name");
		panel.add(formattedTextField_1, "cell 0 6,growx");
		
		JLabel label_4 = new JLabel("CVV");
		panel.add(label_4, "cell 0 7");
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setText("* * *");
		panel.add(formattedTextField_2, "cell 0 8,growx");
		
		JLabel label_5 = new JLabel("Expiration Date");
		panel.add(label_5, "cell 0 9");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"01 ", "02 ", "03 ", "04 ", "05", "06 ", "07 ", "08 ", "09 ", "10", "11 ", "12"}));
		panel.add(comboBox_1, "cell 0 10,growx");
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		panel.add(comboBox_2, "cell 0 10,growx");
		
		
		return panel;
		
	}*/
	
	public JPanel getCreditCardPanelWithData(DataEntry data) {
		panel.removeAll();	
		panel.setLayout(new MigLayout("", "[grow]", "[][][][][][][][][][][][]"));
		
		String title = "Card Name";
		
		JLabel label_0 = new JLabel(title);
		panel.add(label_0, "cell 0 0");
		
		JLabel label_1 = new JLabel("Card Type");
		panel.add(label_1, "cell 0 1");
		
		JComboBox comboBox = new JComboBox();
		String cardType = data.getFieldDataList().get(0);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {cardType}));
		
		panel.add(comboBox, "cell 0 2,growx");
		
		JLabel label_2 = new JLabel("Card Number");
		panel.add(label_2, "cell 0 3");
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setText(data.getFieldDataList().get(1));
		panel.add(formattedTextField, "cell 0 4,growx");
		
		JLabel label_3 = new JLabel("Name on Card");
		panel.add(label_3, "cell 0 5");
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setText(data.getFieldDataList().get(2));
		panel.add(formattedTextField_1, "cell 0 6,growx");
		
		JLabel label_4 = new JLabel("CVV");
		panel.add(label_4, "cell 0 7");
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setText(data.getFieldDataList().get(3));
		panel.add(formattedTextField_2, "cell 0 8,growx");
		
		JLabel label_5 = new JLabel("Expiration Date");
		panel.add(label_5, "cell 0 9");
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setText(data.getFieldDataList().get(4));
		panel.add(formattedTextField_3, "cell 0 10,growx");
		/*
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"01 ", "02 ", "03 ", "04 ", "05", "06 ", "07 ", "08 ", "09 ", "10", "11 ", "12"}));
		panel.add(comboBox_1, "cell 0 10,growx");
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		panel.add(comboBox_2, "cell 0 10,growx");
		*/
		
		JButton btnEditData = new JButton("Edit Entry");
		btnEditData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DatabaseManager dm = new DatabaseManager("vault_database");
				EditDataEntryView editDataEntry = new EditDataEntryView(dm.retrieveUserFromDatabase(data.getOwner()), data);
				editDataEntry.getJframe().setVisible(true);
			}
		});
		btnEditData.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		
		JButton btnShareData = new JButton("Share Entry");
		btnShareData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(data != null){
					DatabaseManager dm = new DatabaseManager("vault_database");
					ShareView share = new ShareView(dm.retrieveUserFromDatabase(data.getOwner()), data);
					share.setLocationRelativeTo(null);
					share.setVisible(true);
				}
			}
		});
		btnShareData.setFont(new Font("Lucida Grande", Font.PLAIN, 10));

		panel.add(btnEditData, "cell 0 11,growx");
		panel.add(btnShareData, "cell 0 11,growx");
		
		return panel;
		
	}

	/*
	
	public JPanel getLicensePanel(DataEntry data){
		panel.removeAll();
		//panel.disable();
		panel.setLayout(new MigLayout("", "[grow]", "[][][][][][][][][][][][]"));
		
		String title = "License";
		
		JLabel label_0 = new JLabel(title);
		panel.add(label_0, "cell 0 0");
		
		JLabel label_2 = new JLabel("License Number");
		panel.add(label_2, "cell 0 1");
		
		JFormattedTextField formattedTextField1 = new JFormattedTextField();
		formattedTextField1.setText("0000-00-0000");
		panel.add(formattedTextField1, "cell 0 2,growx");

		JLabel label_1 = new JLabel("Name");
		panel.add(label_1, "cell 0 3");
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setText("Name on License");
		panel.add(formattedTextField, "cell 0 4,growx");
		
		JLabel label_3 = new JLabel("Address");
		panel.add(label_3, "cell 0 5");
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setText("Address");
		panel.add(formattedTextField_1, "cell 0 6,growx");
		
		JLabel label_4 = new JLabel("Date of Birth");
		panel.add(label_4, "cell 0 7");

		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setText("MM / DD / YYYY");
		panel.add(formattedTextField_2, "cell 0 8,growx");
			
		JLabel label_5 = new JLabel("Expiration Date");
		panel.add(label_5, "cell 0 9");
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setText("MM / DD / YYYY");
		panel.add(formattedTextField_3, "cell 0 10,growx");
		
		
		return panel;
	}
	*/
	
	public JPanel getLicensePaneWithData(DataEntry data){
		panel.removeAll();
		//panel.disable();
		panel.setLayout(new MigLayout("", "[grow]", "[][][][][][][][][][][][]"));
		
		String title = "License";
		
		JLabel label_0 = new JLabel(title);
		panel.add(label_0, "cell 0 0");
		
		JLabel label_1 = new JLabel("License Number");
		panel.add(label_1, "cell 0 1");
		
		JFormattedTextField formattedTextField1 = new JFormattedTextField();
		formattedTextField1.setText(data.getFieldDataList().get(0));
		panel.add(formattedTextField1, "cell 0 2,growx");

		JLabel label_2 = new JLabel("Name");
		panel.add(label_2, "cell 0 3");
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setText(data.getFieldDataList().get(1));
		panel.add(formattedTextField, "cell 0 4,growx");
		
		JLabel label_3 = new JLabel("Address");
		panel.add(label_3, "cell 0 5");
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setText(data.getFieldDataList().get(2));
		panel.add(formattedTextField_1, "cell 0 6,growx");
		
		JLabel label_4 = new JLabel("Date of Birth");
		panel.add(label_4, "cell 0 7");

		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setText(data.getFieldDataList().get(3));
		panel.add(formattedTextField_2, "cell 0 8,growx");
			
		JLabel label_5 = new JLabel("Expiration Date");
		panel.add(label_5, "cell 0 9");
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setText(data.getFieldDataList().get(4));
		panel.add(formattedTextField_3, "cell 0 10,growx");
		
		JButton btnEditData = new JButton("Edit Entry");
		btnEditData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DatabaseManager dm = new DatabaseManager("vault_database");
				EditDataEntryView editDataEntry = new EditDataEntryView(dm.retrieveUserFromDatabase(data.getOwner()), data);
				editDataEntry.getJframe().setVisible(true);
			}
		});
		btnEditData.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		
		JButton btnShareData = new JButton("Share Entry");
		btnShareData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(data != null){
					DatabaseManager dm = new DatabaseManager("vault_database");
					ShareView share = new ShareView(dm.retrieveUserFromDatabase(data.getOwner()), data);
					share.setLocationRelativeTo(null);
					share.setVisible(true);
				}
			}
		});
		btnShareData.setFont(new Font("Lucida Grande", Font.PLAIN, 10));

		panel.add(btnEditData, "cell 0 11,growx");
		panel.add(btnShareData, "cell 0 11,growx");
		
		return panel;
	}

	public JPanel getPhoneNumberPaneWithData(DataEntry data){
		panel.removeAll();
		//panel.disable();
		panel.setLayout(new MigLayout("", "[grow]", "[][][][][][][][][][][][]"));
		
		String title = "Phone Number";
		JLabel label_0 = new JLabel(title);
		panel.add(label_0, "cell 0 0");
		
		JLabel label_1 = new JLabel("Name");
		panel.add(label_1, "cell 0 1");
		
		JFormattedTextField formattedTextField1 = new JFormattedTextField();
		formattedTextField1.setText(data.getFieldDataList().get(0));
		panel.add(formattedTextField1, "cell 0 2,growx");

		JLabel label_2 = new JLabel("Phone Number");
		panel.add(label_2, "cell 0 3");
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setText(data.getFieldDataList().get(1));
		panel.add(formattedTextField, "cell 0 4,growx");
		
		JLabel label_3 = new JLabel("Group");
		panel.add(label_3, "cell 0 5");
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setText(data.getFieldDataList().get(2));
		panel.add(formattedTextField_1, "cell 0 6,growx");		
		
		JButton btnEditData = new JButton("Edit Entry");
		btnEditData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DatabaseManager dm = new DatabaseManager("vault_database");
				EditDataEntryView editDataEntry = new EditDataEntryView(dm.retrieveUserFromDatabase(data.getOwner()), data);
				editDataEntry.getJframe().setVisible(true);
			}
		});
		btnEditData.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		
		JButton btnShareData = new JButton("Share Entry");
		btnShareData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(data != null){
					DatabaseManager dm = new DatabaseManager("vault_database");
					ShareView share = new ShareView(dm.retrieveUserFromDatabase(data.getOwner()), data);
					share.setLocationRelativeTo(null);
					share.setVisible(true);
				}
			}
		});
		btnShareData.setFont(new Font("Lucida Grande", Font.PLAIN, 10));

		panel.add(btnEditData, "cell 0 7,growx");
		panel.add(btnShareData, "cell 0 7,growx");
		
		return panel;
	}
	
	public JPanel getSSNWithData(DataEntry data){
		panel.removeAll();
//		panel.disable();
		panel.setLayout(new MigLayout("", "[grow]", "[][][][][][][][][][][][]"));
		
		String title = "SSN";
		JLabel label_0 = new JLabel(title);
		panel.add(label_0, "cell 0 0");
		
		JLabel label_1 = new JLabel("Name");
			panel.add(label_1, "cell 0 1");
		
		JFormattedTextField formattedTextField1 = new JFormattedTextField();
		formattedTextField1.setText(data.getFieldDataList().get(0));
		panel.add(formattedTextField1, "cell 0 2,growx");

		JLabel label_2 = new JLabel("SSN");
			panel.add(label_2, "cell 0 3");
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setText(data.getFieldDataList().get(1));
		panel.add(formattedTextField, "cell 0 4,growx");
		
		
		JButton btnEditData = new JButton("Edit Entry");
		btnEditData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DatabaseManager dm = new DatabaseManager("vault_database");
				EditDataEntryView editDataEntry = new EditDataEntryView(dm.retrieveUserFromDatabase(data.getOwner()), data);
				editDataEntry.getJframe().setVisible(true);
			}
		});
		btnEditData.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		
		JButton btnShareData = new JButton("Share Entry");
		btnShareData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(data != null){
					DatabaseManager dm = new DatabaseManager("vault_database");
					ShareView share = new ShareView(dm.retrieveUserFromDatabase(data.getOwner()), data);
					share.setLocationRelativeTo(null);
					share.setVisible(true);
				}
			}
		});
		btnShareData.setFont(new Font("Lucida Grande", Font.PLAIN, 10));

		panel.add(btnEditData, "cell 0 5,growx");
		panel.add(btnShareData, "cell 0 5,growx");
		
		return panel;
	}
	
	public JPanel getWifiNetworkWithData(DataEntry data){
		panel.removeAll();
		panel.setLayout(new MigLayout("", "[grow]", "[][][][][][][][][][][][]"));
		
		String title = "WiFi Network";
			JLabel label_0 = new JLabel(title);
			panel.add(label_0, "cell 0 0");
		
		JLabel label_1 = new JLabel("Network Name(SSID)");
			panel.add(label_1, "cell 0 1");
		
		JFormattedTextField formattedTextField1 = new JFormattedTextField();
		formattedTextField1.setText(data.getFieldDataList().get(0));
		panel.add(formattedTextField1, "cell 0 2,growx");

		JLabel label_2 = new JLabel("Password");
			panel.add(label_2, "cell 0 3");
		
		JFormattedTextField formattedTextField2 = new JFormattedTextField();
		formattedTextField2.setText(data.getFieldDataList().get(1));
		panel.add(formattedTextField2, "cell 0 4,growx");
		
		JLabel label_3 = new JLabel("Security Mode");
		panel.add(label_3, "cell 0 5");
	
		JFormattedTextField formattedTextField3 = new JFormattedTextField();
		formattedTextField3.setText(data.getFieldDataList().get(1));
		panel.add(formattedTextField3, "cell 0 6,growx");
				
		JButton btnEditData = new JButton("Edit Entry");
		btnEditData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DatabaseManager dm = new DatabaseManager("vault_database");
				EditDataEntryView editDataEntry = new EditDataEntryView(dm.retrieveUserFromDatabase(data.getOwner()), data);
				editDataEntry.getJframe().setVisible(true);
			}
		});
		btnEditData.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		
		JButton btnShareData = new JButton("Share Entry");
		btnShareData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(data != null){
					DatabaseManager dm = new DatabaseManager("vault_database");
					ShareView share = new ShareView(dm.retrieveUserFromDatabase(data.getOwner()), data);
					share.setLocationRelativeTo(null);
					share.setVisible(true);
				}
			}
		});
		btnShareData.setFont(new Font("Lucida Grande", Font.PLAIN, 10));

		panel.add(btnEditData, "cell 0 7,growx");
		panel.add(btnShareData, "cell 0 7,growx");
		
		return panel;
	}	
	
	public JPanel getGeneralPanelWithData(ArrayList<String> index, DataEntry data){
		panel.removeAll();
		panel.setLayout(new MigLayout("", "[grow]", "[][][][][][][][][][][][]"));
		
		String title = data.getEntryType();
			JLabel label_0 = new JLabel(title);
			panel.add(label_0, "cell 0 0");
		
		int row = 1;
		int i;
		for (i=0; i < index.size(); i++) {
			if((title.equals("Wifi Network") || title.equals("General Password")) && i == 1) {
				JLabel label_1 = new JLabel(index.get(i));
				panel.add(label_1, "cell 0 " + Integer.toString(row++) );
			
				JPasswordField passwordField = new JPasswordField();
				passwordField.setText(data.getFieldDataList().get(i));
				passwordField.setEditable(false);
				passwordField.putClientProperty("JPasswordField.cutCopyAllowed",true);
				panel.add(passwordField, "cell 0 "+ Integer.toString(row++) +",growx");
				char a = passwordField.getEchoChar();

				JCheckBox chckbxShowPassword = new JCheckBox("Show Password");
				chckbxShowPassword.setBounds(130, 176, 128, 23);

				chckbxShowPassword.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if (e.getStateChange() == ItemEvent.SELECTED) {
							passwordField.setEchoChar((char)0);
						} else {
							passwordField.setEchoChar(a); 
						}
					}
				});
				panel.add(chckbxShowPassword, "cell 0 "+ Integer.toString(row++) +",growx");
				continue;
			}
			JLabel label_1 = new JLabel(index.get(i));
			panel.add(label_1, "cell 0 " + Integer.toString(row++) );
		
			JFormattedTextField formattedTextField1 = new JFormattedTextField();
			formattedTextField1.setText(data.getFieldDataList().get(i));
			formattedTextField1.setEditable(false);
			panel.add(formattedTextField1, "cell 0 "+ Integer.toString(row++) +",growx");
		}
		

		JButton btnEditData = new JButton("Edit Entry");
		btnEditData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DatabaseManager dm = new DatabaseManager("vault_database");
				EditDataEntryView editDataEntry = new EditDataEntryView(dm.retrieveUserFromDatabase(data.getOwner()), data);
				editDataEntry.getJframe().setVisible(true);
			}
		});
		btnEditData.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		
		JButton btnShareData = new JButton("Share Entry");
		btnShareData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(data != null){
					DatabaseManager dm = new DatabaseManager("vault_database");
					ShareView share = new ShareView(dm.retrieveUserFromDatabase(data.getOwner()), data);
					share.setLocationRelativeTo(null);
					share.setVisible(true);
				}
			}
		});
		btnShareData.setFont(new Font("Lucida Grande", Font.PLAIN, 10));

		panel.add(btnEditData, "cell 0 "+ Integer.toString(row) +",growx");
		panel.add(btnShareData, "cell 0 "+ Integer.toString(row++) +",growx");
						
		return panel;
	}	
	
	public void valueChanged(TreeSelectionEvent tsl) {
		
		if(tsl.getNewLeadSelectionPath() != null) {
			info.setText(tsl.getNewLeadSelectionPath().getLastPathComponent().toString());
		}
	}
	
	
	
	
	
}
