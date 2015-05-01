package com.icosnet.rfid.util;

/**
 * Created by xirconias on 01/05/15.
 */
public enum MagasinType {
    PRINCIPAL {
        @Override
        public String toString() {
            return "Principale".toUpperCase();
        }
    },
    SECONDARY {
        @Override
        public String toString() {
            return "Secondaire".toUpperCase();
        }
    },
    MOBILE {
        @Override
        public String toString() {
            return "Mobile".toUpperCase();
        }
    };
    public abstract String toString();
}