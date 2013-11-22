package com.nrivishwakarma.utilities;

public class UserProfile {
	public String email;
	public String password;
	public String fname;
	public String lname;
	public String age;
	public String bdate;
	public String gender;
	public String imageUrl;
	public String country;
	public String state;
	public String city;
	public int phone;
	public String status;
	public String fromcountry;
	public String fromstate;
	public String fromcity;
	public String job;
	public String company;
	public String degree;
	public String field;
	public String univer;
	public String yearuniver;
	public String school;
	public String yearschool;
	public String about;
	public String interest;
	
	
	public UserProfile(String email, String password, String fname,
			String lname, String age, String bdate, String gender,
			String imageUrl, String country, String state, String city,
			int phone, String status, String fromcountry, String fromstate,
			String fromcity, String job, String company, String degree,
			String field, String univer, String yearuniver, String school,
			String yearschool, String about, String interest, String sport,
			String books, String movie, String music) {
		super();
		this.email = email;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.bdate = bdate;
		this.gender = gender;
		this.imageUrl = imageUrl;
		this.country = country;
		this.state = state;
		this.city = city;
		this.phone = phone;
		this.status = status;
		this.fromcountry = fromcountry;
		this.fromstate = fromstate;
		this.fromcity = fromcity;
		this.job = job;
		this.company = company;
		this.degree = degree;
		this.field = field;
		this.univer = univer;
		this.yearuniver = yearuniver;
		this.school = school;
		this.yearschool = yearschool;
		this.about = about;
		this.interest = interest;
		this.sport = sport;
		this.books = books;
		this.movie = movie;
		this.music = music;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}
	public String getBooks() {
		return books;
	}
	public void setBooks(String books) {
		this.books = books;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public String getMusic() {
		return music;
	}
	public void setMusic(String music) {
		this.music = music;
	}
	public String sport;
	public String books;
	public String movie;
	public String music;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFromcountry() {
		return fromcountry;
	}
	public void setFromcountry(String fromcountry) {
		this.fromcountry = fromcountry;
	}
	public String getFromstate() {
		return fromstate;
	}
	public void setFromstate(String fromstate) {
		this.fromstate = fromstate;
	}
	public String getFromcity() {
		return fromcity;
	}
	public void setFromcity(String fromcity) {
		this.fromcity = fromcity;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getUniver() {
		return univer;
	}
	public void setUniver(String univer) {
		this.univer = univer;
	}
	public String getYearuniver() {
		return yearuniver;
	}
	public void setYearuniver(String yearuniver) {
		this.yearuniver = yearuniver;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getYearschool() {
		return yearschool;
	}
	public void setYearschool(String yearschool) {
		this.yearschool = yearschool;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	public UserProfile() {
		super();
	}
	@Override
	public String toString() {
		return "UserProfile [email=" + email + ", password=" + password
				+ ", fname=" + fname + ", lname=" + lname + ", age=" + age
				+ ", bdate=" + bdate + ", gender=" + gender + ", imageUrl="
				+ imageUrl + ", country=" + country + ", state=" + state
				+ ", city=" + city + ", phone=" + phone + ", status=" + status
				+ ", fromcountry=" + fromcountry + ", fromstate=" + fromstate
				+ ", fromcity=" + fromcity + ", job=" + job + ", company="
				+ company + ", degree=" + degree + ", field=" + field
				+ ", univer=" + univer + ", yearuniver=" + yearuniver
				+ ", school=" + school + ", yearschool=" + yearschool
				+ ", about=" + about + ", interest=" + interest + ", sport="
				+ sport + ", books=" + books + ", movie=" + movie + ", music="
				+ music + "]";
	}
	
}
