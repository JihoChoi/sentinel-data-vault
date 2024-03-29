package userInterface;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;


public class HelpView {

	/*
	 * HelpView
	 * 2015 10 01 ~ 
	 * 1st Sprint
	 * Jiho Choi
	 * 
	 */
	
	
	public JFrame frmHelp;
	private JTextArea textPane;
	public String credits = 
			"Sentinel Data Vault brought to you by Team 19:\n"
			+ "Scrum Master: Adam Petty\n"
			+ "Zhaoji Jiang,\n"
			+ "Dingfu Sun,\n"
			+ "Jiho Choi,\n"
			+ "and Thomas Worns";
	public String signingUp = 
			"To create a new account in the\n"
			+ "Sentinel Data Vault from the login screen:\n"
			+ "Click on the \"Create new Account Button\",\n"
			+ "When the account creation screen appears,\n"
			+ "fill in all the fields that are displayed,\n"
			+ "Keep in mind that passwords MUST include\n"
			+ "at least one of ALL of the following:\n"
			+ "Uppercase letter, lowercase letter,\n"
			+ "special character, and a Number.\n"
			+ "The username is the email address you\n"
			+ "wish to associate with the account.\n"
			+ "To create your account, click the\n"
			+ "\"Create my account\" button.\n"
			+ "Any fields that contain errors or remain\n"
			+ "empty will keep the account from being created\n"
			+ "until such errors are corrected.\n";
	
	public String loggingIn = 
			"To login to the Sentinel Data Vault (SDV):\n"
			+ "After starting the SDV desktop application,\n"
			+ "a login screen will appear.\n"
			+ "The login screen will prompt\n"
			+ "you for a username and password.\n"
			+ "If you have previously created anaccount\n"
			+ "in the SDV, enter your username and password.\n"
			+ "If you have not created an account,\n"
			+ "follow the Account creation tutorial.";
	
	public String recoveringPassword = 
			"In the event that a user forgets his/her password,\n"
			+ "it can be recovered via the login screen. "
			+ "This is done\n"
			+ "by clicking the \"I forgot my Password\" button.\n"
			+ "When this button is clicked, a window prompting\n"
			+ "for the username of the account that needs recovery.\n"
			+ "After entering the username, the user must answer\n"
			+ "his/her security question."
			+ "After a correctly answered\n"
			+ "security question, the user will be emailed a security\n"
			+ "code that needs to be entered into the window.\n"
			+ "After all these steps are completed, the user will\n"
			+ "be taken to a screen where they can change their\n"
			+ "password by following the on screen prompts.";
	
	public String newEntry = 
			"Creating a new data entry must be done from\n the main\n"
			+ "screen that is displayed after a user logs in.\n"
			+ "The button labeled \"New Entry\" will\n"
			+ "initiate the process of creating a new entry.\n"
			+ "The user must then select a type of data\n"
			+ "entry from the drop down that appears.\n"
			+ "The user will then be prompted for the\n"
			+ " data necessary to complete then entry.\n"
			+ "Once the user is satisfied with their entries,\n"
			+ "clicking the save button saves the entry.";
	
	public String existingEntry=
			"Modifying a data entry must be done from the main\n"
			+ "screen that is displayed after a user logs in.\n"
			+ "To modify an entry, first select that entry from\n"
			+ "the middle column of the main screen. The data entry\n"
			+ "will appear in the right column of the main screen.\n"
			+ "At the bottom of the data entry, a button labeled\n"
			+ "\"Edit Entry\" will display. Clicking this button brings\n"
			+ "up a window similar to the entry creation window.\n"
			+ "After modifying data, click save.\n"
			+ "The newly modified data will display\n"
			+ "when the data entry is next selected.";
	
	public String changingPassword= 
			"In order to change the user account password, the \n"
			+ "user must go to the settings view.\n"
			+ "Selecting the button labeled \"Change Password\"\n"
			+ "in the settings view will bring up\n"
			+ "the window that allows for the changing of user \n"
			+ "account password and/or user security question and \n"
			+ "answer."
			+ "To change only the password, simply fill in\n"
			+ "the fields under the \"New Password\" heading.\n"
			+ "To change only the security question and answer \n"
			+ "simply fill in the fields under the\n "
			+ "\"New Security Question\" heading.\n"
			+ "To change both at the same time, simply fill\n"
			+ "in all the fields."
			+ "When finished with the changes,\n"
			+ "select the button labeled \"Change\" and \n"
			+ "credentials will be changed.";
	
	public String changingAvatar = 
			"The Sentinel Data Vault allows the user\n"
			+ "to select an avatar picture. This is done by\n"
			+ "clicking the \"Settings\" button in the\n"
			+ "main screen after logging in. In the settings\n"
			+ "window, clicking on the \"Change Avatar\"\n"
			+ "button brings up a window that allows for\n"
			+ "the choosing of an avatar. Once the avatar\n"
			+ "has been selected, the main screen will\n"
			+ "display the selected avatar."; 
	
