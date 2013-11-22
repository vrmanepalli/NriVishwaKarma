package com.nrivishwakarma.utilities;

public class Music {
	public String pop;
	public String rnb;
	public String hip;
	public String classic;
	public String pank;
	public String disco;
	public String jass;
	public String roll;
	public String dance;
	public String latino;
	public String retro;
	public String shastriya;
	public String shanson;
	public String country;
	public String tehno;
	public String rock;
	public String getPop() {
		return pop;
	}
	public void setPop(String pop) {
		this.pop = pop;
	}
	public String getRnb() {
		return rnb;
	}
	public void setRnb(String rnb) {
		this.rnb = rnb;
	}
	public String getHip() {
		return hip;
	}
	public void setHip(String hip) {
		this.hip = hip;
	}
	public String getClassic() {
		return classic;
	}
	public void setClassic(String classic) {
		this.classic = classic;
	}
	public String getPank() {
		return pank;
	}
	public void setPank(String pank) {
		this.pank = pank;
	}
	public String getDisco() {
		return disco;
	}
	public void setDisco(String disco) {
		this.disco = disco;
	}
	public String getJass() {
		return jass;
	}
	public void setJass(String jass) {
		this.jass = jass;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getDance() {
		return dance;
	}
	public void setDance(String dance) {
		this.dance = dance;
	}
	public String getLatino() {
		return latino;
	}
	public void setLatino(String latino) {
		this.latino = latino;
	}
	public String getRetro() {
		return retro;
	}
	public void setRetro(String retro) {
		this.retro = retro;
	}
	public String getShastriya() {
		return shastriya;
	}
	public void setShastriya(String shastriya) {
		this.shastriya = shastriya;
	}
	public String getShanson() {
		return shanson;
	}
	public void setShanson(String shanson) {
		this.shanson = shanson;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTehno() {
		return tehno;
	}
	public void setTehno(String tehno) {
		this.tehno = tehno;
	}
	public String getRock() {
		return rock;
	}
	public void setRock(String rock) {
		this.rock = rock;
	}
	public Music(String pop, String rnb, String hip, String classic,
			String pank, String disco, String jass, String roll, String dance,
			String latino, String retro, String shastriya, String shanson,
			String country, String tehno, String rock) {
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
	@Override
	public String toString() {
		return "Music [pop=" + pop + ", rnb=" + rnb + ", hip=" + hip
				+ ", classic=" + classic + ", pank=" + pank + ", disco="
				+ disco + ", jass=" + jass + ", roll=" + roll + ", dance="
				+ dance + ", latino=" + latino + ", retro=" + retro
				+ ", shastriya=" + shastriya + ", shanson=" + shanson
				+ ", country=" + country + ", tehno=" + tehno + ", rock="
				+ rock + "]";
	}
	
	
}
