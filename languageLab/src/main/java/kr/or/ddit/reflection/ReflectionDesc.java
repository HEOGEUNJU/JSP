package kr.or.ddit.reflection;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import kr.or.ddit.reflect.ReflectionTest;
import kr.or.ddit.vo.MemberVO;

/**
 * Reflection (java.lang.reflect)
 * 	: 객체의 타입, 객체의 속성(상태, 행동) 들을 역으로 추적하는 작업.
 *    프레임워크를 이해하기 위해 연습해본 것이고 개념 숙지가 매우 중요함.\
 *    붕어빵 틀은 없는데 붕어빵만 가지고 있을 때 역추적하기 위해 사용
 */
public class ReflectionDesc {
	public static void main(String[] args) {
		Object dataObj = ReflectionTest.getObject();
		System.out.println(dataObj);
		Class<?> objType = dataObj.getClass();
		System.out.println(objType.getName());

		Field[] fields = objType.getDeclaredFields();	
//		Arrays.stream(fields)
//			  .forEach(System.out::println);
		Method[] methods = objType.getDeclaredMethods();
//		Arrays.stream(methods)
//		  	  .forEach(System.out::println);
		
		try {
			Object newObj = objType.newInstance();
			Arrays.stream(fields)
				  .forEach(fld->{
//					  fld.setAccessible(true);
					  String fildName = fld.getName(); //mem_id, getMem_id, setMem_id
					  try {
						PropertyDescriptor pd = new PropertyDescriptor(fildName, objType);
						Method getter = pd.getReadMethod(); //getter
						Method setter = pd.getWriteMethod();//setter
						//getter
//						Object fldValue = fld.get(dataObj);
						Object fldValue = getter.invoke(dataObj);
						//setter
//						fld.set(newObj, fldValue);
						setter.invoke(newObj, fldValue);
						
					} catch (IllegalArgumentException | IllegalAccessException | 
							IntrospectionException | InvocationTargetException e) {
						e.printStackTrace();
					}
				  });
			System.out.println(newObj);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
