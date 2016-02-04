

<div class="col-md-8">  
    <canvas tc-chartjs-bar chart-options="options" chart-data="data" auto-legend></canvas>

</div>  
<div class="col-md-2">
<form role="form">
		<div class="form-group">
			<input class="form-control" id="searchinput" type="search" placeholder="Search..." />
		</div>
		<div id="searchlist" class="list-group pre-scrollable">
			<a ng-repeat="item in distinctUrl" class="list-group-item" ng-click="loadUrlData(item)">{{item}}</a>
</div>
	</form>
</div>