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
package edu.usu.sdl.openstorefront.web.rest.model;

import edu.usu.sdl.openstorefront.storage.model.ComponentResource;
import edu.usu.sdl.openstorefront.storage.model.ResourceType;
import edu.usu.sdl.openstorefront.util.TranslateUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dshurtleff
 */
public class ComponentResourceView
{

	private String name;
	private String resourceType;
	private String resourceTypeDesc;
	private String description;
	private String link;
	private Boolean restricted;

	public ComponentResourceView()
	{
	}

	public static List<ComponentResourceView> toViewList(List<ComponentResource> resources)
	{
		List<ComponentResourceView> viewList = new ArrayList();
		resources.forEach(resource->{
			viewList.add(toView(resource));
		});
		return viewList;
	}
	
	public static ComponentResourceView toView(ComponentResource componentResource)
	{
		ComponentResourceView componentResourceView = new ComponentResourceView();
		componentResourceView.setDescription(componentResource.getDescription());
		componentResourceView.setName(componentResource.getName());
		componentResourceView.setResourceType(componentResource.getResourceType());
		componentResourceView.setResourceTypeDesc(TranslateUtil.translate(ResourceType.class, componentResource.getResourceType()));
		componentResourceView.setRestricted(componentResource.getRestricted());

		String link = componentResource.getLink();
		if (componentResource.getResourceFileId() != null) {
			link = ComponentResource.LOCAL_RESOURCE_URL + componentResource.getResourceId();
		}
		componentResourceView.setLink(link);
		return componentResourceView;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getLink()
	{
		return link;
	}

	public void setLink(String link)
	{
		this.link = link;
	}

	public String getResourceType()
	{
		return resourceType;
	}

	public void setResourceType(String resourceType)
	{
		this.resourceType = resourceType;
	}

	public Boolean getRestricted()
	{
		return restricted;
	}

	public void setRestricted(Boolean restricted)
	{
		this.restricted = restricted;
	}

	public String getResourceTypeDesc()
	{
		return resourceTypeDesc;
	}

	public void setResourceTypeDesc(String resourceTypeDesc)
	{
		this.resourceTypeDesc = resourceTypeDesc;
	}

}
