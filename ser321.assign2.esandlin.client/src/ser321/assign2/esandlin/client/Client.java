package ser321.assign2.esandlin.client;

import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.EventQueue;
import javax.swing.JFrame;

/*
 * Copyright 2019 Tim Lindquist,
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Purpose: demonstrate use of MessageGui class for students to use as a
 * basis for solving Ser321 Spring 2019 Homework Problems.
 * The class SampleClient can be used by students in constructing their 
 * controller for solving homework problems. The view class is MessageGui.
 *
 * This problem set uses a swing user interface to implement (secure) messaging.
 * Messages are communicated to/from message clients, via a common well-known.
 * server.
 * Messages can be sent in clear text, or using password based encryption 
 * (last assignment). For secure messages, the message receiver must enter
 * the password (encrypted).
 * The Message tab has two panes. left pane contains a JList of messages
 * for the user. The right pane is a JTextArea, which can display the
 * contents of a selected message. This pane is also used to compose
 * messages that are to be sent.
 *
 * Ser321 Principles of Distributed Software Systems
 * see http://pooh.poly.asu.edu/Ser321
 * @author Tim Lindquist Tim.Lindquist@asu.edu
 *         Software Engineering, CIDSE, IAFSE, ASU Poly
 * @version January 2019
 */

public class Client implements MessageLibrary, ActionListener, ListSelectionListener {

	private String user; // originator of all message sent by this client.
	private String serverHostPort; // such as lindquisrpi.local:8080
	private static final String patt = "EEE MMM d K:mm:ss yyyy";

	public Client(String user, String hostPort) {
		super("esandlin", user);
		this.user = user;
		this.serverHostPort = hostPort;
// add this object as an action listener for all menu items.
		for (int j = 0; j < userMenuItems.length; j++) {
			for (int i = 0; i < userMenuItems[j].length; i++) {
				userMenuItems[j][i].addActionListener(this);
			}
		}

// add this object as an action listener for the view buttons
		deleteJB.addActionListener(this);
		replyJB.addActionListener(this);
		sendTextJB.addActionListener(this);
		sendCipherJB.addActionListener(this);

// listen for the user to select a row in the list of messages.
// When a selection is made, the method valueChanged will be called.
		messageListJL.addListSelectionListener(this);

		setVisible(true);
	}

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
		if (!e.getValueIsAdjusting()) {
			messageContentJTA.setText(" You selected messageList item: " + messageListJL.getSelectedIndex());
			System.out.println("You selected messageList item: " + messageListJL.getSelectedIndex());
		}
	}

	public void actionPerformed(ActionEvent e) {
// the actions in this method do NOT reflect what has to be done in handling
// these different actions, but are designed to demonstrate how to access the
// view objects.

// If you do something (in here or anywhere) that takes lots of time, you may want
// to change the cursor to an hourglass (waitcursor) while you're doing it. Really
// though, you should use a javax.swing.SwingWorker class to perform any long-lasting
// operations in the background, so the UI is not frozen while a network
// or other long lasting operation is performed. Users don't like non-responsive apps.
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

		if (e.getActionCommand().equals("Exit")) {
			System.exit(0);
		} else if (e.getActionCommand().equals("Reply")) {
			DefaultListModel<String> dlm = (DefaultListModel<String>) messageListJL.getModel();
			Date today = new Date();
			SimpleDateFormat form = new SimpleDateFormat(patt);
			String todayStr = form.format(today);
			dlm.addElement(" Jimmy.Buffet     " + todayStr);
			messageListJL.setSelectedIndex(0);
			fromJTF.setText(user);
			toJTF.setText("Jimmy.Buffet");
			subjectJTF.setText("Fins");
			dateJTF.setText(todayStr);
			messageContentJTA.setText("fins to the left, fins to the right and" + " you're the only bait in town.");
			messageStatusJTA.setText(" *(Insecure, sent as clear text.)*");
		} else if (e.getActionCommand().equals("Delete")) {
			DefaultListModel dlm = (DefaultListModel) messageListJL.getModel();
			int selected = messageListJL.getSelectedIndex();

			String fromNDateStr = selected > -1 ? (String) dlm.getElementAt(selected) : "no selection";
			System.out.println("request to delete message index: " + selected + " text: " + fromNDateStr);
			if (selected > -1) {
				dlm.removeElementAt(selected);
			}
//dlm.clear(); //use this to clear the entire list.
			fromJTF.setText(user);
			toJTF.setText("");
			subjectJTF.setText("");
			messageContentJTA.setText("");
			messageStatusJTA.setText("");
		}

// get rid of the waiting cursor
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

	public static void main(String args[]) {
		try {
			String name = "esandlin";
			String hostPort = "localhost:8080";
			if (args.length >= 2) {
				name = args[0];
				hostPort = args[1];
			}
			Client myMailClient = new Client(name, hostPort);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
