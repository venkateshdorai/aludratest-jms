/*
 * Copyright (C) 2015 Hamburg Sud and the contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.aludratest.service.jms.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Map;

/**
 * Unit test for TextMessageData
 *
 */
public class TextMessageDataTest {

	@Test
    public void testSimpleMessageNullContent() {
		
		TextMessageData message = new TextMessageData();
		
		//assert null content
		assertEquals(null, message.getMessageText());
	}
	
	@Test
    public void testSimpleMessageStringContent() {
		
		String messageValue = "message Value 1";
		TextMessageData message = new TextMessageData(messageValue);
		
		//assert message content
		assertEquals(messageValue, message.getMessageText());
	}
	
	@Test
    public void testSimpleMessageWithProperties() {
		
		String messageValue = "message Value 2";
		String key1 = "key1";
		String value1 = "value1";
		
		TextMessageData message = new TextMessageData(messageValue);
		message.addProperty(key1, value1);
		
		//assert message content
		assertEquals(messageValue, message.getMessageText());
		
		Map<String, Object> properties = message.getProperties();
		
		//assert size
		assertEquals(1, message.getProperties().size());
		//assert properties content
		assertEquals(value1, message.getProperties().get(key1));
		
		String key2 = "key2";
		String value2 = "value2";
		
		properties.put(key2, value2);
		
		//assert size: should remain 1. previous put have no effect
		assertEquals(1, message.getProperties().size());
		
		properties.clear();
		
		//assert size: should remain 1. previous clear have no effect
		assertEquals(1, message.getProperties().size());
	}
}
