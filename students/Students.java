package students;

import sim.engine.*;
import sim.util.*;
import sim.field.grid.ObjectGrid2D;

public class Students extends SimState {

	public ObjectGrid2D yard = new ObjectGrid2D(100,100);

	public Students(long seed) {
		super(seed);
	}

	public void start() {
		super.start();
	}

	public static void main(String[] args) {
		doLoop(Students.class, args);
		System.exit(0);
	}
}
