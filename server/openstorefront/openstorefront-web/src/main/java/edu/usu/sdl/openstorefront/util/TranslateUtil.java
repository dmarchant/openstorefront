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
package edu.usu.sdl.openstorefront.util;

import edu.usu.sdl.openstorefront.service.ServiceProxy;
import edu.usu.sdl.openstorefront.storage.model.LookupEntity;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author dshurtleff
 */
public class TranslateUtil
{

	private static final Logger log = Logger.getLogger(TranslateUtil.class.getName());

	public static <T extends LookupEntity> String translate(Class<T> lookupClass, String code)
	{
		String translated = code;
		if (StringUtils.isNotBlank(code)) {
			ServiceProxy serviceProxy = new ServiceProxy();
			LookupEntity lookupEntity = serviceProxy.getLookupService().getLookupEnity(lookupClass, code);
			if (lookupEntity != null) {
				translated = lookupEntity.getDescription();
			} else {
				log.warning("Unable to find: " + code + " in lookup: " + lookupClass.getName());
			}
		}
		return translated;
	}

}
