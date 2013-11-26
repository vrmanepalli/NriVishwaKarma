'use strict';
app.controller('profileCtrl',function($scope,$rootScope,dataFactory,$cookies, $location, $modal){

	if($cookies.email == "" && $cookies.email == undefined){
		$location.path('/Login');
	}//if
	else{

	//-------------Data Factory to download user's data for page----------------------
	$scope.user = {};
	console.log("email: " + $rootScope.profileUser);
	dataFactory.getInterestFactory($rootScope.profileUser)
	.success(function(interests){
		$scope.inter = interests;
		$scope.updateInter();
	})
	.error(function(error){
		console.log("error in getting interest \n"+error);
	});
	
	
	dataFactory.getUserFactory($rootScope.profileUser)
		.success(function(userData){
			$scope.user=userData;
			$scope.updateUserInfo();
		})
		.error(function(error){
			console.log("error in getting USER \n"+error);
		});
	
	$scope.updateUserInfo = function(){
		//------------General TAB-------------------------------------------
		if($scope.user.imageUrl===""|| ($scope.user.imageUrl===undefined)){$scope.imageUrl = "../img/profile.png";} 
		$scope.username = $scope.user.fname+" "+$scope.user.lname;
		if($scope.user.phone===""|| ($scope.user.phone===undefined)){$scope.phonehide=true;}else{$scope.phonehide=false;}
		if($scope.user.age===""|| ($scope.user.age===undefined)){$scope.agehide=true;}else{$scope.agehide=false;}
		if($scope.user.country===""|| ($scope.user.country===undefined)){$scope.addresshide=true;}else{$scope.addresshide=false;}
		if($scope.user.status===""|| ($scope.user.status===undefined)){$scope.statushide=true;}else{$scope.statushide=false;}
		if($scope.user.fromcountry===""|| ($scope.user.fromcountry===undefined)){$scope.fromaddresshide=true;}else{$scope.fromaddresshide=false;}
		if(($scope.user.about==="") || ($scope.user.about===undefined)){$scope.abouthide=true;}else{$scope.abouthide=false;}
		if($scope.user.gender==="male"){$scope.colorGender="blue";}
		else if($scope.user.gender==="female"){$scope.colorGender="pink";}
		$scope.datepicker = {date: new Date($scope.user.bdate)};
		
		$scope.Fname=$scope.user.fname;
		$scope.Lname=$scope.user.lname;
		$scope.Country=$scope.user.country;
		$scope.State=$scope.user.state;
		$scope.City=$scope.user.city;
		$scope.Phone=$scope.user.phone;
		$scope.Gender=$scope.user.gender;
		$scope.yearDOB = $scope.user.byear;
		$scope.monthDOB = $scope.user.bmonth;
		$scope.dayDOB = $scope.user.bday;
		$scope.Status=$scope.user.status;
		$scope.Fromcountry=$scope.user.fromcountry;
		$scope.Fromstate=$scope.user.fromstate;
		$scope.Fromcity=$scope.user.fromcity;
		$scope.About=$scope.user.about;
	//----------Career TAB----------------------------------------------
		$scope.Job = $scope.user.job;
		$scope.Company = $scope.user.company;
		$scope.Degree = $scope.user.degree;
		$scope.Field = $scope.user.field;
		$scope.Univer = $scope.user.univer;
		$scope.Yearuniver = $scope.user.yearuniver;
		$scope.School = $scope.user.school;
		$scope.Yearschool = $scope.user.yearschool;
		if($scope.user.job===""){$scope.jobhide=true;}
		if($scope.user.field===""){$scope.degreehide=true;}
		if($scope.user.univer===""){$scope.univerhide=true;}
		if($scope.user.school===""){$scope.schoolhide=true;}
		if(($scope.user.job==="")&&($scope.user.field==="")&&($scope.user.univer==="")&&($scope.user.school==="")){
			$scope.allCareer=true;
		}
	
		if($rootScope.profileUser === $cookies.email){//-----<----if user open his page
			console.log("in if");		
		}
		else{//-------<-------if guest open this page
			$scope.User = true;
		}
	}
	
	$scope.updateInter = function(){
		$scope.interest="";
		$scope.sp="";
		$scope.mus="";
		$scope.mov="";
		$scope.book="";
		if($scope.inter.photo ==="1"){$scope.photo=true; $scope.interest=$scope.interest+" Photo,";}else{$scope.photo=false}
		if($scope.inter.collecting ==="1"){$scope.collecting=true;$scope.interest=$scope.interest+" Collecting,";}else{$scope.collecting=false;}
		if($scope.inter.needlework ==="1"){$scope.needlework=true;$scope.interest=$scope.interest+" Needlework,";}else{$scope.needlework=false;}
		if($scope.inter.pcgames ==="1"){$scope.pcgames=true;$scope.interest=$scope.interest+" PC games,";}else{$scope.collectingpcgames=false;}
		if($scope.inter.travel ==="1"){$scope.travel=true;$scope.interest=$scope.interest+" Travel,"}else{$scope.travel=false;}
		if($scope.inter.computer ==="1"){$scope.computer=true;$scope.interest=$scope.interest+" Computer,";}else{$scope.computer=false;}
		if($scope.inter.cookery ==="1"){$scope.cookery=true; $scope.interest=$scope.interest+" Cookery,";}else{$scope.cookery=false;}
		if($scope.inter.art ==="1"){$scope.art=true;$scope.interest=$scope.interest+" Art,";}else{$scope.art=false;}
		if($scope.inter.auto ==="1"){$scope.auto=true;$scope.interest=$scope.interest+" Auto,";}else{$scope.auto=false;}
		if($scope.inter.theater ==="1"){$scope.theater=true;$scope.interest=$scope.interest+" Theater,";}else{$scope.theater=false;}
		if($scope.inter.haunting ==="1"){$scope.haunting=true;$scope.interest=$scope.interest+" Hunting,";}else{$scope.haunting=false;}
		if($scope.inter.science ==="1"){$scope.science=true;;$scope.interest=$scope.interest+" Science,"}else{$scope.science=false;}
		
		if($scope.inter.bookclassic ==="1"){$scope.bookclassic=true; $scope.book=$scope.book+" Classic,";}else{$scope.bookclassic=false;}
		if($scope.inter.bookcomedy ==="1"){$scope.bookcomedy=true;$scope.book=$scope.book+" Comedy,";}else{$scope.bookcomedy=false;}
		if($scope.inter.bookfantasy ==="1"){$scope.bookfantasy=true;$scope.book=$scope.book+" Fantasy,";}else{$scope.bookfantasy=false;}
		if($scope.inter.booktragedy ==="1"){$scope.booktragedy=true;$scope.book=$scope.book+" Tragedy";}else{$scope.booktragedy=false;}
		if($scope.inter.booklovestory ==="1"){$scope.booklovestory=true;$scope.book=$scope.book+" Love story,";}else{$scope.booklovestory=false;}
		if($scope.inter.bookhorror ==="1"){$scope.bookhorror=true;$scope.book=$scope.book+" Horror,";}else{$scope.bookhorror=false;}
		if($scope.inter.bookbiography ==="1"){$scope.bookbiography=true;$scope.book=$scope.book+" Biography,";}else{$scope.bookbiography=false;}
		if($scope.inter.bookdetective ==="1"){$scope.bookdetective=true;$scope.book=$scope.book+" Detective,";}else{$scope.bookdetective=false;}
		if($scope.inter.bookscience ==="1"){$scope.bookscience=true;$scope.book=$scope.book+" Science,";}else{$scope.bookscience=false;}
		
		if($scope.inter.moviearthouse ==="1"){$scope.moviearthouse=true;$scope.mov=$scope.mov+" Arthouse,";}else{$scope.moviearthouse=false;}
		if($scope.inter.moviecomedy ==="1"){$scope.moviecomedy=true;$scope.mov=$scope.mov+" Comedy,";}else{$scope.moviecomedy=false;}
		if($scope.inter.movieadventure ==="1"){$scope.movieadventure=true;$scope.mov=$scope.mov+"Adventure,";}else{$scope.movieadventure=false;}
		if($scope.inter.moviemusical ==="1"){$scope.moviemusical=true;$scope.mov=$scope.mov+" Musical,";}else{$scope.moviemusical=false;}
		if($scope.inter.movietvseries ==="1"){$scope.movietvseries=true;$scope.mov=$scope.mov+" TV series,";}else{$scope.movietvseries=false;}
		if($scope.inter.moviehistorical ==="1"){$scope.moviehistorical=true;$scope.mov=$scope.mov+" Historical,";}else{$scope.moviehistorical=false;}
		if($scope.inter.moviefantasy ==="1"){$scope.moviefantasy=true;$scope.mov=$scope.mov+" Fantasy,";}else{$scope.moviefantasy=false;}
		if($scope.inter.moviedetective ==="1"){$scope.moviedetective=true;$scope.mov=$scope.mov+" Detective,";}else{$scope.moviedetective=false;}
		if($scope.inter.moviedrama ==="1"){$scope.moviedrama=true;$scope.mov=$scope.mov+" Drama,";}else{$scope.moviedrama=false;}
		if($scope.inter.moviescience ==="1"){$scope.moviescience=true;$scope.mov=$scope.mov+" Science,";}else{$scope.moviescience=false;}
		if($scope.inter.moviethriller ==="1"){$scope.moviethriller=true;$scope.mov=$scope.mov+" Thriller,";}else{$scope.moviethriller=false;}
		if($scope.inter.moviehorror ==="1"){$scope.moviehorror=true;$scope.mov=$scope.mov+" Horror,";}else{$scope.moviehorror=false;}
		if($scope.inter.moviewestern ==="1"){$scope.moviewestern=true;$scope.mov=$scope.mov+" Western,";}else{$scope.moviewestern=false;}
		if($scope.inter.moviesitcom ==="1"){$scope.moviesitcom=true;$scope.mov=$scope.mov+" Sitcom,";}else{$scope.moviesitcom=false;}
		
		if($scope.inter.musicpop ==="1"){$scope.musicpop=true;$scope.mus=$scope.mus+" Pop,";}else{$scope.musicpop=false;}
		if($scope.inter.musicpank ==="1"){$scope.musicpank=true;$scope.mus=$scope.mus+" Pank,";}else{$scope.musicpank=false;}
		if($scope.inter.musicdance ==="1"){$scope.musicdance=true;$scope.mus=$scope.mus+" Dance,";}else{$scope.musicdance=false;}
		if($scope.inter.musicshanson ==="1"){$scope.musicshanson=true;$scope.mus=$scope.mus+" Shanson,";}else{$scope.musicshanson=false;}
		if($scope.inter.musicrnb ==="1"){$scope.musicrnb=true;$scope.mus=$scope.mus+" R'n'b,";}else{$scope.musicrnb=false;}
		if($scope.inter.musicdisco ==="1"){$scope.musicdisco=true;$scope.mus=$scope.mus+" Disco,";}else{$scope.musicdisco=false;}
		if($scope.inter.musiclatino ==="1"){$scope.musiclatino=true;$scope.mus=$scope.mus+" Latino,";}else{$scope.musiclatino=false;}
		if($scope.inter.musiccountry ==="1"){$scope.musiccountry=true;$scope.mus=$scope.mus+" Coutry,";}else{$scope.musiccountry=false;}
		if($scope.inter.musichip_hop ==="1"){$scope.musichip_hop=true;$scope.mus=$scope.mus+" Hip-hop,";}else{$scope.musichip_hop=false;}
		if($scope.inter.musicjass ==="1"){$scope.musicjass=true;$scope.mus=$scope.mus+" Jass,";}else{$scope.musicjass=false;}
		if($scope.inter.musicretro ==="1"){$scope.musicretro=true;$scope.mus=$scope.mus+" Retro,";}else{$scope.musicretro=false;}
		if($scope.inter.musictechno ==="1"){$scope.musictechno=true;$scope.mus=$scope.mus+" Techno,";}else{$scope.musictechno=false;}
		if($scope.inter.musicclassic ==="1"){$scope.musicclassic=true;$scope.mus=$scope.mus+" Classic,";}else{$scope.musicclassic=false;}
		if($scope.inter.musicrocknroll ==="1"){$scope.musicrocknroll=true;$scope.mus=$scope.mus+" Rock-n-roll,";}else{$scope.musicrocknroll=false;}
		if($scope.inter.musicsastriya_sangeet ==="1"){$scope.musicsastriya_sangeet=true;$scope.mus=$scope.mus+" Shastriya Sangeet,";}else{$scope.musicsastriya_sangeet=false;}
		if($scope.inter.musicrock ==="1"){$scope.musicrock=true;$scope.mus=$scope.mus+" Rock,";}else{$scope.musicrock=false;}
		
		if($scope.inter.sportrunning ==="1"){$scope.sportrunning=true;$scope.sp=$scope.sp+" Running,";}else{$scope.sportrunning=false;}
		if($scope.inter.sporthockey ==="1"){$scope.sporthockey=true;$scope.sp=$scope.sp+" Hockey,";}else{$scope.sporthockey=false;}
		if($scope.inter.sportdiving ==="1"){$scope.sportdiving=true;$scope.sp=$scope.sp+" Diving,";}else{$scope.sportdiving=false;}
		if($scope.inter.sportjudo ==="1"){$scope.sportjudo=true;$scope.sp=$scope.sp+" Judo,";}else{$scope.sportjudo=false;}
		if($scope.inter.sportsoccer ==="1"){$scope.sportsoccer=true;$scope.sp=$scope.sp+" Soccer,";}else{$scope.sportsoccer=false;}
		if($scope.inter.sportfitness ==="1"){$scope.sportfitness=true;$scope.sp=$scope.sp+" Fitness,";}else{$scope.sportfitness=false;}
		if($scope.inter.sportbowling ==="1"){$scope.sportbowling=true;$scope.sp=$scope.sp+" Bowling,";}else{$scope.sportbowling=false;}
		if($scope.inter.sportskates ==="1"){$scope.sportskates=true;$scope.sp=$scope.sp+" Skates,";}else{$scope.sportskates=false;}
		if($scope.inter.sportfootball ==="1"){$scope.sportfootball=true;$scope.sp=$scope.sp+" Football,";}else{$scope.sportfootball=false;}
		if($scope.inter.sportswimming ==="1"){$scope.sportswimming=true;$scope.sp=$scope.sp+" Swimming,";}else{$scope.sportswimming=false;}
		if($scope.inter.sportsurfing ==="1"){$scope.sportsurfing=true;$scope.sp=$scope.sp+" Surfing,";}else{$scope.sportsurfing=false;}
		if($scope.inter.sportroller_skates ==="1"){$scope.sportroller_skates=true;$scope.sp=$scope.sp+" Roller skates,";}else{$scope.sportroller_skates=false;}
		if($scope.inter.sportvolyball ==="1"){$scope.sportvolyball=true;$scope.sp=$scope.sp+" Volleyball"}else{$scope.sportvolyball=false;}
		if($scope.inter.sportbicycle ==="1"){$scope.sportbicycle=true;$scope.sp=$scope.sp+" Bicycle,";}else{$scope.sportbicycle=false;}
		if($scope.inter.sportyoga ==="1"){$scope.sportyoga=true;$scope.sp=$scope.sp+" Yoga,";}else{$scope.sportyoga=false;}
		if($scope.inter.sportskilling ==="1"){$scope.sportskilling=true;$scope.sp=$scope.sp+" Skiing,";}else{$scope.sportskilling=false;}
		if($scope.inter.sportbaseball ==="1"){$scope.sportbaseball=true;$scope.sp=$scope.sp+" Baseball,";}else{$scope.sportbaseball=false;}
		if($scope.inter.sporttennis ==="1"){$scope.sporttennis=true;$scope.sp=$scope.sp+" Tennis,";}else{$scope.sporttennis=false;}
		if($scope.inter.sportboxing ==="1"){$scope.sportboxing=true;$scope.sp=$scope.sp+" Boxing,";}else{$scope.sportboxing=false;}
		if($scope.inter.sportbasketball ==="1"){$scope.sportbasketball=true;$scope.sp=$scope.sp+" Basketball,";}else{$scope.sportbasketball=false;}
		if($scope.inter.sportsnowboard ==="1"){$scope.sportsnowboard=true;$scope.sp=$scope.sp+" Snowboard,";}else{$scope.sportsnowboard=false;}
		if($scope.inter.sportkickboxing ==="1"){$scope.sportkickboxing=true;$scope.sp=$scope.sp+" Kickboxing,";}else{$scope.sportkickboxing=false;}
		
//----------Interests TAB----------------------------
		if($scope.interest===""){$scope.interhide=true;}else{$scope.interhide=false;}
		if($scope.sp===""){$scope.sport=true;}else{$scope.sport= false;}
		if($scope.mus===""){$scope.music=true;}else{$scope.music=false;}
		if($scope.mov===""){$scope.movie=true;}else{$scope.movie=false;}
		if($scope.book===""){$scope.books=true;}else{$scope.books=false;}
		if(($scope.interest==="")&&($scope.sp==="")&&($scope.mus==="")&&($scope.mov==="")&&($scope.books==="")){
			$scope.allInter=true;
		}else{$scope.allInter=false;}
	}
	
//		$scope.imageUrl = "../img/profile.png";
//		$scope.numOfMessage = "0";
//		$scope.numOfPhoto = "0";
//		$scope.numOfVideo = "0";
//		$scope.numOfFriends = "0";
//		$scope.numOfGroups = "0";
	
	$scope.editGeneral = function(){
		$scope.General = true;
	}
	$scope.cancelGeneral = function(){
		$scope.General = false;
	}
	$scope.okGeneral = function(){
		$scope.user.fname = $scope.Fname;
		$scope.user.lname = $scope.Lname;
		$scope.username = $scope.user.fname+" "+$scope.user.lname;
		$scope.user.country = $scope.Country;
		$scope.user.state = $scope.State;
		$scope.user.city = $scope.City;
		$scope.user.phone = $scope.Phone;
		$scope.user.bdate = $scope.yearDOB+"-"+$scope.monthDOB+"-"+$scope.dayDOB;
		$scope.user.gender = $scope.Gender;
		$scope.user.status = $scope.Status;
		$scope.user.fromcountry = $scope.Fromcountry;
		$scope.user.fromstate = $scope.Fromstate;
		$scope.user.fromcity = $scope.Fromcity;
		$scope.user.about = $scope.About;
		if($scope.user.phone===""|| ($scope.user.phone===undefined)){$scope.phonehide=true;}else{$scope.phonehide=false;}
		if($scope.user.age===""|| ($scope.user.age===undefined)){$scope.agehide=true;}else{$scope.agehide=false;}
		if($scope.user.country===""|| ($scope.user.country===undefined)){$scope.addresshide=true;}else{$scope.addresshide=false;}
		if($scope.user.status===""|| ($scope.user.status===undefined)){$scope.statushide=true;}else{$scope.statushide=false;}
		if($scope.user.fromcountry===""|| ($scope.user.fromcountry===undefined)){$scope.fromaddresshide=true;}else{$scope.fromaddresshide=false;}
		if(($scope.user.about==="") || ($scope.user.about===undefined)){$scope.abouthide=true;}else{$scope.abouthide=false;}
		if($scope.user.gender==="male"){$scope.colorGender="blue";}
		if($scope.user.gender==="female"){$scope.colorGender="pink";}
		$scope.General = false;
		
//--hide when will be show factory
//-------Data Factory send general info of user--------------------------
		dataFactory.updateUserFactory($scope.user)
			.success(function(result){
				$scope.General = false;
			})
			.error(function(error){
				console.log("error in update general user's info \n"+error);
			})
	}
	$scope.editCareer = function(){
		$scope.Career = true;
	}
	$scope.cancelCareer = function(){
		$scope.Career = false;
	}
	$scope.okCareer = function(){
		$scope.user.job = $scope.Job;
		$scope.user.company = $scope.Company;
		$scope.user.degree = $scope.Degree;
		$scope.user.field = $scope.Field;
		$scope.user.univer = $scope.Univer;
		$scope.user.yearuniver = $scope.Yearuniver;
		$scope.user.school = $scope.School;
		$scope.user.yearschool = $scope.Yearschool;
		$scope.Job = $scope.user.job;
		$scope.Company = $scope.user.company;
		$scope.Degree = $scope.user.degree;
		$scope.Field = $scope.user.field;
		$scope.Univer = $scope.user.univer;
		$scope.Yearuniver = $scope.user.yearuniver;
		$scope.School = $scope.user.school;
		$scope.Yearschool = $scope.user.yearschool;
		if($scope.user.job===""){$scope.jobhide=true;}else{$scope.jobhide=false;}
		if($scope.user.field===""){$scope.degreehide=true;}else{$scope.degreehide=false;}
		if($scope.user.univer===""){$scope.univerhide=true;}else{$scope.univerhide=false;}
		if($scope.user.school===""){$scope.schoolhide=true;}else{$scope.schoolhide=false;}
		if(($scope.user.job==="")&&($scope.user.field==="")&&($scope.user.univer==="")&&($scope.user.school==="")){
			$scope.allCareer=true;
		}else{$scope.allCareer=false}
//-------Data Factory send career info of user--------------------------
		dataFactory.updateUserFactory($scope.user)
			.success(function(result){
				$scope.General = false;
			})
			.error(function(error){
				console.log("error in update general user's info \n"+error);
			})
		$scope.Career = false;
	}
	$scope.editInter = function(){
		$scope.Interests = true;
	}
	$scope.okInter = function(){
//----------------------Button for---Changes-----in-----INTERESTS------------------------------------------------------------------
		$scope.interest="";
		$scope.sp="";
		$scope.mus="";
		$scope.mov="";
		$scope.book="";$scope.inter={};
		if($scope.photo){$scope.inter.photo ="1";$scope.interest=$scope.interest+" Photo,";}else{$scope.inter.photo ="0";}
		if($scope.collecting){$scope.inter.collecting ="1";$scope.interest=$scope.interest+" Collecting,";}else{$scope.inter.collecting ="0";}
		if($scope.needlework){$scope.inter.needlework ="1";$scope.interest=$scope.interest+" Needlework,";}else{$scope.inter.needlework ="0";}
		if($scope.pcgames){$scope.inter.pcgames ="1";$scope.interest=$scope.interest+" PC games,";}else{$scope.inter.pcgames ="0";}
		if($scope.travel){$scope.inter.travel ="1";$scope.interest=$scope.interest+" Travel,"}else{$scope.inter.travel ="0";}
		if($scope.computer){$scope.inter.computer ="1";$scope.interest=$scope.interest+" Computer,";}else{$scope.inter.computer ="0";}
		if($scope.cookery){$scope.inter.cookery ="1"; $scope.interest=$scope.interest+" Cookery,";}else{$scope.inter.cookery ="0";}
		if($scope.art){$scope.inter.art ="1";$scope.interest=$scope.interest+" Art,";}else{$scope.inter.art ="0";}
		if($scope.auto){$scope.inter.auto ="1";$scope.interest=$scope.interest+" Auto,";}else{$scope.inter.auto ="0";}
		if($scope.theater){$scope.inter.theater ="1";$scope.interest=$scope.interest+" Theater,";}else{$scope.inter.theater ="0";}
		if($scope.haunting){$scope.inter.haunting ="1";$scope.interest=$scope.interest+" Hunting,";}else{$scope.inter.haunting ="0";}
		if($scope.science){$scope.inter.science ="1";$scope.interest=$scope.interest+" Science,"}else{$scope.inter.science ="0";}
		
		if($scope.bookclassic){$scope.inter.bookclassic ="1"; $scope.book=$scope.book+" Classic,";}else{$scope.inter.bookclassic ="0";}
		if($scope.bookcomedy){$scope.inter.bookcomedy ="1";$scope.book=$scope.book+" Comedy,";}else{$scope.inter.bookcomedy ="0";}
		if($scope.bookfantasy){$scope.inter.bookfantasy ="1";$scope.book=$scope.book+" Fantasy,";}else{$scope.inter.bookfantasy ="0";}
		if($scope.booktragedy){$scope.inter.booktragedy ="1";$scope.book=$scope.book+" Tragedy";}else{$scope.inter.booktragedy ==="0";}
		if($scope.booklovestory){$scope.inter.booklovestory ="1";$scope.book=$scope.book+" Love story,";}else{$scope.inter.booklovestory ="0";}
		if($scope.bookhorror){$scope.inter.bookhorror ="1";$scope.book=$scope.book+" Horror,";}else{$scope.inter.bookhorror ="0";}
		if($scope.bookbiography){$scope.inter.bookbiography ="1";$scope.book=$scope.book+" Biography,";}else{$scope.inter.bookbiography ="0";}
		if($scope.bookdetective){$scope.inter.bookdetective ="1";$scope.book=$scope.book+" Detective,";}else{$scope.inter.bookdetective ="0";}
		if($scope.bookscience){$scope.inter.bookscience ="1";$scope.book=$scope.book+" Science,";}else{$scope.inter.bookscience ="0";}
		
		if($scope.moviearthouse){$scope.inter.moviearthouse ="1";$scope.mov=$scope.mov+" Arthouse,";}else{$scope.inter.moviearthouse ="0";}
		if($scope.moviecomedy){$scope.inter.moviecomedy ="1";$scope.mov=$scope.mov+" Comedy,";}else{$scope.inter.moviecomedy ="0";}
		if($scope.movieadventure){$scope.inter.movieadventure ="1";$scope.mov=$scope.mov+"Adventure,";}else{$scope.inter.movieadventure ="0";}
		if($scope.moviemusical){$scope.inter.moviemusical ="1";$scope.mov=$scope.mov+" Musical,";}else{$scope.inter.moviemusical ="0";}
		if($scope.movietvseries){$scope.inter.movietvseries ="1";$scope.mov=$scope.mov+" TV series,";}else{$scope.inter.movietvseries ="0";}
		if($scope.moviehistorical){$scope.inter.moviehistorical ="1";$scope.mov=$scope.mov+" Historical,";}else{$scope.inter.moviehistorical ="0";}
		if($scope.moviefantasy){$scope.inter.moviefantasy ="1";$scope.mov=$scope.mov+" Fantasy,";}else{$scope.inter.moviefantasy ="0";}
		if($scope.moviedetective){$scope.inter.moviedetective ="1";$scope.mov=$scope.mov+" Detective,";}else{$scope.inter.moviedetective ="0";}
		if($scope.moviedrama){$scope.inter.moviedrama ="1";$scope.mov=$scope.mov+" Drama,";}else{$scope.inter.moviedrama ="0";}
		if($scope.moviescience){$scope.inter.moviescience ="1";$scope.mov=$scope.mov+" Science,";}else{$scope.inter.moviescience ="0";}
		if($scope.moviethriller){$scope.inter.moviethriller ="1";$scope.mov=$scope.mov+" Thriller,";}else{$scope.inter.moviethriller ="0";}
		if($scope.moviehorror){$scope.inter.moviehorror ="1";$scope.mov=$scope.mov+" Horror,";}else{$scope.inter.moviehorror ="0";}
		if($scope.moviewestern){$scope.inter.moviewestern ="1";$scope.mov=$scope.mov+" Western,";}else{$scope.inter.moviewestern ="0";}
		if($scope.moviesitcom){$scope.inter.moviesitcom ="1";$scope.mov=$scope.mov+" Sitcom,";}else{$scope.inter.moviesitcom ="0";}
		
		if($scope.musicpop){$scope.inter.musicpop ="1";$scope.mus=$scope.mus+" Pop,";}else{$scope.inter.musicpop ="0";}
		if($scope.musicpank){$scope.inter.musicpank ="1";$scope.mus=$scope.mus+" Pank,";}else{$scope.inter.musicpank ="0";}
		if($scope.musicdance){$scope.inter.musicdance ="1";$scope.mus=$scope.mus+" Dance,";}else{$scope.inter.musicdance ="0";}
		if($scope.musicshanson){$scope.inter.musicshanson ="1";$scope.mus=$scope.mus+" Shanson,";}else{$scope.inter.musicshanson ="0";}
		if($scope.musicrnb){$scope.inter.musicrnb ="1";$scope.mus=$scope.mus+" R'n'b,";}else{$scope.inter.musicrnb ="0";}
		if($scope.musicdisco){$scope.inter.musicdisco ="1";$scope.mus=$scope.mus+" Disco,";}else{$scope.inter.musicdisco ="0";}
		if($scope.musiclatino){$scope.inter.musiclatino ="1";$scope.mus=$scope.mus+" Latino,";}else{$scope.inter.musiclatino ="0";}
		if($scope.musiccountry){$scope.inter.musiccountry ="1";$scope.mus=$scope.mus+" Coutry,";}else{$scope.inter.musiccountry ="0";}
		if($scope.musichip_hop){$scope.inter.musichip_hop ="1";$scope.mus=$scope.mus+" Hip-hop,";}else{$scope.inter.musichip_hop ="0";}
		if($scope.musicjass){$scope.inter.musicjass ="1";$scope.mus=$scope.mus+" Jass,";}else{$scope.inter.musicjass ="0";}
		if($scope.musicretro){$scope.inter.musicretro ="1";$scope.mus=$scope.mus+" Retro,";}else{$scope.inter.musicretro ="0";}
		if($scope.musictechno){$scope.inter.musictechno ="1";$scope.mus=$scope.mus+" Techno,";}else{$scope.inter.musictechno ="0";}
		if($scope.musicclassic){$scope.inter.musicclassic ="1";$scope.mus=$scope.mus+" Classic,";}else{$scope.inter.musicclassic ="0";}
		if($scope.musicrocknroll){$scope.inter.musicrocknroll ="1";$scope.mus=$scope.mus+" Rock-n-roll,";}else{$scope.inter.musicrocknroll ="0";}
		if($scope.musicsastriya_sangeet){$scope.inter.musicsastriya_sangeet ="1";$scope.mus=$scope.mus+" Shastriya Sangeet,";}else{$scope.inter.musicsastriya_sangeet ="0";}
		if($scope.musicrock){$scope.inter.musicrock==="1";$scope.mus=$scope.mus+" Rock,";}else{$scope.inter.musicrock ="0";}
		
		if($scope.sportrunning){$scope.inter.sportrunning ="1";$scope.sp=$scope.sp+" Running,";}else{$scope.inter.sportrunning ="0";}
		if($scope.sporthockey){$scope.inter.sporthockey ="1";$scope.sp=$scope.sp+" Hockey,";}else{$scope.inter.sporthockey ="0";}
		if($scope.sportdiving){$scope.inter.sportdiving ="1";$scope.sp=$scope.sp+" Diving,";}else{$scope.inter.sportdiving ="0";}
		if($scope.sportjudo){$scope.inter.sportjudo ="1";$scope.sp=$scope.sp+" Judo,";}else{$scope.inter.sportjudo ="0";}
		if($scope.sportsoccer){$scope.inter.sportsoccer ="1";$scope.sp=$scope.sp+" Soccer,";}else{$scope.inter.sportsoccer ="0";}
		if($scope.sportfitness){$scope.inter.sportfitness ="1";$scope.sp=$scope.sp+" Fitness,";}else{$scope.inter.sportfitness ="0";}
		if($scope.sportbowling){$scope.inter.sportbowling ="1";$scope.sp=$scope.sp+" Bowling,";}else{$scope.inter.sportbowling ="0";}
		if($scope.sportskates){$scope.inter.sportskates ="1";$scope.sp=$scope.sp+" Skates,";}else{$scope.inter.sportskates ="0";}
		if($scope.sportfootball){$scope.inter.sportfootball ="1";$scope.sp=$scope.sp+" Football,";}else{$scope.inter.sportfootball ="0";}
		if($scope.sportswimming){$scope.inter.sportswimming ="1";$scope.sp=$scope.sp+" Swimming,";}else{$scope.inter.sportswimming ="0";}
		if($scope.sportsurfing){$scope.inter.sportsurfing ="1";$scope.sp=$scope.sp+" Surfing,";}else{$scope.inter.sportsurfing ="0";}
		if($scope.sportroller_skates){$scope.inter.sportroller_skates ="1";$scope.sp=$scope.sp+" Roller skates,";}else{$scope.inter.sportroller_skates ="0";}
		if($scope.sportvolyball){$scope.inter.sportvolyball ="1";$scope.sp=$scope.sp+" Volleyball"}else{$scope.inter.sportvolyball ="0";}
		if($scope.sportbicycle){$scope.inter.sportbicycle ="1";$scope.sp=$scope.sp+" Bicycle,";}else{$scope.inter.sportbicycle ="0";}
		if($scope.sportyoga){$scope.inter.sportyoga ="1";$scope.sp=$scope.sp+" Yoga,";}else{$scope.inter.sportyoga ="0";}
		if($scope.sportskilling){$scope.inter.sportskilling ="1";$scope.sp=$scope.sp+" Skiing,";}else{$scope.inter.sportskilling ="0";}
		if($scope.sportbaseball){$scope.inter.sportbaseball ="1";$scope.sp=$scope.sp+" Baseball,";}else{$scope.inter.sportbaseball ="0";}
		if($scope.sporttennis){$scope.inter.sporttennis ="1";$scope.sp=$scope.sp+" Tennis,";}else{$scope.inter.sporttennis ="0";}
		if($scope.sportboxing){$scope.inter.sportboxing ="1";$scope.sp=$scope.sp+" Boxing,";}else{$scope.inter.sportboxing ="0";}
		if($scope.sportbasketball){$scope.inter.sportbasketball==="1";$scope.sp=$scope.sp+" Basketball,";}else{$scope.inter.sportbasketball ="0";}
		if($scope.sportsnowboard){$scope.inter.sportsnowboard ="1";$scope.sp=$scope.sp+" Snowboard,";}else{$scope.inter.sportsnowboard ="0";}
		if($scope.sportkickboxing){$scope.inter.sportkickboxing ="1";$scope.sp=$scope.sp+" Kickboxing,";}else{$scope.inter.sportkickboxing ="0";}
		
		if($scope.interest===""){$scope.interhide=true;}else{$scope.interhide=false;}
		if($scope.sp===""){$scope.sport=true;}else{$scope.sport= false;}
		if($scope.mus===""){$scope.music=true;}else{$scope.music=false;}
		if($scope.mov===""){$scope.movie=true;}else{$scope.movie=false;}
		if($scope.book===""){$scope.books=true;}else{$scope.books=false;}
		if(($scope.interest==="")&&($scope.sp==="")&&($scope.mus==="")&&($scope.mov==="")&&($scope.book==="")){
			$scope.allInter=true;
		}else{$scope.allInter=false;}
// ------Data factory for interests---------------------------------------------
		$scope.inter.email=$rootScope.profileUser;
		dataFactory.updateInterestFactory($scope.inter)
		.success(function(){
			$scope.Interests = false;
		})
		.error(function(error){
			console.log("ERROR in updating interests of user \n"+error);
		})
//------------------------------------------------------------------------------------------------------------------------
	}
	$scope.cancelInter = function(){
		$scope.Interests = false;
	}
	$scope.editSecurity = function(){
		$scope.changeSecurity = true;
	}
	$scope.cancelSecurity = function(){
		$scope.changeSecurity = false;
	}
	$scope.okSecurity = function(){
		console.log("password="+$scope.password);
		$scope.changepass={
				email:$rootScope.profileUser,
				password:$scope.password,
		}
		dataFactory.changePassfactory($scope.changepass)
		.success(function(){
			$scope.changeSecurity = false;
		})
		.error(function(error){
			colsole.log("ERROR in change password \n"+error);
		})
	}
	
	/*****************Choose Avatar Modal *********************/
	$scope.openAvatarPicker = function() {
		console.log("Opening avatar modal")
		var modalInstance = $modal.open({
			templateUrl: 'pages/chooseAvatar.html',
			controller: "chooseAvatarCtrl"
		});

		modalInstance.result.then(function (selectedItem) {
			$scope.selected = selectedItem;
		}, function () {
			$log.info('Modal dismissed at: ' + new Date());
		});
	};
		
	}//else
})

app.controller("chooseAvatarCtrl", function($scope, $rootScope, $modalInstance) {
	console.log("initiallizing changeAvatarCtrl");
	$rootScope.image2={url:"../img/profile.png"};
	
	$scope.closeChooseAvatar = function() {
		 $modalInstance.close();
	};

	$scope.single = function(image) {
        var formData = new FormData();
        formData.append('image', image, image.name);

        $http.post('upload', formData, {
            headers: { 'Content-Type': false },
            transformRequest: angular.identity
        }).success(function(result) {
            $scope.uploadedImgSrc = result.src;
            $scope.sizeInBytes = result.size;
        });
        
        $modalInstance.close();
	};
});