/**
 * To serialize and deserialize from an abstract class 'Payment',
 * Gson allows you to register custom serializer and deserializer.
 * Reference: https://www.javacodegeeks.com/2012/04/json-with-gson-and-abstract-classes.html
 */
package app;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class PaymentAdapter implements JsonSerializer<Payment>, JsonDeserializer<Payment> {
    
	/**
	 * Two JSON properties are added : `type` and `properties` 
	 * - type holds a concrete implementation class (simple name such as Cash or CreditCard)
	 * - properties holds the serialized object itself
	 * 
	 * For example,
	 * 	  {
	 * 		 "type": "Cash",
     *		 "properties": {
     * 			"cash": 4000.0,
     * 			"amount": 100.0,
     * 			"method": "CASH"
     *	  	 }
     *	  }
	 */
	@Override
	public JsonElement serialize(Payment src, Type typeOfT, JsonSerializationContext context) {
		JsonObject result = new JsonObject();
        result.add("type", new JsonPrimitive(src.getClass().getSimpleName()));
        result.add("properties", context.serialize(src, src.getClass()));
        return result;
	}
	
	@Override
	public Payment deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();
        JsonElement element = jsonObject.get("properties");
 
        try {
            return context.deserialize(element, Class.forName("app." + type));
        } catch (ClassNotFoundException cnfe) {
            throw new JsonParseException("Unknown element type: " + type, cnfe);
        }
	}

}