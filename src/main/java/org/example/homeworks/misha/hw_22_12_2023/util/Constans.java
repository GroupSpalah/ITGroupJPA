package org.example.homeworks.misha.hw_22_12_2023.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Constans {
    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("misha");
}
