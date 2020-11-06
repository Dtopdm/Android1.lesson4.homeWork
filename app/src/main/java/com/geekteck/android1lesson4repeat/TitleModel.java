package com.geekteck.android1lesson4repeat;

import java.io.Serializable;

public class TitleModel implements Serializable {
    private String text;
    private String description;

    public TitleModel(String text, String description) {
        this.text = text;
        this.description = description;
    }

    public String getText() { return text;
    }

    public String getDescription() { return description;
    }
}
