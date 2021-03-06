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
package edu.usu.sdl.openstorefront.storage.model;

import edu.usu.sdl.openstorefront.doc.ConsumeField;
import java.io.Serializable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dshurtleff
 */
public class ComponentEvaluationSectionPk
		implements Serializable
{

	@NotNull
	@ConsumeField
	private String componentId;

	@NotNull
	@ConsumeField
	private String evaulationSection;

	public ComponentEvaluationSectionPk()
	{
	}

	public String getComponentId()
	{
		return componentId;
	}

	public void setComponentId(String componentId)
	{
		this.componentId = componentId;
	}

	public String getEvaulationSection()
	{
		return evaulationSection;
	}

	public void setEvaulationSection(String evaulationSection)
	{
		this.evaulationSection = evaulationSection;
	}

}
