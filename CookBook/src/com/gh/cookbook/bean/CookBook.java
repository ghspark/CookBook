package com.gh.cookbook.bean;

import java.util.List;

import android.widget.ListView;

public class CookBook {
	private String id;
	private String title;
	private String tags;
	private String imtro;
	private String burden;
	private List<String> albums;
	private List<CookBookSteps> steps;
	public String getImtro() {
		return imtro;
	}
	public void setImtro(String imtro) {
		this.imtro = imtro;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getBurden() {
		return burden;
	}
	public void setBurden(String burden) {
		this.burden = burden;
	}
	public List<String> getAlbums() {
		return albums;
	}
	public void setAlbums(List<String> albums) {
		this.albums = albums;
	}
	public List<CookBookSteps> getSteps() {
		return steps;
	}
	public void setSteps(List<CookBookSteps> steps) {
		this.steps = steps;
	}

}
