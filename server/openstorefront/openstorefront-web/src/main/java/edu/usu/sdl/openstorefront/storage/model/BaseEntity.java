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

import edu.usu.sdl.openstorefront.doc.ValidValueType;
import edu.usu.sdl.openstorefront.util.OpenStorefrontConstant;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author dshurtleff
 */
public abstract class BaseEntity
		implements Serializable
{

	public static final String ACTIVE_STATUS = "A";
	public static final String INACTIVE_STATUS = "I";

	@NotNull
	@ValidValueType({"A", "I"})
	private String activeStatus;

	@NotNull
	@Size(min = 1, max = OpenStorefrontConstant.FIELD_SIZE_USERNAME)
	private String createUser;

	@NotNull
	private Date createDts;

	@NotNull
	@Size(min = 1, max = OpenStorefrontConstant.FIELD_SIZE_USERNAME)
	private String updateUser;

	@NotNull
	private Date updateDts;

	public BaseEntity()
	{
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

}
