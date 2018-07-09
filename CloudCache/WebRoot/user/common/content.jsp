<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


	<div class="panel panel-primary">
		<div class="panel-heading" style="font-size:24px;">redis-cluster 原理</div>
		<div class=" panel-body">

			<p style="font-size:20px;">Redis的集群实现，内置数据自动分片机制，集群内部将所有的key映射到16384个Slot中，集群中的每个Redis
				Instance负责其中的一部分的Slot的读写。集群客户端连接集群中任一Redis Instance即可发送命令，当Redis
				Instance收到自己不负责的Slot的请求时，会将负责请求Key所在Slot的Redis
				Instance地址返回给客户端，客户端收到后自动将原请求重新发往这个地址，对外部透明。一个Key到底属于哪个Slot由crc16(key)
				% 16384 决定。 关于负载均衡，集群的Redis
				Instance之间可以迁移数据，以Slot为单位，但不是自动的，需要外部命令触发。 关于集群成员管理，集群的节点(Redis
				Instance)和节点之间两两定期交换集群内节点信息并且更新，从发送节点的角度看，这些信息包括：集群内有哪些节点，IP和PORT是什么，节点名字是什么，节点的状态(比如OK，PFAIL，FAIL，后面详述)是什么，包括节点角色(master
				或者 slave)等。 关于可用性，集群由N组主从Redis Instance组成。主可以没有从，但是没有从
				意味着主宕机后主负责的Slot读写服务不可用。一个主可以有多个从，主宕机时，某个从会被提升为主，具体哪个从被提升为主，协议类似于Raft，参见这里。如何检测主宕机？Redis
				Cluster采用quorum+心跳的机制。从节点的角度看，节点会定期给其他所有的节点发送Ping，cluster-node-timeout(可配置，秒级)时间内没有收到对方的回复，则单方面认为对端节点宕机，将该节点标为PFAIL状态。通过节点之间交换信息收集到quorum个节点都认为这个节点为PFAIL，则将该节点标记为FAIL，并且将其发送给其他所有节点，其他所有节点收到后立即认为该节点宕机。从这里可以看出，主宕机后，至少cluster-node-timeout时间内该主所负责的Slot的读写服务不可用。

			</p>
		</div>

</div>


<div class="panel panel-info">
		<div class="panel-heading" style="font-size:24px;">redis-cluster 原理</div>
		<div class=" panel-body">

			<p style="font-size:20px;">Redis的集群实现，内置数据自动分片机制，集群内部将所有的key映射到16384个Slot中，集群中的每个Redis
				Instance负责其中的一部分的Slot的读写。集群客户端连接集群中任一Redis Instance即可发送命令，当Redis
				Instance收到自己不负责的Slot的请求时，会将负责请求Key所在Slot的Redis
				Instance地址返回给客户端，客户端收到后自动将原请求重新发往这个地址，对外部透明。一个Key到底属于哪个Slot由crc16(key)
				% 16384 决定。 关于负载均衡，集群的Redis
				Instance之间可以迁移数据，以Slot为单位，但不是自动的，需要外部命令触发。 关于集群成员管理，集群的节点(Redis
				Instance)和节点之间两两定期交换集群内节点信息并且更新，从发送节点的角度看，这些信息包括：集群内有哪些节点，IP和PORT是什么，节点名字是什么，节点的状态(比如OK，PFAIL，FAIL，后面详述)是什么，包括节点角色(master
				或者 slave)等。 关于可用性，集群由N组主从Redis Instance组成。主可以没有从，但是没有从
				意味着主宕机后主负责的Slot读写服务不可用。一个主可以有多个从，主宕机时，某个从会被提升为主，具体哪个从被提升为主，协议类似于Raft，参见这里。如何检测主宕机？Redis
				Cluster采用quorum+心跳的机制。从节点的角度看，节点会定期给其他所有的节点发送Ping，cluster-node-timeout(可配置，秒级)时间内没有收到对方的回复，则单方面认为对端节点宕机，将该节点标为PFAIL状态。通过节点之间交换信息收集到quorum个节点都认为这个节点为PFAIL，则将该节点标记为FAIL，并且将其发送给其他所有节点，其他所有节点收到后立即认为该节点宕机。从这里可以看出，主宕机后，至少cluster-node-timeout时间内该主所负责的Slot的读写服务不可用。

			</p>
		</div>

</div>


