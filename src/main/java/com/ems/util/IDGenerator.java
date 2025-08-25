package com.ems.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.query.Query;

import com.ems.entity.Role;
import com.ems.entity.User;
import com.ems.entity.Project;

public class IDGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

        String prefix = "";
        String hql = "";
        String idColumn = "";
        int nextId = 1;

        if (object instanceof User) {
            User user = (User) object;

            if (user.getRole() == Role.ROLE_EMPLOYEE) {
                prefix = "JTC-";
            } else if (user.getRole() == Role.ROLE_CLIENT) {
                prefix = "Client-";
            } else if (user.getRole() == Role.ROLE_ADMIN) {
                prefix = "Admin-";
            } else {
                prefix = "USR-";
            }

            hql = "SELECT u.userId FROM User u WHERE u.role = :role ORDER BY u.userId DESC";
            Query<String> query = session.createQuery(hql, String.class);
            query.setParameter("role", user.getRole());
            query.setMaxResults(1);

            List<String> list = query.list();
            if (!list.isEmpty()) {
                String lastId = list.get(0);
                String[] parts = lastId.split("-");
                try {
                    nextId = Integer.parseInt(parts[1]) + 1;
                } catch (Exception e) {
                    nextId = 1;
                }
            }

        } else if (object instanceof Project) {
            prefix = "Project-";

            hql = "SELECT p.projectId FROM Project p ORDER BY p.projectId DESC";
            Query<String> query = session.createQuery(hql, String.class);
            query.setMaxResults(1);

            List<String> list = query.list();
            if (!list.isEmpty()) {
                String lastId = list.get(0);
                String[] parts = lastId.split("-");
                try {
                    nextId = Integer.parseInt(parts[1]) + 1;
                } catch (Exception e) {
                    nextId = 1;
                }
            }
        }

        return prefix + String.format("%03d", nextId);
    }
}
