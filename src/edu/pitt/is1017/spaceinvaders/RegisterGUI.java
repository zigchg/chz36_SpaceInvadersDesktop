package edu.pitt.is1017.spaceinvaders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterGUI {

	private JFrame frmSpaceinvadersRegistration;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtEmail;
	private JTextField txtPassword;
	private JTextField txtConfirmPassword;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JLabel lblConfirmPassword;
	private JButton btnRegister;
	private JButton btnCancel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterGUI window = new RegisterGUI();
					window.frmSpaceinvadersRegistration.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSpaceinvadersRegistration = new JFrame("SpaceInvaders - Registration");
		frmSpaceinvadersRegistration.setBounds(100, 100, 450, 728);
		frmSpaceinvadersRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpaceinvadersRegistration.getContentPane().setLayout(null);
		
		lblFirstName = new JLabel("First Name: ");
		lblFirstName.setBounds(40, 45, 120, 16);
		frmSpaceinvadersRegistration.getContentPane().add(lblFirstName);
		
		lblLastName = new JLabel("Last Name: ");
		lblLastName.setBounds(40, 90, 120, 16);
		frmSpaceinvadersRegistration.getContentPane().add(lblLastName);
		
		lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(40, 135, 120, 16);
		frmSpaceinvadersRegistration.getContentPane().add(lblEmail);
		
		lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(40, 180, 120, 16);
		frmSpaceinvadersRegistration.getContentPane().add(lblPassword);
		
		lblConfirmPassword = new JLabel("Confirm Password: ");
		lblConfirmPassword.setBounds(40, 225, 120, 16);
		frmSpaceinvadersRegistration.getContentPane().add(lblConfirmPassword);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(170, 45, 200, 22);
		frmSpaceinvadersRegistration.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(170, 90, 200, 22);
		frmSpaceinvadersRegistration.getContentPane().add(txtLastName);
		txtLastName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(170, 135, 200, 22);
		frmSpaceinvadersRegistration.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(170, 180, 200, 22);
		frmSpaceinvadersRegistration.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setBounds(170, 225, 200, 22);
		frmSpaceinvadersRegistration.getContentPane().add(txtConfirmPassword);
		txtConfirmPassword.setColumns(10);
		
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(txtPassword.getText().equals(txtConfirmPassword.getText()))){
					JOptionPane.showMessageDialog(null, "Confirm password is different from password.");
				}
				else {
					String lastName = txtLastName.getText();
					String firstName = txtFirstName.getText();
					String email = txtEmail.getText();
					String password = txtPassword.getText();
					User newUser = new User(lastName, firstName, email, password);
				}
			}
		});
		btnRegister.setBounds(170, 270, 90, 25);
		frmSpaceinvadersRegistration.getContentPane().add(btnRegister);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSpaceinvadersRegistration.dispose();
			}
		});
		btnCancel.setBounds(280, 270, 90, 25);
		frmSpaceinvadersRegistration.getContentPane().add(btnCancel);
	}

}
