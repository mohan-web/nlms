package org.nlms.portal.controller;

import org.nlms.commons.model.Response;
import org.nlms.portal.model.BasicCard;
import org.nlms.portal.service.BasicCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic")
public class BasicCardController {
	
	@Autowired
	BasicCardService basicCardService;
	
	@ResponseBody
    @RequestMapping(value = "cards", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getByMandal(@RequestBody BasicCard basicCard){
		return basicCardService.getByMandal(basicCard);
	}
	
	@ResponseBody
    @RequestMapping(value = "benificiary", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getByBenificiary(@RequestBody BasicCard basicCard){
		return basicCardService.getByBenificiary(basicCard);
	}

}
