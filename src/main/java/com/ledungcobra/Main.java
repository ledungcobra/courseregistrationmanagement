package com.ledungcobra;

import com.ledungcobra.entites.Student;
import com.ledungcobra.scenes.Home;
import com.ledungcobra.utils.Constants;
import com.ledungcobra.utils.HibernateUtils;
import lombok.val;

import javax.swing.*;
import java.sql.SQLException;

import static com.ledungcobra.utils.Constants.SEMESTER_CHECK_CONSTRAINT_SEMESTER_NAME;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
        HibernateUtils.getCurrentSession();
    }
}
