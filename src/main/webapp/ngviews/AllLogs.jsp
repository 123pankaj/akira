	<div>
	<div class="controls form-inline" >
	
	<select ng-model="date" ng-change="byDate()" class="form-control" >
	<option ng-repeat="day in week">{{day}}</option>
	</select>
	
	
	<select class="form-control"  ng-model="selectedtable">
		<option value="logs">All Logs</option>
		<option value="endpoint" >End point</option>
	</select>
	

	<select ng-model="pageSize" ng-change="changeSize()"  class="form-control" >
	<option ng-repeat="size in pageSizes">{{size}}</option>	
	</select>

	</div>
		<table class="table table-hover table-striped" id="logs">
  		<tr class="row">
   		 	<th ng-click="sortBy('id')">Id</th>
   		 	<th ng-click="sortBy('Endpoint')">End Point Ip</th>
   		 	<th ng-click="sortBy('RemoteHostName')">Remote Ip</th>
   		 	<th ng-click="sortBy('RequestMethod')">Request Method</th>
   		 	<th ng-click="sortBy('URLRequested')">URL Requested</th>
   		 	<th ng-click="sortBy('statusCode')">Status Code</th>
   		 	<th ng-click="sortBy('byteSent')">Byte Sent</th>
   		 	<th ng-click="sortBy('TimeInMicro')">Response Time</th>
   		 	<th ng-click="sortBy('ProcessId')">Process Id</th>
   		 	<th ng-click="sortBy('ReferHead')">Refer Head</th>
   		 	<th ng-click="sortBy('userAgent')">User Agent</th>
  		</tr>
  		<tr ng-repeat="item in LogArray" class="row">
    		<td>{{item.id}}</td>
    		<td>{{item.endpoint}}</td>
    		<td>{{item.remoteHostName}}</td>
    		<td>{{item.requestMethod}}</td>
    		<td>{{item.urlRequested}}</td>
    		<td>{{item.statusCode}}</td>
    		<td>{{item.byteSent}}</td>
    		<td>{{item.timeInMicro}}</td>
    		<td>{{item.processId}}</td>
    		<td>{{item.referHead}}</td>
    		<td>{{item.userAgent}}</td>
    	</tr>
	</table>
	</div>
	
	<div style="width:50%;margin-left:auto;margin-right:auto;" >
	<button class="btn-primary btn-lg" style="float:left"  ng-click="loadPreLogs()">Previous</button>
	<button class="btn-primary btn-lg" style="float:right"  ng-click="loadNextLogs()">Next</button>
	</div>
	<div>
	<ul class="pagination pagination-lg">
  <li><a ng-show="visiblePageNumber(-2)" ng-click="gotoPage(-2);">{{pageNumber -1}}</a></li>
  <li><a ng-show="visiblePageNumber(-1)" ng-click="gotoPage(-1);">{{pageNumber }}</a></li>
  <li><a ng-show="visiblePageNumber(0)"  class="active">{{pageNumber+1}}</a></li>
  <li><a ng-show="visiblePageNumber(1)"  ng-click="gotoPage(1);">{{pageNumber +2}}</a></li>
  <li><a ng-show="visiblePageNumber(2)"  ng-click="gotoPage(2);">{{pageNumber +3}}</a></li>
</ul>
	</div>
	
	
	<div id="example"></div>
	