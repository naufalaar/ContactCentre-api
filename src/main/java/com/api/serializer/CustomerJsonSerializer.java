package com.api.serializer;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;

import com.api.entity.Customer;
import com.api.entity.CustomerStore;
import com.api.entity.Store;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@JsonComponent
public class CustomerJsonSerializer extends JsonSerializer<Customer>{

	@Override
	public void serialize(Customer customer, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
		
		jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id",customer.getId());
        jsonGenerator.writeStringField("firstName",customer.getFirstName());
        jsonGenerator.writeStringField("lastName",customer.getLastName());
        jsonGenerator.writeStringField("birthDate",customer.getBirthDateAsString());
        jsonGenerator.writeStringField("gender",customer.getGender());
        jsonGenerator.writeObjectField("activeStore", customer.getActiveStore());
        jsonGenerator.writeObjectField("salutation", customer.getSalutation());
        jsonGenerator.writeObjectField("status", customer.getStatus());
        jsonGenerator.writeStringField("nextPackIssueDate",customer.getNextPackIssueDateAsString());
        jsonGenerator.writeStringField("clensCheckDate",customer.getclensCheckDateAsString());
        jsonGenerator.writeStringField("emailAddress",customer.getEmailAsString());
        jsonGenerator.writeObjectField("homePhone", customer.getTelephoneByType(1));
        jsonGenerator.writeObjectField("officePhone", customer.getTelephoneByType(2));
        jsonGenerator.writeObjectField("mobilePhone", customer.getTelephoneByType(3));
        jsonGenerator.writeObjectField("homeAddress", customer.getAddressByType("Home"));
        jsonGenerator.writeObjectField("deliveryAddress", customer.getAddressByType("Delivery"));
        jsonGenerator.writeFieldName("stores");
        jsonGenerator.writeStartArray();
        for(CustomerStore store: customer.getCustomerStores()) {
        	jsonGenerator.writeStartObject();
        	jsonGenerator.writeStringField("type",store.getType());
        	jsonGenerator.writeNumberField("storeNumber",store.getStore().getStoreNumber());
        	jsonGenerator.writeStringField("storeName",store.getStore().getStoreName());
        	jsonGenerator.writeStringField("addressLineOne",store.getStore().getAddressLine1());
        	jsonGenerator.writeStringField("addressLineTwo",store.getStore().getAddressLine2());
        	jsonGenerator.writeStringField("town",store.getStore().getTown());
        	jsonGenerator.writeStringField("county",store.getStore().getCounty());
        	jsonGenerator.writeStringField("country",store.getStore().getCountry());
        	jsonGenerator.writeStringField("postCode",store.getStore().getPostCode());
        	jsonGenerator.writeNumberField("telephone",store.getStore().getTelephone());
        	jsonGenerator.writeNumberField("fax",store.getStore().getFax());
        	jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
		
	}

}
