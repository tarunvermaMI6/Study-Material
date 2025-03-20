package com.engineeringdigest.multithreading.revison;

import java.util.Optional;

public class OptionalExample {

	// optional act like a box that handle the null

	public static void main(String[] args) {

		Optional<String> optional = gettingTheOptional();
		// optional.get().toUpperCase(); /// give exception
		if (optional.isPresent()) {
			System.out.println(optional.get().toUpperCase());
		}

		String name = optional.isPresent() ? optional.get() : "";

		// or

		name = optional.orElse("NA");

		optional.ifPresent(x -> System.out.println(x.toUpperCase()));

		// we can change in the value inside the box or take the value out

		// like

		Optional<String> op = optional.map(x -> x.toUpperCase());
		optional.ifPresent(x -> System.out.println(x));

	}

	public static Optional<String> gettingTheOptional() {

		String gettingFromDB = null;
		gettingFromDB = "taun";
		return Optional.ofNullable(gettingFromDB);
	}

	// giving null , sad
	public static String getTheString() {

		String gettingFromDB = null;
		
		return gettingFromDB;

	}
}
