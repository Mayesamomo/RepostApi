package Utilities;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TokenStore {

	//Map of token (ranodm string) to TokenData (username and expiration time)
	private Map<String, TokenData> tokenMap = new HashMap<>();
	
	//this class is a singleton and should not be instantiated directly!
	private static TokenStore instance = new TokenStore();
	public static TokenStore getInstance(){
		return instance;
	}
	
	//private constructor so people know to use the getInstance() function instead
	private TokenStore(){}
	
	/**
	 * Generates a token for the username, stores that token along with an
	 * expiration time, and then returns the token so clients can store it.
	 */
	public String putToken(String username){
		String token = UUID.randomUUID().toString();
		tokenMap.put(token, new TokenData(username));
		return token;
	}
	
	/**
	 * Returns the username mapped to the username, or null
	 * if the token isn't found or has expired.
	 */
	public String getUsername(String token){
		if(tokenMap.containsKey(token)){
			if(tokenMap.get(token).expirationTime > System.currentTimeMillis()){
				return tokenMap.get(token).username;
			}
			else{
				//the token has expired, delete it
				tokenMap.remove(token);
			}
		}
		return null;
	}
	
	/**
	 * Internal class that holds a username and an expiration time.
	 */
	private static class TokenData{
		String username;
		long expirationTime;
		
		private TokenData(String username){
			this.username = username;
			//15 minutes from now
			expirationTime = System.currentTimeMillis() + 15 * 60 * 1000;
		}
	}
}