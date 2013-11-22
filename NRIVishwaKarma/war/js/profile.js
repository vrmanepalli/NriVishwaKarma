'use strict';
app.controller('profileCtrl',function($scope,$rootScope){
//-------------Data Factory to download user's data for page----------------------
//	$scope.user = {};
//	dataFactory.getUserFactory('email')
//		.success(function(userData){
//			$scope.user = userData;
//		})
//		.error(function(error){
//			console.log("error in getting USER \n"+error);
//		});
	$rootScope.currentUser={email:"katrina@gmail.com"};
	$scope.user={
			email:"katrina@gmail.com",
			password:"123456",
			fname:"Katrina",
			lname:"Lander",
			age:"25",
			bdate:"01/14/1999",
			gender:"female",
			imageUrl:"../img/profile.png",
			country:"USA",
			state:"Illinois",
			city:"Buffalo Grove",
			phone:"",
			status:"married",
			fromcountry:"Israel",
			fromstate:"-",
			fromcity:"Beer-Sheva",
			job:"Training",
			company:"PTP",
			degree:"Master",
			field:"Mathematic's and IT in economics",
			univer:"DSEA",
			yearuniver:"2006",
			school:"Slavyansk hight school #15",
			yearschool:"2001",
			about:"I created this page, I'll hope You will like it!:)",
			inter:"photo, travel, computer",
			sport:"fitness",
			music:"",
			movie:"comedy",
			book:"fantasy"
	}
//------------General TAB-------------------------------------------
	$scope.imageUrl = $scope.user.imageUrl; 
	$scope.username = $scope.user.fname+" "+$scope.user.lname;
	if($scope.user.phone===""){$scope.phonehide=true;}
	if($scope.user.age===""){$scope.agehide=true;}
	if($scope.user.country===""){$scope.addresshide=true;}
	if($scope.user.status===""){$scope.statushide=true;}
	if($scope.user.fromcountry===""){$scope.fromaddresshide=true;}
	if($scope.user.about===""){$scope.abouthide=true;}
	if($scope.user.gender==="male"){$scope.colorGender="blue";}
	if($scope.user.gender==="female"){$scope.colorGender="pink";}
	$scope.datepicker = {date: new Date($scope.user.bdate)};
	
	$scope.Fname=$scope.user.fname;
	$scope.Lname=$scope.user.lname;
	$scope.Country=$scope.user.country;
	$scope.State=$scope.user.state;
	$scope.City=$scope.user.city;
	$scope.Phone=$scope.user.phone;
	$scope.Gender=$scope.user.gender;
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
	if($scope.user.degree===""){$scope.degreehide=true;}
	if($scope.user.univer===""){$scope.univerhide=true;}
	if($scope.user.school===""){$scope.schoolhide=true;}
	if(($scope.user.job==="")&&($scope.user.degree==="")&&($scope.user.univer==="")&&($scope.user.school==="")){
		$scope.allCareer=true;
	}
//----------Interests TAB----------------------------
	
	if($scope.user.inter===""){$scope.inter=true;}
	if($scope.user.sport===""){$scope.sport=true;}
	if($scope.user.music===""){$scope.music=true;}
	if($scope.user.movie===""){$scope.movie=true;}
	if($scope.user.book===""){$scope.book=true;}
	if(($scope.user.inter==="")&&($scope.user.sport==="")&&($scope.user.music==="")&&($scope.user.movie==="")&&($scope.user.book==="")){
		$scope.allInter=true;
	}
	
	if($scope.user.email === $rootScope.currentUser.email){//-----<----if user open his page
		console.log("in if");		
		
	}
	else{//-------<-------if guest open this page
		$scope.User = true;
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
		$scope.user.bdate = $scope.datepicker.date;
		$scope.user.gender = $scope.Gender;
		$scope.user.status = $scope.Status;
		$scope.user.fromcountry = $scope.Fromcountry;
		$scope.user.fromstate = $scope.Fromstate;
		$scope.user.fromcity = $scope.Fromcity;
		$scope.user.about = $scope.About;
		if($scope.user.phone===""){$scope.phonehide=true;}else{$scope.phonehide=false;}
		if($scope.user.age===""){$scope.agehide=true;}else{$scope.agehide=false;}
		if($scope.user.country===""){$scope.addresshide=true;}else{$scope.addresshide=false;}
		if($scope.user.status===""){$scope.statushide=true;}else{$scope.statushide=false;}
		if($scope.user.fromcountry===""){$scope.fromaddresshide=true;}else{$scope.fromaddresshide=false;}
		if($scope.user.about===""){$scope.abouthide=true;}else{$scope.abouthide=false;}
		if($scope.user.gender==="male"){$scope.colorGender="blue";}
		if($scope.user.gender==="female"){$scope.colorGender="pink";}
		$scope.General = false;//--hide when will be show factory
//-------Data Factory send general info of user--------------------------
//		dataFactory.updateUserFactory($scope.user)
//			.success(function(result){
//				$scope.General = false;
//			})
//			.error(function(error){
//				console.log("error in update general user's info \n"+error);
//			})
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
//-------Data Factory send career info of user--------------------------
//		dataFactory.updateUserFactory($scope.user)
//			.success(function(result){
//				$scope.General = false;
//			})
//			.error(function(error){
//				console.log("error in update general user's info \n"+error);
//			})
		$scope.Career = false;
	}
	$scope.editInter = function(){
		$scope.Interests = true;
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
	
	
	
	
	//-----------download avatar---------------------------------------
	$rootScope.image2={url:"../img/profile.png"};

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
};	
})
