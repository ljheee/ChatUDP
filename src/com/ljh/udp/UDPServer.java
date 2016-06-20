package com.ljh.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
/**
 * 循环 监听端口
 * 接收到一个，打印输出接收到的内容，并返回发送一个消息
 * @author ljheee
 * https://github.com/ljheee/ChatUDP
 *
 */
public class UDPServer {
	
	public static void main(String[] args) {
		DatagramSocket serSocket =null;
		try {
			serSocket = new DatagramSocket(8899);//构造“邮局”
			
			byte[] receive = new byte[1024];
			byte[] sendData = new byte[1024];
			
			while(true){
				//构建一个数据包；里面没有数据--相当于“空信封”（准备接收数据）
				DatagramPacket dp = new DatagramPacket(receive, receive.length);
				
				serSocket.receive(dp);//接收数据，放到dp数据包，即把收到的数据封装到“空信封”里
				String data = new String(dp.getData());
				System.out.println("Server's receive:"+data);
				
				//发送数据
				InetAddress address = dp.getAddress();
				int port = dp.getPort();
				
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String data1 = br.readLine();//从控制台--读取一行待发数据
				sendData = data1.getBytes();
				
				//构造一封信DatagramPacket，信封里面封装了  待发数据、数据长、以及接收者信息
				DatagramPacket dp1 = new DatagramPacket(sendData, sendData.length,address,port);
				serSocket.send(dp1);//发送数据报文dp1,到目的地
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
