package com.skilldistillery.chores.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.chores.entities.Chore;
import com.skilldistillery.chores.entities.Entry;
import com.skilldistillery.chores.repositories.ChoreRepository;
import com.skilldistillery.chores.repositories.EntryRepository;

@Service
public class EntrySerivceImpl implements EntryService {

	@Autowired
	private EntryRepository entryRepo;

	@Autowired
	private ChoreRepository choreRepo;

	@Override
	public List<Entry> index() {
		return entryRepo.findAll();
	}

	@Override
	public Entry createEntry(Entry entry, Integer choreId) {
		Optional<Chore> op = choreRepo.findById(choreId);
		Chore chore = null;
		if (op.isPresent()) {
			chore = op.get();
			entry.setChore(chore);
			entryRepo.saveAndFlush(entry);
		}
		else {
			entry = null;
		}
		return entry;
	}

	@Override
	public Entry findById(Integer entryId) {
		Optional<Entry> op = entryRepo.findById(entryId);
		Entry entry = null;
		if (op.isPresent()) {
			entry = op.get();
		}
		return entry;
	}

	@Override
	public void deleteEntry(Integer entryId) {
		Optional<Entry> op = entryRepo.findById(entryId);
		if (op.isPresent()) {
			Entry entry = op.get();
			entryRepo.deleteById(entryId);
		}

	}

	@Override
	public boolean entryExists(Integer entryId) {
		return entryRepo.existsById(entryId);

	}

	@Override
	public Entry updateEntry(Integer entryId, Entry entry) {
		Optional<Entry> op = entryRepo.findById(entryId);
		if (op.isPresent()) {
			entry.setId(op.get().getId());
			entryRepo.saveAndFlush(entry);
		} else {
			entry = null;
		}
		return entry;

	}

}
