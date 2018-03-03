package uk.co.mruoc.dto.plugin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class StubbedTypeProvider implements TypeProvider {
    
    @Override
    public Collection<Class<?>> getTypes() {
        Collection<Class<?>> types = new ArrayList<>();

        types.add(String.class);

        types.add(int.class);
        types.add(byte.class);
        types.add(short.class);
        types.add(long.class);
        types.add(float.class);
        types.add(double.class);
        types.add(boolean.class);
        types.add(char.class);

        types.add(BigDecimal.class);
        types.add(Byte.class);
        types.add(Short.class);
        types.add(Integer.class);
        types.add(Long.class);
        types.add(Float.class);
        types.add(Double.class);
        types.add(Boolean.class);
        types.add(Character.class);
        types.add(Date.class);
        types.add(Object.class);

        return types;
    }
    
}
