package test;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import util.CollectionUtil;

public class InetAddressTest {
	public static void main(String args[]){
		try {
			Enumeration<NetworkInterface> interFaceListEnum = NetworkInterface.getNetworkInterfaces();
			if(interFaceListEnum == null){
				System.out.println(" no interface found!");
			}else{
				int  i = 1;
				while(interFaceListEnum.hasMoreElements()){
					System.out.println("INTERFACE :" + (i++));
					NetworkInterface iFaceInterface = interFaceListEnum.nextElement();
					System.out.println("interface DisplayName :" + iFaceInterface.getDisplayName() + " ;interface name :" + iFaceInterface.getName());
					Enumeration<InetAddress> addressList = iFaceInterface.getInetAddresses();
					if(addressList !=null){
						if(!addressList.hasMoreElements()){
							System.out.println("no addres found!");
						}else{
							while(addressList.hasMoreElements()){
								InetAddress addrss = addressList.nextElement();
								System.out.println("Address " + (addrss instanceof Inet4Address ? "(V4)" :(addrss instanceof Inet6Address ? "(V6)" : "?")));
								System.out.println("host name :" + addrss.getHostName() + " host address :" + addrss.getHostAddress());
							}
						}
						
					}
					System.out.println("*******************************************************");
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
			System.out.println("error get NetWork Interface :" + e.getMessage());
		}
		
		for(String host : args){
			try{
				System.out.println(host + " £º");
				InetAddress[] addressList = InetAddress.getAllByName(host);
				for(InetAddress address : addressList){
					System.out.println("host name :" + address.getHostName() + " host address :" + address.getHostAddress());
				}
			}catch(UnknownHostException e){
				System.out.println();
			}
		}
	}
}
