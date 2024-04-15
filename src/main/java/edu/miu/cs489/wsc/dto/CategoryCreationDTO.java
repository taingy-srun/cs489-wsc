package edu.miu.cs489.wsc.dto;

import edu.miu.cs489.wsc.model.Category;

public record CategoryCreationDTO(String name) {

    public Category toCategory() {
        return new Category(null, name);
    }
}
