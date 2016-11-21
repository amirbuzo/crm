//package com.crm.presentation.converter;
//
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//
//import javax.faces.component.UIComponent;
//import javax.faces.context.FacesContext;
//import javax.faces.convert.Converter;
//import javax.faces.convert.FacesConverter;
//import javax.inject.Named;
//
//@Named
//@FacesConverter(forClass = Date.class)
//public class CalendarConverter implements Converter {
//
//	@Override
//	public Object getAsObject(FacesContext context, UIComponent component, String value) {
//		System.out.println("ConverterObject"+value);
//		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
//		try {
//			Date date = formatter.parse(value);
//			Calendar cDate = Calendar.getInstance();
//			cDate.setTime(date);
//			return cDate;
//		} catch (Exception e) {
//			return null;
//		}
//	}
//
//	@Override
//	public String getAsString(FacesContext context, UIComponent component, Object object) {
//		if(!object.toString().isEmpty())
//		{
//			//				System.out.println("ConverterString"+object.toString());
//			//				//Tue Sep 20 00:00:00 CEST 2016
//			//				SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
//			//				SimpleDateFormat formatter2s = new SimpleDateFormat("MM/dd/yyyy");
//			//				Date date = formatter.parse(object.toString());
//			//
//			//				return formatter2s.format(date);
//			return object.toString();
//
//		}else
//			return null;
//	}
//}