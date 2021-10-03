package com.springboot.rest.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.springboot.rest.util.MySequenceGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "RESV_MASTER")
@Data
public class ResvMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @GenericGenerator(
        name = "book_seq", 
        strategy = "org.thoughts.on.java.generators.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name =  MySequenceGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = MySequenceGenerator.VALUE_PREFIX_PARAMETER, value = "R"),
            @Parameter(name = MySequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%09d") })
	@Column(name = "RESV_ID")
	private String resvId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "resvMaster")
	@JoinColumn(name = "resvMaster")
	private ResvBiz resvBiz;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CUST_ID"),
		@JoinColumn(name = "MOBILE")
	})
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Customer customer;
}
