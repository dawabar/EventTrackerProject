package com.skilldistillery.chores.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Entry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String person;
	
	private Double payment;
	
	@ManyToOne
	@JoinColumn(name = "chore_id")
	private Chore chore;
	
	
	
	public Entry() {
		super();
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getPerson() {
		return person;
	}



	public void setPerson(String person) {
		this.person = person;
	}



	public Double getPayment() {
		return payment;
	}



	public void setPayment(Double payment) {
		this.payment = payment;
	}



	public Chore getChore() {
		return chore;
	}



	public void setChore(Chore chore) {
		this.chore = chore;
	}



	@Override
	public String toString() {
		return "Ledger [id=" + id + ", person=" + person + ", payment=" + payment + ", chore=" + chore + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entry other = (Entry) obj;
		return id == other.id;
	}


}
