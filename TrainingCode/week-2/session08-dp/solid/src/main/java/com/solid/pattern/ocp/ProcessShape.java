package com.solid.pattern.ocp;

//OCP
public class ProcessShape {

	//never a stable class OCP, good
	public static void process(Shape shape) {
		shape.draw();
	}
}
