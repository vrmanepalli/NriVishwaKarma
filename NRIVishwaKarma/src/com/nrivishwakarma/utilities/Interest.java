package com.nrivishwakarma.utilities;
public class Interest {
	public boolean photo;
	public boolean travel;
	public boolean auto;
	public boolean collecting;
	public boolean theater;
	public boolean needlework;
	public boolean cookery;
	public boolean hunting;
	public boolean PCgames;
	public boolean art;
	public boolean sience;
	public boolean getPhoto() {
		return photo;
	}
	public void setPhoto(boolean photo) {
		this.photo = photo;
	}
	public boolean getTravel() {
		return travel;
	}
	public void setTravel(boolean travel) {
		this.travel = travel;
	}
	public boolean getAuto() {
		return auto;
	}
	public void setAuto(boolean auto) {
		this.auto = auto;
	}
	public boolean getCollecting() {
		return collecting;
	}
	public void setCollecting(boolean collecting) {
		this.collecting = collecting;
	}
	public boolean getTheater() {
		return theater;
	}
	public void setTheater(boolean theater) {
		this.theater = theater;
	}
	public boolean getNeedlework() {
		return needlework;
	}
	public void setNeedlework(boolean needlework) {
		this.needlework = needlework;
	}
	public boolean getCookery() {
		return cookery;
	}
	public void setCookery(boolean cookery) {
		this.cookery = cookery;
	}
	public boolean getHunting() {
		return hunting;
	}
	public void setHunting(boolean hunting) {
		this.hunting = hunting;
	}
	public boolean getPCgames() {
		return PCgames;
	}
	public void setPCgames(boolean pCgames) {
		PCgames = pCgames;
	}
	public boolean getArt() {
		return art;
	}
	public void setArt(boolean art) {
		this.art = art;
	}
	public boolean getSience() {
		return sience;
	}
	public void setSience(boolean sience) {
		this.sience = sience;
	}
	public Interest(boolean photo, boolean travel, boolean auto,
			boolean collecting, boolean theater, boolean needlework,
			boolean cookery, boolean hunting, boolean pCgames, boolean art,
			boolean sience) {
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
	
}
