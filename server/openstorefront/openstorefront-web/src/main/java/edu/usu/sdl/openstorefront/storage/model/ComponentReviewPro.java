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

import edu.usu.sdl.openstorefront.util.PK;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dshurtleff
 */
public class ComponentReviewPro
		extends BaseComponent
{

	@PK
	@NotNull
	private ComponentReviewProPk componentReviewProPk;
	private String text;

	public ComponentReviewPro()
	{
	}

	public ComponentReviewProPk getComponentReviewProPk()
	{
		return componentReviewProPk;
	}

	public void setComponentReviewProPk(ComponentReviewProPk componentReviewProPk)
	{
		this.componentReviewProPk = componentReviewProPk;
	}

	/**
	 * @return the text
	 */
	public String getText()
	{
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text)
	{
		this.text = text;
	}

}
