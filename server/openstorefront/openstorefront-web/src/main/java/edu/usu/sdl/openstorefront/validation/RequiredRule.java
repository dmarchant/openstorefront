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

package edu.usu.sdl.openstorefront.validation;

import edu.usu.sdl.openstorefront.exception.OpenStorefrontRuntimeException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.validation.constraints.NotNull;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author dshurtleff
 */
public class RequiredRule
	extends BaseRule
{

	@Override
	protected boolean validate(Field field, Object dataObject)
	{
		boolean valid = true;
		
		NotNull notNull = field.getAnnotation(NotNull.class);	
		if (notNull != null)
		{
			try
			{
				String value = BeanUtils.getProperty(dataObject, field.getName());
				
				//This also consider Blank as null
				if (StringUtils.isBlank(value))
				{
					valid = false;
				}
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex)
			{
				throw new OpenStorefrontRuntimeException("Unexpected error occur trying to get value from object.", ex);
			}
		}
		return valid;
	}

	@Override
	protected String getMessage()
	{
		return "Value is required";
	}

	@Override
	protected String getValidationRule(Field field)
	{
		StringBuilder sb = new StringBuilder();					
		sb.append("Value must not be null.");
		return sb.toString();
	}
	
}
