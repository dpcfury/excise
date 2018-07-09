package com.dpc.pojo;

public class UserPush {

	/**
	 * @param args
	 */
	private int id;
	private String baiduUserId;
	private long channelId;
	
	public UserPush(){
		super();
	}
	
	public UserPush(int id,String baiduUserId,long channelId){
		this.id=id;
		this.baiduUserId=baiduUserId;
		this.channelId=channelId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBaiduUserId() {
		return baiduUserId;
	}
	public void setBaiduUserId(String baiduUserId) {
		this.baiduUserId = baiduUserId;
	}
	public long getChannelId() {
		return channelId;
	}
	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:"+id+" baiduUserId:"+baiduUserId+" channelId:"+channelId	;
	}

}
