package com.aoher.service;

import org.junit.platform.commons.util.StringUtils;

public class TranslatorEngine {

    public String translate(String text) {

        if (StringUtils.isBlank(text)) {
            throw new IllegalArgumentException("Translated text must not be empty.");
        }

        switch (text.toLowerCase()) {
            case "hello": return "Bonjour";
            case "yes": return "Oui";
            case "no": return "Non";
            case "goodbye": return "Au revoir";
            case "good night": return "Bonne nuit";
            case "thank you": return "Merci";
            default: return "Not found";
        }
    }
}
