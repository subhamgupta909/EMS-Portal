package com.ems.util;

import java.io.Serializable;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ClientIDGenerator implements IdentifierGenerator {
    private static final String PREFIX = "Client-";
    private static final String ID_FORMAT = "%03d";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) {
        String sql = "SELECT client_id FROM client ORDER BY client_id DESC LIMIT 1";

        String lastId = (String) session.createNativeQuery(sql).uniqueResult();
        int nextId = 1;

        if (lastId != null && lastId.startsWith(PREFIX)) {
            String numberPart = lastId.substring(PREFIX.length());
            try {
                nextId = Integer.parseInt(numberPart) + 1;
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid client ID format in DB: " + lastId);
            }
        }

        return PREFIX + String.format(ID_FORMAT, nextId);
    }

}
