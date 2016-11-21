package com.crm.presentation.help;

import java.util.HashMap;
import java.util.Map;

public class Entity {

	// 5 is an estimate for the number attrs.
	private Map<String,Object> attrs = new HashMap<String,Object>(5);

	public Object getAttribute(String name) { return attrs.get(name); }

	public void setAttribute(String name, Object obj) { attrs.put(name,obj); }

}