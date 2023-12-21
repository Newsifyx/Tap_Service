package com.newsify.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseVO {

	private Boolean status;

	private String message;

	public ResponseVO(Boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
