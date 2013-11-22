package com.nrivishwakarma.utilities;

public class Sport {
	public String running;
	public String soccer;
	public String football;
	public String voleyball;
	public String baseball;
	public String basketball;
	public String hokey;
	public String fitness;
	public String swimming;
	public String bicycle;
	public String tennis;
	public String snowboard;
	public String diving;
	public String bowling;
	public String surfing;
	public String yoga;
	public String boxing;
	public String kickboxing;
	public String judo;
	public String skates;
	public String roller;
	public String skiing;
	public String getRunning() {
		return running;
	}
	public void setRunning(String running) {
		this.running = running;
	}
	public String getSoccer() {
		return soccer;
	}
	public void setSoccer(String soccer) {
		this.soccer = soccer;
	}
	public String getFootball() {
		return football;
	}
	public void setFootball(String football) {
		this.football = football;
	}
	public String getVoleyball() {
		return voleyball;
	}
	public void setVoleyball(String voleyball) {
		this.voleyball = voleyball;
	}
	public String getBaseball() {
		return baseball;
	}
	public void setBaseball(String baseball) {
		this.baseball = baseball;
	}
	public String getBasketball() {
		return basketball;
	}
	public void setBasketball(String basketball) {
		this.basketball = basketball;
	}
	public String getHokey() {
		return hokey;
	}
	public void setHokey(String hokey) {
		this.hokey = hokey;
	}
	public String getFitness() {
		return fitness;
	}
	public void setFitness(String fitness) {
		this.fitness = fitness;
	}
	public String getSwimming() {
		return swimming;
	}
	public void setSwimming(String swimming) {
		this.swimming = swimming;
	}
	public String getBicycle() {
		return bicycle;
	}
	public void setBicycle(String bicycle) {
		this.bicycle = bicycle;
	}
	public String getTennis() {
		return tennis;
	}
	public void setTennis(String tennis) {
		this.tennis = tennis;
	}
	public String getSnowboard() {
		return snowboard;
	}
	public void setSnowboard(String snowboard) {
		this.snowboard = snowboard;
	}
	public String getDiving() {
		return diving;
	}
	public void setDiving(String diving) {
		this.diving = diving;
	}
	public String getBowling() {
		return bowling;
	}
	public void setBowling(String bowling) {
		this.bowling = bowling;
	}
	public String getSurfing() {
		return surfing;
	}
	public void setSurfing(String surfing) {
		this.surfing = surfing;
	}
	public String getYoga() {
		return yoga;
	}
	public void setYoga(String yoga) {
		this.yoga = yoga;
	}
	public String getBoxing() {
		return boxing;
	}
	public void setBoxing(String boxing) {
		this.boxing = boxing;
	}
	public String getKickboxing() {
		return kickboxing;
	}
	public void setKickboxing(String kickboxing) {
		this.kickboxing = kickboxing;
	}
	public String getJudo() {
		return judo;
	}
	public void setJudo(String judo) {
		this.judo = judo;
	}
	public String getSkates() {
		return skates;
	}
	public void setSkates(String skates) {
		this.skates = skates;
	}
	public String getRoller() {
		return roller;
	}
	public void setRoller(String roller) {
		this.roller = roller;
	}
	public String getSkiing() {
		return skiing;
	}
	public void setSkiing(String skiing) {
		this.skiing = skiing;
	}
	public Sport(String running, String soccer, String football,
			String voleyball, String baseball, String basketball, String hokey,
			String fitness, String swimming, String bicycle, String tennis,
			String snowboard, String diving, String bowling, String surfing,
			String yoga, String boxing, String kickboxing, String judo,
			String skates, String roller, String skiing) {
		super();
		this.running = running;
		this.soccer = soccer;
		this.football = football;
		this.voleyball = voleyball;
		this.baseball = baseball;
		this.basketball = basketball;
		this.hokey = hokey;
		this.fitness = fitness;
		this.swimming = swimming;
		this.bicycle = bicycle;
		this.tennis = tennis;
		this.snowboard = snowboard;
		this.diving = diving;
		this.bowling = bowling;
		this.surfing = surfing;
		this.yoga = yoga;
		this.boxing = boxing;
		this.kickboxing = kickboxing;
		this.judo = judo;
		this.skates = skates;
		this.roller = roller;
		this.skiing = skiing;
	}
	public Sport() {
		super();
	}
	@Override
	public String toString() {
		return "Sport [running=" + running + ", soccer=" + soccer
				+ ", football=" + football + ", voleyball=" + voleyball
				+ ", baseball=" + baseball + ", basketball=" + basketball
				+ ", hokey=" + hokey + ", fitness=" + fitness + ", swimming="
				+ swimming + ", bicycle=" + bicycle + ", tennis=" + tennis
				+ ", snowboard=" + snowboard + ", diving=" + diving
				+ ", bowling=" + bowling + ", surfing=" + surfing + ", yoga="
				+ yoga + ", boxing=" + boxing + ", kickboxing=" + kickboxing
				+ ", judo=" + judo + ", skates=" + skates + ", roller="
				+ roller + ", skiing=" + skiing + "]";
	}
	
	
}
