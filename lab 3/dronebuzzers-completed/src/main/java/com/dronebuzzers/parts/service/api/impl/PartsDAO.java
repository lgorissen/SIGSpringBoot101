package com.dronebuzzers.parts.service.api.impl;

import java.util.List;

public interface PartsDAO {
    public List<com.dronebuzzers.parts.service.api.impl.Part> getAllParts();
    public com.dronebuzzers.parts.service.api.impl.Part getPart(String id);
    public List<com.dronebuzzers.parts.service.api.impl.Part> getPartsByType(String type);
    public List<com.dronebuzzers.parts.service.api.impl.Part> getPartsByCategory(String category);
    public double getAmount(String id, int count);
}