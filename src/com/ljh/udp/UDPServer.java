package com.ljh.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
/**
 * 循环 监听端口
 * 接收到一个，打印输出接收到的内容，并返回发送一个消息
 * @author ljheee
 *
 */
public class UDPServer {
	
	public static void main(String[] args) {
		DatagramSocket serSocket =null;
		try {
			serSocket = new DatagramSocket(8899);
			
			byte[] receive = new byte[1024];
			byte[] sendData = new byte[1024];
			
			while(true){
				//构建一个数据包；里面没有数据--相当于“空信封”（准备接收数据）
				DatagramPacket dp = new DatagramPacket(receive, receive.length);
				
				serSocket.receive(dp);//接收数据，放到dp数据包
				String data = new String(dp.getData());
				System.out.println("Server's receive:"+data);
				
				//发送数据
				InetAddress address = dp.getAddress();
				int port = dp.getPort();
				
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String data1 = br.readLine();
				sendData = data1.getBytes();
				DatagramPacket dp1 = new DatagramPacket(sendData, sendData.length,address,port);
				serSocket.send(dp1);//发送数据报文dp到目的地
				dp = null;
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			serSocket.close();
		}
		
		
	}
	
}
