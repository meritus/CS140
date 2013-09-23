package gui;

import java.awt.BorderLayout;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import nim.Nim;

public class NimGUI
{
	private static final String ControlPanel = null;
	private JFrame frame;
	private JPanel controller;
	private JPanel view;
	private Nim nim;

	public NimGUI()
	{
		this.frame = new JFrame("Nim");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 500);
		Nim nim = new Nim(Nim.GUI_HUMAN_STRATEGY);
		controller = new ControlPanel(nim);
		view = new ViewPanel();
		((ControlPanel) controller).addObservers((Observer) view);
		((ControlPanel) controller).setObservers();
		frame.add(controller, BorderLayout.NORTH);
		frame.add(view, BorderLayout.CENTER);
		frame.setVisible(true);
	}

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
