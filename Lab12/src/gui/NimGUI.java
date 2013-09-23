package gui;

/**
*
*Michelle Hochman
*mhochma1@binghamton.edu
*Lab 10
*/

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import nim.Nim;

/**
 * This class implements the nim gui
 * @author Michelle
 *
 */
public class NimGUI
{  
	/**
	 * frame instance variable
	 */
  private JFrame frame;
  /**
   * controller instance vairable
   */
  private JPanel controller;
  /**
   * view instance variable
   */
  private JPanel view;
  /**
   * nim instance variable
   */
  private Nim nim;
  
  /**
   * default constructor
   */
  public NimGUI()
  {
    this.frame = new JFrame("Nim");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    frame.setSize(450, 500);
    Nim nim = new Nim(Nim.GUI_HUMAN_STRATEGY);
    controller = new ControlPanel(nim);
    //view = ((ControlPanel)controller).getView();
    view = new ViewPanel();
    ((ControlPanel)controller).addObservers((Observer)view);
    ((ControlPanel)controller).setObservers();
    frame.add(controller, BorderLayout.NORTH);
    frame.add(view, BorderLayout.CENTER);
    frame.setVisible(true); 
  }
  
  /**
   * main method
   * @param args
   */
  public static void main(String[] args) 
  {
    class EventDispatchingThread implements Runnable 
    {
      public void run() 
      {
        NimGUI game = new NimGUI();
      }
    }
    javax.swing.SwingUtilities.invokeLater(new EventDispatchingThread());
  }

}
