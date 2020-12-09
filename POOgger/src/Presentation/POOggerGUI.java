package Presentation;

import java.util.ArrayList;
import java.util.HashMap;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Domain.Component;
import Domain.Frog;
import Domain.Movable;
import Domain.POOgger;

public class POOggerGUI extends JFrame implements Runnable{

	private static final long serialVersionUID = 1L;
	
	//Thread elements
	private static Thread thread;
	private static volatile boolean running = false;
	private static volatile boolean resume = false;
	private final int FPS = 60;
	private double TARGETTIME = 1000000000/FPS;
	private double delta = 0;
	
	
	
	//Initial menu elements
	private Background background, logo;
	private myButton start, options, exit;
	
	//Options menu elements
	private final JFileChooser fc = new JFileChooser();
	private myButton save, open, back;
	private myComboBox mode, map;
	private JLabel mapLabel, modeLabel;
	
	//Ingame elements
	private Container container;
	private Background gameBackGround;
	private JLabel nightBackground, timeJlabel;
	private static Keyboard keyboard;
	private static POOgger poogger;		
	private Frog[] characters;
	private ArrayList<Movable> movables;
	private ArrayList<Component> homes;
	private ArrayList<JLabel> characters_images;
	private ArrayList<JLabel> movables_images;
	private ArrayList<JLabel> homes_images;
	private ArrayList<JLabel> lifes_labels;
	
	private static final HashMap<String, String> dirs = new HashMap<String, String>(){{
		put("Day", "/Resources/Maps/AtDay/MapDay.jpg");
		put("Night", "/Resources/Maps/AtDay/MapNight.png");
		put("Frog1", "/Resources/Froggs/Frog1.png");
		put("Frog2", "/Resources/Froggs/Frog2.png");
		put("Car1", "/Resources/InStreet/Car1.png");
		put("Car2", "/Resources/InStreet/Car2.png");
		put("Bus1", "/Resources/InStreet/Bus1.png");
		put("Trunk", "/Resources/InRiver/Trunk.png");
		put("Turtles", "/Resources/InRiver/Turtle.png");
		put("Snake", "/Resources/InRiver/Snake.png");
		put("Carreta1", "/Resources/InStreet/Carreta1.png");
		put("Bike", "/Resources/InStreet/Bicycle.png");
		put("Home", "/Resources/AtHome/AtHome.png");
		
		}};	
	
