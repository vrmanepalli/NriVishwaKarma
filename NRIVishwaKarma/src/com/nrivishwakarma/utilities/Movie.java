package com.nrivishwakarma.utilities;

public class Movie {
	public String arthouse;
	public String thriller;
	public String detective;
	public String drama;
	public String comedy;
	public String horror;
	public String fantasy;
	public String sience;
	public String adventure;
	public String western;
	public String historical;
	public String musical;
	public String sitkom;
	public String tv;
	public String getArthouse() {
		return arthouse;
	}
	public void setArthouse(String arthouse) {
		this.arthouse = arthouse;
	}
	public String getThriller() {
		return thriller;
	}
	public void setThriller(String thriller) {
		this.thriller = thriller;
	}
	public String getDetective() {
		return detective;
	}
	public void setDetective(String detective) {
		this.detective = detective;
	}
	public String getDrama() {
		return drama;
	}
	public void setDrama(String drama) {
		this.drama = drama;
	}
	public String getComedy() {
		return comedy;
	}
	public void setComedy(String comedy) {
		this.comedy = comedy;
	}
	public String getHorror() {
		return horror;
	}
	public void setHorror(String horror) {
		this.horror = horror;
	}
	public String getFantasy() {
		return fantasy;
	}
	public void setFantasy(String fantasy) {
		this.fantasy = fantasy;
	}
	public String getSience() {
		return sience;
	}
	public void setSience(String sience) {
		this.sience = sience;
	}
	public String getAdventure() {
		return adventure;
	}
	public void setAdventure(String adventure) {
		this.adventure = adventure;
	}
	public String getWestern() {
		return western;
	}
	public void setWestern(String western) {
		this.western = western;
	}
	public String getHistorical() {
		return historical;
	}
	public void setHistorical(String historical) {
		this.historical = historical;
	}
	public String getMusical() {
		return musical;
	}
	public void setMusical(String musical) {
		this.musical = musical;
	}
	public String getSitkom() {
		return sitkom;
	}
	public void setSitkom(String sitkom) {
		this.sitkom = sitkom;
	}
	public String getTv() {
		return tv;
	}
	public void setTv(String tv) {
		this.tv = tv;
	}
	public Movie(String arthouse, String thriller, String detective,
			String drama, String comedy, String horror, String fantasy,
			String sience, String adventure, String western, String historical,
			String musical, String sitkom, String tv) {
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
	@Override
	public String toString() {
		return "Movie [arthouse=" + arthouse + ", thriller=" + thriller
				+ ", detective=" + detective + ", drama=" + drama + ", comedy="
				+ comedy + ", horror=" + horror + ", fantasy=" + fantasy
				+ ", sience=" + sience + ", adventure=" + adventure
				+ ", western=" + western + ", historical=" + historical
				+ ", musical=" + musical + ", sitkom=" + sitkom + ", tv=" + tv
				+ "]";
	}
	
}
