package amandaalouise.common.utils;

import org.modelmapper.ModelMapper;
import common.src.main.java.amandaalouise.common.utils.SpringContext;

/**
 * MapperUtils
 */
public final class MapperUtil {

    public static <T> T Convert(Object source, Class<T> destinationType) {
        ModelMapper modelMapper = SpringContext.getBean(ModelMapper.class);
        return modelMapper.map(source, destinationType);
    }
}