app.controller('newUserCtrl',function($scope, $window, $location){

	  // Datepicker directive
	  $scope.datepicker = {date: new Date()};
	  
	 $("html").removeClass("no-js").addClass("js");
	 var $window = $(window);
	 new FastClick(document.body);
	
	// Disable certain links in docs
	$('section [href^=#]').click(function (e) {
		e.preventDefault();
	});
	// Make code pretty
	window.prettyPrint && window.prettyPrint();
	  
});