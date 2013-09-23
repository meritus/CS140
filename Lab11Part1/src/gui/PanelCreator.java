package gui;

import javax.swing.JPanel;
import game.Game;

/**
 * This class creates and delivers the controller and view panels for the
 * NewZorkGUI, and creates and delivers the model to the controller, which
 * passes it on to the view
 * 
 * @author Rose Williams
 * 
 */
public class PanelCreator
{
	// Instance Variables
	// --------------------------------------------------------

	/**
	 * This game is the MODEL that will be controlled by the controller, and
	 * displayed by the view
	 */
	private Game game;

	/**
	 * This controller is the CONTROLLER that the user will use to interact with
	 * the MODEL
	 */
	private JPanel controller;

	/**
	 * This view is the VIEW that the user will use to view aspects about the
	 * MODEL
	 */
	private JPanel view;

	// Constructors
	// --------------------------------------------------------------

	/**
	 * Create a new game, create a new controller and send the game to it Get
	 * the view back from the controller
	 */
	public PanelCreator()
	{
		game = new Game();
		controller = new Controller(game);
		view = ((Controller) controller).getView();
	}

	/**
	 * Returns the controller panel
	 * 
	 * @return the controller
	 */
	public JPanel getControlPanel()
	{
		return controller;
	}

	/**
	 * Returns the view panel
	 * 
	 * @return the view
	 */
	public JPanel getViewPanel()
	{
		return view;
	}
}