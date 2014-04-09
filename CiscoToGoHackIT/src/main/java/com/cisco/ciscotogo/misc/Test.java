package com.cisco.ciscotogo.misc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Test {
	@Id @GeneratedValue(strategy=GenerationType.TABLE) @Column(name="test_id")
	private int name;
}
