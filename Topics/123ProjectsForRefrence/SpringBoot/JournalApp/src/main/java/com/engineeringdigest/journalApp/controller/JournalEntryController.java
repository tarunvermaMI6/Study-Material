package com.engineeringdigest.journalApp.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engineeringdigest.journalApp.entity.JournalEntry;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

	Map<Long, JournalEntry> mapOfJournals = new HashMap<>();

	@GetMapping
	public Map<Long, JournalEntry> getJournals() {

		return mapOfJournals;
	}

	@PostMapping
	public ResponseEntity<?> createJournal(@RequestBody JournalEntry journal) {

		try {
			mapOfJournals.put(journal.getId(), journal);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<JournalEntry>(mapOfJournals.get(journal.getId()),HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> updateJournal(@RequestBody JournalEntry journal) {

		try {
			mapOfJournals.remove(journal.getId());
			mapOfJournals.put(journal.getId(), journal);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<JournalEntry>(mapOfJournals.get(journal.getId()),HttpStatus.OK);
	}

	@DeleteMapping("/id/{id}")
	public ResponseEntity<?> removeJournal(@PathVariable long id) {

		try {
			JournalEntry journal = mapOfJournals.get(id);
			mapOfJournals.remove(journal.getId());
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
		}

	@GetMapping("/id/{id}")
	public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable long id) {

		Optional<JournalEntry> journalEntry = Optional.ofNullable(mapOfJournals.get(id));
		return journalEntry.map(entry->new ResponseEntity<JournalEntry>(entry,HttpStatus.OK)).orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
		/*
		try {
			
			if (journalEntry.isPresent()) {
				return new ResponseEntity<JournalEntry>(mapOfJournals.get(id), HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<JournalEntry>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<JournalEntry>(HttpStatus.NOT_FOUND); */
	}

}
