angular.module('demo', [])
    .controller('RealEstate', function($scope, $http) {
        $http.get('http://localhost:8080/real-estate/7').
        then(function(response) {
            $scope.realEstate = response.data;
        });
    });