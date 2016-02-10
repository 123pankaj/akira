</style>
<div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper" >
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                       Auto Scale Groups
                </li>
                <li ng-if="ScaleGroup" ng-repeat="groupName in ScaleGroup" ng-model="ScaleGroup" >
                
                    <a ng-click="">{{groupName}}</a>
                </li>
                 <li ng-if="!ScaleGroup" class="text-center">
                 	<img src="js/loader.gif">
                 </li>
                
            </ul>
        </div>
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h2>Detail Information of Auto Scale Group</h2>
                        <p>Name: {{detail.name}}</p>
                        <p>IPs: {{detail.iplist}}</p>
                        <p>AvailabilityZones: {{detail.availabilityzones}}</p>
                        <p>LaunchConfigurationName: {{detail.launchconfigurationname}} </p>
                        <p>LoadBalancerNames: {{detail.name}}</p>
                        <p>MinSize: {{detail.minsize}}</p>
                        <p>MaxSize: {{detail.maxsize}}</p>
                        <p>DesiredCapacity: {{detail.desiredcapacity}}</p>
                        <p>
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>