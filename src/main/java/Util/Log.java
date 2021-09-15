package Util;
 

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.log4j.Logger;


public class Log {
	private static final int MAXLEN = 80;
	private StringBuilder sb = null;
	private String name = null;
	
	static final Logger logger = Logger.getLogger(Log.class);

	public Log() {
		this.sb = new StringBuilder();
		sb.append("=========================START========================="+System.getProperty("line.separator"));
	}
	
	public Log(String methodName) {
		this.name = methodName;
		this.sb = new StringBuilder();
		sb.append("=========================Start of "+this.name+"========================="+System.getProperty("line.separator"));
	}
	
	public void info(String content) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
		int maxLength = (MAXLEN > content.length()) ? content.length() : MAXLEN;
		int curr_pos = 0;
		String output = "";
		while (curr_pos < content.length())
		{
			if (curr_pos == 0) {
				output = String.format("%-19s %-6s %s", dtf.format(now), "INFO", content.substring(curr_pos, maxLength) + System.getProperty("line.separator"));
			} else {
				output = String.format("%26s %s", "", content.substring(curr_pos, maxLength) + System.getProperty("line.separator"));
			}
			
			sb.append(output);
			curr_pos += MAXLEN;
			maxLength += MAXLEN;
			maxLength = (maxLength > content.length()) ? content.length() : maxLength;
		}
		
	}
	
	public void error(Exception e) {
		logger.error(e.getMessage(), e);
		this.error(e.getMessage());
	}
	
	public void error(String content) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		int maxLength = (MAXLEN > content.length()) ? content.length() : MAXLEN;
		int curr_pos = 0;
		String output = "";
		while (curr_pos <= content.length())
		{
			if (curr_pos == 0) {
				output = String.format("%-19s %-6s %s", dtf.format(now), "ERROR", content.substring(curr_pos, maxLength) + System.getProperty("line.separator"));
			} else {
				output = String.format("%26s %s", "", content.substring(curr_pos, maxLength) + System.getProperty("line.separator"));
			}
			sb.append(output);
			curr_pos += MAXLEN;
			maxLength += MAXLEN;
			maxLength = (maxLength > content.length()) ? content.length() : maxLength;
		}
		
	}
	
	public String getlog(){
		sb.append("=========================End of "+this.name+"========================="+System.getProperty("line.separator"));
		return this.sb.toString();
	}
}