package students;

import sim.engine.*;
import sim.util.*;
import sim.field.grid.ObjectGrid2D;

public class Students extends SimState {

	public ObjectGrid2D yard = new ObjectGrid2D(10,10);

	public Students(long seed) {
		super(seed);
	}

	public void start() {
		super.start();

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if ((i%2)==0 || (j%2)==0) {
					yard.set(i, j, new Object());
				}
			}
		}

		schedule.scheduleRepeating(schedule.EPOCH, 1, 
				new Steppable() {public void step(SimState state) {}});
	}

	public static void main(String[] args) {
		doLoop(Students.class, args);
		System.exit(0);
	}
}