<div class="panel panel-danger">
		<div class="panel-heading" style="font-size:24px;">redis-cluster 原理</div>
		<div class=" panel-body">

			<p style="font-size:20px;">Redis的集群实现，内置数据自动分片机制，集群内部将所有的key映射到16384个Slot中，集群中的每个Redis
				Instance负责其中的一部分的Slot的读写。集群客户端连接集群中任一Redis Instance即可发送命令，当Redis
				Instance收到自己不负责的Slot的请求时，会将负责请求Key所在Slot的Redis
				Instance地址返回给客户端，客户端收到后自动将原请求重新发往这个地址，对外部透明。一个Key到底属于哪个Slot由crc16(key)
				% 16384 决定。 关于负载均衡，集群的Redis
				Instance之间可以迁移数据，以Slot为单位，但不是自动的，需要外部命令触发。 关于集群成员管理，集群的节点(Redis
				Instance)和节点之间两两定期交换集群内节点信息并且更新，从发送节点的角度看，这些信息包括：集群内有哪些节点，IP和PORT是什么，节点名字是什么，节点的状态(比如OK，PFAIL，FAIL，后面详述)是什么，包括节点角色(master
				或者 slave)等。 关于可用性，集群由N组主从Redis Instance组成。主可以没有从，但是没有从
				意味着主宕机后主负责的Slot读写服务不可用。一个主可以有多个从，主宕机时，某个从会被提升为主，具体哪个从被提升为主，协议类似于Raft，参见这里。如何检测主宕机？Redis
				Cluster采用quorum+心跳的机制。从节点的角度看，节点会定期给其他所有的节点发送Ping，cluster-node-timeout(可配置，秒级)时间内没有收到对方的回复，则单方面认为对端节点宕机，将该节点标为PFAIL状态。通过节点之间交换信息收集到quorum个节点都认为这个节点为PFAIL，则将该节点标记为FAIL，并且将其发送给其他所有节点，其他所有节点收到后立即认为该节点宕机。从这里可以看出，主宕机后，至少cluster-node-timeout时间内该主所负责的Slot的读写服务不可用。

			</p>
		</div>

</div>

<div class="panel panel-danger">
		<div class="panel-heading" style="font-size:24px;">redis-cluster 原理</div>
		<div class=" panel-body">

			<p style="font-size:20px;">Redis的集群实现，内置数据自动分片机制，集群内部将所有的key映射到16384个Slot中，集群中的每个Redis
				Instance负责其中的一部分的Slot的读写。集群客户端连接集群中任一Redis Instance即可发送命令，当Redis
				Instance收到自己不负责的Slot的请求时，会将负责请求Key所在Slot的Redis
				Instance地址返回给客户端，客户端收到后自动将原请求重新发往这个地址，对外部透明。一个Key到底属于哪个Slot由crc16(key)
				% 16384 决定。 关于负载均衡，集群的Redis
				Instance之间可以迁移数据，以Slot为单位，但不是自动的，需要外部命令触发。 关于集群成员管理，集群的节点(Redis
				Instance)和节点之间两两定期交换集群内节点信息并且更新，从发送节点的角度看，这些信息包括：集群内有哪些节点，IP和PORT是什么，节点名字是什么，节点的状态(比如OK，PFAIL，FAIL，后面详述)是什么，包括节点角色(master
				或者 slave)等。 关于可用性，集群由N组主从Redis Instance组成。主可以没有从，但是没有从
				意味着主宕机后主负责的Slot读写服务不可用。一个主可以有多个从，主宕机时，某个从会被提升为主，具体哪个从被提升为主，协议类似于Raft，参见这里。如何检测主宕机？Redis
				Cluster采用quorum+心跳的机制。从节点的角度看，节点会定期给其他所有的节点发送Ping，cluster-node-timeout(可配置，秒级)时间内没有收到对方的回复，则单方面认为对端节点宕机，将该节点标为PFAIL状态。通过节点之间交换信息收集到quorum个节点都认为这个节点为PFAIL，则将该节点标记为FAIL，并且将其发送给其他所有节点，其他所有节点收到后立即认为该节点宕机。从这里可以看出，主宕机后，至少cluster-node-timeout时间内该主所负责的Slot的读写服务不可用。

			</p>
		</div>

</div>


<div class="panel panel-danger">
		<div class="panel-heading" style="font-size:24px;">redis-cluster 原理</div>
		<div class=" panel-body">

			<p style="font-size:20px;">Redis的集群实现，内置数据自动分片机制，集群内部将所有的key映射到16384个Slot中，集群中的每个Redis
				Instance负责其中的一部分的Slot的读写。集群客户端连接集群中任一Redis Instance即可发送命令，当Redis
				Instance收到自己不负责的Slot的请求时，会将负责请求Key所在Slot的Redis
				Instance地址返回给客户端，客户端收到后自动将原请求重新发往这个地址，对外部透明。一个Key到底属于哪个Slot由crc16(key)
				% 16384 决定。 关于负载均衡，集群的Redis
				Instance之间可以迁移数据，以Slot为单位，但不是自动的，需要外部命令触发。 关于集群成员管理，集群的节点(Redis
				Instance)和节点之间两两定期交换集群内节点信息并且更新，从发送节点的角度看，这些信息包括：集群内有哪些节点，IP和PORT是什么，节点名字是什么，节点的状态(比如OK，PFAIL，FAIL，后面详述)是什么，包括节点角色(master
				或者 slave)等。 关于可用性，集群由N组主从Redis Instance组成。主可以没有从，但是没有从
				意味着主宕机后主负责的Slot读写服务不可用。一个主可以有多个从，主宕机时，某个从会被提升为主，具体哪个从被提升为主，协议类似于Raft，参见这里。如何检测主宕机？Redis
				Cluster采用quorum+心跳的机制。从节点的角度看，节点会定期给其他所有的节点发送Ping，cluster-node-timeout(可配置，秒级)时间内没有收到对方的回复，则单方面认为对端节点宕机，将该节点标为PFAIL状态。通过节点之间交换信息收集到quorum个节点都认为这个节点为PFAIL，则将该节点标记为FAIL，并且将其发送给其他所有节点，其他所有节点收到后立即认为该节点宕机。从这里可以看出，主宕机后，至少cluster-node-timeout时间内该主所负责的Slot的读写服务不可用。

			</p>
		</div>

</div>