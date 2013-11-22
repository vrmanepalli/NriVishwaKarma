package com.nrivishwakarma.utilities;

public class Books {
	public boolean classic;
	public boolean tradegy;
	public boolean detective;
	public boolean comedy;
	public boolean love;
	public boolean fantasy;
	public boolean horror;
	public boolean sience;
	public boolean biography;
	public boolean getClassic() {
		return classic;
	}
	public void setClassic(boolean classic) {
		this.classic = classic;
	}
	public boolean getTradegy() {
		return tradegy;
	}
	public void setTradegy(boolean tradegy) {
		this.tradegy = tradegy;
	}
	public boolean getDetective() {
		return detective;
	}
	public void setDetective(boolean detective) {
		this.detective = detective;
	}
	public boolean getComedy() {
		return comedy;
	}
	public void setComedy(boolean comedy) {
		this.comedy = comedy;
	}
	public boolean getLove() {
		return love;
	}
	public void setLove(boolean love) {
		this.love = love;
	}
	public boolean getFantasy() {
		return fantasy;
	}
	public void setFantasy(boolean fantasy) {
		this.fantasy = fantasy;
	}
	public boolean getHorror() {
		return horror;
	}
	public void setHorror(boolean horror) {
		this.horror = horror;
	}
	public boolean getSience() {
		return sience;
	}
	public void setSience(boolean sience) {
		this.sience = sience;
	}
	public boolean getBiography() {
		return biography;
	}
	public void setBiography(boolean biography) {
		this.biography = biography;
	}
	public Books(boolean classic, boolean tradegy, boolean detective,
			boolean comedy, boolean love, boolean fantasy, boolean horror,
			boolean sience, boolean biography) {
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
	
}
