package com.example.jpa.dto;

public class PageDTO {
	
	private Long id;
    private int number;
    private String content;
    private String chapter;
    
    public PageDTO() {}
    
    public PageDTO(Long id, Integer number, String content, String chapter) {
		this.id = id;
		this.number = number;
		this.content = content;
		this.chapter = chapter;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	@Override
	public String toString() {
		return "PageDTO [id=" + id + ", number=" + number + ", content=" + content + ", chapter=" + chapter
				+ "]";
	}
    
    
}
