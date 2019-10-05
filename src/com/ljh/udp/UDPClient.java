package com.ljh.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
/**
 * ��server����һ��������һ�������ݰ����͹رա�
 * @author ljheee
 * https://github.com/ljheee/ChatUDP
 *
 */
public class UDPClient {
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket clientSocket = null;
		try {
			//invia dati
			clientSocket =new DatagramSocket();
			InetAddress address = InetAddress.getByName("localhost");
			byte[] receive = new byte[1024];
			byte[] sendData = new byte[1024];
			
			System.out.println("UDP client online");
			
			
			while(true) {
				
			String data = br.readLine();
			sendData =data.getBytes();
			//crea un pacchetto e lo invia alla porta specificata
			DatagramPacket dp = new DatagramPacket(sendData, sendData.length,address,8899);
			clientSocket.send(dp);
			
			// riceve i dati
			DatagramPacket dp1 = new DatagramPacket(receive, receive.length);
			
			clientSocket.receive(dp1);//prende i dati
			String data1 = new String(dp1.getData());
			System.out.println("Client: "+data1);
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{clientSocket.close();}
		
	}
	
}
