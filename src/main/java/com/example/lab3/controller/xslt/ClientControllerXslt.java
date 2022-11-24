package com.example.lab3.controller.xslt;

import com.example.lab3.model.Client;
import com.example.lab3.repository.ClientRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.util.List;


@Controller
@RequestMapping("/xslt/clients")
public class ClientControllerXslt {

    final ClientRepository clientRepository;

    public ClientControllerXslt(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public ModelAndView get() throws JsonProcessingException {
        List<Client> clients = clientRepository.findAll();

        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(clients);

        Source source = new StreamSource(new ByteArrayInputStream(xml.getBytes()));
        ModelAndView modelAndView = new ModelAndView("clients");
        modelAndView.addObject("xmlSource", source);

        return modelAndView;
    }
}