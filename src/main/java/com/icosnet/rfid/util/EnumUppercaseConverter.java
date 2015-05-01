package com.icosnet.rfid.util;

import javax.persistence.AttributeConverter;
import java.util.EnumSet;

/**
 * Created by xirconias on 01/05/15.
 */
public abstract class EnumUppercaseConverter <E extends Enum<E>>  implements AttributeConverter<E, String> {

    private Class<E> enumClass;

    public EnumUppercaseConverter(Class<E> enumClass) {
        this.enumClass = enumClass;
    }

    @Override
    public String convertToDatabaseColumn(E e) {
        return e.name().toString();
    }

    @Override
    public E convertToEntityAttribute(String s) {
        for(E en: EnumSet.allOf(enumClass)){
            if(en.name().equalsIgnoreCase(s)){
                return en;
            }
        }
        return null;
    }

}