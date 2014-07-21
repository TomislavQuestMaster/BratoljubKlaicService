package integration;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author tdubravcevic
 */
public class InitialFill {

	@Test
	public void happyPath() throws Exception {

		Long scholarId = Long.valueOf(sendPost("register", "{\"name\":\"tomo\",\"password\":\"tomo\"}"));

		Long sessionId = Long.valueOf(sendPost("start", "{\"word\":\"rijec\",\"scholarId\":"+scholarId+"}"));

		sendPost("define", "{\"text\":\"rijec\",\"scholarId\":"+scholarId+",\"sessionId\":"+sessionId+"}");
	}

	// HTTP POST request
	private String sendPost(String method, String body) throws Exception {

		String url = "http://localhost:8080/" + method;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type", "application/json");
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(body);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post body: " + body);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		String result = response.toString();
		System.out.println(result);
		return result;
	}
}
