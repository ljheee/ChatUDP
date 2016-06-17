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
			//��������
			 clientSocket =new DatagramSocket();
			InetAddress address = InetAddress.getByName("localhost");
			byte[] receive = new byte[1024];
			byte[] sendData = new byte[1024];
			
			String data = br.readLine();
			sendData =data.getBytes();
			//����һ�����ݰ������͵�address��ָ���˿�
			DatagramPacket dp = new DatagramPacket(sendData, sendData.length,address,8899);
			clientSocket.send(dp);
			
			//��������
			DatagramPacket dp1 = new DatagramPacket(receive, receive.length);
			
			clientSocket.receive(dp1);//�������ݣ��ŵ�dp1���ݰ�
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
