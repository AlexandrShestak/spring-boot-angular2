package com.shestakam.rest;

import com.google.gson.JsonObject;
import com.shestakam.entity.Contact;
import com.shestakam.entity.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value = "/login",  produces="application/json")
    public String login(@RequestBody Contact contact) {
        JsonObject jsonObject = new JsonObject();
        JsonObject message = new JsonObject();

        message.addProperty("email", contact.getEmail());
        message.addProperty("password", contact.getPassword());
        jsonObject.add("test", message);

        contactRepository.save(contact);

        return jsonObject.toString();
    }
}
