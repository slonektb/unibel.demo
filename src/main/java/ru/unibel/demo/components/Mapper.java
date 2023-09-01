package ru.unibel.demo.components;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public <T> T convet (Object obj, Class<T> classObj2) {
        ModelMapper modelMapper = new ModelMapper();
        return (T) modelMapper.map(obj, classObj2);
    }
}
