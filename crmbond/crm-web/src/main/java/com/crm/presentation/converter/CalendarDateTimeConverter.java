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
//public class CalendarDateTimeConverter implements Converter {
//
//	@Override
//	public Object getAsObject(FacesContext context, UIComponent component, String value) {
//		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm");
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
//		SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
//		StringBuilder date = new StringBuilder(formatter.format(((Calendar) object).getTime()));
//		return date.toString();
//	}
//}