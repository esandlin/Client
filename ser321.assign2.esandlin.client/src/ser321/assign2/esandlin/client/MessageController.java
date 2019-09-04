package client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListModel;

import client.Message;

public class MessageController {
	public static DefaultListModel fillMessageList() {
		DefaultListModel model = new DefaultListModel();
		model.add(0, "Message 1");
		return model;
	}
}
