/* 
* Copyright 2014 Space Dynamics Laboratory - Utah State University Research Foundation.
*
* Licensed under the Apache License, Version 2.0 (the 'License');
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an 'AS IS' BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

'use strict';

/*global setupPopovers*/

app.controller('LandingCtrl', ['$scope', 'business', 'localCache', '$location', '$timeout', '$filter', '$route', function ($scope, Business, localCache, $location, $timeout, $filter, $route)  {/*jshint unused:false*/
  // set up the landing page route so that we include the right landing page.
  Business.componentservice.doSearch('search', 'All').then(function(result) {
    $scope.total = result || {};
  });
  $scope.data = {};
  $scope.landingRoute = null;
  
  Business.getFilters().then(function(result) {
    if (result) {
      $scope.filters = result;
      $scope.filters = angular.copy($scope.filters);
    } else {
      $scope.filters = null;
      $scope.filters = angular.copy($scope.filters);
    }
  });


  $scope.$emit('$TRIGGERLOAD', 'landingLoader');
  $timeout(function() {
    // Business.landingPage(false, false, true).then(function (result) {
      var result = localCache.get('landingRoute');
      if ($location.search() && $location.search().route) {
        $scope.landingRoute = $location.search().route;
        $scope.$emit('$TRIGGERUNLOAD', 'landingLoader');
        $scope.loaded = true;
      } else if (result) {
        $scope.landingRoute = result;
        $scope.$emit('$TRIGGERUNLOAD', 'landingLoader');
        $scope.loaded = true;
      }
    // });
  }, 1000); //

  $scope.$on('$TRIGGERLANDING', function(event, data) {
    if ($location.search() && $location.search().route) {
      $scope.landingRoute = $location.search().route;
      $scope.$emit('$TRIGGERUNLOAD', 'landingLoader');
      $scope.loaded = true;
    } else {
      $scope.landingRoute = data;
      $scope.$emit('$TRIGGERUNLOAD', 'landingLoader');
      $scope.loaded = true;
    }
  });

  /***************************************************************
  * This function is used to send the user to the results page with the correct
  * results.
  ***************************************************************/
  $scope.sendToResults = function() {
    var landingType = localCache.get('landingType');
    var landingCode = localCache.get('landingCode');
    if (landingType && landingCode) {
      $location.search({
        'type': landingType,
        'code': landingCode
      });
    } else {
      $location.search({
        'type': 'categories',
        'code': 'IDAM'
      });
    }
    $location.path('/results');
  };

  /***************************************************************
  * This function applies the filters that have been given to us to filter the
  * data with
  ***************************************************************/
  $scope.applyFilters = function(data) {
    data = $filter('componentFilter')($scope.total, $scope.filters);
    $timeout(function() {
      setupPopovers();
    }, 300);
    _.each(data, function(item){
      if (item.description !== null && item.description !== undefined && item.description !== '') {
        var desc = item.description.match(/^(.*?)[.?!]\s/);
        item.shortdescription = (desc && desc[0])? desc[0] + '.': item.description;
      } else {
        item.shortdescription = 'This is a temporary short description';
      }
    });
    return data;
  };
}]);
