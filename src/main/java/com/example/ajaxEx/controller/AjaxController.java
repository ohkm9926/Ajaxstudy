package com.example.ajaxEx.controller;

import com.example.ajaxEx.dto.ajaxDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AjaxController {

    @GetMapping("/ex01")
    public String ex01(){
        System.out.println("AjaxController.ex01");
        return "index";
    }
    @PostMapping("/ex02")
    public @ResponseBody String ex02() {
        System.out.println("AjaxController.ex02");
        return "index";
    }
    @GetMapping("/ex03")
    public @ResponseBody  String ex03(@RequestParam("param1") String param1 , @RequestParam("param2") String param2){
        System.out.println("param =" + param1 +", param2 =" + param2);
        return "ex03메서드 호출완료";
    }

    @PostMapping("/ex04")
    public @ResponseBody  String ex04(@RequestParam("param1") String param1 , @RequestParam("param2") String param2){
        System.out.println("param =" + param1 +", param2 =" + param2);
        return "ex04메서드 호출완료";
    }
    @GetMapping("/ex05")
    public @ResponseBody ajaxDTO ex05(@ModelAttribute ajaxDTO ajaxDTO){
        System.out.println("ajaxDTO = " + ajaxDTO.getParam1());
        return ajaxDTO;



    }
    @PostMapping("/ex06")
    public @ResponseBody ajaxDTO ex06(@ModelAttribute ajaxDTO ajaxDTO) {
        System.out.println("ajaxDTO = " + ajaxDTO.getParam1());
        return ajaxDTO;
    }
    @PostMapping("/ex07")
    public @ResponseBody ajaxDTO ex07(@RequestBody ajaxDTO ajaxDTO){
        System.out.println("ajaxDTO =" + ajaxDTO);
        return ajaxDTO;
    }
     private List<ajaxDTO> DTOList(){
         List<ajaxDTO> dtoList = new ArrayList<>();
         dtoList.add(new ajaxDTO("data1" , "data11"));
         dtoList.add(new ajaxDTO("data2" , "data12"));

         return dtoList;
     }

    @PostMapping("/ex08")
    public @ResponseBody List<ajaxDTO> ex08(@RequestBody ajaxDTO ajaxDTO){
        System.out.println("ajaxDTO =" + ajaxDTO);
        List<ajaxDTO> dtoList = DTOList();
        dtoList.add(ajaxDTO);
        return dtoList;
    }

    @PostMapping("/ex09")
    public ResponseEntity ex09(@RequestBody ajaxDTO ajaxDTO){
        System.out.println("ajaxDTO =" + ajaxDTO);

        return new ResponseEntity<>(ajaxDTO ,HttpStatus.OK);
    }

    @PostMapping("/ex10")
    public ResponseEntity ex10(@RequestBody ajaxDTO ajaxDTO){
        System.out.println("ajaxDTO =" + ajaxDTO);
        List<ajaxDTO> dtoList = DTOList();
        dtoList.add(ajaxDTO);

        return new ResponseEntity<>(dtoList ,HttpStatus.OK);
    }

}
