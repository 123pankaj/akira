package com.akira.in.util;

import java.util.HashMap;
import java.util.Map;

public class Constant {
	public static Map<String,String> apacheDefaultSettings =  new HashMap<String,String>();
	static {
		apacheDefaultSettings.put("%a","RemoteIp");
		apacheDefaultSettings.put("%A","LocalIPAddress");
		apacheDefaultSettings.put("%B","ResponseByteWithZero");
		apacheDefaultSettings.put("%b","ResponseByte");
		apacheDefaultSettings.put("%D","ResponseTimeMicroSecond");
		apacheDefaultSettings.put("%h","RemoteHostName");
		apacheDefaultSettings.put("%H","RequestProtocol");
		apacheDefaultSettings.put("%k","NoOfKeepAliveRequestOnConnection");
		apacheDefaultSettings.put("%l","RemoteLogName");
		apacheDefaultSettings.put("%m","RequestMethod");
		apacheDefaultSettings.put("%p","CanonicalPort");
		apacheDefaultSettings.put("%P","ProcessIdChild");
		apacheDefaultSettings.put("%q","QueryString");
		apacheDefaultSettings.put("%r","RequestFirstLine");
		apacheDefaultSettings.put("%s","Status");
		apacheDefaultSettings.put("%>s","FinalStatus");
		apacheDefaultSettings.put("%t","TimeOfRequest");
		apacheDefaultSettings.put("%T","TimeSpentInRequest");
		apacheDefaultSettings.put("%r","RequestFirstLine");
		apacheDefaultSettings.put("%u","RemoteUser");
		apacheDefaultSettings.put("%U","URLPathRequested");
		apacheDefaultSettings.put("%v","ServerName");
		apacheDefaultSettings.put("%V","ServerNameCanonical");
		apacheDefaultSettings.put("%X","ConnectionStatus");
		apacheDefaultSettings.put("%O","BytesSent");
		apacheDefaultSettings.put("%I","BytesReceived");
		
	}
	public static final String percentage = "%";
	public static final String AUI_FORMAT="%{%d-%m-%y:%H:%M:%S}t %v:%p %h %m %U%q %>s %O %D %P \"%{Referer}i\" \"%{User-Agent}i\"";

}
