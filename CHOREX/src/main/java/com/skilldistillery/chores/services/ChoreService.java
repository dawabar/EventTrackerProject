package com.skilldistillery.chores.services;

import java.util.List;

import com.skilldistillery.chores.entities.Chore;

public interface ChoreService {

	public List<Chore> index();
	
	public Chore findById(Integer choreId);
	
	public Chore createChore(Chore chore);
	
	public Chore updateChore(Integer choreId, Chore chore);

	public void deleteChore(Integer choreId);

	public boolean choreExists(Integer choreId);


}
