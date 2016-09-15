package edu.pitt.is1017.spaceinvaders;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginGUI {

	private JFrame frame;
	private JTextField txtEmail;
	private JTextField txtPassword;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JButton btnRegister;
	private JButton btnLogin;
	private JButton btnCancel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("SpaceInvaders - Login");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(32, 34, 73, 16);
		frame.getContentPane().add(lblEmail);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(32, 66, 73, 16);
		frame.getContentPane().add(lblPassword);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(142, 34, 230, 22);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(142, 66, 230, 22);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		btnRegister = new JButton("Register");
		btnRegister.setBounds(34, 108, 97, 25);
		frame.getContentPane().add(btnRegister);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread ("gameLaunchThread"){
					public void run(){
						try {
							String email = txtEmail.getText();
							String password = txtPassword.getText();
							User user = new User(email, password);
							Game game = new Game(user);
							game.gameLoop();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				};
				t.start();
			}
		});
		btnLogin.setBounds(152, 108, 97, 25);
		frame.getContentPane().add(btnLogin);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnCancel.setBounds(275, 108, 97, 25);
		frame.getContentPane().add(btnCancel);
	}
}
