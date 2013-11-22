'use strict';
angular.module('NRIVishwaKarma')
.factory('dataFactory', ['$http', function($http) {
	var dataFactory = {};
    
    dataFactory.registerUser = function(json) {
    	return $http.post('/register', json);
    };
 
	return dataFactory;
}]);