'use strict';
app.controller('profileCtrl',function($scope,$rootScope){
	$rootScope.user={
			email:"katrina@gmail.com",
			password:"123456",
			fname:"Katrina",
			lname:"Lander",
			age:"30",
			bdate:"01/14/1984",
			gender:"female",
			imageUrl:"../img/profile.png",
			country:"US",
			state:"IL",
			city:"Buffalo Grove",
			phone:"8472192363",
			status:"married",
			job:"training",
			company:"PTP",
			fromcountry:"Israel",
			fromstate:"-",
			fromcity:"Beer-Sheva",
			degree:"master",
			field:"Mathematic's and IT in economics",
			univer:"DSEA",
			yearuniver:"2006",
			school:"Slavyansk hight school",
			yearschool:"2001",
			about:"I created this page, I'll hope You will like it!:)",
			inter:"",
			sport:"",
			music:"",
			movie:"",
			book:""
	}
	
	$scope.datepicker = {date: new Date($rootScope.user.bdate)};
//	$scope.User = true; //<---for hide change information for guests of page
	
	if($rootScope.user === undefined){
		console.log("in if");
		$scope.imageUrl = "../img/profile.png";
		$scope.numOfMessage = "0";
		$scope.numOfPhoto = "0";
		$scope.numOfVideo = "0";
		$scope.numOfFriends = "0";
		$scope.numOfGroups = "0";
	}
	else{
		$scope.imageUrl = $rootScope.user.imageUrl; 
		$scope.username = $rootScope.user.fname+" "+$rootScope.user.lname;
		
		if($rootScope.user.inter ===""){$rootScope.user.inter=$scope.username+" has no particular preferences"; }
		if($rootScope.user.sport ===""){$rootScope.user.sport=$scope.username+" has no particular preferences"; }
		if($rootScope.user.music ===""){$rootScope.user.music=$scope.username+" has no particular preferences"; }
		if($rootScope.user.movie ===""){$rootScope.user.movie=$scope.username+" has no particular preferences"; }
		if($rootScope.user.book ===""){$rootScope.user.book=$scope.username+" has no particular preferences"; }

		}//else
	$scope.editGeneral = function(){
		$scope.General = true;
	}
	$scope.cancelGeneral = function(){
		$scope.General = false;
	}
	$scope.okGeneral = function(){
		$scope.username = $rootScope.user.fname+" "+$rootScope.user.lname;
	}
	$scope.editCareer = function(){
		$scope.Career = true;
	}
	$scope.cancelCareer = function(){
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