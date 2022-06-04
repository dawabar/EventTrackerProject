package com.skilldistillery.chores.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.chores.entities.Chore;
import com.skilldistillery.chores.repositories.ChoreRepository;

@Service
public class ChoreServiceImpl implements ChoreService {

	@Autowired
	private ChoreRepository repo;

	@Override
	public List<Chore> index() {
		return repo.findAll();
	}

	@Override
	public Chore findById(Integer choreId) {
		Optional<Chore> op = repo.findById(choreId);
		Chore chore = null;
		if (op.isPresent()) {
			chore = op.get();
		}
		return chore;
	}

	@Override
	public Chore createChore(Chore chore) {
		chore = repo.saveAndFlush(chore);
		return chore;
	}

	@Override
	public void deleteChore(Integer choreId) {
		Optional<Chore> op = repo.findById(choreId);
		if (op.isPresent()) {
			repo.deleteById(choreId);
		}

	}

	@Override
	public boolean choreExists(Integer choreId) {
		return repo.existsById(choreId);

	}

	@Override
	public Chore updateChore(Integer choreId, Chore chore) {
		Optional<Chore> op = repo.findById(choreId);
		if (op.isPresent()) {
			chore.setId(choreId);
			repo.saveAndFlush(chore);
		} else {
			chore = null;
		}
		return chore;
	}

}
