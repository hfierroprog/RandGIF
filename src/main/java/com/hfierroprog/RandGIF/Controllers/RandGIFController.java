package com.hfierroprog.RandGIF.Controllers;

import at.mukprojects.giphy4j.Giphy;
import at.mukprojects.giphy4j.entity.giphy.GiphyRandom;
import at.mukprojects.giphy4j.entity.search.SearchRandom;
import at.mukprojects.giphy4j.exception.GiphyException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RandGIFController {
    
    @RequestMapping(value = "/")
    public String RandomGif(Model model){
        
        Giphy giphy = new Giphy("UTvzNeIbjkDQnzhmx3PwFrMZVT6INkfI");
        
        try {
            SearchRandom search = giphy.searchRandom("meme");
            
            
            GiphyRandom gr = search.getData();
            
            model.addAttribute("titulo", "RandGIF:");
            model.addAttribute("urlimg", gr.getImageUrl());
            
            System.out.println(gr);
        } catch (GiphyException ex) {
            Logger.getLogger(RandGIFController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "random";
    }
}
