package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;


public class TcpUtils {
	
	public static List<String> getAllHostAddress(String host){
		List<String> hostList = new LinkedList<String>();
		if(!CollectionUtil.isStringEmpty(host)){
			InetAddress[] addressList;
			try {
				addressList = InetAddress.getAllByName(host);
				if(!CollectionUtil.isArrayEmpty(addressList)){
					for(InetAddress address : addressList){
						if(address != null){
							hostList.add(address.getHostAddress());
						}
					}
				}
			} catch (UnknownHostException e) {
				System.out.println("未知主机名，请检查主机名是否存在！");
				System.out.println(e.getMessage());
//				e.printStackTrace();
			}
			return hostList;
		}
		return null;
	}
	
	
	public static List<String> getAllHostNames(String host){
		List<String> hostList = new LinkedList<String>();
		if(!CollectionUtil.isStringEmpty(host)){
			InetAddress[] addressList;
			try {
				addressList = InetAddress.getAllByName(host);
				if(!CollectionUtil.isArrayEmpty(addressList)){
					for(InetAddress address : addressList){
						if(address != null){
							hostList.add(address.getHostName());
						}
					}
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			return hostList;
		}
		return null;
	}
}
