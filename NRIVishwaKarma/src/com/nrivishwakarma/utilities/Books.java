package com.nrivishwakarma.utilities;

public class Books extends AllInterests {
	public String classic;
	public String tradegy;
	public String detective;
	public String comedy;
	public String love;
	public String fantasy;
	public String horror;
	public String sience;
	public String biography;
	public String getClassic() {
		return classic;
	}
	public void setClassic(String classic) {
		this.classic = classic;
	}
	public String getTradegy() {
		return tradegy;
	}
	public void setTradegy(String tradegy) {
		this.tradegy = tradegy;
	}
	public String getDetective() {
		return detective;
	}
	public void setDetective(String detective) {
		this.detective = detective;
	}
	public String getComedy() {
		return comedy;
	}
	public void setComedy(String comedy) {
		this.comedy = comedy;
	}
	public String getLove() {
		return love;
	}
	public void setLove(String love) {
		this.love = love;
	}
	public String getFantasy() {
		return fantasy;
	}
	public void setFantasy(String fantasy) {
		this.fantasy = fantasy;
	}
	public String getHorror() {
		return horror;
	}
	public void setHorror(String horror) {
		this.horror = horror;
	}
	public String getSience() {
		return sience;
	}
	public void setSience(String sience) {
		this.sience = sience;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
	public Books(String classic, String tradegy, String detective,
			String comedy, String love, String fantasy, String horror,
			String sience, String biography) {
		super();
		this.classic = classic;
		this.tradegy = tradegy;
		this.detective = detective;
		this.comedy = comedy;
		this.love = love;
		this.fantasy = fantasy;
		this.horror = horror;
		this.sience = sience;
		this.biography = biography;
	}
	public Books() {
		super();
	}
	@Override
	public String toString() {
		return "Books [classic=" + classic + ", tradegy=" + tradegy
				+ ", detective=" + detective + ", comedy=" + comedy + ", love="
				+ love + ", fantasy=" + fantasy + ", horror=" + horror
				+ ", sience=" + sience + ", biography=" + biography + "]";
	}
	
}
