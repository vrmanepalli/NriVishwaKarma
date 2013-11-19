var app = angular.module('myApp',['$strap.directives']);

app.config(function($routeProvider){
	/*$routeProvider.
	when('/',{templateUrl:'/',controller:''}).
	otherwise({redirecTo:'/',template:'/',controller:''});*/
});

app.controller('newUserCtrl',function($scope, $window, $location){

	  // Datepicker directive
	  $scope.datepicker = {date: new Date()};
	  
	  
	  
	});

	// Docs styles
	//
	$(function() {
	  $("html").removeClass("no-js").addClass("js");
		var $window = $(window);
	  new FastClick(document.body);
		$(document).ready(function($) {
			// Disable certain links in docs
			$('section [href^=#]').click(function (e) {
				e.preventDefault();
			});
			// Make code pretty
			window.prettyPrint && window.prettyPrint();
		});
	});
