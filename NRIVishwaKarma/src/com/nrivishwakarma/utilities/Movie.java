package com.nrivishwakarma.utilities;

public class Movie {
	public boolean arthouse;
	public boolean thriller;
	public boolean detective;
	public boolean drama;
	public boolean comedy;
	public boolean horror;
	public boolean fantasy;
	public boolean sience;
	public boolean adventure;
	public boolean western;
	public boolean historical;
	public boolean musical;
	public boolean sitkom;
	public boolean tv;
	public boolean getArthouse() {
		return arthouse;
	}
	public void setArthouse(boolean arthouse) {
		this.arthouse = arthouse;
	}
	public boolean getThriller() {
		return thriller;
	}
	public void setThriller(boolean thriller) {
		this.thriller = thriller;
	}
	public boolean getDetective() {
		return detective;
	}
	public void setDetective(boolean detective) {
		this.detective = detective;
	}
	public boolean getDrama() {
		return drama;
	}
	public void setDrama(boolean drama) {
		this.drama = drama;
	}
	public boolean getComedy() {
		return comedy;
	}
	public void setComedy(boolean comedy) {
		this.comedy = comedy;
	}
	public boolean getHorror() {
		return horror;
	}
	public void setHorror(boolean horror) {
		this.horror = horror;
	}
	public boolean getFantasy() {
		return fantasy;
	}
	public void setFantasy(boolean fantasy) {
		this.fantasy = fantasy;
	}
	public boolean getSience() {
		return sience;
	}
	public void setSience(boolean sience) {
		this.sience = sience;
	}
	public boolean getAdventure() {
		return adventure;
	}
	public void setAdventure(boolean adventure) {
		this.adventure = adventure;
	}
	public boolean getWestern() {
		return western;
	}
	public void setWestern(boolean western) {
		this.western = western;
	}
	public boolean getHistorical() {
		return historical;
	}
	public void setHistorical(boolean historical) {
		this.historical = historical;
	}
	public boolean getMusical() {
		return musical;
	}
	public void setMusical(boolean musical) {
		this.musical = musical;
	}
	public boolean getSitkom() {
		return sitkom;
	}
	public void setSitkom(boolean sitkom) {
		this.sitkom = sitkom;
	}
	public boolean getTv() {
		return tv;
	}
	public void setTv(boolean tv) {
		this.tv = tv;
	}
	public Movie(boolean arthouse, boolean thriller, boolean detective,
			boolean drama, boolean comedy, boolean horror, boolean fantasy,
			boolean sience, boolean adventure, boolean western, boolean historical,
			boolean musical, boolean sitkom, boolean tv) {
		super();
		this.arthouse = arthouse;
		this.thriller = thriller;
		this.detective = detective;
		this.drama = drama;
		this.comedy = comedy;
		this.horror = horror;
		this.fantasy = fantasy;
		this.sience = sience;
		this.adventure = adventure;
		this.western = western;
		this.historical = historical;
		this.musical = musical;
		this.sitkom = sitkom;
		this.tv = tv;
	}
	public Movie() {
		super();
	}
	
}
