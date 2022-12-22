package com.innowave.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "Channel.findByIdString", query = "select c from Channel c where c.id = ?1")
public class Channel{

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	private String category;

	private String name;

	private BigDecimal position;

	@OneToMany(mappedBy="channel")
	private List<Program> programs;
}