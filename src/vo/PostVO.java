package vo;

public class PostVO {
	private int postNumber;
	private String senderID;
	private String addresseeID;
	private String sendDate;
	private String postTitle;
	private String postContents;
	private boolean asmCheck;
	
	public int getPostNumber() {
		return postNumber;
	}
	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}
	public String getSenderID() {
		return senderID;
	}
	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}
	public String getAddresseeID() {
		return addresseeID;
	}
	public void setAddresseeID(String addresseeID) {
		this.addresseeID = addresseeID;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public String getPostContents() {
		return postContents;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public void setPostContents(String postContents) {
		this.postContents = postContents;
	}
	
	public boolean isAsmCheck() {
		return asmCheck;
	}
	public void setAsmCheck(boolean asmCheck) {
		this.asmCheck = asmCheck;
	}
	
	
}
