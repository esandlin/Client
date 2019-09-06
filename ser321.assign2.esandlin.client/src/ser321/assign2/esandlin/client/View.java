package esandlin;

import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * Copyright (c) 2015 Tim Lindquist, Software Engineering, Arizona State
 * University at the Polytechnic campus
 * <p/>
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation version 2 of the License.
 * <p/>
 * This program is distributed in the hope that it will be useful, but without
 * any warranty or fitness for a particular purpose.
 * <p/>
 * Please review the GNU General Public License at:
 * http://www.gnu.org/licenses/gpl-2.0.html see also:
 * https://www.gnu.org/licenses/gpl-faq.html so you are aware of the terms and
 * your rights with regard to this software. Or, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301,USA
 * <p/>
 * Purpose: Sample Java Swing controller class. FolderBrowserGUI constructs the
 * view components for a sample GUI. This class is extends the GUI to provide
 * the control functionality. When the user does a tree node selection, this
 * valueChanged is called, but virtue of being a TreeSelectionListener and
 * adding itself as a listerner. FolderBrowser defines the call-backs for the
 * JButton as well. It contains sample control functions that respond to button
 * clicks and tree selects. This software is meant to run on Debian Wheezy Linux
 * <p/>
 * Ser321 Principles of Distributed Software Systems see
 * http://pooh.poly.asu.edu/Ser321
 * 
 * @author Tim Lindquist (Tim.Lindquist@asu.edu) CIDSE - Software Engineering,
 *         IAFSE, ASU at the Polytechnic campus
 * @file FolderBrowserGUI.java
 * @date July, 2015
 **/

public class View extends JFrame {

	/**
	 * serialnumber for json
	 */
	private static final long serialVersionUID = -5951646991542473278L;

	private static final boolean debugOn = true;

	private JTextField toTextField = new JTextField(10);
	private JTextField fromtextField = new JTextField(10);
	private JTextField subjectTextField = new JTextField(20);
	private JTextField dateTextField = new JTextField(11);

	private JLabel lblFromLabel = new JLabel("From:");
	private JLabel lblToLabel = new JLabel("To:");
	private JLabel lblSubjectLabel = new JLabel("Subject:");
	private JLabel lblDateLabel = new JLabel("Date:");
	private JLabel lblStatusLabel = new JLabel("Status:");
	private JLabel lblMessageLabel = new JLabel("Messages for Eric.Sandlin");

	private JButton btnDeleteButton = new JButton("Delete");
	private JButton btnReplyButton = new JButton("Reply");
	private JButton btnSendTextButton = new JButton("Send Text");
	private JButton btnCipherButton = new JButton("Send Cipher");

	private JTree treePane = new JTree();
	private JEditorPane editorPaneOutput = new JEditorPane();

	View() {

		// Sets up the view and adds the components

		JPanel panel = new JPanel();

		this.setTitle("Eric Sandlin's Messaging Client for user: esandlin");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(580, 300);

		panel.add(lblMessageLabel);
		panel.add(btnDeleteButton);
		panel.add(btnReplyButton);
		panel.add(btnSendTextButton);
		panel.add(btnCipherButton);
		panel.add(treePane);
		treePane.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Messages:") {
			/**
			 * Json serial version
			 */
			private static final long serialVersionUID = -8241891137546104746L;

			{
				DefaultMutableTreeNode node_1;
				node_1 = new DefaultMutableTreeNode("August 29, 2019 1:15am");
				node_1.add(new DefaultMutableTreeNode("Get your homework done!"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("August 30, 2019  2:45pm");
				node_1.add(new DefaultMutableTreeNode("Get your homework done!"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("September 1, 2019  3:30am");
				node_1.add(new DefaultMutableTreeNode("Get your homework done!"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("September 3, 2019. 1:32pm");
				node_1.add(new DefaultMutableTreeNode("Time is Running out!"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("September 4, 2019. 4:30");
				node_1.add(new DefaultMutableTreeNode("Last day turn in what you have."));
				add(node_1);
			}
		}));
		treePane.setBounds(10, 74, 135, 198);
		panel.add(lblToLabel);
		lblToLabel.setBounds(187, 56, 20, 16);
		panel.add(toTextField);
		toTextField.setBounds(204, 51, 61, 26);
		panel.add(lblFromLabel);
		lblFromLabel.setBounds(277, 56, 36, 16);
		panel.add(fromtextField);
		fromtextField.setBounds(314, 51, 130, 26);
		panel.add(lblDateLabel);
		lblDateLabel.setBounds(277, 94, 36, 16);
		panel.add(dateTextField);
		dateTextField.setBounds(314, 89, 130, 26);
		panel.add(lblSubjectLabel);
		lblSubjectLabel.setBounds(157, 94, 50, 16);
		panel.add(subjectTextField);
		subjectTextField.setBounds(204, 89, 61, 26);
		panel.add(lblStatusLabel);
		panel.add(editorPaneOutput);
		editorPaneOutput.setBounds(157, 116, 287, 100);
		
		this.add(panel);

		// ------- End of setting up the components --------

	}

//	public int getFirstNumber() {
//		return Integer.parseInt(toTextField.getText());
//	}
//
//	public int getSecondNumber() {
//		return Integer.parseInt(fromtextField.getText());
//	}
//
//	public int getCalcSolution() {
//		return Integer.parseInt(subjectTextField.getText());
//	}
//
//	public void setCalcSolution(int solution) {
//		subjectTextField.setText(Integer.toString(solution));
//	}

	public JTextField getToTextField() {
		return toTextField;
	}

	public JTextField getFromtextField() {
		return fromtextField;
	}

	public JTextField getSubjectTextField() {
		return subjectTextField;
	}

	public JTextField getDateTextField() {
		return dateTextField;
	}
	
	public JTree getTreePane() {
		return treePane;
	}

	public void setTreePane(JTree treePane) {
		this.treePane = treePane;
	}

	public JEditorPane getEditorPaneOutput() {
		return editorPaneOutput;
	}

	public void setEditorPaneOutput(JEditorPane editorPaneOutput) {
		this.editorPaneOutput = editorPaneOutput;
	}

	/*
	 * If Button is clicked execute a method in the Controller named actionPerformed
	 */
	void addDeleteListener(ActionListener listenForDeleteButton) {

		btnDeleteButton.addActionListener(listenForDeleteButton);

	}

	void addReplyListener(ActionListener listenForReplyButton) {

		btnReplyButton.addActionListener(listenForReplyButton);

	}

	void addSendListener(ActionListener listenForSendButton) {

		btnSendTextButton.addActionListener(listenForSendButton);

	}

	void addCipherListener(ActionListener listenForCipherButton) {

		btnCipherButton.addActionListener(listenForCipherButton);
	}

	/**
	 * // Open a popup that contains the error message passed
	 * 
	 * @param errorMessage
	 */
	void displayErrorMessage(String errorMessage) {

		JOptionPane.showMessageDialog(this, errorMessage);

	}
	
	/**
	 * @param message
	 */
	private void debug(String message) {
	      if (debugOn)
	         System.out.println("debug: "+message);
	   }

}