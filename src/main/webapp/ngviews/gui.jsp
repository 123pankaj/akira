
<select ng-model="type"  ng-change="bytype()" class="form-control">
	<option value="status">status</option>
	<option value ="responsetime">Response time</option>
</select>
<div class="col-md-8">  
    <canvas tc-chartjs-bar chart-options="options" chart-data="data" auto-legend></canvas>

</div>  
<<<<<<< Updated upstream
=======
<<<<<<< HEAD

<div class="col-md-2">
<form role="form">
		<div class="form-group">
			<input class="form-control" id="searchinput" type="search" placeholder="Search..." />
=======
>>>>>>> Stashed changes
<div >
<form role="form" class="pull-right col-md-3">
		<div>
			<input class="form-control" ng-model="searchurl" placeholder="Search..." />
		
<<<<<<< Updated upstream
=======
>>>>>>> 94475972f17eb574b6ebc4b93f28ef91c97462b6
>>>>>>> Stashed changes
		</div>
		<div class="pre-scrollable">
		<table id="searchlist" class="table table-hover ">
			<tr ng-repeat="item in distinctUrl|filter:searchurl"  ng-click="loadUrlData(item)"><td>{{item}}</td></tr>
</table>
</div>
	</form>
</div>