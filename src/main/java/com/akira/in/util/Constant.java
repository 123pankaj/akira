package com.akira.in.util;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class Constant {
	public static Map<String, String> apacheDefaultSettings = new HashMap<String, String>();
	public static Map<String, String> formaterHelper = new HashMap<String, String>();
	static {
		apacheDefaultSettings.put("%a", "RemoteIp");
		apacheDefaultSettings.put("%A", "LocalIPAddress");
		apacheDefaultSettings.put("%B", "ResponseByteWithZero");
		apacheDefaultSettings.put("%b", "ResponseByte");
		apacheDefaultSettings.put("%D", "ResponseTimeMicroSecond");
		apacheDefaultSettings.put("%h", "RemoteHostName");
		apacheDefaultSettings.put("%H", "RequestProtocol");
		apacheDefaultSettings.put("%k", "NoOfKeepAliveRequestOnConnection");
		apacheDefaultSettings.put("%l", "RemoteLogName");
		apacheDefaultSettings.put("%m", "RequestMethod");
		apacheDefaultSettings.put("%p", "CanonicalPort");
		apacheDefaultSettings.put("%P", "ProcessIdChild");
		apacheDefaultSettings.put("%q", "QueryString");
		apacheDefaultSettings.put("%r", "RequestFirstLine");
		apacheDefaultSettings.put("%s", "Status");
		apacheDefaultSettings.put("%>s", "FinalStatus");
		apacheDefaultSettings.put("%t", "TimeOfRequest");
		apacheDefaultSettings.put("%T", "TimeSpentInRequest");
		apacheDefaultSettings.put("%r", "RequestFirstLine");
		apacheDefaultSettings.put("%u", "RemoteUser");
		apacheDefaultSettings.put("%U", "URLPathRequested");
		apacheDefaultSettings.put("%v", "ServerName");
		apacheDefaultSettings.put("%V", "ServerNameCanonical");
		apacheDefaultSettings.put("%X", "ConnectionStatus");
		apacheDefaultSettings.put("%O", "BytesSent");
		apacheDefaultSettings.put("%I", "BytesReceived");
		// Some custom made
		apacheDefaultSettings.put("%uai", "User-Agent");
		apacheDefaultSettings.put("%rei", "Referer");

		formaterHelper.put("{User-Agent}", "uai");
		formaterHelper.put("{Referer}", "rei");

	}
	/**
	 * <pre>
	 * Trying to find 3 group with braces
	 * In Group 0 - Whole string will be there - "%{abc}t"
	 * In Group 1 - Only inside text - {abc}
	 * In Group 2 - main formatter value - t
	 * </pre>
	 */
	public static final String PatternForBraces = "\"%(\\{.*?\\})(\\w{1})\"";
	/**
	 * <pre>
	 * Trying to find 3 group , to find out the termination character
	 * In Group 0 - Whole string will be there - ">s"
	 * In Group 1 - Only inside text - >s ('>' is optional)
	 * In Group 2 - main formatter value - ' ' (space)
	 * Another example could be %v:
	 * Here the termination character is ':' which will come in group 2.
	 * </pre>
	 */
	public static final String PattrenForFields = "^(>?[a-zA-Z]*)(\\W)?$";

	
	public static final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy:H:m:s");
	public static final String BLANK_SPACE = "";
	public static final String NEXT_LINE = "\n";
	public static final String Percentage = "%";
	public static final String AUI_FORMAT = "\"%{%d-%m-%y:%H:%M:%S}t\" %v:%p %h %m %U %q %>s %O %D %P \"%{Referer}i\" \"%{User-Agent}i\"";

}
