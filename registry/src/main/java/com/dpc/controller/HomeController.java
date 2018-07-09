package com.dpc.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ice.jni.registry.NoSuchKeyException;
import com.ice.jni.registry.RegDWordValue;
import com.ice.jni.registry.RegStringValue;
import com.ice.jni.registry.Registry;
import com.ice.jni.registry.RegistryException;
import com.ice.jni.registry.RegistryKey;
import com.ice.jni.registry.RegistryValue;

@Controller
public class HomeController {

	public static final String DEFAULT_SUBKEY = "Software\\Microsoft\\Windows\\CurrentVersion\\Policies";

	// 初始化(默认一个HKEY_CURRENT_USER下的key)
	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public ModelAndView show() {

		ModelAndView view = new ModelAndView();
		view.setViewName("main");
		view.addObject("current_key_path",
				Registry.HKEY_CURRENT_USER.getFullName() + "\\"
						+ DEFAULT_SUBKEY);

		// 罗列出基本操作路径下的几个subKey
		List<String> allSubKeys = new ArrayList<String>();
		try {
			RegistryKey key = Registry.HKEY_CURRENT_USER
					.openSubKey(DEFAULT_SUBKEY);
			// System.out.println(key.getName());
			Enumeration em = key.keyElements();
			while (em.hasMoreElements()) {
				allSubKeys.add((String) em.nextElement());// 其中的元素都是strings
				// System.out.println(em.nextElement());
			}
			view.addObject("allSubKeys", allSubKeys);
			key.closeKey();
		} catch (NoSuchKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RegistryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return view;
	}

	// 返回一个key的subKey列表如果没有subKeys了就返回值列表
	@RequestMapping(value = "/getSubKeysOrValues.htm", method = RequestMethod.GET)
	public ModelAndView getSubKeysOrValues(
			@RequestParam("current_key_path") String current_key_path,
			@RequestParam("subKeyName") String subKeyName) {
		ModelAndView mv = new ModelAndView();

		// 1.首先查看该key下面是否还有subkey了
		// 2.没有则查处该key的所有值（包括defaultvalue）
		RegistryKey key;
		try {
			int index = current_key_path.indexOf(DEFAULT_SUBKEY);
			System.out.println(current_key_path.substring(index));
			key = Registry.HKEY_CURRENT_USER.openSubKey(
					current_key_path.substring(index)).openSubKey(subKeyName);
			
			if (key.getNumberSubkeys() <= 0) {
				// System.out.println("没有子目录");
				// 输出所有的值

				mv.setViewName("last");
			} else {
				// 找出所有的子键
				List<String> subKeys = new ArrayList<String>();
				Enumeration em = key.keyElements();
				while (em.hasMoreElements()) {
					subKeys.add((String) em.nextElement());// 其中的元素都是strings
				}
				mv.setViewName("main");
				mv.addObject("allSubKeys", subKeys);

			}
			mv.addObject("current_key_path", key.getFullName());

		} catch (NoSuchKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RegistryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mv;
	}

	// 在指定的一个路径中创建一个新的项
	@RequestMapping(value = "/createKey.htm", method = RequestMethod.GET)
	public ModelAndView createKey(
			@RequestParam("current_key_path") String current_key_path,
			@RequestParam("new_subKey") String keyName) {
		// 目的是在当前的操作路径中创建出一个新的项
		ModelAndView mv = new ModelAndView();

		RegistryKey key;
		int index = current_key_path.indexOf(DEFAULT_SUBKEY);
		try {
			key = Registry.HKEY_CURRENT_USER.openSubKey(current_key_path
					.substring(index));
			key.createSubKey(keyName, "");
			mv.setViewName("redirect:/showSubKeys.htm?current_key_path="
					+ current_key_path);
			key.closeKey();
		} catch (NoSuchKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RegistryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	// 显示一个拥有子键的key下的subkey
	@RequestMapping(value = "/showSubKeys.htm", method = RequestMethod.GET)
	public ModelAndView showSubKeys(
			@RequestParam("current_key_path") String current_key_path) {
		ModelAndView mv = new ModelAndView();
		RegistryKey key;

		int index = current_key_path.indexOf(DEFAULT_SUBKEY);
		try {
			key = Registry.HKEY_CURRENT_USER.openSubKey(current_key_path
					.substring(index));
			List<String> subKeys = new ArrayList<String>();
			Enumeration em = key.keyElements();
			while (em.hasMoreElements()) {
				subKeys.add((String) em.nextElement());// 其中的元素都是strings
			}

			key.closeKey();

			mv.setViewName("main");
			mv.addObject("current_key_path", current_key_path);
			mv.addObject("allSubKeys", subKeys);
		} catch (NoSuchKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RegistryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	// 为某个键新建一个value
	@RequestMapping(value = "/addValue.htm", method = RequestMethod.GET)
	public ModelAndView addValue(@RequestParam("value_type") String value_type,
			@RequestParam("current_key_path") String current_key_path,@RequestParam("valueName") String valueName,
			@RequestParam("value") String value) {
		ModelAndView mv = new ModelAndView();
		RegistryKey key;
		
		int index = current_key_path.indexOf(DEFAULT_SUBKEY);
		try {
			key = Registry.HKEY_CURRENT_USER.createSubKey(
					current_key_path.substring(index), "");
			// 判断值得类型
			if ("REG_SZ".equals(value_type)) {
				RegStringValue val = new RegStringValue(key, valueName);
				val.setData(value);//尚未做重复name控制
				key.setValue(val);
			} else {// 另一种默认是REG_DWORD类型
				RegDWordValue	val=new RegDWordValue(key,valueName);
				val.setData(Integer.parseInt(value));//?没出现类型转换问题
				key.setValue(val);
			}
			key.closeKey();
			
			key =Registry.HKEY_CURRENT_USER.openSubKey(current_key_path.substring(index));
			int count =key.getNumberValues();
			key.closeKey();
			mv.setViewName("addSuccess");
			mv.addObject("current_key_path", current_key_path);
			mv.addObject("addedValueName", valueName);
			mv.addObject("addedValue", value);
			mv.addObject("addedValueType", value_type);
			mv.addObject("current_value_count", count);
			
		} catch (NoSuchKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RegistryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mv;
	}
	
//value operation 显示对value操作的界面
	@RequestMapping(value="/startValueOperation.htm",method=RequestMethod.GET)
	public ModelAndView startValueOperation(String current_key_path,String subKeyName){
		ModelAndView mv =new ModelAndView();
		
		mv.setViewName("valueOperate");
		mv.addObject("current_key_path", current_key_path+"\\"+subKeyName);
		mv.addObject("keyName", subKeyName);
		
		return mv;
	}
	
	//查找一个key的对应的某个valueName的值
	@RequestMapping(value="/getValue.htm",method=RequestMethod.GET)
	public ModelAndView getValue(String current_key_path,String valueName){
		ModelAndView mv =new ModelAndView();
		RegistryKey key;
		String keyName=null;
		int index = current_key_path.indexOf(DEFAULT_SUBKEY);
		try {
			key=Registry.HKEY_CURRENT_USER.openSubKey(current_key_path.substring(index));
			RegistryValue value=key.getValue(valueName);
			if(value!=null){
				mv.addObject("valueStr",new String(value.getByteData()));
			}
			keyName=key.getName();
			key.closeKey();
		} catch (NoSuchKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RegistryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mv.setViewName("showValue");
		mv.addObject("current_key_path", current_key_path);
		mv.addObject("keyName", keyName);
		mv.addObject("valueName", valueName);
		
		return mv;
	}
	
	
	@RequestMapping(value="/updateValue.htm",method=RequestMethod.GET)
	public ModelAndView updateValue(String current_key_path, String valueName,String newValue ){
		ModelAndView mv =new ModelAndView();
		RegistryKey key;
		int index = current_key_path.indexOf(DEFAULT_SUBKEY);
		String keyName=null;
		try {
			key=Registry.HKEY_CURRENT_USER.createSubKey(current_key_path.substring(index), "");
			RegStringValue val = new RegStringValue(key, valueName);
			val.setData(newValue);//尚未做重复name控制
			key.setValue(val);
			keyName =key.getName();
			
			key.closeKey();
		} catch (NoSuchKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RegistryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mv.setViewName("updateSuccess");
		mv.addObject("current_key_path", current_key_path);
		mv.addObject("value", newValue);
		mv.addObject("keyName", keyName);
		return mv;
		
	}
	
	//删除key
	@RequestMapping(value="/deleteKey.htm",method=RequestMethod.GET)
	public ModelAndView deleteKey(String current_key_path,String subKey){
		ModelAndView mv =new ModelAndView();
		RegistryKey key;
		int index = current_key_path.indexOf(DEFAULT_SUBKEY);
		try {
			key=Registry.HKEY_CURRENT_USER.createSubKey(current_key_path.substring(index)+"\\"+subKey,"");
			key.deleteSubKey(current_key_path+"\\"+subKey);
			mv.setViewName("redirect:/showSubKeys.htm?current_key_path="
                    + current_key_path);
			key.closeKey();
		} catch (RegistryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return mv;
	}
	
	
	
	
	
	
	
	
}
