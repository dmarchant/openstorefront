/* 
* Copyright 2014 Space Dynamics Laboratory - Utah State University Research Foundation.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

/*global MOCKDATA2*/

'use strict';
app.factory('userservice', ['$rootScope', 'localCache', '$http', '$q', function($rootScope, localCache, $http, $q) {

  //Constants
  var CURRENT_USER = 'CURRENTUSER';
  var minute = 60 * 1000;
  var day = minute * 1440; //1 day
  var MAX_USER_CACHE_TIME = day; /*jshint unused:false*/


  /***************************************************************
  * This function is used to check the localCache for the existance of a result
  * object that hasn't yet expired
  * params: name -- The unique identifier for the entry in the local cache (usually a string)
  * params: expire -- The ammount of time in ms that it will take for the object to expire
  * returns: result -- The value of the object if it has not yet expired, and null for
  *                    result objects that are no longer valid
  ***************************************************************/
  var checkExpire = function(name, expire) {
    var result = localCache.get(name, 'object');
    var cacheTime = null;
    if (result) {
      cacheTime = localCache.get(name+'-time', 'date');
      var timeDiff = new Date() - cacheTime;
      if (timeDiff < expire) {
        return result;
      } else {
        return null;
      }
    }
    return null;
  };

  /***************************************************************
  * We use this function in conjunction with the checkExpire function.
  * Use this function to save the value in the local cache (it will also save
  * an expire time that it can use later to check validity of an entry)
  * params: name -- The unique identifier for the entry in the local cache (usually a string)
  * params: value -- The value of the data that you will be storing
  ***************************************************************/
  var save = function(name, value) {
    localCache.save(name, value);
    localCache.save(name+'-time', new Date());
  };

  var updateCache = function(name, value) {
    save(name, value);
  };


  /**
  *  Loads the current user
  */
  var getCurrentUserProfile = function(forceReload) {
    var deferred = $q.defer();

    var currentUser = checkExpire('currentUserProfile');
    if (currentUser) {
      deferred.resolve(currentUser);
    } else {
      loadProfile(CURRENT_USER, function(data, status, headers, config) { /*jshint unused:false*/
        if (data) {
          save('currentUserProfile', data);
          deferred.resolve(data);
        }
      });
    }

    return deferred.promise;
  };

  /**
  *  Load profile from the server
  * @param string username
  * @returns {undefined}
  */
  var loadProfile = function(username, successFunc) {
    $http.get('/api/v1/resource/userprofiles/' + username).success(successFunc);
  };

  var saveCurrentUserProfile = function(userProfile) { /*jshint unused:false*/
    return saveProfile(CURRENT_USER, userProfile);
  };

  /**
  *  Save profile to the service and on success it reloads the profile
  * @param string usernamer
  * @returns {undefined}
  */
  var saveProfile = function(username, userProfile) { /*jshint unused:false*/
    var deferred = $q.defer();
    if (true) {
      deferred.resolve('It worked');
    } else {
      // if the save fails, give them a reason why... with an error object like this
      //?fix
      /*
      *  {
      *    'success': false,
      *    'errors': [
      *      {
      *        'mainSearchBar' : 'Your input was invalid. Please try again.'
      *      },ok
      *      {
      *        'element_id' : 'Error message to be displayed in the tooltip'
      *      }
      *    ]
      *  };
      */
      deferred.reject('It Failed');
    }
    return deferred.promise;
  };


  var getWatches = function() {
    var deferred = $q.defer();

    var watches = checkExpire('watches', minute * 0.5);
    if (watches) {
      deferred.resolve(watches);
    } else {
      $http({
        'method': 'GET',
        'url': '/api/v1/resource/lookup/watches'
      }).success(function(data, status, headers, config) { /*jshint unused:false*/
        if (data && data !== 'false') {
          save('watches', data);
          deferred.resolve(data);
        } else {
          deferred.reject('There was an error grabbing the watches');
        }
      }).error(function(data, status, headers, config) { /*jshint unused:false*/
      });
    }

    return deferred.promise;
  };

  var setWatches = function(watches) {
    var deferred = $q.defer();

    $http({
      'method': 'POST',
      'url': '/api/v1/resource/lookup/watches',
      'data': watches
    }).success(function(data, status, headers, config) { /*jshint unused:false*/
      if (data && data !== 'false') {
        updateCache('watches', data);
        $rootScope.$broadcast('$updatedWatches');
        deferred.resolve(true);
      } else {
        // deferred.reject('There was an error grabbing the watches');
      }
    }).error(function(data, status, headers, config) { /*jshint unused:false*/
    });

    return deferred.promise;
  };


  /**
  *
  */
  var getReviews = function(userName) {
    var deferred = $q.defer();
    var reviews = [];
    _.each(MOCKDATA2.componentList, function(component) {
      if (component.reviews[0] !== undefined) {
        var review = {
          'componentId': component.componentId,
          'name': component.name,
          'reviews': [],
        };
        _.each(component.reviews, function(item){
          if (item.username === userName) {
            review.reviews.push(item);
          }
        });
        if (review.reviews[0] !== undefined) {
          reviews.push(review);
        }
      }
    });

    deferred.resolve(reviews);
    return deferred.promise;
  };

  //Public API
  return {
    getCurrentUserProfile: getCurrentUserProfile,
    saveCurrentUserProfile: saveCurrentUserProfile,
    getReviews: getReviews,
    getWatches: getWatches,
    setWatches: setWatches
  };

}]);