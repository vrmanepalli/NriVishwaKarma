package com.nrivishwakarma.utilities;

public class Music {
	public boolean pop;
	public boolean rnb;
	public boolean hip;
	public boolean classic;
	public boolean pank;
	public boolean disco;
	public boolean jass;
	public boolean roll;
	public boolean dance;
	public boolean latino;
	public boolean retro;
	public boolean shastriya;
	public boolean shanson;
	public boolean country;
	public boolean tehno;
	public boolean rock;
	public boolean getPop() {
		return pop;
	}
	public void setPop(boolean pop) {
		this.pop = pop;
	}
	public boolean getRnb() {
		return rnb;
	}
	public void setRnb(boolean rnb) {
		this.rnb = rnb;
	}
	public boolean getHip() {
		return hip;
	}
	public void setHip(boolean hip) {
		this.hip = hip;
	}
	public boolean getClassic() {
		return classic;
	}
	public void setClassic(boolean classic) {
		this.classic = classic;
	}
	public boolean getPank() {
		return pank;
	}
	public void setPank(boolean pank) {
		this.pank = pank;
	}
	public boolean getDisco() {
		return disco;
	}
	public void setDisco(boolean disco) {
		this.disco = disco;
	}
	public boolean getJass() {
		return jass;
	}
	public void setJass(boolean jass) {
		this.jass = jass;
	}
	public boolean getRoll() {
		return roll;
	}
	public void setRoll(boolean roll) {
		this.roll = roll;
	}
	public boolean getDance() {
		return dance;
	}
	public void setDance(boolean dance) {
		this.dance = dance;
	}
	public boolean getLatino() {
		return latino;
	}
	public void setLatino(boolean latino) {
		this.latino = latino;
	}
	public boolean getRetro() {
		return retro;
	}
	public void setRetro(boolean retro) {
		this.retro = retro;
	}
	public boolean getShastriya() {
		return shastriya;
	}
	public void setShastriya(boolean shastriya) {
		this.shastriya = shastriya;
	}
	public boolean getShanson() {
		return shanson;
	}
	public void setShanson(boolean shanson) {
		this.shanson = shanson;
	}
	public boolean getCountry() {
		return country;
	}
	public void setCountry(boolean country) {
		this.country = country;
	}
	public boolean getTehno() {
		return tehno;
	}
	public void setTehno(boolean tehno) {
		this.tehno = tehno;
	}
	public boolean getRock() {
		return rock;
	}
	public void setRock(boolean rock) {
		this.rock = rock;
	}
	public Music(boolean pop, boolean rnb, boolean hip, boolean classic,
			boolean pank, boolean disco, boolean jass, boolean roll, boolean dance,
			boolean latino, boolean retro, boolean shastriya, boolean shanson,
			boolean country, boolean tehno, boolean rock) {
		super();
		this.pop = pop;
		this.rnb = rnb;
		this.hip = hip;
		this.classic = classic;
		this.pank = pank;
		this.disco = disco;
		this.jass = jass;
		this.roll = roll;
		this.dance = dance;
		this.latino = latino;
		this.retro = retro;
		this.shastriya = shastriya;
		this.shanson = shanson;
		this.country = country;
		this.tehno = tehno;
		this.rock = rock;
	}
	public Music() {
		super();
	}
}
