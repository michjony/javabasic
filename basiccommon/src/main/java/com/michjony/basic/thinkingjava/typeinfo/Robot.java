package com.michjony.basic.thinkingjava.typeinfo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.michjony.basic.util.Null;

public interface Robot {
	static final Logger LOGGER = Logger.getLogger("Robot");

	String name();

	String model();

	List<Operation> operations();

	class Test {

		public static void main(String[] args) {
			LOGGER.log(Level.INFO, "Test main");
		}

		public static void test(Robot r) {
			if (r instanceof Null) {
				LOGGER.log(Level.INFO, "[Null Robot]");
			}

			LOGGER.log(Level.INFO, "Robot name : " + r.name());
			LOGGER.log(Level.INFO, "Robot model : " + r.model());
			for (Operation oper : r.operations()) {
				LOGGER.log(Level.INFO, "description:" + oper.description());
				oper.command();
			}
		}

	}

	public static void main(String[] args) {
		LOGGER.log(Level.INFO, "Robot main");
	}
}
