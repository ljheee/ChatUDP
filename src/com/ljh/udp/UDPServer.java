package com.ljh.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
/**
 * ѭ�� �����˿�
 * ���յ�һ������ӡ������յ������ݣ������ط���һ����Ϣ
 * @author ljheee
 * https://github.com/ljheee/ChatUDP
 *
 */
public class UDPServer {
	
	public static void main(String[] args) {
		DatagramSocket serSocket =null;
		try {
			serSocket = new DatagramSocket(8899);//���조�ʾ֡�
			
			byte[] receive = new byte[1024];
			byte[] sendData = new byte[1024];
			
			while(true){
				//����һ�����ݰ�������û������--�൱�ڡ����ŷ⡱��׼���������ݣ�
				DatagramPacket dp = new DatagramPacket(receive, receive.length);
				
				serSocket.receive(dp);//�������ݣ��ŵ�dp���ݰ��������յ������ݷ�װ�������ŷ⡱��
				String data = new String(dp.getData());
				System.out.println("Server's receive:"+data);
				
				//��������
				InetAddress address = dp.getAddress();
				int port = dp.getPort();
				
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String data1 = br.readLine();//�ӿ���̨--��ȡһ�д�������
				sendData = data1.getBytes();
				
				//����һ����DatagramPacket���ŷ������װ��  �������ݡ����ݳ����Լ���������Ϣ
				DatagramPacket dp1 = new DatagramPacket(sendData, sendData.length,address,port);
				serSocket.send(dp1);//�������ݱ���dp1,��Ŀ�ĵ�
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
