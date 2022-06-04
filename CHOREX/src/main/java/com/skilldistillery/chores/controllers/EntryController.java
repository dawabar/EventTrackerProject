package com.skilldistillery.chores.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.chores.entities.Chore;
import com.skilldistillery.chores.entities.Entry;
import com.skilldistillery.chores.services.ChoreService;
import com.skilldistillery.chores.services.EntryService;

@RequestMapping("api")
@RestController
public class EntryController {

	@Autowired
	private EntryService es;
	
	@Autowired
	private ChoreService cs;

	@GetMapping("completed")
	public List<Entry> index() {
		return es.index();
	}

	@GetMapping("completed/{entryId}")
	public Entry getEntryById(@PathVariable Integer entryId) {
		return es.findById(entryId);
	}

	@PostMapping("chores/{choreId}/completed")
	public Entry createEntry(@RequestBody Entry entry, @PathVariable Integer choreId, HttpServletResponse res,
			HttpServletRequest req) {

		try {
			Chore chore = cs.findById(choreId);
			entry = es.createEntry(entry, choreId);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(entry.getId());
			res.setHeader("Location", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			entry = null;
		}

		return entry;
	}

	@DeleteMapping("completed/{entryId}")
	public void deleteEntry(@PathVariable Integer entryId, HttpServletResponse res, HttpServletRequest req) {
		es.deleteEntry(entryId);
		if (es.entryExists(entryId)) {
			res.setStatus(400);
		} else {
			res.setStatus(204);
		}
	}

	@PutMapping("completed/{entryId}")
	public Entry updateEntry(@PathVariable int entryId, @RequestBody Entry entry, HttpServletResponse res) {

		try {
			entry = es.updateEntry(entryId, entry);
			if (entry == null) {
				res.setStatus(404);
			}
			else {
				res.setStatus(202);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			entry = null;
		}
		return entry;
	}

}
