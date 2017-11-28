package com.chinapnr.service.ws;

import java.net.MalformedURLException;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

import com.chinapnr.facade.service.TradeFacade;

public class T {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Service srvcModel = new ObjectServiceFactory().create(TradeFacade.class);
        
		XFireProxyFactory factory = new XFireProxyFactory(
		 XFireFactory.newInstance().getXFire());
		 
		String helloWorldURL = "http://localhost:8080//services/tradeFacade";
		  
		TradeFacade srvc;
		try {
			srvc = ( TradeFacade) factory.create(srvcModel, 
			                                  helloWorldURL);
			   System.out.println(ToStringBuilder.reflectionToString(srvc.getTradeInfo("a"))); 
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
