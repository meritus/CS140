package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import nim.Nim;

public class NimGUI
{  
  private JFrame frame;
  private JPanel controller;
  private JPanel view;
  private Nim nim;
  
  /**
   * Creates, fills and displays frame
   */
  public NimGUI()
  {
    this.frame = new JFrame("Nim");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    frame.setSize(450, 450);
    
    Nim nim = new Nim();  // Create MODEL
    
    controller = new ControlPanel(nim); // Create CONTROLLER
    view = new ViewPanel(); // Create VIEW

    frame.add(controller, BorderLayout.NORTH);
    frame.add(view, BorderLayout.CENTER);
    frame.setVisible(true); 
  }
  
  /**
   * "Boilerplate" code to use for GUI main methods:
   * @param args
   */
  public static void main(String[] args) 
  {
    class EventDispatchingThread implements Runnable 
    {
      public void run() 
      {
       new NimGUI(); //anonymous object
      }
    }
    javax.swing.SwingUtilities.invokeLater(new EventDispatchingThread());
  }

}
