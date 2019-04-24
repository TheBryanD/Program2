import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.DropMode;
import java.awt.SystemColor;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import java.security.*;
import java.util.ArrayList;
import java.io.*;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import javax.swing.JScrollBar;
import java.awt.Toolkit;

public class Program2 {

	private JFrame frmProgram;
	private JTextField txtfperson;
	private JTextField txtsperson;
	public BlockChain bc = new BlockChain();
	private int blockNum = 0;


	/**
	 * Launch the application.
	 */
	
	public String name1;
	public String name2;
	public int transactionNum = 1;
	private JTextField txtAmount;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Program2 window = new Program2();
					window.frmProgram.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the application.
	 */
	public Program2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProgram = new JFrame();
		frmProgram.setIconImage(Toolkit.getDefaultToolkit().getImage(Program2.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		frmProgram.setTitle("Program 2");
		frmProgram.setResizable(false);
		frmProgram.getContentPane().setBackground(Color.GRAY);
		frmProgram.setBounds(100, 100, 633, 630);
		frmProgram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProgram.getContentPane().setLayout(null);
		
//TopPanel~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		JPanel TopPanel = new JPanel();
		TopPanel.setBackground(Color.LIGHT_GRAY);
		TopPanel.setBounds(0, 0, 627, 56);
		frmProgram.getContentPane().add(TopPanel);
		TopPanel.setLayout(null);
		
		JLabel lblTransaction = new JLabel("Transaction #" + transactionNum);
		lblTransaction.setBounds(10, 11, 111, 14);
		TopPanel.add(lblTransaction);
		
		txtfperson = new JTextField();
		txtfperson.setText("1stPerson");
		txtfperson.setBounds(119, 8, 86, 20);
		TopPanel.add(txtfperson);
		txtfperson.setColumns(10);
		
		JLabel ArrowImg = new JLabel("");
		ArrowImg.setForeground(Color.BLACK);
		ArrowImg.setIcon(new ImageIcon(Program2.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
		ArrowImg.setBounds(233, 9, 16, 16);
		TopPanel.add(ArrowImg);
		
		txtsperson = new JTextField();
		txtsperson.setText("2ndPerson");
		txtsperson.setBounds(275, 8, 86, 20);
		TopPanel.add(txtsperson);
		txtsperson.setColumns(10);
		
		JButton btnSign = new JButton("Sign");
		btnSign.setBackground(SystemColor.activeCaption);
		btnSign.setFont(new Font("Arial", Font.PLAIN, 11));
		btnSign.setBounds(518, 7, 89, 23);
		TopPanel.add(btnSign);
		
		txtAmount = new JTextField();
		txtAmount.setText("Amount");
		txtAmount.setBounds(397, 8, 86, 20);
		TopPanel.add(txtAmount);
		txtAmount.setColumns(10);
		
		JLabel label = new JLabel("$");
		label.setBounds(385, 11, 46, 14);
		TopPanel.add(label);
		
		
		
//MiddlePanel~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		JPanel MiddlePanel = new JPanel();
		MiddlePanel.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		MiddlePanel.setBackground(Color.DARK_GRAY);
		MiddlePanel.setBounds(57, 80, 520, 258);
		frmProgram.getContentPane().add(MiddlePanel);
		MiddlePanel.setLayout(null);
		
		JButton btnMerkleRoot = new JButton("Merkle Root ");
		btnMerkleRoot.setBackground(SystemColor.activeCaption);
		btnMerkleRoot.setBounds(320, 119, 113, 23);
		MiddlePanel.add(btnMerkleRoot);
		
		DefaultListModel<String> model = new DefaultListModel<>();
		JList<String> list = new JList(model);
		list.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		list.setBackground(Color.LIGHT_GRAY);
		list.setBounds(112, 11, 321, 97);
		MiddlePanel.add(list);
		
		JLabel lblBlck = new JLabel("Block # ");
		lblBlck.setForeground(SystemColor.inactiveCaption);
		lblBlck.setBounds(10, 153, 330, 23);
		MiddlePanel.add(lblBlck);
		
		JLabel lblPreviousHash = new JLabel("Previous Hash # ");
		lblPreviousHash.setForeground(SystemColor.inactiveCaption);
		lblPreviousHash.setBounds(10, 176, 500, 40);
		MiddlePanel.add(lblPreviousHash);
		
		JButton btnMine = new JButton("Mine");
		btnMine.setBackground(SystemColor.activeCaption);
		btnMine.setBounds(320, 207, 113, 23);
		MiddlePanel.add(btnMine);
		
//BottomPanel~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		JPanel BottomPanel = new JPanel();
		BottomPanel.setBackground(Color.DARK_GRAY);
		BottomPanel.setBounds(0, 366, 627, 236);
		frmProgram.getContentPane().add(BottomPanel);
		BottomPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY, 4));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(21, 11, 172, 214);
		BottomPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblBlock = new JLabel("Block # ");
		lblBlock.setBounds(10, 11, 162, 14);
		panel.add(lblBlock);
		
		JLabel lblPrevHash = new JLabel("Prev Hash # ");
		lblPrevHash.setBounds(10, 36, 162, 14);
		panel.add(lblPrevHash);
		
		JLabel lblMerkleRoot = new JLabel("Merkle Root ");
		lblMerkleRoot.setBounds(10, 61, 162, 14);
		panel.add(lblMerkleRoot);
		
		JLabel lblBlockHash = new JLabel("Block Hash # ");
		lblBlockHash.setBounds(10, 189, 162, 14);
		panel.add(lblBlockHash);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.GRAY, 4));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setLayout(null);
		panel_1.setBounds(228, 11, 172, 214);
		BottomPanel.add(panel_1);
		
