var app = angular.module("votersModule",[]);

	app.config(function($httpProvider) {
		$httpProvider.defaults.useXDomain = true;
		delete $httpProvider.defaults.headers.common['X-Requested-With'];
	});
  
	app.controller("votersController", function($scope, $http) {
		$scope.ok = false;
		$scope.ko = false;
		$scope.datosFormulario = {};
		
		$scope.autenticar = function(){
			$http.post("http://localhost:8080/GetVoterInfo", $scope.datosFormulario)
				.success(function(data) {
					$scope.ok = true;
					$scope.ko = false;
					$scope.respuesta = data;
				})
				.error(function(data) {
					$scope.ok = false;
					$scope.ko = true;
					console.log('Error:' + data);
			});
		};
		
		$scope.cambiarClave = function(){
			$http.post("http://localhost:8080/UpdatePassword", $scope.datosFormulario)
				.success(function(data) {
					$scope.ok = true;
					$scope.ko = false;
					$scope.respuesta = data;
					console.log(data);
				})
				.error(function(data) {
					$scope.ok = false;
					$scope.ko = true;
					console.log('Error:' + data);
			});
		};
	});