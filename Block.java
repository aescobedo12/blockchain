package blockchain;
import java.util.Date;
public class Block {
	
	public String hash;
	public String previousHash; 
	private String data; 
	private long time; //milliseconds
	private int nonce; //arbitrary number that can be used once
	
	//default block constructor  
	public Block(String data,String previousHash ) {
		this.data = data;
		this.previousHash = previousHash;
		this.time = new Date().getTime();
		
		this.hash = calculateHash(); //Making sure we do this after we set the other values.
	}
	
	//Calculate new hash based on blocks
	public String calculateHash() {
		String calculatedhash = signature.applySha256( 
				previousHash +
				Long.toString(time) +
				Integer.toString(nonce) + 
				data 
				);
		return calculatedhash;
	}
	
	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); //set difficulty 
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
		}
		System.out.println("Block Mined. : " + hash); // print hashcode for block
	}
}