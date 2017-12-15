package com.michjony.basic.thinkingjava.typeinfo;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

/**
 * 扫雷Robot
 */
public class SnowRemovalRobot implements Robot {

	private String name;

	public SnowRemovalRobot(String name) {
		this.name = name;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public String model() {
		return "SnowBot Series 11";
	}

	@Override
	public List<Operation> operations() {
		List<Operation> opers = Arrays.asList(new Operation() {

			@Override
			public String description() {
				return name + " can shovel snow";
			}

			@Override
			public void command() {
				LOGGER.log(Level.INFO, "shoveling snow");
			}
		}, new Operation() {

			@Override
			public String description() {
				return name + " can chip ice";
			}

			@Override
			public void command() {
				LOGGER.log(Level.INFO, "chipping snow");
			}
		}, new Operation(){

			@Override
			public String description() {
				return name + " can clear the roof";
			}

			@Override
			public void command() {
				LOGGER.log(Level.INFO, "clearing roof");
			}
			
		});
		return opers;
	}
	public static void main(String[] args) {
		Robot.Test.test(new SnowRemovalRobot("SnowRemoval"));
	}
}
