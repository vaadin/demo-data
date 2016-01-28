package com.vaadin.demodata;


import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Languages {

    private List<String> languages = Arrays.asList(
            "Afrikaans",
            "Albanian",
            "Amharic",
            "Arabic",
            "Armenian",
            "Basque",
            "Bengali",
            "Byelorussian",
            "Burmese",
            "Bulgarian",
            "Catalan",
            "Czech",
            "Chinese",
            "Croatian",
            "Danish",
            "Dari",
            "Dzongkha",
            "Dutch",
            "English",
            "Esperanto",
            "Estonian",
            "Faroese",
            "Farsi",
            "Finnish",
            "French",
            "Gaelic",
            "Galician",
            "German",
            "Greek",
            "Hebrew",
            "Hindi",
            "Hungarian",
            "Icelandic",
            "Indonesian",
            "Inuktitut (Eskimo)",
            "Italian",
            "Japanese",
            "Khmer",
            "Korean",
            "Kurdish",
            "Laotian",
            "Latvian",
            "Lappish",
            "Lithuanian",
            "Macedonian",
            "Malay",
            "Maltese",
            "Nepali",
            "Norwegian",
            "Pashto",
            "Polish",
            "Portuguese",
            "Romanian",
            "Russian",
            "Scots",
            "Serbian",
            "Slovak",
            "Slovenian",
            "Somali",
            "Spanish",
            "Swedish",
            "Swahili",
            "Tagalog-Filipino",
            "Tajik",
            "Tamil",
            "Thai",
            "Tibetan",
            "Tigrinya",
            "Tongan",
            "Turkish",
            "Turkmen",
            "Ucrainian",
            "Urdu",
            "Uzbek",
            "Vietnamese",
            "Welsh"
    );

    public List<String> getLanguages() {
        return languages;
    }
}
