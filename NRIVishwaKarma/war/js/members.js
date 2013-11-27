app.controller("membersCtrl", function($scope) {
	$scope.alphabeticFilter = "All";
	$scope.searchBox = "";
	$scope.pageNumbers = [1,2,3,4,5,6,7,8,9,10];
	$scope.members = [{FName: "James", LName: "Bond", friend: true, imageUrl: ""},
	                      {FName: "Frank", LName: "West", friend: false, imageUrl: ""},
	                      {FName: "Mary", LName: "Templin", friend: false, imageUrl: ""},
	                      {FName: "Tia", LName: "Wates", friend: true, imageUrl: ""},
	                      {FName: "Hank", LName: "Schrader", friend: true, imageUrl: ""},
	                      {FName: "Bill", LName: "Williams", friend: true, imageUrl: ""},
	                      {FName: "Harry", LName: "Osborn", friend: true, imageUrl: ""},
	                      {FName: "Ellen", LName: "Gates", friend: true, imageUrl: ""}];
	
	$(".filter a").click(function(event) {
		event.preventDefault();
        $scope.setAlphabeticFilter(event.target.id);
    });
	
	$(".pagination a").click(function(event) {
		event.preventDefault();
		$scope.requestSelectedPage(event.target.id);
	});
	
	$scope.setAlphabeticFilter = function(filter) {
		$("#" + $scope.alphabeticFilter).attr("class", "");
		$scope.alphabeticFilter = filter;
		$("#" + filter).attr("class", "btn btn-primary");
		console.log(filter);
	};
	
	$scope.requestSelectedPage = function(pageNum) {
		console.log($scope.pageNumbers[pageNum]);
	};
});