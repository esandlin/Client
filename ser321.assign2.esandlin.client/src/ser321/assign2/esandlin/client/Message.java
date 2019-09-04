package ser321.assign2.esandlin.client;


import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.JOptionPane;
import java.net.URL;
import java.util.Date;
import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JFrame;
import javax.swing.tree.TreePath;
import javax.swing.event.TreeSelectionListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * Copyright (c) 2015 Tim Lindquist,
 * Software Engineering,
 * Arizona State University at the Polytechnic campus
 * <p/>
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation version 2
 * of the License.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but without any warranty or fitness for a particular purpose.
 * <p/>
 * Please review the GNU General Public License at:
 * http://www.gnu.org/licenses/gpl-2.0.html
 * see also: https://www.gnu.org/licenses/gpl-faq.html
 * so you are aware of the terms and your rights with regard to this software.
 * Or, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301,USA
 * <p/>
 * Purpose: Sample Java Swing controller class. FolderBrowserGUI constructs the view components
 * for a sample GUI. This class is extends the GUI to provide the control functionality.
 * When the user does a tree node selection, this valueChanged is called, but virtue of being a
 * TreeSelectionListener and adding itself as a listerner. FolderBrowser defines the call-backs
 * for the JButton as well.
 * It contains sample control functions that respond to button clicks and tree
 * selects.
 * This software is meant to run on Debian Wheezy Linux
 * <p/>
 * Ser321 Principles of Distributed Software Systems
 * see http://pooh.poly.asu.edu/Ser321
 * @author Tim Lindquist (Tim.Lindquist@asu.edu) CIDSE - Software Engineering,
 *                       IAFSE, ASU at the Polytechnic campus
 * @file    FolderBrowserGUI.java
 * @date    July, 2015
 **/

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

public class Message implements ActionListener, ListSelectionListener {

	private JFrame frame;
	private JTextField toTextField;
	private JTextField subjectTextField;
	private JTextField FromtextField;
	private JTextField DatetextField;

    public class Message implements MessageLibrary {
        private String content;
        
        public String getContent() {
            return content;
        }
        
        public void setContent(String content) {
            this.content = content;
        }
    }
    
	/**
	 * Main Launches the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Message window = new Message();
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
	public Message() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Eric Sandlin's Messaging Client for user: esandlin");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 39);
		frame.getContentPane().add(panel);
		
		JButton btnDeleteButton = new JButton("Delete");
		btnDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnDeleteButton.setBackground(Color.GRAY);
		panel.add(btnDeleteButton);
		
		JButton btnReplyButton = new JButton("Reply");
		btnReplyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnReplyButton.setBackground(Color.GRAY);
		panel.add(btnReplyButton);
		
		JButton btnSendTextButton = new JButton("Send Text");
		btnSendTextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSendTextButton.setBackground(Color.GRAY);
		panel.add(btnSendTextButton);
		
		JButton btnCipherButton = new JButton("Send Cipher");
		btnCipherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCipherButton.setBackground(Color.GRAY);
		panel.add(btnCipherButton);
		
		toTextField = new JTextField();
		toTextField.setBounds(204, 51, 61, 26);
		frame.getContentPane().add(toTextField);
		toTextField.setColumns(10);
		
		subjectTextField = new JTextField();
		subjectTextField.setBounds(204, 89, 61, 26);
		frame.getContentPane().add(subjectTextField);
		subjectTextField.setColumns(10);
		
		FromtextField = new JTextField();
		FromtextField.setBounds(314, 51, 130, 26);
		frame.getContentPane().add(FromtextField);
		FromtextField.setColumns(10);
		
		DatetextField = new JTextField();
		DatetextField.setBounds(314, 89, 130, 26);
		frame.getContentPane().add(DatetextField);
		DatetextField.setColumns(10);
		
		JLabel lblFromLabel = new JLabel("From:");
		lblFromLabel.setBounds(277, 56, 36, 16);
		frame.getContentPane().add(lblFromLabel);
		
		JLabel lblToLabel = new JLabel("To:");
		lblToLabel.setBounds(187, 56, 20, 16);
		frame.getContentPane().add(lblToLabel);
		
		JLabel lblSubjectLabel = new JLabel("Subject:");
		lblSubjectLabel.setBounds(157, 94, 50, 16);
		frame.getContentPane().add(lblSubjectLabel);
		
		JLabel lblDateLabel = new JLabel("Date:");
		lblDateLabel.setBounds(277, 94, 36, 16);
		frame.getContentPane().add(lblDateLabel);
		
		JTree treePane = new JTree();
		treePane.setBounds(10, 74, 135, 198);
		frame.getContentPane().add(treePane);
		
		JEditorPane editorPaneOutput = new JEditorPane();
		editorPaneOutput.setBounds(157, 116, 287, 100);
		frame.getContentPane().add(editorPaneOutput);
		
		JEditorPane statusPane = new JEditorPane();
		statusPane.setBounds(221, 228, 223, 44);
		frame.getContentPane().add(statusPane);
		
		JLabel lblStatusLabel = new JLabel("Status:");
		lblStatusLabel.setBounds(170, 241, 49, 16);
		frame.getContentPane().add(lblStatusLabel);
		
		JLabel lblMessageLabel = new JLabel("Messages for Eric.Sandlin");
		lblMessageLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 10));
		lblMessageLabel.setBounds(10, 51, 135, 16);
		frame.getContentPane().add(lblMessageLabel);
	}
	/**
	    * actionPerformed is defined by the ActionListener interface.
	    * An object of FolderBrowser registers itself to hear about action events
	    * caused by the <b>Button Clicks</b> and <b>Menu selecions (none here)</b>.
	    * @param ActionEvent the event object created by the source of the
	    * button push (the JButton object.)
	    */
	   public void actionPerformed(ActionEvent e) {
	      // the actions in this method do NOT reflect what has to be done in handling
	      // these different actions, but are designed to demonstrate how to access the
	      // view objects.

	      // If you do something (in here or anywhere) that takes lots of time, you may want
	      // to change the cursor to an hourglass (waitcursor) while you're doing it. Really
	      // though, you should use a javax.swing.SwingWorker class to perform any long-lasting
	      // operations in the background, so the UI is not frozen while a network
	      // or other long lasting operation is performed. Users don't like non-responsive apps.
		//setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		   // put switch case here
	      if(e.getActionCommand().equals("Delete")) {
	    	  
	      }
	      else if(e.getActionCommand().equals("Reply")) {
	    	  
	      }
	      else if(e.getActionCommand().equals("Send Text")) {
	    	  
	      }
	      else if(e.getActionCommand().equals("Send Cipher")) {
	    	  
	      } 
	}
	
	/**
	 * @param e
	 */
	public void valueChanged(ListSelectionEvent e) {
		      // If you do something (in here or anywhere) that takes lots of time, you may want
		      // to change the cursor to hourglass (waitcursor) while you're doing it. See
		      // the setCursor calls in the actionPerformed method. Really, though you
		      // should use a javax.swing.SwingWorker class to perform any long-lasting
		      // operations in the background, so the UI is not frozen while a network
		      // or other long lasting operation is performed.

		      // the call to getvalueisadjusting determines whether we're being called
		      // for the last in a sequence of related (event-generating) user actions.
		      // we generally don't want to redo handling multiple times.
	   }
	
}
