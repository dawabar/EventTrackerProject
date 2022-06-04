package com.skilldistillery.chores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.chores.entities.Entry;

public interface EntryRepository extends JpaRepository<Entry, Integer>{

}
