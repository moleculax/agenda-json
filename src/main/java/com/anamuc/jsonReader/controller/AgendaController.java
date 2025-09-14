package com.anamuc.jsonReader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AgendaController {

    private final File archivo = new File("usuario.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private ArrayNode agenda;

    public AgendaController() {
        try {
            if (archivo.exists()) {
                JsonNode raiz = mapper.readTree(archivo);
                agenda = raiz.isArray() ? (ArrayNode) raiz : mapper.createArrayNode().add(raiz);
            } else {
                agenda = mapper.createArrayNode();
            }
        } catch (IOException e) {
            agenda = mapper.createArrayNode();
        }
    }

    @GetMapping("/")
    public String index(Model model) {
        // Convertir ObjectNode a Map para Thymeleaf
        List<Map<String, Object>> usuarios = new ArrayList<>();
        for (JsonNode nodo : agenda) {
            usuarios.add(mapper.convertValue(nodo, Map.class));
        }
        model.addAttribute("usuarios", usuarios);
        return "index";
    }

    @PostMapping("/agregar")
    public String agregar(@RequestParam String nombre,
                          @RequestParam String rol,
                          @RequestParam String pais,
                          @RequestParam String estado,
                          @RequestParam String email,
                          @RequestParam int anioIngreso,
                          @RequestParam String experiencia) {
        ObjectNode nuevo = mapper.createObjectNode();
        nuevo.put("nombre", nombre);
        nuevo.put("rol", rol);
        nuevo.put("pais", pais);
        nuevo.put("estado", estado);
        nuevo.put("email", email);
        nuevo.put("anioIngreso", anioIngreso);
        nuevo.put("experiencia", experiencia);

        agenda.add(nuevo);
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, agenda);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }
}
