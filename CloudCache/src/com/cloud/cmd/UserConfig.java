package com.cloud.cmd;

import java.util.Vector;

/**
 * Created by dpc on 12/7/14.
 */
public class UserConfig {
    public UserConfig(){
        redisNodes = new Vector<RedisNode>();
    }
    public UserConfig(String userName,int memSize){
        this.userName=userName;
        this.memSize=memSize;
        redisNodes = new Vector<RedisNode>();
    }
    public void addRedisNode(String redisIP,String dockerID,String redisID){
        redisNodes.add(new RedisNode(redisIP,dockerID,redisID));
    }
    public void addRedisNode(String redisIP,String dockerID){
        //RedisNode redisNode = new RedisNode(redisIP,dockerID);
        redisNodes.add(new RedisNode(redisIP,dockerID));
    }

    public int getNumOfNodes() {
        return numOfNodes;
    }

    public void setNumOfNodes(int numOfNodes) {
        this.numOfNodes = numOfNodes;
    }

    public int getMemSize() {
        return memSize;
    }

    public void setMemSize(int memSize) {
        this.memSize = memSize;
    }

    public Vector<RedisNode> getRedisNodes() {
        return redisNodes;
    }


    public void setRedisNodes(Vector<RedisNode> redisNodes) {
        this.redisNodes = redisNodes;
    }

    public int RedisNodeIndex(String IP){
        for(int i=0;i<redisNodes.size();i++)
        {
            if(IP.contains(redisNodes.get(i).getRedisIP()))
                return i;
        }
        return -1;
    }

    public String ipToDockerID(String ip){
        for(int i=0;i<redisNodes.size();i++)
        {
            RedisNode redisNode = redisNodes.get(i);
            if(ip.contains(redisNode.getRedisIP()))
                return redisNode.getDockerID();
        }
        return "";
    }

    public String ipToRedisID(String ip){
        for(int i=0;i<redisNodes.size();i++)
        {
            RedisNode redisNode = redisNodes.get(i);
            if(ip.contains(redisNode.getRedisIP()))
                return redisNode.getRedisID();
        }
        return "";
    }
    private String userName;
    private int memSize;
    private int numOfNodes;
    private Vector<RedisNode> redisNodes;
}
