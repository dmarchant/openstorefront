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

package edu.usu.sdl.openstorefront.web.rest.resource;

import edu.usu.sdl.openstorefront.doc.APIDescription;
import edu.usu.sdl.openstorefront.doc.DataType;
import edu.usu.sdl.openstorefront.web.rest.model.Article;
import edu.usu.sdl.openstorefront.web.rest.model.AttributeTypeView;
import edu.usu.sdl.openstorefront.web.rest.model.RestListResponse;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author dshurtleff
 */
@Path("v1/resource/attributes")
@APIDescription("Attributes are the filterable data asscoated with the listings.")
public class AttributeResource
	extends BaseResource
{
	
	@GET
	@APIDescription("Gets all active attributes and codes for the attributes in view based model.")
	@Produces({MediaType.APPLICATION_JSON})	
	@DataType(AttributeTypeView.class)
	@Path("/view")	
	public RestListResponse getAttributeView()
	{
		List<AttributeTypeView> attributeTypeViews = new ArrayList<>();
	
		
		return sendListResponse(attributeTypeViews);		
	}	
		
	@GET
	@APIDescription("Gets all active attributes and codes for the attributes in view based model.")	
	@Path("/{type}/attributeCode/{code}/article")	
	public Article getAttributeArticle()
	{
		
		return new Article();
	}	
	
}
