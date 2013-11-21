app.controller('profileCtrl',function($scope,$rootScope){
	$rootScope.user={
			email:"katrina@gmail.com",
			fname:"Katrina",
			lname:"Lander",
			age:"30",
			imageUrl:"../img/profile.png",
			country:"US",
			state:"IL",
			city:"Buffalo Grove",
			status:"married",
			job:"training",
			company:"PTP",
			fromcountry:"Israel",
			fromstate:"-",
			fromcity:"Beer-Sheva",
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
})