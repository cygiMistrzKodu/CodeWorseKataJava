package com.java8.mySamples;

import static org.junit.Assert.*;

import org.junit.Test;

public class GenericksTesting {

	@Test
	public void test() {

		SomethingWithGenericks<Integer, String, Integer, String> lalaString = new SomethingWithGenericks<>();

		lalaString.setSomething(100);

		System.out.println(lalaString.getSomething());

		System.out.println(lalaString.addSomething( 45555545345d,  4555553453464d));

	}

	class SomethingWithGenericks<T, U, W, Z> {

		private T something;

		public T getSomething() {
			return something;
		}

		public void setSomething(T something) {
			this.something = something;
		}

		public <W extends Number> W addSomething(W w, W z) {

			if (w instanceof Integer) {

				Integer in = w.intValue() + z.intValue();

				return (W) in;
			}

			Double d = w.doubleValue() + z.doubleValue();

			return (W) d;
		}

	}

}
