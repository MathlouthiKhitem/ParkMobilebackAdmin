package com.example.demo.sERVICE;

import com.example.demo.Module.Agent;
import com.example.demo.Module.Client;
import com.example.demo.Module.Users;
import com.example.demo.Module.Zone;
import com.example.demo.repository.AgentRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.UsersRepository;
import com.example.demo.repository.ZoneRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@Slf4j
@Service
public class AdminService   implements UsersService{
    @Autowired
    private  UsersRepository usersRepository;
    @Autowired
    private final ClientRepository clientRepository;
    @Autowired
    private final AgentRepository agentRepository;
    @Autowired
    private final ZoneRepository zoneRepository;

    @Value("${spring.application.name}")
    private String demo;

    public AdminService(UsersRepository usersRepository, ClientRepository clientRepository, AgentRepository agentRepository, ZoneRepository zoneRepository) {
        this.usersRepository = usersRepository;
        this.clientRepository = clientRepository;
        this.agentRepository = agentRepository;
        this.zoneRepository = zoneRepository;
    }

    public ResponseEntity<Users> createAdmin(@RequestBody Users users) throws URISyntaxException {
        users.setType(0);

        // Generate ObjectId values for ID fields
        ObjectId id = new ObjectId();

        // Set the ID for both the Users and Client objects
        users.setId(id.toString());
        Client client = new Client();
        client.setId(id.toString());

        // Associate the objects
        users.setClient(client);
        client.setUser(users);

        Users savedUsers = save(users);
        Client savedClient = clientRepository.save(client);

        // Manually construct the location URI of the created resource
        String locationUri = "/api/users/" + savedUsers.getId();

        // Return the ResponseEntity with the appropriate status code and location header
        return ResponseEntity.created(new URI(locationUri)).body(savedUsers);
    }
    public ResponseEntity<Users> createAgent(@RequestBody Users users) throws URISyntaxException {
        users.setType(1);

        // Generate ObjectId values for ID fields
        ObjectId id = new ObjectId();

        // Set the ID for both the Users and Client objects
        users.setId(id.toString());
        Agent client = new Agent();
        client.setId(id.toString());

        // Associate the objects
        users.setAgent(client);
        client.setUser(users);

        Users savedUsers = save(users);
        Agent savedClient = agentRepository.save(client);

        // Manually construct the location URI of the created resource
        String locationUri = "/api/users/" + savedUsers.getId();

        // Return the ResponseEntity with the appropriate status code and location header
        return ResponseEntity.created(new URI(locationUri)).body(savedUsers);
    }
    public boolean verifyCredentials(String email, String password) {
        List<Users> users = usersRepository.findByEmail(email);
        for (Users user : users) {
            if (user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public List<Users> getUsersByTypeAndEmailContains() {
        List<Users> users = usersRepository.findAll();

        List<Users> filteredUsers = new ArrayList<>();

        for (Users user : users) {
            if (user.getType() == 1) {
                filteredUsers.add(user);
            }
        }

        return filteredUsers;
    }

    public List<Zone> getListeZone() {
        List<Zone> zones = zoneRepository.findAll();
        return zones;
    }

    public Zone addZONE(@RequestBody Map<String, String> request) throws URISyntaxException {



            Zone parking = new Zone();
            parking.setNameZone(request.get("nameZone"));
            parking.setHourPrice(request.get("hourPrice"));
            parking.setVille(request.get("ville"));
            parking.setDescription(request.get("description"));
        parking.setNmeroParking (request.get("numeroParking"));
        return zoneRepository.save(parking);


    }

    public Map<String, String> assignZoneToAgent(String zoneId, String agentId) {
        Zone zone = zoneRepository.findById(zoneId).orElse(null);
        Agent agent = agentRepository.findById(agentId).orElse(null);

        if (zone != null && agent != null) {
            agent.setZone(zone);
            agentRepository.save(agent);

            // Create a map to hold the zoneId and agentId
            Map<String, String> response = new HashMap<>();
            response.put("zoneId", zoneId);
            response.put("agentId", agentId);

            return response; // Return the map
        } else {
            throw new IllegalArgumentException("Zone or Agent not found with the given IDs.");
        }
    }

//    public Map<String, String> assignZoneToAgent(String zoneId, String agentId) {
//        Zone zone = zoneRepository.findById(zoneId).orElse(null);
//        Agent agent = agentRepository.findById(agentId).orElse(null);
//
//        if (zone != null && agent != null) {
//            // Add the zone to the agent's list of zones
//            agent.getZones().add(zone);
//            agentRepository.save(agent);
//
//            // Create a map to hold the zoneId and agentId
//            Map<String, String> response = new HashMap<>();
//            response.put("zoneId", zoneId);
//            response.put("agentId", agentId);
//
//            return response; // Return the map
//        } else {
//            throw new IllegalArgumentException("Zone or Agent not found with the given IDs.");
//        }
//    }
    @Override
    public Users save(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public Users update(Users users) {
        return null;
    }

    @Override
    public Optional<Users> partialUpdate(Users users) {
        return Optional.empty();
    }

    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public Optional<Users> findOne(String id) {
        return Optional.empty();
    }

    @Override
    public void delete(String id) {

    }
}
