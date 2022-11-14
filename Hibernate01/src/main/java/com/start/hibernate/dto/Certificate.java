package com.start.hibernate.dto;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {
	private String courceName;
	private int courceDuration;

	public Certificate() {
		super();
	}

	public Certificate(String courceName, int courceDuration) {
		super();
		this.courceName = courceName;
		this.courceDuration = courceDuration;
	}

	public String getCourceName() {
		return courceName;
	}

	public void setCourceName(String courceName) {
		this.courceName = courceName;
	}

	public int getCourceDuration() {
		return courceDuration;
	}

	public void setCourceDuration(int courceDuration) {
		this.courceDuration = courceDuration;
	}
}
