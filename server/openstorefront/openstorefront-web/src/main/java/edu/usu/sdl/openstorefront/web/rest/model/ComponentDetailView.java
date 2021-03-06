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

import edu.usu.sdl.openstorefront.doc.DataType;
import edu.usu.sdl.openstorefront.doc.ParamTypeDescription;
import edu.usu.sdl.openstorefront.storage.model.ComponentTag;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;

/**
 * ComponentDetailView Resource
 *
 * @author dshurtleff
 */
public class ComponentDetailView
{

	@NotNull
	@ParamTypeDescription("Key")
	private String componentId;

	@NotNull
	private String guid;

	@NotNull
	private String name;

	@NotNull
	private String description;

	private ComponentRelationshipView parentComponent;

	@DataType(ComponentRelationshipView.class)
	private List<ComponentRelationshipView> subComponents = new ArrayList<>();

	@NotNull
	private String organization;

	private Date releaseDate;
	private String version;

	@NotNull
	private String activeStatus;

	@NotNull
	private Date lastActivityDts;

	@NotNull
	private String createUser;

	@NotNull
	private Date createDts;

	@NotNull
	private String updateUser;

	@NotNull
	private Date updateDts;

	@NotNull
	private Date approvedDate;
	private String approvalState;

	@NotNull
	private String approvedUser;

	private ComponentEvaluationView evaluation = new ComponentEvaluationView();

	@DataType(ComponentQuestionView.class)
	private List<ComponentQuestionView> questions = new ArrayList<>();

	@DataType(ComponentAttributeView.class)
	private List<ComponentAttributeView> attributes = new ArrayList<>();

	@DataType(ComponentTag.class)
	private List<ComponentTag> tags = new ArrayList<>();

	@DataType(ComponentMetadataView.class)
	private List<ComponentMetadataView> metadata = new ArrayList<>();

	@DataType(ComponentMediaView.class)
	private List<ComponentMediaView> componentMedia = new ArrayList<>();

	@DataType(ComponentContactView.class)
	private List<ComponentContactView> contacts = new ArrayList<>();

	@DataType(ComponentResourceView.class)
	private List<ComponentResourceView> resources = new ArrayList<>();

	@DataType(ComponentReviewView.class)
	private List<ComponentReviewView> reviews = new ArrayList<>();

	@DataType(ComponentExternalDependencyView.class)
	private List<ComponentExternalDependencyView> dependencies = new ArrayList<>();

	private Integer componentViews = 0;

	public ComponentDetailView()
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

	public String getGuid()
	{
		return guid;
	}

	public void setGuid(String guid)
	{
		this.guid = guid;
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

	public Date getReleaseDate()
	{
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate)
	{
		this.releaseDate = releaseDate;
	}

	public String getActiveStatus()
	{
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus)
	{
		this.activeStatus = activeStatus;
	}

	public String getCreateUser()
	{
		return createUser;
	}

	public void setCreateUser(String createUser)
	{
		this.createUser = createUser;
	}

	public Date getCreateDts()
	{
		return createDts;
	}

	public void setCreateDts(Date createDts)
	{
		this.createDts = createDts;
	}

	public String getUpdateUser()
	{
		return updateUser;
	}

	public void setUpdateUser(String updateUser)
	{
		this.updateUser = updateUser;
	}

	public Date getUpdateDts()
	{
		return updateDts;
	}

	public void setUpdateDts(Date updateDts)
	{
		this.updateDts = updateDts;
	}

	public ComponentEvaluationView getEvaluation()
	{
		return evaluation;
	}

	public void setEvaluation(ComponentEvaluationView evaluation)
	{
		this.evaluation = evaluation;
	}

	public List<ComponentAttributeView> getAttributes()
	{
		return attributes;
	}

	public void setAttributes(List<ComponentAttributeView> attributes)
	{
		this.attributes = attributes;
	}

	public List<ComponentMetadataView> getMetadata()
	{
		return metadata;
	}

	public void setMetadata(List<ComponentMetadataView> metadata)
	{
		this.metadata = metadata;
	}

	public List<ComponentMediaView> getComponentMedia()
	{
		return componentMedia;
	}

	public void setComponentMedia(List<ComponentMediaView> componentMedia)
	{
		this.componentMedia = componentMedia;
	}

	public List<ComponentContactView> getContacts()
	{
		return contacts;
	}

	public void setContacts(List<ComponentContactView> contacts)
	{
		this.contacts = contacts;
	}

	public List<ComponentResourceView> getResources()
	{
		return resources;
	}

	public void setResources(List<ComponentResourceView> resources)
	{
		this.resources = resources;
	}

	public List<ComponentReviewView> getReviews()
	{
		return reviews;
	}

	public void setReviews(List<ComponentReviewView> reviews)
	{
		this.reviews = reviews;
	}

	public String getVersion()
	{
		return version;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}

	public Date getApprovedDate()
	{
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate)
	{
		this.approvedDate = approvedDate;
	}

	public String getApprovalState()
	{
		return approvalState;
	}

	public void setApprovalState(String approvalState)
	{
		this.approvalState = approvalState;
	}

	public String getOrganization()
	{
		return organization;
	}

	public void setOrganization(String organization)
	{
		this.organization = organization;
	}

	public String getApprovedUser()
	{
		return approvedUser;
	}

	public void setApprovedUser(String approvedUser)
	{
		this.approvedUser = approvedUser;
	}

	public List<ComponentQuestionView> getQuestions()
	{
		return questions;
	}

	public void setQuestions(List<ComponentQuestionView> questions)
	{
		this.questions = questions;
	}

	public ComponentRelationshipView getParentComponent()
	{
		return parentComponent;
	}

	public void setParentComponent(ComponentRelationshipView parentComponent)
	{
		this.parentComponent = parentComponent;
	}

	public List<ComponentRelationshipView> getSubComponents()
	{
		return subComponents;
	}

	public void setSubComponents(List<ComponentRelationshipView> subComponents)
	{
		this.subComponents = subComponents;
	}

	public List<ComponentExternalDependencyView> getDependencies()
	{
		return dependencies;
	}

	public void setDependencies(List<ComponentExternalDependencyView> dependencies)
	{
		this.dependencies = dependencies;
	}

	public List<ComponentTag> getTags()
	{
		return tags;
	}

	public void setTags(List<ComponentTag> tags)
	{
		this.tags = tags;
	}

	public Date getLastActivityDts()
	{
		return lastActivityDts;
	}

	public void setLastActivityDts(Date lastActivityDts)
	{
		this.lastActivityDts = lastActivityDts;
	}

	public Integer getComponentViews()
	{
		return componentViews;
	}

	public void setComponentViews(Integer componentViews)
	{
		this.componentViews = componentViews;
	}

}
