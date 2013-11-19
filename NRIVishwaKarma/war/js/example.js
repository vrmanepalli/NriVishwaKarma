var app = angular.module('angularjs-starter', ['$strap.directives']);

app.controller('MainCtrl', function($scope, $window, $location) {

  // Datepicker directive
  $scope.datepicker = {date: new Date("2012-09-01T00:00:00.000Z")};
  
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