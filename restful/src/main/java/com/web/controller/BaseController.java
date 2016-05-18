package com.web.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.exception.LookupException;
import com.util.Parameter;
import com.util.Security;
import com.web.pojo.Demo;
import com.web.pojo.TournamentContent;
import com.zook.api.ZKClientManager;
import com.zook.api.conts.ServiceConsts;
import com.zook.service.ITransService;

@Controller
@RequestMapping("/baseController")
public class BaseController {
	@Autowired
	private ZKClientManager clientManage;
//	@Autowired
//	private ElasticsearchTemplate elasticsearchTemplate;
	@RequestMapping(value="/jsonfeed",method={RequestMethod.GET})
//	@ResponseBody
    public ModelAndView getJSONs(Model model) {  
        List<TournamentContent> tournamentList = new ArrayList<TournamentContent>();  
        tournamentList.add(TournamentContent.generateContent("FIFA", new Date(), "World Cup", "www.fifa.com/worldcup/"));  
        tournamentList.add(TournamentContent.generateContent("FIFA", new Date(), "U-20 World Cup", "www.fifa.com/u20worldcup/"));  
        tournamentList.add(TournamentContent.generateContent("FIFA", new Date(), "U-17 World Cup", "www.fifa.com/u17worldcup/"));  
        tournamentList.add(TournamentContent.generateContent("FIFA", new Date(), "Confederations Cup", "www.fifa.com/confederationscup/"));  
        model.addAttribute("items", tournamentList);  
        model.addAttribute("status", 0);  
        return new ModelAndView("index");  
    }  
	@RequestMapping(value="/jsonfeed",method={RequestMethod.POST})
//	@ResponseBody
    public ModelAndView getJSON(Model model) {  
        List<TournamentContent> tournamentList = new ArrayList<TournamentContent>();  
        tournamentList.add(TournamentContent.generateContent("FIFA", new Date(), "World Cup", "www.fifa.com/worldcup/"));  
        tournamentList.add(TournamentContent.generateContent("FIFA", new Date(), "U-20 World Cup", "www.fifa.com/u20worldcup/"));  
        tournamentList.add(TournamentContent.generateContent("FIFA", new Date(), "U-17 World Cup", "www.fifa.com/u17worldcup/"));  
        tournamentList.add(TournamentContent.generateContent("FIFA", new Date(), "Confederations Cup", "www.fifa.com/confederationscup/"));  
        model.addAttribute("items", tournamentList);  
        model.addAttribute("status", 0);  
        return new ModelAndView("index");  
    }  
	@RequestMapping("/list")
	@ResponseBody
	public List<Demo> getlist(){
		Parameter p=new Parameter();
		try {
			ITransService service=clientManage.lookup(ServiceConsts.TRANS);
			List<Demo> list=service.getTransList(new Security("",""), p);
			return list;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LookupException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
