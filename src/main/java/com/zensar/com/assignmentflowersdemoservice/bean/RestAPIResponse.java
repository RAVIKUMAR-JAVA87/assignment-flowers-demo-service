package com.zensar.com.assignmentflowersdemoservice.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestAPIResponse {
	private User[] users;

}
