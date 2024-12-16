package com.sourav.parameterizedTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;

public class EnumSourceDemo {

	@ParameterizedTest
	@EnumSource(value = EnumAnimalValue.class)
	public void enumSourceDemoTest(EnumAnimalValue EnumAnimalValue) {
		assertNotNull(EnumAnimalValue);
	}
	
	@ParameterizedTest
	@EnumSource(value = EnumAnimalValue.class, names = {"DOG", "CAT"})
	public void enumSourceDemoWithNamesTest(EnumAnimalValue EnumAnimalValue) {
		assertNotNull(EnumAnimalValue);
	}
	
	@ParameterizedTest
	@EnumSource(value = EnumAnimalValue.class, mode = Mode.EXCLUDE, names = {"DOG", "CAT"})
	public void enumSourceDemoWithExcludeModeTest(EnumAnimalValue EnumAnimalValue) {
		assertNotNull(EnumAnimalValue);
	}
	
	@ParameterizedTest
	@EnumSource(value = EnumAnimalValue.class, mode = Mode.MATCH_ALL, names = "^(C|L).+$")
	public void enumSourceDemoWithMatchAllModeTest(EnumAnimalValue EnumAnimalValue) {
		assertNotNull(EnumAnimalValue);
	}
	
}