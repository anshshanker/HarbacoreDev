package com.example.demo;

import com.example.demo.dto.SpecimenDto;
import com.example.demo.service.ISpecimenService;
import com.example.demo.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class cont {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    ISpecimenService specimenService;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/register")
    public String register(Model model)
    {
        SpecimenDto specimenDTO=new SpecimenDto();
        model.addAttribute("specimenDTO",specimenDTO);
        return "Registerform";
    }

    @PostMapping("/saveuser")
    public String verification(SpecimenDto specimenDTO) throws Exception {
        if(specimenService.existsById(specimenDTO.getEmail()))
            return "Registerform";
        try {
            specimenService.save(specimenDTO);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "Registerform";
        }
        return "login";
    }
    @GetMapping("/login")
    public String login(Model model){
        SpecimenDto specimenDTO=new SpecimenDto();
        model.addAttribute("specimenDTO",specimenDTO);
        return "login";
    }
    @PostMapping("/verify")
    public String verify(SpecimenDto specimenDTO, HttpServletResponse response)throws Exception{
        if(!specimenService.existsById(specimenDTO.getEmail()))
            return "login";
        try{
            SpecimenDto specimenDto1 = specimenService.findById(specimenDTO.getEmail()).get();
            if(!specimenDto1.getPassword().equals(specimenDTO.getPassword()))
                return "login";
            String jwt=jwtUtils.createJWT(specimenDto1,3600*1000);
            Cookie cookie=new Cookie("Hbc",jwt);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
        }
        catch (Exception e){
            e.printStackTrace();
            return "login";
        }
        return "dash";
    }
    @GetMapping("/cart")
    public String cart(@CookieValue(value = "Hbc",defaultValue = " ") String jwt){
        //if (jwt.equals(" "))
          //return "login";
        //try{
            Claims claims=jwtUtils.decodeJWT(jwt);
            if(Integer.parseInt(claims.getIssuer())%2==0)
                return "cart";
            else return "login";
            //return "dash";
        //}
        //catch (Exception e){
            //return "login";
        //}
    }
    @GetMapping("/logout")
    public String logout(HttpServletResponse response)throws Exception{
        Cookie cookie=new Cookie("Hbc","");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "index";
    }
}