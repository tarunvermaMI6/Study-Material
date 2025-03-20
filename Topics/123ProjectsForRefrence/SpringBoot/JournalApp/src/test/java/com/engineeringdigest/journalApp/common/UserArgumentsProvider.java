package com.engineeringdigest.journalApp.common;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import com.engineeringdigest.journalApp.entity.User;

public class UserArgumentsProvider implements ArgumentsProvider  {

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		
		
		return Stream.of(
				
				Arguments.of(User.builder().userName("tarun").password("1234").build()),
				Arguments.of(User.builder().userName("tarun1").password("1234").build()),
				Arguments.of(User.builder().userName("tarun2").password("1234").build())
				
				);
	}

}
