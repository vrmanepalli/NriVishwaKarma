var app = angular.module("NRIVishwaKarma", []).config(function($routeProvider) {
	$routeProvider.when("/Home", {
		templateUrl: "pages/home.html",
		controller: "homeCtrl"
	})
	.when("/NewUser", {
		templateUrl: "pages/newUser.html",
		controller: "newUserCtrl"
	})
	.when("/Profile", {
		templateUrl: "pages/profile.html",
		controller: "profileCtrl"
	})
	.otherwise({redirectTo: '/Home'});
});

app.controller("NRIVishwaKarmaCtrl", function($scope) {
	
});