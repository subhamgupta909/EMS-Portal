package com.ems.util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class EmployeeIDGenerator implements IdentifierGenerator {

    private static final String PREFIX = "JTC-";
    private static final String ID_FORMAT = "%03d";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) {
        String sql = "SELECT emp_id FROM employee ORDER BY emp_id DESC LIMIT 1";

        String lastId = (String) session.createNativeQuery(sql).uniqueResult();
        int nextId = 1;

        if (lastId != null && lastId.startsWith(PREFIX)) {
            String numberPart = lastId.substring(PREFIX.length());
            try {
                nextId = Integer.parseInt(numberPart) + 1;
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid employee ID format in DB: " + lastId);
            }
        }

        return PREFIX + String.format(ID_FORMAT, nextId);
    }
}
