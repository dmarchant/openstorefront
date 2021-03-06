/*
 * Copyright 2014 Space Dynamics Laboratory - Utah State University Research Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.usu.sdl.openstorefront.service.api;

import edu.usu.sdl.openstorefront.service.ServiceInterceptor;
import edu.usu.sdl.openstorefront.service.TransactionInterceptor;
import edu.usu.sdl.openstorefront.storage.model.ApplicationProperty;

/**
 *
 * @author dshurtleff
 */
public interface SystemService
{

	/**
	 * Gets Full application Property
	 *
	 * @param key
	 * @return null if property is not found
	 */
	public ApplicationProperty getProperty(String key);

	/**
	 * Gets property Value
	 *
	 * @param key
	 * @return null if property is not found
	 */
	public String getPropertyValue(String key);

	/**
	 * Save a property to Application Properties. Application properties are
	 * used to store application specific state. If the property should be admin
	 * configurable it should be store in the properties file
	 *
	 * @param key
	 * @param value
	 */
	@ServiceInterceptor(TransactionInterceptor.class)
	public void saveProperty(String key, String value);

}
