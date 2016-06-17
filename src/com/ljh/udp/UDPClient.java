package com.ljh.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class UDPClient {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket clientSocket = null;
		try {
			//发送数据
			 clientSocket =new DatagramSocket();
			InetAddress address = InetAddress.getByName("localhost");
			byte[] receive = new byte[1024];
			byte[] sendData = new byte[1024];
			
			String data = br.readLine();
			sendData =data.getBytes();
			//构建一个数据包，发送到address的指定端口
			DatagramPacket dp = new DatagramPacket(sendData, sendData.length,address,8899);
			clientSocket.send(dp);
			
			//接受数据
			DatagramPacket dp1 = new DatagramPacket(receive, receive.length);
			
			clientSocket.receive(dp1);//接收数据，放到dp1数据包
			String data1 = new String(dp1.getData());
			System.out.println("Client's receive:"+data1);
			
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{clientSocket.close();}
		
		
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
