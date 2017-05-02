package util;

import java.util.List;


public class CollectionUtil {
	
	
	public static boolean isEmptyList(List<Object> list){
		if(list == null || list.size()==0){
			return true;
		}
		return false;
	}
	
	public static boolean isStringEmpty(String string){
		return (null == string ? true : (string.length() == 0 ? true : false));
	}
	
	public static boolean isArrayEmpty(Object[] array){
		if(array == null){
			return true;
		}else{
			if(array.length == 0 || array[0] == null){
				return true;
			}else{
				return false;
			}
		}
	}
}