	/**
	 *  POOggerGUI constructor allows you to create the JFrame to add all graphical elements.
	 */
	POOggerGUI() {
		super("POOGGER");
		setSize(745, 750);
		container = getContentPane();
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("/Resources/Icon/Icon.png")).getImage());
		menu();
	}
	

	//Mehthods for prepare initial GUI.
	
	/**
	 * Calls elements and actions to create the initial menu panel.
	 */
	private void menu() {
		prepareInitialElements();
		prepareActions();
		repaint();
	}	
	
	/**
	 * Create the initial menu panel with all its elements. 
	 */
	private void prepareInitialElements() {		
		background = new Background();
		background.setBackground(new ImageIcon(getClass().getResource("/Resources/Icon/background.jpg")));
		background.setBounds (0,0,745,750);
		logo = new Background();
		logo.setBackground(new ImageIcon(getClass().getResource("/Resources/Icon/Icon.png")));
		logo.setBounds (72,50,600,360);
		
		container.setLayout(null);
		start = new myButton("START");
		start.setLocation(172,450);
		start.setForeground(Color.YELLOW);
		options = new myButton("OPTIONS");
		options.setLocation(172,540);
		options.setForeground(Color.GREEN);
		exit = new myButton("EXIT");
		exit.setLocation(172,630);
		exit.setForeground(Color.MAGENTA);
		
		container.add(start);
		container.add(options);
		container.add(exit);
		container.add(logo);
		container.add(background);
	}
	
	/**
	 * Prepares all listeners for all buttons on the initial menu panel.
	 */
	private void prepareActions() {
		ActionListener exitListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				exit();				
			}
		};
		
		exit.addActionListener(exitListener);
		
		ActionListener optionsListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				options();				
			}
		};

		options.addActionListener(optionsListener);
		
		ActionListener startListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				startGame();				
			}
		};

		start.addActionListener(startListener);
	}
	
	
	/**
	 * Executes all actions assigned to the exit button.
	 */
	private void exit() {
		this.dispose();
		System.exit(0);
	}
	
	/**
	 * Executes all actions assigned to the options button.
	 */
	private void options() {
		poogger = POOgger.getPoogger();
		getContentPane().removeAll();		
		prepareOptionsElements();
		prepareOptionsActions();
		repaint();
	}
	
	/**
	 * Executes all actions assigned to the start button. Deletes the panel and creates the game panel.
	 */
	private void startGame() {
		getContentPane().removeAll();		
		prepareGameElements();
		repaint();
		this.begin();
	}

	//Methods for ingame GUI.
	/**
	 * Create the game panel with all its elements.  
	 */
	private void prepareGameElements() {
		keyboard = new Keyboard();
		addKeyListener(keyboard);		
		
		poogger = POOgger.getPoogger();
		characters = poogger.getCharacters();
		homes = poogger.getHomes();
		movables = poogger.getMovables();
		gameBackGround = new Background();
		gameBackGround.setBackground(new ImageIcon(getClass().getResource(dirs.get("Day"))));
		gameBackGround.setBounds (0,0,745,750);
		container.setLayout(null);
		
				
		timeJlabel = new JLabel();
		timeJlabel.setSize(200, 60);
		timeJlabel.setLocation(350,698);
		timeJlabel.setFont(new Font("Arial", Font.BOLD, 40));
		timeJlabel.setForeground(Color.white);
		container.add(timeJlabel);
		
		lifes_labels = new ArrayList<JLabel>();
		for (int i = 0; i < characters.length; i++) {
			JLabel lifeLabel = new JLabel();
			lifeLabel.setSize(200, 60);
			lifeLabel.setLocation(10,698);
			lifeLabel.setFont(new Font("Arial", Font.BOLD, 40));
			lifeLabel.setForeground(Color.white);
			lifeLabel.setVisible(false);			
			lifes_labels.add(lifeLabel);
			container.add(lifeLabel);
		}

		//Lifes label second player
		if (characters.length == 2) {
			lifes_labels.get(1).setLocation(575,698);
		}	
			
		
		nightBackground =  new JLabel(new ImageIcon(getClass().getResource(dirs.get("Night"))));
		nightBackground.setSize(745,750);
		nightBackground.setVisible(false);
		container.add(nightBackground);
		
		
		characters_images = new ArrayList<JLabel>();
		Movable[] froggs = poogger.getCharacters();
		for (int i = 0; i < characters.length; i++) {
			String name = froggs[i].getName();
			String ruta = dirs.get(name);
			JLabel frog =  new JLabel(new ImageIcon(getClass().getResource(ruta)));
			frog.setSize(50,37);
			characters_images.add(frog);
			container.add(frog);
		}
		
		homes_images = new ArrayList<JLabel>();
		for (Component h: homes) {
			String name = h.getName();
			String ruta = dirs.get(name);
			JLabel element = new JLabel(new ImageIcon(getClass().getResource(ruta)));
			int[] values = h.getValues();
			element.setSize(values[2], values[3]);
			element.setLocation(values[0], values[1]);
			homes_images.add(element);
			container.add(element);
			
		}
				
		
		movables_images = new ArrayList<JLabel>();
		for (Movable m: movables) {
			String name = m.getName();
			String ruta = dirs.get(name);
			JLabel element = new JLabel(new ImageIcon(getClass().getResource(ruta)));
			int[] values = m.getValues();
			element.setSize(values[2], values[3]);
			movables_images.add(element);
			container.add(element);
		}
		
		container.add(gameBackGround);
	}	
	
	//Methods for Options
	
	/**
	 * 
	 */
	private void prepareOptionsElements() {
		background = new Background();
		background.setBackground(new ImageIcon(getClass().getResource("/Resources/Icon/background.jpg")));
		background.setBounds (0,0,745,750);
		
		container.setLayout(null);
		mapLabel = new JLabel("Map");
		mapLabel.setSize(200, 60);
		mapLabel.setLocation(172,65);
		mapLabel.setFont(new Font("Arial", Font.BOLD, 40));
		mapLabel.setForeground(new Color(30,30,30));
		map = new myComboBox();
		map.addItem("Day");
		map.addItem("Night");
		map.setLocation(172, 120);
		map.setSelectedItem(poogger.getMapType());
		
		modeLabel = new JLabel("Mode");
		modeLabel.setSize(200, 60);
		modeLabel.setLocation(172,229);
		modeLabel.setFont(new Font("Arial", Font.BOLD, 40));
		modeLabel.setForeground(new Color(30,30,30));
		mode = new myComboBox();
		mode.addItem("Arcade");
		mode.addItem("Player vs Player");
		mode.addItem("Player vs Machine");
		mode.addItem("Machine vs Machine");
		mode.setLocation(172, 284);
		mode.setSelectedItem(poogger.getMode());
	
		
		save = new myButton("SAVE");
		save.setLocation(172,450);
		save.setForeground(Color.YELLOW);
		open = new myButton("OPEN");
		open.setLocation(172,540);
		open.setForeground(Color.GREEN);
		back = new myButton("BACK");
		back.setLocation(172,630);
		back.setForeground(Color.MAGENTA);
		
		container.add(mapLabel);
		container.add(map);
		container.add(mode);
		container.add(modeLabel);
		container.add(save);
		container.add(open);
		container.add(back);
		container.add(background);	
	}
	
	/**
	 * Prepares all listeners for all buttons on the initial menu panel.
	 */
	private void prepareOptionsActions() {
		ActionListener backListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				poogger.setMode(mode.getSelectedItem().toString());
				poogger.setMapType(map.getSelectedItem().toString());
				getContentPane().removeAll();
				menu();
			}
		};
		
		back.addActionListener(backListener);
		
		ActionListener saveListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				save();				
			}
		};
		
		save.addActionListener(saveListener);
		
		ActionListener openListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				open();
			}
		};
		
		open.addActionListener(openListener);
		
	}
	
	/**
	 * Prepare elements to save the current game.
	 */
	private void save() {		
		fc.setSelectedFile(new File("unPOOgger.dat"));
    	fc.setDialogTitle("Save");
    	fc.setApproveButtonText("Select");
    	int approve = fc.showOpenDialog(null);
    	if (approve == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            if (!file.exists()) {
            	try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
            poogger.save(file);
    	}
	}
	
	/**
	 * Prepare elements for open new game.
	 */
	private void open() {
		fc.setApproveButtonText("Select");
    	int approve = fc.showOpenDialog(null);
    	if (approve == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            poogger.open(file);
            getContentPane().removeAll();
            startGame();
    	}
	}
	
	
	//Methods for Thread 
	
	/**
	 * Creates a new Thread and executes it.
	 */
	public synchronized void begin() {
		running = POOgger.isRunning;
		thread = new Thread(this, "GUI");
		thread.start();
	}
	
	/**
	 * Executes the main cyclo in the thread.
	 */
	public void run() {
		requestFocus();
		long now = 0;
		long lastTime = System.nanoTime();
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime)/TARGETTIME;
			lastTime = now;
			if(delta >= 1){
				
				update();
				delta = 0;
				if(keyboard.esc) {			
					running = false;
					resume = true;
					getContentPane().removeAll();
					menu();
					repaint();
				}
			}
		}
		if (!resume) {
			restart();
		}
	}
	
	/**
	 * Returns to the start menu when the game is over.
	 */
	private void restart() {
		getContentPane().removeAll();
		prepareRestart();
		try {
			thread.sleep(2000);
			getContentPane().removeAll();
			poogger.newPoogger();
			menu();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Kills the thread.
	 */
	public synchronized void finish() {		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Prepare the final GUI when the game is over
	 */
	private void prepareRestart() {
		getContentPane().removeAll();
		
		JLabel background =  new JLabel(new ImageIcon(getClass().getResource(dirs.get("Day"))));
		background.setSize(745,750);
		background.setLocation(0,0);
		
		JLabel gameOver =  new JLabel(new ImageIcon(getClass().getResource("/Resources/Icon/gameOver.png")));
		gameOver.setSize(476,247);
		gameOver.setLocation(134,251);
		
		container.add(gameOver);
		container.add(background);
		repaint();
	}
	
	/**
	 * Updates all objects in the game.
	 */
	private void update() {
		keyboard.update();
		poogger.update();
		running = POOgger.isRunning;
		resume = running;
				
		for (int frog = 0; frog < characters.length; frog++) {
			Frog f = characters[frog]; 
			if(keyboard.up[frog]) {			
				f.jump('U');
			}
			
			if(keyboard.down[frog]) {
				f.jump('D');
			}
			
			if(keyboard.left[frog]) {
				f.jump('L');
			}
			
			if(keyboard.right[frog]) {
				f.jump('R');
			}
		}
	
		for (Movable m: movables) {
			m.move();
		}
		
		draw();
	}
	
	
	/**
	 *Draws all the graphic elements of the game.
	 */
	private void draw() {
		
		timeJlabel.setText(String.valueOf(poogger.getTime()));
		if (poogger.getMapType().equals("Night")) {
			nightBackground.setVisible(true);
		}
		else {
			nightBackground.setVisible(false);
		}

		int i = 0;
		for (Frog f: characters) {
			int[] values = f.getValues();
			lifes_labels.get(i).setText("Lifes: " + String.valueOf(f.getLifes()));
			lifes_labels.get(i).setVisible(true);
			characters_images.get(i).setLocation(values[0], values[1]);
			i++;
		}
		
		i = 0;
		
		for (Component h: homes) {
			if (h.isVisible) {
				homes_images.get(i).setVisible(true);
			}
			else {
				homes_images.get(i).setVisible(false);
			}
			i++;
		}
		
		i = 0;
		
		for (Movable m: movables) {
			int[] values = m.getValues();
			movables_images.get(i).setLocation(values[0], values[1]);
			i++;
		}
	}
	

	/**
	 * Main java class.
	 */
	public static void main(String[] args) {
		POOggerGUI pooggerGUI = new POOggerGUI();
		pooggerGUI.setVisible(true);
	}
}
	