package com.engineeringdigest.journalApp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
// or just use @Data
@Builder
public class JournalEntry {

	private long id;
	private String title;
	private String content;



}
