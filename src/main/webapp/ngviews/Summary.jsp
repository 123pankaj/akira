
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
	


<div>

	<ul class="pagination pagination-lg">
 		
		<li ng-show="pageExists('<')"><a ng-click="loadPreLogs()"><</a></li>
		<li ng-show="pageExists(pn[0])"><a ng-click="loadPage(pn[0])">{{pn[0]}}</a></li>
		<li ng-show="pageExists(pn[1])"><a ng-click="loadPage(pn[1])">{{pn[1]}}</a></li>
		<li ng-show="pageExists(pn[2])"><a ng-click="loadPage(pn[2])">{{pn[2]}}</a></li>
		<li ng-show="pageExists(pn[3])"><a ng-click="loadPage(pn[3])">{{pn[3]}}</a></li>
		<li ng-show="pageExists(pn[4])"><a ng-click="loadPage(pn[4])">{{pn[4]}}</a></li>
		<li ng-show="pageExists(pn[5])"><a ng-click="loadPage(pn[5])">{{pn[5]}}</a></li>
		<li ng-show="pageExists(pn[6])"><a ng-click="loadPage(pn[6])">{{pn[6]}}</a></li>
		<li ng-show="pageExists('>')"><a ng-click="loadNextLogs()">></a></li>
		
	
	</ul>
</div>

</div>


