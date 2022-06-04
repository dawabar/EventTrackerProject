package com.skilldistillery.chores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.chores.entities.Chore;

public interface ChoreRepository extends JpaRepository<Chore, Integer>{

}
