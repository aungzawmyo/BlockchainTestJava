import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

import org.apache.log4j.Logger; 
import Util.Log; 

public class Block {
    private String hash;
    private String previousHash;
    private String data;
    public String getPreviousHash() {
		return previousHash;
	}

	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getNonce() {
		return nonce;
	}

	public void setNonce(int nonce) {
		this.nonce = nonce;
	}

	public static Log getLog() {
		return log;
	}

	public static void setLog(Log log) {
		Block.log = log;
	}

	public static Logger getLogger() {
		return logger;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	private long timeStamp;
    private int nonce= 0;
 
	final static Logger logger = Logger.getLogger(Main.class);
	static Log log=null;
    public Block(String data, String previousHash, long timeStamp) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = timeStamp;
        this.hash = calculateBlockHash();
    }
  
    public String mineBlock(int prefix) {
        String prefixString = new String(new char[prefix]).replace('\0', '0');
        while (!hash.substring(0, prefix).equals(prefixString)) {
            nonce++;
       //     System.out.println("Hash time "+nonce +" ::__ "+hash.substring(0, 10));
            hash = calculateBlockHash();
        }
        return hash;
    }
    public String calculateBlockHash() {
        String dataToHash = previousHash 
          + Long.toString(timeStamp) 
          + Integer.toString(nonce) 
          + data;
        System.out.println("dataHash __ "+dataToHash);
        MessageDigest digest = null;
        byte[] bytes = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
             
            
            bytes = digest.digest(dataToHash.getBytes(StandardCharsets.UTF_8));
        } catch (Exception ex) {
            log.info(ex.getMessage());
        }
        StringBuffer buffer = new StringBuffer();
        for (byte b : bytes) {
            buffer.append(String.format("%02x", b));
        }
      //System.out.println("Hash time "+nonce +" ::__ "+buffer.toString().substring(0, 10));
        return buffer.toString();
    }
    // standard getters and setters

	@Override
	public String toString() {
		return "Block [hash=" + hash + ", previousHash=" + previousHash + ", data=" + data + ", timeStamp=" + timeStamp
				+ ", nonce=" + nonce + "]";
	}

	/**
	 * @return
	 */
	public String getHash() {
		// TODO Auto-generated method stub
		return null;
	}
}