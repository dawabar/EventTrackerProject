package com.skilldistillery.chores.services;

import java.util.List;

import com.skilldistillery.chores.entities.Entry;

public interface EntryService {

	public List<Entry> index();
	
	public Entry findById(Integer entryId);
	
	public Entry createEntry(Entry entry, Integer choreId);
	
	public Entry updateEntry(Integer entryId, Entry entry);

	public void deleteEntry(Integer entryId);

	public boolean entryExists(Integer entryId);
}
