package com.project.studentmanagement.Util;

import org.hibernate.Session;

public class SessionDalUtil {
    public static Session clearSession(Session session) {
        session.clear();
        return session;
    }
}
