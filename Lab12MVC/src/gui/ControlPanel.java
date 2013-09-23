package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observer;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import nim.Nim;

public class ControlPanel extends JPanel
{
	public Logger logObj = Logger.getLogger("Controller");
	private static Handler handler;

	public static final int WIDTH = 400;
	public static final int HEIGHT = 400;
	public static final int PLAYER1 = 0;
	public static final int PLAYER2 = 1;

	private Nim nim;
	private ArrayList<Observer> observerList;

	private JButton newGame;
	private JButton remove;
	private JButton computerTurn;
	private JSpinner spinner;
	private SpinnerModel spinnerModel;
	private JLabel howMany;

	public ControlPanel(Nim nim)
	{
		class HumanListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				humanTurn();
			}
		}

		class ComputerListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				computerTurn();
			}
		}
		class NewGameListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				newGame();
			}
		}

		observerList = new ArrayList<Observer>();

		// creates this handler
		// output will go to file named in argument
		try
		{
			handler = new FileHandler("Nim.log");
			// SimpleFormatter produces plain text(as opposed to XML)
			handler.setFormatter(new SimpleFormatter());
			logObj.addHandler(handler);
			logObj.setLevel(Level.ALL);
		} catch (SecurityException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		this.nim = nim;
		this.setBorder(BorderFactory.createRaisedBevelBorder());

		newGame = new JButton();
		newGame.setLayout(new BorderLayout());
		newGame.add(BorderLayout.NORTH, new JLabel("New"));
		newGame.add(BorderLayout.SOUTH, new JLabel("Game"));
		newGame.setEnabled(false);
		ActionListener newGameListener = new NewGameListener();
		newGame.addActionListener(newGameListener);

		spinnerModel = new SpinnerNumberModel(1, 1, nim.getNumberTokens() / 2,
				1);
		spinner = new JSpinner(spinnerModel);

		remove = new JButton();
		remove.setLayout(new BorderLayout());
		remove.add(BorderLayout.NORTH, new JLabel("Human:"));
		remove.add(BorderLayout.SOUTH, new JLabel("Remove"));
		ActionListener removeListener = new HumanListener();
		remove.addActionListener(removeListener);

		computerTurn = new JButton();
		computerTurn.setLayout(new BorderLayout());
		computerTurn.add(BorderLayout.NORTH, new JLabel("Computer:"));
		computerTurn.add(BorderLayout.SOUTH, new JLabel("Remove"));
		ActionListener oKListener = new ComputerListener();
		computerTurn.addActionListener(oKListener);

		howMany = new JLabel("How Many?");

		this.add(newGame);
		this.add(howMany);
		this.add(spinner);
		this.add(remove);
		this.add(computerTurn);
		newGame.setEnabled(false);
		updateControls();
	}

	public void computerTurn()
	{
		nim.takeTurn();
		if (nim.gameIsNotOver())
		{
			nim.setNextPlayer();
			updateSpinner();
			updateControls();
		} else
		{
			finishGame();
		}
	}

	public boolean validate(int pending)
	{
		boolean validated = true;
		if ((nim.getNumberTokens() == 1 && pending != 1)
				|| (pending < 1 || (nim.getNumberTokens() > 1 && pending > nim
						.getNumberTokens() / 2)))
		{
			JOptionPane.showMessageDialog(
					null,
					"You can only take between\n"
							+ "1 and "
							+ (nim.getNumberTokens() == 1 ? 1 : nim
									.getNumberTokens() / 2)
							+ " sticks from the pile");
			validated = false;
		}
		return validated;
	}

	public void takeTurn(int pending)
	{
		nim.takeTurn(pending);
		logObj.info("Human takes " + pending + " sticks");
	}

	public void humanTurn()
	{
		int pending = (Integer) spinner.getValue();
		if (validate(pending))
		{
			takeTurn(pending);

			if (nim.gameIsNotOver())
			{
				nim.setNextPlayer();
				updateControls();
			} else
			{
				finishGame();
			}
		}
	}

	public void newGame()
	{
		this.nim = new Nim(Nim.GUI_HUMAN_STRATEGY);
		updateSpinner();
		updateControls();
		newGame.setEnabled(false);
	}

	public void finishGame()
	{
		String message = "Player" + (nim.getCurrentPlayer() + 1) + " loses, "
				+ "Player" + (nim.getNextPlayer() + 1) + " wins!";
		logObj.info(message);
		spinner.setEnabled(false);
		remove.setEnabled(false);
		computerTurn.setEnabled(false);
		newGame.setEnabled(true);
	}

	public void updateSpinner()
	{
		int max = (nim.getNumberTokens() / 2 > 0 ? nim.getNumberTokens() / 2
				: 1);
		spinnerModel = new SpinnerNumberModel(1, 1, max, 1);
		spinner.setModel(spinnerModel);
	}

	public void updateControls()
	{
		spinner.setEnabled(nim.getCurrentPlayer() == PLAYER1 ? true : false);
		remove.setEnabled(nim.getCurrentPlayer() == PLAYER1 ? true : false);
		computerTurn.setEnabled(nim.getCurrentPlayer() == PLAYER2 ? true
				: false);
	}

	public void addObservers(Observer observer)
	{
		observerList.add(observer);
	}

	public void setObservers()
	{
		for (Observer o : observerList)
		{
			nim.addObserver(o);
		}
		nim.newGame();
	}
}