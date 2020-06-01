package edu.hospitalreservation.hospitalreservation;

import org.springframework.boot.stereotype.Controller;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class TestController {

    @RequestMapping("/search")
    public String search_test(@RequestBody(required=false) JSONObject json){
        String result="search";
        return result;
    }

    @ResponseBody
    @RequestMapping("/search/content")
    public String log_test(@RequestBody(required=false) String data){
        String result="searchOK";
        JSONObject j=new JSONObject();
        try{
            JSONObject json= new JSONObject(data);
            String search_type = json.getString("search_type");
            String hospital_type_level = json.getString("hospital_type_level");
            String search_input = json.getString("search_input");
            j.put("result",result);
        }catch(Exception e) {System.out.println("wuwuwu"); }
        return j.toString();
    }
}


    @ResponseBody
    @RequestMapping("/login/self")
    public String log_test(@RequestBody(required=false) String data){
        String result="login";
        JSONObject j=new JSONObject();
        try{
            JSONObject json= new JSONObject(data);
            String user = json.getString("user");
            String passwd = json.getString("passwd");
            if(user.equalsIgnoreCase("123456"))
                result="OK";
            else if(passwd.equalsIgnoreCase("666666"))
                result="NO";
            j.put("result",result);
        }catch(Exception e) {System.out.println("wuwuwu"); }
        return j.toString();
    }


    @RequestMapping("/personalCenter**")
    public String personal_center_test(@RequestBody(required=false) JSONObject json){

        return "personalCenter";
    }

    @ResponseBody
    @RequestMapping("/personalCenter/info")
    public String personal_info_test(@RequestBody(required=false) String data){
        JSONObject j=new JSONObject();
        JSONArray array = new JSONArray();
        String user="..";
        try{
            JSONObject jo =new JSONObject();
            jo.put("hd","H1");
            jo.put("fare","49");
            jo.put("time","04-05-2020");
            JSONObject j2 =new JSONObject();
            j2.put("hd","H2");
            j2.put("fare","48");
            j2.put("time","03-05-2020");
            array.put(jo);
            array.put(j2);

            j.put("user","Rico");
            j.put("gender","male");
            j.put("IDnumber","123456789123456789");
            j.put("phone","12456789");
            j.put("oders",array);

            JSONObject json= new JSONObject(data);
            user=json.getString("user");
        }catch(Exception e) {System.out.println("wuwuwu"); }
        if(user.equalsIgnoreCase("123456"))
            return j.toString();
        return "no";
    }
}