	public String localShare = 
			"To share a data entry with another user with\n"
			+ "an account in the same data vault,\n"
			+ "select the entry to be shared in the main\n"
			+ "view and in the right column, the data entry will appear.\n"
			+ "At the bottom of the data entry, a\n"
			+ "button labeled \"Share entry\" will appear.\n"
			+ "Selecting this button brings up the window\n"
			+ "that data entries can be shared from.\n"
			+ "after entering the necessary username,\n"
			+ "select the button labeled \"Share locally\",\n"
			+ "Your data entry is now being shared with the\n"
			+ "selected user."
			+ "This sharing can be ended at any time\n"
			+ "by selecting the button labeled \"Stop Sharing\".";
	
	public String emailShare =
			"To share a data entry via email, select the data\n"
			+ "entry that is to be shared from the main screen.\n"
			+ "A button labeled \"Share Entry\" will appear.\n"
			+ "Selecting this button will bring up a window that\n"
			+ "data entries can be shared from. After entering\n"
			+ "the username of the user that the data will be shared\n"
			+ "with, selecting the \"Share via email\" button will share\n"
			+ "the entry with the selected user.\n"
			+ "The email will contain encrypted text that the\n"
			+ "recieving user will need to decrypt using their\n"
			+ "Sentinel Data Vault.";
	
	public String backup = 
			"From the main screen that appears after the user logs in,\n"
			+ "selecting the \"Create Backup\" button displays a\n"
			+ "file browser. From the displayed file browser,\n"
			+ "selecting the backup location will create a backup\n"
			+ "in that directory.\n"
			+ "NOTE: the selected location MUST be a folder or\n"
			+ "directory. To import a backup, simply select the\n"
			+ "\"Import Entries\" button. In the file browser that\n"
			+ "appears upon the selection of that button\n"
			+ "select the desired backup, and confirm the selection.";


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpView window = new HelpView();
					window.frmHelp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HelpView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHelp = new JFrame();
		frmHelp.setTitle("Help");
		frmHelp.setBounds(100, 100, 540, 402);
		frmHelp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmHelp.setLocationRelativeTo(null);
		JTree tree = new JTree();
		tree.setRootVisible(false);
		tree.setBounds(7, 7, 195, 297);
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				JTree tree = (JTree) e.getSource();

				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

				String selectedNodeName = selectedNode.toString();
				
				if(selectedNodeName.equals("Signing Up") && selectedNode.isLeaf()) { 
					textPane.setText(signingUp);
					frmHelp.repaint();
				}
				else if ( selectedNodeName.equals("Logging In")) { 
					textPane.setText(loggingIn);
					frmHelp.repaint();
				}
				else if ( selectedNodeName.equals("Recovering Password")) { 
					textPane.setText(recoveringPassword);
					frmHelp.repaint();
				}
				else if ( selectedNodeName.equals("Making a New Entry")) { 
					textPane.setText(newEntry);
					frmHelp.repaint();
				}
				else if ( selectedNodeName.equals("Modifying an Existing Entry")) { 
					textPane.setText(existingEntry);
					frmHelp.repaint();
				}
				else if ( selectedNodeName.equals("Changing Password")) { 
					textPane.setText(changingPassword);
					frmHelp.repaint();
				}
				else if ( selectedNodeName.equals("Changing Avatar")) { 
					textPane.setText(changingAvatar);
					frmHelp.repaint();
				}
				else if ( selectedNodeName.equals("Sharing Entries Locally")) { 
					textPane.setText(localShare);
					frmHelp.repaint();
				}
				else if ( selectedNodeName.equals("Sharing Entries Via Email")) { 
					textPane.setText(emailShare);
					frmHelp.repaint();
				}
				else if ( selectedNodeName.equals("Backing up files")) { 
					textPane.setText(backup);
					frmHelp.repaint();
				}
				else if(selectedNodeName.equals("Credits")){ 
					textPane.setText(credits);
					frmHelp.repaint();
				}

			}
		});
		frmHelp.getContentPane().setLayout(null);
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("FAQ") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Creating Account");
						node_1.add(new DefaultMutableTreeNode("Signing Up"));
						node_1.add(new DefaultMutableTreeNode("Logging In"));
						node_1.add(new DefaultMutableTreeNode("Recovering Password"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Creating New Data");
						node_1.add(new DefaultMutableTreeNode("Making a New Entry"));
						node_1.add(new DefaultMutableTreeNode("Modifying an Existing Entry"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Settings");
						node_1.add(new DefaultMutableTreeNode("Changing Password"));
						node_1.add(new DefaultMutableTreeNode("Changing Avatar"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Sharing and Backups");
						node_1.add(new DefaultMutableTreeNode("Sharing Entries Locally"));
						node_1.add(new DefaultMutableTreeNode("Sharing Entries Via Email"));
						node_1.add(new DefaultMutableTreeNode("Backing up files"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Credits");
					add(node_1);
				}
			}
		));
		
		frmHelp.getContentPane().add(tree);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.setBounds(214, 317, 127, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmHelp.dispose();
			}
		});
		
		textPane = new JTextArea();
		textPane.setWrapStyleWord(true);
		textPane.setEditable(false);
		textPane.setBounds(214, 7, 298, 297);
		frmHelp.getContentPane().add(textPane);
		frmHelp.getContentPane().add(btnNewButton);
	}
}
