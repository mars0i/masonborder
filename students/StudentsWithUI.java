package students;

import sim.portrayal.grid.ObjectGridPortrayal2D;
import sim.engine.*;
import sim.display.*;
import javax.swing.*;
import java.awt.*;

public class StudentsWithUI extends GUIState {

	public Display2D display;
	public JFrame displayFrame;
	ObjectGridPortrayal2D gridPortrayal = new ObjectGridPortrayal2D();

	public static void main(String[] args) {
		StudentsWithUI vid = new StudentsWithUI();
		Console c = new Console(vid);
		c.setVisible(true);
	}

	public StudentsWithUI() { super(new Students(System.currentTimeMillis())); }
	public StudentsWithUI(SimState state) { super(state); }
	public static String getName() { return "border test"; }

	public void start() {
		super.start();
		setupPortrayals();
	}

	public void load(SimState state) {
		super.load(state);
		setupPortrayals();
	}

	public void setupPortrayals() {
		Students students = (Students) state;
		gridPortrayal.setField(students.yard);
		gridPortrayal.setGridLines(true);
		gridPortrayal.setBorder(true);
		display.reset();
		display.repaint();
		display.setBackdrop(Color.black);
	}

	public void init(Controller c) {
		super.init(c);
		display = new Display2D(600, 600, this);
		display.setClipping(false);
		displayFrame = display.createFrame();
		displayFrame.setTitle("Border Test");
		c.registerFrame(displayFrame);
		displayFrame.setVisible(true);
		display.attach(gridPortrayal, "Test");
	}

	public void quit() {
		super.quit();
		if (displayFrame!=null) displayFrame.dispose();
		displayFrame = null;
		display = null;
	}
}
