package com.ljh.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class UDPServer {
	public static void main(String[] args) {
		DatagramSocket serSocket =null;
		try {
			 serSocket = new DatagramSocket(8899);
			
			byte[] receive = new byte[1024];
			byte[] sendData = new byte[1024];
			
			while(true){
				//����һ�����ݰ�������û�����ݣ�׼���������ݣ�
				DatagramPacket dp = new DatagramPacket(receive, receive.length);
				
				serSocket.receive(dp);//�������ݣ��ŵ�dp���ݰ�
				String data = new String(dp.getData());
				System.out.println("Server's receive:"+data);
				
				//��������
				InetAddress address = dp.getAddress();
				int port = dp.getPort();
				
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String data1 = br.readLine();
				sendData = data1.getBytes();
				DatagramPacket dp1 = new DatagramPacket(sendData, sendData.length,address,port);
				serSocket.send(dp1);//�������ݱ���dp��Ŀ�ĵ�
				
			}
			
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			serSocket.close();
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
