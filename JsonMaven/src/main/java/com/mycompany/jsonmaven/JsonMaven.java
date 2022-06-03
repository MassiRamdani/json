/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.jsonmaven;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JsonMaven {

    public static void main(String[] args) throws Exception {

        String file = "src/fichier.json";
        String json = new String(Files.readAllBytes(Paths.get(file)));
        
        ObjectMapper mapper = new ObjectMapper();
        //instance de class jsonmaven
        JsonMaven jsonMaven = new JsonMaven();
        
        //recuperer la liste des cles uic
        List<String> listeUic = jsonMaven.getList(json, mapper);
        
        //verfier la validité des cles uic
        if (jsonMaven.verfierUic(listeUic)) {
            System.out.println("Les fichier est valide ");

        } else {
            System.out.println("Les fichier n'est pas valide ");

        }

    }
//finction pour parcourir la liste des "uic" et verifier la validite des integer

    public boolean verfierUic(List<String> listeUic) {
        for (String str : listeUic) {
            if (!str.matches("[0-9]{8}")) {
                return false;
            }
        }
        return true;

    }
//récupérer la liste des cles "uic" dans le fichier json

    public List<String> getList(String json, ObjectMapper mapper) throws JsonMappingException, JsonProcessingException {

        List<String> keys = new ArrayList<>();
        JsonNode jsonNode = mapper.readTree(json);
        getKey(jsonNode, keys);
        return keys;
    }
//fonction recursive pour parcourir les objet et tableau imbriqué

    public void getKey(JsonNode jsonNode, List<String> keys) {

        if (jsonNode.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
            fields.forEachRemaining(field -> {
                if ("uic".equals(field.getKey())) {
                    keys.add(field.getValue().asText());
                }

                getKey((JsonNode) field.getValue(), keys);
            });
        } else if (jsonNode.isArray()) {
            ArrayNode arrayField = (ArrayNode) jsonNode;
            arrayField.forEach(node -> {
                getKey(node, keys);
            });
        }
    }

}
