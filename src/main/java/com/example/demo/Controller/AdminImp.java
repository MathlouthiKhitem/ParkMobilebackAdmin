package com.example.demo.Controller;

import com.example.demo.Module.Users;
import com.example.demo.Module.Zone;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.sERVICE.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RestController
@RequestMapping("/Backend/admin")

@CrossOrigin("http://localhost:4200")
public class AdminImp {
       @Autowired
    AdminService iServContrat;
    @Autowired
    ZoneRepository zoneRepository;

    public AdminImp(AdminService iServContrat) {
        this.iServContrat = iServContrat;
    }

    @PostMapping("/addadmin")
    public Users signup(@RequestBody Users es) throws URISyntaxException {

        ResponseEntity<Users> response = iServContrat.createAdmin(es);
        Users savedUsers = response.getBody();

        return savedUsers;
    }
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> signIn(@RequestBody Users signInRequest) {
        boolean isValidCredentials = iServContrat.verifyCredentials(signInRequest.getEmail(), signInRequest.getPassword());
        if (isValidCredentials) {
            // User is authenticated, generate and return a token

            Map<String, String> response = new HashMap<>();
            response.put("email", signInRequest.getEmail());

            return ResponseEntity.ok(response);
        } else {
            // Invalid credentials
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
    @PostMapping("/addAgent")
    public Users AgentSignup(@RequestBody Users es) throws URISyntaxException {

        ResponseEntity<Users> response = iServContrat.createAgent(es);
        Users savedUsers = response.getBody();

        return savedUsers;
    }
    @GetMapping("/users/type2")
    public List<Users> getUsersByType2() {
        return iServContrat.getUsersByTypeAndEmailContains();
    }
    @PostMapping("/zone")
    public Zone addZONE(@RequestBody Map<String, String> request) throws URISyntaxException {
        return iServContrat.addZONE(request);
    }
    @GetMapping("/zoneliste")
    public List<Zone> getListeZone(){
        return  iServContrat.getListeZone();
    }
    @PostMapping("/assign")
    public ResponseEntity<Map<String, String>> assignZoneToAgent(@RequestBody Map<String, String> request) {
        String zoneId = request.get("zoneId");
        String agentId = request.get("agentId");

        Map<String, String> response = iServContrat.assignZoneToAgent(zoneId, agentId);
        return ResponseEntity.ok(response);
    }



}
