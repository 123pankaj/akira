<div class="controls form-inline">
<select ng-model="type"  ng-change="bytype()" class="form-control">
	<option value="status">status</option>
	<option value ="responsetime">Response time</option>
</select>
</div>
<div class="col-md-8">  
    <canvas tc-chartjs-line chart-options="options" chart-data="data" auto-legend></canvas>

</div>  


<div >
<form role="form" class="pull-right col-md-3">
		<div>
			<input class="form-control" ng-model="searchurl" placeholder="Search..." />
		

		</div>
		<div class="pre-scrollable">
		<table id="searchlist" class="table table-hover ">
			<tr ng-repeat="item in distinctUrl|filter:searchurl"  class="clickable-row"  ng-click="loadUrlData(item)"><td>{{item}}</td></tr>
</table>
</div>
	</form>
</div>