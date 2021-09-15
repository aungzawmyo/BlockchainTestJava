import static org.junit.Assert.assertTrue;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.Test;

public class BlockChainTest {
	  public static void main(String args[]) {

	   		 showTime();
//	    	List<Block> blockchain = new ArrayList<>();
//	    	int prefix = 4;
//	    	String prefixString = new String(new char[prefix]).replace('\0', '0');
//	    	 Block newBlock = new Block(
//	   		      "The is a New Block.", 
//	   		      "0035ea28e7373f08d81b387a758c4b9bac7003ed048f4ca1238bd132146020e9",
//	   		      new Date().getTime());
//	   		    newBlock.mineBlock(prefix);
//	   		  //  assertTrue(newBlock.getHash().substring(0, prefix).equals(prefixString));
//	   		    blockchain.add(newBlock);
//	   		    System.out.println(newBlock.toString()); 
//	   		    int Nounce = newBlock.getNonce();
//	   		    System.out.println("Nounce for prefix"+prefix+"::__"+Nounce);
//	   		 System.out.println(new Date().getTime());

	    	testHashLong(); 
	    	showTime();
	   		 System.exit(1);
			   
	    }
	    public  static void testHashLong() {
//	        byte[] b = ("Ko Ko pays 30 to Bo Bo\n"
//	        		+ "9f79124\n"
//	        		+ "43").getBytes(StandardCharsets.US_ASCII);
//	    	String dataToHash = previousHash 
//	    	          + Long.toString(timeStamp) 
//	    	          + Integer.toString(nonce) 
//	    	          + data;
	    	byte[] b=  ("0035ea28e7373f08d81b387a758c4b9bac7003ed048f4ca1238bd132146020e91631316955733159626The is a New Block.").getBytes(StandardCharsets.UTF_8);
	        //byte[] expected = Bytes.parseHex("60497604d2f6b4df42cea5efb8956f587f81a4ad66fa1b65d9e085224d255036").array();
//
//	        System.out.println("bytes  "+b[0]);
//	        System.out.println("bytes  "+b[1]);
//	        System.out.println("bytes  "+b[2]);
//	        System.out.println("bytes  "+b[3]);
	      //  System.out.println("output _ "+bytesToHex(Sha256.hash(b)));
	    }
	  	static void showTime() {
	  		Instant instant = Instant.now();
	  		DateTimeFormatter formatter =
	  			    DateTimeFormatter.ofLocalizedDateTime( FormatStyle.FULL )
	  			                     .withLocale( Locale.UK )
	  			                     .withZone( ZoneId.systemDefault() );
	  		String output = formatter.format( instant );
	  		System.out.println(output) ; 
	  	}
	  	private static String bytesToHex(byte[] hash) {
		    StringBuilder hexString = new StringBuilder(2 * hash.length);
		    for (int i = 0; i < hash.length; i++) {
		        String hex = Integer.toHexString(0xff & hash[i]);
		        if(hex.length() == 1) {
		            hexString.append('0');
		        }
		        hexString.append(hex);
		    }
		    return hexString.toString();
		}
//	  @Test
//		public void givenBlockchain_whenNewBlockAdded_thenSuccess() {
//		    Block newBlock = new Block(
//		      "The is a New Block.", 
//		      blockchain.get(blockchain.size() - 1).getHash(),
//		      new Date().getTime());
//		    newBlock.mineBlock(prefix);
//		    assertTrue(newBlock.getHash().substring(0, prefix).equals(prefixString));
//		    blockchain.add(newBlock);
//		}
//		@Test
//		public void givenBlockchain_whenValidated_thenSuccess() {
//		    boolean flag = true;
//		    for (int i = 0; i < blockchain.size(); i++) {
//		        String previousHash = i==0 ? "0" : blockchain.get(i - 1).getHash();
//		        flag = blockchain.get(i).getHash().equals(blockchain.get(i).calculateBlockHash())
//		          && previousHash.equals(blockchain.get(i).getPreviousHash())
//		          && blockchain.get(i).getHash().substring(0, prefix).equals(prefixString);
//		            if (!flag) break;
//		    }
//		    assertTrue(flag);
//		}
}
