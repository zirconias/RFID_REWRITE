package com.icosnet.rfid.util;

import javax.persistence.AttributeConverter;

/**
 * Created by xirconias on 01/05/15.
 */
public class MagasinConverter  extends EnumUppercaseConverter<MagasinType>
    implements AttributeConverter<MagasinType,String>{
    public MagasinConverter(){
        super(MagasinType.class);
    }
}
