package com.nrivishwakarma.utilities;
public class Interest {
	public String photo;
	public String travel;
	public String auto;
	public String collecting;
	public String theater;
	public String needlework;
	public String cookery;
	public String hunting;
	public String PCgames;
	public String art;
	public String sience;
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getTravel() {
		return travel;
	}
	public void setTravel(String travel) {
		this.travel = travel;
	}
	public String getAuto() {
		return auto;
	}
	public void setAuto(String auto) {
		this.auto = auto;
	}
	public String getCollecting() {
		return collecting;
	}
	public void setCollecting(String collecting) {
		this.collecting = collecting;
	}
	public String getTheater() {
		return theater;
	}
	public void setTheater(String theater) {
		this.theater = theater;
	}
	public String getNeedlework() {
		return needlework;
	}
	public void setNeedlework(String needlework) {
		this.needlework = needlework;
	}
	public String getCookery() {
		return cookery;
	}
	public void setCookery(String cookery) {
		this.cookery = cookery;
	}
	public String getHunting() {
		return hunting;
	}
	public void setHunting(String hunting) {
		this.hunting = hunting;
	}
	public String getPCgames() {
		return PCgames;
	}
	public void setPCgames(String pCgames) {
		PCgames = pCgames;
	}
	public String getArt() {
		return art;
	}
	public void setArt(String art) {
		this.art = art;
	}
	public String getSience() {
		return sience;
	}
	public void setSience(String sience) {
		this.sience = sience;
	}
	public Interest(String photo, String travel, String auto,
			String collecting, String theater, String needlework,
			String cookery, String hunting, String pCgames, String art,
			String sience) {
		super();
		this.photo = photo;
		this.travel = travel;
		this.auto = auto;
		this.collecting = collecting;
		this.theater = theater;
		this.needlework = needlework;
		this.cookery = cookery;
		this.hunting = hunting;
		PCgames = pCgames;
		this.art = art;
		this.sience = sience;
	}
	public Interest() {
		super();
	}
	@Override
	public String toString() {
		return "Interest [photo=" + photo + ", travel=" + travel + ", auto="
				+ auto + ", collecting=" + collecting + ", theater=" + theater
				+ ", needlework=" + needlework + ", cookery=" + cookery
				+ ", hunting=" + hunting + ", PCgames=" + PCgames + ", art="
				+ art + ", sience=" + sience + "]";
	}
	
	
}
