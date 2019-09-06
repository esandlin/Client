package esandlin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JTextField;

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

public class Controller {
	
	private View theView;
	private Model theModel;
	
	public Controller(View theView, Model theModel) {
		this.theView = theView;
		this.theModel = theModel;
		
		/*
		 *  Tell the View that when ever the calculate button
		 *  is clicked to execute the actionPerformed method
		 *  in the CalculateListener inner class
		 */
		
		
		this.theView.addDeleteListener(new CalculateListener());
		this.theView.addReplyListener(new CalculateListener());
		this.theView.addSendListener(new CalculateListener());
		this.theView.addCipherListener(new CalculateListener());
	}
	
	
	class CalculateListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			// int firstNumber, secondNumber = 0;
			JTextField to, from, date, subject;
			
			/*
			 * Surround interactions with the view with
			 * a try block in case numbers weren't
			 * properly entered
			 */
			
			try{
			
				to = theView.getToTextField();
				from = theView.getFromtextField();
				date = theView.getDateTextField();
				subject = theView.getSubjectTextField();
				
				//theModel.addTwoNumbers(firstNumber, secondNumber);
				
				// theView.setCalcSolution(theModel.getCalculationValue());
				
			}

			catch(NumberFormatException ex){
				
				System.out.println(ex);
				
				theView.displayErrorMessage("Something went wrong. ");
				
			}
			
		}
		
	}
	
public static void main(String[] args) {
    	
    	View theView = new View();
        
    	Model theModel = new Model();
    	
    	Controller theController = new Controller(theView,theModel);
        
        theView.setVisible(true);
        
    }
	
}