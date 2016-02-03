package com.poochiku.suraksha.greendao;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

public class SurakshaSchemaCreator
{

	private static final String OUTPUT_FOLDER = "/drive/engineering/code/poochiku/poochiku/suraksha/code/mobile/android/dao_output";

	public static void main(String[] args) throws Exception
	{
		Schema schema = new Schema(1, "com.poochiku.suraksha.greenDao");
		addUser(schema);
		addIncident(schema);
		//addCustomerOrder(schema);
		new DaoGenerator().generateAll(schema, OUTPUT_FOLDER);
	}

	private static void addUser(Schema schema)
	{
		Entity note = schema.addEntity("SurakshaUser");
		note.addIdProperty();
		note.addStringProperty("firstName").notNull();
		note.addStringProperty("lastName");
		note.addStringProperty("email");
		note.addStringProperty("phoneNumber").notNull();
		note.addStringProperty("gender").notNull();
		note.addStringProperty("surakshaId").notNull();
		note.addStringProperty("password").notNull();
		note.addLongProperty("dob");
	}
	private static void addIncident(Schema schema)
	{
		Entity incident = schema.addEntity("SurakshaIncident");
		incident.addIdProperty();
		incident.addStringProperty("reportId").notNull();
		incident.addStringProperty("surakshaId");
		incident.addStringProperty("username");
		incident.addLongProperty("latitude").notNull();
		incident.addLongProperty("createdDatetime").notNull();
		incident.addLongProperty("longitude").notNull();
		incident.addStringProperty("catName").notNull();
		incident.addStringProperty("catType").notNull();
		incident.addStringProperty("catDispName").notNull();
		incident.addStringProperty("tagName").notNull();
		incident.addStringProperty("tafType").notNull();
		incident.addStringProperty("tagDispName").notNull();
		incident.addStringProperty("desc").notNull();
		incident.addStringProperty("fileIds");
		
	}

	/**
	 * Not using now : Just for reference
	 * 
	 * @param schema
	 */
//	private static void addCustomerOrder(Schema schema)
//	{
//		Entity customer = schema.addEntity("Customer");
//		customer.addIdProperty();
//		customer.addStringProperty("name").notNull();
//		Entity order = schema.addEntity("Order");
//		order.setTableName("ORDERS"); // "ORDER" is a reserved keyword
//		order.addIdProperty();
//		Property orderDate = order.addDateProperty("date").getProperty();
//		Property customerId = order.addLongProperty("customerId").notNull().getProperty();
//		order.addToOne(customer, customerId);
//		ToMany customerToOrders = customer.addToMany(order, customerId);
//		customerToOrders.setName("orders");
//		customerToOrders.orderAsc(orderDate);
//	}

}
