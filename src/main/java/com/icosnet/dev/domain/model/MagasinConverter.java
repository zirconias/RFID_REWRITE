package com.icosnet.dev.domain.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by xirconias on 01/05/15.
 */
/*
@Converter(autoApply = true)
public class MagasinConverter  extends EnumUppercaseConverter<MagasinType>
    implements AttributeConverter<MagasinType,String>{
    public MagasinConverter(){
        super(MagasinType.class);
    }
}*/
@Converter(autoApply = true)
public class MagasinConverter implements AttributeConverter<MagasinType,String>{

    @Override
    public String convertToDatabaseColumn(MagasinType magasinType) {
        switch (magasinType){
            case MOBILE:return "MOBILE";
            case PRINCIPAL:return "PRINCIPAL";
            case SECONDARY:return "SECONDARY";
            default:throw new IllegalArgumentException("valeur incorrecte" + magasinType);
        }
    }

    @Override
    public MagasinType convertToEntityAttribute(String s) {
        switch (s){
            case "MOBILE": return MagasinType.MOBILE;
            case "SECONDARY": return MagasinType.SECONDARY;
            case "PRINCIPAL": return MagasinType.PRINCIPAL;
            default:throw new IllegalArgumentException("valeur incorrecte" + s);
        }
    }
}