		JLabel label_1 = new JLabel("Block # ");
		label_1.setBounds(10, 11, 162, 14);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Prev Hash # ");
		label_2.setBounds(10, 36, 162, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Merkle Root ");
		label_3.setBounds(10, 61, 162, 14);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Block Hash # ");
		label_4.setBounds(10, 189, 162, 14);
		panel_1.add(label_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.GRAY, 4));
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setLayout(null);
		panel_2.setBounds(431, 11, 172, 214);
		BottomPanel.add(panel_2);
		
		JLabel label_5 = new JLabel("Block # ");
		label_5.setBounds(10, 11, 162, 14);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("Prev Hash # ");
		label_6.setBounds(10, 36, 162, 14);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("Merkle Root ");
		label_7.setBounds(10, 61, 162, 14);
		panel_2.add(label_7);
		
		JLabel label_8 = new JLabel("Block Hash # ");
		label_8.setBounds(10, 189, 162, 14);
		panel_2.add(label_8);
	
		
		btnSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				name1 = txtfperson.getText();
				name2 = txtsperson.getText();
				String amount = txtAmount.getText();
				//String signature = GenerateSignature(args);
				transactionNum += 1;
				model.addElement(transactionNum-1 + ". " + name1 + " " + name2 + " $" + amount + " " );
				lblTransaction.setText("Transaction #" + transactionNum);;
				txtfperson.setText(null);
				txtsperson.setText(null);
			}
		});
		btnMine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(transactionNum <= blockNum)
				{
					lblBlock.setText("Block # " + " Error, not allowed to do that now.");
				}
				blockNum += 1;
				if(bc.blockchain.isEmpty())
				{
					bc.addBlock(new Block(/* Hash? */"Hello", "0"));
					bc.blockchain.get(0).hash = null;
				}
				bc.addBlock(new Block(/* Hash? */"Hello", bc.blockchain.get(bc.blockchain.size()-1).hash));
				lblBlck.setText("Block # " + blockNum);
				if(blockNum > 1)
				{
					lblPreviousHash.setText("Previous Hash # " + bc.blockchain.get(blockNum).previousHash);
				}
				else 
				{
					lblPreviousHash.setText("Previous Hash #null" );
				}
				
				if (bc.blockchain.size() == 1)
				{
					label_5.setText("Block #" + (blockNum));
					label_6.setText("Previous Hash #" + "null");
					label_7.setText("Merkle Root");
					label_8.setText("Block Hash #" + bc.blockchain.get(blockNum).hash);
				}
				else if (bc.blockchain.size() == 2)
				{
					label_1.setText("Block #" + (blockNum-1));
					label_2.setText("Previous Hash #" + bc.blockchain.get(blockNum-2).hash);
					label_3.setText("Merkle Root");
					label_4.setText("Block Hash #" + bc.blockchain.get(blockNum-1).hash);
					
					label_5.setText("Block #" + (blockNum));
					label_6.setText("Previous Hash #" + bc.blockchain.get(blockNum-1).hash);
					label_7.setText("Merkle Root");
					label_8.setText("Block Hash #" + bc.blockchain.get(blockNum).hash);
				}
				else if(bc.blockchain.size() > 2)
				{
					lblBlock.setText("Block #" + (blockNum-2));
					lblPrevHash.setText("Previous Hash #" + bc.blockchain.get(blockNum-3).hash);
					lblMerkleRoot.setText("Merkle Root");
					lblBlockHash.setText("Block Hash #" + bc.blockchain.get(blockNum-2).hash);
					
					label_1.setText("Block #" + (blockNum-1));
					label_2.setText("Previous Hash #" + bc.blockchain.get(blockNum-2).hash);
					label_3.setText("Merkle Root");
					label_4.setText("Block Hash #" + bc.blockchain.get(blockNum-1).hash);
					
					label_5.setText("Block #" + (blockNum));
					label_6.setText("Previous Hash #" + bc.blockchain.get(blockNum-1).hash);
					label_7.setText("Merkle Root");
					label_8.setText("Block Hash #" + bc.blockchain.get(blockNum).hash);
				}
			}
		});
	
	}

}
