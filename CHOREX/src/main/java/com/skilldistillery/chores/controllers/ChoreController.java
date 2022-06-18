package com.skilldistillery.chores.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.chores.entities.Chore;
import com.skilldistillery.chores.services.ChoreService;

@RequestMapping("api")
@RestController
@CrossOrigin({ "*", "http://localhost" })
public class ChoreController {

	@Autowired
	private ChoreService cs;

	@GetMapping("chores")
	public List<Chore> index() {
		return cs.index();
	}

	@GetMapping("chores/{choreId}")
	public Chore getChoreById(@PathVariable Integer choreId) {
		return cs.findById(choreId);
	}

	@PostMapping("chores")
	public Chore createEntry(@RequestBody Chore chore, HttpServletResponse res, HttpServletRequest req) {

		try {
			chore = cs.createChore(chore);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(chore.getId());
			res.setHeader("Location", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			chore = null;
		}

		return chore;
	}

	@DeleteMapping("chores/{choreId}")
	public void deleteEntry(@PathVariable Integer choreId, HttpServletResponse res, HttpServletRequest req) {
		cs.deleteChore(choreId);
		if (cs.choreExists(choreId)) {
			res.setStatus(400);
		} else {
			res.setStatus(204);
		}
	}

	@PutMapping("chores/{choreId}")
	public Chore updateEntry(@PathVariable int choreId, @RequestBody Chore chore, HttpServletResponse res) {

		try {
			chore = cs.updateChore(choreId, chore);
			if (chore == null) {
				res.setStatus(404);
			} else {
				res.setStatus(202);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			chore = null;
		}
		return chore;
	}

}
