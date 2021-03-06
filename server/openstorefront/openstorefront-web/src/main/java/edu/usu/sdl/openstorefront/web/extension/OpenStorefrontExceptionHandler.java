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

package edu.usu.sdl.openstorefront.web.extension;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.usu.sdl.openstorefront.exception.OpenStorefrontRuntimeException;
import edu.usu.sdl.openstorefront.util.StringProcessor;
import edu.usu.sdl.openstorefront.web.viewmodel.SystemErrorModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StreamingResolution;
import net.sourceforge.stripes.controller.StripesConstants;
import net.sourceforge.stripes.exception.DefaultExceptionHandler;

/**
 *  Translate Errors into something the front-end can handle
 * @author dshurtleff
 */
public class OpenStorefrontExceptionHandler
	extends DefaultExceptionHandler
{
	private static final Logger log = Logger.getLogger(OpenStorefrontExceptionHandler.class.getName());
	
	private final SystemErrorModel systemErrorModel = new SystemErrorModel();
	
	public Resolution handleopenstorefrontException(OpenStorefrontRuntimeException error, HttpServletRequest request, HttpServletResponse response) 
	{
		systemErrorModel.setPotentialResolution(error.getPotentialResolution());
		return handleAll(error, request, response);
	}
	
	public Resolution handleAll(Throwable error, HttpServletRequest request, HttpServletResponse response) 
	{
		 ActionBean action = (ActionBean) request.getAttribute(StripesConstants.REQ_ATTR_ACTION_BEAN);
		log.log(Level.FINE, "System Error Occured", error);
		error.printStackTrace();
		
		  //TODO: Generate Error Ticket
		 // Capture all request information, stacktraces, user info
		 if (action != null) 
		 {
			 
		 }
		 		
		
		//Strip and senstive info (See Checklist Q: 410)
		
		systemErrorModel.setMessage(error.getMessage());			
		
		final ObjectMapper objectMapper =  StringProcessor.defaultObjectMapper();
		return new StreamingResolution(MediaType.APPLICATION_JSON) {

			@Override
			protected void stream(HttpServletResponse response) throws Exception
			{
				objectMapper.writeValue(response.getOutputStream(), systemErrorModel);				
			}			
		};
	}
	
}
