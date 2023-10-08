package project;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class SendOtp {
	
	public static void sendOTP(String message, String number, String apiKey) {
		try {
		String sendId = "FSTSMS";
		String language = "english";
		String route = "p";
		
		message = URLEncoder.encode(message, "UTF-8");	//important step
		
		String myUrl = "https://www.fast2sms.com/dev/bulkV2?authorization=" + apiKey + "&sender_id=" + sendId + "&message=" + message +  "&route=" + route + "&numbers=" + number;
		URL url = new URL(myUrl);
		HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
		
		con.setRequestMethod("GET");
		
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setRequestProperty("cache-control", "no-cache");
		System.out.println("Wait............");
		int responseCode = con.getResponseCode();
		System.out.println("Response Code : " + responseCode);
		
		StringBuffer response = new StringBuffer();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		while(true) {
			String line = br.readLine();
			if(line == null) {
				break;
			}
			response.append(line);
		}
		System.out.println(response);
		
		}
		catch(Exception e) {
			System.out.println();
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Program Started.....");
		OTP otp = new OTP();
		String otpmessage = otp.generateOTP(5);
		System.out.println("Generate OTP : " + otpmessage);
		
		String apiKey = "kOYBEt41ZRNoplxjzwmSHrIa5bfFL0823UGMscDVngTKvCuiJyT8MgOv0icjuS6BGh7KaLIf3FCo2tlE";
		String number = "9817733828";
		
		sendOTP("Hey this message is send by Manik using Java Code. You OTP is " + otpmessage, number, apiKey);
	}

}
