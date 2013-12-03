app.controller("membersCtrl", function($scope,dataFactory,$rootScope) {
	$scope.alphabeticFilter = "All";
	$scope.searchBox = "";
    //$scope.pageNumbers = [1,2,3,4,5,6,7,8,9,10];
	$scope.showPageNumbers=true;	
	dataFactory.showAllMembers().success(function(members){
	    console.log("success");
	    $scope.members=members;
	    $rootScope.pageNumbers=members[1].c;
	    
	   /* if($rootScope.pageNumbers[members[1].count] == -1)
	    {
	    	
			$scope.showPageNumbers=false;
		}
		*/
	    console.log($rootScope.pageNumbers[members[1].count]);
		})
		.error(function(error){
			console.log("error in getting interest \n"+error);
		});
	
	$scope.mem= [{FName: "James", LName: "Bond", friend: true, imageUrl: ""},
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
		if ($scope.alphabeticFilter == "All"){
			dataFactory.showAllMembers().success(function(members){
			    console.log("success");
			    $scope.members=members;
			    console.log(members[1].c[3]);
			    
				
				})
				.error(function(error){
					console.log("error in getting values for all \n"+error);
				});
			
			
		}
		else{
		
		var data={
				alphabeticFilter:$scope.alphabeticFilter
		         };
		dataFactory.showAlphabeticMembers(data).success(function(members){
		    console.log("success");
		    $scope.members=members;
			
			})
			.error(function(error){
				console.log("error in getting for alphabetic \n"+error);
			});
		
		
		}
	};
	
	$scope.requestSelectedPage = function(pageNum) {
		console.log($scope.pageNumbers[pageNum]);
		console.log($scope.alphabeticFilter);
	};
	
	$scope.searchByName = function(){
		
	var data={	
		searchBox:$scope.searchBox
	          };
	dataFactory.searchByNameFactory(data).success(function(members){
    console.log("success");
    $scope.members=members;
	
	})
	.error(function(error){
		console.log("error in getting interest \n"+error);
	});
	};
});