package org.nlms.portal.service;

import java.util.List;

import org.nlms.commons.model.Response;
import org.nlms.commons.util.OpenLibUtils;
import org.nlms.portal.dao.BasicCardDAO;
import org.nlms.portal.model.BasicBenificiary;
import org.nlms.portal.model.BasicCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BasicCardService {
	
	private static final Logger logger = LoggerFactory.getLogger(BasicCardService.class);
	
	@Autowired
	BasicCardDAO basicCardDAO; 
	
	public Response getByMandal(BasicCard basicCard){
		
		 Response response = new Response();
	     response.setSuccessful(false);
	     response.setRequestObject(OpenLibUtils.clone(basicCard));
	     if ((basicCard.getMandal() != null) && (!StringUtils.isEmpty(basicCard.getMandal()))){
	    	 List<BasicCard> list = basicCardDAO.getByMandal(basicCard);
	    	 response.setResponseObject(list);
	    	 response.setSuccessful(true);
	     }
	     else
         {
            response.setErrorMessage("Invaid mandal : " + basicCard.getMandal());
         }
	     return response;
	}

	public Response getByBenificiary(BasicCard basicCard) {
		Response response = new Response();
	     response.setSuccessful(false);
	     response.setRequestObject(OpenLibUtils.clone(basicCard));
	     if ((basicCard.getAadhaar() != null) && (!StringUtils.isEmpty(basicCard.getAadhaar()))){
	    	 BasicBenificiary basicBenificiary = basicCardDAO.getByBenificiary(basicCard);
	    	 response.setResponseObject(basicBenificiary);
	    	 response.setSuccessful(true);
	     }
	     else
         {
            response.setErrorMessage("Invaid aadhaar : " + basicCard.getAadhaar());
         }
		return response;
	}

}
