'use strict';
app.controller('newUserCtrl', function($scope, $location, $http, $rootScope, dataFactory){
	
	$scope.question = "What was your childhood nickname?";
	$scope.gender="male";
	$scope.month = "01";
	$scope.day = "01";
	$scope.year = "2013";
	
	$scope.daysInMonth = [31,29,31,30,31,30,31,30,31,30,31,30];
	
	$scope.signupForm = function() {
		var data = {
			fname: $scope.fname,
			lname: $scope.lname,
			bday: $scope.year + "-" + $scope.month + "-" + $scope.day,
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
			phone: $scope.phone,
			question: $scope.question,
			answer: $scope.answer
		};
		console.log(JSON.stringify(data));
		dataFactory.registerUser(JSON.stringify(data))
			.success(function(results) {
				console.log(results);
				$location.path("/Profile");
			})
			.error(function(error) {
				console.log(error);
			});
	};
});

angular.module('NRIVishwaKarma').directive('match', function($parse) {
	return {
		require: 'ngModel',
		link: function(scope, elem, attrs, ctrl) {
			scope.$watch(function() {        
		        return $parse(attrs.match)(scope) === ctrl.$modelValue;
		    }, function(currentValue) {
		    	ctrl.$setValidity('mismatch', currentValue);
		    });
		}
	};
});