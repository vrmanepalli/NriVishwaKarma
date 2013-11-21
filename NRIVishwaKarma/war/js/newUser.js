
app.controller('newUserCtrl', function($scope, $location, $http, $rootScope, dataFactory){
	
	// Datepicker directive
	$scope.datepicker = {date: new Date()};
	  
	$rootScope.image2={url:"../img/profile.png"};
	$scope.icon1 = "../img/default.png";
	$scope.icon2 = "../img/default.png";
	$scope.icon3 = "../img/default.png";
	$scope.icon4 = "../img/default.png";
	$scope.icon5 = "../img/default.png";
	$scope.icon6 = "../img/default.png";
	var width = 300
	$scope.imageWidth = width;
	var heading = 0;
	$scope.heading = heading;
	
	$scope.signupForm = function() {
		var data = {
			fname: $scope.fname,
			lname: $scope.lname,
			bday: $scope.datepicker.date,
			gender: $scope.gender,
			country: $scope.country,
			state: $scope.state,
			city: $scope.city,
			email: $scope.email,
			password: $scope.password,
			confirm_pass: $scope.confPassword,
			country_origin: $scope.originCountry,
			state_origin: $scope.originState,
			city_origin: $scope.originCity,
			phone: $scope.phone
		};
		console.log(JSON.stringify(data));
		dataFactory.registerUser(JSON.stringify(data))
			.success(function(results) {
				console.log(results);
			})
			.error(function(error) {
				console.log(error);
			});
	};
});
	/*
	app.directive('rotate', function () {
	    return {
	        restrict: 'A',
	        link: function (scope, element, attrs) {
	            scope.$watch(attrs.degrees, function (rotateDegrees) {
	                console.log(rotateDegrees);
	                var r = 'rotate(' + rotateDegrees + 'deg)';
	                element.css({
	                    '-moz-transform': r,
	                    '-webkit-transform': r,
	                    '-o-transform': r,
	                    '-ms-transform': r
	                });
	            });
	        }
	    }
	});
	
	$scope.leftTurn = function(){
		heading = heading-90
		$scope.heading=heading;
	}
	
	$scope.rightTurn = function(){
		heading = heading+90;
		$scope.heading=heading;
	}
	  
		  $scope.checkForm=function(field, type){
			 var pp = '';
			// validate login
			   if(type == 'login'){
			   var pp = /^[a-zA-Z][a-zA-Z-\._]+[a-zA-Z0-9]$/;
			   }
			// only A-Z
			   if(type == 'en'){
			   var pp = /^[a-zA-Z ]*$/;
			   }
			// A-Z and 1,2,3
			   else if(type == 'en123'){
			   var pp = /^[a-zA-Z0-9]*$/;
			   }
			// !email
			   else if(type == 'email'){
			   var pp = /^[a-zA-Z][-\._a-zA-Z0-9]+@(?:[a-zA-Z0-9][-a-zA-Z0-9]+\.)+[a-zA-Z]{2,6}$/;
			   }
			// only 123
			   else if(type == '123'){
			   var pp = /^[0-9]*$/;
			   }
			//if empty
			   else if(pp == ''){
			   return false;
			   }
			// not empty
			      if (field === ''){
			         return false;
			      }
			//validation about type
			    else if(!field.match(pp)){
			    return false;
			    }
			      return true;   
		};
		
		$scope.validFName=function(){
			if($scope.fname==undefined){
				$scope.fName="control-group error";
				$scope.icon1="../img/attention.png";
			}
			else if($scope.checkForm($scope.fname,'en')){
				$scope.fName="control-group success";
				$scope.icon1="../img/success.png";
			}
			else{
				$scope.fName="control-group error";
				$scope.icon1="../img/attention.png";
			}
		};//validFName
		
		$scope.validLName=function(){
			$scope.validFName();
			if ($scope.lname==undefined){
				
			}
			else if($scope.checkForm($scope.lname,'en')){
				$scope.lName="control-group success";
				$scope.icon2="../img/success.png";
			}
			else{
				$scope.lName="control-group error";
				$scope.icon2="../img/attention.png";
			}
		};//validLName
		
		$scope.validGender=function(){
			$scope.validLName();
			if($scope.gender===undefined){
				$scope.Gender="control-group error";
				$scope.icon3="../img/attention.png";
			}
			else{
				$scope.Gender="control-group success";
				$scope.icon3="../img/success.png";
			}
		}
		
		$scope.validEmail=function(){
			$scope.validGender();
			if($scope.email==undefined){
				$scope.fieldEmail="control-group error";
				$scope.icon4="../img/attention.png";
			}
			else if($scope.checkForm($scope.email,'email')){
				$scope.fieldEmail="control-group success";
				$scope.icon4="../img/success.png";
			}
			else{
				$scope.fieldEmail="control-group error";
				$scope.icon4="../img/attention.png";
			}
		};//validEmail
		
		$scope.validPassword=function(){
			$scope.validEmail();
			if ($scope.password==undefined){
				$scope.fieldPassword="control-group error";
				$scope.icon5="../img/attention.png";
			}
			if($scope.checkForm($scope.password,'en123')){
				$scope.fieldPassword="control-group success";
				$scope.icon5="../img/success.png";
			}
			else{
				$scope.fieldPassword="control-group error";
				$scope.icon5="../img/attention.png";
			}
		};//validPassword
		
		$scope.validConfirm=function(){
			$scope.validPassword();
			if($scope.confpassword === $scope.password){
				$scope.fieldConfpassword="control-group success";
				$scope.icon6="../img/success.png";
			}
			else{
				$scope.fieldConfpassword="control-group error";
				$scope.icon6="../img/attention.png";
			}
		};//validConfirm
		
//-----------download avatar---------------------------------------
		
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
	*/