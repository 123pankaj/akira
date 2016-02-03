
<div>
	<div class="controls form-inline">

		<select ng-model="date" ng-change="byDate()" class="form-control">
			<option ng-repeat="day in week">{{day}}</option>
		</select> 
		
		
		<select class="form-control" ng-model="selectedtable"  ng-change="byTable()" >
			<option value="logs">All Logs</option>
			<option value="endpoint">End point</option>
		</select>
		
		
		 <select ng-model="pageSize" ng-change="changeSize()"
			class="form-control">
			<option ng-repeat="size in pageSizes">{{size}}</option>
		</select>

	</div>
	<table class="table table-hover table-striped" id="logs">
		<tr class="row">
			<th ng-click="sortBy('URLRequested')">URL</th>
			<th ng-click="sortBy('SuccessStatusCode')">#Success Code</th>
			<th ng-click="sortBy('RedirectStatusCode')">#Redirect Code</th>
			<th ng-click="sortBy('FailureStatusCode')">#Failure Code</th>
			<th ng-click="sortBy('AverageTimeInMicro')">Average Response Time(micro seconds)</th>
			
		</tr>
		<tr ng-repeat="item in LogArray" class="row">
			<td>{{item.urlRequested}}</td>
			<td>{{item.successStatusCode}}</td>
			<td>{{item.redirectStatusCode}}</td>
			<td>{{item.failureStatusCode}}</td>
			<td>{{item.averageTimeInMicro}}</td>
		</tr>
	</table>
</div>

<div style="width: 50%; margin-left: auto; margin-right: auto;">
	<button class="btn-primary btn-lg" style="float: left"
		ng-click="loadPreLogs()">Previous</button>
	<button class="btn-primary btn-lg" style="float: right"
		ng-click="loadNextLogs()">Next</button>
</div>
<div>

	<ul class="pagination pagination-lg">
 		<li><a ng-click="gotoPage(-6);"><<</a></li>
		<li><a ng-click="gotoPage(-6);"><</a></li>
		<li><a ng-show="visiblePageNumber(-6)" ng-click="gotoPage(-6);">{{pageNumber-5}}</a></li>
		<li><a ng-show="visiblePageNumber(-5)" ng-click="gotoPage(-5);">{{pageNumber-4}}</a></li>
		<li><a ng-show="visiblePageNumber(-4)" ng-click="gotoPage(-4);">{{pageNumber-3}}</a></li>
		<li><a ng-show="visiblePageNumber(-3)" ng-click="gotoPage(-3);">{{pageNumber-2}}</a></li>
		<li><a ng-show="visiblePageNumber(-2)" ng-click="gotoPage(-2);">{{pageNumber-1}}</a></li>
		<li><a ng-show="visiblePageNumber(-1)" ng-click="gotoPage(-1);">{{pageNumber}}</a></li>
		<li><a ng-show="visiblePageNumber(0)" class="active">{{pageNumber+1}}</a></li>
		<li><a ng-show="visiblePageNumber(1)" ng-click="gotoPage(1);">{{pageNumber+2}}</a></li>
		<li><a ng-show="visiblePageNumber(2)" ng-click="gotoPage(2);">{{pageNumber+3}}</a></li>
		<li><a ng-show="visiblePageNumber(3)" ng-click="gotoPage(3);">{{pageNumber+4}}</a></li>
		<li><a ng-show="visiblePageNumber(4)" ng-click="gotoPage(4);">{{pageNumber+5}}</a></li>
		<li><a ng-show="visiblePageNumber(5)" ng-click="gotoPage(5);">{{pageNumber+6}}</a></li>
		<li><a ng-show="visiblePageNumber(6)" ng-click="gotoPage(6);">{{pageNumber+7}}</a></li>
		<li><a ng-click="gotoPage(-6);">></a></li>
		<li><a ng-click="gotoPage(-6);">>></a></li>
	
	</ul>
</div>

