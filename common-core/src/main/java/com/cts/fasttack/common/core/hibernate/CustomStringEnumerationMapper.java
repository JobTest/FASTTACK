package com.cts.fasttack.common.core.hibernate;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

public abstract class CustomStringEnumerationMapper<ENUMERATION extends Enum<?> & CustomStringEnumeration> implements UserType {

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.VARCHAR};
    }

    @Override
    public abstract Class<ENUMERATION> returnedClass();

    @Override
    public boolean equals(Object o1, Object o2) throws HibernateException {
        return o1 == o2 || o1 != null && o2 != null && o1.equals(o2);
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        return o == null ? 0 : o.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] names, SessionImplementor sessionImplementor, Object o) throws HibernateException, SQLException {
        String dbValue = resultSet.getString(names[0]);
        if (resultSet.wasNull()) {
            return null;
        }
        for (CustomStringEnumeration value : returnedClass().getEnumConstants()) {
            if (value.getDataBaseValue().equals(dbValue)) {
                return value;
            }
        }
        throw new IllegalStateException("Unknown " + returnedClass().getSimpleName() + " id");
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, SessionImplementor sessionImplementor) throws HibernateException, SQLException {
        if (o == null) {
            preparedStatement.setNull(i, Types.VARCHAR);
        } else {
            preparedStatement.setString(i, ((CustomStringEnumeration) o).getDataBaseValue());
        }
    }

    @Override
    public Object deepCopy(Object o) throws HibernateException {
        return o;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        return (Serializable) o;
    }

    @Override
    public Object assemble(Serializable serializable, Object o) throws HibernateException {
        return serializable;
    }

    @Override
    public Object replace(Object o, Object o2, Object o3) throws HibernateException {
        return o;
    }
}
