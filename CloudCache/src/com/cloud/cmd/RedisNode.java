package com.cloud.cmd;

/**
 * Created by dpc on 12/7/14.
 */
public class RedisNode {
    public RedisNode(){

    }
    public RedisNode(String redisIP,String dockerID,String redisID){
        this.redisIP=redisIP;
        this.dockerID=dockerID;
        this.redisID=redisID;
    }
    public RedisNode(String redisIP,String dockerID){
        this.redisIP=redisIP;
        this.dockerID=dockerID;
        this.redisID=" ";
    }
    public String getRedisID() {
        return redisID;
    }

    public void setRedisID(String redisID) {
        this.redisID = redisID;
    }

    public String getDockerID() {

        return dockerID;
    }

    public void setDockerID(String dockerID) {
        this.dockerID = dockerID;
    }

    public String getRedisIP() {

        return redisIP;
    }

    public void setRedisIP(String redisIP) {
        this.redisIP = redisIP;
    }

    private String redisIP;
    private String dockerID;
    private String redisID;
}
