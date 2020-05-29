package com.ciphersnippet.springbootswagger2;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/api")
public class AddressBookResource {

    ConcurrentMap<String, Contact> contacts = new ConcurrentHashMap<>();

    @ApiOperation(value = "Finds Contacts by Id",
            notes = "Provide an id to look up specific contact from the address book",
            response = Contact.class)

    @GetMapping("/{id}")
    public Contact getContact(@ApiParam(value = "Id value for the contact you need to retrieve", required = true)
                              @PathVariable String id) {

        return contacts.get(id);
    }

    @GetMapping("/")
    public List<Contact> getContacts() {

        return new ArrayList<Contact>(contacts.values());
    }

    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact) {
        contacts.put(contact.getId(), contact);
        return contact;
    }


}
