package com.crm.presentation.admin;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;

import com.crm.entities.AEntity;
import com.crm.entities.DynamicField;
import com.crm.sessionbean.DynamicFieldFacade;



public abstract class  AbstractDynamic<T extends AEntity> {
	
	private Class<T> entityClass;

	@EJB
	private DynamicFieldFacade dynamicFieldFacade;
	
	private Map<String,DynamicField> dynamicFields;
	
	public AbstractDynamic(Class<T> entityClass) {
		
		this.entityClass = entityClass;
	}
	
	/**
	 * @return the dynamicFields
	 */
	public  Map<String,DynamicField> getDynamicFields() {

		return dynamicFields;
	}
	
	public  Map<String,DynamicField> getFields() {
		if(dynamicFields == null)
		{
			dynamicFields = new HashMap<String,DynamicField>();
			for(DynamicField dv : dynamicFieldFacade.findAll())
			{
				if(dv.getEntityType().equals(entityClass.getName()))
					dynamicFields.put(dv.getFieldKey(), dv);
			}
		}
		return dynamicFields;
	}
	
	/**
	 * @param dynamicFields the dynamicFields to set
	 */
	public void setDynamicFields( Map<String,DynamicField> dynamicFields) {

		this.dynamicFields = dynamicFields;
	}
}
