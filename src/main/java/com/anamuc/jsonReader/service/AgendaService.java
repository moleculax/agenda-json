package com.anamuc.jsonReader.service;

import com.anamuc.jsonReader.model.Usuario;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgendaService {

    private final String archivoPath = "usuario.json";
    private final ObjectMapper mapper = new ObjectMapper();

    private ArrayNode leerArrayNode() throws IOException {
        File archivo = new File(archivoPath);
        if (!archivo.exists()) return mapper.createArrayNode();

        JsonNode raiz = mapper.readTree(archivo);
        if (raiz.isArray()) return (ArrayNode) raiz;
        if (raiz.isObject()) {
            ArrayNode array = mapper.createArrayNode();
            array.add(raiz);
            return array;
        }
        return mapper.createArrayNode();
    }

    public List<Usuario> getUsuarios() throws IOException {
        ArrayNode array = leerArrayNode();
        List<Usuario> lista = new ArrayList<>();
        for (JsonNode node : array) lista.add(mapper.treeToValue(node, Usuario.class));
        return lista;
    }

    public void agregarUsuario(Usuario usuario) throws IOException {
        ArrayNode array = leerArrayNode();
        array.add(mapper.valueToTree(usuario));
        guardarArray(array);
    }

    public void modificarUsuario(String id, Usuario usuarioModificado) throws IOException {
        ArrayNode array = leerArrayNode();
        for (int i = 0; i < array.size(); i++) {
            ObjectNode node = (ObjectNode) array.get(i);
            if (node.get("id").asText().equals(id)) {
                usuarioModificado.setId(id);
                array.set(i, mapper.valueToTree(usuarioModificado));
                break;
            }
        }
        guardarArray(array);
    }

    public void eliminarUsuario(String id) throws IOException {
        ArrayNode array = leerArrayNode();
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).get("id").asText().equals(id)) {
                array.remove(i);
                break;
            }
        }
        guardarArray(array);
    }

    private void guardarArray(ArrayNode array) throws IOException {
        File archivo = new File(archivoPath);
        mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, array);
    }

    public Usuario buscarUsuario(String id) throws IOException {
        ArrayNode array = leerArrayNode();
        for (JsonNode node : array) {
            if (node.get("id").asText().equals(id))
                return mapper.treeToValue(node, Usuario.class);
        }
        return null;
    }

    public List<Usuario> buscarUsuarios(String nombre, String rol) throws IOException {
        List<Usuario> lista = getUsuarios();
        List<Usuario> resultado = new ArrayList<>();
        for (Usuario u : lista) {
            boolean coincNombre = (nombre == null || nombre.isEmpty()) || u.getNombre().toLowerCase().contains(nombre.toLowerCase());
            boolean coincRol = (rol == null || rol.isEmpty()) || u.getRol().toLowerCase().contains(rol.toLowerCase());
            if (coincNombre && coincRol) resultado.add(u);
        }
        return resultado;
    }
}
