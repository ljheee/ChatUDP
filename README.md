# ChatUDP
A chat used UDP[java],newer,蒋义铭
2016.6.17
UDP 单播。
UDP通信，不存在所谓的“客户端-服务器”，通信双方地位一样。都需要DatagramSocket和DatagramPacket

DatagramSocket---相当于“邮局”，可以包装一个信件发出去；也可以准备一个空信封[DatagramPacket]准备接收信件。