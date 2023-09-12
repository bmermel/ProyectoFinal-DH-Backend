package com.digitalhouse.proyectoFinal.Entity;

import com.digitalhouse.proyectoFinal.Emuns.NombreRol;
import jakarta.persistence.*;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class Rol {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private NombreRol rol;

    public Rol() {
    }

    public Rol(@NotNull NombreRol rol) {
        this.rol = rol;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NombreRol getRol() {
        return rol;
    }

    public void setRol(NombreRol rol) {
        this.rol = rol;
    }
}