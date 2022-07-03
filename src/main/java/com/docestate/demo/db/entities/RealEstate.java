package com.docestate.demo.db.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.StringJoiner;

@Entity
@Table(name = "real_estate", schema = "docestate_simple_demo")
public class RealEstate {

	@Id
	private long   id;
	private String name;
	private String address;

	protected RealEstate() {
	}

	public RealEstate(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", RealEstate.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("name='" + name + "'")
				.add("address='" + address + "'")
				.toString();
	}
}
